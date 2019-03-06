package QueryParser;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.*;

public class XQueryRewriteVisitor extends XQueryBaseVisitor<List<Node>> {
    private List<Node> visitRes = new ArrayList<>();

    private HashMap<String, ArrayList<Node>> context = new HashMap<>();
    private Stack<HashMap<String,ArrayList<Node>>> contextHistory = new Stack<>();
    private Document documentInput = null;
    private Document documentResult = null;


    private ArrayList<Node> getNodeChildren(Node root){
        ArrayList<Node> res = new ArrayList<>();
        for(int i = 0;i < root.getChildNodes().getLength();i++ ){
            res.add(root.getChildNodes().item(i));
        }
        return res;
    }

    @Override
    public List<Node> visitConditionPriority(XQueryParser.ConditionPriorityContext ctx) {
        List<Node> res = visit(ctx.condition());
        return res;
    }


    @Override
    public List<Node> visitProg(XQueryParser.ProgContext ctx) {
        return visit(ctx.xquery());
    }

    @Override
    public List<Node> visitXqueryVariable(XQueryParser.XqueryVariableContext ctx) {
        return new ArrayList<>(context.getOrDefault(ctx.var().getText(),new ArrayList<>()));
        //find in context. return empty list if not found必须新建一个List直接返回后面context会乱
    }

    @Override
    /**
     *  using input document to create new text node;
     */
    public List<Node> visitXqueryStringConstant(XQueryParser.XqueryStringConstantContext ctx) {
        String text = ctx.Stringconstant().getText();
        text = text.substring(1,text.length()-1);
        ArrayList<Node> res = new ArrayList<>();
        res.add(createTextNode(text));
        return res;

    }

    /**
     *
     * @param text
     *
     * create new text node
     * @return new text node
     */
    public Node createTextNode(String text){
        return documentInput.createTextNode(text);
    }

    @Override
    public List<Node> visitXqueryAbsolutePath(XQueryParser.XqueryAbsolutePathContext ctx) {
        return visit(ctx.ap());
    }

    @Override
    public List<Node> visitPriorityXquery(XQueryParser.PriorityXqueryContext ctx) {
        return visit(ctx.xquery());
    }

    /**
     *
     * @param ctx
     *
     * backup context before visiting next xquery and restore the context after visiting
     * @return
     */
    @Override
    public List<Node> visitTwoXquery(XQueryParser.TwoXqueryContext ctx) {
        contextHistory.push(new HashMap<>(context));
        ArrayList<Node> backupRes = new ArrayList<>(visitRes);
        List<Node> result = visit(ctx.xquery(0));
        context = contextHistory.peek();
        visitRes = backupRes;
        List<Node> res2 = visit(ctx.xquery(1));
        result.addAll(res2);
        context = contextHistory.pop();
        visitRes = result;
        return result;
    }

    @Override
    // not sure
    public List<Node> visitXqueryRpChildren(XQueryParser.XqueryRpChildrenContext ctx) {
        List<Node> tmp = visit(ctx.xquery());
//        List<Node> res = new ArrayList<>();
//        for(Node child:tmp){
//            for(int i = 0;i<child.getChildNodes().getLength();i++){
//
//            }
//        }
        visitRes = tmp;
        return visit(ctx.rp());
    }
    //slightly different from visitRpAll since visit xquery sometimes doesn't change visitRes

