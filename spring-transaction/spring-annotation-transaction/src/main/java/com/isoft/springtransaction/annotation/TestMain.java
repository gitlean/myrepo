package com.isoft.springtransaction.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.isoft.springtransaction.annotation.service.StService;

/**
 * 
 * @author john
 * @date   2017年11月27日
 * @description  http://blog.csdn.net/qh_java/article/details/51811533
 */


public class TestMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		StService stService=(StService) context.getBean("stService");
		stService.doSth();
		System.out.println("<<<<<<<<<<<>>>>>>>>>>...");
		
	}

}
