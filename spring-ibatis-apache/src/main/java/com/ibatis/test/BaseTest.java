package com.ibatis.test;
 
 
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
 
import com.spring.ibatis.dao.TestDao;
import com.spring.ibatis.domain.LoginForm;
 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class BaseTest {
	
	@Autowired
	TestDao dao;
	
	@Test
	public void test() {
		LoginForm command = dao.getById();
		String username = command.getUsername();
		System.out.println(username);
	}
}