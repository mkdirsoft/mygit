package com.flx.flxoa.info.system.manager.impl;


import java.util.List;
import com.flx.flxoa.info.system.entity.FlxoaSystemUserGroup;
import com.flx.flxoa.info.system.entity.FlxoaSystemUserGroupDepartment;
import com.flx.flxoa.info.system.entity.FlxoaSystemUserGroupRole;
import com.flx.flxoa.info.system.entity.FlxoaSystemUserGroupUser;
import com.flx.flxoa.info.system.manager.FlxoaSystemUserGroupService;
import com.flx.flxoa.info.system.dao.FlxoaSystemUserGroupDao;
import com.flx.flxoa.info.system.dao.FlxoaSystemUserGroupDepartmentDao;
import com.flx.flxoa.info.system.dao.FlxoaSystemUserGroupRoleDao;
import com.flx.flxoa.info.system.dao.FlxoaSystemUserGroupUserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * 类名称：FlxoaSystemUserGroupServiceImpl.java
 * 类描述：
 * 创建时间：2018-03-28, 上午11:16:41
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 赵鹏辉 
 */ 
@Service
@Transactional
public class FlxoaSystemUserGroupServiceImpl implements FlxoaSystemUserGroupService {
	private FlxoaSystemUserGroupDao dao;
	private FlxoaSystemUserGroupUserDao userDao;
	private FlxoaSystemUserGroupRoleDao roleDao;
	private FlxoaSystemUserGroupDepartmentDao departmentdao;
	@Autowired
	public void setDepartmentdao(FlxoaSystemUserGroupDepartmentDao departmentdao) {
		this.departmentdao = departmentdao;
	}
	public FlxoaSystemUserGroupDepartmentDao getDepartmentdao() {
		return departmentdao;
	}
	
	@Autowired
	public void setRoleDao(FlxoaSystemUserGroupRoleDao roleDao) {
		this.roleDao = roleDao;
	}
	public FlxoaSystemUserGroupRoleDao getRoleDao() {
		return roleDao;
	}
	
	@Autowired
	public void setDao(FlxoaSystemUserGroupUserDao userDao) {
		this.userDao = userDao;
	}
	public FlxoaSystemUserGroupUserDao getUserDao() {
		return userDao;
	}
	
	@Autowired
	public void setDao(FlxoaSystemUserGroupDao dao) {
		this.dao = dao;
	}
	public FlxoaSystemUserGroupDao getDao() {
		return dao;
	}
	/**
	 *添加FlxoaSystemUserGroup
	 */ 
	public boolean add(FlxoaSystemUserGroup flxoaSystemUserGroup) {
		boolean result = dao.add(flxoaSystemUserGroup);
		return result;
	}
	/**
	 *删除FlxoaSystemUserGroup
	 */ 
	public boolean delete(FlxoaSystemUserGroup flxoaSystemUserGroup) {
		boolean result = dao.delete(flxoaSystemUserGroup);
		return result;
	}
	/**
	 *修改FlxoaSystemUserGroup
	 */ 
	public boolean update(FlxoaSystemUserGroup flxoaSystemUserGroup) {
		boolean result = dao.update(flxoaSystemUserGroup);
		return result;
	}
	/**
	 *查询FlxoaSystemUserGroup列表
	 */ 
	public List<FlxoaSystemUserGroup> query(FlxoaSystemUserGroup flxoaSystemUserGroup) {
		List<FlxoaSystemUserGroup> list = dao.query(flxoaSystemUserGroup);
		return list;
	}
	/**
	 *查询FlxoaSystemUserGroup ByID
	 */ 
	public FlxoaSystemUserGroup queryById(FlxoaSystemUserGroup flxoaSystemUserGroup) {
		FlxoaSystemUserGroup result = dao.queryById(flxoaSystemUserGroup);
		return result;
	}
	/**
	 *分页FlxoaSystemUserGroup pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public String queryForPage(int start,int length,String userGroupName,String draw) {
		return dao.queryForPage(start,length,userGroupName,draw);
	}
	/**
	 *查询FlxoaSystemUserGroup数据条数
	 */ 
	public Long queryCount(FlxoaSystemUserGroup flxoaSystemUserGroup) {
		Long result = dao.queryCount(flxoaSystemUserGroup);
		return result;
	}
	/**
	 *分页FlxoaSystemUserGroup pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List quanxianList(int pageNo,int pageSize,FlxoaSystemUserGroup flxoaSystemUserGroup) {
		List list = dao.quanxianList(pageNo,pageSize,flxoaSystemUserGroup);
		return list;
	}
	/**
	 *查询FlxoaSystemUserGroupDepartment数据条数
	 */ 
	public Long quanxianCount(FlxoaSystemUserGroup flxoaSystemUserGroup) {
		Long result = dao.quanxianCount(flxoaSystemUserGroup);
		return result;
	}
	/**
	 * 查询
	 * @param flxoaSystemUserGroup
	 * @return
	 */
	public long getGroupName(FlxoaSystemUserGroup flxoaSystemUserGroup){
		Long result = dao.getGroupName(flxoaSystemUserGroup);
		return result;
	}
	/**
	 * 删除
	 */
	public boolean deleteGroup(FlxoaSystemUserGroup flxoaSystemUserGroup) {
		boolean result=false;
		List<FlxoaSystemUserGroupUser> systemUserGroupUserList=userDao.queryByGroupId(flxoaSystemUserGroup);
		for(int i=0;i<systemUserGroupUserList.size();i++){
			result=userDao.delete(systemUserGroupUserList.get(i));
		}
		List<FlxoaSystemUserGroupRole> systemUserGroupRoleList=roleDao.queryByGroupId(flxoaSystemUserGroup);
		for(int i=0;i<systemUserGroupRoleList.size();i++){
			result=roleDao.delete(systemUserGroupRoleList.get(i));
		}
		List<FlxoaSystemUserGroupDepartment> systemUserGroupDepartmentList=departmentdao.queryByGroupId(flxoaSystemUserGroup);
		for(int i=0;i<systemUserGroupDepartmentList.size();i++){
			result=departmentdao.delete(systemUserGroupDepartmentList.get(i));
		}
		result = dao.delete(flxoaSystemUserGroup);
		return result;
	}
	
