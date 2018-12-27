package com.flx.flxoa.info.market.dao;


import java.util.List;
import com.flx.flxoa.info.market.entity.HxCropsource;

/**
 *
 * 类名称：HxCropsourceDao.java
 * 类描述：
 * 创建时间：2018-11-08, 下午03:05:40
 *
 *@version 1.0 
 *@since JDK版本1.7 
 *@author leijun 
 */ 
public interface HxCropsourceDao {
	/**
	 *添加HxCropsource
	 */ 
	public boolean add(HxCropsource hxCropsource);
	/**
	 *删除HxCropsource
	 */ 
	public boolean delete(HxCropsource hxCropsource);
	/**
	 *修改HxCropsource
	 */ 
	public boolean update(HxCropsource hxCropsource);
	/**
	 *查询HxCropsource列表
	 */ 
	public List<HxCropsource> query(HxCropsource hxCropsource);
	/**
	 *查询HxCropsource ByID
	 */ 
	//public HxCropsource queryById(HxCropsource hxCropsource);
	/**
	 *分页HxCropsource pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<HxCropsource> queryForPage(int pageNo,int pageSize,HxCropsource hxCropsource);
	/**
	 *查询HxCropsource数据条数
	 */ 
	public Long queryCount(HxCropsource hxCropsource);

 }