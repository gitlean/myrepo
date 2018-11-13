package com.isoft.Introspector;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;


/**
 * @Name: MyBeanUtilsTest
 * @Description: JavaBean属性操作工具测试类
 * @Author: XXX
 * @CreateDate: XXX
 * @Version: V1.0
 */
public class MyBeanUtilsTest {

	private User user;

	@Before
	public void init() {
		user = new User();
		user.setName("张三");
		user.setAge(21);
		user.setGender(true);
		user.setBirthday(new Date());
		user.setAddress("北京丰台");
	}

	@Test
	public void testSetPropertyValue() {
		System.out.println(user);
		// 设置String类型数据
		MyBeanUtils.setProperty(user, "name", "李思思");
		// 设置int类型数据
		MyBeanUtils.setProperty(user, "age", 23);
		// 设置boolean类型数据
		MyBeanUtils.setProperty(user, "gender", false);
		// 设置Date类型数据
		MyBeanUtils.setProperty(user, "birthday", new Date(13213412412L));
		System.out.println(user);
	}

	@Test
	public void testGetPropertyValue() {
		// 获取String类型属性
		String name = (String) MyBeanUtils.getPropertyValue("name", user);
		// 获取int类型属性
		int age = (int) MyBeanUtils.getPropertyValue("age", user);
		// 获取boolean类型属性
		boolean gender = (boolean) MyBeanUtils.getPropertyValue("gender", user);
		// 获取Date类型属性
		Date birthday = (Date) MyBeanUtils.getPropertyValue("birthday", user);
		System.out.println(name + "," + age + "," + gender + "," + birthday + ".");
	}

	@Test
	public void testPopulate() {
		// 向Map集合中封装数据，适用于request.getParameterMap() ;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "王五");
		map.put("age", 21);
		map.put("gender", true);
		map.put("birthday", new Date(32131412L));
		
		String[] hobbies = { "打球", "唱歌" };
		map.put("hobbies", hobbies);
		
		// 将Map集合中的数据封装到UserBean
		User u = (User) MyBeanUtils.populate(new User(), map);
		System.out.println(u);
	}
}
