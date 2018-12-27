package com.flx.flxoa.info.market.manager.impl;

import java.util.List;
import com.flx.flxoa.info.market.entity.HxNewscategory;
import com.flx.flxoa.info.market.manager.HxNewscategoryService;
import com.flx.flxoa.info.market.dao.HxNewscategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * 类名称：HxNewscategoryServiceImpl.java
 * 类描述：
 * 创建时间：2018-11-08, 下午03:05:40
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author leijun 
 */ 
@Service
@Transactional
public class HxNewscategoryServiceImpl implements HxNewscategoryService {
	private HxNewscategoryDao dao;
	@Autowired
	public void setDao(HxNewscategoryDao dao) {
		this.dao = dao;
	}
	public HxNewscategoryDao getDao() {
		return dao;
	}
	/**
	 *添加HxNewscategory
	 */ 
	public boolean add(HxNewscategory hxNewscategory) {
		boolean result = dao.add(hxNewscategory);
		return result;
	}
	/**
	 *删除HxNewscategory
	 */ 
	public boolean delete(HxNewscategory hxNewscategory) {
		boolean result = dao.delete(hxNewscategory);
		return result;
	}
	/**
	 *修改HxNewscategory
	 */ 
	public boolean update(HxNewscategory hxNewscategory) {
		boolean result = dao.update(hxNewscategory);
		return result;
	}
	/**
	 *查询HxNewscategory列表
	 */ 
	public List<HxNewscategory> query(HxNewscategory hxNewscategory) {
		List<HxNewscategory> list = dao.query(hxNewscategory);
		return list;
	}
	/**
	 *查询HxNewscategory ByID
	 */ 
//	public HxNewscategory queryById(HxNewscategory hxNewscategory) {
//		HxNewscategory result = dao.queryById(hxNewscategory);
//		return result;
//	}
	/**
	 *分页HxNewscategory pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<HxNewscategory> queryForPage(int pageNo,int pageSize,HxNewscategory hxNewscategory) {
		List<HxNewscategory> list = dao.queryForPage(pageNo,pageSize,hxNewscategory);
		return list;
	}
	/**
	 *查询HxNewscategory数据条数
	 */ 
	public Long queryCount(HxNewscategory hxNewscategory) {
		Long result = dao.queryCount(hxNewscategory);
		return result;
	}

}