package StoreEngine.column

import StoreEngine.`type`.DataType


/**
  * Created by jianwei.yang on 2017/4/22.
  */
class Column(val columnName:String,val dataType:DataType) {

          def getColumnName():String={
             columnName
          }

          def getDataType():DataType={
            dataType.getType()
          }

}


