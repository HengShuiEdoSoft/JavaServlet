package com.hsedo.onepiece.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hsedo.onepiece.core.util.convert.String_Convert;
import com.hsedo.onepiece.iservice.Edo_Art_Common_Types_iservice;
import com.hsedo.onepiece.pojo.Edo_Adverts;
import com.hsedo.onepiece.pojo.Edo_Art_Common_Types_pojo;


/**
 * @author  作者:CC
 * @Date	时间: 2020年9月30日 下午5:18:20
 * 类说明
 *  文章类型  控制台  与广告类型是同一个表
 */
@Controller
@RequestMapping("/Common_Type")
public class Edo_Common_TypeController {

	private static Logger logger = Logger.getLogger(Edo_CommonController.class);

	public Edo_Common_TypeController() {
	}

	@Autowired
	@Qualifier("Edo_Art_Common_Types_service")
	private Edo_Art_Common_Types_iservice common_service;

	
	
	
	@RequestMapping(value = "/iDlistsql", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Map StudentsList(@RequestParam("ID") String ID) {
	int 	id = String_Convert.convertInteger(ID);
		Map map = new HashMap();
		Edo_Art_Common_Types_pojo list = common_service.getModel(id);
		
		map.put("code", 0);
		map.put("data",list);
		return map;
	}
	
	
	
	@RequestMapping("/listsql")
	@ResponseBody
	public Map StudentsList() {
		Map map = new HashMap();
		List<Edo_Art_Common_Types_pojo> list = common_service.selectList(map);
		map.put("code", 0);
		map.put("count", list.size());
		map.put("data",list);
		return map;
	}

	
	@RequestMapping("/select")
	@ResponseBody
	public Map List() {
		Map map = new HashMap();
		Edo_Art_Common_Types_pojo ad = new Edo_Art_Common_Types_pojo();
		ad.setTypeMaster("0");
		List<Edo_Art_Common_Types_pojo> list = common_service.select(ad);
		map.put("code", 0);
		map.put("count", list.size());
		map.put("data",list);
		return map;
	}

	

//	@RequestMapping("/add")
//	public ModelAndView articleadd() {
//		Map map = new HashMap();
//		List<Edo_Art_Common_Types_pojo> list = common_service.selectList(map);
//		return new ModelAndView("typeAdd", "stulist", list);
//	}
	
	
	
	

	// 增
	@RequestMapping(value = "/addsql", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	@Cacheable(value="cacheMap", key="#key1") 
	public Map add(@RequestParam("TypeName") String TypeName, @RequestParam("ParentID") String ParentID,
			@RequestParam("SortID") String SortID, @RequestParam("Img") String Img,@RequestParam("TempShow") String TempShow,
			@RequestParam("PageSize") String PageSize, @RequestParam("TempIndex") String TempIndex) {
		
		Map map = new HashMap();
		map.put("msg", "fail");

		if (TypeName == null || TypeName.length() == 0) {
			map.put("msg", "TypeName不能为空");
			return map;
		}
		int state = 0;
	
		int parentID =  String_Convert.convertInteger(ParentID); 
		int sortID = String_Convert.convertInteger(SortID); 
		int isSystem = 0;
		int pageType = 0;
		int catalog = 0;
		int pageSize =String_Convert.convertInteger(PageSize);
		String Path = "";
		//通过TypeMaster 区分文章类型与广告类型的判断
		String	TypeMaster="0";
		String Catalog = "";
		String TempList="";
		Edo_Art_Common_Types_pojo ad = new Edo_Art_Common_Types_pojo();
		ad.setTypeName(TypeName);
		ad.setState(state);
		ad.setParentID(parentID);
		ad.setSortID(sortID);
		ad.setLayer(0);
		ad.setHaschild(0);
		ad.setPath(Path);
		ad.setTypeMaster(TypeMaster);
		ad.setImg(Img);
		ad.setTempList(TempList);
		ad.setIsSystem(isSystem);
		ad.setPageType(pageType);
		ad.setTempIndex(TempIndex);
		ad.setTempShow(TempShow);
		ad.setPageSize(pageSize);
		ad.setCatalog(Catalog);

		int count = common_service.add(ad);

		if (count == 0) {
			// 执行错误
			map.put("msg", "未成功");
		} else {
			// 执行成功
			map.put("msg", "更改成功");
		}
		return map;
	}

	// 删
	@RequestMapping(value = "/deletesql")
	@ResponseBody // @ResponseBody是可以往前端传递json格式的数据
	public Map articledelete(HttpServletRequest req) {
		Map<String, Object> result = new HashMap(); // 创建子键值对
		result.put("msg", "fail"); // 定义msg , 控制返回的信息

		Map map = new HashMap();
		String ID = req.getParameter("ID");
		map.put("ID", ID);

		int count = common_service.delete(map);

		Map mapweb = new HashMap();
		map.put("msg", "fail");
		if (count == 0) {
			// 执行错误
			mapweb.put("msg", "删除未成功");
		} else {
			// 执行成功
			mapweb.put("msg", "删除成功");
		}
		return mapweb;

	}

//	// 改 返回jsp文件名
//	@RequestMapping("/edit")
//	public ModelAndView edit(int ID) {
//		Edo_Art_Common_Types_pojo list = common_service.getModel(ID);
//		return new ModelAndView("typeEdit", "date", list);
//	}

	// 改
	@RequestMapping("/editsql")
	@ResponseBody
	public Map typeedit(@RequestParam("ID") String ID,@RequestParam("typeName") String TypeName, @RequestParam("parentID") String ParentID,
			@RequestParam("sortID") String SortID, @RequestParam("img") String Img,@RequestParam("tempShow") String TempShow,
			@RequestParam("pageSize") String PageSize, @RequestParam("tempIndex") String TempIndex) {
		
		Map map = new HashMap();
		map.put("msg", "fail");

		if (TypeName == null || TypeName.length() == 0) {
			map.put("msg", "TypeName不能为空");
			return map;
		}
		int state = 0;
		int iD =  String_Convert.convertInteger(ID); 
		int parentID =  String_Convert.convertInteger(ParentID); 
		int sortID = String_Convert.convertInteger(SortID); 
		int isSystem = 0;
		int pageType = 0;
		int catalog = 0;
		int pageSize =String_Convert.convertInteger(PageSize);
		String Path = "";
		String	TypeMaster="0";
		String Catalog = "";
		String TempList="";
		Edo_Art_Common_Types_pojo ad = new Edo_Art_Common_Types_pojo();
		ad.setID(iD);
		ad.setTypeName(TypeName);
		ad.setState(state);
		ad.setParentID(parentID);
		ad.setSortID(sortID);
		ad.setLayer(0);
		ad.setHaschild(0);
		ad.setPath(Path);
		ad.setTypeMaster(TypeMaster);
		ad.setImg(Img);
		ad.setIsSystem(isSystem);
		ad.setPageType(pageType);
		ad.setTempList(TempList);
		ad.setTempIndex(TempIndex);
		ad.setTempShow(TempShow);
		ad.setPageSize(pageSize);
		ad.setCatalog(Catalog);

		int count = common_service.edit(ad);

		if (count == 0) {
			// 执行错误
			map.put("msg", "未成功");
		} else {
			// 执行成功
			map.put("msg", "更改成功");
		}
		return map;
	}
}
