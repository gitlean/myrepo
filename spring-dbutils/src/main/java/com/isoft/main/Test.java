package com.isoft.main;

import java.sql.Connection;
import java.sql.SQLException;

import com.isoft.c3p0.JDBCUtils;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con=null;
		try {
			con=JDBCUtils.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(null!=con){
			System.out.println("yes");
		}

	}

}
