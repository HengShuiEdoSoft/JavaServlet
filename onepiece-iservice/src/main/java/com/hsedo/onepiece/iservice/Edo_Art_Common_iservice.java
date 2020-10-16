package com.hsedo.onepiece.iservice;

import java.util.List;
import java.util.Map;

import com.hsedo.onepiece.pojo.Edo_Art_Common_pojo;

public interface Edo_Art_Common_iservice {
	
	public Edo_Art_Common_pojo getModel(int str);

	public List<Edo_Art_Common_pojo> selectList(Map map);
	
	public int add(Edo_Art_Common_pojo entity);

	public int edit(Edo_Art_Common_pojo entity);

	public 	int delete(Map map);
	
	
	//模糊(搜索)查询
	List<Edo_Art_Common_pojo> selectList1(Edo_Art_Common_pojo m);
	
	//批量删除
    int batchdelete(String   StrID);

}
