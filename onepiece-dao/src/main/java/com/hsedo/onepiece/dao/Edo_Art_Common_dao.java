package com.hsedo.onepiece.dao;

import java.util.List;
import java.util.Map;

import com.hsedo.onepiece.base.BaseDao;
import com.hsedo.onepiece.pojo.Edo_Art_Common_pojo;

/**
 * @author  作者:CC
 * @Date	时间: 2020年9月16日 下午4:05:16
 * 类说明
 * 公共表 dao层基础操作
 */
public interface Edo_Art_Common_dao extends BaseDao<Edo_Art_Common_pojo> {
	//模糊(搜索)查询
	List<Edo_Art_Common_pojo> selectList1(Edo_Art_Common_pojo m);
	
	//批量删除
    int batchdelete(String   StrID);
}
