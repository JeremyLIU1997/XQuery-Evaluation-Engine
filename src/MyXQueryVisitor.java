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

    @Override
    public Object visitAp_slash(XQueryParser.Ap_slashContext ctx) {
        String filename = ctx.FILENAME().getText(); // find file path

        try {
            // create DOM document parser and parse input file
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            filename = filename.replace("\"","");
            File inputFile = new File(filename);
            Document doc = dBuilder.parse(inputFile);

            doc.getDocumentElement().normalize(); // what does this do?

            yet_to_visit.add(doc.getDocumentElement());  // add the XML root
            return this.visit(ctx.rp());

        } // end of try
        catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

    }

    @Override public Object visitAp_double_slash(XQueryParser.Ap_double_slashContext ctx) { return visitChildren(ctx); }

    @Override
    public Object visitRp_tag(XQueryParser.Rp_tagContext ctx) {
        NodeList nodeList = yet_to_visit.remove(0).getChildNodes();
        List<Node> out = new ArrayList<>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                /* if current tag of the context node is equal to the current DOM node name */
                if ( nodeList.item(i).getNodeName().equals(ctx.TAGNAME().getText()) )
                {
                    out.add(nodeList.item(i));
                }
            }
        }
        return out;
    }

    @Override
    public Object visitRp_parent(XQueryParser.Rp_parentContext ctx) {

        return null;
    }

    @Override
    public Object visitRp_anyTag(XQueryParser.Rp_anyTagContext ctx) {
        return null;
    }
    @Override public Object visitRp_double_slash(XQueryParser.Rp_double_slashContext ctx) { return visitChildren(ctx); }
    @Override public Object visitRp_comma(XQueryParser.Rp_commaContext ctx) { return visitChildren(ctx); }
    @Override public Object visitRp_self(XQueryParser.Rp_selfContext ctx) { return visitChildren(ctx); }
    @Override public Object visitRp_text(XQueryParser.Rp_textContext ctx) { return visitChildren(ctx); }
    @Override public Object visitRp_filter(XQueryParser.Rp_filterContext ctx) { return visitChildren(ctx); }
    @Override public Object visitRp_paren(XQueryParser.Rp_parenContext ctx) { return visitChildren(ctx); }
    @Override public Object visitRp_att(XQueryParser.Rp_attContext ctx) { return visitChildren(ctx); }
    @Override public Object visitRp_slash(XQueryParser.Rp_slashContext ctx) { return visitChildren(ctx); }
    @Override public Object visitF_not(XQueryParser.F_notContext ctx) { return visitChildren(ctx); }
    @Override public Object visitF_paren(XQueryParser.F_parenContext ctx) { return visitChildren(ctx); }
    @Override public Object visitF_or(XQueryParser.F_orContext ctx) { return visitChildren(ctx); }
    @Override public Object visitF_and(XQueryParser.F_andContext ctx) { return visitChildren(ctx); }
    @Override public Object visitF_is_alt(XQueryParser.F_is_altContext ctx) { return visitChildren(ctx); }
    @Override public Object visitF_eq_alt(XQueryParser.F_eq_altContext ctx) { return visitChildren(ctx); }
    @Override public Object visitF_eq(XQueryParser.F_eqContext ctx) { return visitChildren(ctx); }
    @Override public Object visitF_is(XQueryParser.F_isContext ctx) { return visitChildren(ctx); }

}

