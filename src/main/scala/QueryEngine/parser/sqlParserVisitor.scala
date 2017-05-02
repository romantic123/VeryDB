package QueryEngine.parser

import QueryEngine.logicPlan.{column_logic, table_logic, logicPlanTree}
import common.Catalog
import org.antlr.v4.runtime.RuleContext
import sqlParser.SqlLexerParser
import sqlParser.SqlLexerParser.{DatatypeContext, IdentContext}

/**
  * Created by jianwei.yang on 2017/4/23.
  */
class sqlParserVisitor extends sqlParser.SqlLexerBaseVisitor[AnyRef]{

  def VisitChild[T](ctx:RuleContext): T ={
    ctx.accept(this).asInstanceOf[T]
  }

  def getPlan(ctx:RuleContext):logicPlanTree=VisitChild(ctx)


  /**
    *
    * @param ctx the parse tree
    *   */
  override  def visitCreate_statement(ctx: SqlLexerParser.Create_statementContext) : logicPlanTree = {
    val tableName=ctx.FIRST_CHAR().getText
    val tableisExist=Catalog.lookUpTable(tableName)
    if (!tableisExist) throw new Exception ("table is exists!")
    val table=table_logic(tableName,None)
    val column=getPlan(ctx.column_and_type())
    table.leaf=column
     table
  }

  override  def visitColumn_and_type(ctx: SqlLexerParser.Column_and_typeContext) : logicPlanTree ={
    def f[T]=(list:java.util.List[T])=>List[String]{
      case list:List[_<:RuleContext]=>
      val resList=list.foldLeft(List[String]()){(a,b)=>
           val res= a +: (b.getText)
            res.asInstanceOf[List[String]]
      }
    }
    val coumnList=ctx.ident()
    val typeList=ctx.datatype()
    val column=column_logic(f(ctx.ident()),f(ctx.datatype()))
    column
  }


  override  def visitStmt(ctx:SqlLexerParser.StmtContext):logicPlanTree={
    val plan=getPlan(ctx)
    plan
  }

}

object  sqlParserVisitor {
  def apply()=new sqlParserVisitor()
}
