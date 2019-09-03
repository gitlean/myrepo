package com.isoft.test;

import java.util.Properties;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
*@author john
*@createTime 2019年9月3日 上午10:16:05
*@describe 
*/

@RunWith(SpringRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class TestSpring {
	@Autowired
	private Properties yamlProperties;
	
	@Test
    public void testM1(){
		System.out.println(yamlProperties.getProperty("environments.prod.url"));
	}

	
	
}
