package StoreEngine.index.page

import StoreEngine.row.Row
import StoreEngine.value.Value

/**
  * Created by jianwei.yang on 2017/6/5.
  */
class Page{
  //0是叶子节点,1是非叶子节点
  var pageType:Int=null
  var keysSize:Int=null
  var keys:Seq[Int]=null
  var values:Seq[Row]=null
  var childs:Seq[PageReference]=null

  val everyPageSize=4096


  /**
    * 叶子节点上的page
    *
    * @param pageType
    * @param pageLen
    * @param keys
    */

  def this(pageType:Int,pageLen:Int,keys:Seq[Int]){
    this()
    this.pageType=pageType
    this.keysSize=pageLen
    this.keys=keys
  }

  def this(pageType:Int,pageLen:Int,keys:Seq[Int],values:Seq[Row],childs:Seq[PageReference]){
    this(pageType,pageLen,keys)
    this.values=values
    this.childs=childs

  }


  /**
    * 从某个节点search符合条件的key
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

