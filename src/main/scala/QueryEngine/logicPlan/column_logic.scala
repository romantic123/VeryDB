package QueryEngine.logicPlan

import StoreEngine.`type`.DataType


/**
  * Created by jianwei.yang on 2017/4/28.
  */
case class column_logic(columnList:List[String], typeList:List[DataType], child: logicPlanTree)extends logicPlanTree{
}
