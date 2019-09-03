package com.isoft.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author john
 * @createTime 2019年9月2日 上午11:18:50
 * @describe
 */
@ConfigurationProperties("user")
@Component
public class UserProperties {
	/**
	 * 名称
	 */
	private String userName;
	/**
	 * 性别
	 */
	private int gender;

	// getter & setter
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getUserName() {
		return userName;
	}

	public int getGender() {
		return gender;
	}
}
