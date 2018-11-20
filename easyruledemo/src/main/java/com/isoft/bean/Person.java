package com.isoft.bean;

public class Person {
	private String name;
	private int age;
	
	public Person(){
		
	}
	
	public Person(String name,int age){
		this.name=name;
		this.age=age;
	}
	
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
	
	
	public boolean isAdult(){
		return (18-this.age)>0?false:true;
	}

}
