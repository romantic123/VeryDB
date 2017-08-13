package StoreEngine.index.page

import StoreEngine.row.Row
import StoreEngine.value.Value

/**
  * Created by jianwei.yang on 2017/6/5.
  */
class Page{

  var pageType:Int=null
  var parentId:Int=null
  var tableId:Int=null
  var pageLen:Int=null
  var keys:Seq[Int]=null
  var values:Seq[Row]=null
  var childs:Seq[PageReference]=null


  /**
    * 叶子节点上的page
    *
    * @param pageType
    * @param parentId
    * @param tableId
    * @param pageLen
    * @param keys
    */

  def this(pageType:Int,parentId:Int,tableId:Int,pageLen:Int,keys:Seq[Int]){
    this()
    this.pageType=pageType
    this.parentId=parentId
    this.tableId=tableId
    this.pageLen=pageLen
    this.keys=keys
  }

  def this(pageType:Int,parentId:Int,tableId:Int,pageLen:Int,keys:Seq[Int],values:Seq[Row],childs:Seq[PageReference]){
    this(pageType,parentId,tableId,pageLen,keys)
    this.values=values
    this.childs=childs

  }


  /**
    * 从某个节点search符合条件的key
    *
    * @param searchKey
    * @return
    */

  def search(searchKey:Int,start:Int,end:Int):Int={
    if(end==start){
      return start
    }
    val mid=(end-start)/2
    val midValue=keys(mid)
    if(midValue==searchKey){
      return mid
    }
    if(midValue<searchKey){
      search(searchKey,mid,end)
    }
    if(midValue>searchKey){
      search(searchKey,start,mid)
    }

    return 0;
  }


  def insert(insertKey: Int, row:Row): Unit ={
        
  }

}

object Page{
  def apply()=new Page()
  val PageHeadSize=16
  var pageSize=4096


}

