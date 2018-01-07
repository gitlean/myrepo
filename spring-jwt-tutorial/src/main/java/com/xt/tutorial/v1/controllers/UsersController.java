package com.xt.tutorial.v1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.xt.tutorial.models.User;
import com.xt.tutorial.utils.JWT;
import com.xt.tutorial.utils.ResponseData;

//UsersController用于测试登录
@Controller
@RequestMapping("/users")
public class UsersController {

	@RequestMapping("/login")
	@ResponseBody
	public ResponseData login(@RequestParam String username, @RequestParam String password) {
		if ("imjack".equals(username) && "123456".equals(password)) {
			ResponseData responseData = ResponseData.ok();
			User user = new User();
			user.setId(1);
			user.setUsername(username);
			user.setPassword(password);
			
			responseData.putDataValue("user", user);
			
			String token = JWT.sign(user, 30L * 24L * 3600L * 1000L);
			if (token != null) {
				responseData.putDataValue("token", token);
			}
			
			return responseData;
		}
		return ResponseData.customerError().putDataValue(ResponseData.ERRORS_KEY, new String[] { "用户名或者密码错误" });
	}

	@PostMapping(value = "/model")
	@ResponseBody
	public User model(@RequestBody String rqmbodyString) {

		System.out.println(rqmbodyString);

		User user = new User();
		user.setId(1);
		user.setUsername("Tome");
		user.setPassword("123456");
		return user;
	}

	@RequestMapping(value = "/model2")
	@ResponseBody
	public User model2(@RequestParam(value="username",required=false) String username) {
		//http://825635381.iteye.com/blog/2196911
		//可以通过required=false或者true来要求@RequestParam配置的前端参数是否一定要传
		System.out.println(username);

		User user = new User();
		user.setId(1);
		user.setUsername("Tome");
		user.setPassword("123456");
		return user;
	}
}
