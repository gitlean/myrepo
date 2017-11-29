package com.isoft.springtransaction.comprehensive;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

public class TemplateUtils {
	private static Logger logger=LoggerFactory.getLogger(TemplateUtils.class);
	private static String oracleDS = "dataSource";
	private static DataSource dataSource = null;

	static {
		try {
			//获取上下文
			Context context = new InitialContext();   //rt.jar

			dataSource = (DataSource) context.lookup(oracleDS);
		} catch (NamingException e) {
			logger.info("查找数据源失败···", e);
		}
	}

	public static TransactionTemplate getTransactionTemplate() {
		PlatformTransactionManager txManager = new DataSourceTransactionManager(dataSource);
		return new TransactionTemplate(txManager);
	}

	
	public static JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(dataSource);
	}

	public static NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return new NamedParameterJdbcTemplate(dataSource);
	}

	/**
	//https://www.2cto.com/kf/201612/575975.html
	 * 从Spring 3.1开始，JdbcTemplate和NamedParameterJdbcTemplate提供了SimpleJdbcTemplate的功能。
	 * SimpleJdbcTemplate和SimpleJdbcDaoSupport被标记为过时，到Spring 4.3则被完全移除。
	public static SimpleJdbcTemplate getSimpleJdbcTemplate() {
		return new SimpleJdbcTemplate(dataSource);
	}
	*/
	public static void main(String[] args) {
		System.out.println("<<<<<<<<<<<<>>>>>>>>>>>");
	}

}
