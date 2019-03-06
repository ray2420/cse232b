import QueryParser.XQueryLexer;
import QueryParser.XQueryParser;
import QueryParser.XQueryRewriteVisitor;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static List<Node> executeQuery(String query){
        CharStream is = new ANTLRInputStream(query);
        XQueryLexer lexer = new XQueryLexer(is);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        XQueryParser parser = new XQueryParser(tokens);
        ParseTree queryTree = parser.prog();
        XQueryRewriteVisitor xpw = new XQueryRewriteVisitor();
        return xpw.visit(queryTree);
    }
    public static String txt2String(File file){
        StringBuilder result = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                result.append(System.lineSeparator()+s);
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return result.toString();
    }
    public static void main(String[] args) throws Exception{
        List<Node> result = new ArrayList<>();

        String inputFile = "test.txt";
//        File f = new File(inputFile);
//        String input = txt2String(f);
//        System.out.println(input);
//        System.out.println();
//        result = executeQuery(input);
        result = executeQuery("<result>{\n" +
                "for $s in doc(\"j_caesar.xml\")//SCENE \n" +
                "where $s//SPEAKER/text()=\"CAESAR\"\n" +
                "return \n" +
                "<scenes> { <scene> {$s/TITLE/text()} </scene>,\n" +
                "for $a in doc(\"j_caesar.xml\")//ACT\n" +
                "where some $s1 in (for $x in $a//SCENE where $x/TITLE/text()=\"SCENE II.  A public place.\" return $x) satisfies $s1 eq $s and$a/TITLE/text() = \"ACT I\"\n" +
                "return <act>\n" +
                "{$a/TITLE/text()}\n" +
                "</act>\n" +
                "}\n" +
                "</scenes>\n" +
                "}\n" +
                "</result>");
//        result = executeQuery("<result> { \n" +
//                "for $a in doc(\"j_caesar.xml\")//PERSONAE, $b in $a/PERSONA \n" +
//                "where not (($b/text() = \"JULIUS CAESAR\") or ($b/text() = \"Another Poet\") ) \n" +
//                "return $b \n" +
//                "} </result> \n");
        DocumentBuilderFactory Factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder Builder = Factory.newDocumentBuilder();
        Document doc = Builder.newDocument();
        Node top = doc.createElement("RESULT");
        doc.appendChild(top);

        for (Node n:result){
            Element node = createNewElement(doc,n);
            top.appendChild(node);
        }

        TransformerFactory tFactory =
                TransformerFactory.newInstance();
        Transformer transformer =
                tFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        DOMSource source = new DOMSource(top);
        StreamResult sr = new StreamResult(new File("out.xml"));
        transformer.transform(source, sr);
        transformer.transform(source, new StreamResult(System.out));


    }

    public static Element createNewElement(Document doc, Node node){
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = doc.createElement(node.getNodeName());
            NodeList tmp = node.getChildNodes();
            for (int i = 0; i < tmp.getLength(); i++) {
                if (tmp.item(i).getNodeType() == Node.TEXT_NODE) {
                    Node txt = doc.createTextNode(tmp.item(i).getNodeValue());
                    element.appendChild(txt);
                } else element.appendChild(createNewElement(doc, tmp.item(i)));
            }
            return element;
        }
        return null;
    }
}
