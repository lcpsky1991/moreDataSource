package com.wangguan.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wangguan.constant.GlobalSetConstant;
import com.wangguan.enums.UserType;
import com.wangguan.model.User;
import com.wangguan.service.back.BackUserService;
import com.wangguan.service.front.FrontUserService;
import com.wangguan.util.SessionUtil;
import com.wangguan.util.StringUtil;

/**
 * @author zhangtb
 * @date 2016-7-3 14:45:03
 * @since 1.0.0
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private FrontUserService frontUserService;
	@Autowired
	private BackUserService backUserService;
	
	/**
	 * 跳转到用户登录页面
	 * 
	 * @author zhangtb
	 * @date 2016-7-3 14:47:14
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/toLogin")
	public ModelAndView toLogin(HttpServletRequest request, ModelMap modelMap) {
		
		return new ModelAndView("user/login", modelMap);
	}
	
	/**
	 * 用户登录操作
	 * 
	 * @author zhangtb
	 * @date 2016-7-3 14:47:14
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/login")
	public ModelAndView login(HttpServletRequest request, ModelMap modelMap) {
		Integer type = StringUtil.toInt(request.getParameter("type"), 0);
		String username = StringUtil.toString(request.getParameter("username"), null);
		String password = StringUtil.toString(request.getParameter("password"), null);
		if(StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)) {
			if(type.equals(UserType.FRONT.getIndex())) {
				// 前台用户
				User user = frontUserService.getUser(username, password);
				if(user != null) {
					// 绑定到session
					SessionUtil.set(request, GlobalSetConstant.USER, user, GlobalSetConstant.cache);
					return new ModelAndView("redirect:/index", modelMap);
				}
			}
			if(type.equals(UserType.BACK.getIndex())) {
				// 后台用户
				User user = backUserService.getUser(username, password);
				if(user != null) {
					// 绑定到session
					SessionUtil.set(request, GlobalSetConstant.USER, user, GlobalSetConstant.cache);
					return new ModelAndView("redirect:/index", modelMap);
				}
			}
		}
		return new ModelAndView("user/login", modelMap);
	}

}
