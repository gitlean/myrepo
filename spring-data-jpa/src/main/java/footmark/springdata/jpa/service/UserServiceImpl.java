package footmark.springdata.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import footmark.springdata.jpa.dao.UserDaoImpl;
import footmark.springdata.jpa.domain.UserInfo;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDaoImpl dao;

	public UserInfo save(UserInfo user) {
		// TODO Auto-generated method stub
		return dao.save(user);
	}

	public UserInfo findByUserId(Integer userid) {
		// TODO Auto-generated method stub
		return dao.findByUserId(userid);
	}

}
