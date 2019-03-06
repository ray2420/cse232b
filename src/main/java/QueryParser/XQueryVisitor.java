// Generated from C:/cse232b/23_CSE232BWI19/src/main/java/QueryParser\XQuery.g4 by ANTLR 4.7.2
package QueryParser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link XQueryParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface XQueryVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link XQueryParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(XQueryParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code xqueryForClause}
	 * labeled alternative in {@link XQueryParser#xquery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXqueryForClause(XQueryParser.XqueryForClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code xqueryStringConstant}
	 * labeled alternative in {@link XQueryParser#xquery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXqueryStringConstant(XQueryParser.XqueryStringConstantContext ctx);
	/**
	 * Visit a parse tree produced by the {@code priorityXquery}
	 * labeled alternative in {@link XQueryParser#xquery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPriorityXquery(XQueryParser.PriorityXqueryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code xqueryRpChildren}
	 * labeled alternative in {@link XQueryParser#xquery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXqueryRpChildren(XQueryParser.XqueryRpChildrenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code xqueryAbsolutePath}
	 * labeled alternative in {@link XQueryParser#xquery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXqueryAbsolutePath(XQueryParser.XqueryAbsolutePathContext ctx);
	/**
	 * Visit a parse tree produced by the {@code twoXquery}
	 * labeled alternative in {@link XQueryParser#xquery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTwoXquery(XQueryParser.TwoXqueryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code xqueryRpAll}
	 * labeled alternative in {@link XQueryParser#xquery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXqueryRpAll(XQueryParser.XqueryRpAllContext ctx);
	/**
	 * Visit a parse tree produced by the {@code xqueryTagName}
	 * labeled alternative in {@link XQueryParser#xquery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXqueryTagName(XQueryParser.XqueryTagNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code xqueryVariable}
	 * labeled alternative in {@link XQueryParser#xquery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXqueryVariable(XQueryParser.XqueryVariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code xqueryLetClause}
	 * labeled alternative in {@link XQueryParser#xquery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXqueryLetClause(XQueryParser.XqueryLetClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(XQueryParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#forclause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForclause(XQueryParser.ForclauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#letclause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetclause(XQueryParser.LetclauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#whereclause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhereclause(XQueryParser.WhereclauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#returnclause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnclause(XQueryParser.ReturnclauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code conditionSome}
	 * labeled alternative in {@link XQueryParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionSome(XQueryParser.ConditionSomeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code conditionNot}
	 * labeled alternative in {@link XQueryParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionNot(XQueryParser.ConditionNotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code conditionPriority}
	 * labeled alternative in {@link XQueryParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionPriority(XQueryParser.ConditionPriorityContext ctx);
	/**
	 * Visit a parse tree produced by the {@code conditionAnd}
	 * labeled alternative in {@link XQueryParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionAnd(XQueryParser.ConditionAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code conditionOr}
	 * labeled alternative in {@link XQueryParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionOr(XQueryParser.ConditionOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code conditionIsEmpty}
	 * labeled alternative in {@link XQueryParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionIsEmpty(XQueryParser.ConditionIsEmptyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code conditionEqual}
	 * labeled alternative in {@link XQueryParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionEqual(XQueryParser.ConditionEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code conditionSame}
	 * labeled alternative in {@link XQueryParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionSame(XQueryParser.ConditionSameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AbsolutePath}
	 * labeled alternative in {@link XQueryParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAbsolutePath(XQueryParser.AbsolutePathContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RelativePath}
	 * labeled alternative in {@link XQueryParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelativePath(XQueryParser.RelativePathContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Filter}
	 * labeled alternative in {@link XQueryParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilter(XQueryParser.FilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RpParent}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpParent(XQueryParser.RpParentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RpAttribute}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpAttribute(XQueryParser.RpAttributeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RpAllChildren}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpAllChildren(XQueryParser.RpAllChildrenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RpText}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpText(XQueryParser.RpTextContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RpAll}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpAll(XQueryParser.RpAllContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RpChildren}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpChildren(XQueryParser.RpChildrenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RpCurrent}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpCurrent(XQueryParser.RpCurrentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RpTwo}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpTwo(XQueryParser.RpTwoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RpTag}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpTag(XQueryParser.RpTagContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RpFirst}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpFirst(XQueryParser.RpFirstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RpFilter}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpFilter(XQueryParser.RpFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FilterFirst}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilterFirst(XQueryParser.FilterFirstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FilterEqual}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilterEqual(XQueryParser.FilterEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FilterNot}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilterNot(XQueryParser.FilterNotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FilterOr}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilterOr(XQueryParser.FilterOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FilterAnd}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilterAnd(XQueryParser.FilterAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FilterRp}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilterRp(XQueryParser.FilterRpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FilterIs}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilterIs(XQueryParser.FilterIsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ApChildren}
	 * labeled alternative in {@link XQueryParser#ap}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApChildren(XQueryParser.ApChildrenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ApAll}
	 * labeled alternative in {@link XQueryParser#ap}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApAll(XQueryParser.ApAllContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#fileName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFileName(XQueryParser.FileNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#tagName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagName(XQueryParser.TagNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#attName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttName(XQueryParser.AttNameContext ctx);
}