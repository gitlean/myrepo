package footmark.springdata.jpa.dao;

import org.springframework.data.repository.Repository;


import footmark.springdata.jpa.domain.UserInfo;

@org.springframework.stereotype.Repository
public interface UserDaoImpl extends Repository<UserInfo, Integer> {
	public UserInfo save(UserInfo user);

	public UserInfo findByUserId(Integer userId);

	//public Page<UserInfo> findByBalanceGreaterThan(Integer balance, Pageable pageable);
	
}
