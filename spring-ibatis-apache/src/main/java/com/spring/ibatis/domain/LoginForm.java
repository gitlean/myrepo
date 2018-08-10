package com.spring.ibatis.domain;
 
public class LoginForm {
	private long userId;
	
	public long getUserId() {
		return userId;
	}
 
	public void setUserId(long userId) {
		this.userId = userId;
	}
 
	private String username;
	
	private String password;
	
	private String groupname;
 
	public String getUsername() {
		return username;
	}
 
	public void setUsername(String username) {
		this.username = username;
	}
 
	public String getPassword() {
		return password;
	}
 
	public void setPassword(String password) {
		this.password = password;
	}
 
	public String getGroupname() {
		return groupname;
	}
 
	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}
}