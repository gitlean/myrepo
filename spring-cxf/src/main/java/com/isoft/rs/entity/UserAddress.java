package com.isoft.rs.entity;

import javax.xml.bind.annotation.XmlElement;

public class UserAddress {
	
	private String homeAddress;//家庭地址
	private String workAddress;//公司地址
	
	@XmlElement(name = "HomeAddress")
	public String getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	@XmlElement(name = "WorkAddress")
	public String getWorkAddress() {
		return workAddress;
	}
	public void setWorkAddress(String workAddress) {
		this.workAddress = workAddress;
	}

}