package com.isoft.demo.el;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


public class Item {

	
	private String name;

	
	private int total;

	public String getName() {
		return name;
	}

	public int getTotal() {
		return total;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTotal(int total) {
		this.total = total;
	}

}