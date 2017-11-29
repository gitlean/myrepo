package com.isoft.springtransaction.platTranman.dao.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.isoft.springtransaction.platTranman.dao.SpDao;

@Repository("spDao")
public class SpDaoImp implements SpDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private DataSourceTransactionManager tm;

	public void dosth() {
		// TODO Auto-generated method stub

		DefaultTransactionDefinition tf = new DefaultTransactionDefinition();
		tf.setPropagationBehavior(DefaultTransactionDefinition.PROPAGATION_REQUIRED);

		TransactionStatus status = tm.getTransaction(tf); 
		try {

			jdbcTemplate.update("insert spring_transaction(uname,address) values('a','aa')");

			jdbcTemplate.update("insert spring_transaction(uname,address) values('bbbbbbbbb','bb')");

			tm.commit(status);
		} catch (Exception e) {
			tm.rollback(status);
			e.printStackTrace();
		}
	}

}
