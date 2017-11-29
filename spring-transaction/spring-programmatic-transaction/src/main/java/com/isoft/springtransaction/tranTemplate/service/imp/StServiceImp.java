package com.isoft.springtransaction.tranTemplate.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.isoft.springtransaction.tranTemplate.dao.StDao;
import com.isoft.springtransaction.tranTemplate.service.StService;

@Service("stService")
public class StServiceImp implements StService {
	@Autowired
	private StDao dao;

	@Autowired
	private TransactionTemplate transactionTemplate;

	public void doBusinessLogic() {
		// TODO Auto-generated method stub
		transactionTemplate.execute(new TransactionCallback() {
			public Object doInTransaction(TransactionStatus status) {
				try {
					dao.update1();
					
					dao.update2();
					
					
				} catch (Exception e) {
					status.setRollbackOnly(); // 回滚
					e.printStackTrace();
				}
				return null;
			}

		});

	}

}
