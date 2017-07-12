package QueryEngine.executePlan

import QueryEngine.logicPlan.{column_logic, table_logic, logicPlanTree}
import StoreEngine.column.Column
import StoreEngine.row.Row
import StoreEngine.table.CommonTable
import common.Catalog

/**
  * Created by jianwei.yang on 2017/5/1.
  */
case class ddlCommandExec(plan: table_logic,child:executePlanTree) extends executePlanTree {



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
    val tableName = plan.tableName
    val column = plan.child.asInstanceOf[column_logic]
    val columnNameList = column.columnList
    val columnTypeList = column.typeList
    val table = CommonTable()
    table.setTable(tableName)

    // 两个List拼成一个Column对象
    def getcolumn (columnNameList: List[String], typeList: List[String]):List[Column] = {
      if (columnNameList.length != typeList.length) throw new Exception("column and type not match")
      val iter1 = columnNameList.toIterator
      val iter2 = typeList.toIterator
      var columnList: List[Column] = List[Column]()
      while (iter1.hasNext) {
        val c=new Column(iter1.next(), iter2.next())
         columnList = columnList :+ c
      }
      columnList
    }
    val columnList: List[Column]=getcolumn(columnNameList, columnTypeList)
    // table对象构造完毕
    table.setColumn(columnList)
    // 添加到全局的catalog中
    Catalog.addTableToMap(table)
  }

}
