package com.service.demo.impl;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.service.demo.IHelloWorld;

/**
 * 
 * @author john
 * @date 2017年11月30日
 * @description JDK开发webservice方式 http://langgufu.iteye.com/blog/2087116
 *              sun JAX-WS
 */



@WebService
public class HelloWorldImpl implements IHelloWorld {

	@WebMethod
	public String sayHello(String name) {
		System.out.println("say hello is called");
		return "hello " + name;
	}

}