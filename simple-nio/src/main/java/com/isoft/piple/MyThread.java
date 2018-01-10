/**
 * 
 */
package com.isoft.piple;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 * @author john
 * @date 2018年1月10日
 * @time 下午3:02:03
 * @describe:
 */
public class MyThread implements Runnable {
	private int type;

	private Pipe pipe;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Pipe getPipe() {
		return pipe;
	}

	public void setPipe(Pipe pipe) {
		this.pipe = pipe;
	}

	public MyThread() {

	};

	public MyThread(Pipe pipe, int type) {// 1发送，2接受
		this.pipe = pipe;
		this.type = type;

	};

	public void run() {
		if (1 == type) {// 向管道写数据

			Pipe.SinkChannel sinkChannel = pipe.sink();
			// 通过调用SinkChannel的write()方法，将数据写入SinkChannel,

			String newData = "New String to write to file..." + System.currentTimeMillis();

			ByteBuffer buf = ByteBuffer.allocate(48);

			buf.clear();

			buf.put(newData.getBytes());

			buf.flip();

			while (buf.hasRemaining()) {

				try {
					sinkChannel.write(buf);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

		if (2 == type) {
			// 从读取管道的数据，需要访问source通道
			Pipe.SourceChannel sourceChannel = pipe.source();

			ByteBuffer buf = ByteBuffer.allocate(48);

			try {
				int bytesRead = sourceChannel.read(buf);

				while (bytesRead != -1) {
					System.out.println("\nRead " + bytesRead);// 读取数量
					// 反转Buffer,将Buffer从写模式切换到读模式
					buf.flip();
					while (buf.hasRemaining()) {
						System.out.print((char) buf.get());
					}
					// 清除缓存
					// 一旦读完了所有的数据，就需要清空缓冲区，让它可以再次被写入。有两种方式能清空缓冲区：调用clear()或compact()方法。clear()方法会清空整个缓冲区。compact()方法只会清除已经读过的数据。任何未读的数据都被移到缓冲区的起始处，新写入的数据将放到缓冲区未读数据的后面。
					buf.clear();

					bytesRead = sourceChannel.read(buf);
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
