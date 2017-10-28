package com.xxx.system;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
/**
 * Aspect类
 * @author john
 * @date   2017年10月27日
 * @description  创建切入代码
 */
@Component
@Aspect
public class MonitorLogAspect {
	private static Logger logger=LoggerFactory.getLogger(MonitorLogAspect.class);
	@Pointcut("@annotation(com.xxx.system.MonitorLogForService)")
	public void pointCut() {}//实际切入的代码

	@Before("pointCut()")
	public void beforeMethod(JoinPoint joinPoint) throws Throwable {
		
		String key = joinPoint.getSignature().toString();
//		System.out.println(key);
		
		logger.debug("Aspect before ..."+key);
		
		
//		Object[] args = joinPoint.getArgs();// 如果需要这里可以取出参数进行处理
//		for(int i=0;i<args.length;i++){
//			System.out.print(args[i]+"\t");
//		}
//		System.out.println();
//		
//
//		
//		System.out.println("AspectJ get it before...");
		
		

	}

}
