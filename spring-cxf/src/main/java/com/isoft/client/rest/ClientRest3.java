package com.isoft.client.rest;

/**
 * 编写一个基于WebClient（org.apache.cxf.jaxrs.client.WebClient）简单客户端
 */
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.client.WebClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.isoft.rs.DTO.ReturnDTO;
import com.isoft.rs.entity.UserAddress;
import com.isoft.rs.entity.UserBean;
import com.isoft.rs.entity.UserPhone;

import net.sf.json.JSONObject;

public class ClientRest3 {


	public static void main(String[] args) {
		JSONObject json=new JSONObject();
		json.put("key1", "value1");
		
		WebClient wsc = WebClient.create("http://localhost:8080/spring-cxf/ws/restServiceMock");

		wsc.header("Content-Type", MediaType.APPLICATION_JSON);//设置Content-Type
		
		String returnStr=wsc.path("/saveAuth").accept(MediaType.APPLICATION_JSON).acceptEncoding("utf-8").post(json.toString(),
				String.class);
		System.out.println(returnStr);

	}

	

}
