package footmark.springdata.jpa.service;

import footmark.springdata.jpa.domain.UserInfo;

public interface UserService {
	public UserInfo save(UserInfo user);

	public UserInfo findByUserId(Integer userid);
}
