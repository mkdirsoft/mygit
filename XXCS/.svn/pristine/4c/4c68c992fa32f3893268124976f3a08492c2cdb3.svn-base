package com.flx.flxoa.info.signin.dao;


import java.util.List;

import com.flx.flxoa.info.signin.entity.DoorCard;
import com.flx.flxoa.info.signin.entity.FlxoaAttendanceSigndetails;

/**
 *
 * 类名称：FlxoaAttendanceSigndetailsDao.java
 * 类描述：
 * 创建时间：2018-03-16, 下午02:52:37
 *
 *@version 1.0 
 *@since JDK版本1.7 
 *@author 张海英 
 */ 
public interface FlxoaAttendanceSigndetailsDao {
	/**
	 *添加FlxoaAttendanceSigndetails
	 */ 
	public boolean add(FlxoaAttendanceSigndetails flxoaAttendanceSigndetails);
	/**
	 *删除FlxoaAttendanceSigndetails
	 */ 
	public boolean delete(FlxoaAttendanceSigndetails flxoaAttendanceSigndetails);
	/**
	 *修改FlxoaAttendanceSigndetails
	 */ 
	public boolean update(FlxoaAttendanceSigndetails flxoaAttendanceSigndetails);
	/**
	 *查询FlxoaAttendanceSigndetails列表
	 */ 
	public List<FlxoaAttendanceSigndetails> query(FlxoaAttendanceSigndetails flxoaAttendanceSigndetails);
	/**
	 *查询FlxoaAttendanceSigndetails ByID
	 */ 
	public FlxoaAttendanceSigndetails queryById(FlxoaAttendanceSigndetails flxoaAttendanceSigndetails);
	/**
	 * 查询FlxoaAttendanceSigndetails  当天手机签到的列表
	 */
	public List<FlxoaAttendanceSigndetails> queryTodayRecord(String userIds,int morningTime);
	/**
	 * 查询签到明细
	 * @param flxoaAttendanceSigndetails
	 * @return
	 */
	public List<FlxoaAttendanceSigndetails> querySignDetail(
			FlxoaAttendanceSigndetails flxoaAttendanceSigndetails);
	
	
}