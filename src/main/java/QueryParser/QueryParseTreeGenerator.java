package QueryParser;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class QueryParseTreeGenerator {

    String queryString;

    public QueryParseTreeGenerator(String queryString){
        this.queryString = queryString;
    }

    public QueryParseTreeGenerator(){
        this.queryString = "doc(sd.xml)/a/b/c";
    }

    public ParseTree generateParseTree(){
        CharStream charStream = CharStreams.fromString("doc(si.xml)/a/d/fd/c");
        XQueryLexer lexer = new XQueryLexer(charStream);
        XQueryParser parser = new XQueryParser(new CommonTokenStream(lexer));
        ParseTree parseTree  = parser.query();
        return parseTree;
    }
}
