package com.isoft.springtransaction.annotation.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.isoft.springtransaction.annotation.dao.StDao;
import com.isoft.springtransaction.annotation.service.StService;

@Service("stService")
public class StServiceImp implements StService {

	@Autowired
	private StDao stDao;
	
	@Transactional
	public void doSth() {
		// TODO Auto-generated method stub
		System.out.println("doSth");
		stDao.update1();
		stDao.update2();

	}
	

	

}
