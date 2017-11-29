package com.isoft.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

//@Service
public class SpringContextHelper implements ApplicationContextAware {
	static ApplicationContext context;

	public void setApplicationContext(ApplicationContext context) throws BeansException {
		SpringContextHelper.context = context;
	}

	public static ApplicationContext getApplicationContext() {
		return context;
	}

	public static Object getBean(String beanName) {
		return context.getBean(beanName);
	}

	public static <T> T getBean(Class<T> clazz) {
		return context.getBean(clazz);
	}
}