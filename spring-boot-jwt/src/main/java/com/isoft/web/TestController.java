package com.isoft.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isoft.vo.LoginPara;

@RestController
@RequestMapping("/test")
public class TestController {
	@RequestMapping("/getU1")
	public String getUser1() {

		return "Hello";
	}
	
	//http://localhost:8080/test/getU2
	@RequestMapping("/getU2")
	public LoginPara getUser2() {
		LoginPara user = new LoginPara();
		user.setUserName("小明");
		user.setPassword("xxxx");
		return user;
	}
}
