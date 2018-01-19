package com.isoft.dao;

import java.util.List;
import java.util.Map;

public interface IBaseDao {

	List<Map<String, Object>> queryForList(String sql1, Object[] objs);
	void insert(String sql,Object[] objs);
}
