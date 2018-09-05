package com.isoft.dao.imp;

import java.util.List;

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

}
