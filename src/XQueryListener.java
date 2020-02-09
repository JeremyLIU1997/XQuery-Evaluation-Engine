// Generated from XQuery.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link XQueryParser}.
 */
public interface XQueryListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code xq_str}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXq_str(XQueryParser.Xq_strContext ctx);
	/**
	 * Exit a parse tree produced by the {@code xq_str}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXq_str(XQueryParser.Xq_strContext ctx);
	/**
	 * Enter a parse tree produced by the {@code xq_slash_rp}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXq_slash_rp(XQueryParser.Xq_slash_rpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code xq_slash_rp}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXq_slash_rp(XQueryParser.Xq_slash_rpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code xq_paren}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXq_paren(XQueryParser.Xq_parenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code xq_paren}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXq_paren(XQueryParser.Xq_parenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code xq_double_slash_rp}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXq_double_slash_rp(XQueryParser.Xq_double_slash_rpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code xq_double_slash_rp}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXq_double_slash_rp(XQueryParser.Xq_double_slash_rpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code xq_ap}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXq_ap(XQueryParser.Xq_apContext ctx);
	/**
	 * Exit a parse tree produced by the {@code xq_ap}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXq_ap(XQueryParser.Xq_apContext ctx);
	/**
	 * Enter a parse tree produced by the {@code xq_var}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXq_var(XQueryParser.Xq_varContext ctx);
	/**
	 * Exit a parse tree produced by the {@code xq_var}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXq_var(XQueryParser.Xq_varContext ctx);
	/**
	 * Enter a parse tree produced by the {@code xq_FLWR}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXq_FLWR(XQueryParser.Xq_FLWRContext ctx);
	/**
	 * Exit a parse tree produced by the {@code xq_FLWR}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXq_FLWR(XQueryParser.Xq_FLWRContext ctx);
	/**
	 * Enter a parse tree produced by the {@code xq_constructor}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXq_constructor(XQueryParser.Xq_constructorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code xq_constructor}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXq_constructor(XQueryParser.Xq_constructorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code xq_let}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXq_let(XQueryParser.Xq_letContext ctx);
	/**
	 * Exit a parse tree produced by the {@code xq_let}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXq_let(XQueryParser.Xq_letContext ctx);
	/**
	 * Enter a parse tree produced by the {@code xq_comma}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXq_comma(XQueryParser.Xq_commaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code xq_comma}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXq_comma(XQueryParser.Xq_commaContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#stringconst}.
	 * @param ctx the parse tree
	 */
	void enterStringconst(XQueryParser.StringconstContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#stringconst}.
	 * @param ctx the parse tree
	 */
	void exitStringconst(XQueryParser.StringconstContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#forClause}.
	 * @param ctx the parse tree
	 */
	void enterForClause(XQueryParser.ForClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#forClause}.
	 * @param ctx the parse tree
	 */
	void exitForClause(XQueryParser.ForClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#letClause}.
	 * @param ctx the parse tree
	 */
	void enterLetClause(XQueryParser.LetClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#letClause}.
	 * @param ctx the parse tree
	 */
	void exitLetClause(XQueryParser.LetClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void enterWhereClause(XQueryParser.WhereClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void exitWhereClause(XQueryParser.WhereClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#returnClause}.
	 * @param ctx the parse tree
	 */
	void enterReturnClause(XQueryParser.ReturnClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#returnClause}.
	 * @param ctx the parse tree
	 */
	void exitReturnClause(XQueryParser.ReturnClauseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cond_and}
	 * labeled alternative in {@link XQueryParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCond_and(XQueryParser.Cond_andContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cond_and}
	 * labeled alternative in {@link XQueryParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCond_and(XQueryParser.Cond_andContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cond_empty}
	 * labeled alternative in {@link XQueryParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCond_empty(XQueryParser.Cond_emptyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cond_empty}
	 * labeled alternative in {@link XQueryParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCond_empty(XQueryParser.Cond_emptyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cond_eq}
	 * labeled alternative in {@link XQueryParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCond_eq(XQueryParser.Cond_eqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cond_eq}
	 * labeled alternative in {@link XQueryParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCond_eq(XQueryParser.Cond_eqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cond_is}
	 * labeled alternative in {@link XQueryParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCond_is(XQueryParser.Cond_isContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cond_is}
	 * labeled alternative in {@link XQueryParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCond_is(XQueryParser.Cond_isContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cond_paren}
	 * labeled alternative in {@link XQueryParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCond_paren(XQueryParser.Cond_parenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cond_paren}
	 * labeled alternative in {@link XQueryParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCond_paren(XQueryParser.Cond_parenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cond_some}
	 * labeled alternative in {@link XQueryParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCond_some(XQueryParser.Cond_someContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cond_some}
	 * labeled alternative in {@link XQueryParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCond_some(XQueryParser.Cond_someContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cond_not}
	 * labeled alternative in {@link XQueryParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCond_not(XQueryParser.Cond_notContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cond_not}
	 * labeled alternative in {@link XQueryParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCond_not(XQueryParser.Cond_notContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cond_or}
	 * labeled alternative in {@link XQueryParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCond_or(XQueryParser.Cond_orContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cond_or}
	 * labeled alternative in {@link XQueryParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCond_or(XQueryParser.Cond_orContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ap_double_slash}
	 * labeled alternative in {@link XQueryParser#ap}.
	 * @param ctx the parse tree
	 */
	void enterAp_double_slash(XQueryParser.Ap_double_slashContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ap_double_slash}
	 * labeled alternative in {@link XQueryParser#ap}.
	 * @param ctx the parse tree
	 */
	void exitAp_double_slash(XQueryParser.Ap_double_slashContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ap_slash}
	 * labeled alternative in {@link XQueryParser#ap}.
	 * @param ctx the parse tree
	 */
	void enterAp_slash(XQueryParser.Ap_slashContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ap_slash}
	 * labeled alternative in {@link XQueryParser#ap}.
	 * @param ctx the parse tree
	 */
	void exitAp_slash(XQueryParser.Ap_slashContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rp_parent}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRp_parent(XQueryParser.Rp_parentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rp_parent}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRp_parent(XQueryParser.Rp_parentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rp_tag}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRp_tag(XQueryParser.Rp_tagContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rp_tag}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRp_tag(XQueryParser.Rp_tagContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rp_anyTag}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRp_anyTag(XQueryParser.Rp_anyTagContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rp_anyTag}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRp_anyTag(XQueryParser.Rp_anyTagContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rp_double_slash}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRp_double_slash(XQueryParser.Rp_double_slashContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rp_double_slash}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRp_double_slash(XQueryParser.Rp_double_slashContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rp_comma}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRp_comma(XQueryParser.Rp_commaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rp_comma}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRp_comma(XQueryParser.Rp_commaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rp_self}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRp_self(XQueryParser.Rp_selfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rp_self}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRp_self(XQueryParser.Rp_selfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rp_text}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRp_text(XQueryParser.Rp_textContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rp_text}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRp_text(XQueryParser.Rp_textContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rp_filter}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRp_filter(XQueryParser.Rp_filterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rp_filter}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRp_filter(XQueryParser.Rp_filterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rp_paren}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRp_paren(XQueryParser.Rp_parenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rp_paren}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRp_paren(XQueryParser.Rp_parenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rp_att}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRp_att(XQueryParser.Rp_attContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rp_att}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRp_att(XQueryParser.Rp_attContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rp_slash}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRp_slash(XQueryParser.Rp_slashContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rp_slash}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRp_slash(XQueryParser.Rp_slashContext ctx);
	/**
	 * Enter a parse tree produced by the {@code f_not}
	 * labeled alternative in {@link XQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterF_not(XQueryParser.F_notContext ctx);
	/**
	 * Exit a parse tree produced by the {@code f_not}
	 * labeled alternative in {@link XQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitF_not(XQueryParser.F_notContext ctx);
	/**
	 * Enter a parse tree produced by the {@code f_paren}
	 * labeled alternative in {@link XQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterF_paren(XQueryParser.F_parenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code f_paren}
	 * labeled alternative in {@link XQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitF_paren(XQueryParser.F_parenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code f_or}
	 * labeled alternative in {@link XQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterF_or(XQueryParser.F_orContext ctx);
	/**
	 * Exit a parse tree produced by the {@code f_or}
	 * labeled alternative in {@link XQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitF_or(XQueryParser.F_orContext ctx);
	/**
	 * Enter a parse tree produced by the {@code f_and}
	 * labeled alternative in {@link XQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterF_and(XQueryParser.F_andContext ctx);
	/**
	 * Exit a parse tree produced by the {@code f_and}
	 * labeled alternative in {@link XQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitF_and(XQueryParser.F_andContext ctx);
	/**
	 * Enter a parse tree produced by the {@code f_rp}
	 * labeled alternative in {@link XQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterF_rp(XQueryParser.F_rpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code f_rp}
	 * labeled alternative in {@link XQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitF_rp(XQueryParser.F_rpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code f_eq}
	 * labeled alternative in {@link XQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterF_eq(XQueryParser.F_eqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code f_eq}
	 * labeled alternative in {@link XQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitF_eq(XQueryParser.F_eqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code f_is}
	 * labeled alternative in {@link XQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterF_is(XQueryParser.F_isContext ctx);
	/**
	 * Exit a parse tree produced by the {@code f_is}
	 * labeled alternative in {@link XQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitF_is(XQueryParser.F_isContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#filename}.
	 * @param ctx the parse tree
	 */
	void enterFilename(XQueryParser.FilenameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#filename}.
	 * @param ctx the parse tree
	 */
	void exitFilename(XQueryParser.FilenameContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#tagname}.
	 * @param ctx the parse tree
	 */
	void enterTagname(XQueryParser.TagnameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#tagname}.
	 * @param ctx the parse tree
	 */
	void exitTagname(XQueryParser.TagnameContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#attriname}.
	 * @param ctx the parse tree
	 */
	void enterAttriname(XQueryParser.AttrinameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#attriname}.
	 * @param ctx the parse tree
	 */
	void exitAttriname(XQueryParser.AttrinameContext ctx);
}