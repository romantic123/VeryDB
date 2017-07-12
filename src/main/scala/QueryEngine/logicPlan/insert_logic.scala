package QueryEngine.logicPlan

import StoreEngine.column.Column
import StoreEngine.table.{CommonTable, Table}
import common.Catalog

/**
  * Created by jianwei.yang on 2017/5/8.
  */
case class insert_logic(val tableName:String,val Value:List[String],child:logicPlanTree) extends logicPlanTree{

  //TODO insert into table(col1,col2,col3) values(val1,val2,val3)
  //目前只支持 insert into table values(val1,val2,val3)
/*            lazy val  expectColumn:List[Column]={
              if(Catalog.lookUpTable(tableName)){
                  Catalog.getTable(tableName) match{
                    case Some(table)=>{
                        if(table.isInstanceOf[CommonTable]){
                           table.asInstanceOf[CommonTable].allColumn
                        }
                    case
                    }
                  }
              }else{
              null
              }
            }*/

  def expectColumn(table:CommonTable): Seq[Column] ={
    table.allColumn
  }
}
