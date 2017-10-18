package cn.isoft.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "USER")  //mapping
@Table(name = "TB_USER")  //对应的表
public class User implements Serializable {
	@Id
	@Column(name = "ID")
	private int uid;

	@Column(name = "NAME")
	private String uname;

	@Column(name = "AGE")
	private int age;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[id:"+uid+",name:"+uname+",age:"+age+"]";
	}
	
	
}
