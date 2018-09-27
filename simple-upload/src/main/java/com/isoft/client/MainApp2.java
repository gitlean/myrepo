package com.isoft.client;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

/**
 * 
 * @author john
 * @date 2018年1月17日
 * @time 下午2:55:06
 * @describe:https://www.cnblogs.com/dennyzhangdd/p/6808321.html
 * 在HttpCient4.3之前上传文件主要使用MultipartEntity这个类，但现在这个类已经不在推荐使用了（过时了）。随之替代它的类是MultipartEntityBuilder
 * 中文名称不行且  普通文件上传成功但内容为空
 */
public class MainApp2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		MultipartEntityBuilder entityBuilder = MultipartEntityBuilder.create();
		entityBuilder.addBinaryBody("file", new byte[] {}, ContentType.DEFAULT_BINARY, "E:\\finance.txt");

		HttpEntity entity = entityBuilder.build();

		HttpPost request = new HttpPost("http://localhost:8080/simple-upload/ws/file/upload");
		request.setEntity(entity);

		HttpClient client = HttpClientBuilder.create().build();
		client.execute(request);
		System.out.println("<<<<<<<<>>>>>>>>>>>>>.");

	}

}
