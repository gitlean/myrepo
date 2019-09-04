package com.isoft.cglibdemo;

import org.junit.Test;

import com.isoft.proxyFactorydemo2.MyTarget;

import net.sf.cglib.proxy.Enhancer;

public class ProxyTest {
	@Test
	public void proxyTest() {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(MyTarget.class);
		enhancer.setCallback(new MyInterceptor());
		MyTarget target = (MyTarget) enhancer.create();
		target.printName();
		System.out.println("proxy class name:" + target.getClass().getName());
	}

}
