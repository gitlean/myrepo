package com.isoft.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.isoft.vo.ResponseData;

@Controller
public class BizController {
	@RequestMapping(value = "/add")
	@ResponseBody
	public ResponseData login(@RequestParam("a") String a, @RequestParam("b") String b) {
		ResponseData responseData = ResponseData.ok();
		int sum = Integer.parseInt(a) + Integer.parseInt(b);
		responseData.putDataValue("sum", sum);
		return responseData;

	}
}
