package net.hw.webmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.hw.bean.User;
import net.hw.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/index")
	public String index(){
		return "index";
	}


	
	@RequestMapping("/showStudent")
	public String showStudent(){
		return "showStudent";
	}
	
	@RequestMapping("/showOneUser")
	public String showOneUser(Model model){
		
		User oneuser=userService.findOneUser();
		model.addAttribute("user", oneuser);
		return "showOneUser";
	}
	
	
	@RequestMapping("/showAllUsers")
	public String showAllUsers(Model model){
		List<User> users=userService.findAllUsers();
		
		model.addAttribute("users", users);
		return "showAllUsers";
	}
	
	@RequestMapping("/showAllUsers2")
	public String showAllUsers2(Model model){
		List<User> users=userService.findAllUsers();
		
		model.addAttribute("users", users);
		return "showAllUsers2";
	}
	
	
	@RequestMapping("/welcome")
	public String welcome(Model model){
		model.addAttribute("name", "张三");
		return "welcome";
	}
	
	
	
	
}
