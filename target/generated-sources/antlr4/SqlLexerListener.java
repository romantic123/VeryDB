// Generated from SqlLexer.g4 by ANTLR 4.6
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SqlLexerParser}.
 */
public interface SqlLexerListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SqlLexerParser#create_statement}.
	 * @param ctx the parse tree
	 */
	void enterCreate_statement(@NotNull SqlLexerParser.Create_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlLexerParser#create_statement}.
	 * @param ctx the parse tree
	 */
	void exitCreate_statement(@NotNull SqlLexerParser.Create_statementContext ctx);

	/**
	 * Enter a parse tree produced by {@link SqlLexerParser#insert_statement}.
	 * @param ctx the parse tree
	 */
	void enterInsert_statement(@NotNull SqlLexerParser.Insert_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlLexerParser#insert_statement}.
	 * @param ctx the parse tree
	 */
	void exitInsert_statement(@NotNull SqlLexerParser.Insert_statementContext ctx);

	/**
	 * Enter a parse tree produced by {@link SqlLexerParser#update_statement}.
	 * @param ctx the parse tree
	 */
	void enterUpdate_statement(@NotNull SqlLexerParser.Update_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlLexerParser#update_statement}.
	 * @param ctx the parse tree
	 */
	void exitUpdate_statement(@NotNull SqlLexerParser.Update_statementContext ctx);

	/**
	 * Enter a parse tree produced by {@link SqlLexerParser#delete_statement}.
	 * @param ctx the parse tree
	 */
	void enterDelete_statement(@NotNull SqlLexerParser.Delete_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlLexerParser#delete_statement}.
	 * @param ctx the parse tree
	 */
	void exitDelete_statement(@NotNull SqlLexerParser.Delete_statementContext ctx);

	/**
	 * Enter a parse tree produced by {@link SqlLexerParser#datatype}.
	 * @param ctx the parse tree
	 */
	void enterDatatype(@NotNull SqlLexerParser.DatatypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlLexerParser#datatype}.
	 * @param ctx the parse tree
	 */
	void exitDatatype(@NotNull SqlLexerParser.DatatypeContext ctx);

	/**
	 * Enter a parse tree produced by {@link SqlLexerParser#ident}.
	 * @param ctx the parse tree
	 */
	void enterIdent(@NotNull SqlLexerParser.IdentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlLexerParser#ident}.
	 * @param ctx the parse tree
	 */
	void exitIdent(@NotNull SqlLexerParser.IdentContext ctx);
}