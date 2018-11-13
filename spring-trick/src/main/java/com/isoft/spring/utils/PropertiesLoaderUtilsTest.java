package com.isoft.spring.utils;

import java.util.Properties;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import junit.framework.TestCase;

public class PropertiesLoaderUtilsTest extends TestCase {

	@Test
	public void testLoadPropertiesResource() throws Exception {
		Properties ret = PropertiesLoaderUtils.loadProperties(new ClassPathResource("test.properties"));
		assertEquals("value", ret.getProperty("key"));
		assertEquals("中文", ret.getProperty("key2"));
	}

	// 测试通过。当然，我们是非常不建议使用XML的方式来做配置的。
	@Test
	public void testLoadPropertiesResourceXml() throws Exception {
		Properties ret = PropertiesLoaderUtils.loadProperties(new ClassPathResource("test.xml"));
		assertEquals("value", ret.getProperty("key"));
		assertEquals("中文", ret.getProperty("key2"));
	}

	@Test
	public void testLoadPropertiesEncodedResource() throws Exception {
		//可以看到，只是在之前的ClassPathResource基础之上包装了UTF-8字符编码的EncodeResource
		Properties ret = PropertiesLoaderUtils
				.loadProperties(new EncodedResource(new ClassPathResource("test.properties"), "UTF-8"));
		assertEquals("value", ret.getProperty("key"));
		assertEquals("中文", ret.getProperty("key2"));
	}
	
	
	
	@Test
	public void testFillPropertiesPropertiesResource() throws Exception {
	    Resource res = new ClassPathResource("test.properties");
	    Properties ret = new Properties();
	    //fillProperties方法其实是loadProperties方法的真正调用方法
	    PropertiesLoaderUtils.fillProperties(ret, res);
	    assertEquals("value", ret.getProperty("key"));
	}


	
	

}
