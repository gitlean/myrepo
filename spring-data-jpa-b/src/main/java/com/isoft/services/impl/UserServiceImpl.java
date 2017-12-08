package com.isoft.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isoft.entity.UserInfo;
import com.isoft.repository.UserRepository;
import com.isoft.services.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository dao;

	public UserInfo save(UserInfo user) {
		// TODO Auto-generated method stub
		
		return dao.save(user);
	}

	public List<UserInfo> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
		
	}

	public UserInfo findById(Integer Id) {
		// TODO Auto-generated method stub
		Optional<UserInfo> user =dao.findById(Id);
		
		
		if(user.isPresent()){//不为空
			return user.get();
		}
		return null;
	}

	public void delete(UserInfo user) {
		// TODO Auto-generated method stub
		dao.delete(user);
		
		
	}



}
