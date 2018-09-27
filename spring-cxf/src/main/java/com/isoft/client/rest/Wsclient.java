package com.isoft.client.rest;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.support.AllEncompassingFormHttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.http.converter.xml.SourceHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.isoft.rs.DTO.ReturnDTO;
import com.isoft.rs.entity.UserBean;

import net.sf.json.JSONObject;



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

		String respon = template
				.getForObject("http://localhost:8080/spring-cxf/ws/restMock/surpolicy/sendString/123456", String.class);
		System.out.println(respon);
		System.out.println("<<<<<<>>>>>>>>>>.");

	}

	public void sengMsg2() {


		JSONObject json=new JSONObject();
		json.put("key1", "value1");
		String respon =template.postForObject("http://localhost:8080/spring-cxf/ws/restServiceMock/saveAuth", "Hello", String.class);
		
		System.out.println(respon);
		System.out.println("<<<<<<>>>>>>>>>>.");

	}
	
	public void sendBean() {

		HttpHeaders headers = new HttpHeaders();

		MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
		headers.setContentType(type);

		headers.add("Accept", MediaType.APPLICATION_JSON.toString());

		UserBean bean = new UserBean();
		bean.setAge("40");
		bean.setName("Tome");
		
		JSONObject jsonObj = JSONObject.fromObject(bean); // net.sf.json.JSONObject
		System.out.println(jsonObj);
		
		//用MappingJackson2HttpMessageConverter将bean转为json？？？

		HttpEntity<String> formEntity = new HttpEntity<String>(jsonObj.toString(), headers);

		ReturnDTO rdto = template.postForObject("http://localhost:8080/spring-cxf/ws/restMock/surpolicy/sendBean",
				formEntity, ReturnDTO.class);
		System.out.println(rdto);
		////////////////////////

		// UserBean bean = new UserBean();
		// bean.setAge("40");
		//
		// ReturnDTO rdto =
		// template.postForObject("http://localhost:8080/spring-cxf/ws/restMock/surpolicy/sendBean",
		// bean,
		// ReturnDTO.class);
		//
		// System.out.println(rdto);

		System.out.println("<<<<<<>>>>>>>>>>.");

	}

}
