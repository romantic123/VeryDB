package StoreEngine.index.TreeIndex.BTree

import StoreEngine.index.page.Page
import StoreEngine.row.Row
import common.Catalog

/**
  * Created by jianwei.yang on 2017/6/5.
  */

class BtreeLeaf extends Btree {
  var storePage: Page = _


  def this(storePage: Page) {
    this()
  }


  override def update(): Unit = ???

  override def isLeaf(page: Page): Boolean = ???

  override def remove(): Unit = ???


  def insert(tableName: String, row: Row): Option[Page] = {
    //当前节点的keys和values
    val currentNodeKeys: Seq[Int] = storePage.keys
    val currentNodeValues: Seq[Row] = storePage.values

    //待插入的key和index
    val insertKey: Int = row.key.get()
    val insertIndex = binary_serach(insertKey, currentNodeKeys)

    //以index为边界,将index的左右key分别存储到两个不同的临时数组中
    val leftKeyss = currentNodeKeys.take(insertIndex)
    val rightKeys = currentNodeKeys.takeRight(insertIndex)

    //以index为边界,将index的左右key分别存储到两个不同的临时数组中
    val leftValues: Seq[Row] = currentNodeValues.take(insertIndex)
    val rightValues: Seq[Row] = currentNodeValues.takeRight(insertIndex)

    //将待插入的key和value插入到临时数组中,组成新节点的key和value
    val newCurrentNodeKeys: Seq[Int] = (leftKeyss :+ insertKey) ++ rightKeys
    val newCurrentNodeValues: Seq[Row] = (leftValues :+ row) ++ rightValues

    //插入完之后,判断是否需要分裂

    //如果分裂,返回keys数组的中间key
    if (getSize(tableName: String, newCurrentNodeKeys, newCurrentNodeValues) > Page.pageSize) {
      val newSplitPage: Page = split()
      return Some(newSplitPage)
    }
    //如果不需要分裂,直接返回
    return None
  }

  def getSize(tableName: String, keys: Seq[Int], values: Seq[Row]): Int = {
    val size = keys.size * 4 + values.size * Catalog.getRowSize(tableName) + Page.PageHeadSize
    size
  }

  def binary_serach(serarchKey: Int, allKeys: Seq[Int]): Int = {
    1
  }


  /**
    * 分裂叶节点
    */
  def split(): Page = {
    //确定切割点,默认中中间节点
    val currentNodeLength = storePage.keys.size / 2

    //获取切割节点的key和value
    val key = storePage.keys(currentNodeLength)
    val value = storePage.values(currentNodeLength)

    //该节点所有的key和value
    val keys = storePage.keys
    val values = storePage.values

    //从切割点切割,左边key和右边key分别放到两个临时数组,切割点的key放在右边数组中
    var leftKeys: Seq[Int] = null
    System.arraycopy(keys, 0, leftKeys, 0, currentNodeLength)
    var rightKey: Seq[Int] = null
    System.arraycopy(keys, currentNodeLength, rightKey, 0, currentNodeLength)

    //从切割点切割,左边key和右边key分别放到两个临时数组,切割点的value放在右边数组中
    var leftValues: Seq[Row] = null
    System.arraycopy(values, 0, leftValues, 0, currentNodeLength)
    var rightValues: Seq[Row] = null
    System.arraycopy(values, currentNodeLength, rightValues, 0, currentNodeLength)

    //右边的keys和values组成一个新的page,左边的keys和value还在原页中
    val newPage = new Page(1, 1, rightKey, rightValues, null)

    //new出新的叶子节点
    newPage
  }

}

object BtreeLeaf {
  def apply() = new BtreeLeaf()

  def apply(storePage: Page): BtreeLeaf = new BtreeLeaf(storePage: Page)
}

