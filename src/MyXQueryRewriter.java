import org.antlr.v4.runtime.misc.Pair;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.util.*;

public class MyXQueryRewriter extends XQueryBaseVisitor<Object> {

    private HashMap<String, List<String>> tree = new HashMap<>(); // parent -> child
    private HashMap<String, String> tableIDMap = new HashMap<>(); // var -> tableID
    private List<String> rootVarList = new ArrayList<>(); // store root variables for each tree
    private HashMap<String, HashMap<String, String>> resCodeMap = new HashMap<>(); // tableID -> code
    private HashMap<Pair<String, String>, List<Pair<String, String>>> equationsMap = new HashMap<>(); // (groupID, groupID) -> (var, var)
    private String joinShapeFlag = "B"; // "L"
    private int tableAmt = 0;

    public void setJoinShapeFlag(String joinShapeFlag) {
        Set<String> joinShapeFlagSet = new HashSet<>(Arrays.asList("B", "L", "b", "l"));
        if (joinShapeFlagSet.contains(joinShapeFlag))
            this.joinShapeFlag = joinShapeFlag;
    }

    @Override
    public Object visitXq_ap(XQueryParser.Xq_apContext ctx) {
        return this.visit(ctx.ap());
    }

    @Override
    public Object visitAp_slash(XQueryParser.Ap_slashContext ctx) {
        this.visit(ctx.rp());
        return null;
    }

    @Override
    public Object visitAp_double_slash(XQueryParser.Ap_double_slashContext ctx) {
        this.visit(ctx.rp());
        return null;
    }

    @Override
    public Object visitXq_double_slash_rp(XQueryParser.Xq_double_slash_rpContext ctx) {
        this.visit(ctx.rp());
        return ctx.xq().getText();
    }

    @Override
    public Object visitXq_slash_rp(XQueryParser.Xq_slash_rpContext ctx) {
        this.visit(ctx.rp());
        return ctx.xq().getText();
    }

    @Override
    public Object visitRp_slash(XQueryParser.Rp_slashContext ctx) { // TO BE REFACTORED
        this.visit(ctx.rp(1));
        return null;
    }

    @Override
    public Object visitRp_double_slash(XQueryParser.Rp_double_slashContext ctx) {
        this.visit(ctx.rp(1));
        return null;
    }

    String tmpVarName; //used for visitRp_text
    HashSet<String> textVarSet = new HashSet<>();

    @Override
    public Object visitRp_text(XQueryParser.Rp_textContext ctx) {
        textVarSet.add(tmpVarName);
        return null;
    }


    String getNewTableID(String leftTableID, String rightTableID) {
        String[] leftTableIDArr = leftTableID.split(",");
        String[] rightTableIDArr = rightTableID.split(",");
        String res = "";
        int pointer1 = 0, pointer2 = 0;
        int leftLen = leftTableIDArr.length;
        int rightLen = rightTableIDArr.length;

        while (pointer1 < leftLen || pointer2 < rightLen) {
            if (pointer2 >= rightLen || pointer1 < leftLen &&
                    Integer.parseInt(leftTableIDArr[pointer1]) <= Integer.parseInt(rightTableIDArr[pointer2])) {
                res += "," + leftTableIDArr[pointer1];
                pointer1++;
            } else {
                res += "," + rightTableIDArr[pointer2];
                pointer2++;
            }
        }
        return res.substring(1);
    }

