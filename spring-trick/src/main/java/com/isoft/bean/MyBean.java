package com.isoft.bean;

import org.springframework.stereotype.Component;

@Component("myBean")
public class MyBean {
	public void saySth(String msg) {
		System.out.println("MyBean------>" + msg);
	}

}
