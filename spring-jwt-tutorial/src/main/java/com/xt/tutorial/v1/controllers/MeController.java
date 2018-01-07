package com.xt.tutorial.v1.controllers;

//为了验证我们的JWT是否真的可以工作，我们再设计一个MeController里面有一个get_info接口
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xt.tutorial.models.User;
import com.xt.tutorial.utils.JWT;
import com.xt.tutorial.utils.ResponseData;

@Controller
@RequestMapping("/me")
public class MeController {

	@GetMapping("/get_info")
	@ResponseBody
	public ResponseData getInfo(@RequestParam String token) {
		User user = JWT.unsign(token, User.class);
		if (user != null) {//认证成功
			return ResponseData.ok().putDataValue("user", user);
		}
		return ResponseData.customerError().putDataValue(ResponseData.ERRORS_KEY, new String[] { "token不合法" });
	}
}
