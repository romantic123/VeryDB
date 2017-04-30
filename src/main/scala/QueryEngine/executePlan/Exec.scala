package QueryEngine.executePlan

import QueryEngine.logicPlan.logicPlanTree
import QueryEngine.optimizerPlan.optimizerPlanTree
import QueryEngine.parser.mySqlParser

/**
  * Created by jianwei.yang on 2017/4/30.
  */
class Exec extends {

   val logicPlan=mySqlParser().parserSql("create table test(id int);")
   val optimizerPlan=optimizerPlanTree().optimizerPlan(logicPlan)
   val physicalPlan=optimizerPlan.genPhysicalPlan()

}
