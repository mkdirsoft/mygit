package com.flx.flxoa.info.market.dao;


import java.util.List;
import com.flx.flxoa.info.market.entity.HxSource;

/**
 *
 * 类名称：HxSourceDao.java
 * 类描述：
 * 创建时间：2018-11-08, 下午03:05:40
 *
 *@version 1.0 
 *@since JDK版本1.7 
 *@author leijun 
 */ 
public interface HxSourceDao {
	/**
	 *添加HxSource
	 */ 
	public boolean add(HxSource hxSource);
	/**
	 *删除HxSource
	 */ 
//	public boolean delete(HxSource hxSource);
	/**
	 *修改HxSource
	 */ 
	public boolean update(HxSource hxSource);
	/**
	 *查询HxSource列表
	 */ 
	public List<HxSource> query(HxSource hxSource);
	
	public boolean isExist(String username,String UserID);
	/**
	 *查询HxSource ByID
	 */ 
	public HxSource queryById(HxSource hxSource);
	/**
	 *分页HxSource pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<HxSource> queryForPage(int pageNo,int pageSize,HxSource hxSource);
	/**
	 *查询HxSource数据条数
	 */ 
	public Long queryCount(HxSource hxSource);

 }