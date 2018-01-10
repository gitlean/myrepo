package com.isoft.socket.noblocking;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/**
 * 
 * @author john
 * @date 2018年1月10日
 * @time 下午1:38:06
 * @describe:单线程使用一个Selector处理3个channel的示例
 */
public class MyClientWithSelector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void call1() {

		try {

			// 1、创建一个Selector
			Selector selector = Selector.open();

			// 2、向Selector注册通道
			// 与Selector一起使用时，Channel必须处于非阻塞模式下。这意味着不能将FileChannel与Selector一起使用，因为FileChannel不能切换到非阻塞模式。而套接字通道都可以。
			SocketChannel socketChannel1;
			SocketChannel socketChannel2;
			SocketChannel socketChannel3;

			socketChannel1 = SocketChannel.open();
			socketChannel1.configureBlocking(false);// 设置非阻塞模式
			socketChannel1.connect(new InetSocketAddress("127.0.0.1", 9991));

			socketChannel2 = SocketChannel.open();
			socketChannel2.configureBlocking(false);// 设置非阻塞模式
			socketChannel2.connect(new InetSocketAddress("127.0.0.1", 9991));

			socketChannel3 = SocketChannel.open();
			socketChannel3.configureBlocking(false);// 设置非阻塞模式
			socketChannel3.connect(new InetSocketAddress("127.0.0.1", 9991));

			// 当向Selector注册Channel时，register()方法会返回一个SelectionKey对象。这个对象包含了一些你感兴趣的属性：
			SelectionKey key1 = socketChannel1.register(selector, SelectionKey.OP_READ);
			SelectionKey key2 = socketChannel2.register(selector, SelectionKey.OP_READ);
			SelectionKey key3 = socketChannel3.register(selector, SelectionKey.OP_READ);
			
			
			//-------------------------------------------------------------------
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
