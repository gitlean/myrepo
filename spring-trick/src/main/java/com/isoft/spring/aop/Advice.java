package com.isoft.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

import com.isoft.spring.aop.service.IAddition;
import com.isoft.spring.aop.service.imp.AdditionImpl;

//增强类
//使用@Aspect将该类变成一个Spring能够识别的切面提供类；标记@Component，能够让Spring配置对象扫描到；
@Aspect
@Component
public class Advice {

//	简单解释一下这个代码：
//	1，public IAddition addition字段，代表我要引入的接口；
//	2，@DeclareParents标签说明这个接口要引入的目标，其中value="cn.wolfcode.springboot.utilstest.IEmployeeService+"代表要引入到的目标类是IEmployeeService及其所有子类；
//	3，defaultImpl代表接口默认的实现，即我们的AdditionImpl类；
//	到这里，一个基本的introduction就已经配置完成；
	@DeclareParents(value = "com.isoft.spring.aop.service.IEmployeeService+", 
            defaultImpl = AdditionImpl.class)
	public IAddition addition;


	
	// 定义的前置增强切入点
	// @Before("execution(* com.isoft.spring.aop.service.imp.*Service*.*(..))")
	@Before("execution(* com.isoft.spring.aop.service.*Service*.*(..))")
	public void advisor() {
		System.out.println("do before");
	}

	// 在Advice类中增加一个针对MyComponent的增强：
	@Before("execution(* com.isoft.spring.aop.service.MyComponent.*(..))")
	public void advisor2() {
		System.out.println("do before");
	}

}
