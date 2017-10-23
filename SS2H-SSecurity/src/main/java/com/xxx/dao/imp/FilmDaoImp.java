package com.xxx.dao.imp;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.xxx.dao.FilmDao;
import com.xxx.entity.Film;

public class FilmDaoImp implements FilmDao {

	@Autowired
	EntityManagerFactory entityManagerFactory;

	public List<Film> getAllFilm() {
		// TODO Auto-generated method stub
		EntityManager em = entityManagerFactory.createEntityManager();
		String jpql = "select o from FILM o";
		Query query = em.createQuery(jpql);
		List<Film> list = query.getResultList();
		em.close();
		return list;
	}

	public Film getFilmById(int id) {
		// TODO Auto-generated method stub

		Long id_l = new Long((long) id);
		EntityManager em = entityManagerFactory.createEntityManager();
		String jpql = "select o from FILM o where id=:id";
		Query query = em.createQuery(jpql);
		query.setParameter("id", id_l);
		Film film = (Film) query.getSingleResult();
		em.close();
		return film;
	}

	
	//structs2  action  未用到  暂未实现
	public List<Film> getAllFilmOrder(Map<String, Object> params) {
		// TODO Auto-generated method stub
		
		
		
		
		return null;
	}

	public void insertFilm(Film film) {
		// TODO Auto-generated method stub
		EntityManager em = entityManagerFactory.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(film);
		tx.commit();

		em.close();

	}

	//???
	public void updateFilm(Film film) {
		// TODO Auto-generated method stub
		EntityManager em = entityManagerFactory.createEntityManager();
		// 实体管理器已于事务关联
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		// 查找出来后 person 对象在 CPU 时处于托管状态
		// 这时调用实体类的 set 方法，可以对数据进行更改，但并不是立即更改，是放在 JDBC 的批处理交易库里面
		Film film4update = em.find(Film.class, film.getId());
		film4update.setFname(film.getFname());
		// 调用事务提交后，会将数据同步到数据库中
		tx.commit();
		em.close();
	}

	public void deleteFilm(int id) {
		// TODO Auto-generated method stub
		
		Long id_l = new Long((long) id);
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Film Film = em.find(Film.class, id_l);
	    em.remove(Film);
	    tx.commit();
		em.close();

	}

}
