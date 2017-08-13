package StoreEngine.table

import StoreEngine.column.Column
import StoreEngine.fs.fileDisk
import StoreEngine.row.Row
import java.nio.ByteBuffer
import StoreEngine.value.{StringValue, IntValue}

import scala.collection.mutable.ArrayBuffer

/**
  * Created by jianwei.yang on 2017/4/22.
  */
class CommonTable extends  Table{
   override  var tableName: String = _
   override  val allRow = scala.collection.mutable.ArrayBuffer[Row]()
   override  var allColumn: Seq[Column] = Seq[Column]()

  def setTable(name:String){
    this.tableName=name
  }

  def addRow(row:Row): Seq[Row] ={


    //将文本写入到磁盘文件
    val fsdisk=new fileDisk()
    row.valueList.foreach{
      case intValue if(intValue.isInstanceOf[IntValue])=>{
       val valueByte= intValue.asInstanceOf[IntValue].getBytes()
       val data=ByteBuffer.allocate(100)
       data.put(valueByte)
       data.flip()
       while(data.hasRemaining){
         val byteRead=fsdisk.write(data,fsdisk.size())
         println(byteRead)
       }
      }
      case stringValue if(stringValue.isInstanceOf[StringValue])=>{
        val valueByte=stringValue.asInstanceOf[StringValue].getBytes()
        val data=ByteBuffer.allocate(100)
        data.put(valueByte)
        data.flip()
        while(data.hasRemaining){
          val byteRead=fsdisk.write(data,fsdisk.size())
          println(byteRead)
        }
      }
    }


    allRow+=(row)
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