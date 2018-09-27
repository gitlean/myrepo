package com.isoft.rs.entity;
import java.util.List;

import javax.ws.rs.PathParam;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * 
 * UserBean.java
 *
 * @title User的传输数据类
 * @description
 * @author SAM-SHO 
 * @Date 2014-11-25
 */

@XmlRootElement(name = "USER")
public class UserBean {
	
	private String name;
	
	private String age;
	
	private UserAddress userAddress;//地址
	
	private List<UserPhone> phoneList ;//手机
	
	public UserBean(){
		
	}
	
	public UserBean(String name){
		this.name=name;
	}
	public UserBean(String name,String age,UserAddress userAddress,List<UserPhone> phoneList){
		this.name=name;
		this.age=age;
		this.userAddress=userAddress;
		this.phoneList=phoneList;
	}
	
	

	@XmlElement(name="NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement(name = "AGE")
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@XmlElement(name = "UserAddress")
	public UserAddress getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(UserAddress userAddress) {
		this.userAddress = userAddress;
	}

	@XmlElementWrapper(name = "PhoneList")
	@XmlElement(name = "UserPhone")
	public List<UserPhone> getPhoneList() {
		return phoneList;
	}

	public void setPhoneList(List<UserPhone> phoneList) {
		this.phoneList = phoneList;
	}
	
}
