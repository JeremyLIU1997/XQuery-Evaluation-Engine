// Generated from XQuery.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class XQueryLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, UNDERSCORE=12, EQ=13, IS=14, AND=15, OR=16, NOT=17, 
		NEWLINE=18, WS=19, TAGNAME=20, NAMESTRING=21, ATTRINAME=22, LPAREN=23, 
		RPAREN=24, DOUBLESLASH=25, SLASH=26, FILENAME=27;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "UNDERSCORE", "EQ", "IS", "AND", "OR", "NOT", "NEWLINE", 
			"WS", "TAGNAME", "NAMESTRING", "ATTRINAME", "LPAREN", "RPAREN", "DOUBLESLASH", 
			"SLASH", "FILENAME"
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


	public XQueryLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "XQuery.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\35\u0093\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3"+
		"\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n"+
		"\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20"+
		"\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23\5\23m\n\23\3\23\3\23"+
		"\3\24\6\24r\n\24\r\24\16\24s\3\24\3\24\3\25\3\25\3\26\3\26\6\26|\n\26"+
		"\r\26\16\26}\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3"+
		"\34\3\34\7\34\u008d\n\34\f\34\16\34\u0090\13\34\3\34\3\34\2\2\35\3\3\5"+
		"\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\35\3\2\5\4\2\13"+
		"\13\"\"\5\2\62;C\\c|\6\2\60;C\\aac|\2\u0097\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2"+
		"\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2"+
		"\2\2\65\3\2\2\2\2\67\3\2\2\2\39\3\2\2\2\5=\3\2\2\2\7?\3\2\2\2\tA\3\2\2"+
		"\2\13D\3\2\2\2\rK\3\2\2\2\17M\3\2\2\2\21O\3\2\2\2\23Q\3\2\2\2\25S\3\2"+
		"\2\2\27U\3\2\2\2\31X\3\2\2\2\33Z\3\2\2\2\35]\3\2\2\2\37`\3\2\2\2!d\3\2"+
		"\2\2#g\3\2\2\2%l\3\2\2\2\'q\3\2\2\2)w\3\2\2\2+{\3\2\2\2-\177\3\2\2\2/"+
		"\u0081\3\2\2\2\61\u0083\3\2\2\2\63\u0085\3\2\2\2\65\u0088\3\2\2\2\67\u008a"+
		"\3\2\2\29:\7f\2\2:;\7q\2\2;<\7e\2\2<\4\3\2\2\2=>\7,\2\2>\6\3\2\2\2?@\7"+
		"\60\2\2@\b\3\2\2\2AB\7\60\2\2BC\7\60\2\2C\n\3\2\2\2DE\7v\2\2EF\7g\2\2"+
		"FG\7z\2\2GH\7v\2\2HI\7*\2\2IJ\7+\2\2J\f\3\2\2\2KL\7B\2\2L\16\3\2\2\2M"+
		"N\7]\2\2N\20\3\2\2\2OP\7_\2\2P\22\3\2\2\2QR\7.\2\2R\24\3\2\2\2ST\7?\2"+
		"\2T\26\3\2\2\2UV\7?\2\2VW\7?\2\2W\30\3\2\2\2XY\7a\2\2Y\32\3\2\2\2Z[\7"+
		"g\2\2[\\\7s\2\2\\\34\3\2\2\2]^\7k\2\2^_\7u\2\2_\36\3\2\2\2`a\7c\2\2ab"+
		"\7p\2\2bc\7f\2\2c \3\2\2\2de\7q\2\2ef\7t\2\2f\"\3\2\2\2gh\7p\2\2hi\7q"+
		"\2\2ij\7v\2\2j$\3\2\2\2km\7\17\2\2lk\3\2\2\2lm\3\2\2\2mn\3\2\2\2no\7\f"+
		"\2\2o&\3\2\2\2pr\t\2\2\2qp\3\2\2\2rs\3\2\2\2sq\3\2\2\2st\3\2\2\2tu\3\2"+
		"\2\2uv\b\24\2\2v(\3\2\2\2wx\5+\26\2x*\3\2\2\2y|\t\3\2\2z|\5\31\r\2{y\3"+
		"\2\2\2{z\3\2\2\2|}\3\2\2\2}{\3\2\2\2}~\3\2\2\2~,\3\2\2\2\177\u0080\5+"+
		"\26\2\u0080.\3\2\2\2\u0081\u0082\7*\2\2\u0082\60\3\2\2\2\u0083\u0084\7"+
		"+\2\2\u0084\62\3\2\2\2\u0085\u0086\7\61\2\2\u0086\u0087\7\61\2\2\u0087"+
		"\64\3\2\2\2\u0088\u0089\7\61\2\2\u0089\66\3\2\2\2\u008a\u008e\7$\2\2\u008b"+
		"\u008d\t\4\2\2\u008c\u008b\3\2\2\2\u008d\u0090\3\2\2\2\u008e\u008c\3\2"+
		"\2\2\u008e\u008f\3\2\2\2\u008f\u0091\3\2\2\2\u0090\u008e\3\2\2\2\u0091"+
		"\u0092\7$\2\2\u00928\3\2\2\2\b\2ls{}\u008e\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}