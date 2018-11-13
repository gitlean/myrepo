package com.isoft.blueberry.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.isoft.aware.AService;
import com.isoft.aware.ApplicationContextHelper;
import com.isoft.aware.BeanFactoryHelper;
import com.isoft.aware.MService;

@Controller
@RequestMapping("/mvc")
public class IndexController {

	@RequestMapping(value = "/index")
	public String index(HttpServletRequest request) {

		System.out.println("got it...");

		return "index";   // /WEB-INF/jsp/index.jsp

	}
	
	
	@RequestMapping(value = "/index2")
	public String index2(HttpServletRequest request) {

		System.out.println("index2");
		AService aService=(AService) BeanFactoryHelper.getBean("compAService");

		if(null==aService){
			System.out.println("aService is null");
		}
		
	
		MService mService=(MService) BeanFactoryHelper.getBean("mService");  //异常
		
		
		return "index2"; 
	}
	
	@RequestMapping(value = "/index3")
	public String index3(HttpServletRequest request) {

		System.out.println("index3");
		
		AService aService= BeanFactoryHelper.getBean("compAService",AService.class);
		
		AService aService2= ApplicationContextHelper.getBean("compAService",AService.class);
		
		
		
		MService mService=BeanFactoryHelper.getBean("mService",MService.class);   //异常
		
		
		return "index3"; 
	}
	
	
}
