package com.mengdee.manage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mengdee.manage.service.EhcacheService;

public class MainApp {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

		EhcacheService ehcacheService = (EhcacheService) ctx.getBean("ehcacheServiceImpl");
		System.out.println("第一次调用：" + ehcacheService.getTimestamp("param"));
		Thread.sleep(2000);
		System.out.println("2秒之后调用：" + ehcacheService.getTimestamp("param"));
		Thread.sleep(4000);
		System.out.println("再过4秒之后调用：" + ehcacheService.getTimestamp("param"));

	}

}
