package com;

import com.newer.login.bean.User;
import com.newer.login.service.UserService;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user=new User();
		user.setUserName("admin");
		user.setPassword("123456");
		UserService userService=new UserService();

		User u=userService.login(user);
		
		if(null==u){
			System.out.println("null");
		}
	}

}
