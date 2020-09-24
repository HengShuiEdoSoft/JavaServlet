package com.hsedo.onepiece.iservice;

import java.util.List;
import java.util.Map;

import com.hsedo.onepiece.pojo.Edo_Adverts;



/**
 * @author  作者:CC
 * @Date	时间: 2020年9月24日 下午5:57:53
 * 类说明
 *   广告类基础逻辑 接口
 */
public interface Edo_Adverts_iservice {
	
	public Edo_Adverts getModel(int str);

	public List<Edo_Adverts> selectList(Map map);
	
	public int add(Edo_Adverts entity);

	public int edit(Edo_Adverts entity);

	public 	int delete(Map map);

}
