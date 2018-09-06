package com.isoft.demo2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.util.CharsetUtil;

@Sharable
public class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf> {
	/**
	 * 此方法会在连接到服务器后被调用
	 */
	public void channelActive(ChannelHandlerContext ctx) {
		//ctx.write(Unpooled.copiedBuffer("Netty rocks!", CharsetUtil.UTF_8));
		//为什么我的执行结果没有把发送和接受的消息打印出来呢？
		//EchoClientHandler.channelActive()中所调用的wirte改为writeAndFlush
		ctx.writeAndFlush(Unpooled.copiedBuffer("Netty rocks!", CharsetUtil.UTF_8));
	}

	/**
	 * 此方法会在接收到服务器数据后调用
	 */
	//其中需要注意的是channelRead0()方法，此方法接收到的可能是一些数据片段，比如服务器发送了5个字节数据，Client端不能保证一次全部收到，
	//比如第一次收到3个字节，第二次收到2个字节。我们可能还会关心收到这些片段的顺序是否可发送顺序一致，这要看具体是什么协议，比如基于TCP协议的字节流是能保证顺序的
	public void channelRead0(ChannelHandlerContext ctx, ByteBuf in) {
		System.out.println("Client received: " + ByteBufUtil.hexDump(in.readBytes(in.readableBytes())));
	}

	/**
	 * 捕捉到异常
	 */
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		cause.printStackTrace();
		ctx.close();
	}

}