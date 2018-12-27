package com.flx.flxoa.info.signin.manager;


import java.util.List;
import java.util.Map;

import com.flx.flxoa.info.signin.entity.FlxoaAttendanceSigndetails;
import com.flx.flxoa.info.signin.entity.FlxoaAttendanceSummary;
import com.flx.flxoa.info.system.entity.FlxoaSystemUser;

/**
 *
 * 类名称：FlxoaAttendanceSummaryService.java
 * 类描述：
 * 创建时间：2018-03-16, 下午02:52:37
 *
 *@version 1.0 
 *@since JDK版本1.7 
 *@author 张海英 
 */ 
public interface FlxoaAttendanceSummaryService {
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
	 *查询FlxoaAttendanceSummary ByID
	 */ 
	public FlxoaAttendanceSummary queryById(FlxoaAttendanceSummary flxoaAttendanceSummary);
	/**
	 * 分页
	 */
	public String queryForPage(int pageNo,int pageSize);
	/**
	 * 求和
	 * @return
	 */
	public Long queryCount(FlxoaAttendanceSummary flxoaAttendanceSummary);
	/**
	 * 根据sql 返回List
	 */
	public List<FlxoaAttendanceSummary> querySQL(FlxoaAttendanceSummary flxoaAttendanceSummary);
	/**
	 *  返回List
	 */
	public List<FlxoaAttendanceSummary> query(FlxoaAttendanceSummary flxoaAttendanceSummary);
	
	/**
	 * 根据userids查询部门内人员的考勤
	 */
	public List<FlxoaAttendanceSummary> queryByUserIds(FlxoaAttendanceSummary flxoaAttendanceSummary,String userIds);
	/**
	 * 查询当天考勤信息  FlxoaAttendanceSummary
	 */
	public List<FlxoaAttendanceSummary> queryCurrentSign(FlxoaAttendanceSummary summary,String userIds, String cardId,List<FlxoaSystemUser> cardList);
	/**
	 * 对两个数据库组成的List 进行分页
	 */
	public String queryPageSign(Map<String, String> map,List<FlxoaAttendanceSummary> dataList);
}