import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.lang.reflect.Array;
import java.util.*;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class MyXQueryVisitor extends XQueryBaseVisitor<Object> {
    private Map<String, Integer> map = new HashMap<String, Integer>();
    private List<Node> yet_to_visit = new ArrayList<>(); // to store DOM nodes yet to visit
    //private Document globalDoc;//now equals the opened file, not sure if we need to create a new document


    private Document openInputFile(String filename) {
        try {
            // create DOM document parser and parse input file
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            filename = filename.replace("\"","");
            File inputFile = new File(filename);
            Document doc = dBuilder.parse(inputFile);

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
        //globalDoc = doc;
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

            for (Node node : (List<Node>)this.visit(ctx.rp()))
                if ( ! out.contains(node) )
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
                if ( nodeList.item(i).getNodeName().equals(ctx.tagname().getText()) )
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
    public Object visitRp_slash(XQueryParser.Rp_slashContext ctx) {
        List<Node> out = new ArrayList<Node>();
        if (yet_to_visit.isEmpty())
            return out;

        for (Node node1: deduplicate((List<Node>) this.visit(ctx.rp(0))) ) {
            yet_to_visit.add(node1);
            for (Node node2: (List<Node>)this.visit(ctx.rp(1)))
                if ( ! out.contains(node2))
                    out.add(node2);
        }
        return out;
    }

    @Override public Object visitRp_double_slash(XQueryParser.Rp_double_slashContext ctx) {
        List<Node> out = new ArrayList<Node>();

        for ( Node node1: deduplicate((List<Node>)this.visit(ctx.rp(0))) ) { // for every node in nodeList, do double_slash
            /* For every node in nodeList, find self or descendent */
            List<Node> selfOrDescendent = new ArrayList<Node>();

            List<Node> queue = new ArrayList<Node>(); // for traversal
            queue.add(node1); // add root (the self node)
            while (!queue.isEmpty())  { // bfs traversal of DOM tree
                Node node = queue.remove(0);
                selfOrDescendent.add(node);
                NodeList children = node.getChildNodes();
                /* add all ELEMENT children to temp */
                for (int j = 0; j < children.getLength(); j++)
                    if (children.item(j).getNodeType() == Node.ELEMENT_NODE)
                        queue.add(children.item(j));
            }
            /* Now all self or descendent nodes found, do double slash for each */
            for (int j = 0; j < selfOrDescendent.size(); j++) {
                yet_to_visit.add(selfOrDescendent.get(j));
                for (Node node2: (List<Node>)this.visit(ctx.rp(1)))
                    if (! out.contains(node2))
                        out.add(node2);
            }
        }
        return out;
    }

    @Override
    public Object visitRp_comma(XQueryParser.Rp_commaContext ctx) {
        Node temp = yet_to_visit.get(0);
        List<Node> out = (List<Node>)this.visit(ctx.rp(0));
        yet_to_visit.add(temp);
        out.addAll((List<Node>)this.visit(ctx.rp(1)));
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
        List<Node> intermediate_result = (List<Node>)this.visit(ctx.rp());
        for (int i = 0; i < intermediate_result.size(); i++) {
            yet_to_visit.add(intermediate_result.get(i));
            if ( (boolean)this.visit(ctx.filter()) ) // evaluate filter on each node
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
        HashMap<Node,Integer> map = new HashMap<Node,Integer>();
        HashMap<Integer,Node> reverseMap = new HashMap<Integer,Node>();
        for (int i = 0; i < list.size(); i++)
            if (! map.containsKey(list.get(i))) {
                map.put(list.get(i),i);
                reverseMap.put(i,list.get(i));
            }

        for (int i = 0; i < list.size(); i++)
            if (reverseMap.containsKey(i))
                out.add(reverseMap.get(i));

        return out;
    }

    /* filter methods */

    @Override
    public Object visitF_not(XQueryParser.F_notContext ctx) {
        return !(boolean)this.visit(ctx.filter());
    }

    @Override
    public Object visitF_rp(XQueryParser.F_rpContext ctx) {
        // yet_to_visit is guaranteed to be not empty
        // otherwise this func will not be called
        // but precautions, let's add them
        if (yet_to_visit.isEmpty())
            return false;

        return ((List<Node>)this.visit(ctx.rp())).size() > 0;
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
        if ( (boolean)this.visit(ctx.filter(0)))
            return true;
        else {
            yet_to_visit.add(node);
            return (boolean)this.visit(ctx.filter(1));
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
        if ( ! (boolean)this.visit(ctx.filter(0)) )
            return false;
        else {
            yet_to_visit.add(node);
            return (boolean)this.visit(ctx.filter(1));
        }
    }

    @Override
    public Object visitF_eq(XQueryParser.F_eqContext ctx) {
        Node node = yet_to_visit.get(0);
        List<Node> list1 = (List<Node>)this.visit(ctx.rp(0));
        yet_to_visit.add(node);
        List<Node> list2 = (List<Node>)this.visit(ctx.rp(1));

        for (int i = 0; i < list1.size(); i++)
            for (int j = 0; j < list2.size(); j++)
                if (list1.get(i).isEqualNode(list2.get(j)))
                    return true;
        return false;
    }

    @Override
    public Object visitF_is(XQueryParser.F_isContext ctx) {
        Node node = yet_to_visit.get(0);
        List<Node> list1 = (List<Node>)this.visit(ctx.rp(0));
        yet_to_visit.add(node);
        List<Node> list2 = (List<Node>)this.visit(ctx.rp(1));
        for (int i = 0; i < list1.size(); i++)
            for (int j = 0; j < list2.size(); j++)
                if ( list1.get(i).isSameNode(list2.get(j)) )
                    return true;
        return false;
    }

    @Override
    public Object visitXq_str(XQueryParser.Xq_strContext ctx) {
        //get string from ctx
        String StringConstant = ctx.getText().replace("\"", "");//?
        //create new text node
        //Node newTextNode = globalDoc.createTextNode(StringConstant);
        //return newTextNode;

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            Document newDoc = dbf.newDocumentBuilder().newDocument();
            return newDoc.createTextNode(StringConstant);
        } catch (ParserConfigurationException ex) {
            return null;
        }
    }

    @Override
    public Object visitXq_var(XQueryParser.Xq_varContext ctx) {
        Node node = yet_to_visit.get(0);
        List<Node> out = new ArrayList<>();

        return visitChildren(ctx);

    }

    @Override public Object visitXq_slash_rp(XQueryParser.Xq_slash_rpContext ctx) { return visitChildren(ctx); }
    @Override public Object visitXq_paren(XQueryParser.Xq_parenContext ctx) { return visitChildren(ctx); }
    @Override public Object visitXq_double_slash_rp(XQueryParser.Xq_double_slash_rpContext ctx) { return visitChildren(ctx); }
    @Override public Object visitXq_ap(XQueryParser.Xq_apContext ctx) { return visitChildren(ctx); }

    @Override public Object visitXq_FLWR(XQueryParser.Xq_FLWRContext ctx) { return visitChildren(ctx); }
    @Override public Object visitXq_constructor(XQueryParser.Xq_constructorContext ctx) { return visitChildren(ctx); }
    @Override public Object visitXq_let(XQueryParser.Xq_letContext ctx) { return visitChildren(ctx); }
    @Override public Object visitXq_comma(XQueryParser.Xq_commaContext ctx) { return visitChildren(ctx); }
    @Override public Object visitForClause(XQueryParser.ForClauseContext ctx) { return visitChildren(ctx); }
    @Override public Object visitLetClause(XQueryParser.LetClauseContext ctx) { return visitChildren(ctx); }
    @Override public Object visitWhereClause(XQueryParser.WhereClauseContext ctx) { return visitChildren(ctx); }
    @Override public Object visitReturnClause(XQueryParser.ReturnClauseContext ctx) { return visitChildren(ctx); }
    @Override public Object visitCond_and(XQueryParser.Cond_andContext ctx) { return visitChildren(ctx); }
    @Override public Object visitCond_empty(XQueryParser.Cond_emptyContext ctx) { return visitChildren(ctx); }
    @Override public Object visitCond_eq(XQueryParser.Cond_eqContext ctx) { return visitChildren(ctx); }
    @Override public Object visitCond_is(XQueryParser.Cond_isContext ctx) { return visitChildren(ctx); }
    @Override public Object visitCond_paren(XQueryParser.Cond_parenContext ctx) { return visitChildren(ctx); }
    @Override public Object visitCond_some(XQueryParser.Cond_someContext ctx) { return visitChildren(ctx); }
    @Override public Object visitCond_not(XQueryParser.Cond_notContext ctx) { return visitChildren(ctx); }
    @Override public Object visitCond_or(XQueryParser.Cond_orContext ctx) { return visitChildren(ctx); }

}

