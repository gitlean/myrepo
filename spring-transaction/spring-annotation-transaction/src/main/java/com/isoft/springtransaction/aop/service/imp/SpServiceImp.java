package com.isoft.springtransaction.aop.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isoft.springtransaction.aop.dao.SpDao;
import com.isoft.springtransaction.aop.service.SpService;

@Service("spService")
public class SpServiceImp implements SpService {

	@Autowired
	private SpDao spDao;
	
	public void doBusinessLogic() {
		// TODO Auto-generated method stub
		spDao.update1();
		spDao.update2();
	}
	
	
	public void saveLogic(){
		spDao.update1();
		spDao.update2();
	}

}
