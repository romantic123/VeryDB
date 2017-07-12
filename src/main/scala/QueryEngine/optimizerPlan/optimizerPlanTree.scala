package QueryEngine.optimizerPlan

import QueryEngine.Tree
import QueryEngine.logicPlan.logicPlanTree

/**
  * Created by jianwei.yang on 2017/4/30.
  */
class optimizerPlanTree extends  Tree{
     val optimizerRules=Seq(testOptimizer)

     def optimizerPlan(plan:logicPlanTree):logicPlanTree={
       optimizerRules.foldLeft(plan) {(plan_optimzer,rule)=>
        rule.apply(plan)
       }
     }

  override def child: Tree = null
}

object testOptimizer{
    def apply(logicPlan:logicPlanTree)={
      println("用于测试的优化规则..." +
        "")
      logicPlan
    }
}

object optimizerPlanTree{
  def apply()=new optimizerPlanTree()
}