package com.flx.flxoa.info.market.manager;


import java.util.List;
import java.util.Map;

import com.flx.flxoa.info.market.entity.HxFavorite;

/**
 *
 * 类名称：HxFavoriteService.java
 * 类描述：
 * 创建时间：2018-11-08, 下午03:05:40
 *
 *@version 1.0 
 *@since JDK版本1.7 
 *@author leijun 
 */ 
public interface HxFavoriteService {
	/**
	 *添加HxFavorite
	 */ 
	public boolean add(HxFavorite hxFavorite);
	/**
	 *删除HxFavorite
	 */ 
	public boolean delete(HxFavorite hxFavorite);
	public boolean isExist(String  username,String UserID);
	/**
	 *修改HxFavorite
	 */ 
	public boolean update(HxFavorite hxFavorite);
	/**
	 *查询HxFavorite列表
	 */ 
	public List<HxFavorite> query(HxFavorite hxFavorite);
	/**
	 *查询HxFavorite ByID
	 */ 
	//public HxFavorite queryById(HxFavorite hxFavorite);
	/**
	 *分页HxFavorite pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public String queryForPage(Map<String,String> map);
	/**
	 *查询HxFavorite数据条数
	 */ 
	public Long queryCount(HxFavorite hxFavorite);

 }