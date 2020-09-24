package com.hsedo.onepiece.dao;

import java.util.List;
import java.util.Map;

import com.hsedo.onepiece.base.BaseDao;
import com.hsedo.onepiece.pojo.Edo_Art_Common_Types_pojo;


/**
 * @author  作者:CC
 * @Date	时间: 2020年9月24日 下午5:36:01
 * 类说明
 *  文章分类 管理dao层
 */
public interface Edo_Art_Common_Types_dao extends BaseDao<Edo_Art_Common_Types_pojo> {
//	//模糊查询
//	 List<Edo_Art_Common_Types_pojo> selectList1(Edo_Art_Common_Types_pojo m);

	 //按照PID查找
	List<Edo_Art_Common_Types_pojo> selectPID(int m);
}
