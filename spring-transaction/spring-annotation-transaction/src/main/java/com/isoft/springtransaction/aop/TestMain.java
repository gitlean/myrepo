package com.isoft.springtransaction.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.isoft.springtransaction.aop.service.SpService;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-2.xml");
		SpService spService=(SpService) context.getBean("spService");
		//spService.doBusinessLogic();
		
		spService.saveLogic();
		System.out.println("<<<<<<<<<<<>>>>>>>>>>...");
	}

}
