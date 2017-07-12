package ExecuteEngine.executePlan

import QueryEngine.executePlan.executePlanTree
import QueryEngine.logicPlan.select_logic
import StoreEngine.table.CommonTable
import StoreEngine.value.{IntValue, Value}
import common.Catalog

/**
  * Created by jianwei.yang on 2017/5/14.
  */
case class projectExec(plan:select_logic,child:executePlanTree) extends executePlanTree{

  override  def next[Row]():Iterator[StoreEngine.row.Row]={
    child.next()
  }

  override  def execute(): Unit ={
    super.execute()      //让子树执行,执行完后将结果存在data里,然后坐等该节点调用
    val data=next() //数据从子树来
    data.map{x=>
      println(x)
    }


  }


}
