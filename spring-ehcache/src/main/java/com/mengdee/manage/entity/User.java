package com.mengdee.manage.entity;

public class User {
	private String id;
	private String name;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String id, String name) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

}
