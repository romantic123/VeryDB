package StoreEngine.index.TreeIndex.BTree

import StoreEngine.index.page.Page
import StoreEngine.row.Row

/**
  * Created by jianwei.yang on 2017/8/3.
  */
abstract class Btree {
  var storePage:Page
  //var childs:Seq[Btree]
  var filePos:Int
  def insert(node: Btree,row:Row)
  def update()
  def remove()
  def split()
  def isLeaf(page:Page):Boolean

}
