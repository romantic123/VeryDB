package StoreEngine.index.TreeIndex.BTree

import StoreEngine.index.page.Page
import StoreEngine.row.Row

/**
  * Created by jianwei.yang on 2017/8/3.
  */
abstract class Btree {
  var storePage:Page
  def update()
  def remove()
  def split():Page
  def isLeaf(page:Page):Boolean

}
