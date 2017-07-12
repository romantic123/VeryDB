package QueryEngine.executePlan

import ExecuteEngine.executePlan.DbExecuteTool
import QueryEngine.logicPlan.logicPlanTree
import QueryEngine.optimizerPlan.optimizerPlanTree
import QueryEngine.parser.mySqlParser

/**
  * Created by jianwei.yang on 2017/4/30.
  */
class Exec {

   var testSql:String=null

   def setSql(sql:String) {
      testSql=sql
   }

   def start()={
      getPhysicalPlan(testSql).execute()
   }



   def getPhysicalPlan(sql:String): executePlanTree ={
       val logicPlan=mySqlParser().parserSql(testSql)
       val optimizerPlan=optimizerPlanTree().optimizerPlan(logicPlan)
       val physicalPlan=DbExecuteTool().ddlBatch(optimizerPlan)
      physicalPlan
   }

}

object Exec {
     def apply()=new Exec()

}
