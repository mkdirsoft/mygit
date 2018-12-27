package com.flx.flxoa.info.signin.dao;


import java.util.List;
import java.util.Map;

import com.flx.flxoa.info.signin.entity.FlxoaAttendanceHolidayset;

/**
 *
 * 类名称：FlxoaAttendanceHolidaysetDao.java
 * 类描述：
 * 创建时间：2018-03-27, 上午11:04:09
 *
 *@version 1.0 
 *@since JDK版本1.7 
 *@author 张海英 
 */ 
public interface FlxoaAttendanceHolidaysetDao {
	/**
	 *添加FlxoaAttendanceHolidayset
	 */ 
	public boolean add(FlxoaAttendanceHolidayset flxoaAttendanceHolidayset);
	/**
	 *删除FlxoaAttendanceHolidayset
	 */ 
	public boolean delete(FlxoaAttendanceHolidayset flxoaAttendanceHolidayset);
	/**
	 *修改FlxoaAttendanceHolidayset
	 */ 
	public boolean update(FlxoaAttendanceHolidayset flxoaAttendanceHolidayset);
	/**
	 *查询FlxoaAttendanceHolidayset列表
	 */ 
	public List<FlxoaAttendanceHolidayset> query(FlxoaAttendanceHolidayset flxoaAttendanceHolidayset);
	/**
	 *查询FlxoaAttendanceHolidayset ByID
	 */ 
	public FlxoaAttendanceHolidayset queryById(FlxoaAttendanceHolidayset flxoaAttendanceHolidayset);
	/**
	 *分页FlxoaAttendanceHolidayset pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<FlxoaAttendanceHolidayset> queryForPage(int pageNo,int pageSize,FlxoaAttendanceHolidayset flxoaAttendanceHolidayset);
	/**
	 *查询FlxoaAttendanceHolidayset数据条数
	 */ 
	public Long queryCount(FlxoaAttendanceHolidayset flxoaAttendanceHolidayset);
	/**
	 * 查询每年中所有的节假日
	 * @param flxoaAttendanceHolidayset
	 * @return
	 */
	public List<FlxoaAttendanceHolidayset> queryByYear(
			FlxoaAttendanceHolidayset flxoaAttendanceHolidayset);
	/**
	 * 根据节假日查询记录
	 * @param model
	 * @return
	 */
	public FlxoaAttendanceHolidayset queryByLegalHolidays(FlxoaAttendanceHolidayset model);
	/**
	 * 删除选中的节假日
	 * @param model
	 * @return
	 */
	public boolean deleteHoliday(FlxoaAttendanceHolidayset model);
 }