package com.isoft.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.isoft.entity.RiskEarlyWarn;
import com.isoft.service.impl.EarlyWarnPublishImpl;

/**
 * @author anonymous
 * @createTime 2020年11月5日 下午6:46:30
 * @describe
 */

@Component
@Aspect
public class Advice {

	@Autowired
	private EarlyWarnPublishImpl earlyWarnPublish;

	
	//@Pointcut("execution(* com.isoft.controller..*.*(..))")
	@Pointcut("execution(* com.isoft.controller.*Controller*.*(..))")
	public void pointerCutMethod() {
	}

	@Around("pointerCutMethod()")
	public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("doAround");
		
		Object[] args = joinPoint.getArgs(); //MyController   aMethod的 参数列表
		Object object = joinPoint.proceed();
		earlyWarnPublish.register((RiskEarlyWarn)args[0]);
		return object;
	}
	
	
	

}
