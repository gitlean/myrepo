package com.xxx.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.xxx.dao.FilmMapper;
import com.xxx.pojo.Film;
import com.xxx.service.FilmService;

/**
 * ӰƬ��Ϣҵ���߼��ӿ�ʵ����
 * 
 * @author HotStrong
 * 
 */
public class FilmServiceImpl implements FilmService {

	// ע��ӰƬMapper
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