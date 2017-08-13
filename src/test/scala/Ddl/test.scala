import QueryEngine.executePlan.Exec

/**
  * Created by jianwei.yang on 2017/5/3.
  */

object test{
   def main(args:Array[String])={
     val exec=Exec()
     def startTest(): Unit ={

       exec.setSql("CREATE table test(id int,name varchar(20),score varchar(20))")
       exec.start()
       exec.setSql("insert into test values(1,yang,90);")
       exec.start()
       exec.setSql("insert into test values(2,jian,91)")
       exec.start()
       exec.setSql("insert into test values(3,wei,92)")
       exec.start()
       exec.setSql("select * from test where id >2")
       exec.start()
     }
     val a =startTest()
   }

}