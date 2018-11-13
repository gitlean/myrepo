package com.isoft.enums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.isoft.reflection.MyClassUtil;

public interface Paired extends Code, Name {
	static final String ENUM_PATCH = "com.isoft.enums";
	
	
	Map<String, Paired> CODE_NAME = new HashMap<String, Paired>() {
		{
			Set<Class<?>> classes = MyClassUtil.implementingClassOf(Paired.class, ENUM_PATCH);
			for (Class<?> clazz : classes) {
				if (clazz.isEnum()) {
					Arrays.asList(clazz.getEnumConstants()).stream().forEach(e -> {
						Paired paired = (Paired) e;
						put(paired.getCode(), paired);
					});
				}
			}
		}
	};
	
	
	

	static Paired getEnum(String code) {
		return CODE_NAME.get(code);
	}

}
