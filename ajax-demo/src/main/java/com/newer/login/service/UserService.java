package com.newer.login.service;

import com.newer.login.bean.User;

public class UserService {

	public User login(User user) {

		// if(user.getUserName()=="admin"&&user.getPassword()=="123456"){
		// return user;
		// }

		if (user.getUserName().equals("admin")  && user.getPassword().equals("123456") ) {
			return user;
		}

		return null;

	}
}
