package com.isoft.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.isoft.bean.AyBean;

public class TestMain2 {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AyBean bean=(AyBean) context.getBean("ryBean"); //ryBean----com.isoft.bean.RyBean
		bean.dosth("SSSSSS");
		

	}

}
