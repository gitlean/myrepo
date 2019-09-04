package com.isoft.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class TestMain {

	public static void main(String[] args) {
		JSONObject json=new JSONObject();
		json.put("a", "sadsad");
		json.put("b", "222222");
		
		Object o=JSON.parse(json.toJSONString());
		System.out.println(o.getClass());
		
		JSONArray jarr=new JSONArray();
		jarr.add(json);
		o=JSON.parse(jarr.toJSONString());
		System.out.println(o.getClass());
		
		
		
	}

}
