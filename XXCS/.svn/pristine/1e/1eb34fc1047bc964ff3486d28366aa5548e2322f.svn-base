package com.flx.flxoa.info.market.manager.impl;


import java.util.List;
import java.util.Map;

import com.flx.flxoa.info.market.entity.HxFavorite;
import com.flx.flxoa.info.market.manager.HxFavoriteService;
import com.flx.flxoa.info.market.dao.HxFavoriteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * 类名称：HxFavoriteServiceImpl.java
 * 类描述：
 * 创建时间：2018-11-08, 下午03:05:40
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author leijun 
 */ 
@Service
@Transactional
public class HxFavoriteServiceImpl implements HxFavoriteService {
	private HxFavoriteDao dao;
	@Autowired
	public void setDao(HxFavoriteDao dao) {
		this.dao = dao;
	}
	public HxFavoriteDao getDao() {
		return dao;
	}
	/**
	 *添加HxFavorite
	 */ 
	public boolean add(HxFavorite hxFavorite) {
		boolean result = dao.add(hxFavorite);
		return result;
	}
	public boolean isExist(String username,String UserID) {
		boolean result = dao.isExist(username,UserID);
		return result;
	}
	/**
	 *删除HxFavorite
	 */ 
	public boolean delete(HxFavorite hxFavorite) {
		boolean result = dao.delete(hxFavorite);
		return result;
	}
	/**
	 *修改HxFavorite
	 */ 
	public boolean update(HxFavorite hxFavorite) {
		boolean result = dao.update(hxFavorite);
		return result;
	}
	/**
	 *查询HxFavorite列表
	 */ 
	public List<HxFavorite> query(HxFavorite hxFavorite) {
		List<HxFavorite> list = dao.query(hxFavorite);
		return list;
	}
	/**
	 *查询HxFavorite ByID
	 */ 
//	public HxFavorite queryById(HxFavorite hxFavorite) {
//		HxFavorite result = dao.queryById(hxFavorite);
//		return result;
//	}
	/**
	 *分页HxFavorite pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public String queryForPage(Map<String,String> map) {
		String list = dao.queryForPage(map);
		return list;
	}
	/**
	 *查询HxFavorite数据条数
	 */ 
	public Long queryCount(HxFavorite hxFavorite) {
		Long result = dao.queryCount(hxFavorite);
		return result;
	}

}