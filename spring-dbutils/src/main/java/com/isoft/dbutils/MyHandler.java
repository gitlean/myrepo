package com.isoft.dbutils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;

import com.isoft.domain.User;
//自定义实现ResultSetHandler封装查询结果集
//ResultSetHandler<T>,<T>表示封装结果的类型
//MyHandler 是自定义的ResultSetHandler封装结果集策略对象
public class MyHandler implements ResultSetHandler<List<User>> {

	public List<User> handle(ResultSet rs) throws SQLException {
		// 封装数据，数据从 Resultset 中获取
		List<User> list = new ArrayList<User>();
		while (rs.next()) {
			User u = new User();
			u.setId(rs.getInt("id"));
			u.setName(rs.getString("name"));
			u.setPwd(rs.getString("pwd"));

			list.add(u);
		}
		return list;
	}
	
	public static void main(String[] args) {
		
	}

}