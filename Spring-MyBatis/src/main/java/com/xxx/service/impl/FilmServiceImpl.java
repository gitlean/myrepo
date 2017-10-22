package com.xxx.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.xxx.dao.FilmMapper;
import com.xxx.pojo.Film;
import com.xxx.service.FilmService;

/**
 * 影片信息业务逻辑接口实现类
 * 
 * @author HotStrong
 * 
 */
public class FilmServiceImpl implements FilmService {

	// 注入影片Mapper
	@Autowired
	private FilmMapper mapper;

	public void insertFilm(Film film) {

		mapper.insertFilm(film);
	}

	public void deleteFilm(int filmId) {

		mapper.deleteFilm(filmId);
	}

	public void updateFilm(Film film) {

		mapper.updateFilm(film);
	}

	public Film getFilmById(int filmId) {

		return mapper.getFilmById(filmId);
	}

	public List<Film> getAllFilm() {

		return mapper.getAllFilm();

	}

}