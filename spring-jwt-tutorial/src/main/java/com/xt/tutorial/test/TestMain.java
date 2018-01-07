package com.xt.tutorial.test;

import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.xt.tutorial.models.User;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(System.currentTimeMillis());
		SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
		RestTemplate restTemplate = new RestTemplate(requestFactory);

		User user = new User();
		user.setUsername("tome");
		user.setPassword("123456");
		
		
		String postResult = restTemplate.postForObject("http://localhost:8080/spring-web-tutorial/users/model", "wddddddddd",
				String.class);
		System.out.println(postResult);

	}
	
	
	public static String loginTest(User user,RestTemplate restTemplate){
		return restTemplate.postForObject("http://localhost:8080/spring-web-tutorial/users/login", user,
				String.class);
		
	}
	
	

}
