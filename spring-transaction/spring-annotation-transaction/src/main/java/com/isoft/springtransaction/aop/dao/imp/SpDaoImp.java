package com.isoft.springtransaction.aop.dao.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.isoft.springtransaction.aop.dao.SpDao;

@Repository("spDao")
public class SpDaoImp implements SpDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void update1() {
		// 数据库操作1
		jdbcTemplate.update("insert spring_transaction(uname,address) values('a','aa')");

	}

	public void update2() {

		jdbcTemplate.update("insert spring_transaction(uname,address) values('bbbbbbbbb','bb')");

	}

}
