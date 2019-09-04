package com.isoft.cglibdemo;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class MyInterceptor implements MethodInterceptor {

	@Override
	public Object intercept(Object obj, Method method, Object[] params, MethodProxy proxy) throws Throwable {
		System.err.println("=======before======");
		Object res = proxy.invokeSuper(obj, params);
		System.err.println("=======and======");
		return res;
	}

}
