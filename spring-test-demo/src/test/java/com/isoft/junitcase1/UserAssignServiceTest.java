package com.isoft.junitcase1;


import static org.junit.Assert.*;


import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.isoft.BaseJunit4Test;
import com.isoft.dao.IBaseDao;

import java.util.List;
import java.util.Map;

public class UserAssignServiceTest extends BaseJunit4Test {

	//如果关联了tomcat，@Resource不需额外的jar包依赖，tomcat  annotations-api.jar
	@Resource // 自动注入,默认按名称  即 “baseDao”
	private IBaseDao baseDao;

	@Test // 标明是测试方法
	@Transactional // 标明此方法需使用事务
	@Rollback(false) // 标明使用完此方法后事务不回滚,true时为回滚
	public void insert() {
		String sql = "insert into user(name,password) values(?,?)";
		Object[] objs = new Object[] { "00", "000" };
		baseDao.insert(sql, objs);

		String sql1 = "select * from user where name=? and password=? ";
		List<Map<String, Object>> list = baseDao.queryForList(sql1, objs);
		System.out.println(list);
		assertTrue(list.size() > 0);
	}

}