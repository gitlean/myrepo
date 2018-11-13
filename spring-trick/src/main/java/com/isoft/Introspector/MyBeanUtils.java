package com.isoft.Introspector;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @Name: MyBeanUtils
 * @Description: JavaBean属性操作工具类
 * @Author: XXX
 * @CreateDate: 2017-3-9 上午10:40:01
 * @Version: V1.0
 */
public class MyBeanUtils {

	/**
	 * @Name: getPropertyValue
	 * @Description: 根据指定的属性名称获取属性值
	 * @Author: XXX
	 * @Version: V1.0
	 * @CreateDate: 2017-3-9 上午10:55:17
	 * @Parameters: @param propertyName 属性名称
	 * @Parameters: @param bean bean实例对象
	 * @Return: Object 返回getter方法的返回值，即属性值
	 */
	public static Object getPropertyValue(String propertyName, Object bean) {
		Object propertyValue = null;
		try {
			PropertyDescriptor pd = new PropertyDescriptor(propertyName, bean.getClass());
			Method method = pd.getReadMethod();
			propertyValue = method.invoke(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return propertyValue;
	}

	/**
	 * @Name: setProperty
	 * @Description: 设置/修改属性的内容
	 * @Author: XXX
	 * @Version: V1.0
	 * @CreateDate: 2017-3-9 上午11:01:23
	 * @Parameters: @param bean Bean实例对象
	 * @Parameters: @param name 属性名
	 * @Parameters: @param value 修改内容
	 * @Return: void 无
	 */
	public static void setProperty(Object bean, String name, Object value) {
		try {
			PropertyDescriptor pd = new PropertyDescriptor(name, bean.getClass());
			Method method = pd.getWriteMethod();
			method.invoke(bean, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @Name: populate
	 * @Description: 将Map中的内容封装到JavaBean 说明： Map中的key必须与JavaBean中的属性名称相同
	 *               Map中的value传递给JavaBean对应的属性
	 * @Author: XXX
	 * @Version: V1.0
	 * @CreateDate: XXX
	 * @Parameters: @param bean
	 * @Parameters: @param map
	 * @Return: void
	 */
	public static Object populate(Object bean, Map<String, Object> map) {
		if (map != null && map.size() > 0) {
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				String propertyName = entry.getKey();
				Object propertyValue = entry.getValue();
				try {
					PropertyDescriptor pd = new PropertyDescriptor(propertyName, bean.getClass());
					Method method = pd.getWriteMethod();
					method.invoke(bean, propertyValue);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		}
		return bean;
	}
}
