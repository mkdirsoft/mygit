package com.flx.flxoa.info.market.manager;


import java.util.List;
import java.util.Map;

import com.flx.flxoa.info.market.entity.HxSubscribe;

/**
 *
 * 类名称：HxSubscribeService.java
 * 类描述：
 * 创建时间：2018-11-08, 下午03:05:40
 *
 *@version 1.0 
 *@since JDK版本1.7 
 *@author leijun 
 */ 
public interface HxSubscribeService {
	/**
	 *添加HxSubscribe
	 */ 
	public boolean add(HxSubscribe hxSubscribe);
	/**
	 *查询HxSubscribe
	 */ 
	public boolean isExist(String userID,String RegionCodeID,String CropCategoryID);
	/**
	 *删除HxSubscribe
	 */ 
	public boolean delete(HxSubscribe hxSubscribe);
	/**
	 *修改HxSubscribe
	 */ 
	public boolean update(HxSubscribe hxSubscribe);
	/**
	 *查询HxSubscribe列表
	 */ 
	public List<HxSubscribe> query(HxSubscribe hxSubscribe);
	/**
	 *查询HxSubscribe ByID
	 */ 
	//public HxSubscribe queryById(HxSubscribe hxSubscribe);
	/**
	 *分页HxSubscribe pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public String queryForPage(Map<String,String> map);
	/**
	 *查询HxSubscribe数据条数
	 */ 
	public Long queryCount(HxSubscribe hxSubscribe);

 }