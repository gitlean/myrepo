package com.xt.tutorial.v1.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xt.tutorial.utils.ResponseData;

/**
 * 
 * @author john
 * @date 2018年1月5日
 * @time 上午11:55:41
 * @describe: 此controller用来测试用的
 */
@Controller
@RequestMapping("/index")
public class IndexController {
	
	@GetMapping
	@ResponseBody
	public Map<String, Object> index() {
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("code", 200);
		response.put("message", "Ok");
		response.put("data", new HashMap<String, String>());
		return response;
	}
	
	@GetMapping("/test_response_data")
	@ResponseBody
	public ResponseData testResponseData() {
		return ResponseData.ok().putDataValue("token", "XXXXXXXXXXXXXXXXXXXXXXX");
	}
}
