package com.xxx.dao;

import java.util.List;
import java.util.Map;
import com.xxx.pojo.Film;

/**
 * 电影信息数据访问接口
 */
public interface FilmMapper {

	/**
	 * 功能：查询所有电影
	 * 
	 * @return
	 */
	public List<Film> getAllFilm();

	/**
	 * 功能：按编号获取电影
	 * 
	 * @return
	 */
	public Film getFilmById(int id);

	/**
	 * 功能：查询并排序
	 * 
	 * @param params
	 * @return
	 */
	public List<Film> getAllFilmOrder(Map<String, Object> params);

	/**
	 * 功能：添加影片
	 * 
	 * @param film
	 */
	public void insertFilm(Film film);

	/**
	 * 功能：修改影片
	 * 
	 * @param film
	 */
	public void updateFilm(Film film);

	/**
	 * 功能：删除影片
	 * 
	 * @param id
	 */
	public void deleteFilm(int id);

}