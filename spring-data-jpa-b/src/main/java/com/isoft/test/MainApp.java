package com.isoft.test;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.isoft.entity.UserInfo;
import com.isoft.services.UserService;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService = ctx.getBean("userService", UserService.class);
		UserInfo user = new UserInfo();
		user.setUsername("Tom");
		userService.save(user);

		// -----------------------------------------------
		List<UserInfo> list = userService.findAll();
		Iterator iter = list.iterator();
		while (iter.hasNext()) {
			user = (UserInfo) iter.next();
			System.out.println(user);
		}
		// -----------------------------------------------
		user = userService.findById(5);
		System.out.println(user);
		// -----------------------------------------------
		
		user.setUserId(7);
		
		userService.delete(user);

	}
}
