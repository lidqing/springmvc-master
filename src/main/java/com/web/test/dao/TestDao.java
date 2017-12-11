package com.web.test.dao;

import java.util.List;
import java.util.Map;


public interface TestDao {

	List<Map<String,Object>> queryUserlist(Map<String,Object> map);
	
	int insertUserStyle(Map<String,Object> map);
	
	int updateUser(Map<String,Object> map);
}
