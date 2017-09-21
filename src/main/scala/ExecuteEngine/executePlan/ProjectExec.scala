package ExecuteEngine.executePlan

import QueryEngine.executePlan.ExecutePlanTree
import QueryEngine.logicPlan.select_logic

/**
  * Created by jianwei.yang on 2017/5/14.
  */
case class ProjectExec(plan: select_logic, child: ExecutePlanTree) extends ExecutePlanTree {

  override  def next[Row]():Iterator[StoreEngine.row.Row]={
    child.next()
  }

  override  def execute(): Unit ={
    super.execute()      //让子树执行,执行完后将结果存在data里,然后坐等该节点调用
    val data=child.next() //数据从子树来
    data.toSeq.map{x=>
      x.valueList.foreach{y=>
        print(y.toString +" ")
      }
    }
  }


}

