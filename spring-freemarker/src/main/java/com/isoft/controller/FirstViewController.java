package com.isoft.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;

import com.isoft.entity.User;
import com.isoft.service.IUserService;
import com.isoft.tools.FreeMarkerUtil;

import freemarker.template.TemplateException;

@Controller
@RequestMapping(value = "/hello")
public class FirstViewController {
	
	@Autowired
	IUserService userService;
	
	@RequestMapping(value = "test.html", method = RequestMethod.GET)
	public String index(String name, Model model) {
		model.addAttribute("message", "hello");
		model.addAttribute("name", name);
		
		return "test.ftl";
	}
	
	
	@RequestMapping(value = "/allUsers", method = RequestMethod.GET)
	public String allUsers(Model model) {
		
		
		List<User> users=userService.getAllUsers();
		model.addAttribute("users", users);
		return "allUsers.ftl";
	}
	
	
	@Autowired
	private FreeMarkerConfig freeMarkerConfig;//获取FreemarkerConfig的实例
	

	@RequestMapping("/ttt")
	public String ttt(HttpServletRequest request,HttpServletResponse response,ModelMap mv) throws IOException, TemplateException, ServletException{
		String FREEMARKER_PATH="freemarkerPath";
		
		String fileName ="ttt.html";//可以fileName随机UUID生成，这样就不会重复
		Boolean flag =(Boolean)FreeMarkerUtil.htmlFileHasExist(request, FREEMARKER_PATH, fileName).get("exist");
		if(!flag){//如何静态文件不存在，重新生成
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("name", "xiaowang小王");//这里包含业务逻辑请求等
			mv.addAllAttributes(map);
	        FreeMarkerUtil.createHtml(freeMarkerConfig, "demo.ftl", request, map, FREEMARKER_PATH, fileName);//根据模板生成静态页面
		}
		return FREEMARKER_PATH+"/"+fileName;//始终返回生成的HTML页面
	}

}
