package com.flx.flxoa.info.system.manager;


import java.util.List;

import com.flx.flxoa.info.system.entity.FlxoaSystemUserGroupDepartment;
import com.flx.flxoa.info.system.entity.FlxoaSystemUserGroupUser;

/**
 *
 * 类名称：FlxoaSystemUserGroupUserService.java
 * 类描述：
 * 创建时间：2018-03-28, 上午11:15:33
 *
 *@version 1.0 
 *@since JDK版本1.7 
 *@author 赵鹏辉 
 */ 
public interface FlxoaSystemUserGroupUserService {
	/**
	 *添加FlxoaSystemUserGroupUser
	 */ 
	public boolean add(FlxoaSystemUserGroupUser flxoaSystemUserGroupUser);
	/**
	 *删除FlxoaSystemUserGroupUser
	 */ 
	public boolean delete(FlxoaSystemUserGroupUser flxoaSystemUserGroupUser);
	/**
	 *修改FlxoaSystemUserGroupUser
	 */ 
	public boolean update(FlxoaSystemUserGroupUser flxoaSystemUserGroupUser);
	/**
	 *查询FlxoaSystemUserGroupUser列表
	 */ 
	public List<FlxoaSystemUserGroupUser> query(FlxoaSystemUserGroupUser flxoaSystemUserGroupUser);
	/**
	 *查询FlxoaSystemUserGroupUser ByID
	 */ 
	public FlxoaSystemUserGroupUser queryById(FlxoaSystemUserGroupUser flxoaSystemUserGroupUser);
	/**
	 *分页FlxoaSystemUserGroupUser pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<FlxoaSystemUserGroupUser> queryForPage(int pageNo,int pageSize,FlxoaSystemUserGroupUser flxoaSystemUserGroupUser);
	/**
	 *查询FlxoaSystemUserGroupUser数据条数
	 */ 
	public Long queryCount(FlxoaSystemUserGroupUser flxoaSystemUserGroupUser);
	/**
	 *删除FlxoaSystemUserGroupUser
	 */ 
	public boolean deleteByGroupId(FlxoaSystemUserGroupUser flxoaSystemUserGroupUser);
	
 }