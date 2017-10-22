package com.xxx.service.impl;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import com.xxx.dao.FilmDao;
import com.xxx.entity.Film;
import com.xxx.service.FilmService;

/**
 * 影片信息业务逻辑接口实现类
 * 
 * @author HotStrong
 * 
 */
public class FilmServiceImpl implements FilmService {

	//Service层有一个DAO 实例
	//业务逻辑的CRUD应该交给 DAO来做
	//DAO也应该先定义出接口，再写实现类
	
	// 注入DAO
	@Autowired
	private FilmDao filmDao;

	public FilmDao getFilmDao() {
		return filmDao;
	}


	public void setFilmDao(FilmDao filmDao) {
		this.filmDao = filmDao;
	}


	//添加一部影片
	public void insertFilm(Film film) {
		filmDao.insertFilm(film);
		
	}

	
	public void deleteFilm(int filmId) {
		filmDao.deleteFilm(filmId);
		
	}

	public void updateFilm(Film film) {
		filmDao.updateFilm(film);
		
	}

	public Film getFilmById(int filmId) {
		return filmDao.getFilmById(filmId);
		
	}

	public List<Film> getAllFilm() {

		return filmDao.getAllFilm();

	}

}