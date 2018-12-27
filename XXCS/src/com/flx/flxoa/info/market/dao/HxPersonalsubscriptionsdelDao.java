package com.flx.flxoa.info.market.dao;


import java.util.List;
import com.flx.flxoa.info.market.entity.HxPersonalsubscriptionsdel;

/**
 *
 * 类名称：HxPersonalsubscriptionsdelDao.java
 * 类描述：
 * 创建时间：2018-11-15, 下午03:17:08
 *
 *@version 1.0 
 *@since JDK版本1.7 
 *@author leijun 
 */ 
public interface HxPersonalsubscriptionsdelDao {
	/**
	 *添加HxPersonalsubscriptionsdel
	 */ 
	public boolean add(HxPersonalsubscriptionsdel hxPersonalsubscriptionsdel);
	/**
	 *删除HxPersonalsubscriptionsdel
	 */ 
	public boolean delete(HxPersonalsubscriptionsdel hxPersonalsubscriptionsdel);
	/**
	 *修改HxPersonalsubscriptionsdel
	 */ 
	public boolean update(HxPersonalsubscriptionsdel hxPersonalsubscriptionsdel);
	/**
	 *查询HxPersonalsubscriptionsdel列表
	 */ 
	public List<HxPersonalsubscriptionsdel> query(HxPersonalsubscriptionsdel hxPersonalsubscriptionsdel);
	/**
	 *查询HxPersonalsubscriptionsdel ByID
	 */ 
	public HxPersonalsubscriptionsdel queryById(HxPersonalsubscriptionsdel hxPersonalsubscriptionsdel);
	/**
	 *分页HxPersonalsubscriptionsdel pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<HxPersonalsubscriptionsdel> queryForPage(int pageNo,int pageSize,HxPersonalsubscriptionsdel hxPersonalsubscriptionsdel);
	/**
	 *查询HxPersonalsubscriptionsdel数据条数
	 */ 
	public Long queryCount(HxPersonalsubscriptionsdel hxPersonalsubscriptionsdel);

 }