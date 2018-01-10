package com.isoft.datagramChannel;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class Peer2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DatagramChannel channel;
		try {
			// 打开 DatagramChannel
			channel = DatagramChannel.open();
			channel.socket().bind(new InetSocketAddress(9998));

			// 发送数据
			String newData = "New String to write ..." + System.currentTimeMillis();
			ByteBuffer buf = ByteBuffer.allocate(48);
			buf.clear();
			buf.put(newData.getBytes());
			buf.flip();
			int bytesSent = channel.send(buf, new InetSocketAddress("127.0.0.1", 9999));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
