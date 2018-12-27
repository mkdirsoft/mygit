package com.flx.flxoa.info.system.manager;


import java.util.List;
import com.flx.flxoa.info.system.entity.FlxoaSystemUserGroupDepartment;
import com.flx.flxoa.info.system.entity.FlxoaSystemUserGroupUser;

/**
 *
 * 类名称：FlxoaSystemUserGroupDepartmentService.java
 * 类描述：
 * 创建时间：2018-03-29, 上午09:35:52
 *
 *@version 1.0 
 *@since JDK版本1.7 
 *@author 赵鹏辉 
 */ 
public interface FlxoaSystemUserGroupDepartmentService {
	/**
	 *添加FlxoaSystemUserGroupDepartment
	 */ 
	public boolean add(FlxoaSystemUserGroupDepartment flxoaSystemUserGroupDepartment);
	/**
	 *删除FlxoaSystemUserGroupDepartment
	 */ 
	public boolean delete(FlxoaSystemUserGroupDepartment flxoaSystemUserGroupDepartment);
	/**
	 *修改FlxoaSystemUserGroupDepartment
	 */ 
	public boolean update(FlxoaSystemUserGroupDepartment flxoaSystemUserGroupDepartment);
	/**
	 *查询FlxoaSystemUserGroupDepartment列表
	 */ 
	public List<FlxoaSystemUserGroupDepartment> query(FlxoaSystemUserGroupDepartment flxoaSystemUserGroupDepartment);
	/**
	 *查询FlxoaSystemUserGroupDepartment ByID
	 */ 
	public FlxoaSystemUserGroupDepartment queryById(FlxoaSystemUserGroupDepartment flxoaSystemUserGroupDepartment);
	/**
	 *分页FlxoaSystemUserGroupDepartment pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<FlxoaSystemUserGroupDepartment> queryForPage(int pageNo,int pageSize,FlxoaSystemUserGroupDepartment flxoaSystemUserGroupDepartment);
	/**
	 *查询FlxoaSystemUserGroupDepartment数据条数
	 */ 
	public Long queryCount(FlxoaSystemUserGroupDepartment flxoaSystemUserGroupDepartment);
	/**
	 *删除FlxoaSystemUserGroupUser
	 */ 
	public boolean deleteByGroupId(FlxoaSystemUserGroupDepartment flxoaSystemUserGroupDepartment);

 }