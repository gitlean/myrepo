package com.isoft.dao;

import java.util.List;
import java.util.Map;

import com.isoft.entity.Film;

public interface IMDao {
	public List<Film> queryList();
	public Film getFilmById(int id);
	public List<Film> getAllFilmOrder(Map map);
	public int insertFilm(Film film);
	public int updateFilm(Film film);

}
