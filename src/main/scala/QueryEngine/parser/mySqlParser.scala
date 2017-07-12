package QueryEngine.parser

import QueryEngine.logicPlan.logicPlanTree
import org.antlr.v4.runtime.{CommonTokenStream, CommonToken, ANTLRInputStream}
import sqlParser.{SqlLexerParser, SqlLexerLexer}

/**
  * Created by jianwei.yang on 2017/4/27.
  */
class mySqlParser  {

  def createLexerAndParser[T](command:String)(toParser:SqlLexerParser=>T):T ={
    val lexer=new SqlLexerLexer(new AntlrStringStream(command))
    val tokens=new CommonTokenStream(lexer)
    val sqlParser=new SqlLexerParser(tokens)
    toParser(sqlParser)
  }

  def parserSql(command:String):logicPlanTree=createLexerAndParser(command){sqlParser=>
      sqlParserVisitor().visitOnesql(sqlParser.onesql()) match {
        case paln:logicPlanTree => paln
      }
  }

/*  def queryTree(plan:logicPlanTree)={

  }*/


}

object  mySqlParser{
    def apply()=new mySqlParser()
}


class AntlrStringStream(input:String) extends ANTLRInputStream(input){
}