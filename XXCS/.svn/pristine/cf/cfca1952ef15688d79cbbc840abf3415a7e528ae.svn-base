package com.flx.flxoa.info.market.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flx.flxoa.info.market.dao.HxRegionDao;
import com.flx.flxoa.info.market.entity.HxRegion;
import com.flx.flxoa.info.market.manager.HxRegionService;

/**
 *
 * 类名称：HxRegionServiceImpl.java
 * 类描述：
 * 创建时间：2018-11-02, 上午11:02:11
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author leijun 
 */ 
@Service
@Transactional
public class HxRegionServiceImpl implements HxRegionService {
	private HxRegionDao dao;
	@Autowired
	public void setDao(HxRegionDao dao) {
		this.dao = dao;
	}
	public HxRegionDao getDao() {
		return dao;
	}
	/**
	 *添加HxRegion
	 */ 
	public boolean add(HxRegion hxRegion) {
		boolean result = dao.add(hxRegion);
		return result;
	}
	/**
	 *删除HxRegion
	 */ 
	public boolean delete(HxRegion hxRegion) {
		boolean result = dao.delete(hxRegion);
		return result;
	}
	/**
	 *修改HxRegion
	 */ 
	public boolean update(HxRegion hxRegion) {
		boolean result = dao.update(hxRegion);
		return result;
	}
	/**
	 *查询HxRegion列表
	 */ 
	public List<HxRegion> query(HxRegion hxRegion) {
		List<HxRegion> list = dao.query(hxRegion);
		return list;
	}
	/**
	 *查询HxRegion ByID
	 */ 
	public HxRegion queryById(HxRegion hxRegion) {
		HxRegion result = dao.queryById(hxRegion);
		return result;
	}
	/**
	 *分页HxRegion pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<HxRegion> queryForPage(int pageNo,int pageSize,HxRegion hxRegion) {
		List<HxRegion> list = dao.queryForPage(pageNo,pageSize,hxRegion);
		return list;
	}
	/**
	 *查询HxRegion数据条数
	 */ 
	public Long queryCount(HxRegion hxRegion) {
		Long result = dao.queryCount(hxRegion);
		return result;
	}

}