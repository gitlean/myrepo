package com.isoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isoft.vo.UserInfo;

/**
 * JpaRepository的查询直接在接口中定义查询方法，如果是符合规范的，可以不用写实现
 * 
 * @author john
 * @date 2017年12月8日
 * @description
 */

@Repository
public interface UserRepository extends JpaRepository<UserInfo, Integer> {

}
