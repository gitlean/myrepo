package com.isoft.action;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Log implements ApplicationContextAware {
	private ApplicationContext context;

	public void setApplicationContext(ApplicationContext context) throws BeansException {
		// TODO Auto-generated method stub
		this.context=context;
		
	}
	
	
	//通过PublicEvent发布事件
	public int log(String logMsg){
		LogEvent event=new LogEvent(logMsg);
		this.context.publishEvent(event);
		return 0;
	}

}
