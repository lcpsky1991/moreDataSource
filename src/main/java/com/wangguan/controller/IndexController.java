package com.wangguan.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wangguan.service.back.BackUserService;
import com.wangguan.service.front.FrontUserService;

/**
 * @author zhangtb
 * @date 2016-7-3 14:45:03
 * @since 1.0.0
 */
@Controller
public class IndexController {
	
	@Autowired
	private FrontUserService frontUserService;
	@Autowired
	private BackUserService backUserService;
	
	/**
	 * 返回系统主页
	 * 
	 * @author zhangtb
	 * @date 2016-7-3 14:47:14
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/index")
	public ModelAndView index(HttpServletRequest request, ModelMap modelMap) {
		System.out.println("主页...");
		return new ModelAndView("index", modelMap);
	}

}
