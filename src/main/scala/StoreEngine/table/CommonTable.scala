package StoreEngine.table

import StoreEngine.column.Column
import StoreEngine.row.Row

/**
  * Created by jianwei.yang on 2017/4/22.
  */
class CommonTable extends  Table{
  override var tableName: String = _
  override val allRow: List[Row] = List[Row]()
  override val allColumn: List[Column] = List[Column]()

  def setTable(name:String){
    this.tableName=name
  }

  def addRow(row:Row): List[Row] ={
    allRow:+(row)
  }


}

object CommonTable {
    def apply()=new CommonTable()
}