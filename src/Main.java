import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.w3c.dom.Node;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import java.io.FileInputStream;
import java.io.InputStream;


public class Main {
    public static void main(String[] args) throws Exception {
        String inputFile = null;

        /* parse arguments */
        if (args.length > 0)
            inputFile = args[0];
        else {
            System.out.println("Input file not specified. Exit.");
        }

        boolean xmlOutput = false;
        for (int i = 1; i < args.length; i++)
            if (args[i].charAt(0) == '-' && args[i].contains("x"))
                xmlOutput = true;

        // reading input and lexing/parsing
        InputStream is = new FileInputStream(inputFile); // throws FileNotFound
        ANTLRInputStream input = new ANTLRInputStream(is);
        XQueryLexer lexer = new XQueryLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        XQueryParser parser = new XQueryParser(tokens);
        ParseTree tree = parser.xq();

        // create my custom visitor and evaluate query
        MyXQueryVisitor visitor = new MyXQueryVisitor();
        List<Node> result = (List<Node>)visitor.visit(tree);

        /* printing results */
        System.out.println("\nNumber of nodes: " + result.size());
        TreeNodePrinter printer = new TreeNodePrinter();
        int i = 1;
        for (Node node: result) {
            // System.out.println("\n***** Node #" + i++ + "  *****");
            if (xmlOutput)
                printer.prettyPrint(node,"");
            else
                printer.printNode(node);
        }
    }


}


