package com.isoft.demo;

import org.springframework.beans.factory.annotation.Autowired;

public class Test2 {

	@Autowired
	private static Test1 test1;
	
	public static String getName1(){
		System.out.println("Test2静态方法获取test1  name1="+test1.getName());
		return test1.getName();
	}
	
	public static String getName2(){
		System.out.println("Test2静态方法获取test1  name2="+test1.getName());
		return test1.getName();
	}
	
	public static String getName3(){
		System.out.println("Hello");
		System.out.println("Test2静态方法获取test1  name3="+test1.getName());
		return test1.getName();
	}
	
}
