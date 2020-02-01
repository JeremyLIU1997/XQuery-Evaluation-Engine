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
		NEWLINE=18, WS=19, NAMESTRING=20, LPAREN=21, RPAREN=22, DOUBLESLASH=23, 
		SLASH=24, FILENAME=25;
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
			"WS", "NAMESTRING", "LPAREN", "RPAREN", "DOUBLESLASH", "SLASH", "FILENAME"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'doc'", "'*'", "'.'", "'..'", "'text()'", "'@'", "'['", "']'", 
			"','", "'='", "'=='", "'_'", "'eq'", "'is'", "'and'", "'or'", "'not'", 
			null, null, null, "'('", "')'", "'//'", "'/'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"UNDERSCORE", "EQ", "IS", "AND", "OR", "NOT", "NEWLINE", "WS", "NAMESTRING", 
			"LPAREN", "RPAREN", "DOUBLESLASH", "SLASH", "FILENAME"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\33\u008b\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3"+
		"\f\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21"+
		"\3\21\3\22\3\22\3\22\3\22\3\23\5\23i\n\23\3\23\3\23\3\24\6\24n\n\24\r"+
		"\24\16\24o\3\24\3\24\3\25\3\25\6\25v\n\25\r\25\16\25w\3\26\3\26\3\27\3"+
		"\27\3\30\3\30\3\30\3\31\3\31\3\32\3\32\7\32\u0085\n\32\f\32\16\32\u0088"+
		"\13\32\3\32\3\32\2\2\33\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f"+
		"\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63"+
		"\33\3\2\5\4\2\13\13\"\"\5\2\62;C\\c|\6\2\60;C\\aac|\2\u008f\2\3\3\2\2"+
		"\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3"+
		"\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2"+
		"\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2"+
		"\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2"+
		"\2\2\2\63\3\2\2\2\3\65\3\2\2\2\59\3\2\2\2\7;\3\2\2\2\t=\3\2\2\2\13@\3"+
		"\2\2\2\rG\3\2\2\2\17I\3\2\2\2\21K\3\2\2\2\23M\3\2\2\2\25O\3\2\2\2\27Q"+
		"\3\2\2\2\31T\3\2\2\2\33V\3\2\2\2\35Y\3\2\2\2\37\\\3\2\2\2!`\3\2\2\2#c"+
		"\3\2\2\2%h\3\2\2\2\'m\3\2\2\2)u\3\2\2\2+y\3\2\2\2-{\3\2\2\2/}\3\2\2\2"+
		"\61\u0080\3\2\2\2\63\u0082\3\2\2\2\65\66\7f\2\2\66\67\7q\2\2\678\7e\2"+
		"\28\4\3\2\2\29:\7,\2\2:\6\3\2\2\2;<\7\60\2\2<\b\3\2\2\2=>\7\60\2\2>?\7"+
		"\60\2\2?\n\3\2\2\2@A\7v\2\2AB\7g\2\2BC\7z\2\2CD\7v\2\2DE\7*\2\2EF\7+\2"+
		"\2F\f\3\2\2\2GH\7B\2\2H\16\3\2\2\2IJ\7]\2\2J\20\3\2\2\2KL\7_\2\2L\22\3"+
		"\2\2\2MN\7.\2\2N\24\3\2\2\2OP\7?\2\2P\26\3\2\2\2QR\7?\2\2RS\7?\2\2S\30"+
		"\3\2\2\2TU\7a\2\2U\32\3\2\2\2VW\7g\2\2WX\7s\2\2X\34\3\2\2\2YZ\7k\2\2Z"+
		"[\7u\2\2[\36\3\2\2\2\\]\7c\2\2]^\7p\2\2^_\7f\2\2_ \3\2\2\2`a\7q\2\2ab"+
		"\7t\2\2b\"\3\2\2\2cd\7p\2\2de\7q\2\2ef\7v\2\2f$\3\2\2\2gi\7\17\2\2hg\3"+
		"\2\2\2hi\3\2\2\2ij\3\2\2\2jk\7\f\2\2k&\3\2\2\2ln\t\2\2\2ml\3\2\2\2no\3"+
		"\2\2\2om\3\2\2\2op\3\2\2\2pq\3\2\2\2qr\b\24\2\2r(\3\2\2\2sv\t\3\2\2tv"+
		"\5\31\r\2us\3\2\2\2ut\3\2\2\2vw\3\2\2\2wu\3\2\2\2wx\3\2\2\2x*\3\2\2\2"+
		"yz\7*\2\2z,\3\2\2\2{|\7+\2\2|.\3\2\2\2}~\7\61\2\2~\177\7\61\2\2\177\60"+
		"\3\2\2\2\u0080\u0081\7\61\2\2\u0081\62\3\2\2\2\u0082\u0086\7$\2\2\u0083"+
		"\u0085\t\4\2\2\u0084\u0083\3\2\2\2\u0085\u0088\3\2\2\2\u0086\u0084\3\2"+
		"\2\2\u0086\u0087\3\2\2\2\u0087\u0089\3\2\2\2\u0088\u0086\3\2\2\2\u0089"+
		"\u008a\7$\2\2\u008a\64\3\2\2\2\b\2houw\u0086\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}