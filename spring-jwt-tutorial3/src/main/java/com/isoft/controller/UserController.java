package com.isoft.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.isoft.service.UserService;
import com.isoft.utils.JWT;
import com.isoft.vo.Login;
import com.isoft.vo.ResponseData;
import com.isoft.vo.User;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	// 处理登录
	//@RequestMapping(value = "/login", produces = "application/json; charset=utf-8")
	@RequestMapping(value = "/login")
	public @ResponseBody ResponseData login(HttpServletRequest request, @RequestParam("email") String email,
			@RequestParam("password") String password) {
		Login login = new Login();
		login.setEmail(email);
		login.setPassword(password);
		ResponseData responseData = ResponseData.ok();
		// 先到数据库验证
		Integer loginId = userService.checkLogin(login);
		
		
		
		if (null != loginId) {
			User user = userService.getUserByLoginId(loginId);
			login.setId(loginId);
			// 给用户jwt加密生成token
			String token = JWT.sign(login, 60L * 1000L * 30L);
			// 封装成对象返回给客户端
			responseData.putDataValue("loginId", login.getId());
			responseData.putDataValue("token", token);
			responseData.putDataValue("user", user);
		} else {
			responseData = ResponseData.customerError();
		}
		return responseData;
	}

}
