package com.isoft;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.isoft.bean.Person;

/**
 * @author john
 * @createTime 2019年9月2日 上午9:29:39
 * @describe
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot02ConfigApplicationTests {
	@Autowired
	private Person person;

	@Test
	public void contextLoads() {

		System.out.println(person);

	}
}
