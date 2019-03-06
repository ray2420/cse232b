package QueryParser;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.w3c.dom.Node;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class XQuery {
    public static void main(String[] args) throws IOException {
        String inputFile = null;
        inputFile = "./XPathTest.txt";
        InputStream is = System.in;
        if (inputFile!=null) is = new FileInputStream(inputFile);
        ANTLRInputStream input = new ANTLRInputStream(is);

        XQueryLexer lexer = new XQueryLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        XQueryParser parser = new XQueryParser(tokens);
        ParseTree tree = parser.prog();

        XQueryRewriteVisitor xpw = new XQueryRewriteVisitor();
//        XPathCustomizedVisitor eval = new XPathCustomizedVisitor();
        ArrayList<Node> finalResult = (ArrayList<Node>) xpw.visit(tree);
//
//        System.out.println("finalResult size: " + finalResult.size());
        for(Node n:finalResult) {
            System.out.println(n.getNodeName());
        }
    }
}