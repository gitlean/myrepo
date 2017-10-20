package com.xxx.test;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import junit.framework.TestCase;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.xxx.dao.FilmMapper;
import com.xxx.pojo.Film;

public class TestMyBaties extends TestCase {
	
	//ָ��MyBatis�����ļ�
	private static final String RESOURCE = "mybatis-config.xml";
	
	/**
	 * ��6���������CRUD
	 * @throws IOException
	 */
	public void testBaties() throws IOException{
		
		//1��ָ��MyBaties�����ļ�
		Reader reader = Resources.getResourceAsReader(RESOURCE);
		//2������SqlSessionFactory()
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		
		SqlSession session = null;
		try {
			
			//3����ȡSqlSession
			session = sessionFactory.openSession();
			
			//4����ȡDAO�ӿڶ���
			FilmMapper mapper = session.getMapper(FilmMapper.class);
			
			//5��CRUD����
			
			//5.1--���ӰƬ
			Film film = new Film();
			film.setFname("Ц������");
			mapper.insertFilm(film);
			session.commit();//��ӡ��޸ġ�ɾ�����������Ҫ�ύ����
			
			//5.2--��ȡ���е�Ӱ��Ϣ
			List<Film> filmList = mapper.getAllFilm();
			
			//��ʾ���е�Ӱ��Ϣ
			for(Film filmObj : filmList){
				
				System.out.println("��ӰID��" + filmObj.getId() + " ��Ӱ����" + filmObj.getFname());
				
			}
			
			//5.3--��ѯ����
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("orderKey", "id asc");
			filmList = mapper.getAllFilmOrder(params);
			//��ʾ���е�Ӱ��Ϣ
			for(Film filmObj : filmList){
				
				System.out.println("��ӰID��" + filmObj.getId() + " ��Ӱ����" + filmObj.getFname());
				
			}
			
			//5.4--�޸�ӰƬ"Ц������"Ϊ"ϲ��֮��"
			film = mapper.getFilmById(9);
			film.setFname("ϲ��֮��");
			mapper.updateFilm(film);
			session.commit();
			
			//5.5--ɾ��ӰƬ"Ц������"����IDΪ9
			mapper.deleteFilm(9);
			session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			
			//6���ر�SqlSession
			if(session != null){
				session.close();
			}
		}
		
	}
	
}