package com.xxx.service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import com.xxx.pojo.Film;

/**
 * ӰƬ��Ϣҵ���߼��ӿ�
 * 
 * @author HotStrong
 * 
 */
public interface FilmService {

	/**
	 * ���һ��ӰƬ
	 * 
	 * @param film
	 */
	@Transactional
	public void insertFilm(Film film);

	/**
	 * �޸�һ��ӰƬ����Ϣ
	 * 
	 * @param film
	 */
	@Transactional
	public void updateFilm(Film film);

	/**
	 * ͨ��ӰƬ���ɾ��һ��ӰƬ
	 * 
	 * @param filmId
	 */
	@Transactional
	public void deleteFilm(int filmId);

	/**
	 * ͨ��ӰƬ��Ż�ȡһ��ӰƬ
	 * 
	 * @param filmId
	 * @return
	 */
	public Film getFilmById(int filmId);

	/**
	 * ��ȡ���е�ӰƬ
	 * 
	 * @return
	 */
	public List<Film> getAllFilm();

}