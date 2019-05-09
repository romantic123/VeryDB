package ExecuteEngine.executePlan

import QueryEngine.executePlan.ExecutePlanTree
import StoreEngine.index.IndexCursor
import StoreEngine.index.TreeIndex.BTree.BtreeIndex
import StoreEngine.row.Row
import StoreEngine.table.CommonTable
import common.Catalog

/**
  * Created by jianwei.yang on 2017/6/26.
  */
case class ScanExec(needScanTable: CommonTable, child: ExecutePlanTree) extends ExecutePlanTree {

  var indexCursor: Seq[IndexCursor] = null
  var tableData: Iterator[Row] = null

  override def next[Row](): Iterator[StoreEngine.row.Row] = tableData

  override def execute(): Unit = {
    val tableName = needScanTable.tableName
    val columnName: String = null

    val table = Catalog.getTable(tableName) match {
      case None => throw new Exception("表不存在")
      case Some(table) => table.asInstanceOf[CommonTable]
    }
    for (i <- indexCursor) {
      i.getStart()
      for (j <- i.getStart() to i.getEnd()) {
        BtreeIndex().read(tableName, j)
      }
    }
  }


}
