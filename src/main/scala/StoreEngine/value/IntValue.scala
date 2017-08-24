package StoreEngine.value

/**
  * Created by jianwei.yang on 2017/4/22.
  */
class IntValue extends Value {
  var data: Int = 1

  def this(i: Int) {
    this()
    this.data = i
  }

  def add(value: Int): Value = {
    this.data = value
    this
  }

  def get(): Int = {
    data
  }

  override def toString(): String = {
    data.toString
  }

  def getBytes(): Array[Byte] = {
    var Seqbyte = Array[Byte]()
    Seqbyte = Seqbyte :+ (data & 0xff).asInstanceOf[Byte];
    Seqbyte = Seqbyte :+ (data >> 8 & 0xff).asInstanceOf[Byte];
    Seqbyte = Seqbyte :+ (data >> 16 & 0xff).asInstanceOf[Byte];
    Seqbyte = Seqbyte :+ (data >> 24 & 0xff).asInstanceOf[Byte];
    Seqbyte
  }
}

object IntValue {
  def apply() = new IntValue()

  def apply(i: Int) = new IntValue(i)


}