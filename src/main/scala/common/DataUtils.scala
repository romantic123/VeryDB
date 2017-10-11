package common

import java.nio.ByteBuffer

import StoreEngine.`type`.{IntType, StringType}
import StoreEngine.row.Row
import StoreEngine.value.{IntValue, StringValue}

object DataUtils {
  def readString(buff: ByteBuffer): String = {
    //第一个存储Int值,该Int的值为String的长度
    val len: Int = buff.getInt()
    //读取所有String
    val byteArray: Array[Byte] = new Array[Byte](len)
    for (i <- 0 until len) {
      byteArray(i) = buff.get()
    }
    new String(byteArray)
  }


  /**
    * 将row写入到buffer中
    *
    * @param tableName
    * @param buff
    * @param row
    */
  def writeRow(tableName: String, buff: ByteBuffer, row: Row) = {
    val valueIterator = row.valueList.toIterator
    Catalog.getTableMapValueType(tableName) match {
      case Some(typeList) => {
        typeList.foreach {
          case valueType: IntType =>
            buff.putInt(valueIterator.next().asInstanceOf[IntValue].get())
          case valueType: StringType =>
            val strValue = valueIterator.next().asInstanceOf[StringValue]
            buff.putInt(strValue.size)
            buff.put(strValue.data.getBytes)
        }
      }
      case None => {

      }
    }
  }
}