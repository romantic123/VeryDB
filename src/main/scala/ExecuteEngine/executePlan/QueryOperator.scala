package ExecuteEngine.executePlan

import QueryEngine.executePlan.ExecutePlanTree
import QueryEngine.logicPlan.{filter_logic, logicPlanTree, scan_logic, select_logic}
import common.Catalog

/**
  * Created by jianwei.yang on 2017/7/11.
  */
object QueryOperator {
  def apply(plan: logicPlanTree): ExecutePlanTree = plan match {
    case plan: select_logic => {
      ProjectExec(plan, convertLogic.logic2Physic(plan.child))
    }
    //在此处假设filter的子树一定是scan树,此处的顺序可在optimizer处调整
    case plan: filter_logic => {
      FilterExec(plan, convertLogic.logic2Physic(plan.child))
    }
    case plan: scan_logic => {
      val getTableOrNone = Catalog.getTable(plan.tableName)
      val scanTable = ExecuteCommonUtils.getTableFromCatalog(plan.tableName)
      ScanExec(scanTable, null)
    }
  }

}

object convertLogic {
  def logic2Physic(plan: logicPlanTree): ExecutePlanTree = {
    QueryOperator(plan)
  }
}