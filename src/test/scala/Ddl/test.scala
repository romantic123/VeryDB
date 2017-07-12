import QueryEngine.executePlan.Exec

/**
  * Created by jianwei.yang on 2017/5/3.
  */

object test{
   def main(args:Array[String])={
     val exec=Exec()
     def startTest(): Unit ={

       exec.setSql("CREATE table test(id int)")
       exec.start()
       exec.setSql("insert into test values(1)")
       exec.start()
       exec.setSql("select * from test where id =1")
       exec.start()
     }
     val a =startTest()
   }

}