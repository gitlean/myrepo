package com.isoft.proxyFactorydemo3;

import java.text.ParseException;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.isoft.service.ITimeBook;

public class ProxyTest {
	
	  public static void main(String[] args) throws ParseException {  
		  Resource res=new ClassPathResource("applicationContext.xml");
			 
			BeanFactory factory=new XmlBeanFactory(res);  //实际应用中，把BeanFactory封装为SpringBeanFactory
			ITimeBook timeBook =   (ITimeBook) factory.getBean("logProxy");
			
			timeBook.doAuditing("China");
			timeBook.call();
			System.out.println(timeBook.getClass());
			
			
			
			//org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator r;
			
	    } 
	

}
