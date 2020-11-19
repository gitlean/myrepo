package com.isoft.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isoft.dao.IMDao;
import com.isoft.entity.Film;
import com.isoft.service.IMyService;

@Service
public class MyServiceImp implements IMyService {

	@Autowired
	IMDao dao;
	
	public List<Film> queryList() {
		// TODO Auto-generated method stub
		return dao.queryList();
	}

}
