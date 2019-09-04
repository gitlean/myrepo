package com.isoft.pojoaop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

 
public class Aoptest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		IBookDao book = (IBookDao) ctx.getBean("bookDao");
		
		 book.add();
		
		//book.delete();
		
	}

}
