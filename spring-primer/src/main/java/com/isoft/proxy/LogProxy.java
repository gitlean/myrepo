package com.isoft.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 
 * @author john
 * @date 2018年11月16日
 * @time 上午10:22:47
 * @describe: 与静态代理相比（固定代理接口），这里动态绑定接口
 * 动态代理主要涉及接口InvocationHandler，以及Proxy类。
 * 
 * 因为生成的proxy class中，继承了Proxy类，实现了需要代理的接口，而Java中是单继承，多实现的处理方式，也就解释了JDK动态代理中只能代理接口的原因了
 * 
 * 
 */
public class LogProxy implements InvocationHandler {

	private Object delegate;//动态接受
	
	//获取代理类
	public Object bind(Object delegate){
		this.delegate=delegate;
		
		//
		return Proxy.newProxyInstance(delegate.getClass().getClassLoader(), delegate.getClass().getInterfaces(), this);//.getInterfaces()
	}
	
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		 //this.object=object;
		Object result=null;
		System.out.println("在调用"+method.getName()+"之前....");
		result=method.invoke(delegate, args);
		
		return result;
	}

}
