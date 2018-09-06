package com.isoft.vo;

import java.io.Serializable;

public class Film implements Serializable {

	private Long id;

	private String fname;

	public Film() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFname() {
		return this.fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	@Override
	public String toString() {
		return "[id=" + id + ",fname=" + fname + "]";

	}

}