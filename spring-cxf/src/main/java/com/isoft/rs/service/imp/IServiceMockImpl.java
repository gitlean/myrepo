package com.isoft.rs.service.imp;


import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.isoft.rs.service.IServiceMock;

@Service("IServiceMock")
public class IServiceMockImpl implements IServiceMock {
     
	public String saveAuth(String auth) {
		// TODO Auto-generated method stub
		//com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider p;
		JSONObject json = new JSONObject();
		json.put("saveAuth", "1");

		return json.toString();
	}

	public String getICInfo(String busiSeq, String cardType, String cardCode, String wsUser) {
		// TODO Auto-generated method stub
		JSONObject json = new JSONObject();
		json.put("getICInfo", "1");

		return json.toString();
	}

	public String getCreditReport(String busiSeq, String cardType, String cardCode, String wsUser) {
		// TODO Auto-generated method stub
		JSONObject json = new JSONObject();
		json.put("getCreditReport", "1");

		return json.toString();
	}

}
