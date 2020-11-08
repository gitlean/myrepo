package com.isoft.mq.producer.queue;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

/**
 * @author anonymous
 * @createTime 2020年11月8日 上午9:55:06
 * @describe
 */
@Service
public class QueueSender {
	@Resource(name = "jmsQueueTemplate")
	private JmsTemplate jmsTemplate;

	/**
	 * 向指定队列发送消息
	 */
	public void sendMessage(Destination destination, final String msg) {
		System.out.println("向队列" + destination.toString() + "发送了消息------------" + msg);
		jmsTemplate.send(destination, new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(msg);
			}
		});
	}

	/**
	 * 向默认队列发送消息
	 */
	public void sendMessage(final String msg) {
		String destination = jmsTemplate.getDefaultDestination().toString();
		System.out.println("向队列" + destination + "发送了消息------------" + msg);
		jmsTemplate.send(new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(msg);
			}
		});

	}
}
