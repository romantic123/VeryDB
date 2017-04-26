package QueryEngine.parser

import QueryEngine.logicPlan.logicPlanTree
import org.antlr.v4.runtime.RuleContext
import sqlParser.SqlLexerParser

/**
  * Created by jianwei.yang on 2017/4/23.
  */
class sqlParser extends sqlParser.SqlLexerBaseVisitor[AnyRef]{

  def VisitChild[T](ctx:RuleContext): T ={
    ctx.accept(this).asInstanceOf[T]
  }

  def getPlan(ctx:RuleContext):logicPlanTree=VisitChild(ctx)


  override  def visitCreate_statement(ctx: SqlLexerParser.Create_statementContext) : logicPlanTree = {
    val plan=getPlan(ctx.column_and_type())
    plan
  }

  override  def visitColumn_and_type(ctx: SqlLexerParser.Column_and_typeContext) : logicPlanTree ={
    val plan=getPlan(ctx)
    plan
  }

}
