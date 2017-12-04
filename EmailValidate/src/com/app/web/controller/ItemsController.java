package com.app.web.controller;

//import java.util.ArrayList;
//import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;

//import cn.itheima.pojo.Items;

@Controller
public class ItemsController {

	@RequestMapping("/list")
	public String itemsList() throws Exception{
		//ModelAndView modelAndView = new ModelAndView();
		
		//modelAndView.addObject("itemList", itemList);
		
	//	modelAndView.setViewName("itemList");
		
	//	return modelAndView;
		return "success";

	}
}
