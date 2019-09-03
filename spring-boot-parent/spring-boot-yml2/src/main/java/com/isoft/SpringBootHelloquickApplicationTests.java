package com.isoft;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import com.isoft.bean.Person;

/**
 * @author john
 * @createTime 2019年9月2日 上午10:56:51
 * @describe
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootHelloquickApplicationTests {

	@Autowired
	private Person person;

	@Test
	public void contextLoads() {
		System.out.print(person);
	}

}
