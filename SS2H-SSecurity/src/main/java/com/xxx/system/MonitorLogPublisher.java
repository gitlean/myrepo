package com.xxx.system;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.xxx.system.entity.MonitorLog;
import com.xxx.system.event.MonitorLogEvent;

@Component("monitorLogPublisher")
public class MonitorLogPublisher implements ApplicationContextAware{

	private ApplicationContext ctx;
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		this.ctx=applicationContext;
	}
	
	public void publish(MonitorLog log){
		ctx.publishEvent(new MonitorLogEvent(this,log));
		
	}

}
