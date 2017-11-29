package com.isoft.springtransaction.platTranman;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.isoft.springtransaction.platTranman.service.SpService;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		SpService spService = (SpService) context.getBean("spService");
		spService.doBusinessLogic();
		System.out.println("<<<<<<<<<<<>>>>>>>>>>...");
		
	}

}
