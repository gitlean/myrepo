package test;  

import java.util.List;  
import junit.framework.TestCase;  
import org.springframework.context.ApplicationContext;  
import org.springframework.context.support.ClassPathXmlApplicationContext;  
import com.xxx.pojo.Film;  
import com.xxx.service.FilmService;  
 
/** 
 * 测试Spring整合MyBatis 
 * @author HotStrong 
 * 
 */  
public class TestSpringMyBatis extends TestCase {  
      
    //Spring整合MyBatis相关配置文件  
    //private String[] configFiles = {"applicationContext-mybatis.xml", "applicationContext-services.xml"};  
    //创建Spring应用上下文  
    //private ApplicationContext context =  new ClassPathXmlApplicationContext(configFiles);  
      
	
	private ApplicationContext context =  new ClassPathXmlApplicationContext("applicationContext.xml");  
    
    
    public void testFilm(){  
          
        //获取影片业务逻辑对象  
        FilmService filmService = (FilmService)context.getBean("filmService");  
          
        try {  
              
            /*以下为影片业务逻辑操作*/  
              
            //1、添加一部影片  
            Film film = new Film();  
            film.setFname("功夫熊猫2");//设置片名  
            filmService.insertFilm(film);//添加影片  
              
            //2、修改影片信息  
            //先获取待修改的影片信息  
            film = filmService.getFilmById(9);//9为功夫熊猫2的影片编号  
            //修改影片名称  
            film.setFname("功夫熊猫3");  
            //修改操作  
            filmService.updateFilm(film);  
              
            //3、删除"功夫熊猫3"，其编号为9  
            filmService.deleteFilm(9); 
            
            //4、显示所有电影信息  
            List<Film> filmList = filmService.getAllFilm();  
            for(Film filmObj : filmList){  
                  
                System.out.println("电影ID：" + filmObj.getId() + " 电影名：" + filmObj.getFname());  
            }  
              
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
         
    }  
}  