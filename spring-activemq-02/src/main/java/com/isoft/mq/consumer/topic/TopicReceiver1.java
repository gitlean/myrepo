package com.isoft.mq.consumer.topic;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.stereotype.Service;

/**
*@author anonymous
*@createTime 2020年11月8日 上午10:00:49
*@describe
*/
@Service("topicReceiver1")
public class TopicReceiver1 implements MessageListener {

	@Override
	public void onMessage(Message message) {
		TextMessage tm = (TextMessage) message;
		try {
			System.out.println("topicReceiver1监听到了文本消息：\t" + tm.getText());
			// do something ...
		} catch (JMSException e) {
			e.printStackTrace();
		}

	}

}
