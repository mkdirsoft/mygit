package com.flx.flxoa.info.system.dao.impl;


import java.util.List;

import com.flx.flxoa.info.system.entity.FlxoaSystemUserGroup;
import com.flx.flxoa.info.system.entity.FlxoaSystemUserGroupUser;
import com.flx.flxoa.info.system.dao.FlxoaSystemUserGroupUserDao;
import org.springframework.stereotype.Repository;
import com.flx.flxoa.common.hibernate3.HibernateBaseDao;

/**
 *
 * 类名称：FlxoaSystemUserGroupUserDaoImpl.java
 * 类描述：
 * 创建时间：2018-03-28, 上午11:15:33
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 赵鹏辉 
 */ 
@Repository
public class FlxoaSystemUserGroupUserDaoImpl extends HibernateBaseDao<FlxoaSystemUserGroupUser, Integer> implements FlxoaSystemUserGroupUserDao {
	/**
	 *添加FlxoaSystemUserGroupUser
	 */ 
	public boolean add(FlxoaSystemUserGroupUser flxoaSystemUserGroupUser) {
		return save(flxoaSystemUserGroupUser);
	}
	/**
	 *删除FlxoaSystemUserGroupUser
	 */ 
	public boolean delete(FlxoaSystemUserGroupUser flxoaSystemUserGroupUser) {
		return del(flxoaSystemUserGroupUser);
	}
	/**
	 *修改FlxoaSystemUserGroupUser
	 */ 
	public boolean update(FlxoaSystemUserGroupUser flxoaSystemUserGroupUser) {
		return modify(flxoaSystemUserGroupUser);
	}
	/**
	 *查询FlxoaSystemUserGroupUser列表
	 */ 
	public List<FlxoaSystemUserGroupUser> query(FlxoaSystemUserGroupUser flxoaSystemUserGroupUser) {
		String hql = " from FlxoaSystemUserGroupUser where delete_flag = '0' ";
		return getListByHQL(hql, null);
	}
	/**
	 *查询FlxoaSystemUserGroupUser ByID
	 */ 
	public FlxoaSystemUserGroupUser queryById(FlxoaSystemUserGroupUser flxoaSystemUserGroupUser) {
		return get(flxoaSystemUserGroupUser.getId());
	}
	/**
	 *分页FlxoaSystemUserGroupUser pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<FlxoaSystemUserGroupUser> queryForPage(int pageNo,int pageSize,FlxoaSystemUserGroupUser flxoaSystemUserGroupUser) {
		String hql = " from FlxoaSystemUserGroupUser where delete_flag = '0' ";
		return queryForPageByHQL(pageNo, pageSize, hql);
	}
	/**
	 *查询FlxoaSystemUserGroupUser数据条数 
	 */ 
	public Long queryCount(FlxoaSystemUserGroupUser flxoaSystemUserGroupUser) {
		String hql = "select count(*) from FlxoaSystemUserGroupUser where delete_flag = '0' ";
		return countByHql(hql,null);
	}
	/**
	 * 删除
	 */
	public boolean deleteByGroupId(FlxoaSystemUserGroupUser flxoaSystemUserGroupUser){
		String sql="delete from FlxoaSystemUserGroupUser where user_group_id=?";
		Object[] param=new Object[flxoaSystemUserGroupUser.getUserGroupId()];
		executeSql(sql,param);
		return true;
	}
	
	/**
	 * 查询
	 * @param flxoaSystemUserGroup
	 * @return
	 */
	public List<FlxoaSystemUserGroupUser> queryByGroupId(FlxoaSystemUserGroup flxoaSystemUserGroup){
		String hql = " from FlxoaSystemUserGroupUser where delete_flag = '0' and user_group_id=? ";
		Object[] object=new Object[flxoaSystemUserGroup.getId()]; 
		return getListByHQL(hql, object);
	}
	
	
	@Override
	protected Class<FlxoaSystemUserGroupUser> getEntityClass() {
		return FlxoaSystemUserGroupUser.class;
	} 

}