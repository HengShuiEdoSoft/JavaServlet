package com.hsedo.onepiece.iservice;

import java.util.List;
import java.util.Map;

import com.hsedo.onepiece.pojo.Edo_Art_Common_Types_pojo;


public interface Edo_Art_Common_Types_iservice {
	
	public Edo_Art_Common_Types_pojo getModel(int str);

	public List<Edo_Art_Common_Types_pojo> selectList(Map map);

	public int add(Edo_Art_Common_Types_pojo entity);

	public int edit(Edo_Art_Common_Types_pojo entity);

	public 	int delete(Map map);
	
	 //按照PID查找
public List<Edo_Art_Common_Types_pojo> selectPID(int m);
}
