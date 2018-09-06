package com.isoft.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isoft.repository.UserRepository;
import com.isoft.services.UserService;
import com.isoft.vo.UserInfo;

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
		UserInfo user = dao.findOne(Id);

		return user;
	}

	public void delete(UserInfo user) {
		// TODO Auto-generated method stub
		dao.delete(user);

	}

}
