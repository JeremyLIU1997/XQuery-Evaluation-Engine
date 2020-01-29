// Generated from /Users/LeLe/IdeaProjects/XQuery-Evaluation-Engine/src/XQuery.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link XQueryParser}.
 */
public interface XQueryListener extends ParseTreeListener {
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
}