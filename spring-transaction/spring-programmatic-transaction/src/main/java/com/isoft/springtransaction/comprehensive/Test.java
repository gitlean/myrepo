package com.isoft.springtransaction.comprehensive;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

@SuppressWarnings("all")
public class Test {

	public void m1() throws Exception {
		TransactionTemplate transactionTemplate = TemplateUtils.getTransactionTemplate();
		Object object = transactionTemplate.execute(new TransactionCallback() {
			public Object doInTransaction(TransactionStatus status) {
				try {
					// 数据库操作1
					// 数据库操作2
				} catch (Exception e) {
					status.setRollbackOnly();
					e.printStackTrace();
				}
				return null;
			}
		});
	}

	public void m2() throws Exception {
		TransactionTemplate transactionTemplate = TemplateUtils.getTransactionTemplate();
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			protected void doInTransactionWithoutResult(TransactionStatus s) {
				try {
					// 数据库操作1
					// 数据库操作2
				} catch (Exception e) {
					s.setRollbackOnly();
					e.printStackTrace();
				}
			}
		});
	}

	//3.2.2 使用PlatformTransactionManager
	
	public void m3() throws Exception {
		Context ctx = new InitialContext();
		DataSource ds = (DataSource) ctx.lookup("dataSource");
		JdbcTemplate jt = new JdbcTemplate(ds);
		DefaultTransactionDefinition tf = new DefaultTransactionDefinition();
		PlatformTransactionManager tm = new DataSourceTransactionManager(ds);
		TransactionStatus ts = tm.getTransaction(tf);
		try {
			// 数据库操作1
			// 数据库操作2
			tm.commit(ts);
		} catch (Exception e) {
			tm.rollback(ts);
			e.printStackTrace();
		}
	}

}
