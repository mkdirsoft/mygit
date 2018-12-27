package com.flx.flxoa.info.market.manager.impl;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flx.flxoa.info.market.dao.HxCropcategoryDao;
import com.flx.flxoa.info.market.entity.HxCropcategory;
import com.flx.flxoa.info.market.manager.HxCropcategoryService;

/**
 *
 * 类名称：HxCropcategoryServiceImpl.java
 * 类描述：
 * 创建时间：2018-11-02, 上午11:02:11
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author leijun 
 */ 
@Service
@Transactional
public class HxCropcategoryServiceImpl implements HxCropcategoryService {
	private HxCropcategoryDao dao;
	@Autowired
	public void setDao(HxCropcategoryDao dao) {
		this.dao = dao;
	}
	public HxCropcategoryDao getDao() {
		return dao;
	}
	/**
	 *添加HxCropcategory
	 */ 
	public boolean add(HxCropcategory hxCropcategory) {
		boolean result = dao.add(hxCropcategory);
		return result;
	}
	/**
	 *删除HxCropcategory
	 */ 
	public boolean delete(HxCropcategory hxCropcategory) {
		boolean result = dao.delete(hxCropcategory);
		return result;
	}
	/**
	 *修改HxCropcategory
	 */ 
	public boolean update(HxCropcategory hxCropcategory) {
		boolean result = dao.update(hxCropcategory);
		return result;
	}
	/**
	 *查询HxCropcategory列表
	 */ 
	public List<HxCropcategory> query(HxCropcategory hxCropcategory) {
		List<HxCropcategory> list = dao.query(hxCropcategory);
		return list;
	}
	/**
	 *查询HxCropcategory ByID
	 */ 
	public HxCropcategory queryById(HxCropcategory hxCropcategory) {
		HxCropcategory result = dao.queryById(hxCropcategory);
		return result;
	}
	/**
	 *分页HxCropcategory pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<HxCropcategory> queryForPage1(int pageNo,int pageSize,HxCropcategory hxCropcategory) {
		List<HxCropcategory> list = dao.queryForPage1(pageNo,pageSize,hxCropcategory);
		return list;
	}
	/**
	 *分页HxCropcategory pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public String queryForPage(Map<String,String> map) {
		String list = dao.queryForPage(map);
		return list;
	}
	
	/**
	 *查询HxCropcategory数据条数
	 */ 
	public Long queryCount(HxCropcategory hxCropcategory) {
		Long result = dao.queryCount(hxCropcategory);
		return result;
	}

}