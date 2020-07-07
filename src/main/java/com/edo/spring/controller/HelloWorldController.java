package com.edo.spring.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Controller
public class HelloWorldController {
	@RequestMapping("/HelloSpring")
	public String pringHello() {
		return "hello";
	}

	@RequestMapping("/Spring1")
	public ModelAndView Temp1() {
		List<String> list = new ArrayList<String>();
		list.add("����");
		list.add("����");
		list.add("����");

		ModelAndView mv = new ModelAndView("Temp1");

		mv.addObject("list", list);
		return mv;
	}
	@RequestMapping(value = "/json1", produces = "application/json;charset=UTF-8") //�����producesֵ�ڲ����õ�����½����ݷ��ؽ���Զ�����
    public @ResponseBody
    ModelAndView checkNameValidMethod2(@RequestParam String name) {
        boolean result = true; 
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        map.put("valid", result);
        return new ModelAndView(new MappingJackson2JsonView(), map);
    }
}
