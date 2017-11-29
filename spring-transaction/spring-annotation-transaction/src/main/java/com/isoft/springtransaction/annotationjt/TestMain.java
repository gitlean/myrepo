package com.isoft.springtransaction.annotationjt;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentService studentService = (StudentService) context.getBean("studentService");
		studentService.doComplexLogic();
	}

}