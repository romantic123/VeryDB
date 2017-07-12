package common

import ExecuteEngine.executePlan.executeCommonUtils
import StoreEngine.column.Column
import StoreEngine.table.{CommonTable, Table}
import scala.collection.mutable._

/**
  * Created by jianwei.yang on 2017/4/27.
  */
class Catalog {




}

object Catalog {
  def apply() = new Catalog();
  val tableMap: Map[String,Table] = Map()
  val columnMap: Map[String, Column] = Map()
  
  
  def getTable(tableName:String):Option[Table]={
    if(!lookUpTable(tableName)){
      throw new Exception("表不存在")
    }
    this.tableMap.get(tableName)
  }

  def lookUpTable(tableName: String): Boolean = {
   this.tableMap.exists(x => x._1.equals(tableName))
  }

  def lookUpColumn(columnName: String): Boolean = {
   this.columnMap.exists(x => x._1.equals(columnName))
  }

  def addTableToMap(table: Table)= {
   this.tableMap+=(table.tableName -> table)
  }

  def addColumnToMap(column: Column) = {
   this.columnMap+=(column.columnName -> column)
  }

  def getTableColumn[T](table:String,column:String)={
    val  getTable=executeCommonUtils.getTableFromCatalog(table)
    getTable.getColumn(column)
  }

  def getCoulumnIndex(table:String,column:Column):Int={
    val  getTable=executeCommonUtils.getTableFromCatalog(table)
    getTable.allColumn.indexOf(column)
  }

}