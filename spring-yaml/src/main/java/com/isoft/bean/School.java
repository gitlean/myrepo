package com.isoft.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
*@author john
*@createTime 2019年9月3日 上午10:58:51
*@describe 
*/
@Component
public class School {
	@Value("${env.school.sname}")
	private String name;
	
	@Value("${env.school.code}")
	private String code;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
	public String toString(){
		return "{name="+this.name+",code="+this.code+"}";
	}
	
	
	
	
}
