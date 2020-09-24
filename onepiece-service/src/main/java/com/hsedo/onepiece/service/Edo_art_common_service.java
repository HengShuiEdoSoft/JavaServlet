package com.hsedo.onepiece.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.hsedo.onepiece.dao.Edo_art_common_dao;
import com.hsedo.onepiece.iservice.Edo_art_common_iservice;
import com.hsedo.onepiece.pojo.Edo_art_common_pojo;

@Service("Edo_art_common_service")
public class Edo_art_common_service implements Edo_art_common_iservice {

	@Autowired
	Edo_art_common_dao Dao;
	
	public Edo_art_common_pojo getModel(int str) {
		// TODO Auto-generated method stub
		return Dao.getModel(str);
	}
	
	
	
	public List<Edo_art_common_pojo> selectList(Map map) {
		// TODO Auto-generated method stub
		return Dao.selectList(map);
	}

	public int add(Edo_art_common_pojo entity) {
		// TODO Auto-generated method stub
		return Dao.add(entity);
	}

	public int edit(Edo_art_common_pojo entity) {
		// TODO Auto-generated method stub
		return Dao.update(entity);
	}

	public int delete(Map map) {
		// TODO Auto-generated method stub
		return Dao.delete(map);
	}
}
