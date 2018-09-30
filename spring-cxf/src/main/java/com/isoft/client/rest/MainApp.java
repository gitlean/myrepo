package com.isoft.client.rest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-client.xml");
		Wsclient client = context.getBean(Wsclient.class);
		
		//client.sengMsg();
		//client.sengMsg2();
		client.sengMsg4();
		
		//client.sendBean();
		
	}

}
