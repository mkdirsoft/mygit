package com.flx.flxoa.info.market.manager.impl;


import java.util.List;
import java.util.Map;

import com.flx.flxoa.info.market.entity.HxFollow;
import com.flx.flxoa.info.market.manager.HxFollowService;
import com.flx.flxoa.info.market.dao.HxFollowDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * 类名称：HxFollowServiceImpl.java
 * 类描述：
 * 创建时间：2018-11-08, 下午03:05:40
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author leijun 
 */ 
@Service
@Transactional
public class HxFollowServiceImpl implements HxFollowService {
	private HxFollowDao dao;
	@Autowired
	public void setDao(HxFollowDao dao) {
		this.dao = dao;
	}
	public HxFollowDao getDao() {
		return dao;
	}
	/**
	 *添加HxFollow
	 */ 
	public boolean add(HxFollow hxFollow) {
		boolean result = dao.add(hxFollow);
		return result;
	}
	/**
	 *删除HxFollow
	 */ 
	public boolean delete(HxFollow hxFollow) {
		boolean result = dao.delete(hxFollow);
		return result;
	}
	/**
	 *修改HxFollow
	 */ 
	public boolean update(HxFollow hxFollow) {
		boolean result = dao.update(hxFollow);
		return result;
	}
	public boolean isExist(String username , String userID) {
		boolean result = dao.isExist(username,userID);
		return result;
	}
	/**
	 *查询HxFollow列表
	 */ 
	public List<HxFollow> query(HxFollow hxFollow) {
		List<HxFollow> list = dao.query(hxFollow);
		return list;
	}
	/**
	 *查询HxFollow ByID
	 */ 
//	public HxFollow queryById(HxFollow hxFollow) {
//		HxFollow result = dao.queryById(hxFollow);
//		return result;
//	}
	/**
	 *分页HxFollow pageNo 查询第几页数据  pageSize 每一页显示的数量 queryForPageMore
	 */ 
	public String queryForPage(Map<String,String> map) {
		String list = dao.queryForPage(map);
		return list;
	}
	/**
	 *分页HxFollow pageNo 查询第几页数据  pageSize 每一页显示的数量 queryForPageMore
	 */ 
	public String queryForPageMore(Map<String,String> map) {
		String list = dao.queryForPageMore(map);
		return list;
	}
	/**
	 *查询HxFollow数据条数
	 */ 
	public Long queryCount(HxFollow hxFollow) {
		Long result = dao.queryCount(hxFollow);
		return result;
	}

}