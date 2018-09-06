package com.isoft.demo;

import java.io.*;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class TestMain {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		File file = new File("E:/score20180112.txt");
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		String line=null;
		String data="";
		while(null!=(line=reader.readLine())){
			data+=line;
		}
		
		JSONObject json=JSON.parseObject(data);
		System.out.println(json);
		
		//json.getJSONObject("params");
		System.out.println(json.getJSONObject("params").toJSONString());
		
	}

}
