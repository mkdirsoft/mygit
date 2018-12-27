package com.flx.flxoa.info.signin.dao;


import java.util.List;
import java.util.Map;

import com.flx.flxoa.info.signin.entity.FlxoaAttendanceSummary;

/**
 *
 * 类名称：FlxoaAttendanceSummaryDao.java
 * 类描述：
 * 创建时间：2018-03-16, 下午02:52:37
 *
 *@version 1.0 
 *@since JDK版本1.7 
 *@author 张海英 
 */ 
public interface FlxoaAttendanceSummaryDao {
	/**
	 *添加FlxoaAttendanceSummary
	 */ 
	public boolean add(FlxoaAttendanceSummary flxoaAttendanceSummary);
	/**
	 *删除FlxoaAttendanceSummary
	 */ 
	public boolean delete(FlxoaAttendanceSummary flxoaAttendanceSummary);
	/**
	 *修改FlxoaAttendanceSummary
	 */ 
	public boolean update(FlxoaAttendanceSummary flxoaAttendanceSummary);
	/**
	 *查询FlxoaAttendanceSummary列表
	 */ 
	public List<FlxoaAttendanceSummary> query(FlxoaAttendanceSummary flxoaAttendanceSummary,int pageNo,int pageSize);
	/**
	 * 分页
	 */
	public String queryForPage(int pageNo,int pageSize);
	/**
	 *求和
	 */ 
	public Long queryCount(FlxoaAttendanceSummary flxoaAttendanceSummary);
	/**
	 *查询FlxoaAttendanceSummary ByID
	 */ 
	public FlxoaAttendanceSummary queryById(FlxoaAttendanceSummary flxoaAttendanceSummary);
	/**
	 *查询FlxoaAttendanceSummary列表
	 */ 
	public List<FlxoaAttendanceSummary> querySql(FlxoaAttendanceSummary flxoaAttendanceSummary);
	/**
	 * 查询FlxoaAttendanceSummary列表
	 */
	public List<FlxoaAttendanceSummary> query(FlxoaAttendanceSummary flxoaAttendanceSummary);	
	/**
	 * 查询部门内人员的考勤信息 ，根据userids
	 * @param userIds
	 * @return
	 */
	public List<FlxoaAttendanceSummary> queryByUserIds(FlxoaAttendanceSummary flxoaAttendanceSummary,String userIds);
	/**
	 * 查询FlxoaAttendanceSigndetails  当天手机签到的列表
	 */
	public List<FlxoaAttendanceSummary> queryTodayRecord(FlxoaAttendanceSummary summary, String userIds,int morningTime);
	
	/**
	 * 导入汇总表的数据
	 */
	public List<FlxoaAttendanceSummary> queryYesterdayImport();
}