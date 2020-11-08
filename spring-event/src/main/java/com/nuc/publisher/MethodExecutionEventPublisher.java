package com.nuc.publisher;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

import com.nuc.event.MethodExecutionEvent;
import com.nuc.event.MethodExecutionStatus;
import com.nuc.nps.Constants;

public class MethodExecutionEventPublisher implements
		ApplicationEventPublisherAware {

	// ApplicationEventPublisher：spring的事件发布者接口，定义了发布事件的接口方法publishEvent。
	// 因为ApplicationContext实现了该接口，因此spring的ApplicationContext实例具有发布事件的功能(publishEvent方法在AbstractApplicationContext中有实现)。
	// 在使用的时候，只需要把ApplicationEventPublisher的引用定义到ApplicationEventPublisherAware的实现中，spring容器会完成对ApplicationEventPublisher的注入。
	private ApplicationEventPublisher eventPublisher;

	public void methodToMonitor() {
		MethodExecutionEvent beginEvent = new MethodExecutionEvent(this,
				"methodToMonitor", Constants.BEGIN);
		this.eventPublisher.publishEvent(beginEvent);
		// TODO
		MethodExecutionEvent endEvent = new MethodExecutionEvent(this,
				"methodToMonitor", Constants.END);
		this.eventPublisher.publishEvent(endEvent);
	}

	public void setApplicationEventPublisher(
			ApplicationEventPublisher applicationEventPublisher) {
		this.eventPublisher = applicationEventPublisher;
	}
}