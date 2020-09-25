package com.hsedo.onepiece.controller;


import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hsedo.onepiece.core.util.convert.String_Convert;
import com.hsedo.onepiece.iservice.Edo_Adverts_iservice;
import com.hsedo.onepiece.iservice.Edo_Art_Common_Types_iservice;
import com.hsedo.onepiece.pojo.Edo_Adverts;
import com.hsedo.onepiece.pojo.Edo_Art_Common_Types_pojo;


/**
 * @author  作者:CC
 * @Date	时间: 2020年9月24日 下午6:04:40
 * 类说明
 * 广告操作类
 */
@Controller
@RequestMapping("/Ad")
public class Edo_AdvertsController {
	
		private static Logger logger = Logger.getLogger(CommonController.class);

		public Edo_AdvertsController() {
		}

		@Autowired
		@Qualifier("Edo_Adverts_service")
		private Edo_Adverts_iservice Ad_service;

		//广告查询
		@RequestMapping("/listsql")
		@ResponseBody
		public Map StudentsList() {
			Map map = new HashMap();
			List<Edo_Adverts> list = Ad_service.selectList(map);
			map.put("code", 0);
			map.put("count", list.size());
			map.put("data",list);
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

			int count = Ad_service.delete(map);

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
		

		// 增
		@RequestMapping(value = "/addsql", method = { RequestMethod.GET, RequestMethod.POST })
		@ResponseBody
		public Map articleadd(@RequestParam("TypeID") String TypeID, @RequestParam("Title") String Title,
				@RequestParam("Img") String Img, @RequestParam("Url") String Url,
				@RequestParam("Data1") String Data1, @RequestParam("Data2") String Data2,
				@RequestParam("Data3") String Data3, @RequestParam("Data4") String Data4,
				@RequestParam("Data5") String Data5, @RequestParam("StartTime") String StartTime,
				@RequestParam("EndTime") String EndTime, @RequestParam("AdState") String AdState) {

			Map map = new HashMap();
			map.put("msg", "fail");

			
			int typeID=0;
			if (TypeID == null || TypeID.length() == 0) {
				map.put("msg", "所属分类不能为空");
				return map;
			}else {
				typeID = String_Convert.convertInteger(TypeID);
			}

		
			if (Title == null || Title.length() == 0) {
				map.put("msg", "Title不能为空");
				return map;
			}
			
			Date startTime = null;
			if (StartTime == null || StartTime.length() == 0) {
				map.put("msg", "开始时间不能为空");
				return map;
			}else {
				startTime = String_Convert.StrToDate(StartTime);
			}
			
			Date endTime = null;
			if (EndTime == null || EndTime.length() == 0) {
				map.put("msg", "结束时间不能为空");
				return map;
			}else {
				endTime = String_Convert.StrToDate(EndTime);
			}
			
			int	adState=0;
			if (AdState == null || AdState.length() == 0) {
				map.put("msg", "状态不能为空");
				return map;
			}else {
				adState = String_Convert.convertInteger(AdState);
			}
			
			//没写上传图片
	
			int Hit=0;
			int Sort=0;
			
			

			Edo_Adverts ad = new Edo_Adverts();
			ad.setTypeID(typeID);
			ad.setTitle(Title);
			ad.setImg(Img);
			ad.setUrl(Url);
			ad.setHit(Hit);
			ad.setAdState(adState);
			ad.setStartTime(startTime);
			ad.setEndTime(endTime);
			ad.setSort(Sort);
			ad.setData1(Data1);
			ad.setData2(Data2);
			ad.setData3(Data3);
			ad.setData4(Data4);
			ad.setData5(Data5);
			int count = Ad_service.add(ad);

			if (count == 0) {
				// 执行错误
				map.put("msg", "未成功");
			} else {
				// 执行成功
				map.put("msg", "添加成功");
			}

			return map;

		}


		// 改
		@RequestMapping("/editsql")
		@ResponseBody
		public Map typeedit(@RequestParam("ID") int ID, @RequestParam("TypeID") String TypeID, @RequestParam("Title") String Title,
				@RequestParam("Img") String Img, @RequestParam("Url") String Url,
				@RequestParam("Data1") String Data1, @RequestParam("Data2") String Data2,
				@RequestParam("Data3") String Data3, @RequestParam("Data4") String Data4,
				@RequestParam("Data5") String Data5, @RequestParam("StartTime") String StartTime,
				@RequestParam("EndTime") String EndTime, @RequestParam("AdState") String AdState) {

			Map map = new HashMap();
			map.put("msg", "fail");

			
			int typeID=0;
			if (TypeID == null || TypeID.length() == 0) {
				map.put("msg", "所属分类不能为空");
				return map;
			}else {
				typeID = String_Convert.convertInteger(TypeID);
			}

		
			if (Title == null || Title.length() == 0) {
				map.put("msg", "Title不能为空");
				return map;
			}
			
			Date startTime = null;
			if (StartTime == null || StartTime.length() == 0) {
				map.put("msg", "开始时间不能为空");
				return map;
			}else {
				startTime = String_Convert.StrToDate(StartTime);
			}
			
			Date endTime = null;
			if (EndTime == null || EndTime.length() == 0) {
				map.put("msg", "结束时间不能为空");
				return map;
			}else {
				endTime = String_Convert.StrToDate(EndTime);
			}
			
			int	adState=0;
			if (AdState == null || AdState.length() == 0) {
				map.put("msg", "状态不能为空");
				return map;
			}else {
				adState = String_Convert.convertInteger(AdState);
			}
			
			//没写上传图片
	
			int Hit=0;
			int Sort=0;
			
			

			Edo_Adverts ad = new Edo_Adverts();
			ad.setTypeID(typeID);
			ad.setTitle(Title);
			ad.setImg(Img);
			ad.setUrl(Url);
			ad.setHit(Hit);
			ad.setAdState(adState);
			ad.setStartTime(startTime);
			ad.setEndTime(endTime);
			ad.setSort(Sort);
			ad.setData1(Data1);
			ad.setData2(Data2);
			ad.setData3(Data3);
			ad.setData4(Data4);
			ad.setData5(Data5);
			int count = Ad_service.add(ad);

			if (count == 0) {
				// 执行错误
				map.put("msg", "未成功");
			} else {
				// 执行成功
				map.put("msg", "添加成功");
			}

			return map;

		}

}
