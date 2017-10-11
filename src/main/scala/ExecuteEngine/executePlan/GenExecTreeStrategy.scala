package ExecuteEngine.executePlan

import QueryEngine.executePlan.ExecutePlanTree
import QueryEngine.logicPlan.logicPlanTree

/**
  * Created by jianwei.yang on 2017/7/10.
  */
object GenExecTreeStrategy {

  def getStrategy(plan: logicPlanTree): ExecutePlanTree = {
    QueryOperator(plan)
  }

}
