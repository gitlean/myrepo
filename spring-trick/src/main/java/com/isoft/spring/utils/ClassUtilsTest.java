package com.isoft.spring.utils;

import org.junit.Test;
import org.springframework.util.ClassUtils;

import junit.framework.TestCase;
/**
 * https://www.jianshu.com/p/83cbbd0b8b10
 * @author john
 * @date 2018年10月20日
 * @time 上午10:20:47
 * @describe:
 */
public class ClassUtilsTest extends TestCase {
	@Test
	public void testClassLoader() {
		System.out.println(Thread.currentThread().getContextClassLoader());
		System.out.println(this.getClass().getClassLoader());
		System.out.println(ClassLoader.getSystemClassLoader());
		System.out.println(ClassLoader.getSystemClassLoader().getParent());
	}

	@Test
	public void testClassforName() throws Exception {
		System.out.println(ClassUtils.forName("int", ClassUtils.getDefaultClassLoader()));
		System.out.println(ClassUtils.forName("java.lang.String[]", ClassUtils.getDefaultClassLoader()));
		System.out.println(ClassUtils.forName("java.lang.Thread.State", ClassUtils.getDefaultClassLoader()));
	
		
	}
	
	
	
	
	
	
	

}
