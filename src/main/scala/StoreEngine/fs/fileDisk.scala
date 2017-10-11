package StoreEngine.fs

import java.io.RandomAccessFile
import java.nio.channels.FileChannel.MapMode
import java.nio.channels.{FileChannel, FileLock, ReadableByteChannel, WritableByteChannel}
import java.nio.{ByteBuffer, MappedByteBuffer}

/**
  * Created by jianwei.yang on 2017/7/20.
  */
class fileDisk extends FileChannel {

  val FilePath = "F:\\VeryDb\\ddddd.txt"
  val mode = "rwd"
  val randomAccessFile = new RandomAccessFile(FilePath, mode)
  val channel = randomAccessFile.getChannel

  override def tryLock(position: Long, size: Long, shared: Boolean): FileLock = {
    channel.tryLock()
  }

  override def transferFrom(src: ReadableByteChannel, position: Long, count: Long): Long = {
    channel.transferFrom(src, position, count)
  }

  override def position(): Long = {
    channel.position()
  }

  override def position(newPosition: Long): FileChannel = {
    channel.position(newPosition)
  }

  override def transferTo(position: Long, count: Long, target: WritableByteChannel): Long = {
    channel.transferTo(position, count, target)
  }

  override def size(): Long = {
    channel.size()
  }

  override def truncate(size: Long): FileChannel = {
    channel.truncate(size)
  }

  override def lock(position: Long, size: Long, shared: Boolean): FileLock = {
    channel.lock(position, size, shared)
  }

  override def write(src: ByteBuffer): Int = {
    channel.write(src)
  }

  override def write(srcs: Array[ByteBuffer], offset: Int, length: Int): Long = {
    channel.write(srcs, offset, length)
  }

  override def write(src: ByteBuffer, position: Long): Int = {
    channel.write(src, position)
  }


  def write(startPos: Int, dst: ByteBuffer) = {
    randomAccessFile.seek(startPos)
    println(dst.array().length)
    randomAccessFile.write(dst.array(), 0, dst.array().length)
  }

  /**
    * 从文件中指定位置读取指定长度的byte到dsts中
    *
    * @param startPos
    * @param readSize
    * @param dst
    */
  def read(startPos: Int, readSize: Int, dst: ByteBuffer): ByteBuffer = {
    randomAccessFile.seek(startPos)
    randomAccessFile.read(dst.array(), startPos, readSize)
    dst
  }

  override def read(dst: ByteBuffer): Int = {
    channel.read(dst)
  }

  override def read(dsts: Array[ByteBuffer], offset: Int, length: Int): Long = {
    channel.read(dsts, offset, length)
  }

  override def read(dst: ByteBuffer, position: Long): Int = {
    channel.read(dst, position)
  }

  override def force(metaData: Boolean): Unit = {
    channel.force(metaData)
  }

  override def map(mode: MapMode, position: Long, size: Long): MappedByteBuffer = {
    channel.map(mode, position, size)
  }

  def implCloseChannel(): Unit = {

  }
}

object fileDisk {
  def apply() = new fileDisk()
}