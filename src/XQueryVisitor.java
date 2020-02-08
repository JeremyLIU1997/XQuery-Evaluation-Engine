// Generated from XQuery.g4 by ANTLR 4.7.2
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
	 * Visit a parse tree produced by the {@code xq_str}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXq_str(XQueryParser.Xq_strContext ctx);
	/**
	 * Visit a parse tree produced by the {@code xq_slash_rp}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXq_slash_rp(XQueryParser.Xq_slash_rpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code xq_paren}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXq_paren(XQueryParser.Xq_parenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code xq_double_slash_rp}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXq_double_slash_rp(XQueryParser.Xq_double_slash_rpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code xq_ap}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXq_ap(XQueryParser.Xq_apContext ctx);
	/**
	 * Visit a parse tree produced by the {@code xq_var}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXq_var(XQueryParser.Xq_varContext ctx);
	/**
	 * Visit a parse tree produced by the {@code xq_FLWR}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXq_FLWR(XQueryParser.Xq_FLWRContext ctx);
	/**
	 * Visit a parse tree produced by the {@code xq_constructor}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXq_constructor(XQueryParser.Xq_constructorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code xq_let}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXq_let(XQueryParser.Xq_letContext ctx);
	/**
	 * Visit a parse tree produced by the {@code xq_comma}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXq_comma(XQueryParser.Xq_commaContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#forClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForClause(XQueryParser.ForClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#letClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetClause(XQueryParser.LetClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#whereClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhereClause(XQueryParser.WhereClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#returnClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnClause(XQueryParser.ReturnClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cond_and}
	 * labeled alternative in {@link XQueryParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond_and(XQueryParser.Cond_andContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cond_empty}
	 * labeled alternative in {@link XQueryParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond_empty(XQueryParser.Cond_emptyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cond_eq}
	 * labeled alternative in {@link XQueryParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond_eq(XQueryParser.Cond_eqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cond_is}
	 * labeled alternative in {@link XQueryParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond_is(XQueryParser.Cond_isContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cond_paren}
	 * labeled alternative in {@link XQueryParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond_paren(XQueryParser.Cond_parenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cond_some}
	 * labeled alternative in {@link XQueryParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond_some(XQueryParser.Cond_someContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cond_not}
	 * labeled alternative in {@link XQueryParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond_not(XQueryParser.Cond_notContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cond_or}
	 * labeled alternative in {@link XQueryParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond_or(XQueryParser.Cond_orContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ap_double_slash}
	 * labeled alternative in {@link XQueryParser#ap}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAp_double_slash(XQueryParser.Ap_double_slashContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ap_slash}
	 * labeled alternative in {@link XQueryParser#ap}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAp_slash(XQueryParser.Ap_slashContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rp_parent}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRp_parent(XQueryParser.Rp_parentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rp_tag}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRp_tag(XQueryParser.Rp_tagContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rp_anyTag}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRp_anyTag(XQueryParser.Rp_anyTagContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rp_double_slash}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRp_double_slash(XQueryParser.Rp_double_slashContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rp_comma}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRp_comma(XQueryParser.Rp_commaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rp_self}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRp_self(XQueryParser.Rp_selfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rp_text}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRp_text(XQueryParser.Rp_textContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rp_filter}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRp_filter(XQueryParser.Rp_filterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rp_paren}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRp_paren(XQueryParser.Rp_parenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rp_att}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRp_att(XQueryParser.Rp_attContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rp_slash}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRp_slash(XQueryParser.Rp_slashContext ctx);
	/**
	 * Visit a parse tree produced by the {@code f_not}
	 * labeled alternative in {@link XQueryParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitF_not(XQueryParser.F_notContext ctx);
	/**
	 * Visit a parse tree produced by the {@code f_paren}
	 * labeled alternative in {@link XQueryParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitF_paren(XQueryParser.F_parenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code f_or}
	 * labeled alternative in {@link XQueryParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitF_or(XQueryParser.F_orContext ctx);
	/**
	 * Visit a parse tree produced by the {@code f_and}
	 * labeled alternative in {@link XQueryParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitF_and(XQueryParser.F_andContext ctx);
	/**
	 * Visit a parse tree produced by the {@code f_rp}
	 * labeled alternative in {@link XQueryParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitF_rp(XQueryParser.F_rpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code f_eq}
	 * labeled alternative in {@link XQueryParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitF_eq(XQueryParser.F_eqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code f_is}
	 * labeled alternative in {@link XQueryParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitF_is(XQueryParser.F_isContext ctx);
}