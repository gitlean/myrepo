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
	 * ���ύ��form�Ĳ���ӳ�䵽����
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
    public RequestModel model2(@RequestBody  RequestModel rqm ) {  //ע������һ���������𣬴�������������Բ��� RequestModel������������bean
        System.out.println(rqm.getUsername());
        System.out.println(rqm.getPassword());
        System.out.println(rqm.toString());
        return rqm;  
    }  
	
	
	
	/**
	 * ֱ�Ӱ�JSON�ַ�������body post�����Ϳ�����
	 * �ڲ���֮ǰ����@RequestBodyע�⡣������ָ���Ŀͻ��˷��͹�����������������ݸ�ʽת����javaʵ��
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
	 * username  password  ͨ��POST��GET������������
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
     * url  ������
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
