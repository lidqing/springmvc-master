package com.web.test.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.test.dao.TestDao;

@Service("testService")
@Transactional
public class TestService {
	
	@Autowired
	private TestDao testDao;

	public List<Map<String,Object>> queryUserlist(Map<String,Object> map){
		return testDao.queryUserlist(map);
	}
	
	public int insertUserStyle(Map<String,Object> map){
		return testDao.insertUserStyle(map);
	}
	
	public int updateUser(Map<String,Object> map){
		return testDao.updateUser(map);
	}

}
