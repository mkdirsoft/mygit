package com.flx.flxoa.common.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 类名称：ExecuteTaskListener.java
 * 类描述：
 * 创建时间：2018-3-21, 上午11:31:00
 * 
 * @version 1.0 
 * @since JDK版本 1.7
 * @author 张海英
 */
public class ExecuteTaskListener implements ServletContextListener {
	
	public void contextInitialized(ServletContextEvent event) {
		new TimerManager();
	} 
	
	public void contextDestroyed(ServletContextEvent event) {
		
	}

}