	/**
	 * 授权添加
	 */
	public boolean shouquanAdd(FlxoaSystemUserGroup flxoaSystemUserGroup,
			int[] groupUserIds, int[] groupRoleIds, int[] groupDeptIds) {
		Boolean flag=false;
		List<FlxoaSystemUserGroupUser> systemUserGroupUserList=userDao.queryByGroupId(flxoaSystemUserGroup);
		for(int i=0;i<systemUserGroupUserList.size();i++){
			flag=userDao.delete(systemUserGroupUserList.get(i));
		}
		List<FlxoaSystemUserGroupRole> systemUserGroupRoleList=roleDao.queryByGroupId(flxoaSystemUserGroup);
		for(int i=0;i<systemUserGroupRoleList.size();i++){
			flag=roleDao.delete(systemUserGroupRoleList.get(i));
		}
		List<FlxoaSystemUserGroupDepartment> systemUserGroupDepartmentList=departmentdao.queryByGroupId(flxoaSystemUserGroup);
		for(int i=0;i<systemUserGroupDepartmentList.size();i++){
			flag=departmentdao.delete(systemUserGroupDepartmentList.get(i));
		}
		
		for(int i=0;i<groupUserIds.length;i++){
			FlxoaSystemUserGroupUser flxoaSystemUserGroupUser=new FlxoaSystemUserGroupUser();
			flxoaSystemUserGroupUser.setUserId(groupUserIds[i]);
			flxoaSystemUserGroupUser.setUserGroupId(flxoaSystemUserGroup.getId());
			flag = userDao.add(flxoaSystemUserGroupUser);
		}

		for(int j=0;j<groupRoleIds.length;j++){
			FlxoaSystemUserGroupRole flxoaSystemUserGroupRole=new FlxoaSystemUserGroupRole();
			flxoaSystemUserGroupRole.setRoleId(groupRoleIds[j]);
			flxoaSystemUserGroupRole.setUserGroupId(flxoaSystemUserGroup.getId());
			flag = roleDao.add(flxoaSystemUserGroupRole);
		}

		for(int m=0;m<groupDeptIds.length;m++){
			FlxoaSystemUserGroupDepartment flxoaSystemUserGroupDepartment=new FlxoaSystemUserGroupDepartment();
			flxoaSystemUserGroupDepartment.setDepartmentId(groupDeptIds[m]);
			flxoaSystemUserGroupDepartment.setUserGroupId(flxoaSystemUserGroup.getId());
			flag = departmentdao.add(flxoaSystemUserGroupDepartment);
		}
		
		return flag;
	}

}