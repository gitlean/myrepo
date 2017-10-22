package com.xxx.test;

import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xxx.dao.FilmDao;
import com.xxx.entity.Film;

public class MainApp {

	// private Logger logger = LoggerFactory.getLogger(MainApp.class);

	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(MainApp.class);

		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 获取影片业务逻辑对象
		FilmDao dao = (FilmDao) context.getBean("filmDao");

		logger.info("Hello");
		List<Film> list = dao.getAllFilm();

		Iterator iter = list.iterator();
		while (iter.hasNext()) {
			Film film = (Film) iter.next();
			System.out.println(film);

		}

		// int id=1;
		// System.out.println(dao.getFilmById(id));

		// Film film=new Film();
		// film.setFname("鹰击长空");
		// dao.insertFilm(film);

		// dao.deleteFilm(10);

		// Film film = new Film();
		// film.setId(9l);
		// film.setFname("火烧圆明园");
		// dao.updateFilm(film);

	}

}
