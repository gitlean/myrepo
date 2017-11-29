package com.isoft.test;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.isoft.bean.RyBean;
import com.isoft.util.ProductAwareBean;

public class TestMain2 {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		RyBean bean=(RyBean) context.getBean("ryBean");
		bean.dosth("SSSSSS");
		
//		ProductAwareBean p=(ProductAwareBean) context.getBean("productAwareBean");
//		Map<String,String> map=p.getReplaceableBeanNameRigistry();
//		System.out.println(map);
		//org.springframework.context.event.internalEventListenerProcessor p=null;
	}

}
