package ExecuteEngine.executePlan

import QueryEngine.executePlan.DdlCommandExec
import QueryEngine.logicPlan.{insert_logic, logicPlanTree, select_logic, table_logic}

/**
  * Created by jianwei.yang on 2017/7/5.
  */
class DbExecuteTool {
  /**
    * 用来遍历所有的exec树,exec树的顺序由batch中的遍历顺序决定
    *
    * @param plan
    * @return
    */
  def ddlBatch(plan: logicPlanTree) = plan match {
    case plan: table_logic => {
      DdlCommandExec(plan, null)
    }
    case plan: insert_logic => {
      InsertExec(plan, null)
    }
    case plan: select_logic => {
      GenExecTreeStrategy.getStrategy(plan)
    }
  }
}

object DbExecuteTool {
  def apply() = new DbExecuteTool()
}
