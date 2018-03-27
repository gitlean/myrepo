package com.isoft.blueberry.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mvc")
public class IndexController {
	@RequestMapping(value = "/index")
	public String index(HttpServletRequest request) {

		return "index";   // /WEB-INF/jsp/index.jsp

	}
}
