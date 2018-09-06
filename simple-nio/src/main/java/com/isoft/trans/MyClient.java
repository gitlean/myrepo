package com.isoft.trans;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * 
 * @author john
 * @date 2018年1月10日
 * @time 下午2:30:15
 * @describe:SocketChannel     Noblocking      此时ServerSocketChannel可以是阻塞 /非阻塞
 */
public class MyClient {
	public static void main(String[] args) {
		SocketChannel socketChannel = null;
		try {
			socketChannel = SocketChannel.open();
			socketChannel.configureBlocking(false);// 设置非阻塞模式
			socketChannel.connect(new InetSocketAddress("127.0.0.1", 9991));

			// 此时调用connect()，该方法可能在连接建立之前就返回了。为了确定连接是否建立，可以调用finishConnect()的方法。像这样：
			while (!socketChannel.finishConnect()) {

				Thread.currentThread().sleep(1000);

			}

			// 写入 SocketChannel
			String newData = "New String to write ..." + System.currentTimeMillis();
			
//			String newData ="";
//			for(int i=0;i<100;i++){
//				newData+="English ";
//			}
			
			ByteBuffer buf = ByteBuffer.allocate(2048);
			buf.clear();
			buf.put(newData.getBytes());
			buf.flip();
			while (buf.hasRemaining()) {  //
				
				socketChannel.write(buf);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (null != socketChannel) {
				try {
					socketChannel.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
