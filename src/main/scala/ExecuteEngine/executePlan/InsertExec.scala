package ExecuteEngine.executePlan

import QueryEngine.executePlan.executePlanTree
import QueryEngine.logicPlan.{insert_logic, column_logic, table_logic}
import StoreEngine.column.Column
import StoreEngine.row.Row
import StoreEngine.table.CommonTable
import StoreEngine.value.{Value, IntValue, StringValue}
import common.Catalog

/**
  * Created by jianwei.yang on 2017/5/1.
  */
case class InsertExec(plan: insert_logic,child:executePlanTree) extends executePlanTree {


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
    val TypeList=plan.expectColumn(table).foldLeft(Seq[String]()){(a,b)=>
       a :+ b.getDataType()
    }
    val valueList=plan.Value.toIterator
    val ValueSeq=TypeList.map{
      case valueType if(valueType.equalsIgnoreCase("int"))=>{
        IntValue().add(valueList.next().toInt)
      }
      case valueType if(valueType.equalsIgnoreCase("String"))=>{
        StringValue().add(valueList.next().toString)
      }
      case valueType if(valueType.startsWith("varchar"))=>{
        StringValue().size=valueType.substring(valueType.indexOf('('),valueType.indexOf(')')).toInt  //将varchar的size更新到Row的size属性中
        StringValue().add(valueList.next().toString)
      }
    }.toArray

    val row=Row(ValueSeq)
    table.addRow(row)
    table
  }


}
