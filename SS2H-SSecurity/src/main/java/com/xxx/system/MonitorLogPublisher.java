package com.xxx.system;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.xxx.system.entity.MonitorLog;
import com.xxx.system.event.MonitorLogEvent;

@Component("monitorLogPublisher")
public class MonitorLogPublisher implements ApplicationContextAware{ 
	
	//按照规范：
	//ApplicationEventPublisherAware：在spring的context中希望能发布事件的类必须实现的接口，该接口中定义了设置ApplicationEventPublisher的方法，由ApplicationContext调用并设置。
	//在自己实现的ApplicationEventPublisherAware子类中，需要有ApplicationEventPublisher属性的定义。
    //此处的ApplicationEventPublisher（即ctx）在那个引用中?? (此处ApplicationContextAware和ApplicationEventPublisherAware 位置（地位一样？） )
	
	
	private ApplicationContext ctx;
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		this.ctx=applicationContext;
	}
	
	public void publish(MonitorLog log){
		//通过ApplicationContextAware获取ApplicationEventPublisher
		//ApplicationContext实现了ApplicationEventPublisher接口
		
		ctx.publishEvent(new MonitorLogEvent(this,log));
		
	}

}
