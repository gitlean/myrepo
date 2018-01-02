package com.jeecg.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//单例模式较好
public class SpringContextUtil {

	private static ApplicationContext ctx = null;

	static {
		ctx = new ClassPathXmlApplicationContext("applicationContext-2.xml");
	}

	public static Object getBean(String beanName) {

		return ctx.getBean(beanName);
	}
}
