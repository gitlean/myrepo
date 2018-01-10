package com.isoft.socket.noblocking;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class MyServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("start server @ 9991...");
		ServerSocketChannel serverSocketChannel;
		try {
			// 1、打开 ServerSocketChannel
			serverSocketChannel = ServerSocketChannel.open();

			serverSocketChannel.socket().bind(new InetSocketAddress(9991));
			serverSocketChannel.configureBlocking(false);
			while (true) {

				SocketChannel socketChannel = serverSocketChannel.accept();
				// 在非阻塞模式下，accept() 方法会立刻返回，如果还没有新进来的连接,返回的将是null。
				// 因此，需要检查返回的SocketChannel是否是null.
				if (socketChannel != null) {

					System.out.println("\n*********************************************************");
					// do something with socketChannel...
					ByteBuffer buf = ByteBuffer.allocate(48);
					int bytesRead = socketChannel.read(buf);
					while (bytesRead != -1) {
						System.out.println("\nRead " + bytesRead);// 读取数量
						// 反转Buffer
						buf.flip();
						while (buf.hasRemaining()) {
							System.out.print((char) buf.get());
						}
						// 清除缓存
						// 一旦读完了所有的数据，就需要清空缓冲区，让它可以再次被写入。有两种方式能清空缓冲区：调用clear()或compact()方法。clear()方法会清空整个缓冲区。compact()方法只会清除已经读过的数据。任何未读的数据都被移到缓冲区的起始处，新写入的数据将放到缓冲区未读数据的后面。
						buf.clear();
						bytesRead = socketChannel.read(buf);
					} // while

				}

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
