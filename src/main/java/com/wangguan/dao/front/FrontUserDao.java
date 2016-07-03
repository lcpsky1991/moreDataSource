package com.wangguan.dao.front;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.wangguan.dao.BaseDao;
import com.wangguan.model.User;

/**
 * @author zhangtb
 * @date 2016-7-3 14:21:54
 * @since 1.0.0
 */
@Repository
public interface FrontUserDao extends BaseDao {
	
	/**
	 * @param whereMap 查询条件字段封装
	 * @return
	 */
	User getUser(Map<String, Object> whereMap);

}
