package com.hsedo.onepiece.controller;


import java.util.*;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
		
//		@RequestMapping("/listsql")  //返回Jsp页面
//		public ModelAndView StudentsList() {
//			Map map = new HashMap();
//			List<Edo_Adverts> list = common_service.selectList(map);
//			return new ModelAndView("list", "stulist", list);
//		}

		@RequestMapping("/listsql")
		@ResponseBody
		public Map StudentsList() {
			Map map = new HashMap();
			List<Edo_Art_Common_Types_pojo> list = Ad_service.selectList(map);
			map.put("code", 0);
			map.put("count", list.size());
			map.put("data",list);
			return map;
		}


		// 增
		@RequestMapping(value = "/addsql", method = { RequestMethod.GET, RequestMethod.POST })
		@ResponseBody
		public Map articleadd(@RequestParam("Title") String Title, @RequestParam("TitleWeb") String TitleWeb,
				@RequestParam("KeyWords") String KeyWords, @RequestParam("Description") String Description,
				@RequestParam("Source") String Source, @RequestParam("Url") String Url,
				@RequestParam("Author") String Author, @RequestParam("CDate") String CDate,
				@RequestParam("TypeID") String TypeID, @RequestParam("Img") String Img,
				@RequestParam("FileUrl") String FileUrl, @RequestParam("TempShow") String TempShow,
				@RequestParam("Body") String Body) {

			Map map = new HashMap();
			map.put("msg", "fail");

			String TitleSpell = null;
			if (Title == null || Title.length() == 0) {
				map.put("msg", "Title不能为空");
				return map;
			} else {
				TitleSpell = String_Convert.getPingYin(Title);
			}

			if (TitleWeb == null || TitleWeb.length() == 0) {
				map.put("msg", "TitleWeb不能为空");
				return map;
			}

			if (KeyWords == null || KeyWords.length() == 0) {
				map.put("msg", "关键字不能为空");
				return map;
			}

			if (Description == null || Description.length() == 0) {
				map.put("msg", "描述不能为空");
				return map;
			}

			if (Source == null || Source.length() == 0) {
				map.put("msg", "原地址不能为空");
				return map;
			}

			if (Body == null || Body.length() == 0) {
				map.put("msg", "内容不能为空");
				return map;
			}

			if (Author == null || Author.length() == 0) {
				map.put("msg", "作者不能为空");
				return map;
			}

			String date = DateUtil.getCurrentDateHalf();
			Date date1 = null;
			try {
				date1 = DateUtil.StringToDate(date);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// 类型ID
			int typeID = 0;
			try {
				typeID = String_Convert.convertInteger(TypeID);
			} catch (Exception e) {
			}
			// 设置点击量
			int hit = 0;

			// 设置热度
			int hot = 0;

			short isBest = 0;
			short isNew = 0;

			short isSlide = 0;
			int userID = 0;
			int checkID = 0;
			// 国家ID
			short artState = 0;
			// 分页
			int artType = 1;

			String Body1 = "";
			String Body2 = "";
			String Remark = "";

			Edo_art_common_pojo ad = new Edo_art_common_pojo();
			ad.setTitle(Title);
			ad.setTitleSpell(TitleSpell);
			ad.setTitleWeb(TitleWeb);
			ad.setKeyWords(KeyWords);
			ad.setDescription(Description);
			ad.setTempShow(TempShow);
			ad.setSource(Source);
			ad.setBody(Body);
			ad.setBody1(Body1);
			ad.setBody2(Body2);
			ad.setTypeID(typeID);
			ad.setHit(hit);
			ad.setHot(hot);
			ad.setUrl(Url);
			ad.setIsBest(isBest);
			ad.setIsNew(isNew);
			ad.setIsSlide(isSlide);
			ad.setAuthor(Author);
			ad.setImg(Img);
			ad.setCDate(date1);
			ad.setUserID(userID);
			ad.setCheckID(checkID);
			ad.setArtState(artState);
			ad.setRemark(Remark);
			ad.setFileUrl(FileUrl);
			ad.setArtType(artType);

			int count = common_service.add(ad);

			if (count == 0) {
				// 执行错误
				map.put("msg", "未成功");
			} else {
				// 执行成功
				map.put("msg", "添加成功");
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

		// 改 返回jsp文件名
		@RequestMapping("/edit")
		public ModelAndView typeedit(int ID) {
			Edo_art_common_pojo list = common_service.getModel(ID);
			return new ModelAndView("edit", "date", list);
		}

		// 改
		@RequestMapping("/editsql")
		@ResponseBody
		public Map typeedit(@RequestParam("ID") int ID, @RequestParam("Title") String Title,
				@RequestParam("TitleWeb") String TitleWeb, @RequestParam("KeyWords") String KeyWords,
				@RequestParam("Description") String Description, @RequestParam("Source") String Source,
				@RequestParam("Url") String Url, @RequestParam("Author") String Author, @RequestParam("CDate") String CDate,
				@RequestParam("TypeID") String TypeID, @RequestParam("Img") String Img,
				@RequestParam("FileUrl") String FileUrl, @RequestParam("TempShow") String TempShow,
				@RequestParam("Body") String Body) {

			Map map = new HashMap();
			map.put("msg", "fail");

			String TitleSpell = null;
			if (Title == null || Title.length() == 0) {
				map.put("msg", "Title不能为空");
				return map;
			} else {
				TitleSpell = String_Convert.getPingYin(Title);
			}

			if (TitleWeb == null || TitleWeb.length() == 0) {
				map.put("msg", "TitleWeb不能为空");
				return map;
			}

			if (KeyWords == null || KeyWords.length() == 0) {
				map.put("msg", "关键字不能为空");
				return map;
			}

			if (Description == null || Description.length() == 0) {
				map.put("msg", "描述不能为空");
				return map;
			}

			if (Source == null || Source.length() == 0) {
				map.put("msg", "原地址不能为空");
				return map;
			}

			if (Body == null || Body.length() == 0) {
				map.put("msg", "内容不能为空");
				return map;
			}

			if (Author == null || Author.length() == 0) {
				map.put("msg", "作者不能为空");
				return map;
			}

			String date = DateUtil.getCurrentDateHalf();
			Date date1 = null;
			try {
				date1 = DateUtil.StringToDate(date);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// 类型ID
			int typeID = 0;
			try {
				typeID = String_Convert.convertInteger(TypeID);
			} catch (Exception e) {
			}
			// 设置点击量
			int hit = 0;

			// 设置热度
			int hot = 0;

			short isBest = 0;
			short isNew = 0;

			short isSlide = 0;
			int userID = 0;
			int checkID = 0;
			// 国家ID
			short artState = 0;
			// 分页
			int artType = 1;

			String Body1 = "";
			String Body2 = "";
			String Remark = "";

			Edo_art_common_pojo ad = new Edo_art_common_pojo();
			ad.setID(ID);
			ad.setTitle(Title);
			ad.setTitleSpell(TitleSpell);
			ad.setTitleWeb(TitleWeb);
			ad.setKeyWords(KeyWords);
			ad.setDescription(Description);
			ad.setTempShow(TempShow);
			ad.setSource(Source);
			ad.setBody(Body);
			ad.setBody1(Body1);
			ad.setBody2(Body2);
			ad.setTypeID(typeID);
			ad.setHit(hit);
			ad.setHot(hot);
			ad.setUrl(Url);
			ad.setIsBest(isBest);
			ad.setIsNew(isNew);
			ad.setIsSlide(isSlide);
			ad.setAuthor(Author);
			ad.setImg(Img);
			ad.setCDate(date1);
			ad.setUserID(userID);
			ad.setCheckID(checkID);
			ad.setArtState(artState);
			ad.setRemark(Remark);
			ad.setFileUrl(FileUrl);
			ad.setArtType(artType);

			int count = common_service.edit(ad);

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


}
