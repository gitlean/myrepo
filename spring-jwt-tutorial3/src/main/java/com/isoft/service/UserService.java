package com.isoft.service;

import com.isoft.vo.Login;
import com.isoft.vo.User;

public interface UserService {
	public int checkLogin(Login login);
	public User getUserByLoginId(int loginId);
}
