package com.flx.flxoa.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimerTask;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.flx.flxoa.info.signin.entity.DoorCard;
import com.flx.flxoa.info.signin.manager.FlxoaAttendanceSigndetailsImportService;
import com.flx.flxoa.info.signin.manager.FlxoaAttendanceSummaryImportService;

/**
 * 类名称：ExecuteTimerTask.java
 * 类描述：定时器
 * 创建时间：2018-3-21, 上午11:24:31
 * 
 * @version 1.0 
 * @since JDK版本 1.7
 * @author 张海英
 */
public class ExecuteTimerTask extends TimerTask{

	public ExecuteTimerTask() {}
	
	@Override
	public void run() {
		//得到Service Bean
		WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
		//得到 FlxoaAttendanceSigndetailsImportService
		String[] signdetailsImports = webApplicationContext.getBeanNamesForType(FlxoaAttendanceSigndetailsImportService.class);
		//得到 FlxoaAttendanceSummaryImportService
		String[] summaryImports = webApplicationContext.getBeanNamesForType(FlxoaAttendanceSummaryImportService.class);
		
		if(signdetailsImports!=null && summaryImports !=null){
			for(String x: signdetailsImports){
				System.out.println("signdetailsImports="+x);
				for (String y : summaryImports) {
					System.out.println("summaryImports"+y);
				}
			}
		}
		FlxoaAttendanceSigndetailsImportService signdetailsImportService =null;
		signdetailsImportService = (FlxoaAttendanceSigndetailsImportService)webApplicationContext.getBean("FlxoaAttendanceSigndetailsImportService");
		FlxoaAttendanceSummaryImportService summaryImportService =null;
		summaryImportService = (FlxoaAttendanceSummaryImportService)webApplicationContext.getBean("FlxoaAttendanceSummaryImportService");
		Date de = new Date();
		System.out.println("******************定时器开始运行******************");
		//SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
		//String date = sDateFormat.format(de);
		try {
	        Calendar startDT = Calendar.getInstance();  
			startDT.setTime(new Date());  
			startDT.add(Calendar.DAY_OF_MONTH, -1);
			String datetime=DateUtils.format(startDT.getTime(), "yyyy-MM-dd");
			//签到详情导入
			//获取前一天的开始时间和结束时间时间
			Date date=new Date();//取时间
			//24小时制
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    Calendar calendar = new GregorianCalendar();
		    calendar.setTime(date);
		    calendar.add(Calendar.DAY_OF_MONTH, -1);
		    calendar.set(Calendar.HOUR_OF_DAY,0);
		    calendar.set(Calendar.MINUTE,0);
		    calendar.set(Calendar.SECOND,0);
		    calendar.set(Calendar.MILLISECOND,0);
		    String startTime = format.format(calendar.getTime()); 
		    System.out.println("开始时间："+startTime);
		    calendar.set(Calendar.HOUR,23);
		    calendar.set(Calendar.MINUTE,59);
		    calendar.set(Calendar.SECOND,59);
		    calendar.set(Calendar.MILLISECOND,999);
		    String endTime = format.format(calendar.getTime()); 
		    System.out.println("结束时间："+ endTime);
		    //将开始时间和结束时间set到DoorCard对象中
			DoorCard doorCard = new DoorCard();
			doorCard.setStartTime(startTime);
			doorCard.setEndTime(endTime);
			System.out.println("考勤详情表数据导入开始。。。。。。。。。。。。。。。。。");
			signdetailsImportService.signdetailsImport(doorCard);
			
			//签到汇总表数据库导入
			System.out.println("签到汇总表数据库导入开始。。。。。。。。。。。。。。");
			summaryImportService.summaryImport();
			System.out.println("******************定时器运行结束******************");
		} catch (Exception e) {
			System.out.println("考勤记录导入出现错误：");
			e.printStackTrace();
		}
		
	}

}
