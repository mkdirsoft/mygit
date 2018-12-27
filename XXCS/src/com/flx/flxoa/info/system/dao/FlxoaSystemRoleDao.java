package com.flx.flxoa.info.system.dao;


import java.util.List;
import com.flx.flxoa.info.system.entity.FlxoaSystemRole;
import com.flx.flxoa.info.system.entity.FlxoaSystemRoleFuncation;

/**
 *
 * 类名称：FlxoaSystemRoleDao.java
 * 类描述：
 * 创建时间：2018-03-28, 上午09:18:54
 *
 *@version 1.0 
 *@since JDK版本1.7 
 *@author 雷君 
 */ 
public interface FlxoaSystemRoleDao {
	/**
	 *添加FlxoaSystemRole
	 */ 
	public boolean add(FlxoaSystemRole flxoaSystemRole);
	/**
	 *删除FlxoaSystemRole
	 */ 
	public boolean delete(FlxoaSystemRole flxoaSystemRole);
	/**
	 *删除FlxoaSystemRoleFuncation
	 */ 
	public boolean deleteByName(FlxoaSystemRole flxoaSystemRole);
	/**
	 *删除FlxoaSystemRoleFuncation
	 */ 
	public boolean deleteById(FlxoaSystemRole flxoaSystemRole);
	/**
	 *修改FlxoaSystemRole
	 */ 
	public boolean update(FlxoaSystemRole flxoaSystemRole);
	/**
	 *查询FlxoaSystemRole
	 */ 
	public boolean isExist(String username);
	/**
	 *查询FlxoaSystemRole列表
	 */ 
	public List<FlxoaSystemRole> query(FlxoaSystemRole flxoaSystemRole);
	/**
	 *查询FlxoaSystemRole列表
	 */ 
	public List<FlxoaSystemRole> queryRoleId(FlxoaSystemRole flxoaSystemRole);
	/**
	 *查询FlxoaSystemRole列表
	 */ 
	public List<FlxoaSystemRole> querySql(FlxoaSystemRole flxoaSystemRole);
	/**
	 *查询FlxoaSystemRole ByID
	 */ 
	public FlxoaSystemRole queryById(FlxoaSystemRole flxoaSystemRole);
	/**
	 *分页FlxoaSystemRole pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<FlxoaSystemRole> queryForPage(int pageNo,int pageSize,FlxoaSystemRole flxoaSystemRole);
	/**
	 *查询FlxoaSystemRole数据条数
	 */ 
	public Long queryCount(FlxoaSystemRole flxoaSystemRole);
	


 }