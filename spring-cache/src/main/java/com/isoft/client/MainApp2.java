package com.isoft.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.isoft.cache.Calculator;
import com.isoft.cache.Calculator2;

public class MainApp2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext ctx= new ClassPathXmlApplicationContext("applicationContext2.xml");
        Calculator2 calculator=(Calculator2) ctx.getBean("calculator2");
        System.out.println(calculator.add(2, 3));
        System.out.println(calculator.add(2, 3));
	}

}
