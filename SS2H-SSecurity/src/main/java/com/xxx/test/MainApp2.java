package com.xxx.test;

import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xxx.dao.FilmDao;
import com.xxx.entity.Film;
import com.xxx.system.MyService;

public class MainApp2 {

	// private Logger logger = LoggerFactory.getLogger(MainApp.class);


	
	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(MainApp2.class);

		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MyService myService= context.getBean(MyService.class);
		myService.doSth("AAAAA");
		//myService.doSth2();

	}

}
