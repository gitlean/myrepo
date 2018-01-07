package com.xt.tutorial.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.xt.tutorial.models.User;
import com.xt.tutorial.utils.ResponseData;



@Component
public class Wsclient {
	@Autowired
	private RestTemplate template;

	public RestTemplate getTemplate() {
		return template;
	}

	public void setTemplate(RestTemplate template) {
		this.template = template;
	}

	// private final static String url =
	// "http://localhost:8080/springmvc-jackson-rest";

	public  void sengMsg() {
		
	
		MultiValueMap<String,String> multiValueMap=new LinkedMultiValueMap<String, String>();
        multiValueMap.add("username","tome");
        multiValueMap.add("password","123456");
		
		ResponseData data=template.postForObject("http://localhost:8080/spring-jwt-tutorial/users/login", multiValueMap, ResponseData.class);
		
		System.out.println(data);

	}

}
