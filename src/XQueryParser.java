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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, EQ=17, 
		IS=18, AND=19, OR=20, NOT=21, IN=22, FOR=23, LET=24, WHERE=25, EMPTY=26, 
		SOME=27, SATISFIES=28, RETURN=29, UNDERSCORE=30, VAR=31, NEWLINE=32, WS=33, 
		FILENAME=34, STRING=35, NAMESTRING=36, DOUBLESLASH=37, SLASH=38, LPAREN=39, 
		RPAREN=40;
	public static final int
		RULE_xq = 0, RULE_stringconst = 1, RULE_forClause = 2, RULE_letClause = 3, 
		RULE_whereClause = 4, RULE_returnClause = 5, RULE_condition = 6, RULE_ap = 7, 
		RULE_rp = 8, RULE_filter = 9, RULE_filename = 10, RULE_tagname = 11, RULE_attriname = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"xq", "stringconst", "forClause", "letClause", "whereClause", "returnClause", 
			"condition", "ap", "rp", "filter", "filename", "tagname", "attriname"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "'<'", "'>'", "'{'", "'}'", "':='", "'='", "'=='", "'doc'", 
			"'*'", "'.'", "'..'", "'text()'", "'@'", "'['", "']'", "'eq'", "'is'", 
			"'and'", "'or'", "'not'", "'in'", "'for'", "'let'", "'where'", "'empty'", 
			"'some'", "'satisfies'", "'return'", "'_'", null, null, null, null, null, 
			null, "'//'", "'/'", "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "EQ", "IS", "AND", "OR", "NOT", "IN", "FOR", 
			"LET", "WHERE", "EMPTY", "SOME", "SATISFIES", "RETURN", "UNDERSCORE", 
			"VAR", "NEWLINE", "WS", "FILENAME", "STRING", "NAMESTRING", "DOUBLESLASH", 
			"SLASH", "LPAREN", "RPAREN"
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

	public static class XqContext extends ParserRuleContext {
		public XqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xq; }
	 
		public XqContext() { }
		public void copyFrom(XqContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Xq_strContext extends XqContext {
		public StringconstContext stringconst() {
			return getRuleContext(StringconstContext.class,0);
		}
		public Xq_strContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterXq_str(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitXq_str(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitXq_str(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Xq_slash_rpContext extends XqContext {
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public TerminalNode SLASH() { return getToken(XQueryParser.SLASH, 0); }
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public Xq_slash_rpContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterXq_slash_rp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitXq_slash_rp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitXq_slash_rp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Xq_parenContext extends XqContext {
		public TerminalNode LPAREN() { return getToken(XQueryParser.LPAREN, 0); }
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(XQueryParser.RPAREN, 0); }
		public Xq_parenContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterXq_paren(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitXq_paren(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitXq_paren(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Xq_double_slash_rpContext extends XqContext {
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public TerminalNode DOUBLESLASH() { return getToken(XQueryParser.DOUBLESLASH, 0); }
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public Xq_double_slash_rpContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterXq_double_slash_rp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitXq_double_slash_rp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitXq_double_slash_rp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Xq_apContext extends XqContext {
		public ApContext ap() {
			return getRuleContext(ApContext.class,0);
		}
		public Xq_apContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterXq_ap(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitXq_ap(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitXq_ap(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Xq_varContext extends XqContext {
		public TerminalNode VAR() { return getToken(XQueryParser.VAR, 0); }
		public Xq_varContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterXq_var(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitXq_var(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitXq_var(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Xq_FLWRContext extends XqContext {
		public ForClauseContext forClause() {
			return getRuleContext(ForClauseContext.class,0);
		}
		public LetClauseContext letClause() {
			return getRuleContext(LetClauseContext.class,0);
		}
		public WhereClauseContext whereClause() {
			return getRuleContext(WhereClauseContext.class,0);
		}
		public ReturnClauseContext returnClause() {
			return getRuleContext(ReturnClauseContext.class,0);
		}
		public Xq_FLWRContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterXq_FLWR(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitXq_FLWR(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitXq_FLWR(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Xq_constructorContext extends XqContext {
		public List<TerminalNode> NAMESTRING() { return getTokens(XQueryParser.NAMESTRING); }
		public TerminalNode NAMESTRING(int i) {
			return getToken(XQueryParser.NAMESTRING, i);
		}
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public TerminalNode SLASH() { return getToken(XQueryParser.SLASH, 0); }
		public Xq_constructorContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterXq_constructor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitXq_constructor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitXq_constructor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Xq_letContext extends XqContext {
		public LetClauseContext letClause() {
			return getRuleContext(LetClauseContext.class,0);
		}
		public Xq_letContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterXq_let(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitXq_let(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitXq_let(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Xq_commaContext extends XqContext {
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public Xq_commaContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterXq_comma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitXq_comma(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitXq_comma(this);
			else return visitor.visitChildren(this);
		}
	}

	public final XqContext xq() throws RecognitionException {
		return xq(0);
	}

	private XqContext xq(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		XqContext _localctx = new XqContext(_ctx, _parentState);
		XqContext _prevctx = _localctx;
		int _startState = 0;
		enterRecursionRule(_localctx, 0, RULE_xq, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				_localctx = new Xq_varContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(27);
				match(VAR);
				}
				break;
			case 2:
				{
				_localctx = new Xq_strContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(28);
				stringconst();
				}
				break;
			case 3:
				{
				_localctx = new Xq_apContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(29);
				ap();
				}
				break;
			case 4:
				{
				_localctx = new Xq_parenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(30);
				match(LPAREN);
				setState(31);
				xq(0);
				setState(32);
				match(RPAREN);
				}
				break;
			case 5:
				{
				_localctx = new Xq_constructorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(34);
				match(T__1);
				setState(35);
				match(NAMESTRING);
				setState(36);
				match(T__2);
				setState(37);
				match(T__3);
				setState(38);
				xq(0);
				setState(39);
				match(T__4);
				setState(40);
				match(T__1);
				setState(41);
				match(SLASH);
				setState(42);
				match(NAMESTRING);
				setState(43);
				match(T__2);
				}
				break;
			case 6:
				{
				_localctx = new Xq_FLWRContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(45);
				forClause();
				setState(46);
				letClause();
				setState(47);
				whereClause();
				setState(48);
				returnClause();
				}
				break;
			case 7:
				{
				_localctx = new Xq_letContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(50);
				letClause();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(64);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(62);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new Xq_commaContext(new XqContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_xq);
						setState(53);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(54);
						match(T__0);
						setState(55);
						xq(7);
						}
						break;
					case 2:
						{
						_localctx = new Xq_double_slash_rpContext(new XqContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_xq);
						setState(56);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(57);
						match(DOUBLESLASH);
						setState(58);
						rp(0);
						}
						break;
					case 3:
						{
						_localctx = new Xq_slash_rpContext(new XqContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_xq);
						setState(59);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(60);
						match(SLASH);
						setState(61);
						rp(0);
						}
						break;
					}
					} 
				}
				setState(66);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
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

	public static class StringconstContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(XQueryParser.STRING, 0); }
		public StringconstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringconst; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterStringconst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitStringconst(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitStringconst(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringconstContext stringconst() throws RecognitionException {
		StringconstContext _localctx = new StringconstContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stringconst);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			match(STRING);
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

	public static class ForClauseContext extends ParserRuleContext {
		public List<TerminalNode> FOR() { return getTokens(XQueryParser.FOR); }
		public TerminalNode FOR(int i) {
			return getToken(XQueryParser.FOR, i);
		}
		public List<TerminalNode> VAR() { return getTokens(XQueryParser.VAR); }
		public TerminalNode VAR(int i) {
			return getToken(XQueryParser.VAR, i);
		}
		public List<TerminalNode> IN() { return getTokens(XQueryParser.IN); }
		public TerminalNode IN(int i) {
			return getToken(XQueryParser.IN, i);
		}
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public ForClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterForClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitForClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitForClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForClauseContext forClause() throws RecognitionException {
		ForClauseContext _localctx = new ForClauseContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_forClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			match(FOR);
			setState(70);
			match(VAR);
			setState(71);
			match(IN);
			setState(72);
			xq(0);
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(73);
				match(T__0);
				setState(74);
				match(FOR);
				setState(75);
				match(VAR);
				setState(76);
				match(IN);
				setState(77);
				xq(0);
				}
				}
				setState(82);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class LetClauseContext extends ParserRuleContext {
		public List<TerminalNode> LET() { return getTokens(XQueryParser.LET); }
		public TerminalNode LET(int i) {
			return getToken(XQueryParser.LET, i);
		}
		public List<TerminalNode> VAR() { return getTokens(XQueryParser.VAR); }
		public TerminalNode VAR(int i) {
			return getToken(XQueryParser.VAR, i);
		}
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public LetClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_letClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterLetClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitLetClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitLetClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LetClauseContext letClause() throws RecognitionException {
		LetClauseContext _localctx = new LetClauseContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_letClause);
		try {
			int _alt;
			setState(98);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(83);
				match(LET);
				setState(84);
				match(VAR);
				setState(85);
				match(T__5);
				setState(86);
				xq(0);
				setState(94);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(87);
						match(T__0);
						setState(88);
						match(LET);
						setState(89);
						match(VAR);
						setState(90);
						match(T__5);
						setState(91);
						xq(0);
						}
						} 
					}
					setState(96);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
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

	public static class WhereClauseContext extends ParserRuleContext {
		public TerminalNode WHERE() { return getToken(XQueryParser.WHERE, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public WhereClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whereClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterWhereClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitWhereClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitWhereClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhereClauseContext whereClause() throws RecognitionException {
		WhereClauseContext _localctx = new WhereClauseContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_whereClause);
		try {
			setState(103);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WHERE:
				enterOuterAlt(_localctx, 1);
				{
				setState(100);
				match(WHERE);
				setState(101);
				condition(0);
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ReturnClauseContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(XQueryParser.RETURN, 0); }
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public ReturnClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterReturnClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitReturnClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitReturnClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnClauseContext returnClause() throws RecognitionException {
		ReturnClauseContext _localctx = new ReturnClauseContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_returnClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(RETURN);
			setState(106);
			xq(0);
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

	public static class ConditionContext extends ParserRuleContext {
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
	 
		public ConditionContext() { }
		public void copyFrom(ConditionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Cond_andContext extends ConditionContext {
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public TerminalNode AND() { return getToken(XQueryParser.AND, 0); }
		public Cond_andContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterCond_and(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitCond_and(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitCond_and(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Cond_emptyContext extends ConditionContext {
		public TerminalNode EMPTY() { return getToken(XQueryParser.EMPTY, 0); }
		public TerminalNode LPAREN() { return getToken(XQueryParser.LPAREN, 0); }
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(XQueryParser.RPAREN, 0); }
		public Cond_emptyContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterCond_empty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitCond_empty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitCond_empty(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Cond_eqContext extends ConditionContext {
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public TerminalNode EQ() { return getToken(XQueryParser.EQ, 0); }
		public Cond_eqContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterCond_eq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitCond_eq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitCond_eq(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Cond_isContext extends ConditionContext {
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public TerminalNode IS() { return getToken(XQueryParser.IS, 0); }
		public Cond_isContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterCond_is(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitCond_is(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitCond_is(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Cond_parenContext extends ConditionContext {
		public TerminalNode LPAREN() { return getToken(XQueryParser.LPAREN, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(XQueryParser.RPAREN, 0); }
		public Cond_parenContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterCond_paren(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitCond_paren(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitCond_paren(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Cond_someContext extends ConditionContext {
		public TerminalNode SOME() { return getToken(XQueryParser.SOME, 0); }
		public List<TerminalNode> VAR() { return getTokens(XQueryParser.VAR); }
		public TerminalNode VAR(int i) {
			return getToken(XQueryParser.VAR, i);
		}
		public List<TerminalNode> IN() { return getTokens(XQueryParser.IN); }
		public TerminalNode IN(int i) {
			return getToken(XQueryParser.IN, i);
		}
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public TerminalNode SATISFIES() { return getToken(XQueryParser.SATISFIES, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public Cond_someContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterCond_some(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitCond_some(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitCond_some(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Cond_notContext extends ConditionContext {
		public TerminalNode NOT() { return getToken(XQueryParser.NOT, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public Cond_notContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterCond_not(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitCond_not(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitCond_not(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Cond_orContext extends ConditionContext {
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public TerminalNode OR() { return getToken(XQueryParser.OR, 0); }
		public Cond_orContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterCond_or(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitCond_or(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitCond_or(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		return condition(0);
	}

	private ConditionContext condition(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ConditionContext _localctx = new ConditionContext(_ctx, _parentState);
		ConditionContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_condition, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				_localctx = new Cond_eqContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(109);
				xq(0);
				setState(110);
				match(T__6);
				setState(111);
				xq(0);
				}
				break;
			case 2:
				{
				_localctx = new Cond_eqContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(113);
				xq(0);
				setState(114);
				match(EQ);
				setState(115);
				xq(0);
				}
				break;
			case 3:
				{
				_localctx = new Cond_isContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(117);
				xq(0);
				setState(118);
				match(T__7);
				setState(119);
				xq(0);
				}
				break;
			case 4:
				{
				_localctx = new Cond_isContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(121);
				xq(0);
				setState(122);
				match(IS);
				setState(123);
				xq(0);
				}
				break;
			case 5:
				{
				_localctx = new Cond_emptyContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(125);
				match(EMPTY);
				setState(126);
				match(LPAREN);
				setState(127);
				xq(0);
				setState(128);
				match(RPAREN);
				}
				break;
			case 6:
				{
				_localctx = new Cond_someContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(130);
				match(SOME);
				setState(131);
				match(VAR);
				setState(132);
				match(IN);
				setState(133);
				xq(0);
				setState(140);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(134);
					match(T__0);
					setState(135);
					match(VAR);
					setState(136);
					match(IN);
					setState(137);
					xq(0);
					}
					}
					setState(142);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(143);
				match(SATISFIES);
				setState(144);
				condition(5);
				}
				break;
			case 7:
				{
				_localctx = new Cond_parenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(146);
				match(LPAREN);
				setState(147);
				condition(0);
				setState(148);
				match(RPAREN);
				}
				break;
			case 8:
				{
				_localctx = new Cond_notContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(150);
				match(NOT);
				setState(151);
				condition(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(162);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(160);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new Cond_andContext(new ConditionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_condition);
						setState(154);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(155);
						match(AND);
						setState(156);
						condition(4);
						}
						break;
					case 2:
						{
						_localctx = new Cond_orContext(new ConditionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_condition);
						setState(157);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(158);
						match(OR);
						setState(159);
						condition(3);
						}
						break;
					}
					} 
				}
				setState(164);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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
		public FilenameContext filename() {
			return getRuleContext(FilenameContext.class,0);
		}
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
		public FilenameContext filename() {
			return getRuleContext(FilenameContext.class,0);
		}
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
		enterRule(_localctx, 14, RULE_ap);
		try {
			setState(179);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				_localctx = new Ap_double_slashContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(165);
				match(T__8);
				setState(166);
				match(LPAREN);
				setState(167);
				filename();
				setState(168);
				match(RPAREN);
				setState(169);
				match(DOUBLESLASH);
				setState(170);
				rp(0);
				}
				break;
			case 2:
				_localctx = new Ap_slashContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(172);
				match(T__8);
				setState(173);
				match(LPAREN);
				setState(174);
				filename();
				setState(175);
				match(RPAREN);
				setState(176);
				match(SLASH);
				setState(177);
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
		public TagnameContext tagname() {
			return getRuleContext(TagnameContext.class,0);
		}
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
		public AttrinameContext attriname() {
			return getRuleContext(AttrinameContext.class,0);
		}
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
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_rp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAMESTRING:
				{
				_localctx = new Rp_tagContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(182);
				tagname();
				}
				break;
			case T__9:
				{
				_localctx = new Rp_anyTagContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(183);
				match(T__9);
				}
				break;
			case T__10:
				{
				_localctx = new Rp_selfContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(184);
				match(T__10);
				}
				break;
			case T__11:
				{
				_localctx = new Rp_parentContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(185);
				match(T__11);
				}
				break;
			case T__12:
				{
				_localctx = new Rp_textContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(186);
				match(T__12);
				}
				break;
			case T__13:
				{
				_localctx = new Rp_attContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(187);
				match(T__13);
				setState(188);
				attriname();
				}
				break;
			case LPAREN:
				{
				_localctx = new Rp_parenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(189);
				match(LPAREN);
				setState(190);
				rp(0);
				setState(191);
				match(RPAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(211);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(209);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						_localctx = new Rp_double_slashContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(195);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(196);
						match(DOUBLESLASH);
						setState(197);
						rp(4);
						}
						break;
					case 2:
						{
						_localctx = new Rp_slashContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(198);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(199);
						match(SLASH);
						setState(200);
						rp(3);
						}
						break;
					case 3:
						{
						_localctx = new Rp_commaContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(201);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(202);
						match(T__0);
						setState(203);
						rp(2);
						}
						break;
					case 4:
						{
						_localctx = new Rp_filterContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(204);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(205);
						match(T__14);
						setState(206);
						filter(0);
						setState(207);
						match(T__15);
						}
						break;
					}
					} 
				}
				setState(213);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_filter, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				_localctx = new F_rpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(215);
				rp(0);
				}
				break;
			case 2:
				{
				_localctx = new F_eqContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(216);
				rp(0);
				setState(217);
				match(T__6);
				setState(218);
				rp(0);
				}
				break;
			case 3:
				{
				_localctx = new F_eqContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(220);
				rp(0);
				setState(221);
				match(EQ);
				setState(222);
				rp(0);
				}
				break;
			case 4:
				{
				_localctx = new F_isContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(224);
				rp(0);
				setState(225);
				match(T__7);
				setState(226);
				rp(0);
				}
				break;
			case 5:
				{
				_localctx = new F_isContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(228);
				rp(0);
				setState(229);
				match(IS);
				setState(230);
				rp(0);
				}
				break;
			case 6:
				{
				_localctx = new F_parenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(232);
				match(LPAREN);
				setState(233);
				filter(0);
				setState(234);
				match(RPAREN);
				}
				break;
			case 7:
				{
				_localctx = new F_notContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(236);
				match(NOT);
				setState(237);
				filter(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(248);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(246);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						_localctx = new F_andContext(new FilterContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_filter);
						setState(240);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(241);
						match(AND);
						setState(242);
						filter(4);
						}
						break;
					case 2:
						{
						_localctx = new F_orContext(new FilterContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_filter);
						setState(243);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(244);
						match(OR);
						setState(245);
						filter(3);
						}
						break;
					}
					} 
				}
				setState(250);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
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

	public static class FilenameContext extends ParserRuleContext {
		public TerminalNode FILENAME() { return getToken(XQueryParser.FILENAME, 0); }
		public FilenameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_filename; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterFilename(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitFilename(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitFilename(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FilenameContext filename() throws RecognitionException {
		FilenameContext _localctx = new FilenameContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_filename);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			match(FILENAME);
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

	public static class TagnameContext extends ParserRuleContext {
		public TerminalNode NAMESTRING() { return getToken(XQueryParser.NAMESTRING, 0); }
		public TagnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tagname; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterTagname(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitTagname(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitTagname(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TagnameContext tagname() throws RecognitionException {
		TagnameContext _localctx = new TagnameContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_tagname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			match(NAMESTRING);
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

	public static class AttrinameContext extends ParserRuleContext {
		public TerminalNode NAMESTRING() { return getToken(XQueryParser.NAMESTRING, 0); }
		public AttrinameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attriname; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterAttriname(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitAttriname(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitAttriname(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttrinameContext attriname() throws RecognitionException {
		AttrinameContext _localctx = new AttrinameContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_attriname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			match(NAMESTRING);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 0:
			return xq_sempred((XqContext)_localctx, predIndex);
		case 6:
			return condition_sempred((ConditionContext)_localctx, predIndex);
		case 8:
			return rp_sempred((RpContext)_localctx, predIndex);
		case 9:
			return filter_sempred((FilterContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean xq_sempred(XqContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		}
		return true;
	}
	private boolean condition_sempred(ConditionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 3);
		case 4:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean rp_sempred(RpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 3);
		case 6:
			return precpred(_ctx, 2);
		case 7:
			return precpred(_ctx, 1);
		case 8:
			return precpred(_ctx, 4);
		}
		return true;
	}
	private boolean filter_sempred(FilterContext _localctx, int predIndex) {
		switch (predIndex) {
		case 9:
			return precpred(_ctx, 3);
		case 10:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3*\u0104\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\66\n"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2A\n\2\f\2\16\2D\13\2\3\3\3\3"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4Q\n\4\f\4\16\4T\13\4\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5_\n\5\f\5\16\5b\13\5\3\5\5\5e\n\5\3\6\3"+
		"\6\3\6\5\6j\n\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\7\b\u008d\n\b\f\b\16\b\u0090\13\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\5\b\u009b\n\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u00a3\n\b\f\b\16\b"+
		"\u00a6\13\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5"+
		"\t\u00b6\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00c4"+
		"\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u00d4"+
		"\n\n\f\n\16\n\u00d7\13\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\5\13\u00f1\n\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u00f9\n\13\f"+
		"\13\16\13\u00fc\13\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\2\6\2\16\22\24\17"+
		"\2\4\6\b\n\f\16\20\22\24\26\30\32\2\2\2\u0120\2\65\3\2\2\2\4E\3\2\2\2"+
		"\6G\3\2\2\2\bd\3\2\2\2\ni\3\2\2\2\fk\3\2\2\2\16\u009a\3\2\2\2\20\u00b5"+
		"\3\2\2\2\22\u00c3\3\2\2\2\24\u00f0\3\2\2\2\26\u00fd\3\2\2\2\30\u00ff\3"+
		"\2\2\2\32\u0101\3\2\2\2\34\35\b\2\1\2\35\66\7!\2\2\36\66\5\4\3\2\37\66"+
		"\5\20\t\2 !\7)\2\2!\"\5\2\2\2\"#\7*\2\2#\66\3\2\2\2$%\7\4\2\2%&\7&\2\2"+
		"&\'\7\5\2\2\'(\7\6\2\2()\5\2\2\2)*\7\7\2\2*+\7\4\2\2+,\7(\2\2,-\7&\2\2"+
		"-.\7\5\2\2.\66\3\2\2\2/\60\5\6\4\2\60\61\5\b\5\2\61\62\5\n\6\2\62\63\5"+
		"\f\7\2\63\66\3\2\2\2\64\66\5\b\5\2\65\34\3\2\2\2\65\36\3\2\2\2\65\37\3"+
		"\2\2\2\65 \3\2\2\2\65$\3\2\2\2\65/\3\2\2\2\65\64\3\2\2\2\66B\3\2\2\2\67"+
		"8\f\b\2\289\7\3\2\29A\5\2\2\t:;\f\7\2\2;<\7\'\2\2<A\5\22\n\2=>\f\6\2\2"+
		">?\7(\2\2?A\5\22\n\2@\67\3\2\2\2@:\3\2\2\2@=\3\2\2\2AD\3\2\2\2B@\3\2\2"+
		"\2BC\3\2\2\2C\3\3\2\2\2DB\3\2\2\2EF\7%\2\2F\5\3\2\2\2GH\7\31\2\2HI\7!"+
		"\2\2IJ\7\30\2\2JR\5\2\2\2KL\7\3\2\2LM\7\31\2\2MN\7!\2\2NO\7\30\2\2OQ\5"+
		"\2\2\2PK\3\2\2\2QT\3\2\2\2RP\3\2\2\2RS\3\2\2\2S\7\3\2\2\2TR\3\2\2\2UV"+
		"\7\32\2\2VW\7!\2\2WX\7\b\2\2X`\5\2\2\2YZ\7\3\2\2Z[\7\32\2\2[\\\7!\2\2"+
		"\\]\7\b\2\2]_\5\2\2\2^Y\3\2\2\2_b\3\2\2\2`^\3\2\2\2`a\3\2\2\2ae\3\2\2"+
		"\2b`\3\2\2\2ce\3\2\2\2dU\3\2\2\2dc\3\2\2\2e\t\3\2\2\2fg\7\33\2\2gj\5\16"+
		"\b\2hj\3\2\2\2if\3\2\2\2ih\3\2\2\2j\13\3\2\2\2kl\7\37\2\2lm\5\2\2\2m\r"+
		"\3\2\2\2no\b\b\1\2op\5\2\2\2pq\7\t\2\2qr\5\2\2\2r\u009b\3\2\2\2st\5\2"+
		"\2\2tu\7\23\2\2uv\5\2\2\2v\u009b\3\2\2\2wx\5\2\2\2xy\7\n\2\2yz\5\2\2\2"+
		"z\u009b\3\2\2\2{|\5\2\2\2|}\7\24\2\2}~\5\2\2\2~\u009b\3\2\2\2\177\u0080"+
		"\7\34\2\2\u0080\u0081\7)\2\2\u0081\u0082\5\2\2\2\u0082\u0083\7*\2\2\u0083"+
		"\u009b\3\2\2\2\u0084\u0085\7\35\2\2\u0085\u0086\7!\2\2\u0086\u0087\7\30"+
		"\2\2\u0087\u008e\5\2\2\2\u0088\u0089\7\3\2\2\u0089\u008a\7!\2\2\u008a"+
		"\u008b\7\30\2\2\u008b\u008d\5\2\2\2\u008c\u0088\3\2\2\2\u008d\u0090\3"+
		"\2\2\2\u008e\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0091\3\2\2\2\u0090"+
		"\u008e\3\2\2\2\u0091\u0092\7\36\2\2\u0092\u0093\5\16\b\7\u0093\u009b\3"+
		"\2\2\2\u0094\u0095\7)\2\2\u0095\u0096\5\16\b\2\u0096\u0097\7*\2\2\u0097"+
		"\u009b\3\2\2\2\u0098\u0099\7\27\2\2\u0099\u009b\5\16\b\3\u009an\3\2\2"+
		"\2\u009as\3\2\2\2\u009aw\3\2\2\2\u009a{\3\2\2\2\u009a\177\3\2\2\2\u009a"+
		"\u0084\3\2\2\2\u009a\u0094\3\2\2\2\u009a\u0098\3\2\2\2\u009b\u00a4\3\2"+
		"\2\2\u009c\u009d\f\5\2\2\u009d\u009e\7\25\2\2\u009e\u00a3\5\16\b\6\u009f"+
		"\u00a0\f\4\2\2\u00a0\u00a1\7\26\2\2\u00a1\u00a3\5\16\b\5\u00a2\u009c\3"+
		"\2\2\2\u00a2\u009f\3\2\2\2\u00a3\u00a6\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4"+
		"\u00a5\3\2\2\2\u00a5\17\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a7\u00a8\7\13\2"+
		"\2\u00a8\u00a9\7)\2\2\u00a9\u00aa\5\26\f\2\u00aa\u00ab\7*\2\2\u00ab\u00ac"+
		"\7\'\2\2\u00ac\u00ad\5\22\n\2\u00ad\u00b6\3\2\2\2\u00ae\u00af\7\13\2\2"+
		"\u00af\u00b0\7)\2\2\u00b0\u00b1\5\26\f\2\u00b1\u00b2\7*\2\2\u00b2\u00b3"+
		"\7(\2\2\u00b3\u00b4\5\22\n\2\u00b4\u00b6\3\2\2\2\u00b5\u00a7\3\2\2\2\u00b5"+
		"\u00ae\3\2\2\2\u00b6\21\3\2\2\2\u00b7\u00b8\b\n\1\2\u00b8\u00c4\5\30\r"+
		"\2\u00b9\u00c4\7\f\2\2\u00ba\u00c4\7\r\2\2\u00bb\u00c4\7\16\2\2\u00bc"+
		"\u00c4\7\17\2\2\u00bd\u00be\7\20\2\2\u00be\u00c4\5\32\16\2\u00bf\u00c0"+
		"\7)\2\2\u00c0\u00c1\5\22\n\2\u00c1\u00c2\7*\2\2\u00c2\u00c4\3\2\2\2\u00c3"+
		"\u00b7\3\2\2\2\u00c3\u00b9\3\2\2\2\u00c3\u00ba\3\2\2\2\u00c3\u00bb\3\2"+
		"\2\2\u00c3\u00bc\3\2\2\2\u00c3\u00bd\3\2\2\2\u00c3\u00bf\3\2\2\2\u00c4"+
		"\u00d5\3\2\2\2\u00c5\u00c6\f\5\2\2\u00c6\u00c7\7\'\2\2\u00c7\u00d4\5\22"+
		"\n\6\u00c8\u00c9\f\4\2\2\u00c9\u00ca\7(\2\2\u00ca\u00d4\5\22\n\5\u00cb"+
		"\u00cc\f\3\2\2\u00cc\u00cd\7\3\2\2\u00cd\u00d4\5\22\n\4\u00ce\u00cf\f"+
		"\6\2\2\u00cf\u00d0\7\21\2\2\u00d0\u00d1\5\24\13\2\u00d1\u00d2\7\22\2\2"+
		"\u00d2\u00d4\3\2\2\2\u00d3\u00c5\3\2\2\2\u00d3\u00c8\3\2\2\2\u00d3\u00cb"+
		"\3\2\2\2\u00d3\u00ce\3\2\2\2\u00d4\u00d7\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d5"+
		"\u00d6\3\2\2\2\u00d6\23\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d8\u00d9\b\13\1"+
		"\2\u00d9\u00f1\5\22\n\2\u00da\u00db\5\22\n\2\u00db\u00dc\7\t\2\2\u00dc"+
		"\u00dd\5\22\n\2\u00dd\u00f1\3\2\2\2\u00de\u00df\5\22\n\2\u00df\u00e0\7"+
		"\23\2\2\u00e0\u00e1\5\22\n\2\u00e1\u00f1\3\2\2\2\u00e2\u00e3\5\22\n\2"+
		"\u00e3\u00e4\7\n\2\2\u00e4\u00e5\5\22\n\2\u00e5\u00f1\3\2\2\2\u00e6\u00e7"+
		"\5\22\n\2\u00e7\u00e8\7\24\2\2\u00e8\u00e9\5\22\n\2\u00e9\u00f1\3\2\2"+
		"\2\u00ea\u00eb\7)\2\2\u00eb\u00ec\5\24\13\2\u00ec\u00ed\7*\2\2\u00ed\u00f1"+
		"\3\2\2\2\u00ee\u00ef\7\27\2\2\u00ef\u00f1\5\24\13\3\u00f0\u00d8\3\2\2"+
		"\2\u00f0\u00da\3\2\2\2\u00f0\u00de\3\2\2\2\u00f0\u00e2\3\2\2\2\u00f0\u00e6"+
		"\3\2\2\2\u00f0\u00ea\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f1\u00fa\3\2\2\2\u00f2"+
		"\u00f3\f\5\2\2\u00f3\u00f4\7\25\2\2\u00f4\u00f9\5\24\13\6\u00f5\u00f6"+
		"\f\4\2\2\u00f6\u00f7\7\26\2\2\u00f7\u00f9\5\24\13\5\u00f8\u00f2\3\2\2"+
		"\2\u00f8\u00f5\3\2\2\2\u00f9\u00fc\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fa\u00fb"+
		"\3\2\2\2\u00fb\25\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fd\u00fe\7$\2\2\u00fe"+
		"\27\3\2\2\2\u00ff\u0100\7&\2\2\u0100\31\3\2\2\2\u0101\u0102\7&\2\2\u0102"+
		"\33\3\2\2\2\24\65@BR`di\u008e\u009a\u00a2\u00a4\u00b5\u00c3\u00d3\u00d5"+
		"\u00f0\u00f8\u00fa";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}