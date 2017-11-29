package com.isoft.springtransaction.annotationjt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("studentDao")
public class StudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	
	
	
	public Student getStudentById(int id) {
		
		
		return jdbcTemplate.queryForObject("select * from tbl_student where id = ?", new Object[] { id },
				new StudentRowMapper());//RowMapper常采用匿名内部类
		
	}

	public List<Student> getAllStudent() {
		return jdbcTemplate.query("select * from tbl_student", new StudentRowMapper());
	}

	public int insertStudent(Student student) {
		return jdbcTemplate.update("insert into tbl_student(name,birth,score) values(?,?,?)",
				new Object[] { student.getName(), student.getBirth(), student.getScore() });
	}

	public int deleteStudent(int id) {
		return jdbcTemplate.update("delete from tbl_student where id = ? ", new Object[] { id });
	}

	public int updateStudent(Student student) {
		return jdbcTemplate.update(" update tbl_student set name=?,birth=?,score=? where id=? ",
				new Object[] { student.getName(), student.getBirth(), student.getScore(), student.getId() });
	}
}
