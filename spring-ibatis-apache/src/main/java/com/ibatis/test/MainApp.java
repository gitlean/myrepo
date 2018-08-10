package com.ibatis.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.ibatis.dao.TestDao;
import com.spring.ibatis.domain.LoginForm;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		TestDao dao = (TestDao) ctx.getBean("testDao");

		LoginForm command = dao.getById();
		String username = command.getUsername();
		System.out.println(username);
	
		
	}

}
