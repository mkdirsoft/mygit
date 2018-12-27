package com.flx.flxoa.info.system.dao;


import java.util.List;
import com.flx.flxoa.info.system.entity.FlxoaSystemSso;

/**
 *
 * 类名称：FlxoaSystemSsoDao.java
 * 类描述：
 * 创建时间：2018-05-07, 下午02:35:50
 *
 *@version 1.0 
 *@since JDK版本1.7 
 *@author 刘凯 
 */ 
public interface FlxoaSystemSsoDao {
	/**
	 *添加FlxoaSystemSso
	 */ 
	public boolean add(FlxoaSystemSso flxoaSystemSso);
	/**
	 *删除FlxoaSystemSso
	 */ 
	public boolean delete(FlxoaSystemSso flxoaSystemSso);
	/**
	 *修改FlxoaSystemSso
	 */ 
	public boolean update(FlxoaSystemSso flxoaSystemSso);
	/**
	 *查询FlxoaSystemSso列表
	 */ 
	public List<FlxoaSystemSso> query(FlxoaSystemSso flxoaSystemSso);
	/**
	 *查询FlxoaSystemSso ByID
	 */ 
	public FlxoaSystemSso queryById(FlxoaSystemSso flxoaSystemSso);
	/**
	 *分页FlxoaSystemSso pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<FlxoaSystemSso> queryForPage(int pageNo,int pageSize,FlxoaSystemSso flxoaSystemSso);
	/**
	 *查询FlxoaSystemSso数据条数
	 */ 
	public Long queryCount(FlxoaSystemSso flxoaSystemSso);
	/**
	 *根据属性查询FlxoaSystemSso
	 */ 
	public FlxoaSystemSso queryByPro(FlxoaSystemSso flxoaSystemSso);

 }