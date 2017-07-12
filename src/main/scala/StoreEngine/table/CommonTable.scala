package StoreEngine.table

import StoreEngine.column.Column
import StoreEngine.row.Row

/**
  * Created by jianwei.yang on 2017/4/22.
  */
class CommonTable extends  Table{
   var tableName: String = _
  override val allRow: List[Row] = List[Row]()
   var allColumn: Seq[Column] = Seq[Column]()

  def setTable(name:String){
    this.tableName=name
  }

  def addRow(row:Row): List[Row] ={
    this.allRow:+(row)
  }

  def addColumn(column:Column)={
    this.allColumn:+(column)
  }

  def setColumn(columnList:List[Column])= {
    this.allColumn = columnList.toSeq
  }

  def getColumn(column:String):Column={
    this.allColumn.filter(_.getColumnName().equalsIgnoreCase(column))(0)
  }
}

object CommonTable {
    def apply()=new CommonTable()
}