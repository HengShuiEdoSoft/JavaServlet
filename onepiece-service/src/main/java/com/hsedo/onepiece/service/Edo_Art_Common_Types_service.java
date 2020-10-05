package com.hsedo.onepiece.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsedo.onepiece.core.util.cache.Cache;
import com.hsedo.onepiece.core.util.cache.CacheManager;
import com.hsedo.onepiece.dao.Edo_Art_Common_Types_dao;
import com.hsedo.onepiece.iservice.Edo_Art_Common_Types_iservice;
import com.hsedo.onepiece.pojo.Edo_Art_Common_Types_pojo;

@Service("Edo_Art_Common_Types_service")
public class Edo_Art_Common_Types_service implements Edo_Art_Common_Types_iservice {

	@Autowired
	Edo_Art_Common_Types_dao Dao;

	public Edo_Art_Common_Types_pojo getModel(int str) {
		// TODO Auto-generated method stub
		return Dao.getModel(str);
	}

	private static HashMap cacheMap = new HashMap();

	public List<Edo_Art_Common_Types_pojo> selectList(Map map) {

		Cache cache = CacheManager.getCacheInfo("key1");
		if (cache != null) {
			List<Edo_Art_Common_Types_pojo> list1 = (List<Edo_Art_Common_Types_pojo>) cache.getValue();
			return list1;
		} else {
			List<Edo_Art_Common_Types_pojo> list = Dao.selectList(map); // 第一遍读数据库
			CacheManager.putCache("key1", new Cache("cid", list, -1, false)); // 存到缓存
			return list;
		}
	}

	public Edo_Art_Common_Types_pojo GetTypeByID(int ID) {
		for (Edo_Art_Common_Types_pojo entity : selectList(new HashMap())) {
			if (entity.getID() == ID)
				return entity;
		}
		return null;
	}

	public int add(Edo_Art_Common_Types_pojo entity) {

		if (entity.getParentID() > 0) {
			Edo_Art_Common_Types_pojo parentType = GetTypeByID(entity.getParentID());
			entity.setLayer(parentType.getLayer() + 1);
			entity.setHaschild(0);
			entity.setPath("");
			 Dao.add(entity);
			int categoryId =entity.getID();  //获取新添加的数据ID   
			entity.setPath(parentType.getPath() + "," + categoryId);
			edit(entity);

			if (parentType.getHaschild() == 0) {
				parentType.setHaschild(1);
				edit(parentType);
			}
		} else {
			entity.setLayer(0);
			entity.setHaschild(0);
			entity.setPath("");
			Dao.add(entity); 
			entity.setPath(entity.getID() + "");
			edit(entity);
		} 
		CacheManager.clearOnly("key1");
		return 1;
	}

	
	public int edit(Edo_Art_Common_Types_pojo entity) {
		
//		if(getModel(entity.getID())== null ) {
//			return 0;
//		}else {
//		}
		return Dao.update(entity);
	}

	public int delete(Map map) {
		// TODO Auto-generated method stub
		return Dao.delete(map);
	}

	public List<Edo_Art_Common_Types_pojo> selectPID(int m) {
		// TODO Auto-generated method stub
		return Dao.selectPID(m);
	}

	public List<Edo_Art_Common_Types_pojo> select(Edo_Art_Common_Types_pojo c) {
		// TODO Auto-generated method stub
		return Dao.select(c);
	}

}
