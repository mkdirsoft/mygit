package com.flx.flxoa.info.system.dao.impl;


import java.util.List;

import com.flx.flxoa.info.system.entity.FlxoaSystemUserGroup;
import com.flx.flxoa.info.system.entity.FlxoaSystemUserGroupRole;
import com.flx.flxoa.info.system.entity.FlxoaSystemUserGroupUser;
import com.flx.flxoa.info.system.dao.FlxoaSystemUserGroupRoleDao;
import org.springframework.stereotype.Repository;
import com.flx.flxoa.common.hibernate3.HibernateBaseDao;

/**
 *
 * 类名称：FlxoaSystemUserGroupRoleDaoImpl.java
 * 类描述：
 * 创建时间：2018-03-28, 上午11:15:33
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 赵鹏辉 
 */ 
@Repository
public class FlxoaSystemUserGroupRoleDaoImpl extends HibernateBaseDao<FlxoaSystemUserGroupRole, Integer> implements FlxoaSystemUserGroupRoleDao {
	/**
	 *添加FlxoaSystemUserGroupRole
	 */ 
	public boolean add(FlxoaSystemUserGroupRole flxoaSystemUserGroupRole) {
		return save(flxoaSystemUserGroupRole);
	}
	/**
	 *删除FlxoaSystemUserGroupRole
	 */ 
	public boolean delete(FlxoaSystemUserGroupRole flxoaSystemUserGroupRole) {
		return del(flxoaSystemUserGroupRole);
	}
	/**
	 *修改FlxoaSystemUserGroupRole
	 */ 
	public boolean update(FlxoaSystemUserGroupRole flxoaSystemUserGroupRole) {
		return modify(flxoaSystemUserGroupRole);
	}
	/**
	 *查询FlxoaSystemUserGroupRole列表
	 */ 
	public List<FlxoaSystemUserGroupRole> query(FlxoaSystemUserGroupRole flxoaSystemUserGroupRole) {
		String hql = " from FlxoaSystemUserGroupRole where delete_flag = '0' ";
		return getListByHQL(hql, null);
	}
	/**
	 *查询FlxoaSystemUserGroupRole ByID
	 */ 
	public FlxoaSystemUserGroupRole queryById(FlxoaSystemUserGroupRole flxoaSystemUserGroupRole) {
		return get(flxoaSystemUserGroupRole.getId());
	}
	/**
	 *分页FlxoaSystemUserGroupRole pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<FlxoaSystemUserGroupRole> queryForPage(int pageNo,int pageSize,FlxoaSystemUserGroupRole flxoaSystemUserGroupRole) {
		String hql = " from FlxoaSystemUserGroupRole where delete_flag = '0' ";
		return queryForPageByHQL(pageNo, pageSize, hql);
	}
	/**
	 *查询FlxoaSystemUserGroupRole数据条数 
	 */ 
	public Long queryCount(FlxoaSystemUserGroupRole flxoaSystemUserGroupRole) {
		String hql = "select count(*) from FlxoaSystemUserGroupRole where delete_flag = '0' ";
		return countByHql(hql,null);
	}
	/**
	 * 删除
	 */
	public boolean deleteByGroupId(FlxoaSystemUserGroupRole flxoaSystemUserGroupRole){
		String sql="delete from FlxoaSystemUserGroupRole where user_group_id=?";
		Object[] param=new Object[flxoaSystemUserGroupRole.getUserGroupId()];
		executeSql(sql,param);
		return true;
	}
	/**
	 * 查询
	 * @param flxoaSystemUserGroup
	 * @return
	 */
	public List<FlxoaSystemUserGroupRole> queryByGroupId(FlxoaSystemUserGroup flxoaSystemUserGroup){
		String hql = " from FlxoaSystemUserGroupRole where delete_flag = '0' and user_group_id=? ";
		Object[] object=new Object[flxoaSystemUserGroup.getId()]; 
		return getListByHQL(hql, object);
	}
	@Override
	protected Class<FlxoaSystemUserGroupRole> getEntityClass() {
		return FlxoaSystemUserGroupRole.class;
	} 

}