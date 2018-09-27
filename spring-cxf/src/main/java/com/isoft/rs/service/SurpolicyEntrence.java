package com.isoft.rs.service;

import javax.ws.rs.BeanParam;
/**
 * 
 * GET
 * 访问地址：http://localhost:8080/cxfSpringDemo3/ws/rest/surpolicy/sendString/queryParams_aa
 */
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.isoft.rs.DTO.ReturnDTO;
import com.isoft.rs.entity.UserBean;
import com.isoft.rs.util.ObjectAndXmlHandle;

//最好给服务定义成interface

@Path(value = "/surpolicy")
public class SurpolicyEntrence {

	/**
	 * 简单服务方法
	 * 
	 * @param input
	 *            访问地址：http://localhost:8080/cxfSpringDemo3/ws/rest/surpolicy/sendString/queryParams_aa
	 * @return
	 */
	@GET
	@Path("/sendString/{input}")
	@Produces(MediaType.TEXT_PLAIN)
	public String sendStringParam(@PathParam("input") String input) {
		System.out.println("接收的参数： \r\n" + input);
		// String tReturn = "成功返回";
		String tReturn = "success";
		return tReturn;

	}

	@POST
	@Path("/sendStringPost")
	@Produces(MediaType.TEXT_PLAIN)
	public String sendStringParamPost(String input) {
		System.out.println("接收的参数： \r\n" + input);
		// String tReturn = "成功返回";
		String tReturn = "success Post";
		return tReturn;

	}

	/**
	 * 接受XML ，推荐使用。
	 * 地址：http://localhost:8080/cxfSpringDemo3/ws/rest/surpolicy/sendXml 设置
	 * Content-Type: APPLICATION/XML(可以不设) body 中设置 xml内容
	 */
	@POST
	@Path("/sendXml")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public String sendXml(String requestXML) {
		System.out.println("接收的参数：\r\n " + requestXML);

		UserBean tUserBean = ObjectAndXmlHandle.parseXml2OUserBean(requestXML);

		String tReturn = tUserBean.getName() + " 你好，你的请求成功返回";
		return tReturn;
	}

	/**
	 * 接收Bean
	 * 
	 * @param user
	 *            http://localhost:8080/cxfSpringDemo3/ws/rest/surpolicy/sendBean
	 *            需要设置 Content-Type: application/xml body 中设置 xml内容
	 * @return
	 */
	@POST
	@Path("/sendBean")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	// @Produces(MediaType.APPLICATION_JSON)
	public ReturnDTO sendBean(@BeanParam UserBean user) { // 使用RestTemplate请求；json转Userbean有点问题！！

		// 转成报文
		// ObjectAndXmlHandle.Object2Xml(user);
		System.out.println("name=" + user.getName() + ",age=" + user.getAge());

		ReturnDTO tReturnDTO = new ReturnDTO();
		tReturnDTO.setCode("1");
		tReturnDTO.setMsg(user.getName() + " ,请求成功，已返回");

		return tReturnDTO;
	}

	// @Produces用于定义方法的响应实体的数据类型，可以定义一个或多个
	@POST
	@Path("/sendBean2")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public String sendBean2(@BeanParam UserBean user) {

		// 转成报文
		// ObjectAndXmlHandle.Object2Xml(user);
		System.out.println(user.getUserAddress().getHomeAddress());

		return "sendBean2 get msg";
	}

}
