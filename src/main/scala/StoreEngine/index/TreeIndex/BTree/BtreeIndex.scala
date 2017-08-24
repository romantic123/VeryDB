package StoreEngine.index.TreeIndex.BTree

import java.nio.ByteBuffer

import StoreEngine.fs.fileDisk
import StoreEngine.index.page.{Page, PageReference, PageUtils}
import StoreEngine.row.Row
import StoreEngine.value.{IntValue, StringValue, Value}
import common.{Catalog, DataUtils}

import scala.collection.mutable.ArrayBuffer

/**
  * Created by jianwei.yang on 2017/6/2.
  */
class BtreeIndex extends Btree {
  val root: Page = null
  val keys: ArrayBuffer[Int] = null
  val values: ArrayBuffer[Value] = null
  val childs: ArrayBuffer[Btree] = _
  val storePage = root


  val rootNode: Btree = null
  val currentNode: Btree = rootNode

  /**
    * 传进去表名,从Catalog中获取该表Btree中,rootPage的file pos
    *
    * @param tableName
    * @return
    */
  def getRootNodeFilePos(tableName: String): Option[Int] = {
    Catalog.getRootNodeFilePos(tableName) match {
      case pos => {
        Some(pos.get)
      }
      case None => {
        None
      }
    }
  }

  /**
    *
    */

  def updateRootNodeFilePos(tableName: String, rootFilePos: Int) = {
    Catalog.setRootNodeFilePos(tableName, rootFilePos)
  }

  /**
    *
    * -----------------------------------------------------------------------------------------------------------
    * |  PageType | KeysSize | Key1,Key2,Key3,Key4,Key5......           | value1,value2,value3,value4.......     |
    * -----------------------------------------------------------------------------------------------------------
    * *
    * var pageType:Int=null   //0是叶子节点,1是非叶子节点
    * var keysSize:Int=null
    * var keys:Seq[Int]=null
    * var values:Seq[Row]=null
    * var childs:Seq[PageReference]=null
    * val everyPageSize=4096
    *
    * @param fileDisk
    * @param row
    * @return
    */
  def write(tableName: String, fileDisk: fileDisk, row: Row) = {
    val startPos = 0
    val data1 = ByteBuffer.allocate(4096)
    val data2 = ByteBuffer.allocate(4096)

    data1.putInt(0)
    data1.putInt(0)
    data1.putInt(row.key.get)
    DataUtils.writeRow(tableName, data2, row)

    val keyAndValueSize = 4 + row.rowSize
    val number = 4096 / keyAndValueSize

    val valueStart = 4096 - 8 - number * 4 + startPos


    //写入pageType,keysSize,keys
    fileDisk.write(startPos, data1)

    //写入values,需要计算从page中哪个位置写
    fileDisk.write(valueStart, data2)
  }


  def firstInsert():Unit={
    val tableName_test:String=null
    val row_test:Row=null

    val fileDisk = new fileDisk()
    val data = ByteBuffer.allocate(4096)
    var rootNodePage: Int = 0
    getRootNodeFilePos(tableName_test) match {
      case Some(rootPagePos) => {
        rootNodePage = rootPagePos
      }
      case None => {
        write(tableName_test, fileDisk, row_test)
        updateRootNodeFilePos(tableName_test, 0)
      }
    }
    insert(tableName_test,row_test,0)
  }


  /**
    *1.fileDisk从root page file pos读取4096字节数据
    *2.判断page类型是node还是leaf
    *3.如果是node,判断child,向下走
    *4.如果是leaf,获取文件中存的值
    *
    * @param row
    */
  def insert(tableName: String, row: Row, pagePos:Int): Unit = {

//step1:取出pagePos位置的page
    val page=getPage(tableName,pagePos)


//step3:判断是不是叶子节点
    if (page.pageType==0) {
      //如果是叶子节点,将row插入到leaf的
      val btreeLeaf:BtreeLeaf=BtreeLeaf(page)
      btreeLeaf.insert(row)
      return
    } else {
      //如果不是叶子节点,获取到正确的pageRef,然后遍历该pageRef指向的page
      val btreeNode:BtreeNode=BtreeNode(page)
      val insertIndex=btreeNode.searchInsertPage(row)
      val childPageRef=btreeNode.storePage.childs(insertIndex)
      val childPos=childPageRef.pageId*4096+childPageRef.pos
      insert(tableName,row,childPos)
    }
  }


  def getChild(pageId:Int,pos:Int)={

  }


  def getPage(tableName:String,filePos:Int):Page={
    val data = ByteBuffer.allocate(4096)
    //该page在文件中的绝对索引位置
    fileDisk().read(filePos, 4096, data)
    val pageType: Int = data.getInt()
    /*    val parentId = data.getInt()
        val tableId = data.getInt()*/
    val keysSize = data.getInt()

    //从page中读取keys
    val keys: Array[Int] = new Array[Int](keysSize)
    for (i <- 0 until keysSize) {
      keys(i) = data.getInt()
    }
    val childsPos: Array[Int] = new Array[Int](keysSize)
    val rows: Array[Row] = new Array[Row](keysSize)
    if (pageType == 1) {
      for (i <- 0 until keysSize) {
        childsPos(i) = data.getInt()
      }
    } else if (pageType == 0) {
      //读取整行数据
      for (i <- 0 until keysSize) {
        val values: Array[Value] = new Array[Value](keysSize)
        Catalog.getTableMapValueType(tableName) match {
          case Some(typeList) => {
            typeList.foreach {
              case 1 => {
                values(i) = IntValue(data.getInt())
              }
              case 2 => {
                values(i) = StringValue(DataUtils.readString(data))
              }
            }
          }
        }
        val pageRow=Row(values)
        rows(i)=pageRow
      }
    }

    val page:Page=new Page(pageType,keysSize,keys,rows,null)
    page

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


  def delete(): Unit = {

  }


}
