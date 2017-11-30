package com.isoft.ws.service.imp;


import javax.jws.WebService;

import com.isoft.ws.service.IHelloService;

/**
 * <p>
 * WebService实现类
 * </p>
 *
 * @author IceWee
 * @date 2012-7-6
 * @version 1.0
 */
//@WebService(endpointInterface = "bing.server.IHelloService", serviceName = "HelloService")
@WebService
public class HelloServiceImpl implements IHelloService {

	
	public String sayHello(String username) {
		return "hello, " + username;
	}

}
