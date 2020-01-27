import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.util.*;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class MyXQueryVisitor extends XQueryBaseVisitor<Object> {
    private Map<String, Integer> map = new HashMap<String, Integer>();
    private List<Node> yet_to_visit = new ArrayList<>(); // to store DOM nodes yet to visit

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
            return null;
        }
    }

    @Override
    public Object visitAp_slash(XQueryParser.Ap_slashContext ctx) {
        String filename = ctx.FILENAME().getText(); // find file path
        Document doc = openInputFile(filename); // open file
        yet_to_visit.add(doc.getDocumentElement());  // add the XML root
        return this.visit(ctx.rp());
    }

    @Override public Object visitAp_double_slash(XQueryParser.Ap_double_slashContext ctx) {
        String filename = ctx.FILENAME().getText(); // find file path
        Document doc = openInputFile(filename); // open file

        List<Node> out = new ArrayList<Node>();

        NodeList nodeList = doc.getElementsByTagName("*");

        for (int i = 0; i < nodeList.getLength(); i++) {
            yet_to_visit.add(nodeList.item(i));
            out.addAll( (List<Node>)this.visit(ctx.rp()));
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
                if ( nodeList.item(i).getNodeName().equals(ctx.TAGNAME().getText()) )
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

        yet_to_visit.add(yet_to_visit.remove(0).getParentNode());
        return this.visit(ctx.getParent());
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

    @Override public Object visitRp_double_slash(XQueryParser.Rp_double_slashContext ctx) {
        List<Node> out = new ArrayList<Node>();

        List<Node> nodeList = (List<Node>)this.visit(ctx.rp(0)); // return of the first rp

        for (int i = 0; i < nodeList.size(); i++) { // for every node in nodeList, do double_slash
            /* For every node in nodeList, find self or descendent */
            List<Node> selfOrDescendent = new ArrayList<Node>();

            List<Node> temp = new ArrayList<Node>(); // for graph traversal
            temp.add(nodeList.get(i)); // add root (the self node)
            while (!temp.isEmpty())  {
                Node node = temp.remove(0);
                selfOrDescendent.add(node);
                NodeList children = node.getChildNodes();
                /* add all ELEMENT children to temp */
                for (int j = 0; j < children.getLength(); j++)
                    if (children.item(j).getNodeType() == Node.ELEMENT_NODE)
                        temp.add(children.item(j));
            }
            /* Now all self or descendent nodes found, do double slash for each */
            for (int j = 0; j < selfOrDescendent.size(); j++) {
                yet_to_visit.add(selfOrDescendent.get(j));
                out.addAll( (List<Node>)this.visit(ctx.rp(1)) );
            }
        }
        return out;
    }

    @Override
    public Object visitRp_comma(XQueryParser.Rp_commaContext ctx) {
        Node temp = yet_to_visit.get(0);
        List<Node> out = (List<Node>)this.visit(ctx.rp(0));
        /* add back the original DOM node for the second visit.
        * this is special because usually there is only one call
        * to visit on the same DOM node. In this case, the first
        * visit() removed the node from yet_to_visit(), we need
        * to manualy add back for the second visit();
        */
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
            if ((boolean)this.visit(ctx.filter())) // evaluate filter on each node
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
        String att = ctx.ATTRINAME().getText();
        Node node = yet_to_visit.remove(0);
        node = node.getAttributes().getNamedItem(att);
        if (node != null)
            out.add(node);
        return out;
    }

    @Override
    public Object visitRp_slash(XQueryParser.Rp_slashContext ctx) {
        List<Node> out = new ArrayList<Node>();


        return out;
    }

    @Override public Object visitF_not(XQueryParser.F_notContext ctx) { return visitChildren(ctx); }
    @Override public Object visitF_paren(XQueryParser.F_parenContext ctx) { return visitChildren(ctx); }
    @Override public Object visitF_or(XQueryParser.F_orContext ctx) { return visitChildren(ctx); }
    @Override public Object visitF_and(XQueryParser.F_andContext ctx) { return visitChildren(ctx); }
    @Override public Object visitF_is_alt(XQueryParser.F_is_altContext ctx) { return visitChildren(ctx); }
    @Override public Object visitF_eq_alt(XQueryParser.F_eq_altContext ctx) { return visitChildren(ctx); }
    @Override public Object visitF_eq(XQueryParser.F_eqContext ctx) { return visitChildren(ctx); }
    @Override public Object visitF_is(XQueryParser.F_isContext ctx) { return visitChildren(ctx); }

}

