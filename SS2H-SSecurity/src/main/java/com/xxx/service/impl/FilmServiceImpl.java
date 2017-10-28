package com.xxx.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.xxx.dao.FilmDao;
import com.xxx.entity.Film;
import com.xxx.service.FilmService;
import com.xxx.system.MonitorLogForService;

/**
 * 影片信息业务逻辑接口实现类
 * 
 * @author HotStrong
 * 
 */
public class FilmServiceImpl implements FilmService {
	private static Logger logger=LoggerFactory.getLogger(FilmServiceImpl.class);

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
	@MonitorLogForService
	public void insertFilm(Film film) {
		filmDao.insertFilm(film);
		
	}

	@MonitorLogForService
	public void deleteFilm(int filmId) {
		filmDao.deleteFilm(filmId);
		
	}

	@MonitorLogForService
	public void updateFilm(Film film) {
		filmDao.updateFilm(film);
		
	}

	@MonitorLogForService
	public Film getFilmById(int filmId) {
		return filmDao.getFilmById(filmId);
		
	}

	@MonitorLogForService
	public List<Film> getAllFilm() {

  
		return filmDao.getAllFilm();

	}

}