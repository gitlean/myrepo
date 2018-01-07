package com.isoft.service.imp;

import org.springframework.stereotype.Service;

import com.isoft.service.UserService;
import com.isoft.vo.Login;
import com.isoft.vo.User;

@Service
public class UserServiceImp implements UserService {

	public int checkLogin(Login login) {
		// TODO Auto-generated method stub
		return 1;
	}

	public User getUserByLoginId(int loginId) {
		// TODO Auto-generated method stub
		User user=new User();
		return user;
	}

}
