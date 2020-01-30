import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.w3c.dom.Node;

import java.util.*;

import java.io.FileInputStream;
import java.io.InputStream;



public class Main {
    public static void main(String[] args) throws Exception {
        String inputFile = null;
        if (args.length > 0)
            inputFile = args[0];
        InputStream is = System.in;
        if (inputFile != null)
            is = new FileInputStream(inputFile); // throws FIleNotFound

        // reading input and lexing/parsing
        ANTLRInputStream input = new ANTLRInputStream(is);
        XQueryLexer lexer = new XQueryLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        XQueryParser parser = new XQueryParser(tokens);
        ParseTree tree = parser.ap();

        // create my custom visitor
        MyXQueryVisitor visitor = new MyXQueryVisitor();

        List<Node> result = (List<Node>)visitor.visit(tree);
        System.out.println("\nNumber of nodes: " + result.size());
        System.out.println(result);
    }
}
