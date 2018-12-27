package com.flx.flxoa.info.signin.manager.impl;


import java.util.List;
import java.util.Map;

import com.flx.flxoa.info.signin.entity.FlxoaAttendanceSpecialtimeset;
import com.flx.flxoa.info.signin.manager.FlxoaAttendanceSpecialtimesetService;
import com.flx.flxoa.info.signin.dao.FlxoaAttendanceSpecialtimesetDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * 类名称：FlxoaAttendanceSpecialtimesetServiceImpl.java
 * 类描述：
 * 创建时间：2018-03-26, 下午02:36:07
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 夏改翠 
 */ 
@Service
@Transactional
public class FlxoaAttendanceSpecialtimesetServiceImpl implements FlxoaAttendanceSpecialtimesetService {
	private FlxoaAttendanceSpecialtimesetDao dao;
	@Autowired
	public void setDao(FlxoaAttendanceSpecialtimesetDao dao) {
		this.dao = dao;
	}
	public FlxoaAttendanceSpecialtimesetDao getDao() {
		return dao;
	}
	/**
	 *添加FlxoaAttendanceSpecialtimeset
	 */ 
	public boolean add(FlxoaAttendanceSpecialtimeset flxoaAttendanceSpecialtimeset) {
		boolean result = dao.add(flxoaAttendanceSpecialtimeset);
		return result;
	}
	/**
	 *删除FlxoaAttendanceSpecialtimeset
	 */ 
	public boolean delete(FlxoaAttendanceSpecialtimeset flxoaAttendanceSpecialtimeset) {
		boolean result = dao.delete(flxoaAttendanceSpecialtimeset);
		return result;
	}
	/**
	 *修改FlxoaAttendanceSpecialtimeset
	 */ 
	public boolean update(FlxoaAttendanceSpecialtimeset flxoaAttendanceSpecialtimeset) {
		boolean result = dao.update(flxoaAttendanceSpecialtimeset);
		return result;
	}
	/**
	 *查询FlxoaAttendanceSpecialtimeset列表
	 */ 
	public List<FlxoaAttendanceSpecialtimeset> query(FlxoaAttendanceSpecialtimeset flxoaAttendanceSpecialtimeset) {
		List<FlxoaAttendanceSpecialtimeset> list = dao.query(flxoaAttendanceSpecialtimeset);
		return list;
	}
	/**
	 *查询FlxoaAttendanceSpecialtimeset ByID
	 */ 
	public FlxoaAttendanceSpecialtimeset queryById(FlxoaAttendanceSpecialtimeset flxoaAttendanceSpecialtimeset) {
		FlxoaAttendanceSpecialtimeset result = dao.queryById(flxoaAttendanceSpecialtimeset);
		return result;
	}
	/**
	 *分页FlxoaAttendanceSpecialtimeset pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<FlxoaAttendanceSpecialtimeset> queryForPage(int pageNo,int pageSize,FlxoaAttendanceSpecialtimeset flxoaAttendanceSpecialtimeset) {
		List<FlxoaAttendanceSpecialtimeset> list = dao.queryForPage(pageNo,pageSize,flxoaAttendanceSpecialtimeset);
		return list;
	}
	/**
	 *查询FlxoaAttendanceSpecialtimeset数据条数
	 */ 
	public Long queryCount(FlxoaAttendanceSpecialtimeset flxoaAttendanceSpecialtimeset) {
		Long result = dao.queryCount(flxoaAttendanceSpecialtimeset);
		return result;
	}
	@Override
	public String querySpecialtimeset(Map<String, String> map) {
		
		return dao.querySpecialtimeset(map);
	}
	

}