package com.isoft.service.imp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isoft.dao.IMDao;
import com.isoft.entity.Film;
import com.isoft.service.IMyService;

@Service
public class MyServiceImp implements IMyService {

	@Autowired
	IMDao dao;
	
	public List<Film> queryList() {
		// TODO Auto-generated method stub
		return dao.queryList();
	}

	public Film getFilmById(int id) {
		// TODO Auto-generated method stub
		return dao.getFilmById(id);
	}

	public List<Film> getAllFilmOrder(Map map) {
		// TODO Auto-generated method stub
		return dao.getAllFilmOrder(map);
	}

	public void insertFilm(Film film) {
		// TODO Auto-generated method stub
		int result=dao.insertFilm(film);
		System.out.println("-----------"+result+"------------");
		
	}

	public void updateFilm(Film film) {
		// TODO Auto-generated method stub
		int result=dao.updateFilm(film);
		System.out.println("-----------"+result+"------------");
		
	}

}
