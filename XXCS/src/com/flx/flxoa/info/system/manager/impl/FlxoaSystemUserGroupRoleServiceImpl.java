package com.flx.flxoa.info.system.manager.impl;


import java.util.List;
import com.flx.flxoa.info.system.entity.FlxoaSystemUserGroupRole;
import com.flx.flxoa.info.system.entity.FlxoaSystemUserGroupUser;
import com.flx.flxoa.info.system.manager.FlxoaSystemUserGroupRoleService;
import com.flx.flxoa.info.system.dao.FlxoaSystemUserGroupRoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * 类名称：FlxoaSystemUserGroupRoleServiceImpl.java
 * 类描述：
 * 创建时间：2018-03-28, 上午11:15:33
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 赵鹏辉 
 */ 
@Service
@Transactional
public class FlxoaSystemUserGroupRoleServiceImpl implements FlxoaSystemUserGroupRoleService {
	private FlxoaSystemUserGroupRoleDao dao;
	@Autowired
	public void setDao(FlxoaSystemUserGroupRoleDao dao) {
		this.dao = dao;
	}
	public FlxoaSystemUserGroupRoleDao getDao() {
		return dao;
	}
	/**
	 *添加FlxoaSystemUserGroupRole
	 */ 
	public boolean add(FlxoaSystemUserGroupRole flxoaSystemUserGroupRole) {
		boolean result = dao.add(flxoaSystemUserGroupRole);
		return result;
	}
	/**
	 *删除FlxoaSystemUserGroupRole
	 */ 
	public boolean delete(FlxoaSystemUserGroupRole flxoaSystemUserGroupRole) {
		boolean result = dao.delete(flxoaSystemUserGroupRole);
		return result;
	}
	/**
	 *修改FlxoaSystemUserGroupRole
	 */ 
	public boolean update(FlxoaSystemUserGroupRole flxoaSystemUserGroupRole) {
		boolean result = dao.update(flxoaSystemUserGroupRole);
		return result;
	}
	/**
	 *查询FlxoaSystemUserGroupRole列表
	 */ 
	public List<FlxoaSystemUserGroupRole> query(FlxoaSystemUserGroupRole flxoaSystemUserGroupRole) {
		List<FlxoaSystemUserGroupRole> list = dao.query(flxoaSystemUserGroupRole);
		return list;
	}
	/**
	 *查询FlxoaSystemUserGroupRole ByID
	 */ 
	public FlxoaSystemUserGroupRole queryById(FlxoaSystemUserGroupRole flxoaSystemUserGroupRole) {
		FlxoaSystemUserGroupRole result = dao.queryById(flxoaSystemUserGroupRole);
		return result;
	}
	/**
	 *分页FlxoaSystemUserGroupRole pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<FlxoaSystemUserGroupRole> queryForPage(int pageNo,int pageSize,FlxoaSystemUserGroupRole flxoaSystemUserGroupRole) {
		List<FlxoaSystemUserGroupRole> list = dao.queryForPage(pageNo,pageSize,flxoaSystemUserGroupRole);
		return list;
	}
	/**
	 *查询FlxoaSystemUserGroupRole数据条数
	 */ 
	public Long queryCount(FlxoaSystemUserGroupRole flxoaSystemUserGroupRole) {
		Long result = dao.queryCount(flxoaSystemUserGroupRole);
		return result;
	}
	/**
	 * 删除
	 */
	public boolean deleteByGroupId(FlxoaSystemUserGroupRole flxoaSystemUserGroupRole){
		boolean result = dao.deleteByGroupId(flxoaSystemUserGroupRole);
		return result;
	}
}