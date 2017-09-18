package StoreEngine.value

/**
  * Created by jianwei.yang on 2017/4/22.
  */
class StringValue extends Value {
  var data: String = null
  var size:Int=0


  def this(str:String)={
    this()
    this.data=str
    this.size=str.length
  }

  def add(value: String): Value = {
      this.data=value
      this
  }

   def get(): String = {
    data
  }


  override def toString(): String ={
    data.toString
  }

  def getBytes(): Array[Byte]={
    data.getBytes
  }
}

object StringValue {
  def apply() = new StringValue()
  def apply(str:String) =new StringValue(str)
}