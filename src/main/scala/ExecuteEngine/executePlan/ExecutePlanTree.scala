package QueryEngine.executePlan

import QueryEngine.Tree

/**  * Created by jianwei.yang on 2017/4/30.
  */
abstract class ExecutePlanTree extends Tree {


  def next[Row]():Iterator[StoreEngine.row.Row]

  override def child: ExecutePlanTree //定义子树



  /**
    * 执行孩子节点的execute()方法
    */

  def execute(): Unit ={
    if(child!=null){
      child.execute()
    }
  }

}

