package com.isoft.client.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

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

	public void sengMsg() {

		String respon = template.getForObject("http://localhost:8080/spring-cxf/ws/restMock/sendString/123456", String.class);
		System.out.println(respon);
		System.out.println("<<<<<<>>>>>>>>>>.");

	}

}
