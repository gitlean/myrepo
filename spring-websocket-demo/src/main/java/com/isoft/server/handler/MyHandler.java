package com.isoft.server.handler;

import java.io.IOException;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * 创建 WebSocket 处理器 扩展 TextWebSocketHandler 或 BinaryWebSocketHandler
 * ，你可以覆写指定的方法。 Spring 在收到 WebSocket 事件时，会自动调用事件对应的方法
 * 
 * @author john
 * @date 2018年9月25日
 * @time 下午4:35:54
 * @describe:
 */
public class MyHandler extends TextWebSocketHandler { // 实现了WebSocketHandler接口

	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message) {
		// ...
		System.out.println("MyHandler:handleTextMessage------->");
		System.out.println("服务端接收到的数据是:" + message.getPayload());

		// 服务端回复
		try {
			for (int i = 0; i < 5; i++) {
				TextMessage responseMsg = new TextMessage("Hello".getBytes());
				session.sendMessage(responseMsg);
				Thread.currentThread().sleep(1000);// 休息1s
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}