package ExecuteEngine.executePlan

import StoreEngine.table.CommonTable
import common.Catalog

/**
  * Created by jianwei.yang on 2017/7/12.
  */
object ExecuteCommonUtils {

  def getTableFromCatalog(tableName: String) = {
    val table = Catalog.getTable(tableName) match {
      case None => throw new Exception("表不存在")
      case Some(table) => table.asInstanceOf[CommonTable]
    }
    table
  }

}
