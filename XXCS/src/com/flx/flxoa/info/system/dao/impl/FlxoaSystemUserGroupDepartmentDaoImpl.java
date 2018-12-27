package com.flx.flxoa.info.system.dao.impl;


import java.util.List;

import com.flx.flxoa.info.system.entity.FlxoaSystemUserGroup;
import com.flx.flxoa.info.system.entity.FlxoaSystemUserGroupDepartment;
import com.flx.flxoa.info.system.entity.FlxoaSystemUserGroupRole;
import com.flx.flxoa.info.system.dao.FlxoaSystemUserGroupDepartmentDao;
import org.springframework.stereotype.Repository;
import com.flx.flxoa.common.hibernate3.HibernateBaseDao;

/**
 *
 * 类名称：FlxoaSystemUserGroupDepartmentDaoImpl.java
 * 类描述：
 * 创建时间：2018-03-29, 上午09:35:52
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 赵鹏辉 
 */ 
@Repository
public class FlxoaSystemUserGroupDepartmentDaoImpl extends HibernateBaseDao<FlxoaSystemUserGroupDepartment, Integer> implements FlxoaSystemUserGroupDepartmentDao {
	/**
	 *添加FlxoaSystemUserGroupDepartment
	 */ 
	public boolean add(FlxoaSystemUserGroupDepartment flxoaSystemUserGroupDepartment) {
		return save(flxoaSystemUserGroupDepartment);
	}
	/**
	 *删除FlxoaSystemUserGroupDepartment
	 */ 
	public boolean delete(FlxoaSystemUserGroupDepartment flxoaSystemUserGroupDepartment) {
		return del(flxoaSystemUserGroupDepartment);
	}
	/**
	 *修改FlxoaSystemUserGroupDepartment
	 */ 
	public boolean update(FlxoaSystemUserGroupDepartment flxoaSystemUserGroupDepartment) {
		return modify(flxoaSystemUserGroupDepartment);
	}
	/**
	 *查询FlxoaSystemUserGroupDepartment列表
	 */ 
	public List<FlxoaSystemUserGroupDepartment> query(FlxoaSystemUserGroupDepartment flxoaSystemUserGroupDepartment) {
		String hql = " from FlxoaSystemUserGroupDepartment where delete_flag = '0' ";
		return getListByHQL(hql, null);
	}
	/**
	 *查询FlxoaSystemUserGroupDepartment ByID
	 */ 
	public FlxoaSystemUserGroupDepartment queryById(FlxoaSystemUserGroupDepartment flxoaSystemUserGroupDepartment) {
		return get(flxoaSystemUserGroupDepartment.getId());
	}
	/**
	 *分页FlxoaSystemUserGroupDepartment pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<FlxoaSystemUserGroupDepartment> queryForPage(int pageNo,int pageSize,FlxoaSystemUserGroupDepartment flxoaSystemUserGroupDepartment) {
		String hql = " from FlxoaSystemUserGroupDepartment where delete_flag = '0' ";
		return queryForPageByHQL(pageNo, pageSize, hql);
	}
	/**
	 *查询FlxoaSystemUserGroupDepartment数据条数 
	 */ 
	public Long queryCount(FlxoaSystemUserGroupDepartment flxoaSystemUserGroupDepartment) {
		String hql = "select count(*) from FlxoaSystemUserGroupDepartment where delete_flag = '0' ";
		return countByHql(hql,null);
	}
	/**
	 * 删除
	 */
	public boolean deleteByGroupId(FlxoaSystemUserGroupDepartment flxoaSystemUserGroupDepartment){
		String sql="delete from FlxoaSystemUserGroupDepartment where user_group_id=?";
		Object[] param=new Object[flxoaSystemUserGroupDepartment.getUserGroupId()];
		executeSql(sql,param);
		return true;
	}
	/**
	 * 查询
	 * @param FlxoaSystemUserGroupDepartment
	 * @return
	 */
	public List<FlxoaSystemUserGroupDepartment> queryByGroupId(FlxoaSystemUserGroup flxoaSystemUserGroup){
		String hql = " from FlxoaSystemUserGroupDepartment where delete_flag = '0' and user_group_id=? ";
		Object[] object=new Object[flxoaSystemUserGroup.getId()]; 
		return getListByHQL(hql, object);
	}
	@Override
	protected Class<FlxoaSystemUserGroupDepartment> getEntityClass() {
		return FlxoaSystemUserGroupDepartment.class;
	} 

}