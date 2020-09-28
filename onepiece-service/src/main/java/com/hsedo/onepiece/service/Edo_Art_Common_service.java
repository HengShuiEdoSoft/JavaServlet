package com.hsedo.onepiece.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.hsedo.onepiece.dao.Edo_Art_Common_dao;
import com.hsedo.onepiece.iservice.Edo_Art_Common_iservice;
import com.hsedo.onepiece.pojo.Edo_Art_Common_pojo;

@Service("Edo_Art_Common_service")
public class Edo_Art_Common_service implements Edo_Art_Common_iservice {

	@Autowired
	Edo_Art_Common_dao Dao;
	
	public Edo_Art_Common_pojo getModel(int str) {
		// TODO Auto-generated method stub
		return Dao.getModel(str);
	}
	
	
	
	public List<Edo_Art_Common_pojo> selectList(Map map) {
		// TODO Auto-generated method stub
		return Dao.selectList(map);
	}

	public int add(Edo_Art_Common_pojo entity) {
		// TODO Auto-generated method stub
		return Dao.add(entity);
	}

	public int edit(Edo_Art_Common_pojo entity) {
		// TODO Auto-generated method stub
		return Dao.update(entity);
	}

	public int delete(Map map) {
		// TODO Auto-generated method stub
		return Dao.delete(map);
	}
}
