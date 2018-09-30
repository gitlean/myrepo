package com.lin.hessian.service;

public class BasicService implements Basic {
	private String message = "balalala！";

	@Override
	public String sayHello() {
		return message;
	}
}