package QueryEngine.logicPlan

import StoreEngine.column.Column
import common.Catalog

/**
  * Created by jianwei.yang on 2017/6/19.
  */
case class filter_logic(val columnName: String, val compare: String, val columnValue: String, child: logicPlanTree) extends logicPlanTree {
  lazy val column: Column = Catalog.getTableColumn(tableName, columnName)
  var tableName: String = null

  def filterColumn(): Int = {
    Catalog.getCoulumnIndex(tableName, column)
  }
}
