package com.isoft.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isoft.dao.ICinemaDao;
import com.isoft.service.ICinemaService;

@Service
public class CinemaServiceImp implements ICinemaService {

	@Autowired
	ICinemaDao dao;
	
	public void changeBatchNo(int batchNo) {
		// TODO Auto-generated method stub
		dao.changeBatchNo(batchNo);

	}

}
