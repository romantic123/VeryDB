package StoreEngine.index.TreeIndex.BTree

import StoreEngine.index.page.{PageUtils, PageReference, Page}
import StoreEngine.row.Row

/**
  * Created by jianwei.yang on 2017/6/2.
  */
class btree {

      def search(key:Int): Option[Row] ={
            var currentNode: Page = null;
            var lastAccessNode:Page=null;
            while(currentNode!=null){
                  val p=currentNode.find(key)                       //返回key所在的位置索引
                  if(0<=p && key==currentNode.keys(p)){
                        return None
                  }
                  lastAccessNode=currentNode;
                  currentNode=getPage(currentNode.childPageInfo(p+1)) //继续往下走,遍历下一级
            }
            return null
      }

      /**
        * 获取到PageReference指定的page
        * @param pageRef
        * @return
        */
      def getPage(pageRef: PageReference): Page = {
            val pos = pageRef.pos
            val page= PageUtils.readPageFromFile(pos)
            page
      }

      def insert(){

      }

      def delete(): Unit ={

      }

}
