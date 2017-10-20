package com.xxx.dao;

import java.util.List;
import java.util.Map;
import com.xxx.pojo.Film;

/**
 * ��Ӱ��Ϣ���ݷ��ʽӿ�
 */
public interface FilmMapper {

	/**
	 * ���ܣ���ѯ���е�Ӱ
	 * 
	 * @return
	 */
	public List<Film> getAllFilm();

	/**
	 * ���ܣ�����Ż�ȡ��Ӱ
	 * 
	 * @return
	 */
	public Film getFilmById(int id);

	/**
	 * ���ܣ���ѯ������
	 * 
	 * @param params
	 * @return
	 */
	public List<Film> getAllFilmOrder(Map<String, Object> params);

	/**
	 * ���ܣ����ӰƬ
	 * 
	 * @param film
	 */
	public void insertFilm(Film film);

	/**
	 * ���ܣ��޸�ӰƬ
	 * 
	 * @param film
	 */
	public void updateFilm(Film film);

	/**
	 * ���ܣ�ɾ��ӰƬ
	 * 
	 * @param id
	 */
	public void deleteFilm(int id);

}