package com.xxx.threadlocal.demo2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//https://www.cnblogs.com/dreamroute/p/5034726.html
//这样子，都是用同一个连接，但是每个连接都是新的，是同一个连接的副本。
/**
 * ThreadLocal类是修饰变量的，重点是在控制变量的作用域，初衷可不是为了解决线程并发和线程冲突的，而是为了让变量的种类变的更多更丰富，
 * 方便人们使用罢了。很多开发语言在语言级别都提供这种作用域的变量类型。
 * @author john
 * @date 2018年10月20日
 * @time 下午3:09:51
 * @describe:
 */

public final class ConnectionUtil {

	private ConnectionUtil() {
	}

	private static final ThreadLocal<Connection> conn = new ThreadLocal<Connection>();

	public static Connection getConn() {
		Connection con = conn.get();
		
		if (con == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("url", "userName", "password");
				conn.set(con);
			} catch (ClassNotFoundException | SQLException e) {
				// ...
			}
		}
		
		return con;
	}

}