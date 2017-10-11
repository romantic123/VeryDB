package StoreEngine.index.page

import java.nio.ByteBuffer

/**
  * Created by jianwei.yang on 2017/6/15.
  */
class PageUtils {


}

object PageUtils {
  def apply() = new PageUtils()

  def readPageFromFile(pos: Int): Page = {
    val buffer = ByteBuffer.allocate(1024)
    new Page
  }
}