    @Override
    public Object visitXq_FLWR(XQueryParser.Xq_FLWRContext ctx) {
        this.visit(ctx.forClause());
        if (ctx.whereClause() != null) this.visit(ctx.whereClause());

        //join
        //0. deal with equations within one component and contains constant string // TODO: how to deal with (-1,-1)
        //1. traverse all key in equationsMap
        //2. every time join two group, delete the key and merge related keys
        //3. loop until all the key are deleted

        Set keySet = equationsMap.keySet();
        Set<Pair> tmpKeySet = new HashSet(keySet);
        //0. deal with equations that contain constant string or within one component
        for (Pair k : tmpKeySet) {
            if (k.a.toString().equals("-1") || k.a.toString().equals(k.b.toString())) {
                int tableID = Integer.parseInt(k.b.toString());
                HashMap<String, String> tmpResCodeMap = resCodeMap.get(tableID + "");
                List<Pair<String, String>> tmpEquations = equationsMap.get(k);
                if (!tmpResCodeMap.containsKey("where"))
                    tmpResCodeMap.put("where", "");
                for (Pair<String, String> equation : tmpEquations) {
                    tmpResCodeMap.put("where", tmpResCodeMap.get("where") + " and " + equation.a + " eq " + equation.b);//note ','
                }
                if (tmpResCodeMap.get("where").startsWith(" and"))
                    tmpResCodeMap.put("where", tmpResCodeMap.get("where").substring(4));//delete the first ' and'
                keySet.remove(k);
            }
        }

        int loopCount = 0;
        List<Pair<String, String>> joinSeq = null;
        if (joinShapeFlag.equals("B")) joinSeq = generateBushyTree();
        while (!keySet.isEmpty()) {//one join each loop
            //1. 2. 3.
//            Iterator it = keySet.iterator();
//            Pair tableIDPair = (Pair) it.next();

            // find the first pair to join
            //Pair tableIDPair = findPairToJoin(keySet);
            Pair tableIDPair = null;
            if (joinShapeFlag.equals("B")) tableIDPair = findPairToJoin_B(joinSeq, loopCount);
            else tableIDPair = findPairToJoin_L(keySet);

            String leftTableID = (String) tableIDPair.a;
            String rightTableID = (String) tableIDPair.b;
            //String newTableID = leftTableID + "," + rightTableID;
            String newTableID = getNewTableID(leftTableID, rightTableID);

            //modify variable groupID for each var (traverse all     variable)
            tableIDMap.forEach((k, v) -> {
                if (v.equals(leftTableID) || v.equals(rightTableID)) {
                    tableIDMap.put(k, newTableID);
                }
            });

            // 2. merge the code
            mergeCode(tableIDPair, newTableID);

            // 2. merge the related keys
            keySet.remove(tableIDPair);
            tmpKeySet = new HashSet(keySet);
            for (Pair k : tmpKeySet) {
                boolean tobeMerge = false;
                boolean tobereversed = false;
                Pair<String, String> newPair = null;
                if (k.a.equals(leftTableID) || k.a.equals(rightTableID)) {
                    tobeMerge = true;
                    //newPair = newTableID.compareTo((String) k.b) < 0 ? new Pair<>(newTableID, (String) k.b) : new Pair<>((String) k.b, newTableID);

                    //if (newTableID.compareTo((String) k.b) < 0){
                    if (newTableID.split(",").length >= k.b.toString().split(",").length) {
                        newPair = new Pair<>(newTableID, (String) k.b);
                    } else {
                        newPair = new Pair<>((String) k.b, newTableID);
                        //reverse the equation
                        tobereversed = true;
                    }
                } else if (k.b.equals(leftTableID) || k.b.equals(rightTableID)) {
                    tobeMerge = true;

//                    newPair = newTableID.compareTo((String) k.a) < 0 ?
//                            new Pair<>(newTableID, (String) k.a) : new Pair<>((String) k.a, newTableID);
                    //if (newTableID.compareTo((String) k.a) < 0){
                    if (newTableID.split(",").length >= k.a.toString().split(",").length) {
                        newPair = new Pair<>(newTableID, (String) k.a);
                        //reverse the equation
                        tobereversed = true;
                    } else {
                        newPair = new Pair<>((String) k.a, newTableID);
                    }
                }
                if (tobeMerge) {
                    List<Pair<String, String>> tmpEquations = new ArrayList<>();
                    if (tobereversed) {
                        for (Pair p : equationsMap.get(k)) {
                            tmpEquations.add(new Pair<>((String) p.b, (String) p.a));
                        }
                    } else tmpEquations = equationsMap.get(k);
                    if (!keySet.contains(newPair))
                        equationsMap.put(newPair, tmpEquations);
                    else {//concat two list
                        equationsMap.get(newPair).addAll(tmpEquations);
                    }
                    keySet.remove(k);
                }
            }
            loopCount++;

        }
        //formulate the output (traverse resCodeMap keySet)
        String res = formOutput();

        //return clause
        String returnClause = (String) this.visitReturnClause(ctx.returnClause());

        return res + "\nreturn " + returnClause;
    }


