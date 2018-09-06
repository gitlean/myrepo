package com.linxcool.reactor;

import java.io.IOException;
import java.nio.channels.SocketChannel;

public class Acceptor implements Runnable {
	private Reactor reactor;

	public Acceptor(Reactor reactor) {
		this.reactor = reactor;
	}

	
	public void run() {
		try {
			//通过 ServerSocketChannel.accept() 方法监听新进来的连接
			SocketChannel socketChannel = reactor.serverSocketChannel.accept();
			if (socketChannel != null)// 调用Handler来处理channel
				new SocketReadHandler(reactor.selector, socketChannel);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
