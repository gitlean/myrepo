package com.isoft.mq.consumer.queue;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.stereotype.Service;

/**
 * @author anonymous
 * @createTime 2020年11月8日 上午9:58:49
 * @describe
 */

@Service("queueReceiver1")
public class QueueReceiver1 implements MessageListener {

	@Override
	public void onMessage(Message message) {
		TextMessage tm = (TextMessage) message;
		try {
			System.out.println("queueReceiver1监听到了文本消息：\t" + tm.getText());
			// do something ...
		} catch (JMSException e) {
			e.printStackTrace();
		}

	}

}
