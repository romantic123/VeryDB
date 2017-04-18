// Generated from SqlLexer.g4 by ANTLR 4.6
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SqlLexerParser}.
 *
 * @param <Result> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SqlLexerVisitor<Result> extends ParseTreeVisitor<Result> {
	/**
	 * Visit a parse tree produced by {@link SqlLexerParser#create_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	Result visitCreate_statement(@NotNull SqlLexerParser.Create_statementContext ctx);

	/**
	 * Visit a parse tree produced by {@link SqlLexerParser#insert_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	Result visitInsert_statement(@NotNull SqlLexerParser.Insert_statementContext ctx);

	/**
	 * Visit a parse tree produced by {@link SqlLexerParser#update_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	Result visitUpdate_statement(@NotNull SqlLexerParser.Update_statementContext ctx);

	/**
	 * Visit a parse tree produced by {@link SqlLexerParser#delete_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	Result visitDelete_statement(@NotNull SqlLexerParser.Delete_statementContext ctx);

	/**
	 * Visit a parse tree produced by {@link SqlLexerParser#datatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	Result visitDatatype(@NotNull SqlLexerParser.DatatypeContext ctx);

	/**
	 * Visit a parse tree produced by {@link SqlLexerParser#ident}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	Result visitIdent(@NotNull SqlLexerParser.IdentContext ctx);
}