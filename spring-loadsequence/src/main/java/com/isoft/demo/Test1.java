package com.isoft.demo;

import org.springframework.stereotype.Service;

@Service
public class Test1 {
	private String name = "123";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
