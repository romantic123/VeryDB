package ExecuteEngine.executePlan

import QueryEngine.executePlan.ExecutePlanTree
import QueryEngine.logicPlan.filter_logic
import StoreEngine.index.IndexCursor
import StoreEngine.row.Row
import StoreEngine.value.{IntValue, StringValue, Value}
import common.Catalog

/**
  * Created by jianwei.yang on 2017/6/24.
  */
case class FilterExec(plan: filter_logic, child: ExecutePlanTree) extends ExecutePlanTree {

  var data: Iterator[Row] = null

  override def next[Row](): Iterator[StoreEngine.row.Row] = {
    data
  }

  def getIndexCursorSeq(): Unit = {
    Catalog.clusterIndexColumn.get(plan.tableName)
    new IndexCursor()
    plan.column
  }

  override def execute(): Unit = {
    super.execute()
    if (child.isInstanceOf[ScanExec]) {
      child.asInstanceOf[ScanExec].indexCursor
    }
    data = child.next()
    val filterIndex = plan.filterColumn()

    def compareEquals(value: Value): Boolean = {
      var res: Boolean = false
      if (value.isInstanceOf[IntValue]) {
        res = value.asInstanceOf[IntValue].get() == plan.columnValue.toInt
      } else if (value.isInstanceOf[StringValue]) {
        res = value.asInstanceOf[StringValue].get().equals(plan.columnValue)
      }
      res
    }

    def getdata(compareMethod: Value => Boolean) = data.filter { x =>
      compareMethod(x.valueList(filterIndex))
    }

    val afterFilterRow = plan.compare match {
      case "equals" => getdata(compareEquals)
      case "greater" => getdata(compareGeater)
      case "less" => getdata(compareLess)
    }
    data = afterFilterRow
  }


  def compareGeater(value: Value): Boolean = {
    var res: Boolean = false
    if (value.isInstanceOf[IntValue]) {
      res = value.asInstanceOf[IntValue].get() > plan.columnValue.toInt
    } else {
      throw new Exception("非数值类型,不支持大于计算")
    }
    res
  }

  def compareLess(value: Value): Boolean = {
    var res: Boolean = false
    if (value.isInstanceOf[IntValue]) {
      res = value.asInstanceOf[IntValue].get() == plan.columnValue.toInt
    } else {
      throw new Exception("非数值类型,不支持小于计算")
    }
    res
  }

}
