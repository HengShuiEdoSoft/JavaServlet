package com.hsedo.onepiece.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hsedo.onepiece.iservice.Edo_Art_Common_iservice;
import com.hsedo.onepiece.pojo.Edo_Art_Common_pojo;


@Controller
@RequestMapping("/stus")
public class StudentsController {
	private static Logger logger = Logger.getLogger(StudentsController.class);

	public StudentsController() {
	}

	@Autowired
	@Qualifier("Edo_Art_Common_service")
	private Edo_Art_Common_iservice common_service;

	@RequestMapping("/listsql")
	public ModelAndView StudentsList() {
		Map map = new HashMap();
		List<Edo_Art_Common_pojo> list = common_service.selectList(map);
		return new ModelAndView("list2", "stulist", list); 
	}
}







