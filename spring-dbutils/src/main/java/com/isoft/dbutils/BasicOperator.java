package com.isoft.dbutils;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.isoft.c3p0.JDBCUtils;
import com.isoft.domain.User;
/**
 * 
 * @author john
 * @date 2018年9月10日
 * @time 上午11:21:33
 * @describe:
 */
public class BasicOperator {
	// 需求：向user表插入一条数据
	public void test1() {
		// 第一步：创建queryRunner对象，用来操作sql语句
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		// 第二步：创建sql语句
		String sql = "insert into user values(null,?,?)";
		// 第三步：执行sql语句,params:是sql语句的参数
		// 注意，给sql语句设置参数的时候，按照user表中字段的顺序
		try {
			int update = qr.update(sql, "狗蛋", "123456");
			System.out.println(update);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// 需求：修改id==7的数据
	public void test2() {
		// 第一步：创建queryRunner对象，用来操作sql语句
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		// 第二步：创建sql语句
		String sql = "update user set name = ? where id = ?";
		// 第三步：执行sql语句,params:是sql语句的参数
		// 注意，给sql语句设置参数的时候，按照user表中字段的顺序
		try {
			int update = qr.update(sql, "柳岩", 7);
			System.out.println(update);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// 需求：删除id==7的数据
	public void test3() {
		// 第一步：创建queryRunner对象，用来操作sql语句
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		// 第二步：创建sql语句
		String sql = "delete from user where id = ?";
		// 第三步：执行sql语句,params:是sql语句的参数
		// 注意，给sql语句设置参数的时候，按照user表中字段的顺序
		try {
			int update = qr.update(sql, 7);
			System.out.println(update);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void test4() {
		// 第一步：创建queryRunner对象，用来操作sql语句
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		// 第二步：创建sql语句
		String sql = "select * from user";
		// 第三步：执行sql语句,params:是sql语句的参数
		// 注意，给sql语句设置参数的时候，按照user表中字段的顺序
		try {
			List<User> list = qr.query(sql, new MyHandler());
			System.out.println(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 案例三：ResultSetHandler实现类介绍（由DbUtils框架提供）
               备注：DbUtils给我们提供了10个ResultSetHandler实现类，分别是：
     ①ArrayHandler：     将查询结果的第一行数据，保存到Object数组中
     ②ArrayListHandler     将查询的结果，每一行先封装到Object数组中，然后将数据存入List集合
     ③BeanHandler     将查询结果的第一行数据，封装到user对象
     ④BeanListHandler     将查询结果的每一行封装到user对象，然后再存入List集合
     ⑤ColumnListHandler     将查询结果的指定列的数据封装到List集合中
     ⑥MapHandler     将查询结果的第一行数据封装到map结合（key==列名，value==列值）
     ⑦MapListHandler     将查询结果的每一行封装到map集合（key==列名，value==列值），再将map集合存入List集合
     ⑧BeanMapHandler     将查询结果的每一行数据，封装到User对象，再存入mao集合中（key==列名，value==列值）
     ⑨KeyedHandler     将查询的结果的每一行数据，封装到map1（key==列名，value==列值 ），然后将map1集合（有多个）存入map2集合（只有一个）
     ⑩ScalarHandler     封装类似count、avg、max、min、sum......函数的执行结果
	 */
	//以上10个ResultSetHandler实现类，常用的是BeanHandler、BeanListHandler和ScalarHandler
	//需求：测试BeanHandler策略
	//BeanHandler:将查询结果的第一行数据，封装到user对象
	public void test7() {
		// 第一步：创建queryRunner对象，用来操作sql语句
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		// 第二步：创建sql语句
		String sql = "select * from user";
		// 第三步：执行sql语句,params:是sql语句的参数
		// 注意，给sql语句设置参数的时候，按照user表中字段的顺序
		try {
			User user = qr.query(sql, new BeanHandler<User>(User.class));
			System.out.println(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//需求：测试BeanListHandler策略
	//BeanListHandler:将查询结果的每一行封装到user对象，然后，再存入list集合
	public void test8() {
		// 第一步：创建queryRunner对象，用来操作sql语句
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		// 第二步：创建sql语句
		String sql = "select * from user";
		// 第三步：执行sql语句,params:是sql语句的参数
		// 注意，给sql语句设置参数的时候，按照user表中字段的顺序
		try {
			List<User> list = qr.query(sql, new BeanListHandler<User>(User.class));
			System.out.println(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//需求：测试ScalarHandler策略
	//ScalarHandler:封装类似count、avg、max、min、sum。。。。函数的执行结果
	public void test9() {
		// 第一步：创建queryRunner对象，用来操作sql语句
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		// 第二步：创建sql语句
		String sql = "select count(*) from user";
		// 第三步：执行sql语句,params:是sql语句的参数
		// 注意，给sql语句设置参数的时候，按照user表中字段的顺序
		try {
			Object object = qr.query(sql, new ScalarHandler()); //Scalar  数量
			System.out.println(object);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		BasicOperator ins = new BasicOperator();
		ins.test9();
	}
}
