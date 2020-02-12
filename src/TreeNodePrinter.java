import org.w3c.dom.*;
import javax.swing.tree.TreeNode;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class TreeNodePrinter {

    static final String outputEncoding = "UTF-8";
    private PrintWriter out;
    private int indent = 0;
    private final String basicIndent = " ";

    public TreeNodePrinter() throws Exception {
        out = new PrintWriter(new OutputStreamWriter(System.out,outputEncoding),true);
    }

    public void prettyPrint(Node node, String tab)
    {
        if (node == null)
            return;

        if (node.getNodeType() == Node.TEXT_NODE)
        {
            System.out.print(tab);
            System.out.println(node.getNodeValue());
        }
        else if (node.getNodeType() == Node.ELEMENT_NODE)
        {
            System.out.print(tab);
            System.out.print("<" + node.getNodeName());

            /* for printing attributes */
            NamedNodeMap attrs = node.getAttributes();
            for (int i = 0; i < attrs.getLength(); i++) {
                System.out.print(" ");
                System.out.print(attrs.item(i));
            }
            System.out.println(">");

            NodeList kids = node.getChildNodes();
            for (int i = 0; i < kids.getLength(); i++)
                prettyPrint(kids.item(i), tab + "  ");

            System.out.print(tab);
            System.out.println("</" + node.getNodeName() + ">");
        }
        else if (node.getNodeType() == Node.ATTRIBUTE_NODE)
            System.out.println(node);
    }

    private void outputIndentation() {
        for (int i = 0; i < indent; i++) {
            out.print(basicIndent);
        }
    }

    private void printlnCommon(Node n) {
        out.print(" nodeName=\"" + n.getNodeName() + "\"");
        String val = n.getNamespaceURI();
        if (val != null) {
            out.print(" uri=\"" + val + "\"");
        }

        val = n.getPrefix();

        if (val != null) {
            out.print(" pre=\"" + val + "\"");
        }

        val = n.getLocalName();
        if (val != null) {
            out.print(" local=\"" + val + "\"");
        }

        val = n.getNodeValue();
        if (val != null) {
            out.print(" nodeValue=");
            if (val.trim().equals("")) {
                // Whitespace
                out.print("[WS]");
            }
            else {
                out.print("\"" + n.getNodeValue() + "\"");
            }
        }
        out.println();
    }

    public void printNode(Node n) {
        outputIndentation();
        int type = n.getNodeType();

        switch (type) {
            case Node.ATTRIBUTE_NODE:
                out.print("ATTR:");
                printlnCommon(n);
                break;

            case Node.CDATA_SECTION_NODE:
                out.print("CDATA:");
                printlnCommon(n);
                break;

            case Node.COMMENT_NODE:
                out.print("COMM:");
                printlnCommon(n);
                break;

            case Node.DOCUMENT_FRAGMENT_NODE:
                out.print("DOC_FRAG:");
                printlnCommon(n);
                break;

            case Node.DOCUMENT_NODE:
                out.print("DOC:");
                printlnCommon(n);
                break;

            case Node.DOCUMENT_TYPE_NODE:
                out.print("DOC_TYPE:");
                printlnCommon(n);
                NamedNodeMap nodeMap = ((DocumentType)n).getEntities();
                indent += 2;
                for (int i = 0; i < nodeMap.getLength(); i++) {
                    Entity entity = (Entity)nodeMap.item(i);
                    printNode(entity);
                }
                indent -= 2;
                break;

            case Node.ELEMENT_NODE:
                out.print("ELEM:");
                printlnCommon(n);

                NamedNodeMap atts = n.getAttributes();
                indent += 2;
                for (int i = 0; i < atts.getLength(); i++) {
                    Node att = atts.item(i);
                    printNode(att);
                }
                indent -= 2;
                break;

            case Node.ENTITY_NODE:
                out.print("ENT:");
                printlnCommon(n);
                break;

            case Node.ENTITY_REFERENCE_NODE:
                out.print("ENT_REF:");
                printlnCommon(n);
                break;

            case Node.NOTATION_NODE:
                out.print("NOTATION:");
                printlnCommon(n);
                break;

            case Node.PROCESSING_INSTRUCTION_NODE:
                out.print("PROC_INST:");
                printlnCommon(n);
                break;

            case Node.TEXT_NODE:
                out.print("TEXT:");
                printlnCommon(n);
                break;

            default:
                out.print("UNSUPPORTED NODE: " + type);
                printlnCommon(n);
                break;
        }

        indent++;
        for (Node child = n.getFirstChild(); child != null; child = child.getNextSibling()) {
            printNode(child);
        }
        indent--;
    }
}
