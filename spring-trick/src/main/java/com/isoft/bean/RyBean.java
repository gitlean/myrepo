package com.isoft.bean;

import org.springframework.stereotype.Component;

@Component("ryBean")
public class RyBean {
	
	public void dosth(String msg){
		System.out.println("RyBean---->"+msg);
	}

}
