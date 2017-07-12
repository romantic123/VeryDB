package StoreEngine.value

/**
  * Created by jianwei.yang on 2017/4/22.
  */
class StringValue extends Value {
  var data: String = null

  def add(value: String): Value = {
    val stringValue=value.asInstanceOf[StringValue]
    stringValue
  }

   def get(): String = {
    data
  }

}

object StringValue {
  def apply() = new StringValue()
}