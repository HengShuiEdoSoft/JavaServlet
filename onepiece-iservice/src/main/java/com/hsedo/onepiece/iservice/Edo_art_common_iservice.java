package com.hsedo.onepiece.iservice;

import java.util.List;
import java.util.Map;

import com.hsedo.onepiece.pojo.Edo_art_common_pojo;

public interface Edo_art_common_iservice {
	
	public Edo_art_common_pojo getModel(int str);

	public List<Edo_art_common_pojo> selectList(Map map);
	
	public int add(Edo_art_common_pojo entity);

	public int edit(Edo_art_common_pojo entity);

	public 	int delete(Map map);

}
