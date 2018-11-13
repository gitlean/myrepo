package com.isoft.enums;

import java.lang.reflect.Field;

import org.springframework.util.ReflectionUtils;

public interface Name {
	String DEFAULT_FIELD = "name"; // enum众有一个field ---name

	default String getName() {
		Field field = ReflectionUtils.findField(getClass(), DEFAULT_FIELD);
		if (null == field) {
			throw new RuntimeException("enum must have default field name");
		}
		field.setAccessible(true); //暴力访问(忽略掉访问修饰符)

		try {
			return field.get(this).toString();
		} catch (IllegalAccessException e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}

}
