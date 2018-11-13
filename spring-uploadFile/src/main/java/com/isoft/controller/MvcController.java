package com.isoft.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mvc")
public class MvcController {
	@RequestMapping(value = "/index")
	public String index(HttpServletRequest request) {

		
		
		
		System.out.println("IndexController----------->");
		return "index"; // /WEB-INF/jsp/index.jsp

	}
	

	
	
	@RequestMapping(value = "/index4")
	public String index4(HttpServletRequest request) {

		 
		return "index4"; // /WEB-INF/jsp/index2.jsp

	}
	

	
	@RequestMapping(value = "/bootstrapdemo")
	public String bootstrapdemo(HttpServletRequest request) {

		 
		return "bootstrapdemo";  

	}
	
	
	
	
	@RequestMapping(value = "/jstldemo")
	public String index2(HttpServletRequest request) {

		 
		return "jstldemo"; // /WEB-INF/jsp/index2.jsp

	}
	
}
