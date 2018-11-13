package com.isoft.enums;

import java.lang.reflect.Field;

import org.springframework.util.ReflectionUtils;

public interface Code {
	String DEFAULT_FIELD = "code"; // enum众有一个field ---code

	default String getCode() {
		Field field = ReflectionUtils.findField(getClass(), DEFAULT_FIELD);
		if (null == field) {
			throw new RuntimeException("enum must have default field code");
		}
		field.setAccessible(true);

		try {
			return field.get(this).toString();
		} catch (IllegalAccessException e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
}
