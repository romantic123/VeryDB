// Generated from SqlLexer.g4 by ANTLR 4.6
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

public class SqlLexerLexer extends Lexer {
	public static final int
		CREATE=1, TABLE=2, INSERT=3, INTO=4, VALUES=5, FROM=6, WHERE=7, UPDATE=8, 
		SET=9, DELETE=10, INT=11, FLOAT=12, DATE=13, FIRST_NUMBER=14, FIRST_CHAR=15, 
		DIGIT=16, EQUAL=17, CURVES_LEFT=18, CURVES_RIGHT=19, COMMA=20, SEMICOLON=21, 
		L_WS=22, L_BLANK=23;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"CREATE", "TABLE", "INSERT", "INTO", "VALUES", "FROM", "WHERE", "UPDATE", 
		"SET", "DELETE", "INT", "FLOAT", "DATE", "FIRST_NUMBER", "FIRST_CHAR", 
		"DIGIT", "EQUAL", "CURVES_LEFT", "CURVES_RIGHT", "COMMA", "SEMICOLON", 
		"L_WS", "L_BLANK", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", 
		"L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", 
		"Z"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, "'='", "'('", "')'", "','", "';'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "CREATE", "TABLE", "INSERT", "INTO", "VALUES", "FROM", "WHERE", 
		"UPDATE", "SET", "DELETE", "INT", "FLOAT", "DATE", "FIRST_NUMBER", "FIRST_CHAR", 
		"DIGIT", "EQUAL", "CURVES_LEFT", "CURVES_RIGHT", "COMMA", "SEMICOLON", 
		"L_WS", "L_BLANK"
	};
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
	@NotNull
	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public SqlLexerLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN);
	}

	@Override
	public String getGrammarFileName() { return "SqlLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	public static final String _serializedATN =
		"\3\uaf6f\u8320\u479d\ub75c\u4880\u1605\u191c\uab37\2\31\u010a\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5"+
		"\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\7\17\u00b5\n\17\f\17\16\17\u00b8"+
		"\13\17\3\20\3\20\3\20\7\20\u00bd\n\20\f\20\16\20\u00c0\13\20\3\21\3\21"+
		"\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\6\27\u00cf\n\27"+
		"\r\27\16\27\u00d0\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3"+
		"\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3"+
		"$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/"+
		"\3\60\3\60\3\61\3\61\3\62\3\62\2\2\2\63\3\2\3\5\2\4\7\2\5\t\2\6\13\2\7"+
		"\r\2\b\17\2\t\21\2\n\23\2\13\25\2\f\27\2\r\31\2\16\33\2\17\35\2\20\37"+
		"\2\21!\2\22#\2\23%\2\24\'\2\25)\2\26+\2\27-\2\30/\2\31\61\2\2\63\2\2\65"+
		"\2\2\67\2\29\2\2;\2\2=\2\2?\2\2A\2\2C\2\2E\2\2G\2\2I\2\2K\2\2M\2\2O\2"+
		"\2Q\2\2S\2\2U\2\2W\2\2Y\2\2[\2\2]\2\2_\2\2a\2\2c\2\2\3\2\37\4\2C\\c|\3"+
		"\2\62;\5\2\13\f\17\17\"\"\4\2CCcc\4\2DDdd\4\2EEee\4\2FFff\4\2GGgg\4\2"+
		"HHhh\4\2IIii\4\2JJjj\4\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4\2OOoo\4\2PPpp\4"+
		"\2QQqq\4\2RRrr\4\2SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\4\2YYy"+
		"y\4\2ZZzz\4\2[[{{\4\2\\\\||\u00f4\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2"+
		"\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2"+
		"\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\3e\3\2\2\2\5l\3\2\2\2\7r\3\2\2\2\t"+
		"y\3\2\2\2\13~\3\2\2\2\r\u0085\3\2\2\2\17\u008a\3\2\2\2\21\u0090\3\2\2"+
		"\2\23\u0097\3\2\2\2\25\u009b\3\2\2\2\27\u00a2\3\2\2\2\31\u00a6\3\2\2\2"+
		"\33\u00ac\3\2\2\2\35\u00b1\3\2\2\2\37\u00b9\3\2\2\2!\u00c1\3\2\2\2#\u00c3"+
		"\3\2\2\2%\u00c5\3\2\2\2\'\u00c7\3\2\2\2)\u00c9\3\2\2\2+\u00cb\3\2\2\2"+
		"-\u00ce\3\2\2\2/\u00d4\3\2\2\2\61\u00d6\3\2\2\2\63\u00d8\3\2\2\2\65\u00da"+
		"\3\2\2\2\67\u00dc\3\2\2\29\u00de\3\2\2\2;\u00e0\3\2\2\2=\u00e2\3\2\2\2"+
		"?\u00e4\3\2\2\2A\u00e6\3\2\2\2C\u00e8\3\2\2\2E\u00ea\3\2\2\2G\u00ec\3"+
		"\2\2\2I\u00ee\3\2\2\2K\u00f0\3\2\2\2M\u00f2\3\2\2\2O\u00f4\3\2\2\2Q\u00f6"+
		"\3\2\2\2S\u00f8\3\2\2\2U\u00fa\3\2\2\2W\u00fc\3\2\2\2Y\u00fe\3\2\2\2["+
		"\u0100\3\2\2\2]\u0102\3\2\2\2_\u0104\3\2\2\2a\u0106\3\2\2\2c\u0108\3\2"+
		"\2\2ef\5\65\33\2fg\5S*\2gh\59\35\2hi\5\61\31\2ij\5W,\2jk\59\35\2k\4\3"+
		"\2\2\2lm\5W,\2mn\5\61\31\2no\5\63\32\2op\5G$\2pq\59\35\2q\6\3\2\2\2rs"+
		"\5A!\2st\5K&\2tu\5U+\2uv\59\35\2vw\5S*\2wx\5W,\2x\b\3\2\2\2yz\5A!\2z{"+
		"\5K&\2{|\5W,\2|}\5M\'\2}\n\3\2\2\2~\177\5[.\2\177\u0080\5\61\31\2\u0080"+
		"\u0081\5G$\2\u0081\u0082\5Y-\2\u0082\u0083\59\35\2\u0083\u0084\5U+\2\u0084"+
		"\f\3\2\2\2\u0085\u0086\5;\36\2\u0086\u0087\5S*\2\u0087\u0088\5M\'\2\u0088"+
		"\u0089\5I%\2\u0089\16\3\2\2\2\u008a\u008b\5]/\2\u008b\u008c\5? \2\u008c"+
		"\u008d\59\35\2\u008d\u008e\5S*\2\u008e\u008f\59\35\2\u008f\20\3\2\2\2"+
		"\u0090\u0091\5Y-\2\u0091\u0092\5O(\2\u0092\u0093\5\67\34\2\u0093\u0094"+
		"\5\61\31\2\u0094\u0095\5W,\2\u0095\u0096\59\35\2\u0096\22\3\2\2\2\u0097"+
		"\u0098\5U+\2\u0098\u0099\59\35\2\u0099\u009a\5W,\2\u009a\24\3\2\2\2\u009b"+
		"\u009c\5\67\34\2\u009c\u009d\59\35\2\u009d\u009e\5G$\2\u009e\u009f\59"+
		"\35\2\u009f\u00a0\5W,\2\u00a0\u00a1\59\35\2\u00a1\26\3\2\2\2\u00a2\u00a3"+
		"\5A!\2\u00a3\u00a4\5K&\2\u00a4\u00a5\5W,\2\u00a5\30\3\2\2\2\u00a6\u00a7"+
		"\5;\36\2\u00a7\u00a8\5G$\2\u00a8\u00a9\5M\'\2\u00a9\u00aa\5\61\31\2\u00aa"+
		"\u00ab\5W,\2\u00ab\32\3\2\2\2\u00ac\u00ad\5\67\34\2\u00ad\u00ae\5\61\31"+
		"\2\u00ae\u00af\5W,\2\u00af\u00b0\59\35\2\u00b0\34\3\2\2\2\u00b1\u00b6"+
		"\5!\21\2\u00b2\u00b5\t\2\2\2\u00b3\u00b5\5!\21\2\u00b4\u00b2\3\2\2\2\u00b4"+
		"\u00b3\3\2\2\2\u00b5\u00b8\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b7\3\2"+
		"\2\2\u00b7\36\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b9\u00be\t\2\2\2\u00ba\u00bd"+
		"\t\2\2\2\u00bb\u00bd\5!\21\2\u00bc\u00ba\3\2\2\2\u00bc\u00bb\3\2\2\2\u00bd"+
		"\u00c0\3\2\2\2\u00be\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf \3\2\2\2"+
		"\u00c0\u00be\3\2\2\2\u00c1\u00c2\t\3\2\2\u00c2\"\3\2\2\2\u00c3\u00c4\7"+
		"?\2\2\u00c4$\3\2\2\2\u00c5\u00c6\7*\2\2\u00c6&\3\2\2\2\u00c7\u00c8\7+"+
		"\2\2\u00c8(\3\2\2\2\u00c9\u00ca\7.\2\2\u00ca*\3\2\2\2\u00cb\u00cc\7=\2"+
		"\2\u00cc,\3\2\2\2\u00cd\u00cf\5/\30\2\u00ce\u00cd\3\2\2\2\u00cf\u00d0"+
		"\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2"+
		"\u00d3\b\27\2\2\u00d3.\3\2\2\2\u00d4\u00d5\t\4\2\2\u00d5\60\3\2\2\2\u00d6"+
		"\u00d7\t\5\2\2\u00d7\62\3\2\2\2\u00d8\u00d9\t\6\2\2\u00d9\64\3\2\2\2\u00da"+
		"\u00db\t\7\2\2\u00db\66\3\2\2\2\u00dc\u00dd\t\b\2\2\u00dd8\3\2\2\2\u00de"+
		"\u00df\t\t\2\2\u00df:\3\2\2\2\u00e0\u00e1\t\n\2\2\u00e1<\3\2\2\2\u00e2"+
		"\u00e3\t\13\2\2\u00e3>\3\2\2\2\u00e4\u00e5\t\f\2\2\u00e5@\3\2\2\2\u00e6"+
		"\u00e7\t\r\2\2\u00e7B\3\2\2\2\u00e8\u00e9\t\16\2\2\u00e9D\3\2\2\2\u00ea"+
		"\u00eb\t\17\2\2\u00ebF\3\2\2\2\u00ec\u00ed\t\20\2\2\u00edH\3\2\2\2\u00ee"+
		"\u00ef\t\21\2\2\u00efJ\3\2\2\2\u00f0\u00f1\t\22\2\2\u00f1L\3\2\2\2\u00f2"+
		"\u00f3\t\23\2\2\u00f3N\3\2\2\2\u00f4\u00f5\t\24\2\2\u00f5P\3\2\2\2\u00f6"+
		"\u00f7\t\25\2\2\u00f7R\3\2\2\2\u00f8\u00f9\t\26\2\2\u00f9T\3\2\2\2\u00fa"+
		"\u00fb\t\27\2\2\u00fbV\3\2\2\2\u00fc\u00fd\t\30\2\2\u00fdX\3\2\2\2\u00fe"+
		"\u00ff\t\31\2\2\u00ffZ\3\2\2\2\u0100\u0101\t\32\2\2\u0101\\\3\2\2\2\u0102"+
		"\u0103\t\33\2\2\u0103^\3\2\2\2\u0104\u0105\t\34\2\2\u0105`\3\2\2\2\u0106"+
		"\u0107\t\35\2\2\u0107b\3\2\2\2\u0108\u0109\t\36\2\2\u0109d\3\2\2\2\b\2"+
		"\u00b4\u00b6\u00bc\u00be\u00d0\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
	}
}