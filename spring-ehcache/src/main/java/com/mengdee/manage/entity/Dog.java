package com.mengdee.manage.entity;

public class Dog {
	private long serialno;
	private String nickname;
	private short age;

	public Dog() {

	}

	public Dog(long serialno, String nickname, short age) {
		this.serialno = serialno;
		this.nickname = nickname;
		this.age = age;
	}

	public long getSerialno() {
		return serialno;
	}

	public String getNickname() {
		return nickname;
	}

	public short getAge() {
		return age;
	}

	public void setSerialno(long serialno) {
		this.serialno = serialno;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setAge(short age) {
		this.age = age;
	}

	public String toString() {
		return "[serialno=" + serialno + ",nickname=" + nickname + ",age=" + age + "]";
	}

}
