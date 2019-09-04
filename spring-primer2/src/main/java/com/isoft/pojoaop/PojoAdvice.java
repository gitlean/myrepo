package com.isoft.pojoaop;

import org.aspectj.lang.ProceedingJoinPoint;

public class PojoAdvice {
	public void before() {
		System.out.println("前置通知");
	}

	public void after(Object returnval) {
		System.out.println("后置通知" + "，处理后的结果为：" + returnval);
	}

	public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("环绕前置增强...");
		Object o = proceedingJoinPoint.proceed();
		System.out.println("环绕后置增强...");
		return o;
	}

	public void afterThrowing(Throwable e) {
		System.out.println("异常通知:" + e.getMessage());
	}
}
