package com.isoft.dao.imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.isoft.dao.FilmDao;
import com.isoft.vo.Film;

@Component
public class FilmDaoImp implements FilmDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Film> query() {
		// TODO Auto-generated method stub
		
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
