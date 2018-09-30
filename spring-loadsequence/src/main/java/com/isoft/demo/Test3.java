package com.isoft.demo;

import org.springframework.stereotype.Service;

@Service
public class Test3 {
	private static String name1=Test2.getName3();
	
	private static final String name=Test2.getName1();
	
	static{
		System.out.println("test value="+Test2.getName2());
	}

}
