package common

import ExecuteEngine.executePlan.executeCommonUtils
import StoreEngine.`type`.{DataType, IntType, StringType}
import StoreEngine.column.Column
import StoreEngine.table.{CommonTable, Table}
import StoreEngine.value.{IntValue, StringValue}

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

  val tableMapValueType: scala.collection.mutable.Map[String, scala.collection.mutable.ArrayBuffer[DataType]] = scala.collection.mutable.Map()


  def getTableMapValueType(tableName: String): Option[ArrayBuffer[DataType]] = {
    tableMapValueType.get(tableName)
  }


  /**
    * 计算一行数据的大小
    */
  def getRowSize(tableName: String): Int = {

    getTableMapValueType(tableName) match {
      case Some(columnTypes) => {
        var size = 0;
        columnTypes.foreach {
          case columnType: IntType => {
            size += IntType().size
          }
          case columnType: StringType => {
            size += StringType().size
          }

        }
        size
      }
      case None =>{
        throw  new Exception("此表不存在!")
      }
    }

  }


  def getRootNodeFilePos(tableName: String): Option[Int] = {
    if (!lookUpTable(tableName)) {
      throw new Exception("表不存在")
    }
    rootNodeFilePos.get(tableName)
  }


  def setRootNodeFilePos(tableName: String, filePos: Int) = {
    if (!lookUpTable(tableName)) {
      throw new Exception("表不存在")
    }
    rootNodeFilePos += (tableName -> filePos)
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

  def addTableMapValueType(tableName: String, column: Column) = {
    tableMapValueType.get(tableName) match {
      case Some(typeList) => {
        val newTypeList = typeList :+ column.getDataType()
        tableMapValueType.update(tableName, newTypeList)
      }
      case None => {
        val newList:scala.collection.mutable.ArrayBuffer[DataType]=new scala.collection.mutable.ArrayBuffer()
        newList+=column.getDataType()
        tableMapValueType +=(tableName->newList)
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