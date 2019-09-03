package com.isoft.bean;
/**
*@author john
*@createTime 2019年9月3日 上午10:36:06
*@describe 
*/
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:default.properties")
public class Person {
	@Value("${secs.prod.name}")
	private String name;
	
	@Value("${secs.prod.age}")
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	
	public String toString(){
		return "{name="+this.name+",age="+this.age+"}";
	}
}
