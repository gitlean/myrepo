package com.isoft.service;

import java.util.List;
import java.util.Map;

import com.isoft.entity.Film;

public interface IMyService {
	public  List<Film> queryList();
	public Film getFilmById(int id);
	public  List<Film> getAllFilmOrder(Map map);
	public void insertFilm(Film film);
	public void  updateFilm(Film film);
}
