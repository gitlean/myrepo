package com.service.rest;

import java.io.Serializable;

public class RequestModel  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1623013650919986290L;
	String username;
	String password;
	
	
	public RequestModel() {
		super();
	}
	
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
	
	@Override
	public String toString() {
		return "RequestModel [username=" + username + ", password=" + password
				+ "]";
	}
	
}
