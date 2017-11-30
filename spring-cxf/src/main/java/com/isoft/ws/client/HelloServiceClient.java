package com.isoft.ws.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.isoft.ws.service.IHelloService;

/**
 * <p>
 * WebService调用方-客户端
 * </p>
 * 
 * @author IceWee
 * @date 2012-7-6
 * @version 1.0
 */
public class HelloServiceClient {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext-client.xml");
		
		//获取WS的本地代理
		IHelloService proxy = (IHelloService) context.getBean("client");
		String response = proxy.sayHello("Peter");
		System.out.println(response);
	}

}
