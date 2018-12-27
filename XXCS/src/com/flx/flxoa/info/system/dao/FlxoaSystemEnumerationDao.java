package com.flx.flxoa.info.system.dao;


import java.util.List;
import com.flx.flxoa.info.system.entity.FlxoaSystemEnumeration;

/**
 *
 * 类名称：FlxoaSystemEnumerationDao.java
 * 类描述：
 * 创建时间：2018-04-21, 下午03:11:35
 *
 *@version 1.0 
 *@since JDK版本1.7 
 *@author 刘凯 
 */ 
public interface FlxoaSystemEnumerationDao {
	/**
	 *添加FlxoaSystemEnumeration
	 */ 
	public boolean add(FlxoaSystemEnumeration flxoaSystemEnumeration);
	/**
	 *删除FlxoaSystemEnumeration
	 */ 
	public boolean delete(FlxoaSystemEnumeration flxoaSystemEnumeration);
	/**
	 *修改FlxoaSystemEnumeration
	 */ 
	public boolean update(FlxoaSystemEnumeration flxoaSystemEnumeration);
	/**
	 *查询FlxoaSystemEnumeration列表
	 */ 
	public List<FlxoaSystemEnumeration> query(FlxoaSystemEnumeration flxoaSystemEnumeration);
	/**
	 *查询FlxoaSystemEnumeration ByID
	 */ 
	public FlxoaSystemEnumeration queryById(FlxoaSystemEnumeration flxoaSystemEnumeration);
	/**
	 *分页FlxoaSystemEnumeration pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<FlxoaSystemEnumeration> queryForPage(int pageNo,int pageSize,FlxoaSystemEnumeration flxoaSystemEnumeration);
	/**
	 *查询FlxoaSystemEnumeration数据条数
	 */ 
	public Long queryCount(FlxoaSystemEnumeration flxoaSystemEnumeration);

 }