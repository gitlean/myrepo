package com.isoft.vo;

import java.io.Serializable;

public class User implements Serializable{
	public String getNickname() {
		return nickname;
	}
	public String getNation() {
		return nation;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	private String nickname;
	private String nation;

}
