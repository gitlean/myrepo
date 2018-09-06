package com.service.demo;

import javax.jws.WebMethod;
import javax.jws.WebService;

//@WebService(wsdlLocation = "classpath:wsdl/HelloWorld.wsdl")
@WebService
public interface IHelloWorld {
	//@WebMethod
	public String sayHello(String name);
}
