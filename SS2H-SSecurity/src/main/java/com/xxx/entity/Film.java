package com.xxx.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "FILM")  //mapping
@Table(name = "FILM")  //对应的表
public class Film implements Serializable{

	// Fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "FNAME")
	private String fname;

	// Constructors
	/** default constructor */
	public Film() {
	}

	// Property accessors
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
	public String toString(){
		return "[id="+id+",fname="+fname+"]";
		
	}

}