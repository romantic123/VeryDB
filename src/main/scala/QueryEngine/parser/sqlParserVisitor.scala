package QueryEngine.parser

import QueryEngine.logicPlan._
import common.Catalog
import org.antlr.v4.runtime.RuleContext
import sqlParser.SqlLexerParser
import sqlParser.SqlLexerParser.{OnesqlContext, DatatypeContext, IdentContext}
import collection.JavaConversions._

/**
  * Created by jianwei.yang on 2017/4/23.
  */
class sqlParserVisitor extends sqlParser.SqlLexerBaseVisitor[AnyRef] {

  /**
    * 一个节点有多个子节点的时候,使用该方法,visitChildren()会遍历ctx所有的子节点
    *
    * @param ctx
    * @tparam T
    * @return
    */
  def VisitChild[T](ctx: RuleContext): T = {
    visitChildren(ctx).asInstanceOf[T]
  }

  /**
    * 传进来一个ctx节点,就遍历该节点
    *
    * @param ctx
    * @return
    */

  def getPlan(ctx: RuleContext): logicPlanTree = {
    ctx.accept(this).asInstanceOf[logicPlanTree]
  }


  override def visitOnesql(ctx: SqlLexerParser.OnesqlContext): logicPlanTree = {
    // 遍历stmt节点,就是进入visitStmt方法
    getPlan(ctx.stmt())
  }


  override def visitStmt(ctx: SqlLexerParser.StmtContext): logicPlanTree = {
    // 遍历ctx的所有子节点
    VisitChild(ctx)
  }


  override def visitCreate_statement(ctx: SqlLexerParser.Create_statementContext): logicPlanTree = {
    val tableName = ctx.FIRST_CHAR().getText
    val tableisExist = Catalog.lookUpTable(tableName)
    if (tableisExist) throw new Exception("table is exists!")
    val column = getPlan(ctx.column_and_type())
    val table = table_logic(tableName, None,column)
    table
  }

  override def visitColumn_and_type(ctx: SqlLexerParser.Column_and_typeContext): logicPlanTree = {
    val coumnList = ctx.ident()
    val typeList = ctx.datatype()
    //TODO 下面两个方法,可以优化
    val iterator_column = ctx.ident().toIterator
    val columnList = iterator_column.foldLeft(List[String]()) { (a, b) =>
        a :+ (b.getText)
    }
    val iterator_dataType = ctx.datatype().toIterator
    val dataTyleList = iterator_dataType.foldLeft(List[String]()) { (a, b) =>
         a :+ (b.getText)
    }
    val column = column_logic(columnList, dataTyleList,null)
    column
  }

  override def visitInsert_statement(ctx: SqlLexerParser.Insert_statementContext):logicPlanTree = {
    val insertTable=ctx.FIRST_CHAR().getText
    val iterator_value=ctx.ident().toIterator
    val valueList=iterator_value.foldLeft(List[String]()){(a,b)=>
        a :+ (b.getText)
    }
    val insert_value=insert_logic(insertTable,valueList,null)
    insert_value
  }


  override def visitFilter_list(ctx:SqlLexerParser.Filter_listContext):logicPlanTree={
    val filterColumn=ctx.ident(0).getText;
    var compare:String=null
    if(ctx.EQUAL()!=null){
      compare="equals"
    }else if(ctx.GREATER()!=null){
      compare="greater"
    }else if(ctx.LESS()!=null){
      compare="less"
    }
    val filtervalue=ctx.ident(1).getText
    val scanLogic=scan_logic(null)
    filter_logic(filterColumn,compare,filtervalue,scanLogic)
  }


//TODO 此处待优化
  override def visitSelect_statement(ctx: SqlLexerParser.Select_statementContext):logicPlanTree = {
    var filterInfo=visitFilter_list(ctx.filter_list())
    val selectTable=ctx.FIRST_CHAR().getText
    filterInfo.asInstanceOf[filter_logic].tableName=selectTable
    filterInfo.asInstanceOf[filter_logic].child.asInstanceOf[scan_logic].tableName=selectTable
    val item_list=ctx.item_list().ident().map{x=>
      x.getText
    }.toList
    val select_table=select_logic(selectTable,item_list,filterInfo)
    select_table
  }


}

object  sqlParserVisitor {
  def apply()=new sqlParserVisitor()
}
