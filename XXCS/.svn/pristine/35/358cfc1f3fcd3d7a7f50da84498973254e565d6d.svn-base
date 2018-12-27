package com.flx.flxoa.info.signin.manager.impl;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import com.flx.flxoa.info.signin.entity.FlxoaAttendanceHolidayset;
import com.flx.flxoa.info.signin.manager.FlxoaAttendanceHolidaysetService;
import com.flx.flxoa.info.signin.dao.FlxoaAttendanceHolidaysetDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * 类名称：FlxoaAttendanceHolidaysetServiceImpl.java
 * 类描述：
 * 创建时间：2018-03-27, 上午11:04:09
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 张海英 
 */ 
@Service
@Transactional
public class FlxoaAttendanceHolidaysetServiceImpl implements FlxoaAttendanceHolidaysetService {
	private FlxoaAttendanceHolidaysetDao dao;
	@Autowired
	public void setDao(FlxoaAttendanceHolidaysetDao dao) {
		this.dao = dao;
	}
	public FlxoaAttendanceHolidaysetDao getDao() {
		return dao;
	}
	/**
	 *添加FlxoaAttendanceHolidayset
	 */ 
	public boolean add(FlxoaAttendanceHolidayset flxoaAttendanceHolidayset) {
		boolean result = dao.add(flxoaAttendanceHolidayset);
		return result;
	}
	/**
	 *删除FlxoaAttendanceHolidayset
	 */ 
	public boolean delete(FlxoaAttendanceHolidayset flxoaAttendanceHolidayset) {
		boolean result = dao.delete(flxoaAttendanceHolidayset);
		return result;
	}
	/**
	 *修改FlxoaAttendanceHolidayset
	 */ 
	public boolean update(FlxoaAttendanceHolidayset flxoaAttendanceHolidayset) {
		boolean result = dao.update(flxoaAttendanceHolidayset);
		return result;
	}
	/**
	 *查询FlxoaAttendanceHolidayset列表
	 */ 
	public List<FlxoaAttendanceHolidayset> query(FlxoaAttendanceHolidayset flxoaAttendanceHolidayset) {
		List<FlxoaAttendanceHolidayset> list = dao.query(flxoaAttendanceHolidayset);
		return list;
	}
	/**
	 *查询FlxoaAttendanceHolidayset ByID
	 */ 
	public FlxoaAttendanceHolidayset queryById(FlxoaAttendanceHolidayset flxoaAttendanceHolidayset) {
		FlxoaAttendanceHolidayset result = dao.queryById(flxoaAttendanceHolidayset);
		return result;
	}
	/**
	 *分页FlxoaAttendanceHolidayset pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<FlxoaAttendanceHolidayset> queryForPage(int pageNo,int pageSize,FlxoaAttendanceHolidayset flxoaAttendanceHolidayset) {
		List<FlxoaAttendanceHolidayset> list = dao.queryForPage(pageNo,pageSize,flxoaAttendanceHolidayset);
		return list;
	}
	/**
	 *查询FlxoaAttendanceHolidayset数据条数
	 */ 
	public Long queryCount(FlxoaAttendanceHolidayset flxoaAttendanceHolidayset) {
		Long result = dao.queryCount(flxoaAttendanceHolidayset);
		return result;
	}
	/**
	 * 查询每年中的所有节假日
	 */
	@Override
	public List<FlxoaAttendanceHolidayset> showAllHolidaysEveryYear(FlxoaAttendanceHolidayset flxoaAttendanceHolidayset) {
		return dao.queryByYear(flxoaAttendanceHolidayset);
	}
	/**
	 * 根据法定节假日查询记录
	 */
	@Override
	public FlxoaAttendanceHolidayset queryByLegalHolidays(
			FlxoaAttendanceHolidayset model) {
		return dao.queryByLegalHolidays(model);
	}
	/**
	 * 删除选中的节假日
	 */
	@Override
	public boolean deleteHoliday(FlxoaAttendanceHolidayset model) {
		return dao.deleteHoliday(model);
	}
}