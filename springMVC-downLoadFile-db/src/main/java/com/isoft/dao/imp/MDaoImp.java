package com.isoft.dao.imp;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.isoft.dao.IMDao;
import com.isoft.entity.Film;

@Repository
public class MDaoImp implements IMDao {
	@Autowired
	EntityManagerFactory entityManagerFactory;
	
	public List<Film> queryList() {
		// TODO Auto-generated method stub
		/**
		
		
		//模拟DB取数据
		List<Adata> list=new ArrayList<Adata>();
		Adata ins=new Adata("1","Tome");
		list.add(ins);
		
		Adata ins2=new Adata("2","Jerry");
		list.add(ins2);
		 */
		
		EntityManager em = entityManagerFactory.createEntityManager();
		String jpql = "select o from FILM o";  //@Entity(name = "FILM")  此处FILM保持一致
		Query query = em.createQuery(jpql);
		List<Film> list = query.getResultList();
		em.close();
		return list;
	}

}
