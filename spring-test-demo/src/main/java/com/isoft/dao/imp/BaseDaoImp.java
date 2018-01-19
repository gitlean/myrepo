package com.isoft.dao.imp;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.isoft.dao.IBaseDao;

@Repository("baseDao")
public class BaseDaoImp implements IBaseDao{

	public List<Map<String, Object>> queryForList(String sql1, Object[] objs) {
		// TODO Auto-generated method stub
		return null;
	}

	public void insert(String sql, Object[] objs) {
		// TODO Auto-generated method stub
		
	}

}
