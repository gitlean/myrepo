package com.nuc.publisher;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

import com.nuc.event.MethodExecutionEvent;
import com.nuc.event.MethodExecutionStatus;
import com.nuc.nps.Constants;

public class MethodExecutionEventPublisher implements
		ApplicationEventPublisherAware {

	// ApplicationEventPublisher��spring���¼������߽ӿڣ������˷����¼��Ľӿڷ���publishEvent��
	// ��ΪApplicationContextʵ���˸ýӿڣ����spring��ApplicationContextʵ�����з����¼��Ĺ���(publishEvent������AbstractApplicationContext����ʵ��)��
	// ��ʹ�õ�ʱ��ֻ��Ҫ��ApplicationEventPublisher�����ö��嵽ApplicationEventPublisherAware��ʵ���У�spring��������ɶ�ApplicationEventPublisher��ע�롣
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