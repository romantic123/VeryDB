package StoreEngine.column

import StoreEngine.datatype.DataType

/**
  * Created by jianwei.yang on 2017/4/22.
  */
class Column(val columnName:String,val dataType:String) {

          def getColumnName():String={
             columnName
          }

          def getDataType():String={
            dataType
          }

}


