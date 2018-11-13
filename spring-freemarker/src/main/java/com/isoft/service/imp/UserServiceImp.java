package com.isoft.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.isoft.entity.User;
import com.isoft.service.IUserService;

@Service
public class UserServiceImp implements IUserService {

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> list=new ArrayList<User>();
		
		User u1=new User(1,"Tome",12);
		User u2=new User(2,"jerry",14);
		User u3=new User(3,"john",18);
		
		list.add(u1);
		list.add(u2);
		list.add(u3);
		
		return list;
	}

}
