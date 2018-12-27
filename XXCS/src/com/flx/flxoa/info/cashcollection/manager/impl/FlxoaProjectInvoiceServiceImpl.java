package com.flx.flxoa.info.cashcollection.manager.impl;


import java.util.List;
import java.util.Map;

import com.flx.flxoa.info.cashcollection.entity.FlxoaCashcollectionClaimAffirm;
import com.flx.flxoa.info.cashcollection.entity.FlxoaProjectInvoice;
import com.flx.flxoa.info.cashcollection.manager.FlxoaProjectInvoiceService;
import com.flx.flxoa.info.cashcollection.dao.FlxoaProjectInvoiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * 类名称：FlxoaProjectInvoiceServiceImpl.java
 * 类描述：
 * 创建时间：2018-03-16, 下午06:54:26
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 赵鹏辉
 */ 
@Service
@Transactional
public class FlxoaProjectInvoiceServiceImpl implements FlxoaProjectInvoiceService {
	private FlxoaProjectInvoiceDao dao;
	@Autowired
	public void setDao(FlxoaProjectInvoiceDao dao) {
		this.dao = dao;
	}
	public FlxoaProjectInvoiceDao getDao() {
		return dao;
	}
	/**
	 *添加FlxoaProjectInvoice
	 */ 
	public boolean add(FlxoaProjectInvoice flxoaProjectInvoice) {
		boolean result = dao.add(flxoaProjectInvoice);
		return result;
	}
	/**
	 *删除FlxoaProjectInvoice
	 */ 
	public boolean delete(FlxoaProjectInvoice flxoaProjectInvoice) {
		boolean result = dao.delete(flxoaProjectInvoice);
		return result;
	}
	/**
	 *修改FlxoaProjectInvoice
	 */ 
	public boolean update(FlxoaProjectInvoice flxoaProjectInvoice) {
		boolean result = dao.update(flxoaProjectInvoice);
		return result;
	}
	/**
	 *查询FlxoaProjectInvoice列表
	 */ 
	public List<FlxoaProjectInvoice> query(FlxoaProjectInvoice flxoaProjectInvoice) {
		List<FlxoaProjectInvoice> list = dao.query(flxoaProjectInvoice);
		return list;
	}
	/**
	 *查询FlxoaProjectInvoice ByID
	 */ 
	public FlxoaProjectInvoice queryById(FlxoaProjectInvoice flxoaProjectInvoice) {
		FlxoaProjectInvoice result = dao.queryById(flxoaProjectInvoice);
		return result;
	}
	/**
	 *分页FlxoaProjectInvoice pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public String queryForPage(Map<String,String> map) {
		return dao.queryForPage(map);
	}
	/**
	 *查询FlxoaProjectInvoice数据条数
	 */ 
	public Long queryCount(FlxoaProjectInvoice flxoaProjectInvoice) {
		Long result = dao.queryCount(flxoaProjectInvoice);
		return result;
	}
}