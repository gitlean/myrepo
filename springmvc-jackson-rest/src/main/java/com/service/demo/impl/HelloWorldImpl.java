package com.service.demo.impl;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.service.demo.IHelloWorld;

@WebService
public class HelloWorldImpl implements IHelloWorld {

	@WebMethod
	public String sayHello(String name) {
		System.out.println("say hello is called");
		return "hello " + name;
	}

}