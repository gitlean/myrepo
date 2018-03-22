package com.jadyer.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/mvc")
public class MyController {
	
	@RequestMapping(value = "/index")  
	public String index(HttpServletRequest request) {
		
		return "index";      // /WEB-INF/jsp/index.jsp

	}
	
	
	
	@RequestMapping(value = "/develop")  
	public String say(HttpServletRequest request) {
		System.out.println("Got it...");
		String uname=request.getParameter("uname");
		System.out.println("uname-------->"+uname);
		
		
		String contextPath=request.getContextPath();
		
		System.out.println("contextPath-------->"+contextPath);
		
		return "xx";

	}
	
	
	
	
	
	@RequestMapping(value = "/develop2")  
	public ModelAndView say2() {
		System.out.println("Got it 2...");
		ModelAndView mv=new ModelAndView();
		mv.setViewName("xx");  //    /WEB-INF/jsp/xx.jsp
		//mv.addObject("pd", null);
		return mv;

	}
	
	
	
}



