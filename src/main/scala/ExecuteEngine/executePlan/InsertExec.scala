package ExecuteEngine.executePlan

import QueryEngine.executePlan.ExecutePlanTree
import QueryEngine.logicPlan.insert_logic
import StoreEngine.SEngine
import StoreEngine.`type`.DataType
import StoreEngine.row.Row
import StoreEngine.table.CommonTable
import StoreEngine.value.{IntValue, StringValue}
import common.Catalog

/**
  * Created by jianwei.yang on 2017/5/1.
  */
case class InsertExec(plan: insert_logic, child: ExecutePlanTree) extends ExecutePlanTree {


  override  def next[Row]():Iterator[StoreEngine.row.Row]={
    child.next()
  }
  /**
    * 1.获取table_logic树下的column_logic子树
    * 2.获取column_logic子树下面的List[columnName]和List[typeList]
    * 3.同时遍历两个List,每取出一个columnName和type就new出一个Column对象,将该对象添加到List[Column]中
    * 4.将该List[Column]传给CommonTable
    */
  override def execute(): Unit = {
    //先执行子树的execute()方法
    super.execute()
    val tableName=plan.tableName
    val table=Catalog.getTable(tableName) match{
      case None=> throw new Exception("表不存在")
      case Some(table) => table.asInstanceOf[CommonTable]
    }
    val TypeList=plan.expectColumn(table).foldLeft(Seq[DataType]()){ (a, b)=>
       a :+ b.dataType
    }
    val valueList=plan.Value.toIterator
    val ValueSeq=TypeList.map{
      case valueType:StoreEngine.`type`.IntType =>{
        IntValue().add(valueList.next().toInt)
      }
      case valueType:StoreEngine.`type`.StringType=>{
        StringValue().add(valueList.next().toString)
      }
    }.toArray

    val row=Row(ValueSeq)
    SEngine.storeFile(tableName,row)
    table.addRow(row)
    table
  }


}
