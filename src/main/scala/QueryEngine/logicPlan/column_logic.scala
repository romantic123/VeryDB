package QueryEngine.logicPlan

import StoreEngine.datatype.DataType

/**
  * Created by jianwei.yang on 2017/4/28.
  */
case class column_logic(columnList:List[String],typeList:List[String],child: logicPlanTree)extends logicPlanTree{
}
