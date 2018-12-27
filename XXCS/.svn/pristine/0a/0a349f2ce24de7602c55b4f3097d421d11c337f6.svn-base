package com.flx.flxoa.info.system.manager.impl;


import java.util.List;

import com.flx.flxoa.info.projectmanagement.entity.FlxoaProjectInformation;
import com.flx.flxoa.info.system.entity.FlxoaSystemRoleFuncation;
import com.flx.flxoa.info.system.manager.FlxoaSystemRoleFuncationService;
import com.flx.flxoa.info.system.dao.FlxoaSystemRoleFuncationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * 类名称：FlxoaSystemRoleFuncationServiceImpl.java
 * 类描述：
 * 创建时间：2018-03-28, 上午10:17:54
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 雷君 
 */ 
@Service
@Transactional
public class FlxoaSystemRoleFuncationServiceImpl implements FlxoaSystemRoleFuncationService {
	private FlxoaSystemRoleFuncationDao dao;
	@Autowired
	public void setDao(FlxoaSystemRoleFuncationDao dao) {
		this.dao = dao;
	}
	public FlxoaSystemRoleFuncationDao getDao() {
		return dao;
	}
	/**
	 *添加FlxoaSystemRoleFuncation
	 */ 
	public boolean add(FlxoaSystemRoleFuncation flxoaSystemRoleFuncation) {
		boolean result = dao.add(flxoaSystemRoleFuncation);
		return result;
	}
	/**
	 *删除FlxoaSystemRoleFuncation
	 */ 
	public boolean delete(FlxoaSystemRoleFuncation flxoaSystemRoleFuncation) {
		boolean result = dao.delete(flxoaSystemRoleFuncation);
		return result;
	}
	/**
	 *修改FlxoaSystemRoleFuncation
	 */ 
	public boolean update(FlxoaSystemRoleFuncation flxoaSystemRoleFuncation) {
		boolean result = dao.update(flxoaSystemRoleFuncation);
		return result;
	}
	/**
	 *查询FlxoaSystemRoleFuncation列表
	 */ 
	public List<FlxoaSystemRoleFuncation> query(FlxoaSystemRoleFuncation flxoaSystemRoleFuncation) {
		List<FlxoaSystemRoleFuncation> list = dao.query(flxoaSystemRoleFuncation);
		return list;
	}
	/**
	 *查询FlxoaProjectInformation列表
	 */ 
	public List<FlxoaSystemRoleFuncation> querySql(FlxoaSystemRoleFuncation flxoaSystemRoleFuncation) {
		List<FlxoaSystemRoleFuncation> list = dao.querySql(flxoaSystemRoleFuncation);
		return list;
	}
	/**
	 *查询FlxoaSystemRoleFuncation ByID
	 */ 
	public FlxoaSystemRoleFuncation queryById(FlxoaSystemRoleFuncation flxoaSystemRoleFuncation) {
		FlxoaSystemRoleFuncation result = dao.queryById(flxoaSystemRoleFuncation);
		return result;
	}
	/**
	 *分页FlxoaSystemRoleFuncation pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<FlxoaSystemRoleFuncation> queryForPage(int pageNo,int pageSize,FlxoaSystemRoleFuncation flxoaSystemRoleFuncation) {
		List<FlxoaSystemRoleFuncation> list = dao.queryForPage(pageNo,pageSize,flxoaSystemRoleFuncation);
		return list;
	}
	/**
	 *查询FlxoaSystemRoleFuncation数据条数
	 */ 
	public Long queryCount(FlxoaSystemRoleFuncation flxoaSystemRoleFuncation) {
		Long result = dao.queryCount(flxoaSystemRoleFuncation);
		return result;
	}
	/**
	 *删除FlxoaSystemRole
	 */ 
	public boolean deleteByName(FlxoaSystemRoleFuncation flxoaSystemRoleFuncation) {
		boolean result = dao.deleteByName(flxoaSystemRoleFuncation);
		return result;
	}


}