package common

import ExecuteEngine.executePlan.executeCommonUtils
import StoreEngine.`type`.DataType
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
  //tableMap中的key是表名,value是table的实例
  val tableMap: Map[String, Table] = Map()
  //columnMap中的key是列名,value是column的实例
  val columnMap: Map[String, Column] = Map()
  //rootNodeFilePos中key是表名,value是Btree中root page的pos
  var rootNodeFilePos: Map[String, Int] = Map()

  val tableMapValueType: Map[String, scala.collection.mutable.LinkedList[Int]] = Map()


  def getTableMapValueType(tableName: String): Option[LinkedList[Int]]= {
    tableMapValueType.get(tableName)
  }



  def getRootNodeFilePos(tableName: String): Option[Int] = {
    if (!lookUpTable(tableName)) {
      throw new Exception("表不存在")
    }
    rootNodeFilePos.get(tableName)
  }


  def setRootNodeFilePos(tableName: String,filePos:Int) = {
    if (!lookUpTable(tableName)) {
      throw new Exception("表不存在")
    }
    rootNodeFilePos+=(tableName->filePos)
  }



  def getTable(tableName: String): Option[Table] = {
    if (!lookUpTable(tableName)) {
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

  def addTableToMap(table: Table) = {
    this.tableMap += (table.tableName -> table)
  }

  def addColumnToMap(column: Column) = {
    this.columnMap += (column.columnName -> column)
  }

  def addTableMapValueType(tableName:String,column: Column)={
    tableMapValueType.get(tableName) match{
      case Some(typeList)=>{
        val newTypeList=typeList:+column.getDataType()
        tableMapValueType.update(tableName,newTypeList)
      }
      case None=>{
        throw new Exception("从元数据表中查找不到该表的元数据信息:行的数据类型")
      }
    }
    column.dataType.getType()
  }

  def getTableColumn[T](table: String, column: String) = {
    val getTable = executeCommonUtils.getTableFromCatalog(table)
    getTable.getColumn(column)
  }

  def getCoulumnIndex(table: String, column: Column): Int = {
    val getTable = executeCommonUtils.getTableFromCatalog(table)
    getTable.allColumn.indexOf(column)
  }

}