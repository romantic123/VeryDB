package StoreEngine.table

import StoreEngine.column.Column
import StoreEngine.row.Row

/**
  * Created by jianwei.yang on 2017/4/22.
  */
abstract  class Table {
       var tableName:String
       val allRow:List[Row]
       val allColumn:List[Column]
}
