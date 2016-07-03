package com.wangguan.service.front.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wangguan.dao.front.FrontUserDao;
import com.wangguan.enums.UserType;
import com.wangguan.model.User;
import com.wangguan.service.front.FrontUserService;
import com.wangguan.util.MD5Util;

/**
 * @author zhangtb
 * @date 2016-7-3 14:37:23
 * @since 1.0.0
 */
@Service
public class FrontUserServiceImpl implements FrontUserService {
	
	@Autowired
	private FrontUserDao userDao;

	@Override
	public User getUser(String username, String password) {
		Map<String, Object> whereMap = new HashMap<String, Object>();
		whereMap.put("username", username);
		whereMap.put("password", MD5Util.encode(password));
		whereMap.put("type", UserType.FRONT.getIndex());
		return userDao.getUser(whereMap);
	}

}
