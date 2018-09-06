package com.isoft.dao.imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.isoft.dao.FilmDao;
import com.isoft.repository.UserRepository;
import com.isoft.vo.Film;
import com.isoft.vo.UserInfo;

import javassist.bytecode.Descriptor.Iterator;

@Component
public class FilmDaoImp implements FilmDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	@Qualifier("secondJdbcTemplate")
	JdbcTemplate jdbcTemplate2;

	
	@Autowired 
	private UserRepository repository;
	
	@Override
	public List<Film> query() {
		// TODO Auto-generated method stub
		String sql2 = "select * from t_userinfo";
		List<UserInfo> list = jdbcTemplate2.query(sql2, new RowMapper<UserInfo>() {

			@Override
			public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				UserInfo user = new UserInfo();
				user.setUserId(rs.getInt("userinfo_id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));

				return user;
			}

		});

		System.out.println(list);
		/////////////////////////////////////////////
		System.out.println("------------------");
		List<UserInfo> list2=repository.findAll();
		System.out.println(list2);
		

		String sql = "select * from film";
		return jdbcTemplate.query(sql, new RowMapper<Film>() {

			@Override
			public Film mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Film film = new Film();
				film.setId(rs.getLong("id"));
				film.setFname(rs.getString("fname"));
				return film;
			}

		});
	}

}
