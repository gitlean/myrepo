package com.isoft.proxyFactorydemo3;

import java.text.ParseException;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.isoft.service.ITimeBook;

/**
 * 
 * @author john
 * @date 2018年11月17日
 * @time 下午3:53:12
 * @describe:DefaultAdvisorAutoProxyCreator这个类功能更为强大，
 * 这个类的奇妙之处是他实现了BeanProcessor接口,当ApplicationContext读如所有的Bean配置信息后，
 * 这个类将扫描上下文，寻找所有的Advistor(一个Advisor是一个切入点和一个通知的组成)，
 * 将这些Advisor应用到所有符合切入点的Bean中
 */
public class ProxyTest2 {
	
	public static void main(String[] args)   {
		call1(); //DefaultAdvisorAutoProxyCreator需要ApplicationContext
		
		//call2();  //此种调用不会有代理发生

	}
	
	
	public static void call1(){
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext2.xml");
		ITimeBook timeBook = (ITimeBook) ctx.getBean("timeBook");

		timeBook.doAuditing("China");
		timeBook.call();
		System.out.println(timeBook.getClass());
	}
	
	public static void call2(){
		Resource res = new ClassPathResource("applicationContext2.xml");
		BeanFactory factory = new XmlBeanFactory(res); // 实际应用中，把BeanFactory封装为SpringBeanFactory
		ITimeBook timeBook = (ITimeBook) factory.getBean("timeBook");

		timeBook.doAuditing("China");
		timeBook.call();
		System.out.println(timeBook.getClass());
	}
	

}
