package com.isoft.cache;

import org.springframework.stereotype.Service;

@Service("calculator2")
public class Calculator2 {
	

	public int add(int a,int b){
		
		System.out.println("now calculator a+b...");
		return a+b;
	}

}
