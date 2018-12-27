package com.flx.flxoa.info.system.dao.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.flx.flxoa.info.system.entity.FlxoaSystemUserGroup;
import com.flx.flxoa.info.system.entity.FlxoaSystemUserGroupDepartment;
import com.flx.flxoa.info.system.dao.FlxoaSystemUserGroupDao;
import org.springframework.stereotype.Repository;
import com.flx.flxoa.common.hibernate3.HibernateBaseDao;
import com.flx.flxoa.common.util.CommonUtils;

/**
 *
 * 类名称：FlxoaSystemUserGroupDaoImpl.java
 * 类描述：
 * 创建时间：2018-03-28, 上午11:16:41
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 赵鹏辉 
 */ 
@Repository
public class FlxoaSystemUserGroupDaoImpl extends HibernateBaseDao<FlxoaSystemUserGroup, Integer> implements FlxoaSystemUserGroupDao {
	/**
	 *添加FlxoaSystemUserGroup
	 */ 
	public boolean add(FlxoaSystemUserGroup flxoaSystemUserGroup) {
		return save(flxoaSystemUserGroup);
	}
	/**
	 *删除FlxoaSystemUserGroup
	 */ 
	public boolean delete(FlxoaSystemUserGroup flxoaSystemUserGroup) {
		return del(flxoaSystemUserGroup);
	}
	/**
	 *修改FlxoaSystemUserGroup
	 */ 
	public boolean update(FlxoaSystemUserGroup flxoaSystemUserGroup) {
		return modify(flxoaSystemUserGroup);
	}
	/**
	 *查询FlxoaSystemUserGroup列表
	 */ 
	public List<FlxoaSystemUserGroup> query(FlxoaSystemUserGroup flxoaSystemUserGroup) {
		String hql = " from FlxoaSystemUserGroup where delete_flag = '0' ";
		return getListByHQL(hql, null);
	}
	/**
	 *查询FlxoaSystemUserGroup ByID
	 */ 
	public FlxoaSystemUserGroup queryById(FlxoaSystemUserGroup flxoaSystemUserGroup) {
		return get(flxoaSystemUserGroup.getId());
	}
	/**
	 *分页FlxoaSystemUserGroup pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public String queryForPage(int start,int length,String userGroupName,String draw) {
		//查询hql语句
		String hql=" from flxoa_system_user_group userGroup left join flxoa_system_user sysUser on userGroup.create_user_id=sysUser.id left join flxoa_system_department dept on userGroup.create_department_id=dept.id " +
				"where userGroup.delete_flag='0' and sysUser.delete_flag='0' and dept.delete_flag='0'";

		if(!CommonUtils.isEmpty(userGroupName)){
			hql+=" and userGroup.name like'%";
			hql+=userGroupName;
			hql+="%'";	
		}
		hql+=" order by userGroup.id desc";
		//查询参数
		String querySql="select userGroup.id,userGroup.name,sysUser.real_name,dept.name,userGroup.create_time"+hql;

		//求和查询sql
		String countSql="select count(*) "+hql;

		List list= queryListForPageBySQL(start, length, querySql);
		List<Map<String,String>> dataList=new ArrayList<Map<String,String>>();
		List<Map<String,String>> otherDataList=new ArrayList<Map<String,String>>();

		for(int i=0;i<list.size();i++){
			Map<String,String> dataMap=new HashMap<String,String>();
			Object[] obj=(Object[]) list.get(i);
			dataMap.put("userGroupId", String.valueOf(obj[0]));
			dataMap.put("userGroupName", String.valueOf(obj[1]));
			dataMap.put("createUser", String.valueOf(obj[2]));
			dataMap.put("deptName", String.valueOf(obj[3]));
			dataMap.put("createTime", String.valueOf(obj[4]));
			dataList.add(dataMap);
		}
		Long totalCount= countBySql(countSql,null);
		Map<String,String> otherDataMap=new HashMap<String,String>();
		otherDataList.add(otherDataMap);
		return CommonUtils.getPageJson(start,length,draw,totalCount,dataList,otherDataList);
	}
	/**
	 *查询FlxoaSystemUserGroup数据条数 
	 */ 
	public Long queryCount(FlxoaSystemUserGroup flxoaSystemUserGroup) {
		String hql = "select count(*) from FlxoaSystemUserGroup where delete_flag = '0' ";
		return countByHql(hql,null);
	}
	/**
	 *分页FlxoaSystemUserGroup pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List quanxianList(int pageNo,int pageSize,FlxoaSystemUserGroup flxoaSystemUserGroup) {
		String sql="select userGroup.id,userGroupUser.groupUserId,userGroupRole.groupRoleId,userGroupDepartment.groupDepartmentId,userGroup.name," +
				"userGroupUser.userName,userGroupRole.roleName,userGroupDepartment.departmentName from flxoa_system_user_group userGroup left join " +
				"(select groupUser.id groupUserId,groupUser.user_group_id,sysUser.real_name userName from flxoa_system_user_group_user groupUser " +
				"left join flxoa_system_user sysUser on groupUser.user_id=sysUser.id where groupUser.delete_flag = '0' and sysUser.delete_flag='0')userGroupUser on userGroup.id=userGroupUser.user_group_id " +
				"left join (select groupRole.id groupRoleId,groupRole.user_group_id,sysRole.name roleName from flxoa_system_user_group_role groupRole " +
				"left join flxoa_system_role sysRole on groupRole.role_id=sysRole.id where groupRole.delete_flag = '0' and sysRole.delete_flag='0')userGroupRole " +
				"on userGroup.id=userGroupRole.user_group_id left join (select groupDepartment.id groupDepartmentId,groupDepartment.user_group_id,sysDepartment.name departmentName from " +
				"flxoa_system_user_group_department groupDepartment left join flxoa_system_department sysDepartment on groupDepartment.department_id=sysDepartment.id " +
				"where groupDepartment.delete_flag = '0' and sysDepartment.delete_flag='0' )userGroupDepartment on userGroup.id=userGroupDepartment.user_group_id where userGroup.delete_flag = '0'";
		return queryListForPageBySQL(pageNo, pageSize, sql,null);
	}
	/**
	 *查询FlxoaSystemUserGroup数据条数 
	 */ 
	public Long quanxianCount(FlxoaSystemUserGroup flxoaSystemUserGroup) {
		String sql="select count(*) from flxoa_system_user_group userGroup left join " +
				"(select groupUser.id groupUserId,groupUser.user_group_id,sysUser.real_name userName from flxoa_system_user_group_user groupUser " +
				"left join flxoa_system_user sysUser on groupUser.user_id=sysUser.id where groupUser.delete_flag = '0' and sysUser.delete_flag='0')userGroupUser on userGroup.id=userGroupUser.user_group_id " +
				"left join (select groupRole.id groupRoleId,groupRole.user_group_id,sysRole.name roleName from flxoa_system_user_group_role groupRole " +
				"left join flxoa_system_role sysRole on groupRole.role_id=sysRole.id where groupRole.delete_flag = '0' and sysRole.delete_flag='0')userGroupRole " +
				"on userGroup.id=userGroupRole.user_group_id left join (select groupDepartment.id groupDepartmentId,groupDepartment.user_group_id,sysDepartment.name departmentName from " +
				"flxoa_system_user_group_department groupDepartment left join flxoa_system_department sysDepartment on groupDepartment.department_id=sysDepartment.id " +
				"where groupDepartment.delete_flag = '0' and sysDepartment.delete_flag='0' )userGroupDepartment on userGroup.id=userGroupDepartment.user_group_id where userGroup.delete_flag = '0'";
		return countBySql(sql,null);
	}

	/**
	 *查询
	 */ 
	public long getGroupName(FlxoaSystemUserGroup flxoaSystemUserGroup) {
		String hql = "select count(*) from FlxoaSystemUserGroup where delete_flag = '0' and name=? ";
		Object[] obj={flxoaSystemUserGroup.getName()};
		return countByHql(hql,obj);
	}

	/**
	 *查询
	 */ 
	public List<Object> queryList(FlxoaSystemUserGroup flxoaSystemUserGroup) {
		String hql = "select count(*) from FlxoaSystemUserGroup where delete_flag = '0' and name=? ";
		Object[] obj={flxoaSystemUserGroup.getId()};
		return null;
	}


	@Override
	protected Class<FlxoaSystemUserGroup> getEntityClass() {
		return FlxoaSystemUserGroup.class;
	} 

}