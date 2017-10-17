package cn.test;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.isoft.entity.User;

public class MainApp2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		EntityManagerFactory factory = (EntityManagerFactory) context
				.getBean("entityManagerFactory");
		EntityManager em = factory.createEntityManager();
		String jpql = "select o from USER o";
		Query query = em.createQuery(jpql);
		List<User> list=query.getResultList();
		Iterator iter=list.iterator();
		while(iter.hasNext()){
			User user=(User) iter.next();
			System.out.println(user.toString());
		}
		
		em.close();
		factory.close();

	}

}
