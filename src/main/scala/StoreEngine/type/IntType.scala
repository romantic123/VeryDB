package StoreEngine.`type`

class IntType extends DataType {
  var size: Int = 4

  override def getType() = this


}


object IntType {
  def apply(): IntType = new IntType()

}