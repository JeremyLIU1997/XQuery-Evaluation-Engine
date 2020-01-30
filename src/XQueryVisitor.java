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