package com.isoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.isoft.entity.UserInfo;
@Repository
public interface UserInfoRepository extends CrudRepository<UserInfo, Integer> {
	UserInfo findUserInfoById(int id);

	List<UserInfo> findUserInfoByRole(String role);

	@Query(value = "select * from t_user limit ?1", nativeQuery = true)
	List<UserInfo> findAllUsersByCount(int count);

	UserInfo findUserInfoByName(String userName);
}
