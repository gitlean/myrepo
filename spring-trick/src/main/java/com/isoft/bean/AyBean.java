package com.isoft.bean;

import org.springframework.stereotype.Component;

@Component("ayBean")
public class AyBean {
	
	public void dosth(String msg){
		System.out.println("AyBean-------->"+msg);
	}

}
