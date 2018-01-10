package com.isoft;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestMain {

	public static void main(String[] args) {
		call2();
	}

	public static void call1() {
		// TODO Auto-generated method stub
		RandomAccessFile aFile = null;
		try {
			aFile = new RandomAccessFile("data/nio-data.txt", "rw");
			FileChannel inChannel = aFile.getChannel();

			ByteBuffer buf = ByteBuffer.allocate(48);
			int bytesRead = inChannel.read(buf);
			while (bytesRead != -1) {
				System.out.println("\nRead " + bytesRead);// 读取数量
				// 反转Buffer,将Buffer从写模式切换到读模式
				buf.flip();
				while (buf.hasRemaining()) {
					System.out.print((char) buf.get());// read 1 byte at a time
				}
				// 清除缓存
				// 一旦读完了所有的数据，就需要清空缓冲区，让它可以再次被写入。有两种方式能清空缓冲区：调用clear()或compact()方法。clear()方法会清空整个缓冲区。compact()方法只会清除已经读过的数据。任何未读的数据都被移到缓冲区的起始处，新写入的数据将放到缓冲区未读数据的后面。
				buf.clear();

				bytesRead = inChannel.read(buf);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (null != aFile) {
				try {
					aFile.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

	public static void call2() {

		RandomAccessFile fromFile = null;
		RandomAccessFile toFile = null;
		try {
			fromFile = new RandomAccessFile("data/fromFile.txt", "rw");
			FileChannel fromChannel = fromFile.getChannel();

			toFile = new RandomAccessFile("data/toFile.txt", "rw");

			FileChannel toChannel = toFile.getChannel();

			long position = 0;

			long count = fromChannel.size();

			toChannel.transferFrom(fromChannel, position, count);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (null != fromFile) {
				try {
					fromFile.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (null != toFile) {
				try {
					toFile.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
}
