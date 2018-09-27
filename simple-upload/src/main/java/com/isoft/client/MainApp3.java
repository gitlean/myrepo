package com.isoft.client;

import java.io.File;

import org.springframework.core.io.FileSystemResource;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author john
 * @date 2018年1月17日
 * @time 下午3:35:45
 * @describe:http://blog.csdn.net/mhmyqn/article/details/26395743
 * 中文名称支持
 */
public class MainApp3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "http://localhost:8080/simple-upload/ws/file/upload";
		String filePath = "E:\\苏州市地方企业征信系统信息采集及信息查询授权委托书.pdf";

		RestTemplate rest = new RestTemplate();
		
		FileSystemResource resource = new FileSystemResource(new File(filePath));
		MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
		param.add("jarFile", resource);
		//param.add("fileName", "test.txt");

		String string = rest.postForObject(url, param, String.class);
		System.out.println(string);
	}

}
