package com.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.service.rest.RequestModel;

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

		RequestModel modle=template.getForObject("http://localhost:8080/springmvc-jackson-rest/rest/demo/path/Tome/123456",
				RequestModel.class);
		System.out.println(modle);
		System.out.println("<<<<<<>>>>>>>>>>.");

	}

}
