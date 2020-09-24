package com.hsedo.onepiece.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsedo.onepiece.dao.Edo_Adverts_dao;
import com.hsedo.onepiece.iservice.Edo_Adverts_iservice;
import com.hsedo.onepiece.pojo.Edo_Adverts;

/**
 * @author  作者:CC
 * @Date	时间: 2020年9月24日 下午5:59:08
 * 类说明
 * 广告 逻辑类
 */

@Service("Edo_Adverts_service")
public class Edo_Adverts_service  implements Edo_Adverts_iservice{

		@Autowired
		Edo_Adverts_dao Dao;

		public Edo_Adverts getModel(int str) {
			// TODO Auto-generated method stub
			return Dao.getModel(str);
		}

		public List<Edo_Adverts> selectList(Map map) {
			// TODO Auto-generated method stub
			return Dao.selectList(map);
		}

		public int add(Edo_Adverts entity) {
			// TODO Auto-generated method stub
			return Dao.add(entity);
		}

		public int edit(Edo_Adverts entity) {
			// TODO Auto-generated method stub
			return Dao.update(entity);
		}

		public int delete(Map map) {
			// TODO Auto-generated method stub
			return Dao.delete(map);
		}
}
