package com.isoft.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@RequestMapping("/hello")
	public String index() throws Exception {

		//throw new Exception("EXXXX");

		int a=10;
		int b=0;
		int c=a/b;
		return "Hello World";
	}

}