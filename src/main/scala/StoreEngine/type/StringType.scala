package StoreEngine.`type`

class StringType extends DataType {
  var size: Int = 0

  def this(size: Int) {
    this()
    this.size = size
  }

  def getType() = this

}

object StringType {
  def apply() = new StringType()

  def apply(size: Int) = new StringType(size)

}