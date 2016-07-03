package com.wangguan.service.front;

import com.wangguan.model.User;

/**
 * @author zhangtb
 * @date 2016-7-3 14:37:23
 * @since 1.0.0
 */
public interface FrontUserService {
	
	/**
	 * 查询用户
	 * 
	 * @author zhangtb
	 * @date 2016-7-3 15:04:59
	 * @param username 用户名
	 * @param password 密码
	 * @return
	 */
	User getUser(String username, String password);

}
