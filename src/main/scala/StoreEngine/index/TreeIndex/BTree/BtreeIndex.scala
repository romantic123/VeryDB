package StoreEngine.index.TreeIndex.BTree

import StoreEngine.index.page.{PageUtils, PageReference, Page}
import StoreEngine.row.Row
import StoreEngine.value.{StringValue, IntValue, Value}

/**
  * Created by jianwei.yang on 2017/6/2.
  */
class BtreeIndex extends Btree {
  val root: Page = null
  val keys: Seq[Int] = null
  var values: Seq[Value] = null
  var childs: Seq[Btree] = _

  var storePage = root



  val rootNode:Btree=null
  val currentNode: Btree =rootNode
  /**
    *
    * @param row
    */
  override def insert(row: Row): Unit = {
    val currentNodePage=currentNode.storePage
    val currentAllKeys = currentNode.storePage.keys
    val insertKey = row.key.get()
    val index = binary_serach(insertKey, currentAllKeys)
    if (isLeaf(currentNodePage)) {
          currentNode.asInstanceOf[BtreeLeaf].splitLeaf(currentNode)
    } else {
      childs(index).insert()
    }

  }




  def judgeSplit(row: Row): Boolean = {
    true
  }

  def binary_serach(serarchKey: Int, allKeysl: Seq[Int]): Int = {
    1
  }


  def readPage(): Unit = {

  }

  override def isLeaf(node: Page): Boolean = {
    true
  }


  override def update(): Unit = ???

  override def remove(): Unit = ???

  /**
    * 获取到PageReference指定的page
    *
    * @param pageRef
    * @return
    */
  def getPage(pageRef: PageReference): Page = {
    val pos = pageRef.pos
    val page = PageUtils.readPageFromFile(pos)
    page
  }

  /*  def convertRow2Values(row:Row): Unit ={
        row.valueList.map{
          case  value if (value.isInstanceOf[IntValue]) =>{
              value
          }
          case  value if (value.isInstanceOf[StringValue])=>{
            ss
          }
        }
    }*/


  def delete(): Unit = {

  }


}
