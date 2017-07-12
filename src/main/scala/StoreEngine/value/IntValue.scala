package StoreEngine.value

/**
  * Created by jianwei.yang on 2017/4/22.
  */
class IntValue  extends  Value{
      var data:Int =1

      def add(value: Int): Value = {
            this.data=value
            this
      }

      def get(): Int ={
          data
      }

}

object IntValue{
      def apply()=new IntValue()

}