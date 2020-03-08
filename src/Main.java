import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.w3c.dom.Node;

import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        String inputFile = null;
        /* parse arguments */
        if (args.length > 0)
            inputFile = args[0];
        else
            System.out.println("Input file not specified. Exit.");

        boolean xmlOutput = false;
        boolean rewriteFlag = false;
        boolean noEvalFlag = false;

        for (int i = 1; i < args.length; i++)
            if (args[i].charAt(0) == '-') {
                if (args[i].contains("x")) // xml output format
                    xmlOutput = true;
                if (args[i].contains("r")) // rewrite
                    rewriteFlag = true;
                if (args[i].contains("s")) // stop after rewriting
                    noEvalFlag = true;
            }

        // if rewriter
        if (rewriteFlag) {
            // reading input and lexing/parsing
            InputStream is = new FileInputStream(inputFile); // throws FileNotFound
            ANTLRInputStream input = new ANTLRInputStream(is);
            XQueryLexer lexer = new XQueryLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            XQueryParser parser = new XQueryParser(tokens);
            ParseTree tree = parser.xq();

            MyXQueryRewriter rewriter = new MyXQueryRewriter();
            System.out.println("******* Rewrite Result *******");
            String rewrite_output = (String)rewriter.visit(tree);
            System.out.println(rewrite_output);
            System.out.println("******************************");

            inputFile = "./etc/.temp_output.txt";
            FileWriter tempOutput;
            try {
                tempOutput = new FileWriter(inputFile, false);
            }
            catch (Exception e) {
                inputFile  = "." + inputFile;
                tempOutput = new FileWriter(inputFile, false);
            }

            tempOutput.write(rewrite_output);
            tempOutput.close();
        }

        // reading input and lexing/parsing
        InputStream is = new FileInputStream(inputFile); // throws FileNotFound
        ANTLRInputStream input = new ANTLRInputStream(is);
        XQueryLexer lexer = new XQueryLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        XQueryParser parser = new XQueryParser(tokens);
        ParseTree tree = parser.xq(); // check if syntax correct

        if (noEvalFlag) // if noEval flag set, abort.
            System.exit(0);

        // if evaluate query
        MyXQueryVisitor visitor = new MyXQueryVisitor();
        List<Node> result = (List<Node>)visitor.visit(tree);

        /* printing results */
        System.out.println("\nNumber of nodes: " + result.size());
        TreeNodePrinter printer = new TreeNodePrinter();
        int i = 1;
        for (Node node: result) {
            if (xmlOutput)
                printer.prettyPrint(node,"");
            else
                printer.printNode(node);
        }
    }
}


