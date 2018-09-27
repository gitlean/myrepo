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

public class ClientRest2 {

	private WebClient webBlient = null;

	public WebClient getWebBlient() {
		return webBlient;
	}

	public void setWebBlient(WebClient webBlient) {
		this.webBlient = webBlient;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClientRest2 client = new ClientRest2();
		// 初始化WebClient
		client.init();
		WebClient wsc = client.getWebBlient();

		// 发送String 测试服务端的简单方法
		// String tResponseMsg =
		// wsc.path("surpolicy/sendString/{input}","我来ping一下。。").accept(MediaType.TEXT_PLAIN).get(String.class);
		// System.out.println(tResponseMsg);

		// 发送XML报文
		// String tRequestXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"
		// standalone=\"yes\"?><USER><AGE>27</AGE><NAME>SAM-SHO</NAME><PhoneList><UserPhone><num>13612345678</num><type>移动</type></UserPhone><UserPhone><num>13798765432</num><type>联通</type></UserPhone></PhoneList><UserAddress><homeAddress>苏州高新区</homeAddress><workAddress>苏州园区</workAddress></UserAddress></USER>";
		// String tResponseMsg2 =
		// wsc.path("surpolicy/sendXml").accept(MediaType.APPLICATION_XML).post(tRequestXml,
		// String.class);
		// System.out.println("返回的信息： \r\n" + tResponseMsg2);

		// 发送Bean
		UserBean tUserBean = new UserBean();
		tUserBean.setName("SAM-SHO");
		tUserBean.setAge("27");

		UserAddress tUserAddress = new UserAddress();
		tUserAddress.setWorkAddress("苏州园区");
		tUserAddress.setHomeAddress("苏州高新区");
		tUserBean.setUserAddress(tUserAddress);

		List<UserPhone> phoneList = new ArrayList<UserPhone>();
		UserPhone tUserPhone = new UserPhone();
		tUserPhone.setType("移动");
		tUserPhone.setNum("13612345678");
		phoneList.add(tUserPhone);

		tUserPhone = new UserPhone();
		tUserPhone.setType("联通");
		tUserPhone.setNum("13798765432");
		phoneList.add(tUserPhone);
		tUserBean.setPhoneList(phoneList);

//		ReturnDTO tReturnDTO = wsc.path("surpolicy/sendBean").accept(MediaType.APPLICATION_XML).acceptEncoding("utf-8")
//				.post(tUserBean, ReturnDTO.class);
//		System.out.println("返回的数据：" + tReturnDTO.getMsg());
//		System.out.println(tReturnDTO);
		
		
		String returnStr=wsc.path("surpolicy/sendBean2").accept(MediaType.APPLICATION_XML).acceptEncoding("utf-8").post(tUserBean,
				String.class);
		System.out.println(returnStr);

	}

	public void init() {

		// WebClient 可以使用spring注入，也可以手工创建：

		// 1、 手动创建webClient对象，注意这里的地址是发布的那个/rest地址
		// String url = "http://localhost:8080/cxfSpringDemo3/ws/rest/";
		// webBlient = WebClient.create(url);

		// 2、 从Spring Ioc容器中拿webClient对象，或者直接用注入
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-client.xml");
		webBlient = ctx.getBean("webClient", WebClient.class);

		if (null != webBlient) {
			System.out.println("create webBlient success... ");

		} else {
			System.out.println("create webBlient fail... ");
		}
	}

}
