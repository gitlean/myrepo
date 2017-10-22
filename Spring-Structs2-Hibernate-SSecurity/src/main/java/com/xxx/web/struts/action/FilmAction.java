package com.xxx.web.struts.action;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xxx.entity.Film;
import com.xxx.service.FilmService;

@SuppressWarnings("serial")
public class FilmAction extends ActionSupport implements ModelDriven<Film> {

	// 业务逻辑对象
	@Autowired
	private FilmService filmService;

	// 封装查询结果
	private List<Film> filmList;

	// 封装页面提交的表单数据
	private Film film = new Film();

	/**
	 * 获取所有的电影
	 * 
	 * @return
	 * @throws Exception
	 */
	public String findFilm() throws Exception {

		this.filmList = this.filmService.getAllFilm();
		return SUCCESS;
	}

	/**
	 * 根据影片ID获取影片信息
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
	 * 添加影片
	 * 
	 * @return
	 * @throws Exception
	 */
	public String insertFilm() throws Exception {

		this.filmService.insertFilm(film);
		return SUCCESS;
	}

	/**
	 * 修改影片
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updateFilm() throws Exception {

		this.filmService.updateFilm(film);
		return SUCCESS;
	}

	/**
	 * 删除影片
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