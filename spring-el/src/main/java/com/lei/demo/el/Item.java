package com.lei.demo.el;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("itemBean")
public class Item {

	@Value("itemA") // 直接注入String
	private String name;

	@Value("10") // 直接注入integer
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