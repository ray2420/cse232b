import QueryParser.XQuery;
import QueryParser.XQueryLexer;
import QueryParser.XQueryParser;
import QueryParser.XQueryRewriteVisitor;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runners.model.TestTimedOutException;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnitTest {


    public List<Node> executeQuery(String query){
        CharStream is = new ANTLRInputStream(query);
        XQueryLexer lexer = new XQueryLexer(is);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        XQueryParser parser = new XQueryParser(tokens);
        ParseTree queryTree = parser.prog();
        XQueryRewriteVisitor xpw = new XQueryRewriteVisitor();
        return xpw.visit(queryTree);
    }

    @Before
    @DisplayName("Executed before each test case.")
    public void start(){

    }

    @After
    @DisplayName("Executed after each test case.")
    public void end(){

    }

    @Test
    public void testAbsolutePath() {
        testApChildren();
        testApAll();
    }

    @Test
    public void testRelativePath(){
        List<Node> result = executeQuery("doc(j_caesar.xml)/PLAY");
        assertEquals("TITLE", result.get(0).getNodeName());
        assertEquals("Dramatis Personae", result.get(0).getTextContent());
    }

    public void testApChildren(){
        testRpFilter();
        List<Node> result2 = executeQuery("doc(j_caesar.xml)/LINE");
        assertEquals(0, result2.size());
        List<Node> result3 = executeQuery("doc(j_caesar.xml)/PLAY");
        assertEquals(1, result3.size());
    }

    public void testApAll(){
        List<Node> result = executeQuery("doc(j_caesar.xml)//SPEAKER");
        assertEquals(798, result.size());
        assertEquals("FLAVIUS", result.get(0).getTextContent());
        assertEquals("OCTAVIUS", result.get(result.size()-1).getTextContent());
    }

    @Test
    public void testRpChildren(){
        List<Node> result = executeQuery("doc(book.xml)/bib/book");
        assertEquals(4, result.size());
        assertEquals("TCP/IP IllustratedStevensW.Addison-Wesley65.95", result.get(0).getTextContent());
//        assertEquals("OCTAVIUS", result.get(result.size()-1).getTextContent());
    }

    @Test
    public void testRpTag(){

    }

    @Test
    public void testRpAllChildren(){
        List<Node> result = executeQuery("doc(book.xml)/bib/book//author");
        assertEquals(5, result.size());
        assertEquals("StevensW.", result.get(0).getTextContent());
    }

    @Test
    public void testRpCurrent(){
        List<Node> result = executeQuery("doc(book.xml)/bib/book/.");
        assertEquals(4, result.size());
        assertEquals("TCP/IP IllustratedStevensW.Addison-Wesley65.95", result.get(0).getTextContent());
    }

    @Test
    public void testRpParent(){
        List<Node> result = executeQuery("doc(book.xml)/bib/book/..");
        assertEquals(1, result.size());
        assertEquals("bib", result.get(0).getNodeName());
    }

    @Test
    public void testRpText(){
        List<Node> result = executeQuery("doc(book.xml)//publisher/text()");
        assertEquals(4, result.size());
        assertEquals("Addison-Wesley", result.get(0).getNodeValue());
        assertEquals(3,result.get(0).getNodeType());
    }

    @Test
    public void testRpAttribute(){
        List<Node> result = executeQuery("doc(book.xml)//book/@year");
        assertEquals(3, result.size());
        assertEquals("1994", result.get(0).getNodeValue());
    }

    @Test
    public void testRpFrist(){
        List<Node> result = executeQuery("doc(book.xml)//book/(author)");
        assertEquals(5 , result.size());
//        assertEquals("1994", result.get(0).getNodeValue();
    }

    @Test
    public void testRpFilter(){
        List<Node> result = executeQuery("doc(j_caesar.xml)/PLAY [TITLE and FM]");
        assertEquals("PLAY", result.get(0).getNodeName());
        assertEquals(1, result.size());
        List<Node> result2 = executeQuery("doc(j_caesar.xml)/PLAY [DOTA2 and FM]");
        assertEquals(0, result2.size());
    }

    @Test
    public void testRpTwo(){

    }

    @Test
    public void testRpFilterRp(){

    }

    @Test
    public void testRpFilterEqual(){

    }

    @Test
    public void testRpFilterIs(){

    }

    @Test
    public void testRpFilterFirst(){

    }

    @Test
    public void testRpFilterAnd(){

    }

    @Test
    public void testRpFilterOr(){

    }

    @Test
    public void testRpFilterNot(){

    }

    @Test
    public void testXqueryStringConstant(){
//        List<Node> result = executeQuery("for $x in doc(\"book.xml\")/bib/book return <title>{$x/title}<title>");
        List<Node> result = executeQuery("<result>{ " +
                "for $a in (for $s in doc(j_caesar.xml)//ACT " +
                "  return $s)" +
//                ",$sc in (for $t in $a/SCENE " +
//                "  return $t), " +
//                "$sp in (for $d in $sc/SPEECH " +
//                "  return $d) " +
//                "where $sp/LINE/text() = \"Et tu, Brute! Then fall, Caesar.\" " +
                "return <who>{" +
                "<when>{ " +
                "<act>{$a/TITLE/text()}</act>" +
//                "<scene>{$sc/TITLE/text()}</scene> " +
                "}</when> " +
                "} </result> ");
        assertEquals(1, result.size());
    }




}
