package com.nuc.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

import com.nuc.event.MethodExecutionEvent;
import com.nuc.event.MethodExecutionStatus;
import com.nuc.nps.Constants;

/**
 * Spring容器中的事件监听器，与java中基本的事件监听器的定义相比，这里需要实现ApplicationListener接口
 * ApplicationListener接口虽然继承自EventListener，但扩展了EventListener
 * 它在接口声明中定义了onApplicationEvent的接口方法，而不像EventListener只作为标记性接口。
 */

public class MethodExecutionEventListener implements ApplicationListener<MethodExecutionEvent> {//泛型限定下范围

	//重载onApplicationEvent方法
	public void onApplicationEvent(MethodExecutionEvent event) {
		System.out.println("发布的事件被捕捉到...");
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
