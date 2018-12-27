package com.flx.flxoa.info.signin.controller;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flx.flxoa.common.util.DateUtils;
import com.flx.flxoa.info.signin.entity.DoorCard;
import com.flx.flxoa.info.signin.entity.FlxoaAttendanceSigndetails;
import com.flx.flxoa.info.signin.entity.FlxoaAttendanceSummary;
import com.flx.flxoa.info.signin.manager.FlxoaAttendanceSigndetailsImportService;
import com.flx.flxoa.info.signin.manager.FlxoaAttendanceSigndetailsService;
import com.flx.flxoa.info.signin.manager.FlxoaAttendanceSummaryImportService;
import com.flx.flxoa.info.system.entity.FlxoaSystemUser;
import com.flx.flxoa.info.system.manager.FlxoaSystemUserService;

/**
 * 类名称：TestImport.java
 * 类描述：
 * 创建时间：2018-3-21, 上午4:28:50
 * 
 * @version 1.0 
 * @since JDK版本 1.7
 * @author 张海英
 */
@Controller
public class TestImport {
protected FlxoaAttendanceSigndetailsImportService flxoaAttendanceSigndetailsImportService;
protected FlxoaAttendanceSummaryImportService flxoaAttendanceSummaryImportService;	
protected FlxoaSystemUserService flxoaSystemUserService;
	@Autowired
	public void setFlxoaAttendanceSigndetailsImportService(
			FlxoaAttendanceSigndetailsImportService flxoaAttendanceSigndetailsImportService) {
		this.flxoaAttendanceSigndetailsImportService = flxoaAttendanceSigndetailsImportService;
	}

	@Autowired
	public void setFlxoaAttendanceSummaryImportService(
			FlxoaAttendanceSummaryImportService flxoaAttendanceSummaryImportService) {
		this.flxoaAttendanceSummaryImportService = flxoaAttendanceSummaryImportService;
	}
	@Autowired
	public void setFlxoaSystemUserService(
			FlxoaSystemUserService flxoaSystemUserService) {
		this.flxoaSystemUserService = flxoaSystemUserService;
	}

	@RequestMapping(value="/testImport",produces="text/html;charset=UTF-8")
	@ResponseBody
	public void testImport(HttpServletRequest request,HttpServletResponse response,FlxoaAttendanceSummary model) throws UnsupportedEncodingException, ParseException {
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
		flxoaAttendanceSigndetailsImportService.signdetailsImport(doorCard);
	}
	
	
	
	@RequestMapping(value="/testImport2",produces="text/html;charset=UTF-8")
	@ResponseBody
	public void testImport2(HttpServletRequest request,HttpServletResponse response,FlxoaAttendanceSummary model) throws UnsupportedEncodingException, ParseException {
		System.out.println("签到汇总表数据库导入开始。。。。。。。。。。。。。。");
		flxoaAttendanceSummaryImportService.summaryImport();
	}
	
	@RequestMapping(value="/userIdGetUser",produces="text/html;charset=UTF-8")
	@ResponseBody
	public void userIdGetUser(HttpServletRequest request,HttpServletResponse response,FlxoaAttendanceSummary model) throws UnsupportedEncodingException, ParseException {
		int userId =1;
		FlxoaSystemUser flxoaSystemUser = new FlxoaSystemUser();
		flxoaSystemUser.setCreateUserId(userId);
		FlxoaSystemUser usernew = flxoaSystemUserService.queryByUserId(flxoaSystemUser);
		System.out.println(usernew.getRealName());
		System.out.println(usernew.getEmail());
	}
}
