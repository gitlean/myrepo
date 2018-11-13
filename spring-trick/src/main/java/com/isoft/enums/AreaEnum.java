package com.isoft.enums;

public enum AreaEnum implements Paired {
	beijing("北京", "110100"), shanghai("上海", "310100"), tianjin("天津", "120100"), chongqing("重庆", "500100 ");

	final String name;
	final String code;

	AreaEnum(String name, String code) { // 注意顺序
		this.name = name;
		this.code = code;

	}

}
