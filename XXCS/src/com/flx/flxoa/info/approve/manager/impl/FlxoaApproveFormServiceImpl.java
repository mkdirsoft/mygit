package com.flx.flxoa.info.approve.manager.impl;


import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.flx.flxoa.info.approve.entity.FlxoaApproveForm;
import com.flx.flxoa.info.approve.manager.FlxoaApproveFormService;
import com.flx.flxoa.info.approve.dao.FlxoaApproveFormDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * 类名称：FlxoaApproveFormServiceImpl.java
 * 类描述：
 * 创建时间：2018-03-23, 下午04:41:33
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 刘凯 
 */ 
@Service
@Transactional
public class FlxoaApproveFormServiceImpl implements FlxoaApproveFormService {
	private FlxoaApproveFormDao dao;
	@Autowired
	public void setDao(FlxoaApproveFormDao dao) {
		this.dao = dao;
	}
	public FlxoaApproveFormDao getDao() {
		return dao;
	}
	/**
	 *添加FlxoaApproveForm
	 */ 
	public boolean add(FlxoaApproveForm flxoaApproveForm) {
		boolean result = dao.add(flxoaApproveForm);
		return result;
	}
	/**
	 *删除FlxoaApproveForm
	 */ 
	public boolean delete(FlxoaApproveForm flxoaApproveForm) {
		boolean result = dao.delete(flxoaApproveForm);
		return result;
	}
	/**
	 *修改FlxoaApproveForm
	 */ 
	public boolean update(FlxoaApproveForm flxoaApproveForm) {
		boolean result = dao.update(flxoaApproveForm);
		return result;
	}
	/**
	 *查询FlxoaApproveForm列表
	 */ 
	public ConcurrentHashMap<String, Object> query(String start,String length,FlxoaApproveForm flxoaApproveForm) {
		ConcurrentHashMap<String, Object> map = dao.query(start,length,flxoaApproveForm);
		return map;
	}
	/**
	 *查询FlxoaApproveForm列表
	 */ 
	public List<FlxoaApproveForm> query(FlxoaApproveForm flxoaApproveForm) {
		List<FlxoaApproveForm> list = dao.query(flxoaApproveForm);
		return list;
	}
	/**
	 *查询FlxoaApproveForm ByID
	 */ 
	public FlxoaApproveForm queryById(FlxoaApproveForm flxoaApproveForm) {
		FlxoaApproveForm result = dao.queryById(flxoaApproveForm);
		return result;
	}
	/**
	 *分页FlxoaApproveForm pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<FlxoaApproveForm> queryForPage(int pageNo,int pageSize,FlxoaApproveForm flxoaApproveForm) {
		List<FlxoaApproveForm> list = dao.queryForPage(pageNo,pageSize,flxoaApproveForm);
		return list;
	}
	/**
	 *查询FlxoaApproveForm数据条数
	 */ 
	public Long queryCount(FlxoaApproveForm flxoaApproveForm) {
		Long result = dao.queryCount(flxoaApproveForm);
		return result;
	}
	/**
	 *查询 审批记录详情  FlxoaApproveForm 
	 */ 	
	@Override
	public List<FlxoaApproveForm> queryApproveFormLog(
			FlxoaApproveForm flxoaApproveForm) {
		List<FlxoaApproveForm> list = dao.queryApproveFormLog(flxoaApproveForm);
		return list;
	}
	@Override
	public List<FlxoaApproveForm> queryChechUserApproveFormLog(
			FlxoaApproveForm flxoaApproveForm) {
		List<FlxoaApproveForm> list = dao.queryChechUserApproveFormLog(flxoaApproveForm);
		return list;
	}

}