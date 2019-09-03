package com.isoft.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.isoft.bean.School;

/**
*@author john
*@createTime 2019年9月3日 上午10:16:05
*@describe 使用 <context:property-placeholder/> 标签将properties 文件引入到项目中
*/

@RunWith(SpringRunner.class)
@ContextConfiguration({"classpath:applicationContext3.xml"})
public class TestSpring3 {
	@Autowired
	private School school;
 
	@Test
    public void testM1(){
		System.out.println(school);
	}

	
	
}
