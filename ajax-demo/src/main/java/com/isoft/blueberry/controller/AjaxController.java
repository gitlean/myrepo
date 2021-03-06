package com.isoft.blueberry.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;


/**
 * 注意，此处用  @RestController 来标志   区分 @Controller
 * @author john
 * @date 2018年3月29日
 * @time 上午11:16:57
 * @describe:
 */
@RestController
@RequestMapping("/org")
public class AjaxController {
	@RequestMapping(value = "/doDelete")
	public String index(HttpServletRequest request) {
		String param1=request.getParameter("param1");
		String param2=request.getParameter("param2");
		System.out.println(param1+"\t"+param2);
		
		JSONObject json=new JSONObject();
		
		if(!StringUtils.isEmpty(param1)&&param1.equals("1")){
			json.put("success", 1);
		}else{
			json.put("success", 0);
		}
		
		
		return json.toJSONString();
		
		//return "index";   // /WEB-INF/jsp/index.jsp
		//return "asdf";
	}
	
	
	@RequestMapping(value = "/roll")
	public String roll(HttpServletRequest request) {
		
		JSONObject json=new JSONObject();
		int num=(int)(Math.random()*10000);
		json.put("count", num);
		json.put("count", num);
		System.out.println(new Date()+"--------->"+json);
		return json.toJSONString();

	}
	
	public static void main(String[] args) {
		int num=(int)(Math.random()*10000);
		System.out.println(8765);
	}
	
	
}
