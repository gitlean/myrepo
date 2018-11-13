package com.isoft.aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextHelper implements ApplicationContextAware {

	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	public static Object getBean(String beanName) {
		if (applicationContext == null) {
			throw new NullPointerException("ApplicationContext is null!");
		}
		return applicationContext.getBean(beanName);
	}
	
	
	
	public static <T>T getBean(String beanName,Class<T> clazz) {
		if (applicationContext == null) {
			throw new NullPointerException("ApplicationContext is null!");
		}
		
		return applicationContext.getBean(beanName,clazz);
	}

}