package com.flx.flxoa.info.signin.dao;


import java.util.List;

import java.util.Map;
import com.flx.flxoa.info.signin.entity.FlxoaAttendanceSpecialtimeset;

/**
 *
 * 类名称：FlxoaAttendanceSpecialtimesetDao.java
 * 类描述：
 * 创建时间：2018-03-26, 下午02:36:07
 *
 *@version 1.0 
 *@since JDK版本1.7 
 *@author 夏改翠 
 */ 
public interface FlxoaAttendanceSpecialtimesetDao {
	/**
	 *添加FlxoaAttendanceSpecialtimeset
	 */ 
	public boolean add(FlxoaAttendanceSpecialtimeset flxoaAttendanceSpecialtimeset);
	/**
	 *删除FlxoaAttendanceSpecialtimeset
	 */ 
	public boolean delete(FlxoaAttendanceSpecialtimeset flxoaAttendanceSpecialtimeset);
	/**
	 *修改FlxoaAttendanceSpecialtimeset
	 */ 
	public boolean update(FlxoaAttendanceSpecialtimeset flxoaAttendanceSpecialtimeset);
	/**
	 *查询FlxoaAttendanceSpecialtimeset列表
	 */ 
	public List<FlxoaAttendanceSpecialtimeset> query(FlxoaAttendanceSpecialtimeset flxoaAttendanceSpecialtimeset);
	/**
	 *查询FlxoaAttendanceSpecialtimeset ByID
	 */ 
	public FlxoaAttendanceSpecialtimeset queryById(FlxoaAttendanceSpecialtimeset flxoaAttendanceSpecialtimeset);
	/**
	 *分页FlxoaAttendanceSpecialtimeset pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<FlxoaAttendanceSpecialtimeset> queryForPage(int pageNo,int pageSize,FlxoaAttendanceSpecialtimeset flxoaAttendanceSpecialtimeset);
	/**
	 *查询FlxoaAttendanceSpecialtimeset数据条数
	 */ 
	public Long queryCount(FlxoaAttendanceSpecialtimeset flxoaAttendanceSpecialtimeset);
	/**
	 * 查询FlxoaAttendanceSpecialtimeset 包括今天的特殊时间
	 */
	public List<FlxoaAttendanceSpecialtimeset> queryToday(int date,List<String> statusList,List<String> detailsList);
	
	/**
	 * 分页查询
	 * @return
	 */
	public String querySpecialtimeset(Map<String,String> map);
 }