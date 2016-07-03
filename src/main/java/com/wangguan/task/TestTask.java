package com.wangguan.task;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wangguan.model.User;
import com.wangguan.service.back.BackUserService;
import com.wangguan.service.front.FrontUserService;

/**
 * 自定义定时任务
 * 
 * @author zhangtb
 * @date 2016-7-3 15:34:36
 * @since 1.0.0
 */
@Component
public class TestTask {

	private final static Log logger = LogFactory.getLog(TestTask.class);
	
	@Autowired
	private FrontUserService frontUserService;
	@Autowired
	private BackUserService backUserService;
	
	public void execute() {
		logger.info("同步开始...");
		
		User frontUser = frontUserService.getUser("test", "123456");
		logger.info(frontUser.toString());
		
		logger.info("--------------------------------------------------");
		
		User backUser = backUserService.getUser("admin", "123456");
		logger.info(backUser.toString());
		
		logger.info("同步结束...");
	}
	
}
