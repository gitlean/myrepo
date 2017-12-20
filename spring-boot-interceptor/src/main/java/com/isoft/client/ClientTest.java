package com.isoft.client;

import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class ClientTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleClientHttpRequestFactory requestFactory=new SimpleClientHttpRequestFactory();
		RestTemplate restTemplate=new RestTemplate(requestFactory);
		call(restTemplate);
		

	}
	
	
	public static void call(RestTemplate restTemplate){
		String data=restTemplate.getForObject("http://localhost:9000/interceptor/hello", String.class);
		System.out.println(data);
	}

}
