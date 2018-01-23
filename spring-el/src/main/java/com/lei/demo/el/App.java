package com.lei.demo.el;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		Customer obj = (Customer) context.getBean("customerBean");
		System.out.println(obj);
		System.out.println(obj.getItemName());

	}

}