package com.isoft.test;

import java.util.Collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.isoft.bean.AyBean;
import com.isoft.bean.MyBean;
import com.isoft.util.ProductAwareBean;
import com.isoft.util.SpringContextHelper;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		 MyBean bean1=SpringContextHelper.getBean(MyBean.class);
		 bean1.saySth("Hello!");
		//
		// AyBean bean2=(AyBean) SpringContextHelper.getBean("ayBean");
		// bean2.dosth("China");

		Collection<ProductAwareBean> cs = context.getBeansOfType(ProductAwareBean.class).values();
		if (cs.isEmpty()) {
			System.out.println("Empty");
		}

	}

}
