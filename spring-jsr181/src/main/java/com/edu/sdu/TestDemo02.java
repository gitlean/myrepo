package com.edu.sdu;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class TestDemo02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String namespaceUrl = "http://sdu.edu.com/";  

		URL url = new URL("http://localhost:8888/ws01?wsdl");        //?????????????????

		// 使用namespaceURL和服务名创建QName
		//浏览器打开 http://localhost:8888/ws01?wsdl    有下面代码
		// <definitions ... targetNamespace="http://ws01.yzl.com/"
		// name="MyServiceImplService">
		// <service name="MyServiceImplService">
		
		QName qname = new QName(namespaceUrl, "MyServiceImplService");

		// 创建服务
		Service service = Service.create(url, qname);

		// 服务器和客户端在同一机器时可以直接用服务的接口类,不在同一机器的具体用法见后面的章节
		IMyService client = service.getPort(IMyService.class);
		
		client.testException();
	}

}
