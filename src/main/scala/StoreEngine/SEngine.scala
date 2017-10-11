package StoreEngine

import StoreEngine.index.TreeIndex.BTree.BtreeIndex
import StoreEngine.row.Row

class SEngine {

}

object SEngine {
  def apply(): SEngine = new SEngine()

  def storeFile(tableName: String, row: Row): Boolean = {
    val btreeIndex = new BtreeIndex()
    btreeIndex.insert(tableName, row)
    true
  }
}