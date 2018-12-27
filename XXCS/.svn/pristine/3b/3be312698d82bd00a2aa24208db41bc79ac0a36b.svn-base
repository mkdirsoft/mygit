package com.flx.flxoa.info.signin.dao.impl;


import java.util.List;
import java.util.Map;

import com.flx.flxoa.info.approve.entity.FlxoaApproveFormdata;
import com.flx.flxoa.info.signin.entity.FlxoaAttendanceHolidayset;
import com.flx.flxoa.info.signin.dao.FlxoaAttendanceHolidaysetDao;
import org.springframework.stereotype.Repository;
import com.flx.flxoa.common.hibernate3.HibernateBaseDao;

/**
 *
 * 类名称：FlxoaAttendanceHolidaysetDaoImpl.java
 * 类描述：
 * 创建时间：2018-03-27, 上午11:04:09
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 张海英 
 */ 
@Repository
public class FlxoaAttendanceHolidaysetDaoImpl extends HibernateBaseDao<FlxoaAttendanceHolidayset, Integer> implements FlxoaAttendanceHolidaysetDao {
	/**
	 *添加FlxoaAttendanceHolidayset
	 */ 
	public boolean add(FlxoaAttendanceHolidayset flxoaAttendanceHolidayset) {
		return save(flxoaAttendanceHolidayset);
	}
	/**
	 *删除FlxoaAttendanceHolidayset
	 */ 
	public boolean delete(FlxoaAttendanceHolidayset flxoaAttendanceHolidayset) {
		flxoaAttendanceHolidayset.setDeleteFlag("1");
		return save(flxoaAttendanceHolidayset);
	}
	/**
	 *修改FlxoaAttendanceHolidayset
	 */ 
	public boolean update(FlxoaAttendanceHolidayset flxoaAttendanceHolidayset) {
		return modify(flxoaAttendanceHolidayset);
	}
	/**
	 *查询FlxoaAttendanceHolidayset列表
	 */ 
	public List<FlxoaAttendanceHolidayset> query(FlxoaAttendanceHolidayset flxoaAttendanceHolidayset) {
		String hql = " from FlxoaAttendanceHolidayset where delete_flag = '0' ";
		return getListByHQL(hql, null);
	}
	/**
	 *查询FlxoaAttendanceHolidayset ByID
	 */ 
	public FlxoaAttendanceHolidayset queryById(FlxoaAttendanceHolidayset flxoaAttendanceHolidayset) {
		return get(flxoaAttendanceHolidayset.getId());
	}
	/**
	 *分页FlxoaAttendanceHolidayset pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<FlxoaAttendanceHolidayset> queryForPage(int pageNo,int pageSize,FlxoaAttendanceHolidayset flxoaAttendanceHolidayset) {
		String hql = " from FlxoaAttendanceHolidayset where delete_flag = '0' ";
		return queryForPageByHQL(pageNo, pageSize, hql);
	}
	/**
	 *查询FlxoaAttendanceHolidayset数据条数 
	 */ 
	public Long queryCount(FlxoaAttendanceHolidayset flxoaAttendanceHolidayset) {
		String hql = "select count(*) from FlxoaAttendanceHolidayset where delete_flag = '0' ";
		return countByHql(hql,null);
	}
	/**
	 * 查询每年中所有的节假日
	 */
	@Override
	public List<FlxoaAttendanceHolidayset> queryByYear(FlxoaAttendanceHolidayset flxoaAttendanceHolidayset) {
		String hql = " from FlxoaAttendanceHolidayset where delete_flag = '0'and years=?";
		Object [] obj = {flxoaAttendanceHolidayset.getYears()};
		List<FlxoaAttendanceHolidayset> list = getListByHQL(hql, obj);
		return list;
	}
	@Override
	protected Class<FlxoaAttendanceHolidayset> getEntityClass() {
		return FlxoaAttendanceHolidayset.class;
	}
	/**
	 * 根据节假日查询记录
	 */
	@Override
	public FlxoaAttendanceHolidayset queryByLegalHolidays(FlxoaAttendanceHolidayset model) {
		String hql = " from FlxoaAttendanceHolidayset where delete_flag = '0'and legal_holidays=?";
		Object [] obj = {model.getLegalHolidays()};
		FlxoaAttendanceHolidayset holidayset =getByHQL(hql, obj);
		return holidayset;
	}
	/**
	 * 删除选中的节假日
	 * @param flxoaAttendanceHolidayset
	 * @return
	 */
	@Override
	public boolean deleteHoliday(FlxoaAttendanceHolidayset model) {
		String hql = " delete FlxoaAttendanceHolidayset where legal_holidays=?";
		Object [] obj = {model.getLegalHolidays()};
		queryHql(hql,obj);
		return true;
	}
}