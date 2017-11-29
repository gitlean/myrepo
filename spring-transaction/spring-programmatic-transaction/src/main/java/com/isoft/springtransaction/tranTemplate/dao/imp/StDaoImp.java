package com.isoft.springtransaction.tranTemplate.dao.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.isoft.springtransaction.tranTemplate.dao.StDao;

@Repository("stDao")
public class StDaoImp implements StDao {
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
