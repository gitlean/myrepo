package com.isoft.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isoft.dao.FilmDao;
import com.isoft.services.FilmService;
import com.isoft.vo.Film;

@Service
public class FilmServiceImp implements FilmService {

	@Autowired
	private FilmDao dao;
	
	@Override
	public List<Film> query() {
		// TODO Auto-generated method stub
		return dao.query();
	}

}
