package com.edu.sdu;

import java.net.*;

import javax.jws.WebService;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

/**
 * 
 * helloword项目:测试环境跟服务器环境在同一机器同一项目内使用,服务在其他机器上则在后续介绍
 * 
 * @author Administrator
 * 
 *         先启动服务端RunService
 * 
 */

public class TestDemo {
	public static void main(String[] args) throws Exception {

		// 注意MyServiceImpl中的
		// @WebService(endpointInterface="cn.edu.sdu.IMyService") 一致

		/**
		 * 如果不想用默认的命名空间(包反转)，可以通过如下方法修改
		 * 
		 * @WebService(targetNamespace="http://com.ws.test") 在声明 服务的时候
		 */

		String namespaceUrl = "http://sdu.edu.com/";

		URL url = new URL("http://localhost:8888/ws01?wsdl"); // ?????????????????

		// 使用namespaceURL和服务名创建QName
		// 浏览器打开 http://localhost:8888/ws01?wsdl 有下面代码
		// <definitions ... targetNamespace="http://ws01.yzl.com/"
		// name="MyServiceImplService">
		// <service name="MyServiceImplService">

		QName qname = new QName(namespaceUrl, "MyServiceImplService");

		// 创建服务
		Service service = Service.create(url, qname);

		// 服务器和客户端在同一机器时可以直接用服务的接口类,不在同一机器的具体用法见后面的章节
		IMyService client = service.getPort(IMyService.class);

		System.out.println(client.add(10, 20));
		System.out.println(client.login("test", "123456"));
		System.out.println(client.login("test", "111111"));
	}

}
