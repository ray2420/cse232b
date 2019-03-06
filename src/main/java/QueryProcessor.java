import QueryParser.QueryParseTreeGenerator;
import XmlParser.XmlParserGenerator;
import org.antlr.v4.runtime.tree.ParseTree;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class QueryProcessor {

    ParseTree queryTree;
    Document xmlDoc;

    public QueryProcessor(ParseTree queryTree, Document xmlDoc){
        this.queryTree = queryTree;
        this.xmlDoc = xmlDoc;
    }

    public Node eval() {
        return xmlDoc;
    }


    public static void main(String[] args) throws Exception{
        XmlParserGenerator xmlParserGenerator = new XmlParserGenerator("j_caesar.xml");
        Document docTree = xmlParserGenerator.generateParser();
//        ParseTree queryTree = new QueryParseTreeGenerator().generateParseTree();
//        Node queryResultNodes = new QueryProcessor(queryTree, docTree).eval();
        xmlParserGenerator.echo(docTree);
    }

}
