package com.nuc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nuc.publisher.MethodExecutionEventPublisher;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		MethodExecutionEventPublisher publisher = (MethodExecutionEventPublisher) context
				.getBean("evtPublisher");
		publisher.methodToMonitor();
	}
}