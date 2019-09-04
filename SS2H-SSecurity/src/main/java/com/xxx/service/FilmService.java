package com.xxx.service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;

import com.xxx.entity.Film;

/**
 * 影片信息业务逻辑接口
 * 
 * @author HotStrong
 * 
 */
public interface FilmService {

	/**
	 * 添加一部影片
	 * 
	 * @param film
	 */
	@Transactional
	public void insertFilm(Film film);

	/**
	 * 修改一部影片的信息
	 * 
	 * @param film
	 */
	@Transactional
	public void updateFilm(Film film);

	/**
	 * 通过影片编号删除一部影片
	 * 
	 * @param filmId
	 */
	@Transactional
	public void deleteFilm(int filmId);

	/**
	 * 通过影片编号获取一部影片
	 * 
	 * @param filmId
	 * @return
	 */
	public Film getFilmById(int filmId);

	/**
	 * 获取所有的影片
	 * 
	 * @return
	 */
	public List<Film> getAllFilm();
	
	
	
	public void test();
	
	

}