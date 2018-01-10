package com.isoft.datagramChannel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class Peer1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DatagramChannel channel;
		try {
			// 打开 DatagramChannel
			// 打开的 DatagramChannel可以在UDP端口9999上接收数据包。
			channel = DatagramChannel.open();
			channel.socket().bind(new InetSocketAddress(9999));

			// 接收数据
			// 如果Buffer容不下收到的数据，多出的数据将被丢弃。
			ByteBuffer buf = ByteBuffer.allocate(48);
			buf.clear();
			channel.receive(buf);

			// 反转Buffer
			buf.flip();
			while (buf.hasRemaining()) {
				System.out.print((char) buf.get());
			}
			buf.clear();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