    @Override
    public List<Node> visitXqueryRpAll(XQueryParser.XqueryRpAllContext ctx) {
        Queue<Node> queue = new LinkedList<>();
        List<Node> res = visit(ctx.xquery());
        ArrayList<Node> result = new ArrayList<>(res);
        ((LinkedList<Node>) queue).addAll(res);
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            for(int i = 0;i<cur.getChildNodes().getLength();i++){
                Node child = cur.getChildNodes().item(i);
                result.add(child);
                queue.offer(child);
            }
        }
        visitRes = result;
        return visit(ctx.rp());
    }



    public static Node cloneNode(Document doc, Node node){
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = doc.createElement(node.getNodeName());
            NodeList tmp = node.getChildNodes();
            for (int i = 0; i < tmp.getLength(); i++) {
                if (tmp.item(i).getNodeType() == Node.TEXT_NODE) {
                    Node txt = doc.createTextNode(tmp.item(i).getNodeValue());
                    element.appendChild(txt);
                } else element.appendChild(cloneNode(doc, tmp.item(i)));
            }
            return element;
        }else if(node.getNodeType() == Node.TEXT_NODE){
            Node txt = doc.createTextNode(node.getNodeValue());
            return txt;
        }
        return null;
    }

    public Node createNode(String tagName,List<Node> inputNodes){
        Node output = documentResult.createElement(tagName);
        for(Node node:inputNodes){
            if(node!=null){
                output.appendChild(cloneNode(documentResult,node));
            }
        }
        return output;
    }

    @Override
    public List<Node> visitForclause(XQueryParser.ForclauseContext ctx) {
        List<Node> result = new ArrayList<>(forClauseHelper(0,ctx));
        return result;
    }
    public List<Node> forClauseHelper(int index,XQueryParser.ForclauseContext ctx){
        List<Node> result = new ArrayList<>();
        List<Node> xqueryResult = visit(ctx.xquery(index));
        if(index == ctx.var().size()-1){   //the last "var in xquery"
            return xqueryResult;
        }
        for(Node node:xqueryResult){
            contextHistory.push(new HashMap<>(context));
            ArrayList<Node> curVarContext = new ArrayList<>();
            curVarContext.add(node);
            context.put(ctx.var(index).getText(),curVarContext);
            result.addAll(forClauseHelper(index+1,ctx));
            context = contextHistory.pop();
        }
        return result;

    }

    @Override
    public List<Node> visitLetclause(XQueryParser.LetclauseContext ctx) {
        for(int i = 0;i<ctx.var().size();i++){
            ArrayList<Node> res =(ArrayList<Node>)visit(ctx.xquery(i));
            context.put(ctx.var(i).getText(),res);
//            System.out.println(res.size());
        }
        return null;
    }

    @Override
    public List<Node> visitWhereclause(XQueryParser.WhereclauseContext ctx) {
        List<Node> res = visit(ctx.condition());
        return res;
    }

    @Override
    public List<Node> visitReturnclause(XQueryParser.ReturnclauseContext ctx) {
        return visit(ctx.xquery());
    }


    @Override
    public List<Node> visitXqueryForClause(XQueryParser.XqueryForClauseContext ctx) {

        return xqueryForClauseHelper(0,ctx);
    }
    public List<Node> xqueryForClauseHelper(int index,XQueryParser.XqueryForClauseContext ctx){
        List<Node> result = new ArrayList<>();

        if(index == ctx.forclause().var().size()){   //end of for, consider the where, let, return clause
            contextHistory.push(new HashMap<>(context));
            if(ctx.letclause()!=null){
                visit(ctx.letclause());
            }
            if(ctx.whereclause()!=null){
                List<Node> whereRes = visit(ctx.whereclause());
                if(whereRes.size() == 0){ //not sure.if no node satisfies where, directly return empty list;
                    context = contextHistory.pop();
                    return result;
                }
            }
            if(ctx.returnclause()!=null){
                    List<Node> returnRes = visit(ctx.returnclause());
                    result.addAll(returnRes);
//                    System.out.println(returnRes.size());
            }


            context = contextHistory.pop();
            return result;

        }else{
            List<Node> xqueryResult = visit(ctx.forclause().xquery(index));
            for(Node node:xqueryResult){
                contextHistory.push(new HashMap<>(context));
                ArrayList<Node> curVarContext = new ArrayList<>();
                curVarContext.add(node);
                String var = ctx.forclause().var(index).getText();
                context.put(var,curVarContext);
                List<Node> helperRes = xqueryForClauseHelper(index+1,ctx);
                result.addAll(helperRes);
                context = contextHistory.pop();
            }

        }
        return result;

    }



    @Override
    public List<Node> visitXqueryLetClause(XQueryParser.XqueryLetClauseContext ctx) {
        contextHistory.push(new HashMap<>(context));
        visit(ctx.letclause());
        List<Node> res = visit(ctx.xquery());
        context = contextHistory.pop();
        return res;
    }

    @Override
    public List<Node> visitXqueryTagName(XQueryParser.XqueryTagNameContext ctx) {
        if(documentResult == null){
            try {
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                documentResult = db.newDocument();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        List<Node> result = new ArrayList<>();
        result.add(createNode(ctx.tagName(0).getText(),visit(ctx.xquery())));
        return result;
    }

    @Override
    public List<Node> visitConditionEqual(XQueryParser.ConditionEqualContext ctx) {
        List<Node> tmp1;
        List<Node> tmp2;
        contextHistory.push(new HashMap<>(context));
        List<Node> visitResBack = new ArrayList<>(visitRes);
        tmp1 = visit(ctx.xquery(0));
        context = contextHistory.peek();
        visitRes = visitResBack;
        tmp2 = visit(ctx.xquery(1));
        context = contextHistory.pop();
        visitRes = visitResBack;
        List<Node> bool = new ArrayList<>();
        for(Node n1:tmp1){
            for(Node n2:tmp2){
                if(n1.isEqualNode(n2)){
                    bool.add(n1);
                    return bool;
                }
            }
        }
        return bool;

    }

    @Override
    public List<Node> visitConditionSame(XQueryParser.ConditionSameContext ctx) {
        List<Node> tmp1;
        List<Node> tmp2;
        contextHistory.push(new HashMap<>(context));
        List<Node> visitResBack = new ArrayList<>(visitRes);
        tmp1 = visit(ctx.xquery(0));
        context = contextHistory.peek();
        visitRes = visitResBack;
        tmp2 = visit(ctx.xquery(1));
        context = contextHistory.pop();
        visitRes = visitResBack;
        List<Node> bool = new ArrayList<>();
        for(Node n1:tmp1){
            for(Node n2:tmp2){
                if(n1.isSameNode(n2)){
                    bool.add(n1);
                    return bool;
                }
            }
        }
        return bool;
    }
    // not sure whether needs to backup the context in not,empty,and,or
    @Override
    public List<Node> visitConditionIsEmpty(XQueryParser.ConditionIsEmptyContext ctx) {

        List<Node> bool = new ArrayList<>();

        if(visit(ctx.xquery()).isEmpty()){
            bool.add(null);
        }
        return bool;
    }

    @Override
    public List<Node> visitConditionAnd(XQueryParser.ConditionAndContext ctx) {
        List<Node> tmp1 = visit(ctx.condition(0));
        List<Node> tmp2 = visit(ctx.condition(1));
        List<Node> bool = new ArrayList<>();
        if(tmp1.size()!=0 && tmp2.size()!=0){
            bool.add(null);
        }
        return bool;
    }

    @Override
    public List<Node> visitConditionOr(XQueryParser.ConditionOrContext ctx) {
        List<Node> tmp1 = visit(ctx.condition(0));
        List<Node> tmp2 = visit(ctx.condition(1));
        List<Node> bool = new ArrayList<>();
        if(tmp1.size()!=0 || tmp2.size()!=0){
            bool.add(null);
        }
        return bool;
    }

    @Override
    public List<Node> visitConditionNot(XQueryParser.ConditionNotContext ctx) {
        List<Node> res = visit(ctx.condition());
        List<Node> bool = new ArrayList<>();
        if(res.size() == 0){
            bool.add(null);
        }
        return bool;
    }

    @Override
    public List<Node> visitConditionSome(XQueryParser.ConditionSomeContext ctx) {
        contextHistory.push(new HashMap<>(context));
        for(int i =0;i<ctx.var().size();i++){
            String var = ctx.var(i).getText();
            List<Node> varList = visit(ctx.xquery(i));
            context.put(var,(ArrayList<Node>)varList);
        }
        List<Node> result = visit(ctx.condition());
        context = contextHistory.pop();
        return result;
    }

    @Override
    public List<Node> visitFileName(XQueryParser.FileNameContext ctx) {
        String fileName = ctx.getText();
        File xmlInputFile = new File(fileName);
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setIgnoringComments(false);
        dbf.setIgnoringElementContentWhitespace(false);
        dbf.setCoalescing(false);
        dbf.setExpandEntityReferences(true);
        DocumentBuilder db = null;

        ArrayList<Node> res = new ArrayList<>();
        try{
            db = dbf.newDocumentBuilder();
            if(db!=null){
                documentInput = db.parse(xmlInputFile);

            }
            if(documentInput !=null){
                documentInput.getDocumentElement().normalize();
            }
            res.add(documentInput);
            visitRes = res;

        }catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public List<Node> visitApChildren(XQueryParser.ApChildrenContext ctx) {
        List<Node> res = new ArrayList<>();
        visit(ctx.fileName());
        res = visit(ctx.rp());
        visitRes = res;
        return res;
    }

    @Override
    public List<Node> visitApAll(XQueryParser.ApAllContext ctx) {
        Queue<Node> queue = new LinkedList<>();

        visit(ctx.fileName());
        queue.addAll(visitRes);
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            for(int i = 0;i<cur.getChildNodes().getLength();i++){
                Node child = cur.getChildNodes().item(i);
                visitRes.add(child);
                queue.offer(child);
            }
        }
        List<Node> res = visit(ctx.rp());
        return res;

    }

    @Override
    public List<Node> visitRpTag(XQueryParser.RpTagContext ctx) {
        List<Node> res = new ArrayList<>();
        for(Node node : visitRes){
            for(int i = 0;i<node.getChildNodes().getLength();i++){
                Node child= node.getChildNodes().item(i);
                if(child.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) child;
//                    if(ctx.tagName().getText().equals("SCENE")){
//                        System.out.println(element.getTagName().equals(ctx.tagName().getText()));
//                    }
                    if (element.getTagName().equals(ctx.tagName().getText())){
                        res.add(child);
                    }
                }
            }
        }
        visitRes = res;
        return res;
    }

    @Override
    public List<Node> visitRpChildren(XQueryParser.RpChildrenContext ctx) {
        visit(ctx.rp().get(0));
        visit(ctx.rp().get(1));
        return visitRes;
    }

    @Override
    public List<Node> visitRpAllChildren(XQueryParser.RpAllChildrenContext ctx) {
        List<Node> res = new ArrayList<>();
        for(Node node : visitRes){
            for(int i = 0;i<node.getChildNodes().getLength();i++){
                Node child= node.getChildNodes().item(i);
                if(child.getNodeType() != Node.TEXT_NODE && child.getNodeType() != Node.ATTRIBUTE_NODE){
                    res.add(child);
                }
            }
        }
        visitRes = res;
        return res;
    }

    @Override
    public List<Node> visitRpCurrent(XQueryParser.RpCurrentContext ctx) {
        return visitRes;
    }

    @Override
    public List<Node> visitRpParent(XQueryParser.RpParentContext ctx) {
        List<Node> res = new ArrayList<>();
        for(Node n: visitRes){
            Node p = null;
            if(n.getNodeType() == Node.ATTRIBUTE_NODE ){
                p = ((Attr)n).getOwnerElement();
            }else{
                p = n.getParentNode();
            }
            if(!res.contains(p)){
                res.add(p);
            }
        }
        visitRes = res;
        return res;
    }

    @Override
    public List<Node> visitRpText(XQueryParser.RpTextContext ctx) {
        List<Node> res = new ArrayList<>();
        for(Node n: visitRes){
            if(n.getChildNodes().getLength() == 1 && n.getChildNodes().item(0).getNodeType() == Node.TEXT_NODE ){
                String val = n.getFirstChild().getNodeValue();
                if(!val.equals("\n") && val.length()>0){
                    res.add(n.getFirstChild());
                }
            }
        }
        visitRes = res;
        return res;
    }

    @Override
    public List<Node> visitRpAttribute(XQueryParser.RpAttributeContext ctx) {
        List<Node> res = new ArrayList<>();
        for(Node n: visitRes){
            if(n.getNodeType()== Node.ELEMENT_NODE){
                Attr attr = ((Element)n).getAttributeNode(ctx.attName().getText());
                if(attr!=null){
                    res.add(attr);
                }
            }
        }
        visitRes = res;
        return res;
    }

    @Override
    public List<Node> visitRpFirst(XQueryParser.RpFirstContext ctx) {
        return visit(ctx.rp());
    }



    @Override
    public List<Node> visitRpAll(XQueryParser.RpAllContext ctx) {
        Queue<Node> queue = new LinkedList<>();

        visit(ctx.rp().get(0));

        ((LinkedList<Node>) queue).addAll(visitRes);
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            for(int i = 0;i<cur.getChildNodes().getLength();i++){
                Node child = cur.getChildNodes().item(i);
                visitRes.add(child);
                queue.offer(child);
            }
        }
        return visit(ctx.rp().get(1));
    }

    @Override
    public List<Node> visitRpTwo(XQueryParser.RpTwoContext ctx) {
        List<Node> tmp1;
        List<Node> tmp2;
        List<Node> visitResBack = new ArrayList<>(visitRes);
        tmp1 = visit(ctx.rp(0));
        visitRes = visitResBack;
        tmp2 = visit(ctx.rp(1));
        tmp1.addAll(tmp2);
        visitRes = tmp1;
        return tmp1;
    }

    @Override
    public List<Node> visitFilterRp(XQueryParser.FilterRpContext ctx) {
        List<Node> bool;
        List<Node> visitResBack = new ArrayList<>(visitRes);
        bool = visit(ctx.rp());
        visitRes = visitResBack;
        return bool;
    }

    @Override
    public List<Node> visitFilterEqual(XQueryParser.FilterEqualContext ctx) {
        List<Node> tmp1;
        List<Node> tmp2;
        List<Node> visitResBack = new ArrayList<>(visitRes);
        tmp1 = visit(ctx.rp(0));
        visitRes = visitResBack;
        tmp2 = visit(ctx.rp(1));
        visitRes = visitResBack;
        List<Node> bool = new ArrayList<>();
        for(Node n1:tmp1){
            for(Node n2:tmp2){
                if(n1.isEqualNode(n2)){
                    bool.add(null);
                }
            }
        }
        return bool;
    }

    @Override
    public List<Node> visitFilterIs(XQueryParser.FilterIsContext ctx) {
        List<Node> tmp1 = new ArrayList<>();
        List<Node> tmp2 = new ArrayList<>();
        List<Node> visitResBack = new ArrayList<>(visitRes);
        tmp1 = visit(ctx.rp(0));
        visitRes = visitResBack;
        tmp2 = visit(ctx.rp(1));
        visitRes = visitResBack;
        List<Node> bool = new ArrayList<>();
        for(Node n1:tmp1){
            for(Node n2:tmp2){
                if(n1.isSameNode(n2)){
                    bool.add(null);
                }
            }
        }
        return bool;
    }

    @Override
    public List<Node> visitFilterFirst(XQueryParser.FilterFirstContext ctx) {
        return visit(ctx.f());
    }

    @Override
    public List<Node> visitFilterNot(XQueryParser.FilterNotContext ctx) {
        List<Node> res = visit(ctx.f());
        List<Node> bool = new ArrayList<>();
        if(res.size() == 0){
            bool.add(null);
        }
        return bool;

    }

    @Override
    public List<Node> visitFilterAnd(XQueryParser.FilterAndContext ctx) {
        List<Node> tmp1 = visit(ctx.f(0));
        List<Node> tmp2 = visit(ctx.f(1));
        List<Node> bool = new ArrayList<>();
        if(tmp1.size()!=0 && tmp2.size()!=0){
            bool.add(null);
        }
        return bool;
    }

    @Override
    public List<Node> visitFilterOr(XQueryParser.FilterOrContext ctx) {
        List<Node> tmp1 = visit(ctx.f(0));
        List<Node> tmp2 = visit(ctx.f(1));
        List<Node> bool = new ArrayList<>();
        if(tmp1.size()!=0 || tmp2.size()!=0){
            bool.add(null);
        }
        return bool;
    }


    @Override
    public List<Node> visitRpFilter(XQueryParser.RpFilterContext ctx){
        visitRes = visit(ctx.rp());
//        List<Node> res = visit(ctx.rp());
        List<Node> backup = new ArrayList<>(visitRes);
        List<Node> res = new ArrayList<>();
        for(Node node: backup){
            visitRes = new ArrayList<>();
            visitRes.add(node);
            if(visit(ctx.f()).size()>0){
                res.add(node);
            }
        }

        visitRes = res;
        return visitRes;

    }
}
