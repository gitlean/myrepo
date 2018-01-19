package com.isoft.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.isoft.cache.Calculator;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext ctx= new ClassPathXmlApplicationContext("applicationContext.xml");
        Calculator calculator=(Calculator) ctx.getBean("calculator");
        System.out.println(calculator.add(2, 3));
        System.out.println(calculator.add(2, 3));
	}

}
