package QueryEngine.logicPlan

/**
  * Created by jianwei.yang on 2017/6/19.
  */
case class scan_logic(child: logicPlanTree) extends logicPlanTree {
  var tableName: String = null
}
