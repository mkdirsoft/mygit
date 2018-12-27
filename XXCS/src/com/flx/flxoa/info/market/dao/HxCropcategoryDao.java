package com.flx.flxoa.info.market.dao;


import java.util.List;
import java.util.Map;

import com.flx.flxoa.info.market.entity.HxCropcategory;

/**
 *
 * 类名称：HxCropcategoryDao.java
 * 类描述：
 * 创建时间：2018-11-02, 上午11:02:11
 *
 *@version 1.0 
 *@since JDK版本1.7 
 *@author leijun 
 */ 
public interface HxCropcategoryDao {
	/**
	 *添加HxCropcategory
	 */ 
	public boolean add(HxCropcategory hxCropcategory);
	/**
	 *删除HxCropcategory
	 */ 
	public boolean delete(HxCropcategory hxCropcategory);
	/**
	 *修改HxCropcategory
	 */ 
	public boolean update(HxCropcategory hxCropcategory);
	/**
	 *查询HxCropcategory列表
	 */ 
	public List<HxCropcategory> query(HxCropcategory hxCropcategory);
	/**
	 *查询HxCropcategory ByID
	 */ 
	public HxCropcategory queryById(HxCropcategory hxCropcategory);
	/**
	 *分页HxCropcategory pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<HxCropcategory> queryForPage1(int pageNo,int pageSize,HxCropcategory hxCropcategory);
	/**
	 *分页HxCropcategory pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public String queryForPage(Map<String,String> map);
	/**
	 * 
	 *查询HxCropcategory数据条数
	 */ 
	public Long queryCount(HxCropcategory hxCropcategory);

 }