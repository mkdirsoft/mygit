package com.flx.flxoa.info.signin.dao;

import java.util.List;

import com.flx.flxoa.info.signin.entity.FlxoaAttendanceSigndetails;

/**
 * 类名称：FlxoaAttendanceSummaryImportDao.java
 * 类描述：考勤汇总数据库导入接口
 * 创建时间：2018-3-22, 上午10:04:14
 * 
 * @version 1.0 
 * @since JDK版本 1.7
 * @author 张海英
 */
public interface FlxoaAttendanceSummaryImportDao {
	
	/*
	 * 查询签到详情表中的数据的最早签到记录
	 */
	public List<FlxoaAttendanceSigndetails> querySignDetailsEarliest();
	/*
	 * 查询签到详情表中的数据的最晚签到记录
	 */
	public List<FlxoaAttendanceSigndetails> querySignDetailsLatest();
}
