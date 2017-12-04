package com.isoft.rs.util;

import java.io.StringReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.xml.sax.InputSource;

import com.isoft.rs.entity.UserBean;


/**
 * 
 * ObjectAndXmlHandle.java
 *
 * @title jaxb处理xml解析
 * @description
 * @author SAM-SHO 
 * @Date 2014-11-25
 */
public class ObjectAndXmlHandle {
	
	public static UserBean parseXml2OUserBean(String xml) {
		try {
			JAXBContext context = JAXBContext.newInstance(UserBean.class);
			InputSource is = new InputSource();
			StringReader xmlStr = new StringReader(xml);
			is.setCharacterStream(xmlStr);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			UserBean user = (UserBean) unmarshaller.unmarshal(is);
			return user;
		} catch (JAXBException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void Object2Xml(Object object) {
//		FileWriter writer = null;  		
	    try {  
	    	JAXBContext context = JAXBContext.newInstance(object.getClass());
	        Marshaller marshal = context.createMarshaller();  
	        marshal.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  
	        marshal.setProperty("jaxb.encoding", "utf-8");
	        marshal.marshal(object, System.out);  
	          
//	        writer = new FileWriter("shop.xml");  
//	        marshal.marshal(object, writer);  
	    } catch (Exception e) {  
	        e.printStackTrace();  
	    } 	
	}
}
