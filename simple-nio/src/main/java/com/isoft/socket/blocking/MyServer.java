package com.isoft.socket.blocking;

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

			while (true) {
				// 2、通过 ServerSocketChannel.accept() 方法监听新进来的连接。当
				// accept()方法返回的时候,它返回一个包含新进来的连接的 SocketChannel。因此,
				// accept()方法会一直阻塞到有新连接到达。

				// 且通常不会仅仅只监听一个连接,在while循环中调用 accept()方法.
				
				SocketChannel socketChannel = serverSocketChannel.accept();
				System.out.println("\n*********************************************************");
				// do something with socketChannel...
				ByteBuffer buf = ByteBuffer.allocate(48);
				int bytesRead = socketChannel.read(buf);
				while (bytesRead != -1) {
					System.out.println("\nRead " + bytesRead);// 读取数量
					// 反转Buffer
					buf.flip();
					while (buf.hasRemaining()) {
						System.out.print((char) buf.get());// read 1 byte at a
															// time
					}
					// 清除缓存
					// 一旦读完了所有的数据，就需要清空缓冲区，让它可以再次被写入。有两种方式能清空缓冲区：调用clear()或compact()方法。clear()方法会清空整个缓冲区。compact()方法只会清除已经读过的数据。任何未读的数据都被移到缓冲区的起始处，新写入的数据将放到缓冲区未读数据的后面。
					buf.clear();
					bytesRead = socketChannel.read(buf);
				}//while
				
				

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
