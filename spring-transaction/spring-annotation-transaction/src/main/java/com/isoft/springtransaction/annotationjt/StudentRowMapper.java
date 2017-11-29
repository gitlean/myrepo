package com.isoft.springtransaction.annotationjt;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * 
 * @author john
 * @date   2017年11月28日
 * @description
 */
public class StudentRowMapper implements RowMapper<Student> {

	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Student student=new Student();
	
		student.setId(rs.getInt("id"));
		student.setName(rs.getString("name"));
		student.setBirth(rs.getDate("birth"));
		student.setScore(rs.getFloat("score"));
		
		
		return student;
	}

}
