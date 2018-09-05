package com.nuc.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

import com.nuc.event.MethodExecutionEvent;
import com.nuc.event.MethodExecutionStatus;
import com.nuc.nps.Constants;

/**
 * Spring�����е��¼�����������java�л������¼��������Ķ�����ȣ�������Ҫʵ��ApplicationListener�ӿ�
 * ApplicationListener�ӿ���Ȼ�̳���EventListener������չ��EventListener
 * ���ڽӿ������ж�����onApplicationEvent�Ľӿڷ�����������EventListenerֻ��Ϊ����Խӿڡ�
 */

public class MethodExecutionEventListener implements ApplicationListener<MethodExecutionEvent> {//�����޶��·�Χ

	//����onApplicationEvent����
	public void onApplicationEvent(MethodExecutionEvent event) {
		System.out.println("�������¼�����׽��...");
		if (event instanceof MethodExecutionEvent) {
			if (Constants.BEGIN
					.equals(((MethodExecutionEvent) event)
							.getMethodExecutionStatus())) {
				System.out.println("It's beginning");
			}
			if (Constants.END.equals(((MethodExecutionEvent) event)
					.getMethodExecutionStatus())) {
				System.out.println("It's ending");
			}
		}
	}
}
