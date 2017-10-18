package cn.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.jxufe.Person;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		Person obj = (Person) context.getBean("person");
		obj.getMessage();

//		BasicDataSource db = (BasicDataSource) context.getBean("dataSource");
//		Connection con = null;
//		try {
//			if (null != db) {
//				con = db.getConnection();
//				String sql="select * from user";
//				PreparedStatement pstmt=con.prepareStatement(sql);
//			    ResultSet rs=pstmt.executeQuery();
//			    while(rs.next()){
//			    	System.out.println(rs.getString("name"));
//			    }
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		} finally {
//			if (null != con) {
//				try {
//					con.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
		
		System.out.println("<<<<<<<<<>>>>>>>>>");

	}

}
