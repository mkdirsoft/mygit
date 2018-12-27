package com.flx.flxoa.info.system.manager;


import java.util.List;
import com.flx.flxoa.info.system.entity.FlxoaSystemUserGroup;
import com.flx.flxoa.info.system.entity.FlxoaSystemUserGroupDepartment;
import com.flx.flxoa.info.system.entity.FlxoaSystemUserGroupUser;

/**
 *
 * 类名称：FlxoaSystemUserGroupService.java
 * 类描述：
 * 创建时间：2018-03-28, 上午11:16:41
 *
 *@version 1.0 
 *@since JDK版本1.7 
 *@author 赵鹏辉 
 */ 
public interface FlxoaSystemUserGroupService {
	/**
	 *添加FlxoaSystemUserGroup
	 */ 
	public boolean add(FlxoaSystemUserGroup flxoaSystemUserGroup);
	/**
	 *删除FlxoaSystemUserGroup
	 */ 
	public boolean delete(FlxoaSystemUserGroup flxoaSystemUserGroup);
	/**
	 *修改FlxoaSystemUserGroup
	 */ 
	public boolean update(FlxoaSystemUserGroup flxoaSystemUserGroup);
	/**
	 *查询FlxoaSystemUserGroup列表
	 */ 
	public List<FlxoaSystemUserGroup> query(FlxoaSystemUserGroup flxoaSystemUserGroup);
	/**
	 *查询FlxoaSystemUserGroup ByID
	 */ 
	public FlxoaSystemUserGroup queryById(FlxoaSystemUserGroup flxoaSystemUserGroup);
	/**
	 *分页FlxoaSystemUserGroup pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public String queryForPage(int start,int length,String userGroupName,String draw);
	/**
	 *查询FlxoaSystemUserGroup数据条数
	 */ 
	public Long queryCount(FlxoaSystemUserGroup flxoaSystemUserGroup);
	/**
	 * 查询
	 * @param flxoaSystemUserGroup
	 * @return
	 */
	public long getGroupName(FlxoaSystemUserGroup flxoaSystemUserGroup);
	
	/**
	 *删除FlxoaSystemUserGroup
	 */ 
	public boolean deleteGroup(FlxoaSystemUserGroup flxoaSystemUserGroup);
	/**
	 *分页FlxoaSystemUserGroupDepartment pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List quanxianList(int pageNo,int pageSize,FlxoaSystemUserGroup flxoaSystemUserGroup);
	/**
	 *查询FlxoaSystemUserGroupDepartment数据条数
	 */ 
	public Long quanxianCount(FlxoaSystemUserGroup flxoaSystemUserGroup);
	/**
	 * 授权添加
	 * @param flxoaSystemUserGroup
	 * @param groupUserIds
	 * @param groupRoleIds
	 * @param groupDeptIds
	 * @return
	 */
	public boolean shouquanAdd(FlxoaSystemUserGroup flxoaSystemUserGroup,int[] groupUserIds,int[] groupRoleIds,int[] groupDeptIds);
	
 }