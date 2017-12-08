package com.isoft.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	private Logger logger=LoggerFactory.getLogger(MyController.class);
	@RequestMapping("/hello")
	public String hello() {
		logger.debug("DEBUG");
		logger.info("INFO");
		logger.warn("WARN");
		
		return "hello world";
	}

}
