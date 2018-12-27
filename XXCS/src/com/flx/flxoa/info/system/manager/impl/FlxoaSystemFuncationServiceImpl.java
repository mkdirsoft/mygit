package com.flx.flxoa.info.system.manager.impl;


import java.util.List;
import com.flx.flxoa.info.system.entity.FlxoaSystemFuncation;
import com.flx.flxoa.info.system.manager.FlxoaSystemFuncationService;
import com.flx.flxoa.info.system.dao.FlxoaSystemFuncationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * 类名称：FlxoaSystemFuncationServiceImpl.java
 * 类描述：
 * 创建时间：2018-03-18, 下午03:46:59
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 刘凯 
 */ 
@Service
@Transactional
public class FlxoaSystemFuncationServiceImpl implements FlxoaSystemFuncationService {
	private FlxoaSystemFuncationDao dao;
	@Autowired
	public void setDao(FlxoaSystemFuncationDao dao) {
		this.dao = dao;
	}
	public FlxoaSystemFuncationDao getDao() {
		return dao;
	}
	/**
	 *添加FlxoaSystemFuncation
	 */ 
	public boolean add(FlxoaSystemFuncation flxoaSystemFuncation) {
		boolean result = dao.add(flxoaSystemFuncation);
		return result;
	}
	/**
	 *删除FlxoaSystemFuncation
	 */ 
	public boolean delete(FlxoaSystemFuncation flxoaSystemFuncation) {
		boolean result = dao.delete(flxoaSystemFuncation);
		return result;
	}
	/**
	 *修改FlxoaSystemFuncation
	 */ 
	public boolean update(FlxoaSystemFuncation flxoaSystemFuncation) {
		boolean result = dao.update(flxoaSystemFuncation);
		return result;
	}
	/**
	 *查询FlxoaSystemFuncation列表
	 */ 
	public List<FlxoaSystemFuncation> query(FlxoaSystemFuncation flxoaSystemFuncation) {
		List<FlxoaSystemFuncation> list = dao.query(flxoaSystemFuncation);
		return list;
	}
	/**
	 *查询FlxoaSystemFuncation ByID
	 */ 
	public FlxoaSystemFuncation queryById(FlxoaSystemFuncation flxoaSystemFuncation) {
		FlxoaSystemFuncation result = dao.queryById(flxoaSystemFuncation);
		return result;
	}
	@Override
	public String queryButtonByPath(String listPath) {
		String result = dao.queryButtonByPath(listPath);
		return result;
	}
	@Override
	public int queryByMaxId() {
		int result = dao.queryByMaxId();
		return result;
	}

}