package com.flx.flxoa.common.util;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.Timer;

/**
 * 类名称：TimerManager.java
 * 类描述：设定执行的时间
 * 创建时间：2018-3-21, 上午11:33:18
 * 
 * @version 1.0 
 * @since JDK版本 1.7
 * @author 张海英
 */
public class TimerManager {
	//时间间隔 1天（86400秒）
	private static final long PERIOD_DAY = 24 * 60 * 60 * 1000; 
	
	/*
	 * 定制每日4:00执行方法
	 */
	public TimerManager() {
		Calendar calendar = Calendar.getInstance();
		//获取当地时区
		TimeZone zone = TimeZone.getTimeZone("GMT+8");
		TimeZone.setDefault(zone);
		calendar.setTimeZone(zone);
		calendar.set(Calendar.HOUR_OF_DAY, 4);  
		calendar.set(Calendar.MINUTE, 0);  
		calendar.set(Calendar.SECOND, 0);
		//执行定时任务的时间
		Date date = calendar.getTime();
		
		Timer timer = new Timer();
		ExecuteTimerTask task = new ExecuteTimerTask();
		
		if (date.before(new Date())) {  
			date = this.addDay(date, 1);
		}
		//安排指定的任务在指定的时间开始进行重复的固定延迟执行。
		timer.schedule(task,date,PERIOD_DAY);
	}
	
		// 增加或减少天数
		public Date addDay(Date date, int num) {  
		   Calendar startDT = Calendar.getInstance();  
		   startDT.setTime(date);  
		   startDT.add(Calendar.DAY_OF_MONTH, num);  
		   return startDT.getTime();  
		}  
}
