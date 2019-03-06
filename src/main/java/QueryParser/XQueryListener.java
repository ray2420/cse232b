// Generated from C:/cse232b/23_CSE232BWI19/src/main/java/QueryParser\XQuery.g4 by ANTLR 4.7.2
package QueryParser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link XQueryParser}.
 */
public interface XQueryListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link XQueryParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(XQueryParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(XQueryParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code xqueryForClause}
	 * labeled alternative in {@link XQueryParser#xquery}.
	 * @param ctx the parse tree
	 */
	void enterXqueryForClause(XQueryParser.XqueryForClauseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code xqueryForClause}
	 * labeled alternative in {@link XQueryParser#xquery}.
	 * @param ctx the parse tree
	 */
	void exitXqueryForClause(XQueryParser.XqueryForClauseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code xqueryStringConstant}
	 * labeled alternative in {@link XQueryParser#xquery}.
	 * @param ctx the parse tree
	 */
	void enterXqueryStringConstant(XQueryParser.XqueryStringConstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code xqueryStringConstant}
	 * labeled alternative in {@link XQueryParser#xquery}.
	 * @param ctx the parse tree
	 */
	void exitXqueryStringConstant(XQueryParser.XqueryStringConstantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code priorityXquery}
	 * labeled alternative in {@link XQueryParser#xquery}.
	 * @param ctx the parse tree
	 */
	void enterPriorityXquery(XQueryParser.PriorityXqueryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code priorityXquery}
	 * labeled alternative in {@link XQueryParser#xquery}.
	 * @param ctx the parse tree
	 */
	void exitPriorityXquery(XQueryParser.PriorityXqueryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code xqueryRpChildren}
	 * labeled alternative in {@link XQueryParser#xquery}.
	 * @param ctx the parse tree
	 */
	void enterXqueryRpChildren(XQueryParser.XqueryRpChildrenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code xqueryRpChildren}
	 * labeled alternative in {@link XQueryParser#xquery}.
	 * @param ctx the parse tree
	 */
	void exitXqueryRpChildren(XQueryParser.XqueryRpChildrenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code xqueryAbsolutePath}
	 * labeled alternative in {@link XQueryParser#xquery}.
	 * @param ctx the parse tree
	 */
	void enterXqueryAbsolutePath(XQueryParser.XqueryAbsolutePathContext ctx);
	/**
	 * Exit a parse tree produced by the {@code xqueryAbsolutePath}
	 * labeled alternative in {@link XQueryParser#xquery}.
	 * @param ctx the parse tree
	 */
	void exitXqueryAbsolutePath(XQueryParser.XqueryAbsolutePathContext ctx);
	/**
	 * Enter a parse tree produced by the {@code twoXquery}
	 * labeled alternative in {@link XQueryParser#xquery}.
	 * @param ctx the parse tree
	 */
	void enterTwoXquery(XQueryParser.TwoXqueryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code twoXquery}
	 * labeled alternative in {@link XQueryParser#xquery}.
	 * @param ctx the parse tree
	 */
	void exitTwoXquery(XQueryParser.TwoXqueryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code xqueryRpAll}
	 * labeled alternative in {@link XQueryParser#xquery}.
	 * @param ctx the parse tree
	 */
	void enterXqueryRpAll(XQueryParser.XqueryRpAllContext ctx);
	/**
	 * Exit a parse tree produced by the {@code xqueryRpAll}
	 * labeled alternative in {@link XQueryParser#xquery}.
	 * @param ctx the parse tree
	 */
	void exitXqueryRpAll(XQueryParser.XqueryRpAllContext ctx);
	/**
	 * Enter a parse tree produced by the {@code xqueryTagName}
	 * labeled alternative in {@link XQueryParser#xquery}.
	 * @param ctx the parse tree
	 */
	void enterXqueryTagName(XQueryParser.XqueryTagNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code xqueryTagName}
	 * labeled alternative in {@link XQueryParser#xquery}.
	 * @param ctx the parse tree
	 */
	void exitXqueryTagName(XQueryParser.XqueryTagNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code xqueryVariable}
	 * labeled alternative in {@link XQueryParser#xquery}.
	 * @param ctx the parse tree
	 */
	void enterXqueryVariable(XQueryParser.XqueryVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code xqueryVariable}
	 * labeled alternative in {@link XQueryParser#xquery}.
	 * @param ctx the parse tree
	 */
	void exitXqueryVariable(XQueryParser.XqueryVariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code xqueryLetClause}
	 * labeled alternative in {@link XQueryParser#xquery}.
	 * @param ctx the parse tree
	 */
	void enterXqueryLetClause(XQueryParser.XqueryLetClauseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code xqueryLetClause}
	 * labeled alternative in {@link XQueryParser#xquery}.
	 * @param ctx the parse tree
	 */
	void exitXqueryLetClause(XQueryParser.XqueryLetClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(XQueryParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(XQueryParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#forclause}.
	 * @param ctx the parse tree
	 */
	void enterForclause(XQueryParser.ForclauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#forclause}.
	 * @param ctx the parse tree
	 */
	void exitForclause(XQueryParser.ForclauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#letclause}.
	 * @param ctx the parse tree
	 */
	void enterLetclause(XQueryParser.LetclauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#letclause}.
	 * @param ctx the parse tree
	 */
	void exitLetclause(XQueryParser.LetclauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#whereclause}.
	 * @param ctx the parse tree
	 */
	void enterWhereclause(XQueryParser.WhereclauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#whereclause}.
	 * @param ctx the parse tree
	 */
	void exitWhereclause(XQueryParser.WhereclauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#returnclause}.
	 * @param ctx the parse tree
	 */
	void enterReturnclause(XQueryParser.ReturnclauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#returnclause}.
	 * @param ctx the parse tree
	 */
	void exitReturnclause(XQueryParser.ReturnclauseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code conditionSome}
	 * labeled alternative in {@link XQueryParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterConditionSome(XQueryParser.ConditionSomeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code conditionSome}
	 * labeled alternative in {@link XQueryParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitConditionSome(XQueryParser.ConditionSomeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code conditionNot}
	 * labeled alternative in {@link XQueryParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterConditionNot(XQueryParser.ConditionNotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code conditionNot}
	 * labeled alternative in {@link XQueryParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitConditionNot(XQueryParser.ConditionNotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code conditionPriority}
	 * labeled alternative in {@link XQueryParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterConditionPriority(XQueryParser.ConditionPriorityContext ctx);
	/**
	 * Exit a parse tree produced by the {@code conditionPriority}
	 * labeled alternative in {@link XQueryParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitConditionPriority(XQueryParser.ConditionPriorityContext ctx);
	/**
	 * Enter a parse tree produced by the {@code conditionAnd}
	 * labeled alternative in {@link XQueryParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterConditionAnd(XQueryParser.ConditionAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code conditionAnd}
	 * labeled alternative in {@link XQueryParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitConditionAnd(XQueryParser.ConditionAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code conditionOr}
	 * labeled alternative in {@link XQueryParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterConditionOr(XQueryParser.ConditionOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code conditionOr}
	 * labeled alternative in {@link XQueryParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitConditionOr(XQueryParser.ConditionOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code conditionIsEmpty}
	 * labeled alternative in {@link XQueryParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterConditionIsEmpty(XQueryParser.ConditionIsEmptyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code conditionIsEmpty}
	 * labeled alternative in {@link XQueryParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitConditionIsEmpty(XQueryParser.ConditionIsEmptyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code conditionEqual}
	 * labeled alternative in {@link XQueryParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterConditionEqual(XQueryParser.ConditionEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code conditionEqual}
	 * labeled alternative in {@link XQueryParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitConditionEqual(XQueryParser.ConditionEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code conditionSame}
	 * labeled alternative in {@link XQueryParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterConditionSame(XQueryParser.ConditionSameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code conditionSame}
	 * labeled alternative in {@link XQueryParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitConditionSame(XQueryParser.ConditionSameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AbsolutePath}
	 * labeled alternative in {@link XQueryParser#query}.
	 * @param ctx the parse tree
	 */
	void enterAbsolutePath(XQueryParser.AbsolutePathContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AbsolutePath}
	 * labeled alternative in {@link XQueryParser#query}.
	 * @param ctx the parse tree
	 */
	void exitAbsolutePath(XQueryParser.AbsolutePathContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RelativePath}
	 * labeled alternative in {@link XQueryParser#query}.
	 * @param ctx the parse tree
	 */
	void enterRelativePath(XQueryParser.RelativePathContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RelativePath}
	 * labeled alternative in {@link XQueryParser#query}.
	 * @param ctx the parse tree
	 */
	void exitRelativePath(XQueryParser.RelativePathContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Filter}
	 * labeled alternative in {@link XQueryParser#query}.
	 * @param ctx the parse tree
	 */
	void enterFilter(XQueryParser.FilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Filter}
	 * labeled alternative in {@link XQueryParser#query}.
	 * @param ctx the parse tree
	 */
	void exitFilter(XQueryParser.FilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RpParent}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpParent(XQueryParser.RpParentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RpParent}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpParent(XQueryParser.RpParentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RpAttribute}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpAttribute(XQueryParser.RpAttributeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RpAttribute}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpAttribute(XQueryParser.RpAttributeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RpAllChildren}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpAllChildren(XQueryParser.RpAllChildrenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RpAllChildren}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpAllChildren(XQueryParser.RpAllChildrenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RpText}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpText(XQueryParser.RpTextContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RpText}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpText(XQueryParser.RpTextContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RpAll}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpAll(XQueryParser.RpAllContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RpAll}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpAll(XQueryParser.RpAllContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RpChildren}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpChildren(XQueryParser.RpChildrenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RpChildren}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpChildren(XQueryParser.RpChildrenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RpCurrent}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpCurrent(XQueryParser.RpCurrentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RpCurrent}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpCurrent(XQueryParser.RpCurrentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RpTwo}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpTwo(XQueryParser.RpTwoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RpTwo}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpTwo(XQueryParser.RpTwoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RpTag}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpTag(XQueryParser.RpTagContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RpTag}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpTag(XQueryParser.RpTagContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RpFirst}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpFirst(XQueryParser.RpFirstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RpFirst}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpFirst(XQueryParser.RpFirstContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RpFilter}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpFilter(XQueryParser.RpFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RpFilter}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpFilter(XQueryParser.RpFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FilterFirst}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void enterFilterFirst(XQueryParser.FilterFirstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FilterFirst}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void exitFilterFirst(XQueryParser.FilterFirstContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FilterEqual}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void enterFilterEqual(XQueryParser.FilterEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FilterEqual}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void exitFilterEqual(XQueryParser.FilterEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FilterNot}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void enterFilterNot(XQueryParser.FilterNotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FilterNot}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void exitFilterNot(XQueryParser.FilterNotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FilterOr}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void enterFilterOr(XQueryParser.FilterOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FilterOr}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void exitFilterOr(XQueryParser.FilterOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FilterAnd}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void enterFilterAnd(XQueryParser.FilterAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FilterAnd}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void exitFilterAnd(XQueryParser.FilterAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FilterRp}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void enterFilterRp(XQueryParser.FilterRpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FilterRp}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void exitFilterRp(XQueryParser.FilterRpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FilterIs}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void enterFilterIs(XQueryParser.FilterIsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FilterIs}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void exitFilterIs(XQueryParser.FilterIsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ApChildren}
	 * labeled alternative in {@link XQueryParser#ap}.
	 * @param ctx the parse tree
	 */
	void enterApChildren(XQueryParser.ApChildrenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ApChildren}
	 * labeled alternative in {@link XQueryParser#ap}.
	 * @param ctx the parse tree
	 */
	void exitApChildren(XQueryParser.ApChildrenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ApAll}
	 * labeled alternative in {@link XQueryParser#ap}.
	 * @param ctx the parse tree
	 */
	void enterApAll(XQueryParser.ApAllContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ApAll}
	 * labeled alternative in {@link XQueryParser#ap}.
	 * @param ctx the parse tree
	 */
	void exitApAll(XQueryParser.ApAllContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#fileName}.
	 * @param ctx the parse tree
	 */
	void enterFileName(XQueryParser.FileNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#fileName}.
	 * @param ctx the parse tree
	 */
	void exitFileName(XQueryParser.FileNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#tagName}.
	 * @param ctx the parse tree
	 */
	void enterTagName(XQueryParser.TagNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#tagName}.
	 * @param ctx the parse tree
	 */
	void exitTagName(XQueryParser.TagNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#attName}.
	 * @param ctx the parse tree
	 */
	void enterAttName(XQueryParser.AttNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#attName}.
	 * @param ctx the parse tree
	 */
	void exitAttName(XQueryParser.AttNameContext ctx);
}