package com.flx.flxoa.info.market.manager;


import java.util.List;
import java.util.Map;

import com.flx.flxoa.info.market.entity.HxFollow;

/**
 *
 * 类名称：HxFollowService.java
 * 类描述：
 * 创建时间：2018-11-08, 下午03:05:40
 *
 *@version 1.0 
 *@since JDK版本1.7 
 *@author leijun 
 */ 
public interface HxFollowService {
	/**
	 *添加HxFollow
	 */ 
	public boolean add(HxFollow hxFollow);
	/**
	 *删除HxFollow
	 */ 
	public boolean delete(HxFollow hxFollow);
	/**
	 *修改HxFollow
	 */ 
	public boolean update(HxFollow hxFollow);
	
	public boolean isExist(String  username, String userID);
	/**
	 *查询HxFollow列表
	 */ 
	public List<HxFollow> query(HxFollow hxFollow);
	/**
	 *查询HxFollow ByID
	 */ 
	//public HxFollow queryById(HxFollow hxFollow);
	/**
	 *分页HxFollow pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public String queryForPage(Map<String,String> map);
	/**
	 *分页HxFollow pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public String queryForPageMore(Map<String,String> map);
	/**
	 *查询HxFollow数据条数
	 */ 
	public Long queryCount(HxFollow hxFollow);

 }