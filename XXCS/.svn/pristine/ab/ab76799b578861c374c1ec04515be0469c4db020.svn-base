package com.flx.flxoa.info.system.dao.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.flx.flxoa.info.system.entity.FlxoaSystemUser;
import com.flx.flxoa.info.system.entity.FlxoaSystemUserRole;
import com.flx.flxoa.info.system.dao.FlxoaSystemUserRoleDao;
import org.springframework.stereotype.Repository;
import com.flx.flxoa.common.hibernate3.HibernateBaseDao;
import com.flx.flxoa.common.util.CommonUtils;

/**
 *
 * 类名称：FlxoaSystemUserRoleDaoImpl.java
 * 类描述：
 * 创建时间：2018-04-02, 下午02:21:42
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 雷君 
 */ 
@Repository
public class FlxoaSystemUserRoleDaoImpl extends HibernateBaseDao<FlxoaSystemUserRole, Integer> implements FlxoaSystemUserRoleDao {
	/**
	 *添加FlxoaSystemUserRole
	 */ 
	public boolean add(FlxoaSystemUserRole flxoaSystemUserRole) {
		return save(flxoaSystemUserRole);
	}
	/**
	 *删除FlxoaSystemUserRole
	 */ 
	public boolean delete(FlxoaSystemUserRole flxoaSystemUserRole) {
		flxoaSystemUserRole.setDeleteFlag("1");
		return save(flxoaSystemUserRole);
	}
	/**
	 *修改FlxoaSystemUserRole
	 */ 
	public boolean update(FlxoaSystemUserRole flxoaSystemUserRole) {
		return modify(flxoaSystemUserRole);
	}
	/**
	 *查询FlxoaSystemUserRole列表
	 */ 
	public List<FlxoaSystemUserRole> query(FlxoaSystemUserRole flxoaSystemUserRole) {
		String sql = " select flxoa_system_user_role.id, flxoa_system_role.name,flxoa_system_user.real_name,flxoa_system_department.name as dname,flxoa_system_user_role.delete_flag  from flxoa_system_user_role left join flxoa_system_role on flxoa_system_user_role.role_id=flxoa_system_role.id left join flxoa_system_user on flxoa_system_user_role.user_id=flxoa_system_user.id left join flxoa_system_department on flxoa_system_user_role.department_id=flxoa_system_department.id";
			   sql +="  where flxoa_system_user_role.delete_flag = '0'";
		if(null != flxoaSystemUserRole){
			if(flxoaSystemUserRole.getRoleName() != null && !"".equals(flxoaSystemUserRole.getRoleName())){
				sql += "  and flxoa_system_role.name ='"+flxoaSystemUserRole.getRoleName()+"'";
			}
			if(flxoaSystemUserRole.getUserName() != null && !"".equals(flxoaSystemUserRole.getUserName())){
				sql += "  and flxoa_system_user.real_name ='"+flxoaSystemUserRole.getUserName()+"'";
			}			
		}	   
		List list = getListBySQL(sql, null);
		List<FlxoaSystemUserRole> formList = new ArrayList<FlxoaSystemUserRole>();
		for (int i = 0; i < list.size(); i++) {
			FlxoaSystemUserRole form = new FlxoaSystemUserRole();
			Object[] objects = (Object[])list.get(i);
			form.setId((Integer)objects[0]);
			form.setRoleName(String.valueOf(objects[1]));
			form.setUserName(String.valueOf(objects[2]));
			form.setFuncationName(String.valueOf(objects[3]));
			formList.add(form);
		}
		return formList;
	}
	/**
	 *查询FlxoaSystemUserRole ByID
	 */ 
	public FlxoaSystemUserRole queryById(FlxoaSystemUserRole flxoaSystemUserRole) {
		return get(flxoaSystemUserRole.getId());
	}
	/**
	 *分页FlxoaSystemUserRole pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public String queryForPage(int pageNo,int pageSize,String draw,FlxoaSystemUserRole flxoaSystemUserRole) {
		String sql = " select flxoa_system_user_role.id, flxoa_system_role.name,flxoa_system_user.real_name,flxoa_system_department.name as dname,flxoa_system_user_role.delete_flag  from flxoa_system_user_role left join flxoa_system_role on flxoa_system_user_role.role_id=flxoa_system_role.id left join flxoa_system_user on flxoa_system_user_role.user_id=flxoa_system_user.id left join flxoa_system_department on flxoa_system_user_role.department_id=flxoa_system_department.id";
		   sql +="  where flxoa_system_user_role.delete_flag = '0'";
	if(null != flxoaSystemUserRole){
		if(flxoaSystemUserRole.getRoleName() != null && !"".equals(flxoaSystemUserRole.getRoleName())){
			sql += "  and flxoa_system_role.name ='"+flxoaSystemUserRole.getRoleName()+"'";
		}
		if(flxoaSystemUserRole.getUserName() != null && !"".equals(flxoaSystemUserRole.getUserName())){
			sql += "  and flxoa_system_user.real_name ='"+flxoaSystemUserRole.getUserName()+"'";
		}			
	}	   
	List list = queryListForPageBySQL(pageNo, pageSize, sql);
	String countSql = "select count(*)  from flxoa_system_user_role left join flxoa_system_role on flxoa_system_user_role.role_id=flxoa_system_role.id left join flxoa_system_user on flxoa_system_user_role.user_id=flxoa_system_user.id left join flxoa_system_department on flxoa_system_user_role.department_id=flxoa_system_department.id";
	countSql +="  where flxoa_system_user_role.delete_flag = '0'";
				if(flxoaSystemUserRole.getRoleName() != null && !"".equals(flxoaSystemUserRole.getRoleName())){
					countSql += "  and flxoa_system_role.name ='"+flxoaSystemUserRole.getRoleName()+"'";
				}
				if(flxoaSystemUserRole.getUserName() != null && !"".equals(flxoaSystemUserRole.getUserName())){
					countSql += "  and flxoa_system_user.real_name ='"+flxoaSystemUserRole.getUserName()+"'";
				}			
	Long totalCount= countBySql(countSql,null);//获取数据总数，用于分页
	List<Map<String,String>> formList = new ArrayList<Map<String,String>>();
	for (int i = 0; i < list.size(); i++) {
		Map<String,String> form = new HashMap<String,String>();
		Object[] objects = (Object[])list.get(i);
//		form.setId((Integer)objects[0]);
//		form.setRoleName(String.valueOf(objects[1]));
//		form.setUserName(String.valueOf(objects[2]));
//		form.setFuncationName(String.valueOf(objects[3]));
		form.put("id", String.valueOf(objects[0]));
		form.put("roleName", String.valueOf(objects[1]));
		form.put("userName", String.valueOf(objects[2]));
		form.put("funcationName", String.valueOf(objects[3]));
		formList.add(form);
		}
		return CommonUtils.getPageJson(pageNo, pageSize, draw, totalCount, formList, null);
	}
	/**
	 *查询FlxoaSystemUserRole数据条数 
	 */ 
	public Long queryCount(FlxoaSystemUserRole flxoaSystemUserRole) {
		String hql = "select count(*) from FlxoaSystemUserRole where delete_flag = '0' ";
		return countByHql(hql,null);
	}
	
	@Override
	protected Class<FlxoaSystemUserRole> getEntityClass() {
		return FlxoaSystemUserRole.class;
	} 

}