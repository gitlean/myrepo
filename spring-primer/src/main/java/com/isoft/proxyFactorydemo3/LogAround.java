package com.isoft.proxyFactorydemo3;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LogAround implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println(invocation.getMethod().getName() + "调用之前");
		Object res = invocation.proceed();
		System.out.println(invocation.getMethod().getName() + "调用之后");
		
		
		return res;
	}



}
