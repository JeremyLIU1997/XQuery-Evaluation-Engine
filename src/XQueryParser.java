// Generated from XQuery.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class XQueryParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, UNDERSCORE=12, EQ=13, IS=14, AND=15, OR=16, NOT=17, 
		NEWLINE=18, WS=19, TAGNAME=20, NAMESTRING=21, ATTRINAME=22, LPAREN=23, 
		RPAREN=24, DOUBLESLASH=25, SLASH=26, FILENAME=27;
	public static final int
		RULE_ap = 0, RULE_rp = 1, RULE_filter = 2;
	private static String[] makeRuleNames() {
		return new String[] {
			"ap", "rp", "filter"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'doc'", "'*'", "'.'", "'..'", "'text()'", "'@'", "'['", "']'", 
			"','", "'='", "'=='", "'_'", "'eq'", "'is'", "'and'", "'or'", "'not'", 
			null, null, null, null, null, "'('", "')'", "'//'", "'/'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"UNDERSCORE", "EQ", "IS", "AND", "OR", "NOT", "NEWLINE", "WS", "TAGNAME", 
			"NAMESTRING", "ATTRINAME", "LPAREN", "RPAREN", "DOUBLESLASH", "SLASH", 
			"FILENAME"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "XQuery.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public XQueryParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ApContext extends ParserRuleContext {
		public ApContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ap; }
	 
		public ApContext() { }
		public void copyFrom(ApContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Ap_slashContext extends ApContext {
		public TerminalNode LPAREN() { return getToken(XQueryParser.LPAREN, 0); }
		public TerminalNode FILENAME() { return getToken(XQueryParser.FILENAME, 0); }
		public TerminalNode RPAREN() { return getToken(XQueryParser.RPAREN, 0); }
		public TerminalNode SLASH() { return getToken(XQueryParser.SLASH, 0); }
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public Ap_slashContext(ApContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterAp_slash(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitAp_slash(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitAp_slash(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Ap_double_slashContext extends ApContext {
		public TerminalNode LPAREN() { return getToken(XQueryParser.LPAREN, 0); }
		public TerminalNode FILENAME() { return getToken(XQueryParser.FILENAME, 0); }
		public TerminalNode RPAREN() { return getToken(XQueryParser.RPAREN, 0); }
		public TerminalNode DOUBLESLASH() { return getToken(XQueryParser.DOUBLESLASH, 0); }
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public Ap_double_slashContext(ApContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterAp_double_slash(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitAp_double_slash(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitAp_double_slash(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ApContext ap() throws RecognitionException {
		ApContext _localctx = new ApContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_ap);
		try {
			setState(18);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				_localctx = new Ap_double_slashContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(6);
				match(T__0);
				setState(7);
				match(LPAREN);
				setState(8);
				match(FILENAME);
				setState(9);
				match(RPAREN);
				setState(10);
				match(DOUBLESLASH);
				setState(11);
				rp(0);
				}
				break;
			case 2:
				_localctx = new Ap_slashContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(12);
				match(T__0);
				setState(13);
				match(LPAREN);
				setState(14);
				match(FILENAME);
				setState(15);
				match(RPAREN);
				setState(16);
				match(SLASH);
				setState(17);
				rp(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RpContext extends ParserRuleContext {
		public RpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rp; }
	 
		public RpContext() { }
		public void copyFrom(RpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Rp_parentContext extends RpContext {
		public Rp_parentContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterRp_parent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitRp_parent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitRp_parent(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Rp_tagContext extends RpContext {
		public TerminalNode TAGNAME() { return getToken(XQueryParser.TAGNAME, 0); }
		public Rp_tagContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterRp_tag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitRp_tag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitRp_tag(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Rp_anyTagContext extends RpContext {
		public Rp_anyTagContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterRp_anyTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitRp_anyTag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitRp_anyTag(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Rp_double_slashContext extends RpContext {
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public TerminalNode DOUBLESLASH() { return getToken(XQueryParser.DOUBLESLASH, 0); }
		public Rp_double_slashContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterRp_double_slash(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitRp_double_slash(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitRp_double_slash(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Rp_commaContext extends RpContext {
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public Rp_commaContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterRp_comma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitRp_comma(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitRp_comma(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Rp_selfContext extends RpContext {
		public Rp_selfContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterRp_self(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitRp_self(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitRp_self(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Rp_textContext extends RpContext {
		public Rp_textContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterRp_text(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitRp_text(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitRp_text(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Rp_filterContext extends RpContext {
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public FilterContext filter() {
			return getRuleContext(FilterContext.class,0);
		}
		public Rp_filterContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterRp_filter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitRp_filter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitRp_filter(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Rp_parenContext extends RpContext {
		public TerminalNode LPAREN() { return getToken(XQueryParser.LPAREN, 0); }
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(XQueryParser.RPAREN, 0); }
		public Rp_parenContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterRp_paren(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitRp_paren(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitRp_paren(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Rp_attContext extends RpContext {
		public TerminalNode ATTRINAME() { return getToken(XQueryParser.ATTRINAME, 0); }
		public Rp_attContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterRp_att(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitRp_att(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitRp_att(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Rp_slashContext extends RpContext {
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public TerminalNode SLASH() { return getToken(XQueryParser.SLASH, 0); }
		public Rp_slashContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterRp_slash(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitRp_slash(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitRp_slash(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RpContext rp() throws RecognitionException {
		return rp(0);
	}

	private RpContext rp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RpContext _localctx = new RpContext(_ctx, _parentState);
		RpContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_rp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TAGNAME:
				{
				_localctx = new Rp_tagContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(21);
				match(TAGNAME);
				}
				break;
			case T__1:
				{
				_localctx = new Rp_anyTagContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(22);
				match(T__1);
				}
				break;
			case T__2:
				{
				_localctx = new Rp_selfContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(23);
				match(T__2);
				}
				break;
			case T__3:
				{
				_localctx = new Rp_parentContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(24);
				match(T__3);
				}
				break;
			case T__4:
				{
				_localctx = new Rp_textContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(25);
				match(T__4);
				}
				break;
			case T__5:
				{
				_localctx = new Rp_attContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(26);
				match(T__5);
				setState(27);
				match(ATTRINAME);
				}
				break;
			case LPAREN:
				{
				_localctx = new Rp_parenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(28);
				match(LPAREN);
				setState(29);
				rp(0);
				setState(30);
				match(RPAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(50);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(48);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						_localctx = new Rp_double_slashContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(34);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(35);
						match(DOUBLESLASH);
						setState(36);
						rp(4);
						}
						break;
					case 2:
						{
						_localctx = new Rp_slashContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(37);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(38);
						match(SLASH);
						setState(39);
						rp(3);
						}
						break;
					case 3:
						{
						_localctx = new Rp_commaContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(40);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(41);
						match(T__8);
						setState(42);
						rp(2);
						}
						break;
					case 4:
						{
						_localctx = new Rp_filterContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(43);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(44);
						match(T__6);
						setState(45);
						filter(0);
						setState(46);
						match(T__7);
						}
						break;
					}
					} 
				}
				setState(52);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class FilterContext extends ParserRuleContext {
		public FilterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_filter; }
	 
		public FilterContext() { }
		public void copyFrom(FilterContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class F_notContext extends FilterContext {
		public TerminalNode NOT() { return getToken(XQueryParser.NOT, 0); }
		public FilterContext filter() {
			return getRuleContext(FilterContext.class,0);
		}
		public F_notContext(FilterContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterF_not(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitF_not(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitF_not(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class F_parenContext extends FilterContext {
		public TerminalNode LPAREN() { return getToken(XQueryParser.LPAREN, 0); }
		public FilterContext filter() {
			return getRuleContext(FilterContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(XQueryParser.RPAREN, 0); }
		public F_parenContext(FilterContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterF_paren(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitF_paren(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitF_paren(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class F_orContext extends FilterContext {
		public List<FilterContext> filter() {
			return getRuleContexts(FilterContext.class);
		}
		public FilterContext filter(int i) {
			return getRuleContext(FilterContext.class,i);
		}
		public TerminalNode OR() { return getToken(XQueryParser.OR, 0); }
		public F_orContext(FilterContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterF_or(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitF_or(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitF_or(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class F_andContext extends FilterContext {
		public List<FilterContext> filter() {
			return getRuleContexts(FilterContext.class);
		}
		public FilterContext filter(int i) {
			return getRuleContext(FilterContext.class,i);
		}
		public TerminalNode AND() { return getToken(XQueryParser.AND, 0); }
		public F_andContext(FilterContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterF_and(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitF_and(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitF_and(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class F_rpContext extends FilterContext {
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public F_rpContext(FilterContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterF_rp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitF_rp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitF_rp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class F_eqContext extends FilterContext {
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public TerminalNode EQ() { return getToken(XQueryParser.EQ, 0); }
		public F_eqContext(FilterContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterF_eq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitF_eq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitF_eq(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class F_isContext extends FilterContext {
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public TerminalNode IS() { return getToken(XQueryParser.IS, 0); }
		public F_isContext(FilterContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterF_is(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitF_is(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitF_is(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FilterContext filter() throws RecognitionException {
		return filter(0);
	}

	private FilterContext filter(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		FilterContext _localctx = new FilterContext(_ctx, _parentState);
		FilterContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_filter, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				_localctx = new F_rpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(54);
				rp(0);
				}
				break;
			case 2:
				{
				_localctx = new F_eqContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(55);
				rp(0);
				setState(56);
				match(T__9);
				setState(57);
				rp(0);
				}
				break;
			case 3:
				{
				_localctx = new F_eqContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(59);
				rp(0);
				setState(60);
				match(EQ);
				setState(61);
				rp(0);
				}
				break;
			case 4:
				{
				_localctx = new F_isContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(63);
				rp(0);
				setState(64);
				match(T__10);
				setState(65);
				rp(0);
				}
				break;
			case 5:
				{
				_localctx = new F_isContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(67);
				rp(0);
				setState(68);
				match(IS);
				setState(69);
				rp(0);
				}
				break;
			case 6:
				{
				_localctx = new F_parenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(71);
				match(LPAREN);
				setState(72);
				filter(0);
				setState(73);
				match(RPAREN);
				}
				break;
			case 7:
				{
				_localctx = new F_notContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(75);
				match(NOT);
				setState(76);
				filter(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(87);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(85);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new F_andContext(new FilterContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_filter);
						setState(79);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(80);
						match(AND);
						setState(81);
						filter(4);
						}
						break;
					case 2:
						{
						_localctx = new F_orContext(new FilterContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_filter);
						setState(82);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(83);
						match(OR);
						setState(84);
						filter(3);
						}
						break;
					}
					} 
				}
				setState(89);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return rp_sempred((RpContext)_localctx, predIndex);
		case 2:
			return filter_sempred((FilterContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean rp_sempred(RpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 2);
		case 2:
			return precpred(_ctx, 1);
		case 3:
			return precpred(_ctx, 4);
		}
		return true;
	}
	private boolean filter_sempred(FilterContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 3);
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\35]\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\25\n\2"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3#\n\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3\63\n\3\f\3\16\3\66\13"+
		"\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4P\n\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4X\n\4"+
		"\f\4\16\4[\13\4\3\4\2\4\4\6\5\2\4\6\2\2\2l\2\24\3\2\2\2\4\"\3\2\2\2\6"+
		"O\3\2\2\2\b\t\7\3\2\2\t\n\7\31\2\2\n\13\7\35\2\2\13\f\7\32\2\2\f\r\7\33"+
		"\2\2\r\25\5\4\3\2\16\17\7\3\2\2\17\20\7\31\2\2\20\21\7\35\2\2\21\22\7"+
		"\32\2\2\22\23\7\34\2\2\23\25\5\4\3\2\24\b\3\2\2\2\24\16\3\2\2\2\25\3\3"+
		"\2\2\2\26\27\b\3\1\2\27#\7\26\2\2\30#\7\4\2\2\31#\7\5\2\2\32#\7\6\2\2"+
		"\33#\7\7\2\2\34\35\7\b\2\2\35#\7\30\2\2\36\37\7\31\2\2\37 \5\4\3\2 !\7"+
		"\32\2\2!#\3\2\2\2\"\26\3\2\2\2\"\30\3\2\2\2\"\31\3\2\2\2\"\32\3\2\2\2"+
		"\"\33\3\2\2\2\"\34\3\2\2\2\"\36\3\2\2\2#\64\3\2\2\2$%\f\5\2\2%&\7\33\2"+
		"\2&\63\5\4\3\6\'(\f\4\2\2()\7\34\2\2)\63\5\4\3\5*+\f\3\2\2+,\7\13\2\2"+
		",\63\5\4\3\4-.\f\6\2\2./\7\t\2\2/\60\5\6\4\2\60\61\7\n\2\2\61\63\3\2\2"+
		"\2\62$\3\2\2\2\62\'\3\2\2\2\62*\3\2\2\2\62-\3\2\2\2\63\66\3\2\2\2\64\62"+
		"\3\2\2\2\64\65\3\2\2\2\65\5\3\2\2\2\66\64\3\2\2\2\678\b\4\1\28P\5\4\3"+
		"\29:\5\4\3\2:;\7\f\2\2;<\5\4\3\2<P\3\2\2\2=>\5\4\3\2>?\7\17\2\2?@\5\4"+
		"\3\2@P\3\2\2\2AB\5\4\3\2BC\7\r\2\2CD\5\4\3\2DP\3\2\2\2EF\5\4\3\2FG\7\20"+
		"\2\2GH\5\4\3\2HP\3\2\2\2IJ\7\31\2\2JK\5\6\4\2KL\7\32\2\2LP\3\2\2\2MN\7"+
		"\23\2\2NP\5\6\4\3O\67\3\2\2\2O9\3\2\2\2O=\3\2\2\2OA\3\2\2\2OE\3\2\2\2"+
		"OI\3\2\2\2OM\3\2\2\2PY\3\2\2\2QR\f\5\2\2RS\7\21\2\2SX\5\6\4\6TU\f\4\2"+
		"\2UV\7\22\2\2VX\5\6\4\5WQ\3\2\2\2WT\3\2\2\2X[\3\2\2\2YW\3\2\2\2YZ\3\2"+
		"\2\2Z\7\3\2\2\2[Y\3\2\2\2\t\24\"\62\64OWY";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}