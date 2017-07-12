package StoreEngine.value
import StoreEngine.value.IntValue

/**
  * Created by jianwei.yang on 2017/4/22.
  */
abstract class Value() {

  //def add(value: Value): Value

/*  def addValue(dataType:String,value:Any): Value ={
    case "int" => {
      IntValue().add(value.toString.toInt)
    }*/
/*
  def getInt():Int={
    IntValue.get()
  }

  def getString():String={
    StringValue.get()
  }*/

}

/*object Value {
  def apply()=new Value();
  }*/

  /*      def apply()=new Value().write();


        def  write(valueType:String,value:String):Value= valueType match{
              case valueType if(valueType.equalsIgnoreCase("int"))=>{
                    new IntValue().write(value)
              }
              case valueType if(valueType.equalsIgnoreCase("String"))=>{
                    new StringValue()
              }
        }*/


