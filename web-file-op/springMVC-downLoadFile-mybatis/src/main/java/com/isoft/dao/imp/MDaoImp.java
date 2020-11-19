package com.isoft.dao.imp;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.isoft.dao.IMDao;
import com.isoft.entity.Film;

@Repository
public class MDaoImp implements IMDao {

    @Autowired
    SqlSessionTemplate sqlSession;
    
	public List<Film> queryList() {
		// TODO Auto-generated method stub
		List<Film> list=sqlSession.selectList("com.isoft.entity.Film.getAllFilm");
		return list;
	}

	public Film getFilmById(int id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("com.isoft.entity.Film.getFilmById", id);
	}

	public List<Film> getAllFilmOrder(Map map) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("com.isoft.entity.Film.getAllFilmOrder", map);
	}

	public int insertFilm(Film film) {
		// TODO Auto-generated method stub
		
		return sqlSession.insert("com.isoft.entity.Film.insertFilm", film);
		
	}

	
	public int updateFilm(Film film) {
		// TODO Auto-generated method stub
		return sqlSession.update("com.isoft.entity.Film.updateFilm", film);
		
	}
	
	
	

}
