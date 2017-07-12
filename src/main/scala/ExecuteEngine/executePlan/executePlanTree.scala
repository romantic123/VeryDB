package QueryEngine.executePlan

import ExecuteEngine.executePlan.InsertExec
import QueryEngine.Tree
import QueryEngine.logicPlan._
import StoreEngine.row.Row

/**  * Created by jianwei.yang on 2017/4/30.
  */
abstract  class executePlanTree extends Tree{


  def next[Row]():Iterator[StoreEngine.row.Row]
  override def child:executePlanTree //定义子树



  /**
    * 执行孩子节点的execute()方法
    */

  def execute(): Unit ={
    if(child!=null){
      child.execute()
    }
  }

}

