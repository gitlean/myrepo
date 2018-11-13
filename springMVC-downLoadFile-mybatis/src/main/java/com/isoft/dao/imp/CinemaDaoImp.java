package com.isoft.dao.imp;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.isoft.dao.ICinemaDao;

@Repository
public class CinemaDaoImp implements ICinemaDao{

    @Autowired
    SqlSessionTemplate sqlSession;
    
	public void changeBatchNo(int batchNo) {
		// TODO Auto-generated method stub
		sqlSession.update("com.isoft.entity.Cinema.updateCinema", batchNo);
		
	}

}
