package com.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
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

	
	public  void sengMsg() {

//		RequestModel modle=template.getForObject("http://localhost:8080/springmvc-jackson-rest/rest/demo/path/Tome/123456",
//				RequestModel.class);
		
		//*********************************************************
		
		HttpHeaders headers = new HttpHeaders();  
	    headers.add("X-Auth-Token", "e348bc22-5efa-4299-9142-529f07a18ac9");  
		MultiValueMap<String,String> multiValueMap=new LinkedMultiValueMap<String, String>();
        multiValueMap.add("username","tome");
        multiValueMap.add("password","123456");
        
        HttpEntity<MultiValueMap<String, String>> requestEntity  = new HttpEntity<MultiValueMap<String, String>>(multiValueMap,headers);  
		RequestModel modle=template.postForObject("http://localhost:8080/springmvc-jackson-rest/rest/demo/param",requestEntity
				,RequestModel.class);
		
		//*********************************************************
		

		System.out.println(modle);
		System.out.println("<<<<<<>>>>>>>>>>.");

	}

}
