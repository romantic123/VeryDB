package QueryEngine.logicPlan

import StoreEngine.table.CommonTable
import common.Catalog

/**
  * Created by jianwei.yang on 2017/6/19.
  */
case class select_logic(val tableName: String, val itemList: List[String], child: logicPlanTree) extends logicPlanTree {

  val filter = child.asInstanceOf[filter_logic]


  val table = Catalog.getTable(tableName) match {
    case None => throw new Exception("表不存在")
    case Some(table) => table.asInstanceOf[CommonTable]
  }

}
