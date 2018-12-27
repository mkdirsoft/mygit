package com.flx.flxoa.info.system.dao.impl;


import java.util.ArrayList;
import java.util.List;
import com.flx.flxoa.info.system.entity.FlxoaSystemRole;
import com.flx.flxoa.info.system.entity.FlxoaSystemRoleFuncation;
import com.flx.flxoa.info.system.entity.FlxoaSystemUserRole;
import com.flx.flxoa.info.system.dao.FlxoaSystemRoleDao;
import org.springframework.stereotype.Repository;
import com.flx.flxoa.common.hibernate3.HibernateBaseDao;

/**
 *
 * 类名称：FlxoaSystemRoleDaoImpl.java
 * 类描述：
 * 创建时间：2018-03-28, 上午09:18:54
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 雷君 
 */ 
@Repository
public class FlxoaSystemRoleDaoImpl extends HibernateBaseDao<FlxoaSystemRole, Integer> implements FlxoaSystemRoleDao {
	/**
	 *添加FlxoaSystemRole
	 */ 
	public boolean add(FlxoaSystemRole flxoaSystemRole) {
		return save(flxoaSystemRole);
	}
	/**
	 *删除FlxoaSystemRole
	 */ 
	public boolean delete(FlxoaSystemRole flxoaSystemRole) {
		flxoaSystemRole.setDeleteFlag("1");
		return save(flxoaSystemRole);
	}
	
	/**
	 *修改FlxoaSystemRole
	 */ 
	public boolean update(FlxoaSystemRole flxoaSystemRole) {
		return modify(flxoaSystemRole);
	}
	
	
	public List<FlxoaSystemRole> queryRoleId(FlxoaSystemRole flxoaSystemRole) {
		String hql = " from FlxoaSystemRole where delete_flag ='0' ";
		return getListByHQL(hql, null);
	}
	/**
	 *查询FlxoaSystemRole列表
	 */ 
	public List<FlxoaSystemRole> query(FlxoaSystemRole flxoaSystemRole) {
		String sql = " select "
				+ "flxoa_system_role.id roid, "
				+ "flxoa_system_role.name, "
				+ "flxoa_system_funcation.name fun_name, "
				+ "flxoa_system_funcation.url, "
				+ "flxoa_system_role_funcation.id "
				+ "FROM "
				+ "flxoa_system_role "
				+ "LEFT JOIN flxoa_system_role_funcation ON flxoa_system_role_funcation.role_id = flxoa_system_role.id "
				+ "LEFT JOIN flxoa_system_funcation ON flxoa_system_role_funcation.funcation_id = flxoa_system_funcation.id "; 
				sql += " where flxoa_system_role.delete_flag = '0' ";
		if(flxoaSystemRole.getRoid() != null && !"".equals(flxoaSystemRole.getRoid())) {
			sql +=" and roid = '"+flxoaSystemRole.getRoid()+"' ";
		}
		List list = getListBySQL(sql, null);
		List<FlxoaSystemRole> formList = new ArrayList<FlxoaSystemRole>();
		for (int i = 0; i < list.size(); i++) {
			FlxoaSystemRole form = new FlxoaSystemRole();
			Object[] objects = (Object[])list.get(i);
			form.setRoid(String.valueOf(objects[0]));
			form.setName(String.valueOf(objects[1]));
			form.setFun_name(String.valueOf(objects[2]));
			form.setUrl(String.valueOf(objects[3]));
			formList.add(form);
		}
		return formList;
	}
	/**
	 *查询FlxoaSystemRole列表
	 */ 
	public List<FlxoaSystemRole> querySql(FlxoaSystemRole flxoaSystemRole) {
		String sql = " select * from  flxoa_system_role  where name='"+flxoaSystemRole.getName()+"' ";
		return querySQL(sql, null);
	}
	/**
	 *查询FlxoaSystemRole ByID
	 */ 
	public FlxoaSystemRole queryById(FlxoaSystemRole flxoaSystemRole) {
		return get(flxoaSystemRole.getId());
	}
	/**
	 *分页FlxoaSystemRole pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<FlxoaSystemRole> queryForPage(int pageNo,int pageSize,FlxoaSystemRole flxoaSystemRole) {
		String hql = " from FlxoaSystemRole where delete_flag = '0' ";
		if(flxoaSystemRole.getName() != null && !"".equals(flxoaSystemRole.getName())) {
			hql += " and name like '%"+flxoaSystemRole.getName() +"%'";
		}
			hql += " order by id";
		return queryForPageByHQL(pageNo, pageSize, hql);
	}
	/**
	 *删除FlxoaSystemRole  deleteById
	 */ 
	public boolean deleteByName(FlxoaSystemRole flxoaSystemRole) {
		String sql = "delete from flxoa_system_role Where role_id='"+flxoaSystemRole.getId()+"'";
		System.out.println("hql"+sql);
		executeSql(sql,null);
		return true;
	}
	/**
	 *删除FlxoaSystemRole  deleteById
	 */ 
	public boolean deleteById(FlxoaSystemRole flxoaSystemRole) {
		deleteById(flxoaSystemRole.getId());
		System.out.println("flxoaSystemRole.getId()====="+flxoaSystemRole.getId());
		return true;
	}
	
	/**
	 *查询FlxoaSystemRole数据条数 
	 */ 
	public Long queryCount(FlxoaSystemRole flxoaSystemRole) {
		String hql = "select count(*) from FlxoaSystemRole where delete_flag = '0' ";
		return countByHql(hql,null);
	}
	
	@Override
	protected Class<FlxoaSystemRole> getEntityClass() {
		return FlxoaSystemRole.class;
	}
	@Override
	public boolean isExist(String username) {
		String hql="from FlxoaSystemRole where name='"+username+"' ";
		List list=queryByHQL(hql);
		if(list.size()<1){
			return true;
		}
		return false;
	} 

}