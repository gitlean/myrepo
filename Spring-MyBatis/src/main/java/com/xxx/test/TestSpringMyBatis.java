package com.xxx.test;  

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xxx.pojo.Film;
import com.xxx.service.FilmService;

import junit.framework.TestCase;  
 
/** 
 * ����Spring����MyBatis 
 * @author HotStrong 
 * 
 */  
public class TestSpringMyBatis extends TestCase {  
      
    //Spring����MyBatis��������ļ�  
    //private String[] configFiles = {"applicationContext-mybatis.xml", "applicationContext-services.xml"};  
    //����SpringӦ��������  
    //private ApplicationContext context =  new ClassPathXmlApplicationContext(configFiles);  
      
	
	private ApplicationContext context =  new ClassPathXmlApplicationContext("applicationContext.xml");  
    
    
    public void testFilm(){  
          
        //��ȡӰƬҵ���߼�����  
        FilmService filmService = (FilmService)context.getBean("filmService");  
          
        try {  
        	
            /*����ΪӰƬҵ���߼�����*/  
              
            //1�����һ��ӰƬ  
            Film film = new Film();  
            film.setFname("������è2");//����Ƭ��  
            filmService.insertFilm(film);//���ӰƬ  
              
            //2���޸�ӰƬ��Ϣ  
            //�Ȼ�ȡ���޸ĵ�ӰƬ��Ϣ  
            film = filmService.getFilmById(9);//9Ϊ������è2��ӰƬ���  
            //�޸�ӰƬ����  
            film.setFname("������è3");  
            //�޸Ĳ���  
            filmService.updateFilm(film);  
              
            //3��ɾ��"������è3"������Ϊ9  
            filmService.deleteFilm(9); 
            
            //4����ʾ���е�Ӱ��Ϣ  
            List<Film> filmList = filmService.getAllFilm();  
            for(Film filmObj : filmList){  
                  
                System.out.println("��ӰID��" + filmObj.getId() + " ��Ӱ����" + filmObj.getFname());  
            }  
              
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
         
    }  
}  