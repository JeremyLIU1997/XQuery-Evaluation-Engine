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

        boolean leftDeepFlag = false;
        boolean bushyFlag = false;
        boolean noEvalFlag = false;

        for (int i = 1; i < args.length; i++)
            if (args[i].charAt(0) == '-') {
                if (args[i].contains("l") || args[i].contains("L")) // rewriter left-deep flag
                    leftDeepFlag = true;
                if (args[i].contains("b") || args[i].contains("B")) // rewriter bushy flag
                    bushyFlag = true;
                if (args[i].contains("s") || args[i].contains("S")) // no evaluation flag
                    noEvalFlag = true;
            }

        InputStream is;
        // reading input and lexing/parsing
        try {
            is = new FileInputStream(inputFile); // throws FileNotFound
        } catch (Exception e) {
            System.out.println("Input query file not found. Exit.");
            System.exit(-1);
            return;
        }

        /* generate syntax tree for input query */
        ANTLRInputStream input = new ANTLRInputStream(is);
        XQueryLexer lexer = new XQueryLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        XQueryParser parser = new XQueryParser(tokens);
        ParseTree tree = parser.xq();

        String rewrite_output;
        // rewritability check
        ParseTreeWalker walker = new ParseTreeWalker();
        MyXQueryListener rewriteChecker = new MyXQueryListener();
        walker.walk(rewriteChecker, tree);

        // rewritable
        if (rewriteChecker.isRewritable()) {
            MyXQueryRewriter rewriter = new MyXQueryRewriter();
            rewriter.setJoinShapeFlag("L");
            if (bushyFlag)
                rewriter.setJoinShapeFlag("B");
            rewrite_output = (String) rewriter.visit(tree);
            System.out.println("******* Rewrite Result *******");
            System.out.println(rewrite_output);
            System.out.println("******************************\n");
        }
        // if not rewritable, rewrite result is original query.
        else {
            // System.out.println("----- Syntax is not rewritable -----");
            rewrite_output = "";
            int character;
            is = new FileInputStream(inputFile);
            while ((character = is.read()) != -1)
                rewrite_output += (char) character;
        }

        inputFile = "./rewrite_output.txt";
        FileWriter tempOutput;
        try {
            tempOutput = new FileWriter(inputFile, false);
        } catch (Exception e) {
            inputFile = "." + inputFile;
            tempOutput = new FileWriter(inputFile, false);
        }

        tempOutput.write(rewrite_output);
        tempOutput.close();

        // reading new input and lexing/parsing (from rewrite result)
        is = new FileInputStream(inputFile);
        input = new ANTLRInputStream(is);
        lexer = new XQueryLexer(input);
        tokens = new CommonTokenStream(lexer);
        parser = new XQueryParser(tokens);
        tree = parser.xq(); // check if syntax correct

        if (noEvalFlag)
            return;

        MyXQueryVisitor visitor = new MyXQueryVisitor();
        List<Node> result = (List<Node>) visitor.visit(tree);

        /* printing results */
        System.out.println("\nNumber of nodes: " + result.size());
        TreeNodePrinter printer = new TreeNodePrinter();
        for (Node node : result)
            printer.prettyPrint(node, "");


        /* writing evaluation result to file */
        FileWriter evalOutputFile;
        inputFile = "./eval_output.txt";
        try {
            evalOutputFile = new FileWriter(inputFile, false);
        } catch (Exception e) {
            inputFile = "." + inputFile;
            evalOutputFile = new FileWriter(inputFile, false);
        }
        evalOutputFile.write(""); // empty the file for new writing
        evalOutputFile.close();

        // write to file
        System.out.println("\n***** Rewrite output written in ``./rewrite_output.txt`` *****");
        System.out.println("***** Evaluation output written in ``./eval_output.txt`` *****\n");
        PrintStream fileOut = new PrintStream(inputFile);
        System.setOut(fileOut); // redirect output to file
        System.out.println("\nNumber of nodes: " + result.size());
        for (Node node : result)
            printer.prettyPrint(node, "");
    }
}


