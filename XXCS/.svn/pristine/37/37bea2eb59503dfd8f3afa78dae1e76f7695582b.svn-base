package com.flx.flxoa.info.system.manager.impl;


import java.util.List;
import com.flx.flxoa.info.system.entity.FlxoaSystemRole;
import com.flx.flxoa.info.system.entity.FlxoaSystemRoleFuncation;
import com.flx.flxoa.info.system.manager.FlxoaSystemRoleService;
import com.flx.flxoa.info.system.dao.FlxoaSystemRoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * 类名称：FlxoaSystemRoleServiceImpl.java
 * 类描述：
 * 创建时间：2018-03-28, 上午09:18:54
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 雷君 
 */ 
@Service
@Transactional
public class FlxoaSystemRoleServiceImpl implements FlxoaSystemRoleService {
	private FlxoaSystemRoleDao dao;
	@Autowired
	public void setDao(FlxoaSystemRoleDao dao) {
		this.dao = dao;
	}
	public FlxoaSystemRoleDao getDao() {
		return dao;
	}
	/**
	 *添加FlxoaSystemRole
	 */ 
	public boolean add(FlxoaSystemRole flxoaSystemRole) {
		boolean result = dao.add(flxoaSystemRole);
		return result;
	}
	/**
	 *删除FlxoaSystemRole
	 */ 
	public boolean delete(FlxoaSystemRole flxoaSystemRole) {
		boolean result = dao.delete(flxoaSystemRole);
		return result;
	}
	
	/**
	 *修改FlxoaSystemRole
	 */ 
	public boolean update(FlxoaSystemRole flxoaSystemRole) {
		boolean result = dao.update(flxoaSystemRole);
		return result;
	}
	
	@Override
	public boolean isExist(String username) {
		boolean result = dao.isExist(username);
		return result;
	}

	/**
	 *查询FlxoaSystemRole列表
	 */ 
	public List<FlxoaSystemRole> query(FlxoaSystemRole flxoaSystemRole) {
		List<FlxoaSystemRole> list = dao.query(flxoaSystemRole);
		return list;
	}
	/**
	 *查询FlxoaSystemRole列表
	 */ 
	public List<FlxoaSystemRole> queryRoleId(FlxoaSystemRole flxoaSystemRole) {
		List<FlxoaSystemRole> list = dao.queryRoleId(flxoaSystemRole);
		return list;
	}
	/**
	 *查询FlxoaSystemRole列表queryRoleId
	 */ 
	public List<FlxoaSystemRole> querySql(FlxoaSystemRole flxoaSystemRole) {
		List<FlxoaSystemRole> list = dao.querySql(flxoaSystemRole);
		
		return list;
	}
	
	/**
	 *删除FlxoaSystemRole
	 */ 
	public boolean deleteByName(FlxoaSystemRole FlxoaSystemRole) {
		boolean result = dao.deleteByName(FlxoaSystemRole);
		return result;
	}
	/**
	 *删除FlxoaSystemRole
	 */ 
	public boolean deleteById(FlxoaSystemRole FlxoaSystemRole) {
		boolean result = dao.deleteById(FlxoaSystemRole);
		return result;
	}

	/**
	 *查询FlxoaSystemRole ByID
	 */ 
	public FlxoaSystemRole queryById(FlxoaSystemRole flxoaSystemRole) {
		FlxoaSystemRole result = dao.queryById(flxoaSystemRole);
		return result;
	}
	/**
	 *分页FlxoaSystemRole pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<FlxoaSystemRole> queryForPage(int pageNo,int pageSize,FlxoaSystemRole flxoaSystemRole) {
		List<FlxoaSystemRole> list = dao.queryForPage(pageNo,pageSize,flxoaSystemRole);
		return list;
	}
	/**
	 *查询FlxoaSystemRole数据条数
	 */ 
	public Long queryCount(FlxoaSystemRole flxoaSystemRole) {
		Long result = dao.queryCount(flxoaSystemRole);
		return result;
	}

	


	
}