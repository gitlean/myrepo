package com.xxx.web.struts.action;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xxx.pojo.Film;
import com.xxx.service.FilmService;

@SuppressWarnings("serial")
public class FilmAction extends ActionSupport implements ModelDriven<Film> {

	// ҵ���߼�����
	@Autowired
	private FilmService filmService;

	// ��װ��ѯ���
	private List<Film> filmList;

	// ��װҳ���ύ�ı�����
	private Film film = new Film();

	/**
	 * ��ȡ���еĵ�Ӱ
	 * 
	 * @return
	 * @throws Exception
	 */
	public String findFilm() throws Exception {

		this.filmList = this.filmService.getAllFilm();
		return SUCCESS;
	}

	/**
	 * ����ӰƬID��ȡӰƬ��Ϣ
	 * 
	 * @return
	 * @throws Exception
	 */
	public String detailFilm() throws Exception {

		int id = film.getId().intValue();
		Film film = this.filmService.getFilmById(id);
		this.film.setFname(film.getFname());
		return SUCCESS;
	}

	/**
	 * ���ӰƬ
	 * 
	 * @return
	 * @throws Exception
	 */
	public String insertFilm() throws Exception {

		this.filmService.insertFilm(film);
		return SUCCESS;
	}

	/**
	 * �޸�ӰƬ
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updateFilm() throws Exception {

		this.filmService.updateFilm(film);
		return SUCCESS;
	}

	/**
	 * ɾ��ӰƬ
	 * 
	 * @return
	 * @throws Exception
	 */
	public String deleteFilm() throws Exception {

		int id = film.getId().intValue();
		this.filmService.deleteFilm(id);
		return SUCCESS;
	}

	public Film getModel() {
		return film;
	}

	public List<Film> getFilmList() {
		return filmList;
	}

	public void setFilmList(List<Film> filmList) {
		this.filmList = filmList;
	}

}