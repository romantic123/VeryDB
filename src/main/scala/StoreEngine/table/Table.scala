package StoreEngine.table

import StoreEngine.column.Column
import StoreEngine.row.Row

import scala.collection.mutable.ArrayBuffer

/**
  * Created by jianwei.yang on 2017/4/22.
  */
abstract class Table {
       var tableName:String
       val allRow:ArrayBuffer[Row]
       var allColumn:Seq[Column]
}