    private Pair<String, String> findPairToJoin(Set keySet) {
        Pair<String, String> tableIDPair = null;
        //Iterator it = keySet.iterator();
        //Pair tableIDPair = (Pair) it.next();
        int maxTableNum = 0;
        int minTableNum = Integer.MAX_VALUE;
        int globalTableNum = joinShapeFlag.equals("B") ? Integer.MAX_VALUE : 0;
        for (Object obj : keySet) {
            Pair<String, String> tmpTableIDpair = (Pair) obj;
            int tableNum = tmpTableIDpair.a.split(",").length + tmpTableIDpair.b.split(",").length;

            if (joinShapeFlag.equals("B") && tableNum < globalTableNum ||
                    joinShapeFlag.equals("L") && tableNum > globalTableNum) {
                globalTableNum = tableNum;
                tableIDPair = tmpTableIDpair;

            }
//            if (joinShapeFlag.equals("B")){
//                if (tableNum < minTableNum){
//                    minTableNum = tableNum;
//                    tableIDPair = tmpTableIDpair;
//                }
//            }
//            else{//left join
//                if (tableNum > maxTableNum){
//                    maxTableNum = tableNum;
//                    tableIDPair = tmpTableIDpair;
//                }
//            }
        }
        return tableIDPair;
    }

    private Pair<String, String> findPairToJoin_L(Set keySet) {
        Pair<String, String> tableIDPair = null;
        int globalTableNum = Integer.MAX_VALUE;
        for (Object obj : keySet) {
            Pair<String, String> tmpTableIDpair = (Pair) obj;
            int tableNum = tmpTableIDpair.a.split(",").length + tmpTableIDpair.b.split(",").length;

            if (tableNum < globalTableNum) {
                globalTableNum = tableNum;
                tableIDPair = tmpTableIDpair;
            }
        }
        return tableIDPair;
    }

    private Pair<String, String> findPairToJoin_B(List<Pair<String, String>> joinSeq, int loopCount) {
        return joinSeq.get(loopCount);
    }

