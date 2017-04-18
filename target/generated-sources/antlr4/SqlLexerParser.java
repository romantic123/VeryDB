// Generated from SqlLexer.g4 by ANTLR 4.6
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

public class SqlLexerParser extends Parser {
	public static final int
		CREATE=1, TABLE=2, INSERT=3, INTO=4, VALUES=5, FROM=6, WHERE=7, UPDATE=8, 
		SET=9, DELETE=10, INT=11, FLOAT=12, DATE=13, FIRST_NUMBER=14, FIRST_CHAR=15, 
		DIGIT=16, EQUAL=17, CURVES_LEFT=18, CURVES_RIGHT=19, COMMA=20, SEMICOLON=21, 
		L_WS=22, L_BLANK=23;
	public static final int
		RULE_create_statement = 0, RULE_insert_statement = 1, RULE_update_statement = 2, 
		RULE_delete_statement = 3, RULE_datatype = 4, RULE_ident = 5;
	public static final String[] ruleNames = {
		"create_statement", "insert_statement", "update_statement", "delete_statement", 
		"datatype", "ident"
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

	@Override
	public String getGrammarFileName() { return "SqlLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	public SqlLexerParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN);
	}
	public static class Create_statementContext extends ParserRuleContext {
		public TerminalNode CREATE() { return getToken(SqlLexerParser.CREATE, 0); }
		public TerminalNode TABLE() { return getToken(SqlLexerParser.TABLE, 0); }
		public TerminalNode FIRST_CHAR() { return getToken(SqlLexerParser.FIRST_CHAR, 0); }
		public TerminalNode CURVES_LEFT() { return getToken(SqlLexerParser.CURVES_LEFT, 0); }
		public TerminalNode CURVES_RIGHT() { return getToken(SqlLexerParser.CURVES_RIGHT, 0); }
		public TerminalNode SEMICOLON() { return getToken(SqlLexerParser.SEMICOLON, 0); }
		public List<? extends IdentContext> ident() {
			return getRuleContexts(IdentContext.class);
		}
		public IdentContext ident(int i) {
			return getRuleContext(IdentContext.class,i);
		}
		public List<? extends DatatypeContext> datatype() {
			return getRuleContexts(DatatypeContext.class);
		}
		public DatatypeContext datatype(int i) {
			return getRuleContext(DatatypeContext.class,i);
		}
		public List<? extends TerminalNode> COMMA() { return getTokens(SqlLexerParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlLexerParser.COMMA, i);
		}
		public Create_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlLexerListener ) ((SqlLexerListener)listener).enterCreate_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlLexerListener ) ((SqlLexerListener)listener).exitCreate_statement(this);
		}
		@Override
		public <Result> Result accept(ParseTreeVisitor<? extends Result> visitor) {
			if ( visitor instanceof SqlLexerVisitor<?> ) return ((SqlLexerVisitor<? extends Result>)visitor).visitCreate_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	@RuleVersion(0)
	public final Create_statementContext create_statement() throws RecognitionException {
		Create_statementContext _localctx = new Create_statementContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_create_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(12);
			match(CREATE);
			setState(13);
			match(TABLE);
			setState(14);
			match(FIRST_CHAR);
			setState(15);
			match(CURVES_LEFT);
			setState(21); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(16);
				ident();
				setState(17);
				datatype();
				setState(19);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(18);
					match(COMMA);
					}
				}

				}
				}
				setState(23); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==FIRST_NUMBER || _la==FIRST_CHAR );
			setState(25);
			match(CURVES_RIGHT);
			setState(26);
			match(SEMICOLON);
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

	public static class Insert_statementContext extends ParserRuleContext {
		public TerminalNode INSERT() { return getToken(SqlLexerParser.INSERT, 0); }
		public TerminalNode INTO() { return getToken(SqlLexerParser.INTO, 0); }
		public TerminalNode FIRST_CHAR() { return getToken(SqlLexerParser.FIRST_CHAR, 0); }
		public TerminalNode VALUES() { return getToken(SqlLexerParser.VALUES, 0); }
		public TerminalNode CURVES_LEFT() { return getToken(SqlLexerParser.CURVES_LEFT, 0); }
		public TerminalNode CURVES_RIGHT() { return getToken(SqlLexerParser.CURVES_RIGHT, 0); }
		public TerminalNode SEMICOLON() { return getToken(SqlLexerParser.SEMICOLON, 0); }
		public List<? extends IdentContext> ident() {
			return getRuleContexts(IdentContext.class);
		}
		public IdentContext ident(int i) {
			return getRuleContext(IdentContext.class,i);
		}
		public List<? extends TerminalNode> COMMA() { return getTokens(SqlLexerParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlLexerParser.COMMA, i);
		}
		public Insert_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insert_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlLexerListener ) ((SqlLexerListener)listener).enterInsert_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlLexerListener ) ((SqlLexerListener)listener).exitInsert_statement(this);
		}
		@Override
		public <Result> Result accept(ParseTreeVisitor<? extends Result> visitor) {
			if ( visitor instanceof SqlLexerVisitor<?> ) return ((SqlLexerVisitor<? extends Result>)visitor).visitInsert_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	@RuleVersion(0)
	public final Insert_statementContext insert_statement() throws RecognitionException {
		Insert_statementContext _localctx = new Insert_statementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_insert_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			match(INSERT);
			setState(29);
			match(INTO);
			setState(30);
			match(FIRST_CHAR);
			setState(31);
			match(VALUES);
			setState(32);
			match(CURVES_LEFT);
			setState(37); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(33);
				ident();
				setState(35);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(34);
					match(COMMA);
					}
				}

				}
				}
				setState(39); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==FIRST_NUMBER || _la==FIRST_CHAR );
			setState(41);
			match(CURVES_RIGHT);
			setState(42);
			match(SEMICOLON);
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

	public static class Update_statementContext extends ParserRuleContext {
		public TerminalNode UPDATE() { return getToken(SqlLexerParser.UPDATE, 0); }
		public TerminalNode FIRST_CHAR() { return getToken(SqlLexerParser.FIRST_CHAR, 0); }
		public TerminalNode SET() { return getToken(SqlLexerParser.SET, 0); }
		public List<? extends IdentContext> ident() {
			return getRuleContexts(IdentContext.class);
		}
		public IdentContext ident(int i) {
			return getRuleContext(IdentContext.class,i);
		}
		public List<? extends TerminalNode> EQUAL() { return getTokens(SqlLexerParser.EQUAL); }
		public TerminalNode EQUAL(int i) {
			return getToken(SqlLexerParser.EQUAL, i);
		}
		public TerminalNode SEMICOLON() { return getToken(SqlLexerParser.SEMICOLON, 0); }
		public TerminalNode WHERE() { return getToken(SqlLexerParser.WHERE, 0); }
		public Update_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_update_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlLexerListener ) ((SqlLexerListener)listener).enterUpdate_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlLexerListener ) ((SqlLexerListener)listener).exitUpdate_statement(this);
		}
		@Override
		public <Result> Result accept(ParseTreeVisitor<? extends Result> visitor) {
			if ( visitor instanceof SqlLexerVisitor<?> ) return ((SqlLexerVisitor<? extends Result>)visitor).visitUpdate_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	@RuleVersion(0)
	public final Update_statementContext update_statement() throws RecognitionException {
		Update_statementContext _localctx = new Update_statementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_update_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			match(UPDATE);
			setState(45);
			match(FIRST_CHAR);
			setState(46);
			match(SET);
			setState(47);
			ident();
			setState(48);
			match(EQUAL);
			setState(49);
			ident();
			{
			setState(50);
			match(WHERE);
			setState(51);
			ident();
			setState(52);
			match(EQUAL);
			setState(53);
			ident();
			}
			setState(55);
			match(SEMICOLON);
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

	public static class Delete_statementContext extends ParserRuleContext {
		public TerminalNode DELETE() { return getToken(SqlLexerParser.DELETE, 0); }
		public TerminalNode FROM() { return getToken(SqlLexerParser.FROM, 0); }
		public TerminalNode FIRST_CHAR() { return getToken(SqlLexerParser.FIRST_CHAR, 0); }
		public TerminalNode WHERE() { return getToken(SqlLexerParser.WHERE, 0); }
		public List<? extends IdentContext> ident() {
			return getRuleContexts(IdentContext.class);
		}
		public IdentContext ident(int i) {
			return getRuleContext(IdentContext.class,i);
		}
		public TerminalNode EQUAL() { return getToken(SqlLexerParser.EQUAL, 0); }
		public TerminalNode SEMICOLON() { return getToken(SqlLexerParser.SEMICOLON, 0); }
		public Delete_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_delete_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlLexerListener ) ((SqlLexerListener)listener).enterDelete_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlLexerListener ) ((SqlLexerListener)listener).exitDelete_statement(this);
		}
		@Override
		public <Result> Result accept(ParseTreeVisitor<? extends Result> visitor) {
			if ( visitor instanceof SqlLexerVisitor<?> ) return ((SqlLexerVisitor<? extends Result>)visitor).visitDelete_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	@RuleVersion(0)
	public final Delete_statementContext delete_statement() throws RecognitionException {
		Delete_statementContext _localctx = new Delete_statementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_delete_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			match(DELETE);
			setState(58);
			match(FROM);
			setState(59);
			match(FIRST_CHAR);
			setState(60);
			match(WHERE);
			setState(61);
			ident();
			setState(62);
			match(EQUAL);
			setState(63);
			ident();
			setState(64);
			match(SEMICOLON);
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

	public static class DatatypeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(SqlLexerParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(SqlLexerParser.FLOAT, 0); }
		public TerminalNode DATE() { return getToken(SqlLexerParser.DATE, 0); }
		public DatatypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datatype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlLexerListener ) ((SqlLexerListener)listener).enterDatatype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlLexerListener ) ((SqlLexerListener)listener).exitDatatype(this);
		}
		@Override
		public <Result> Result accept(ParseTreeVisitor<? extends Result> visitor) {
			if ( visitor instanceof SqlLexerVisitor<?> ) return ((SqlLexerVisitor<? extends Result>)visitor).visitDatatype(this);
			else return visitor.visitChildren(this);
		}
	}

	@RuleVersion(0)
	public final DatatypeContext datatype() throws RecognitionException {
		DatatypeContext _localctx = new DatatypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_datatype);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << FLOAT) | (1L << DATE))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				if (_input.LA(1) == Token.EOF) {
					matchedEOF = true;
				}

				_errHandler.reportMatch(this);
				consume();
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

	public static class IdentContext extends ParserRuleContext {
		public TerminalNode FIRST_NUMBER() { return getToken(SqlLexerParser.FIRST_NUMBER, 0); }
		public TerminalNode FIRST_CHAR() { return getToken(SqlLexerParser.FIRST_CHAR, 0); }
		public IdentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ident; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlLexerListener ) ((SqlLexerListener)listener).enterIdent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlLexerListener ) ((SqlLexerListener)listener).exitIdent(this);
		}
		@Override
		public <Result> Result accept(ParseTreeVisitor<? extends Result> visitor) {
			if ( visitor instanceof SqlLexerVisitor<?> ) return ((SqlLexerVisitor<? extends Result>)visitor).visitIdent(this);
			else return visitor.visitChildren(this);
		}
	}

	@RuleVersion(0)
	public final IdentContext ident() throws RecognitionException {
		IdentContext _localctx = new IdentContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_ident);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			_la = _input.LA(1);
			if ( !(_la==FIRST_NUMBER || _la==FIRST_CHAR) ) {
			_errHandler.recoverInline(this);
			} else {
				if (_input.LA(1) == Token.EOF) {
					matchedEOF = true;
				}

				_errHandler.reportMatch(this);
				consume();
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

	public static final String _serializedATN =
		"\3\uaf6f\u8320\u479d\ub75c\u4880\u1605\u191c\uab37\3\31I\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\26"+
		"\n\2\6\2\30\n\2\r\2\16\2\31\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5"+
		"\3&\n\3\6\3(\n\3\r\3\16\3)\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3"+
		"\7\3\7\2\2\2\b\2\2\4\2\6\2\b\2\n\2\f\2\2\4\3\2\r\17\3\2\20\21F\2\16\3"+
		"\2\2\2\4\36\3\2\2\2\6.\3\2\2\2\b;\3\2\2\2\nD\3\2\2\2\fF\3\2\2\2\16\17"+
		"\7\3\2\2\17\20\7\4\2\2\20\21\7\21\2\2\21\27\7\24\2\2\22\23\5\f\7\2\23"+
		"\25\5\n\6\2\24\26\7\26\2\2\25\24\3\2\2\2\25\26\3\2\2\2\26\30\3\2\2\2\27"+
		"\22\3\2\2\2\30\31\3\2\2\2\31\27\3\2\2\2\31\32\3\2\2\2\32\33\3\2\2\2\33"+
		"\34\7\25\2\2\34\35\7\27\2\2\35\3\3\2\2\2\36\37\7\5\2\2\37 \7\6\2\2 !\7"+
		"\21\2\2!\"\7\7\2\2\"\'\7\24\2\2#%\5\f\7\2$&\7\26\2\2%$\3\2\2\2%&\3\2\2"+
		"\2&(\3\2\2\2\'#\3\2\2\2()\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*+\3\2\2\2+,\7\25"+
		"\2\2,-\7\27\2\2-\5\3\2\2\2./\7\n\2\2/\60\7\21\2\2\60\61\7\13\2\2\61\62"+
		"\5\f\7\2\62\63\7\23\2\2\63\64\5\f\7\2\64\65\7\t\2\2\65\66\5\f\7\2\66\67"+
		"\7\23\2\2\678\5\f\7\289\3\2\2\29:\7\27\2\2:\7\3\2\2\2;<\7\f\2\2<=\7\b"+
		"\2\2=>\7\21\2\2>?\7\t\2\2?@\5\f\7\2@A\7\23\2\2AB\5\f\7\2BC\7\27\2\2C\t"+
		"\3\2\2\2DE\t\2\2\2E\13\3\2\2\2FG\t\3\2\2G\r\3\2\2\2\6\25\31%)";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
	}
}