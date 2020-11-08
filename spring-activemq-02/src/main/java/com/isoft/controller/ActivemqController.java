package com.isoft.controller;

import javax.annotation.Resource;
import javax.jms.Destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.isoft.mq.producer.queue.QueueSender;
import com.isoft.mq.producer.topic.TopicSender;

/**
 * @author anonymous
 * @createTime 2020年11月8日 上午10:05:20
 * @describe
 */
@Controller
@RequestMapping("/activemq")
public class ActivemqController {

	// 队列名test.queue
	@Resource(name = "normalQueueDestination")
	private Destination normalQueueDestination;

	// 队列名test.topic
	@Resource(name = "topicQueueDestination")
	private Destination topicQueueDestination;

	// 队列消息生产者
	@Autowired
	private QueueSender queueSender;

	// 队列消息生产者
	@Autowired
	private TopicSender topicSender;

	// http://localhost:8080/spring-activemq-02/activemq/index
	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@RequestMapping("/queue")
	public String sendQueueMessage(@RequestParam("message") String message) {
		queueSender.sendMessage(normalQueueDestination, message);
		return "welcome";
	}

	@RequestMapping("/topic")
	public String sendTopicMessage(@RequestParam("message") String message) {
		topicSender.sendMessage(topicQueueDestination, message);
		return "welcome";
	}

}
