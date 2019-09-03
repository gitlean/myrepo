package com.isoft.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.isoft.bean.Person;

/**
*@author john
*@createTime 2019年9月3日 上午10:16:05
*@describe  @PropertySource 注解将配置文件加载到某一个类中
*/

@RunWith(SpringRunner.class)
@ContextConfiguration({"classpath:applicationContext2.xml"})
public class TestSpring2 {
	@Autowired
	private Person person;

	@Test
    public void testM1(){
		System.out.println(person);
	}

	
	
}
