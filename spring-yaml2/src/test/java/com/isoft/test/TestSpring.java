package com.isoft.test;


import java.util.Iterator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.PropertySource;
import org.springframework.core.env.PropertySources;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.isoft.bean.Person;

/**
*@author john
*@createTime 2019年9月3日 上午10:16:05
*@describe 
*/

@RunWith(SpringRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class TestSpring {
	@Autowired
	private PropertySourcesPlaceholderConfigurer pspConfig;
	@Autowired
	private Person person;
	
	
	@Test
    public void testM1(){
		PropertySources  ps=pspConfig.getAppliedPropertySources();
		Iterator<PropertySource<?>> iter=ps.iterator();
		while(iter.hasNext()){
			System.out.println("-----------");
			PropertySource<?> ele=iter.next();
			 
			System.out.println(ele.containsProperty("secs.prod.name"));
			System.out.println(ele.containsProperty("secs.prod.age"));
			System.out.println(ele.toString());
			
			
			String name=ele.getName();
			String value=(String) ele.getProperty(name);
			System.out.println(name+"\t"+value);
		}
		
	}

	
	@Test
    public void testM2(){
		
		System.out.println(person);
	}
	
	
	
	
	
}
