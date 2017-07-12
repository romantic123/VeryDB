package StoreEngine.index.page

import StoreEngine.row.Row

/**
  * Created by jianwei.yang on 2017/6/5.
  */
class Page{
  val pageHeader:PageHeader=null
  val keys:Array[Int]=null
  val offset:Array[Int]=null
  val row:Row=null
  val childPageInfo:Array[PageReference]=null


  def find(key:Int): Int ={
     1
  }



}
