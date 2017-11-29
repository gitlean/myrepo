package com.isoft.springtransaction.tranTemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.isoft.springtransaction.tranTemplate.service.StService;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		StService stService = (StService) context.getBean("stService");
		stService.doBusinessLogic();
		System.out.println("<<<<<<<<<<<>>>>>>>>>>...");

	}

}
