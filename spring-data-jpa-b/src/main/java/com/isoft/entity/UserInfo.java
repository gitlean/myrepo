package com.isoft.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Author:ZhangJianPing Time:11-8-31 下午12:46
 */
@Entity
@Table(name = "t_userinfo")
public class UserInfo implements Serializable {
	
	
	private Integer userId;

	private String username;

	private String password;
	public UserInfo() {
    }
	
	@Id
	@Column(name="userinfo_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getUserId() { //属性要驼峰命名，否则会报错
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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
		return "UserInfo{" + "userId=" + userId + ", username='" + username + '\'' + '}';
	}
}
