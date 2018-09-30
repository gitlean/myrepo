package com.isoft.client.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
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

	//HTTP 415 Unsupported Media Type       ????
	/**
	 *  @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
		@Produces({MediaType.APPLICATION_JSON})
		public interface IServiceMock {}
		
		接受什么样的数据、返回什么样的数据？？           convert
		这里传的是string  "Hello"   
	 */
	
	public void sengMsg2() {


		JSONObject json=new JSONObject();
		json.put("key1", "value1");
		String respon =template.postForObject("http://localhost:8080/spring-cxf/ws/restServiceMock/saveAuth", "Hello", String.class);
		
		System.out.println(respon);
		System.out.println("<<<<<<>>>>>>>>>>.");

	}

	//HTTP 415 Unsupported Media Type 
	//这里传的是JSONObject
	public void sengMsg3() {
		JSONObject json=new JSONObject();
		json.put("key1", "value1");
		JSONObject respon =template.postForObject("http://localhost:8080/spring-cxf/ws/restServiceMock/saveAuth", json.toString(), JSONObject.class);
		System.out.println(respon.toString());
		System.out.println("<<<<<<>>>>>>>>>>.");

	}
	
	
	//sengMsg2() 稍微做改动      https://www.cnblogs.com/BensonHe/p/4602746.html    
	public void sengMsg4() {
		JSONObject jsonObj=new JSONObject();
		jsonObj.put("key1", "value1");
		
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());

        HttpEntity<String> formEntity = new HttpEntity<String>("Hello", headers);

        JSONObject respon  = template.postForObject("http://localhost:8080/spring-cxf/ws/restServiceMock/saveAuth", formEntity, JSONObject.class);
		
	
		System.out.println(respon.toString());
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
