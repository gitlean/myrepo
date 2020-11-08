package com.isoft;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.isoft.controller.MyController;
import com.isoft.entity.RiskEarlyWarn;

/**
*@author anonymous
*@createTime 2020年11月5日 下午1:21:39
*@describe
*/
public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		
		/*
		EarlyWarnPublishImpl publisher = (EarlyWarnPublishImpl) context
				.getBean("earlyWarnPublish");
		publisher.register(new RiskEarlyWarn("a","Hello"));

		//一般和AOP结合使用，当进入某个方法之前 发布时间，这里直接发布
		
		*/
		
		MyController myController=(MyController) context.getBean("myController");
		RiskEarlyWarn riskEarlyWarn=new RiskEarlyWarn("a","b");
		
		String rdata=myController.aMethod(riskEarlyWarn);
		System.out.println(rdata);
		
		
		
	}

}
