import org.antlr.v4.runtime.misc.Pair;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.util.*;

public class XQueryRewriter extends XQueryBaseVisitor<Object> {

    protected List<HashMap<String, List<Node>>> mem_stack = new ArrayList<>();
    private List<Node> yet_to_visit = new ArrayList<>(); // to store DOM nodes yet to visit

    private Document openInputFile(String filename) {
        try {
            // create DOM document parser and parse input file
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            filename = filename.replace("\"", "");
            File inputFile = new File(filename);
            Document doc = dBuilder.parse(inputFile);
            doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize(); // what does this do?
            return doc;
        } // end of try
        catch (Exception e) {
            System.out.println("File open error, exit.");
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }


    @Override
    public Object visitAp_slash(XQueryParser.Ap_slashContext ctx) {
        return null;
    }

//
//    /* filter methods */



    /* Milestone 2 functions */


    @Override
    //TODO: see if xq_slash only contains a situation "var/rp"
    public Object visitXq_double_slash_rp(XQueryParser.Xq_double_slash_rpContext ctx) {
        return ctx.xq().getText();
    }

    @Override
    //TODO: see if xq_slash only contains a situation "var/rp"
    public Object visitXq_slash_rp(XQueryParser.Xq_slash_rpContext ctx) {
        return ctx.xq().getText();
    }

    @Override
    public Object visitXq_ap(XQueryParser.Xq_apContext ctx) {
        return this.visit(ctx.ap());
    }


    private void popStackUntil(int until) {
        while (mem_stack.size() > until)
            mem_stack.remove(mem_stack.size() - 1);
    }

    private HashMap<String, List<String>> tree = new HashMap<>(); //parent -> child
    private HashMap<String, String> tableIDMap = new HashMap<>(); //var -> tableID
    private List<String> rootVarList = new ArrayList<>(); //store root variables for each tree
    private HashMap<String,HashMap<String,String>> resCodeMap = new HashMap<>(); //tableID -> code
    private HashMap<Pair<String, String>, List<Pair<String,String>>> equationsMap = new HashMap<>(); // (groupID, groupID) -> (var, var)

    @Override
    public Object visitXq_FLWR(XQueryParser.Xq_FLWRContext ctx) {
        this.visitForClause(ctx.forClause());
        this.visitWhereClause(ctx.whereClause());

        //join
        //0. deal with equations within one component and contains constant string //TODO: how to deal with (-1,-1)
        //1. traverse all key in equationsMap
        //2. every time join two group, delete the key and merge related keys
        //3. loop until all the key are deleted

        Set keySet = equationsMap.keySet();
        Set<Pair> tmpKeySet = new HashSet(keySet);
        //deal with equations that contain constant string
        for (Pair k : tmpKeySet){
            if (k.a.toString().equals("-1")){
                int tableID = Integer.parseInt(k.b.toString());
                HashMap<String,String> tmpResCodeMap = resCodeMap.get(tableID+"");
                if (!tmpResCodeMap.containsKey("where"))
                    tmpResCodeMap.put("where","\"" + k.a.toString() + "\" eq "+ k.b.toString());
                else tmpResCodeMap.put("where", tmpResCodeMap.get("where")+ ", \"" + k.a.toString() + "\" eq "+ k.b.toString());//note ','
                keySet.remove(k);
            }
        }
        //deal with equations within one component
        for (Pair k : tmpKeySet){
            if (k.a.toString().equals(k.b.toString())){
                int tableID = Integer.parseInt(k.b.toString());
                HashMap<String,String> tmpResCodeMap = resCodeMap.get(tableID+"");
                if (!tmpResCodeMap.containsKey("where"))
                    tmpResCodeMap.put("where",k.a.toString() + " eq "+ k.b.toString());
                else tmpResCodeMap.put("where", tmpResCodeMap.get("where")+ ", " + k.a.toString() + " eq "+ k.b.toString());//note ','
                keySet.remove(k);
            }
        }

        while (!keySet.isEmpty()){//one join each loop
            //1.
            Iterator it = keySet.iterator();
            Pair tableIDPair = (Pair) it.next();

            String leftTableID = (String) tableIDPair.a;
            String rightTableID = (String) tableIDPair.b;
            String newTableID = leftTableID + ","+rightTableID;

            //modify variable groupID (traverse all variable)
            tableIDMap.forEach((k,v) -> {
                if (v.equals(leftTableID) || v.equals(rightTableID)){
                    tableIDMap.put(k,newTableID);
                }
            });

            //merge the code
            mergeCode(tableIDPair, newTableID);

            //merge the related keys
            tmpKeySet = new HashSet(keySet);
            for (Pair k:tmpKeySet) {
                boolean tobeMerge = false;
                Pair<String, String> newPair = null;
                if (k.a.equals(leftTableID) || k.a.equals(rightTableID)) {
                    tobeMerge = true;
                    newPair = newTableID.compareTo((String) k.b) < 0 ?
                            new Pair<>(newTableID, (String) k.b) : new Pair<>((String) k.b, newTableID);
                } else if (k.b.equals(leftTableID) || k.b.equals(rightTableID)) {
                    tobeMerge = true;
                    newPair = newTableID.compareTo((String) k.a) < 0 ?
                            new Pair<>(newTableID, (String) k.a) : new Pair<>((String) k.a, newTableID);
                }
                if (tobeMerge) {
                    if (!keySet.contains(newPair))
                        equationsMap.put(newPair, equationsMap.get(k));
                    else {//concat two list
                        equationsMap.get(newPair).addAll(equationsMap.get(k));
                    }
                    keySet.remove(k);
                }
            }
            keySet.remove(tableIDPair);

        }
        //formulate the output (traverse rescodes keyset)
        String res = formOutput();

        //return clause
        String returnClause = (String) this.visitReturnClause(ctx.returnClause());

        System.out.println(res + "\n" + returnClause);
        return res + "\n" + returnClause;
    }

    //merge the code (join two groups)
    private Object mergeCode(Pair tableIDPair, String newTableID){
        String leftTableID = (String) tableIDPair.a;
        String rightTableID = (String) tableIDPair.b;
        List<Pair<String,String>> tmpEquations = equationsMap.get(tableIDPair);
        //contact first & second table
        concatCode(leftTableID);
        concatCode(rightTableID);
        //merge them and save to the new key
        HashMap<String, String> tmpRes = new HashMap<>();
        tmpRes.put("joinArg1",resCodeMap.get(leftTableID).get("res"));
        tmpRes.put("joinArg2",resCodeMap.get(rightTableID).get("res"));
        String joinArg3 = "[";
        String joinArg4 = "[";
        for (Pair equation : tmpEquations){
            joinArg3 += equation.a + ", ";
            joinArg4 += equation.b + ", ";
        }
        joinArg3 = joinArg3.substring(0,joinArg3.length()-2) + "]";
        joinArg4 = joinArg4.substring(0,joinArg4.length()-2) + "]";
        tmpRes.put("joinArg3",joinArg3);
        tmpRes.put("joinArg4",joinArg4);

        resCodeMap.put(newTableID,tmpRes);
        resCodeMap.remove(leftTableID);
        resCodeMap.remove(rightTableID);
        return "ABC";
    }

    //before: codes saved as "for" -> "...", "where" -> "...",
    //In this function we concat these key-value pairs in each group
    //and save them as "res" -> result code string
    private String concatCode(String key){
        HashMap<String, String> tmpResCode = resCodeMap.get(key);
        String res="";
        //for the first type
        if (tmpResCode.containsKey("for")){
            res = res + "for "+ tmpResCode.get("for");
            if (tmpResCode.containsKey("where")) res = res + "\nwhere "+ tmpResCode.get("where");
            res = res + "\nreturn <tuple> \n"+ tmpResCode.get("return") + "\n </tuple>";
        }
        //for the second type
        else{
            res = res + "join (";
            res = res + tmpResCode.containsKey("joinArg1") + ",\n\n"
                    +tmpResCode.containsKey("joinArg2") + ",\n\n"
                    +tmpResCode.containsKey("joinArg3") + ", "
                    +tmpResCode.containsKey("joinArg4") + ",\n\n";
            res = res + "\n)";
        }
        tmpResCode.put("res",res);
        return res;
    }

    //formulate the output (traverse rescodes keyset)
    //Note that we store count in resCodeMap
    private String formOutput(){
        String res="for ";
        int count=0;
        for (String k:resCodeMap.keySet()){
            HashMap tmpRes = resCodeMap.get(k);
            if (tmpRes.containsKey("joinArg1")){ //this group was joined before
                res = res + "$tuple" + count + " in " + concatCode(k) + ",\n";
                count++;
                tmpRes.put("count",count);
            }
            else{
                res = res + tmpRes.get("for") + ",\n";
            }
        }
        return res.substring(0,res.length()-2);
    }


    /* a wrapper class used for DFS */
    class NodeWithDepth {
        int depth;
        Node node;

        public NodeWithDepth(Node node, int depth) {
            this.depth = depth;
            this.node = node;
        }
    }

    @Override
    public Object visitReturnClause(XQueryParser.ReturnClauseContext ctx) {
        Set<Character> endOfVar = new HashSet<>(Arrays.asList('/','<', ','));
        String text = ctx.xq().getText();
        String res="";
        int startInd=0;
        while (text.indexOf('$',startInd) != -1){
            int ind  = text.indexOf('$',startInd);
            //modify result
            res += text.substring(startInd,ind);
            //update pointer
            startInd =  ind + 1;
            //locate the variable
            int i=ind+1;
            while (!endOfVar.contains(text.charAt(i))){
                i++;
            }
            String var = text.substring(ind,i);
            //formulate the new variable
            if (!tableIDMap.containsKey(var)) {
                res += var;
                continue;// not existing variable
            }
            HashMap tmpResCode = resCodeMap.get(tableIDMap.get(var));
            String count = (String) tmpResCode.getOrDefault("count","-1");
            if (count.equals("-1")) {
                res += var;
                continue; //this group didn't join
            }
            String newVar = "$tuple"+ count + "/"+ var.substring(1) + "/*";
            res += newVar;
        }
        return res;
    }

    @Override
    //TODO: initialize return clause
    public Object visitForClause(XQueryParser.ForClauseContext ctx) {
        int tableID = -1;
        for (int i=0; i<ctx.var().size(); ++i){
            String child = ctx.var(i).getText();
            String parent = (String) this.visit(ctx.xq(i));
            String returnClause = "<"+child.substring(1)
                    +">{"+child+"}</"+child.substring(1)+">";
            String forClause = child + " in " + ctx.xq(i).getText();
            //if parent is root: tableID++
            if (parent != null){  //parent is not root
                //add parent-child pair to tree
//                if (!tree.containsKey(parent)){ //parent must have appeared before
//                    tree.put(parent,new ArrayList<String>());
//                }
                String tmpTableID = tableIDMap.get(parent);
                tree.get(parent).add(child); //TODO: deduplicate
                //add child to tableIDMap
                tableIDMap.put(child,tmpTableID);
                //update the corresponding code in resCodeList
                resCodeMap.get(tmpTableID+"").put("for",
                        resCodeMap.get(tmpTableID+"").get("for") + ",\n " + forClause);
                resCodeMap.get(tmpTableID+"").put("return",
                        resCodeMap.get(tmpTableID+"").get("return") + ",\n" + returnClause);
            }
            else{
                tableID++;
                //add node to rootVarList
                rootVarList.add(child);
                tableIDMap.put(child,tableID+"");
                //add a new string to result code list
                resCodeMap.put(tableID+"", new HashMap<>());
                resCodeMap.get(tableID+"").put("for", forClause);
                resCodeMap.get(tableID+"").put("return", returnClause);

            }
        }

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
        //TODO: if constant string begin with $
        int leftTableID = Integer.parseInt(tableIDMap.getOrDefault(leftVar, "-1"));
        int rightTableID = Integer.parseInt(tableIDMap.getOrDefault(rightVar, "-1"));

        //put the smaller one in the front
        Pair<String, String> val= leftTableID < rightTableID?
                new Pair<>(leftVar, rightVar) : new Pair<>(rightVar, leftVar);

        Pair<String, String> key= leftTableID < rightTableID?
                new Pair<>(leftTableID+"", rightTableID+"") : new Pair<>(rightTableID+"", leftTableID+"");

        if (!equationsMap.containsKey(key)) equationsMap.put(key,new ArrayList<>());
        equationsMap.get(key).add(val);

        return "ABC";
    }



    @Override
    public Object visitXq_comma(XQueryParser.Xq_commaContext ctx) {
        List<Node> out = new ArrayList<>((List<Node>) this.visit(ctx.xq(0)));
        out.addAll((List<Node>) this.visit(ctx.xq(1)));
        return out;
    }


    @Override
    public Object visitCond_and(XQueryParser.Cond_andContext ctx) {
        this.visit(ctx.condition(0));
        this.visit(ctx.condition(1));
        return "ABC";
    }

}

