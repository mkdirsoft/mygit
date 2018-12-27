package com.flx.flxoa.info.system.dao.impl;


import java.util.ArrayList;
import java.util.List;

import com.flx.flxoa.info.projectmanagement.entity.FlxoaProjectInformation;
import com.flx.flxoa.info.system.entity.FlxoaSystemRoleFuncation;
import com.flx.flxoa.info.system.entity.FlxoaSystemUser;
import com.flx.flxoa.info.system.dao.FlxoaSystemRoleFuncationDao;
import org.springframework.stereotype.Repository;
import com.flx.flxoa.common.hibernate3.HibernateBaseDao;

/**
 *
 * 类名称：FlxoaSystemRoleFuncationDaoImpl.java
 * 类描述：
 * 创建时间：2018-03-28, 上午10:17:54
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 雷君 
 */ 
@Repository
public class FlxoaSystemRoleFuncationDaoImpl extends HibernateBaseDao<FlxoaSystemRoleFuncation, Integer> implements FlxoaSystemRoleFuncationDao {
	/**
	 *添加FlxoaSystemRoleFuncation
	 */ 
	public boolean add(FlxoaSystemRoleFuncation flxoaSystemRoleFuncation) {
		return save(flxoaSystemRoleFuncation);
	}
	/**
	 *删除FlxoaSystemRoleFuncation
	 */ 
	public boolean delete(FlxoaSystemRoleFuncation flxoaSystemRoleFuncation) {
		flxoaSystemRoleFuncation.setDeleteFlag("1");
		return save(flxoaSystemRoleFuncation);
	}
	/**
	 *修改FlxoaSystemRoleFuncation
	 */ 
	public boolean update(FlxoaSystemRoleFuncation flxoaSystemRoleFuncation) {
		return modify(flxoaSystemRoleFuncation);
	}
	/**
	 *查询FlxoaSystemRoleFuncation列表
	 */ 
	public List<FlxoaSystemRoleFuncation> query(FlxoaSystemRoleFuncation flxoaSystemRoleFuncation) {
		String  sql = " select "
				+ "flxoa_system_role.name roleName, "
				+ "flxoa_system_funcation.name funName, "
				+ "flxoa_system_role_funcation.id, "
				+ "flxoa_system_role_funcation.role_id,"
				+ "flxoa_system_role_funcation.funcation_id "
				+ "from "
				+ "flxoa_system_role_funcation "
				+ "left join flxoa_system_role on flxoa_system_role_funcation.role_id = flxoa_system_role.id "
				+ "left join "
				+ "flxoa_system_funcation on flxoa_system_role_funcation.funcation_id = flxoa_system_funcation.id"; 
			sql += " where flxoa_system_role_funcation.delete_flag = '0'";
		if(flxoaSystemRoleFuncation.getRoleName() != null  &&  !"".equals(flxoaSystemRoleFuncation.getRoleName())) {
			sql += " and flxoa_system_role.name =  '"+flxoaSystemRoleFuncation.getRoleName()+"'";
		}
		if(null != flxoaSystemRoleFuncation.getRoleId()){
			sql += " and flxoa_system_role_funcation.role_id =  '"+flxoaSystemRoleFuncation.getRoleId()+"'";
		}
		List list = getListBySQL(sql, null);
		List<FlxoaSystemRoleFuncation> formList = new ArrayList<FlxoaSystemRoleFuncation>();
		for (int i = 0; i < list.size(); i++) {
			FlxoaSystemRoleFuncation form = new FlxoaSystemRoleFuncation();
			Object[] objects = (Object[])list.get(i);
			form.setRoleName(String.valueOf(objects[0]));
			form.setFunctionName(String.valueOf(objects[1]));
			form.setId((Integer)objects[2]);
			form.setRoleId((Integer)objects[3]);
			form.setFuncationId((Integer)objects[4]);
			formList.add(form);
		}
		return formList;
	}
	/**
	 *查询FlxoaSystemRoleFuncation ByID
	 */ 
	public FlxoaSystemRoleFuncation queryById(FlxoaSystemRoleFuncation flxoaSystemRoleFuncation) {
		return get(flxoaSystemRoleFuncation.getId());
	}
	/**
	 *分页FlxoaSystemRoleFuncation pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<FlxoaSystemRoleFuncation> queryForPage(int pageNo,int pageSize,FlxoaSystemRoleFuncation flxoaSystemRoleFuncation) {
		String hql = " from FlxoaSystemRoleFuncation where delete_flag = '0' ";
		return queryForPageByHQL(pageNo, pageSize, hql);
	}
	/**
	 *删除FlxoaSystemRole
	 */ 
	public boolean deleteByName(FlxoaSystemRoleFuncation flxoaSystemRoleFuncation) {
		String sql = "delete from flxoa_system_role_funcation Where role_id='"+flxoaSystemRoleFuncation.getRoleId()+"'";
		executeSql(sql,null);
		return true;
	}

	/**
	 *查询FlxoaSystemRoleFuncation数据条数 
	 */ 
	public Long queryCount(FlxoaSystemRoleFuncation flxoaSystemRoleFuncation) {
		String hql = "select count(*) from FlxoaSystemRoleFuncation where delete_flag = '0' ";
		return countByHql(hql,null);
	}
	/**
	 *查询FlxoaProjectInformation列表
	 */ 
	public List<FlxoaSystemRoleFuncation> querySql(FlxoaSystemRoleFuncation flxoaSystemRoleFuncation) {
		String sql ="select proj_state,count(*) as count from flxoa_project_information group by proj_state";
		return querySQL(sql, null);
	}
	
	@Override
	protected Class<FlxoaSystemRoleFuncation> getEntityClass() {
		return FlxoaSystemRoleFuncation.class;
	} 

}