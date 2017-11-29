package com.isoft.springtransaction.platTranman.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isoft.springtransaction.platTranman.dao.SpDao;
import com.isoft.springtransaction.platTranman.service.SpService;

@Service("spService")
public class SpServiceImp implements SpService {

	@Autowired
	private SpDao dao;

	public void doBusinessLogic() {
		// TODO Auto-generated method stub
		dao.dosth();
	}

}
