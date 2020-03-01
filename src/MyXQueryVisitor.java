import com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderImpl;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.lang.reflect.Array;
import java.util.*;

import org.w3c.dom.*;

import javax.xml.parsers.*;
import java.io.*;

public class MyXQueryVisitor extends XQueryBaseVisitor<Object> {

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
        String filename = ctx.filename().getText(); // find file path
        Document doc = openInputFile(filename); // open file
        yet_to_visit.add(doc);  // add the XML root
        return this.visit(ctx.rp());
    }

    @Override
    public Object visitAp_double_slash(XQueryParser.Ap_double_slashContext ctx) {
        String filename = ctx.filename().getText(); // find file path
        Document doc = openInputFile(filename); // open file
        List<Node> out = new ArrayList<Node>();
        NodeList nodeList = doc.getElementsByTagName("*");

        for (int i = -1; i < nodeList.getLength(); i++) {
            if (i < 0)
                yet_to_visit.add(doc);
            else
                yet_to_visit.add(nodeList.item(i));

            for (Node node : (List<Node>) this.visit(ctx.rp()))
                if (!out.contains(node))
                    out.add(node);
        }
        return out;
    }

    @Override
    public Object visitRp_tag(XQueryParser.Rp_tagContext ctx) {
        List<Node> out = new ArrayList<Node>();
        if (yet_to_visit.isEmpty())
            return out;

        NodeList nodeList = yet_to_visit.remove(0).getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                /* if current tag of the context node is equal to the current DOM node name */
                if (nodeList.item(i).getNodeName().equals(ctx.tagname().getText()))
                    out.add(nodeList.item(i));
            }
        }
        return out;
    }

    @Override
    public Object visitRp_parent(XQueryParser.Rp_parentContext ctx) {
        List<Node> out = new ArrayList<Node>();
        if (yet_to_visit.isEmpty())
            return out;
        if (yet_to_visit.get(0).getParentNode() == null) {
            yet_to_visit.remove(0);
            return out;
        }

        out.add(yet_to_visit.remove(0).getParentNode());
        return out;
    }

    @Override
    public Object visitRp_anyTag(XQueryParser.Rp_anyTagContext ctx) {
        List<Node> out = new ArrayList<Node>();
        if (yet_to_visit.isEmpty())
            return out;
        NodeList nodeList = yet_to_visit.remove(0).getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++)
            if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE)
                out.add(nodeList.item(i));
        return out;
    }

    @Override
    public Object visitRp_slash(XQueryParser.Rp_slashContext ctx) { // TO BE REFACTORED
        List<Node> out = new ArrayList<Node>();
        if (yet_to_visit.isEmpty())
            return out;

        for (Node node1 : deduplicate((List<Node>) this.visit(ctx.rp(0)))) {
            yet_to_visit.add(node1);
            for (Node node2 : (List<Node>) this.visit(ctx.rp(1)))
                if (!out.contains(node2))
                    out.add(node2);
        }
        return out;
    }

    private List<Node> findSelfOrDescendant(Node root) {
        /* For every node in nodeList, find self or descendent */
        List<Node> selfOrDescendent = new ArrayList<Node>();

        List<Node> queue = new ArrayList<Node>(); // for traversal
        queue.add(root);                // add root (the self node)
        while (!queue.isEmpty()) {      // bfs traversal of DOM tree
            Node node = queue.remove(0);
            selfOrDescendent.add(node);
            NodeList children = node.getChildNodes();
            /* add all ELEMENT children to temp */
            for (int i = 0; i < children.getLength(); i++)
                if (children.item(i).getNodeType() == Node.ELEMENT_NODE)
                    queue.add(children.item(i));
        }
        return selfOrDescendent;
    }

    private List<Node> evaluateForEach(List<Node> contextNodes, XQueryParser.RpContext ctx) {
        List<Node> out = new ArrayList<Node>();
        for (int i = 0; i < contextNodes.size(); i++) {
            yet_to_visit.add(contextNodes.get(i));
            for (Node node : (List<Node>) this.visit(ctx))
                if (!out.contains(node))
                    out.add(node);
        }
        return out;
    }

    @Override
    public Object visitRp_double_slash(XQueryParser.Rp_double_slashContext ctx) {
        List<Node> out = new ArrayList<>();
        for (Node node1 : deduplicate((List<Node>) this.visit(ctx.rp(0)))) { // for every node in nodeList, do double_slash
            for (Node node : evaluateForEach(findSelfOrDescendant(node1), ctx.rp(1)))
                if (!out.contains(node))
                    out.add(node);
        }
        return out;
    }

    @Override
    public Object visitRp_comma(XQueryParser.Rp_commaContext ctx) {
        Node temp = yet_to_visit.get(0);
        List<Node> out = (List<Node>) this.visit(ctx.rp(0));
        yet_to_visit.add(temp);
        out.addAll((List<Node>) this.visit(ctx.rp(1)));
        return out;
    }

    @Override
    public Object visitRp_self(XQueryParser.Rp_selfContext ctx) {
        List<Node> out = new ArrayList<Node>();
        if (yet_to_visit.isEmpty())
            return out;
        out.add(yet_to_visit.remove(0));
        return out;
    }

    @Override
    public Object visitRp_text(XQueryParser.Rp_textContext ctx) {
        List<Node> out = new ArrayList<Node>();
        if (yet_to_visit.isEmpty())
            return out;
        NodeList children = yet_to_visit.remove(0).getChildNodes();
        for (int i = 0; i < children.getLength(); i++)
            if (children.item(i).getNodeType() == Node.TEXT_NODE)
                out.add(children.item(i));
        return out;
    }

    @Override
    public Object visitRp_filter(XQueryParser.Rp_filterContext ctx) {
        List<Node> out = new ArrayList<Node>();
        List<Node> intermediate_result = (List<Node>) this.visit(ctx.rp());
        for (int i = 0; i < intermediate_result.size(); i++) {
            yet_to_visit.add(intermediate_result.get(i));
            if ((boolean) this.visit(ctx.filter())) // evaluate filter on each node
                out.add(intermediate_result.get(i));
        }
        return out;
    }

    @Override
    public Object visitRp_paren(XQueryParser.Rp_parenContext ctx) {
        return this.visit(ctx.rp());
    }

    @Override
    public Object visitRp_att(XQueryParser.Rp_attContext ctx) {
        List<Node> out = new ArrayList<Node>();
        if (yet_to_visit.isEmpty())
            return out;
        String att = ctx.attriname().getText();

        Node node = yet_to_visit.remove(0);
        /* when node == doc, getAttributes() returns null !!! */
        if (node.getAttributes() == null)
            return out;

        node = node.getAttributes().getNamedItem(att);

        if (node != null)
            out.add(node);
        return out;
    }

    /* used to deduplicate list of DOM nodes */
    private List<Node> deduplicate(List<Node> list) {
        List<Node> out = new ArrayList<Node>();
        HashMap<Node, Integer> map = new HashMap<Node, Integer>();
        HashMap<Integer, Node> reverseMap = new HashMap<Integer, Node>();
        for (int i = 0; i < list.size(); i++)
            if (!map.containsKey(list.get(i))) {
                map.put(list.get(i), i);
                reverseMap.put(i, list.get(i));
            }

        for (int i = 0; i < list.size(); i++)
            if (reverseMap.containsKey(i))
                out.add(reverseMap.get(i));

        return out;
    }

    /* filter methods */

    @Override
    public Object visitF_not(XQueryParser.F_notContext ctx) {
        return !(boolean) this.visit(ctx.filter());
    }

    @Override
    public Object visitF_rp(XQueryParser.F_rpContext ctx) {
        // yet_to_visit is guaranteed to be not empty
        // otherwise this func will not be called
        // but precautions, let's add them
        if (yet_to_visit.isEmpty())
            return false;

        return ((List<Node>) this.visit(ctx.rp())).size() > 0;
    }

    @Override
    public Object visitF_paren(XQueryParser.F_parenContext ctx) {
        return this.visit(ctx.filter());
    }

    @Override
    public Object visitF_or(XQueryParser.F_orContext ctx) {
        // yet_to_visit is guaranteed to be not empty
        // otherwise this func will not be called
        // but precautions, let's add them
        if (yet_to_visit.isEmpty())
            return false;

        Node node = yet_to_visit.get(0);
        if ((boolean) this.visit(ctx.filter(0)))
            return true;
        else {
            yet_to_visit.add(node);
            return this.visit(ctx.filter(1));
        }
    }

    @Override
    public Object visitF_and(XQueryParser.F_andContext ctx) {
        // yet_to_visit is guaranteed to be not empty
        // otherwise this func will not be called
        // but precautions, let's add them
        if (yet_to_visit.isEmpty())
            return false;

        Node node = yet_to_visit.get(0);
        if (!(boolean) this.visit(ctx.filter(0)))
            return false;
        else {
            yet_to_visit.add(node);
            return (boolean) this.visit(ctx.filter(1));
        }
    }

    @Override
    public Object visitF_eq(XQueryParser.F_eqContext ctx) {
        Node node = yet_to_visit.get(0);
        List<Node> list1 = (List<Node>) this.visit(ctx.rp(0));
        yet_to_visit.add(node);
        List<Node> list2 = (List<Node>) this.visit(ctx.rp(1));

        for (int i = 0; i < list1.size(); i++)
            for (int j = 0; j < list2.size(); j++)
                if (list1.get(i).isEqualNode(list2.get(j)))
                    return true;
        return false;
    }

    @Override
    public Object visitF_is(XQueryParser.F_isContext ctx) {
        Node node = yet_to_visit.get(0);
        List<Node> list1 = (List<Node>) this.visit(ctx.rp(0));
        yet_to_visit.add(node);
        List<Node> list2 = (List<Node>) this.visit(ctx.rp(1));
        for (int i = 0; i < list1.size(); i++)
            for (int j = 0; j < list2.size(); j++)
                if (list1.get(i).isSameNode(list2.get(j)))
                    return true;
        return false;
    }

    /* Milestone 2 functions */
    @Override
    public Object visitXq_str(XQueryParser.Xq_strContext ctx) {
        String StringConstant = ctx.getText().substring(1, ctx.getText().length() - 1);
        List<Node> out = new ArrayList<Node>();
        try {
            out.add(DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument().createTextNode(StringConstant));
            return out;
        } catch (ParserConfigurationException e) {
            System.out.println("ParserConfigurationException, exit.");
            System.exit(3);
            return null;
        }
    }

    @Override
    public Object visitXq_double_slash_rp(XQueryParser.Xq_double_slash_rpContext ctx) {
        List<Node> out = new ArrayList<>();
        for (Node node1 : deduplicate((List<Node>) this.visit(ctx.xq()))) { // for every node in nodeList, do double_slash
            for (Node node : evaluateForEach(findSelfOrDescendant(node1), ctx.rp()))
                if (!out.contains(node))
                    out.add(node);
        }
        return out;
    }

    @Override
    public Object visitXq_slash_rp(XQueryParser.Xq_slash_rpContext ctx) {
        List<Node> out = new ArrayList<>();
        for (Node node : evaluateForEach((List<Node>) this.visit(ctx.xq()), ctx.rp()))
            if (!out.contains(node))
                out.add(node);
        return out;
    }

    @Override
    public Object visitXq_paren(XQueryParser.Xq_parenContext ctx) {
        return this.visit(ctx.xq());
    }

    @Override
    public Object visitXq_ap(XQueryParser.Xq_apContext ctx) {
        return (List<Node>) this.visit(ctx.ap());
    }

    @Override
    public List<Node> visitXq_var(XQueryParser.Xq_varContext ctx) {
        for (int i = 0; i < mem_stack.size(); i++) {
            List<Node> temp = mem_stack.get(mem_stack.size() - 1 - i).get(ctx.var().getText());
            if (temp != null)
                return temp;
        }
        return new ArrayList<>();
    }


    private void popStackUntil(int until) {
        while (mem_stack.size() > until)
            mem_stack.remove(mem_stack.size() - 1);
    }

    @Override
    public Object visitXq_FLWR(XQueryParser.Xq_FLWRContext ctx) {
        return this.visit(ctx.forClause());
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
    public Object visitForClause(XQueryParser.ForClauseContext ctx) {
        ArrayList<Node> out = new ArrayList<>();
        XQueryParser.Xq_FLWRContext parent = (XQueryParser.Xq_FLWRContext) ctx.parent;
        Deque<NodeWithDepth> stack = new ArrayDeque<>();

        List<Node> temp = (List<Node>) this.visit(ctx.xq(0));
        for (int i = temp.size() - 1; i >= 0; i--)
            stack.push(new NodeWithDepth(temp.get(i), 0));

        int originalStackSize = mem_stack.size();
        HashMap<String, List<Node>> forcontext = new HashMap<String, List<Node>>();
        mem_stack.add(forcontext);

        int MAXDEPTH = ctx.xq().size() - 1;
        while (!stack.isEmpty()) {
            NodeWithDepth cur = stack.pop();
            ArrayList<Node> dummy = new ArrayList<>();
            if (cur.node != null) // ignore placeholder node
                dummy.add(cur.node);
            HashMap<String, List<Node>> context = mem_stack.get(mem_stack.size() - 1); // ???
            context.put(ctx.var(cur.depth).getText(), dummy);

            if (cur.depth == MAXDEPTH) {
                int stackSizeBeforeLet = mem_stack.size();
                /* handle let clause */
                if (parent.letClause() != null)
                    this.visit(parent.letClause());

                /* handle where clause */
                int stackSizeBeforeWhere = mem_stack.size();
                boolean whereReturnVal = true;
                if (parent.whereClause() != null)
                    whereReturnVal = (boolean) this.visit(parent.whereClause());
                popStackUntil(stackSizeBeforeWhere);

                if (whereReturnVal)
                    out.addAll((List<Node>) this.visit(parent.returnClause()));

                popStackUntil(stackSizeBeforeLet);
                continue;
            }

            temp = (List<Node>) this.visit(ctx.xq(cur.depth + 1));
            for (int i = temp.size() - 1; i >= 0; i--)
                stack.push(new NodeWithDepth(temp.get(i), cur.depth + 1));
            /* create a placeholder node to make sure the evaluations go all the way down */
            if (temp.size() == 0)
                stack.push(new NodeWithDepth(null, cur.depth + 1));
        }
        popStackUntil(originalStackSize);
        return out;
    }

    @Override
    public Object visitLetClause(XQueryParser.LetClauseContext ctx) {
        HashMap<String, List<Node>> newContext = new HashMap<String, List<Node>>();
        mem_stack.add(newContext);
        for (int i = 0; i < ctx.var().size(); i++)
            newContext.put(ctx.var(i).getText(), (List<Node>) this.visit(ctx.xq(i)));
        return new ArrayList<Node>(); // dummy return
    }

    @Override
    public Object visitWhereClause(XQueryParser.WhereClauseContext ctx) {
        return (Boolean) this.visit(ctx.condition());
    }

    @Override
    public Object visitReturnClause(XQueryParser.ReturnClauseContext ctx) {
        return this.visit(ctx.xq());
    }


    private Node makeElem(String tag, List<Node> children) {
        try {
            Document newDoc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Node out = newDoc.createElement(tag);
            for (int i = 0; i < children.size(); i++)
                out.appendChild(newDoc.importNode(children.get(i).cloneNode(true), true));
            return out;
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            System.out.println("ParserConfigurationException, exit.");
            System.exit(1);
            return null;
        }
    }

    @Override
    public Object visitXq_constructor(XQueryParser.Xq_constructorContext ctx) {
        List<Node> out = new ArrayList<>();
        if (!ctx.tagname(0).getText().equals(ctx.tagname(1).getText())) {
            System.out.println("Opening and closing tags don't match: "
                    + "\'"
                    + ctx.tagname(0).getText()
                    + "\'"
                    + " != "
                    + "\'"
                    + ctx.tagname(1).getText()
                    + "\'"
                    + ". Exit.");
            System.exit(2);
        }
        out.add(this.makeElem(ctx.tagname(0).getText(), (List<Node>) this.visit(ctx.xq())));
        return out;
    }

    @Override
    public Object visitXq_let(XQueryParser.Xq_letContext ctx) {
        this.visit(ctx.letClause());
        return new ArrayList<Node>(); // dummy return
    }

    @Override
    public Object visitXq_comma(XQueryParser.Xq_commaContext ctx) {
        List<Node> out = new ArrayList<>((List<Node>) this.visit(ctx.xq(0)));
        out.addAll((List<Node>) this.visit(ctx.xq(1)));
        return out;
    }

    @Override
    public Object visitCond_and(XQueryParser.Cond_andContext ctx) {
        return (boolean) this.visit(ctx.condition(0)) && (boolean) this.visit(ctx.condition(1));
    }

    @Override
    public Object visitCond_empty(XQueryParser.Cond_emptyContext ctx) {
        return ((List<Node>) this.visit(ctx.xq())).size() == 0;
    }

    @Override
    public Object visitCond_some(XQueryParser.Cond_someContext ctx) {
        Deque<NodeWithDepth> stack = new ArrayDeque<>();

        List<Node> temp = (List<Node>) this.visit(ctx.xq(0));
        for (int i = temp.size() - 1; i >= 0; i--)
            stack.push(new NodeWithDepth(temp.get(i), 0));

        int originalStackSize = mem_stack.size();
        mem_stack.add(new HashMap<String, List<Node>>());

        int MAXDEPTH = ctx.xq().size() - 1;
        while (!stack.isEmpty()) {
            NodeWithDepth cur = stack.pop();
            ArrayList<Node> dummy = new ArrayList<>();
            if (cur.node != null) // ignore placeholder node
                dummy.add(cur.node);
            HashMap<String, List<Node>> context = mem_stack.get(mem_stack.size() - 1); // ???
            context.put(ctx.var(cur.depth).getText(), dummy);

            if (cur.depth == MAXDEPTH) {
                if ((boolean) this.visit(ctx.condition())) {
                    popStackUntil(originalStackSize);
                    return true;
                }
                continue;
            }

            temp = (List<Node>) this.visit(ctx.xq(cur.depth + 1));
            for (int i = temp.size() - 1; i >= 0; i--)
                stack.push(new NodeWithDepth(temp.get(i), cur.depth + 1));
            /* create a placeholder node to make sure the evaluations go all the way down */
            if (temp.size() == 0)
                stack.push(new NodeWithDepth(null, cur.depth + 1));
        }
        popStackUntil(originalStackSize);
        return false;
    }


    @Override
    public Object visitCond_eq(XQueryParser.Cond_eqContext ctx) {
        List<Node> list1 = (List<Node>) this.visit(ctx.xq(0));
        List<Node> list2 = (List<Node>) this.visit(ctx.xq(1));
        for (int i = 0; i < list1.size(); i++)
            for (int j = 0; j < list2.size(); j++)
                if (list1.get(i).isEqualNode(list2.get(j)))
                    return true;

        return false;
    }

    @Override
    public Object visitCond_is(XQueryParser.Cond_isContext ctx) {
        List<Node> list1 = (List<Node>) this.visit(ctx.xq(0));
        List<Node> list2 = (List<Node>) this.visit(ctx.xq(1));
        for (int i = 0; i < list1.size(); i++)
            for (int j = 0; j < list2.size(); j++)
                if (list1.get(i).isSameNode(list2.get(j)))
                    return true;

        return false;
    }

    @Override
    public Object visitCond_paren(XQueryParser.Cond_parenContext ctx) {
        return this.visit(ctx.condition());
    }

    @Override
    public Object visitCond_not(XQueryParser.Cond_notContext ctx) {
        return !(boolean) this.visit(ctx.condition());
    }

    @Override
    public Object visitCond_or(XQueryParser.Cond_orContext ctx) {
        return (boolean) this.visit(ctx.condition(0)) || (boolean) this.visit(ctx.condition(1));
    }

    @Override
    public Object visitAttributeList(XQueryParser.AttributeListContext ctx) {
        String out[] = new String[ctx.attriname().size()];
        for (int i = 0; i < ctx.attriname().size(); i++)
            out[i] = ctx.attriname(i).getText();
        return out;
    }

    @Override
    public Object visitXq_join(XQueryParser.Xq_joinContext ctx) {
        return this.visit(ctx.joinClause());
    }

    private int stringToInt(String s) {
        int code = 0;
        for (int i = 0; i < s.length(); i++)
            code += s.charAt(i) * (i+1);
        return code;
    }

    private int getHashKey(Node tuple, HashMap<String,Integer> attris) {
        NodeList children = tuple.getChildNodes();
        int key = 0;
        for (int i = 0; i < children.getLength(); i++)
                if (attris.containsKey(children.item(i).getNodeName()))
                    key += stringToInt(children.item(i).getChildNodes().item(0).getNodeName()) + children.item(i).getChildNodes().item(0).getChildNodes().getLength();
        return key;
    }

    @Override
    public Object visitJoinClause(XQueryParser.JoinClauseContext ctx) {
        List<Node> smallist = (List<Node>)this.visit(ctx.xq(0));
        List<Node> biglist = (List<Node>)this.visit(ctx.xq(1));
        String[] smallattri = (String[])this.visitAttributeList(ctx.attributeList(0));
        String[] bigattri = (String[])this.visitAttributeList(ctx.attributeList(1));

        List<Node> swap1;
        String[] swap2;
        if (smallist.size() > biglist.size()) {
            swap1 = smallist;
            smallist = biglist;
            biglist = swap1;

            swap2 = smallattri;
            smallattri = bigattri;
            bigattri = swap2;
        }

        /* construct attribute map for biglist */
        HashMap<String, Integer> bigattrimap = new HashMap<>();
        for (int i = 0; i < bigattri.length; i++)
            bigattrimap.put(bigattri[i],i);

        /* construct hashmap for biglist */
        HashMap<Integer, List<Node>> joinmap = new HashMap<>();
        for (int i = 0; i < biglist.size(); i++) {
            Node tuple = biglist.get(i);

            int key = getHashKey(tuple, bigattrimap);
            if (joinmap.containsKey(key))
                joinmap.get(key).add(tuple);
            else {
                joinmap.put(key, new ArrayList<>());
                joinmap.get(key).add(tuple);
            }
        }

        List<Node> out = new ArrayList<>();
        /* construct attribute map for smallist */
        HashMap<String, Integer> smallattrimap = new HashMap<>();
        for (int i = 0; i < smallattri.length; i++)
            smallattrimap.put(smallattri[i],i);

        /* join process */
        for (int i = 0; i < smallist.size(); i++) {
            Node smalltuple = smallist.get(i);
            int key = getHashKey(smalltuple,smallattrimap);
            List<Node> bucket = joinmap.get(key);
            if (bucket == null)
                continue;

            for (Node bigtuple: bucket) {
                NodeList children = bigtuple.getChildNodes();
                HashMap<Integer, Node> tupleCompareMap = new HashMap<>();
                Node child;
                String tag;
                /* construct tupleCompareMap for bigtuple */
                for (int j = 0; j < children.getLength(); j++) {
                    child = children.item(j);
                    tag = child.getNodeName();
                    if (bigattrimap.containsKey(tag))
                        tupleCompareMap.put(bigattrimap.get(tag), child);
                }

                /* test if smalltuple and bigtuple are equal */
                boolean breakflag = false;
                children = smalltuple.getChildNodes();
                for (int j = 0; j < children.getLength(); j++) {
                    child = children.item(j);
                    tag = child.getNodeName();
                    if (smallattrimap.containsKey(tag))
                        if ( ! child.getChildNodes().item(0).isEqualNode( tupleCompareMap.get(smallattrimap.get(tag)).getChildNodes().item(0) )) {
                            breakflag = true;
                            break;
                        }
                }
                /* test passes, join the tuples and add to output */
                if (!breakflag) {
                    try {
                        Document newDoc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
                        Node newElem = newDoc.createElement("tuple");
                        for (int j = 0; j < smalltuple.getChildNodes().getLength(); j++)
                            newElem.appendChild( newDoc.importNode(smalltuple.getChildNodes().item(j).cloneNode(true),true) );
                        for (int j = 0; j < bigtuple.getChildNodes().getLength(); j++)
                            newElem.appendChild( newDoc.importNode(bigtuple.getChildNodes().item(j).cloneNode(true),true) );
                        out.add(newElem);
                    } catch (ParserConfigurationException e) {
                        e.printStackTrace();
                        System.out.println("ParserConfigurationException in join(), exit.");
                        System.exit(1);
                        return null;
                    }
                }
            } // for every bigtuple (in the bucket)
        } // for every smalltuple

        return out;
    }

}

