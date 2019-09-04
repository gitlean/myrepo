package com.isoft.test;

import java.util.Calendar;
import java.util.Locale;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.isoft.action.Log;
import com.isoft.beans.HelloBean;

public class TestMain {
	public static void main(String[] args) {

		call5();
		 
	}
	
	
	public static void call1(){
		HelloBean hbean=new HelloBean();

		BeanWrapper bw = new BeanWrapperImpl(hbean);
		bw.setPropertyValue("msg", "ASSD");
		System.out.println(bw.getPropertyValue("msg"));
	}
	
	public static void call2() throws Exception{
		
		//InputStream ins=new FileInputStream("applicationContext.xml"); //绝对路径、相对路径
		//Resource res =new InputStreamResource(ins);
		
		Resource res=new ClassPathResource("applicationContext.xml");
		 
		BeanFactory factory=new XmlBeanFactory(res);  //实际应用中，把BeanFactory封装为SpringBeanFactory
		HelloBean hbean = (HelloBean) factory.getBean("helloBean");
		
		hbean.setMsg("dsfd");
		System.out.println(hbean.getMsg());
		
	}
	
	
	public static void call3(){
		//ApplicationContext ctx =new FileSystemXmlApplicationContext("applicationContext.xml");//绝对路径、相对路径
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloBean hbean = (HelloBean) ctx.getBean("helloBean");
		hbean.setMsg("dsfd");
		System.out.println(hbean.getMsg());

		
	}
	//-----------------------------------------------------------------------
	
	/**
	 * 国际化
	 */
	public static void call4(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	 
		
		Object[] objs=new Object[]{"哈喽",Calendar.getInstance().getTime()};
		String msg=ctx.getMessage("HelloWorld", objs,Locale.CHINA); //获取key=HelloWorld的msg
		System.out.println(msg);
		
	}
	
	/**
	 * 事件传递
	 */
	public static void call5(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Log log=(Log) ctx.getBean("log");
		log.log("ssssssssss");
	}

}
