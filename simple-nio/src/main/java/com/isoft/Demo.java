package com.isoft;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SocketChannel socketChannel = null;
		try {
			socketChannel = SocketChannel.open();
			socketChannel.configureBlocking(false);// 设置非阻塞模式
			socketChannel.connect(new InetSocketAddress("127.0.0.1", 9991));

			
			
			
			
	

//			boolean isInterestedInAccept = (interestSet & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT;
//
//			boolean isInterestedInConnect = (interestSet & SelectionKey.OP_CONNECT) == SelectionKey.OP_CONNECT;
//
//			boolean isInterestedInRead = (interestSet & SelectionKey.OP_READ) == SelectionKey.OP_READ;
//
//			boolean isInterestedInWrite = (interestSet & SelectionKey.OP_WRITE) == SelectionKey.OP_WRITE;
//
//			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		// validOps()
	}

}