    private List<Pair<String, String>> generateBushyTree() {
        int dpLength = (int) Math.pow(2, tableAmt);
        int dp_treeHeight[] = new int[dpLength];
        Pair<Integer, Integer>[] dp_indexPair = new Pair[dpLength];

        // init
        for (int i = 0; i < dpLength; ++i) {
            dp_treeHeight[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < tableAmt; ++i) {
            int dpInd = rank(new int[]{i});
            dp_indexPair[dpInd] = new Pair<>(i, i);
            dp_treeHeight[dpInd] = 0;
        }

        for (int i = 1; i < dpLength; ++i) {
            int[] subset = unrank(i);
            int combinationAmt = (int) Math.pow(2, subset.length);
            for (int j = 1; j < combinationAmt; ++j) {
                int[] subsetIndexArr1 = unrank(j);
                int[] subsetIndexArr2 = getComplement(j, subset.length);
                int[] subset1 = new int[subsetIndexArr1.length];
                int[] subset2 = new int[subsetIndexArr2.length];

                for (int k = 0; k < subsetIndexArr1.length; ++k) {
                    subset1[k] = subset[subsetIndexArr1[k]];
                }
                for (int k = 0; k < subsetIndexArr2.length; ++k) {
                    subset2[k] = subset[subsetIndexArr2[k]];
                }

                if (checkConnection(subset1, subset2)) {
                    int dpInd1 = rank(subset1);
                    int dpInd2 = rank(subset2);
                    if (dp_treeHeight[dpInd1] == Integer.MAX_VALUE || dp_treeHeight[dpInd2] == Integer.MAX_VALUE) continue;
                    int newHeight = Math.max(dp_treeHeight[dpInd1], dp_treeHeight[dpInd2]) + 1;
                    if (dp_treeHeight[i] > newHeight) {
                        dp_treeHeight[i] = newHeight;
                        dp_indexPair[i] = dpInd1<dpInd2? new Pair<>(dpInd1, dpInd2):new Pair<>(dpInd2,dpInd1);
                    }
                    //System.out.println("ok");
                }
                //System.out.println("ok");
            }
        }

        return createJoinSequence(dp_indexPair);
    }

    private boolean checkConnection(int[] subset1, int[] subset2) {
        Set keySet = equationsMap.keySet();
        for (int i = 0; i < subset1.length; ++i) {
            for (int j = 0; j < subset2.length; ++j) {
                //String key = "("+Math.min(subset1[i], subset2[j]) + "," + Math.max(subset1[i], subset2[j])+")";
                Pair<String,String> key = new Pair<>(Math.min(subset1[i], subset2[j])+"",Math.max(subset1[i], subset2[j])+"");
                if (keySet.contains(key)) return true;
            }
        }
        return false;
    }

    private int rank(int[] tableIdArr) {
        int rank = 0;
        for (int id : tableIdArr)
            rank += Math.pow(2, id);
        return rank;
    }

    private int[] unrank(int rank) {
        List<Integer> temp = new LinkedList<>();

        int i = 0;
        while (rank != 0) {
            if (rank % 2 == 1)
                temp.add(i);

            rank /= 2;
            i++;
        }
        int[] out = new int[temp.size()];
        Iterator<Integer> iter = temp.iterator();
        for (i = 0; i < temp.size(); i++)
            out[i] = iter.next();
        return out;
    }

    private int[] getComplement(int rank, int n) {
        return unrank((int) Math.pow(2, n) - 1 - rank);
    }


    // wrapper func for overloaded createJoinSequence
    private List<Pair<String, String>> createJoinSequence(Pair<Integer, Integer>[] dp) {
        List<Pair<String, String>> out = new LinkedList<Pair<String, String>>();
        this.createJoinSequence(dp, (int) Math.pow(2, this.tableAmt) - 1, out);
        return out;
    }

    // create an explicit join sequence ID-to-ID from the dp array
    private String createJoinSequence(Pair<Integer, Integer>[] dp, int index, List<Pair<String, String>> out) {
        // base case, primitive table
        if (dp[index].a.equals((dp[index].b)))
            return dp[index].a + ",";

        int left = dp[index].a;
        int right = dp[index].b;

        String leftString = createJoinSequence(dp, left, out), rightString = createJoinSequence(dp, right, out);
        out.add(new Pair<>(leftString.substring(0,leftString.length()-1), rightString.substring(0,rightString.length()-1)));

        return leftString + rightString;

    }


    //merge the code (join two groups)
    private void mergeCode(Pair tableIDPair, String newTableID) {
        String leftTableID = (String) tableIDPair.a;
        String rightTableID = (String) tableIDPair.b;
        List<Pair<String, String>> tmpEquations = equationsMap.get(tableIDPair);
        //contact first & second table
        concatCode(leftTableID);
        concatCode(rightTableID);
        //merge them and save to the new key
        HashMap<String, String> tmpRes = new HashMap<>();
        tmpRes.put("joinArg1", resCodeMap.get(leftTableID).get("res"));
        tmpRes.put("joinArg2", resCodeMap.get(rightTableID).get("res"));
        String joinArg3 = "[";
        String joinArg4 = "[";
        for (Pair equation : tmpEquations) {
            joinArg3 += equation.a.toString().substring(1) + ", ";
            joinArg4 += equation.b.toString().substring(1) + ", ";
        }
        joinArg3 = joinArg3.substring(0, joinArg3.length() - 2) + "]";
        joinArg4 = joinArg4.substring(0, joinArg4.length() - 2) + "]";
        tmpRes.put("joinArg3", joinArg3);
        tmpRes.put("joinArg4", joinArg4);

        resCodeMap.put(newTableID, tmpRes);
        resCodeMap.remove(leftTableID);
        resCodeMap.remove(rightTableID);
    }

    //before: codes saved as "for" -> "...", "where" -> "...",
    //In this function we concat these key-value pairs in each group
    //and save them as "res" -> result code string
    private String concatCode(String key) {
        HashMap<String, String> tmpResCode = resCodeMap.get(key);
        String res = "";
        //for the first type
        if (tmpResCode.containsKey("for")) {
            res = res + "for " + tmpResCode.get("for");
            if (tmpResCode.containsKey("where")) res = res + "\nwhere " + tmpResCode.get("where");
            res = res + "\nreturn <tuple>{ \n" + tmpResCode.get("return") + "\n }</tuple>";
        }
        //for the second type
        else {
            res = res + "join (\n";
            res = res + tmpResCode.get("joinArg1") + ",\n\n"
                    + tmpResCode.get("joinArg2") + ",\n\n"
                    + tmpResCode.get("joinArg3") + ", "
                    + tmpResCode.get("joinArg4");
            res = res + "\n)";
        }
        tmpResCode.put("res", res);
        return res;
    }

    // formulate the output (traverse rescodes keyset)
    // Note that we store count in resCodeMap
    private String formOutput() {
        String res = "for ";
        int count = 0;
        String where = "";
        for (String k : resCodeMap.keySet()) {
            HashMap tmpRes = resCodeMap.get(k);
            if (tmpRes.containsKey("joinArg1")) { //this group was joined before
                res = res + "$tuple" + count + " in " + concatCode(k) + ",\n";
                tmpRes.put("count", count + "");
                count++;
            } else {
                res = res + tmpRes.get("for") + ",\n";
                if (tmpRes.containsKey("where"))
                    where += tmpRes.get("where") + " and";
            }
        }
        if (!where.equals(""))
            res = res.substring(0, res.length() - 2) + "\nwhere" + where.substring(0, where.length() - 4) + ",\n";
        return res.substring(0, res.length() - 2);
    }

    @Override
    public Object visitReturnClause(XQueryParser.ReturnClauseContext ctx) {
        Set<Character> endOfVar = new HashSet<>(Arrays.asList('/', '<', ',', '}'));
        String text = ctx.xq().getText();
        String res = "";
        int startInd = 0;
        while (startInd < text.length() && text.indexOf('$', startInd) != -1) {
            int ind = text.indexOf('$', startInd);
            //modify result
            res += text.substring(startInd, ind);

            //locate the variable
            int i = ind;
            while (i < text.length() - 1 && !endOfVar.contains(text.charAt(++i))) {
                //i++;
            }
            String var = text.substring(ind, i);
            //update pointer
            startInd = i;
            //char c = text.charAt(i);

            //formulate the new variable
            if (!tableIDMap.containsKey(var)) {
                res += var;
                continue;// not existing variable
            }
            HashMap tmpResCode = resCodeMap.get(tableIDMap.get(var));
            String count = (String) tmpResCode.getOrDefault("count", "-1");
            if (count.equals("-1")) {
                res += var;
                continue; //this group didn't join
            }
            String newVar = textVarSet.contains(var) ?
                    "$tuple" + count + "/" + var.substring(1) + "/text()" :
                    "$tuple" + count + "/" + var.substring(1) + "/*";
            res += newVar;
        }
        res += text.substring(startInd);
        return res;
    }

    @Override
    public Object visitForClause(XQueryParser.ForClauseContext ctx) {
        int tableID = -1;
        for (int i = 0; i < ctx.var().size(); ++i) {
            String child = ctx.var(i).getText();
            tmpVarName = child;
            String parent = (String) this.visit(ctx.xq(i));
            String returnClause = "<" + child.substring(1)
                    + ">{" + child + "}</" + child.substring(1) + ">";
            String forClause = child + " in " + ctx.xq(i).getText();
            //if parent is root: tableID++
            if (parent != null) {  //parent is not root
                String tmpTableID = tableIDMap.get(parent);
                if (!tree.containsKey(parent)) tree.put(parent, new ArrayList<>());
                tree.get(parent).add(child); // TODO: deduplicate
                //add child to tableIDMap
                tableIDMap.put(child, tmpTableID);
                //update the corresponding code in resCodeList
                resCodeMap.get(tmpTableID + "").put("for",
                        resCodeMap.get(tmpTableID + "").get("for") + ",\n " + forClause);
                resCodeMap.get(tmpTableID + "").put("return",
                        resCodeMap.get(tmpTableID + "").get("return") + ",\n" + returnClause);
            } else {
                tableID++;
                //add node to rootVarList
                rootVarList.add(child);
                tableIDMap.put(child, tableID + "");
                tree.put(child, new ArrayList<>());
                //add a new string to result code list
                resCodeMap.put(tableID + "", new HashMap<>());
                resCodeMap.get(tableID + "").put("for", forClause);
                resCodeMap.get(tableID + "").put("return", returnClause);
            }
        }
        tableAmt = tableID + 1;
        return "ABC";
    }

    @Override
    public Object visitWhereClause(XQueryParser.WhereClauseContext ctx) {
        return this.visit(ctx.condition());
    }

    @Override
    public Object visitCond_eq(XQueryParser.Cond_eqContext ctx) {
        String leftVar = ctx.xq(0).getText();
        String rightVar = ctx.xq(1).getText();
        int leftTableID = Integer.parseInt(tableIDMap.getOrDefault(leftVar, "-1"));
        int rightTableID = Integer.parseInt(tableIDMap.getOrDefault(rightVar, "-1"));

        //put the smaller one in the front
        Pair<String, String> val = leftTableID < rightTableID ?
                new Pair<>(leftVar, rightVar) : new Pair<>(rightVar, leftVar);

        Pair<String, String> key = leftTableID < rightTableID ?
                new Pair<>(leftTableID + "", rightTableID + "") : new Pair<>(rightTableID + "", leftTableID + "");

        if (!equationsMap.containsKey(key)) equationsMap.put(key, new ArrayList<>());
        equationsMap.get(key).add(val);

        return "ABC";
    }

    @Override
    public Object visitCond_and(XQueryParser.Cond_andContext ctx) {
        this.visit(ctx.condition(0));
        this.visit(ctx.condition(1));
        return "ABC";
    }
}

