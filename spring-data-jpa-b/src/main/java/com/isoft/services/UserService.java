package com.isoft.services;

import java.util.List;

import com.isoft.entity.UserInfo;

public interface UserService {
	public UserInfo save(UserInfo user);
	
	public List<UserInfo> findAll();
	
	public UserInfo findById(Integer Id);
	
	public void delete(UserInfo user);
	
	
}
