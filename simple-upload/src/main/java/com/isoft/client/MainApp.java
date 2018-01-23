package com.isoft.client;

import java.io.File;
import java.nio.charset.Charset;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * 
 * @author john
 * @date 2018年1月17日
 * @time 下午2:17:48
 * @describe:客户端代码参考http://blog.csdn.net/shang3583091/article/details/50955328
 * 
 * 中文名称文件不行
 */
public class MainApp {

	public static void main(String[] args) throws Exception {
		MultipartEntity entity = new MultipartEntity();
		entity.addPart("id", new StringBody("newid", Charset.forName("UTF-8")));
		entity.addPart("name", new StringBody("newName", Charset.forName("UTF-8")));
		entity.addPart("file1", new FileBody(new File("E:\\扬州征信业务系统移交清单.docx")));

		HttpPost request = new HttpPost("http://localhost:8080/simple-upload/ws/file/upload");
		request.setEntity(entity);
		HttpClient client = new DefaultHttpClient();
		client.execute(request);
		System.out.println("<<<<<<<<>>>>>>>>>>>>>.");
	}

}
