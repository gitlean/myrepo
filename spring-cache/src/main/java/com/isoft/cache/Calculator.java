package com.isoft.cache;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("calculator")
public class Calculator {
	
	@Cacheable("xxx")
	public int add(int a,int b){
		
		System.out.println("now calculator a+b...");
		return a+b;
	}

}
