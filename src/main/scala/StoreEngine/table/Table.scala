package StoreEngine.table

import StoreEngine.column.Column
import StoreEngine.row.Row

/**
  * Created by jianwei.yang on 2017/4/22.
  */
abstract class Table {
       var tableName:String
       def allRow:List[Row]
       var allColumn:Seq[Column]
}
