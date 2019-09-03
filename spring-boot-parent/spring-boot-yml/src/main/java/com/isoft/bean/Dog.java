package com.isoft.bean;
/**
*@author john
*@createTime 2019年8月30日 下午5:07:44
*@describe 
*/
public class Dog {
	private String name;
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
		return "Dog{name="+this.name+","+"age="+age+"}";
	}

}
