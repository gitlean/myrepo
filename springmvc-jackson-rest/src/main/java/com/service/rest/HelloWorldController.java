package com.service.rest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.json.JsonUtils;

@Controller  
@RequestMapping("/rest/demo")  
public class HelloWorldController {  
	/**
	 * 把提交的form的参数映射到对象
	 * @param rqm
	 * @return
	 */
	
	@ResponseBody
	//@RequestMapping(value="/model",consumes = "application/json",method=RequestMethod.POST)  
    @RequestMapping(value="/model")  
    public RequestModel model(@ModelAttribute("rqm") RequestModel rqm ) {  
        System.out.println(rqm.getUsername());
        System.out.println(rqm.getPassword());
        System.out.println(rqm.toString());
        return rqm;  
    }  
	
	@ResponseBody
    @RequestMapping(value="/model1-2")  
    public RequestModel model2(@RequestBody  RequestModel rqm ) {  //注意与上一个方法区别，此外请求参数可以不是 RequestModel，可以是其他bean
        System.out.println(rqm.getUsername());
        System.out.println(rqm.getPassword());
        System.out.println(rqm.toString());
        return rqm;  
    }  
	
	
	
	/**
	 * 直接把JSON字符串当成body post过来就可以了
	 * 在参数之前加入@RequestBody注解。用来将指定的客户端发送过来的请求参数的数据格式转换成java实体
	 * @param rqmbodyString
	 * @return
	 */
	@ResponseBody
	//@RequestMapping(value="/model",consumes = "application/json")  
    @RequestMapping(value="/model2")  
    public RequestModel model2(@RequestBody String rqmbodyString ) { 
		RequestModel rqmbody=JsonUtils.json2Object(rqmbodyString, RequestModel.class);
        System.out.println(rqmbody.getUsername());
        System.out.println(rqmbody.getPassword());
        System.out.println(rqmbody.toString());
        
        rqmbody.setUsername(rqmbody.getUsername()+"H");
        return rqmbody;  
    }  
    
	/**
	 * username  password  通过POST（GET？）传过来的
	 * @param username
	 * @param password
	 * @return
	 */
    @ResponseBody
    @RequestMapping(value="/param")  
    public RequestModel param(@RequestParam("username") String username,@RequestParam("password") String password ) {  
        System.out.println(username);
        System.out.println(password);
        RequestModel rqm=new RequestModel();
        rqm.setUsername(username);
        rqm.setPassword(password);
        return rqm;  
    }  
    
    
    /**
     * url  传参数
     * @param username
     * @param password
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/path/{username}/{password}")
    public RequestModel path(@PathVariable("username") String username,@PathVariable("password") String password ) {  
        System.out.println(username);
        System.out.println(password);
        RequestModel rqm=new RequestModel();
        rqm.setUsername(username);
        rqm.setPassword(password);
        return rqm;  
    }  
    /********************************************************/
    @ResponseBody
    @RequestMapping(value = "/myTest")
    public RequestModel myTest(HttpServletRequest req){
    	RequestModel rqm=new RequestModel();
    	String param1=req.getParameter("param1");
		String param2=req.getParameter("param2");
    	
		System.out.println(param1+"\t"+param2);
		
    	return rqm;  
    	
    }
    
    
    
}  
