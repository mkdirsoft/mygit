package com.flx.flxoa.info.clientsManagement.manager.impl;


import java.util.List;
import java.util.Map;

import com.flx.flxoa.common.util.CommonUtils;
import com.flx.flxoa.info.clientsManagement.entity.FlxoaClientContact;
import com.flx.flxoa.info.clientsManagement.manager.FlxoaClientContactService;
import com.flx.flxoa.info.clientsManagement.dao.FlxoaClientContactDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * 类名称：FlxoaClientContactServiceImpl.java
 * 类描述：
 * 创建时间：2018-09-05, 下午03:19:41
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 孙进 
 */ 
@Service
@Transactional
public class FlxoaClientContactServiceImpl implements FlxoaClientContactService {
	private FlxoaClientContactDao dao;
	@Autowired
	public void setDao(FlxoaClientContactDao dao) {
		this.dao = dao;
	}
	public FlxoaClientContactDao getDao() {
		return dao;
	}
	/**
	 *添加FlxoaClientContact
	 */ 
	public boolean add(FlxoaClientContact flxoaClientContact) {
		boolean result = dao.add(flxoaClientContact);
		return result;
	}
	/**
	 *删除FlxoaClientContact
	 */ 
	public boolean delete(FlxoaClientContact flxoaClientContact) {
		boolean result = dao.delete(flxoaClientContact);
		return result;
	}
	/**
	 *修改FlxoaClientContact
	 */ 
	public boolean update(FlxoaClientContact flxoaClientContact) {
		boolean result = dao.update(flxoaClientContact);
		return result;
	}
	/**
	 *查询FlxoaClientContact列表
	 */ 
	public List<FlxoaClientContact> query(FlxoaClientContact flxoaClientContact) {
		List<FlxoaClientContact> list = dao.query(flxoaClientContact);
		return list;
	}
	/**
	 *查询FlxoaClientContact ByID
	 */ 
	public FlxoaClientContact queryById(FlxoaClientContact flxoaClientContact) {
		FlxoaClientContact result = dao.queryById(flxoaClientContact);
		return result;
	}
	/**
	 *分页FlxoaClientContact pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public String queryForPage(Map<String,String> map) {
		return dao.queryForPage(map);
	}
	/**
	 *查询FlxoaClientContact数据条数
	 */ 
	public Long queryCount(FlxoaClientContact flxoaClientContact) {
		Long result = dao.queryCount(flxoaClientContact);
		return result;
	}

}