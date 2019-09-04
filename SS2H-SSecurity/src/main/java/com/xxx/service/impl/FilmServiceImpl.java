package com.xxx.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxx.dao.FilmDao;
import com.xxx.entity.Film;
import com.xxx.service.FilmService;
import com.xxx.system.MonitorLogForService;

/**
 * 影片信息业务逻辑接口实现类
 * 
 * @author HotStrong
 * 
 */
@Service
public class FilmServiceImpl implements FilmService {
	private static Logger logger=LoggerFactory.getLogger(FilmServiceImpl.class);

	@Autowired
	FilmService self;
	
	
	
	//Service层有一个DAO 实例
	//业务逻辑的CRUD应该交给 DAO来做
	//DAO也应该先定义出接口，再写实现类
	
	// 注入DAO
	@Autowired
	private FilmDao filmDao;

	@Autowired
	private SchoolServiceImp schoolService;
	
	public FilmDao getFilmDao() {
		return filmDao;
	}


	public void setFilmDao(FilmDao filmDao) {
		this.filmDao = filmDao;
	}
	
	
	//添加一部影片
	@MonitorLogForService
	public void insertFilm(Film film) {
		filmDao.insertFilm(film);
		
	}

	@MonitorLogForService
	public void deleteFilm(int filmId) {
		filmDao.deleteFilm(filmId);
		
	}

	@MonitorLogForService
	public void updateFilm(Film film) {
		filmDao.updateFilm(film);
		
	}

	@MonitorLogForService
	public Film getFilmById(int filmId) {
		return filmDao.getFilmById(filmId);
		
	}

	@MonitorLogForService
	public List<Film> getAllFilm() {
		
		schoolService.saySth("Love"); //此处，  切面会被执行
		
		schoolService.saySth("Love");//再调一次，切面仍然会被执行
		
		
		test();    //此处test()切面不会被执行；因为test()和getAllFilm()在同一个类里
  
		//以上总结的切面会不会被执行规则，适用递归/嵌套
		//即，切面的执行要从另一个类的方法调用此类的方法，此时切面才会被执行，与代理的机制有关
		
		/**
		 * java同一个类的方法调用，不进AOP
			https://blog.csdn.net/gezilan/article/details/88821901
			https://blog.csdn.net/c764193441/article/details/79143522  important
			在同一个类中调用另一个方法没有触发 Spring AOP 的问题
			https://www.cnblogs.com/rainwang/p/7519719.html

		 */
		self.test();//此种方法解决java同一个类的方法调用，不进AOP
		
		
		return filmDao.getAllFilm();

	}
	
	/**
	 * 
	 */
	@MonitorLogForService  
	public void test(){
		System.out.println("Hello World!");
	}
	

}