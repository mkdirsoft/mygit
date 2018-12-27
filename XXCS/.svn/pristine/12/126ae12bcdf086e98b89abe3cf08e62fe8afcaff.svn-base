package com.flx.flxoa.info.market.manager.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flx.flxoa.info.market.dao.HxCropsourceDao;
import com.flx.flxoa.info.market.entity.HxCropsource;
import com.flx.flxoa.info.market.manager.HxCropsourceService;


/**
 *
 * 类名称：HxCropsourceServiceImpl.java
 * 类描述：
 * 创建时间：2018-11-08, 下午03:05:40
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author leijun 
 */ 
@Service
@Transactional
public class HxCropsourceServiceImpl implements HxCropsourceService {
	private HxCropsourceDao dao;
	@Autowired
	public void setDao(HxCropsourceDao dao) {
		this.dao = dao;
	}
	public HxCropsourceDao getDao() {
		return dao;
	}
	/**
	 *添加HxCropsource
	 */ 
	public boolean add(HxCropsource hxCropsource) {
		boolean result = dao.add(hxCropsource);
		return result;
	}
	/**
	 *删除HxCropsource
	 */ 
	public boolean delete(HxCropsource hxCropsource) {
		boolean result = dao.delete(hxCropsource);
		return result;
	}
	/**
	 *修改HxCropsource
	 */ 
	public boolean update(HxCropsource hxCropsource) {
		boolean result = dao.update(hxCropsource);
		return result;
	}
	/**
	 *查询HxCropsource列表
	 */ 
	public List<HxCropsource> query(HxCropsource hxCropsource) {
		List<HxCropsource> list = dao.query(hxCropsource);
		return list;
	}
	/**
	 *查询HxCropsource ByID
	 */ 
//	public HxCropsource queryById(HxCropsource hxCropsource) {
//		HxCropsource result = dao.queryById(hxCropsource);
//		return result;
//	}
	/**
	 *分页HxCropsource pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<HxCropsource> queryForPage(int pageNo,int pageSize,HxCropsource hxCropsource) {
		List<HxCropsource> list = dao.queryForPage(pageNo,pageSize,hxCropsource);
		return list;
	}
	/**
	 *查询HxCropsource数据条数
	 */ 
	public Long queryCount(HxCropsource hxCropsource) {
		Long result = dao.queryCount(hxCropsource);
		return result;
	}

}