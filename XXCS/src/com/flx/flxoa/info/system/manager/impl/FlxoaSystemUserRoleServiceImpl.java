package com.flx.flxoa.info.system.manager.impl;


import java.util.List;
import com.flx.flxoa.info.system.entity.FlxoaSystemUserRole;
import com.flx.flxoa.info.system.manager.FlxoaSystemUserRoleService;
import com.flx.flxoa.info.system.dao.FlxoaSystemUserRoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * 类名称：FlxoaSystemUserRoleServiceImpl.java
 * 类描述：
 * 创建时间：2018-04-02, 下午02:21:42
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 雷君 
 */ 
@Service
@Transactional
public class FlxoaSystemUserRoleServiceImpl implements FlxoaSystemUserRoleService {
	private FlxoaSystemUserRoleDao dao;
	@Autowired
	public void setDao(FlxoaSystemUserRoleDao dao) {
		this.dao = dao;
	}
	public FlxoaSystemUserRoleDao getDao() {
		return dao;
	}
	/**
	 *添加FlxoaSystemUserRole
	 */ 
	public boolean add(FlxoaSystemUserRole flxoaSystemUserRole) {
		boolean result = dao.add(flxoaSystemUserRole);
		return result;
	}
	/**
	 *删除FlxoaSystemUserRole
	 */ 
	public boolean delete(FlxoaSystemUserRole flxoaSystemUserRole) {
		boolean result = dao.delete(flxoaSystemUserRole);
		return result;
	}
	/**
	 *修改FlxoaSystemUserRole
	 */ 
	public boolean update(FlxoaSystemUserRole flxoaSystemUserRole) {
		boolean result = dao.update(flxoaSystemUserRole);
		return result;
	}
	/**
	 *查询FlxoaSystemUserRole列表
	 */ 
	public List<FlxoaSystemUserRole> query(FlxoaSystemUserRole flxoaSystemUserRole) {
		List<FlxoaSystemUserRole> list = dao.query(flxoaSystemUserRole);
		return list;
	}
	/**
	 *查询FlxoaSystemUserRole ByID
	 */ 
	public FlxoaSystemUserRole queryById(FlxoaSystemUserRole flxoaSystemUserRole) {
		FlxoaSystemUserRole result = dao.queryById(flxoaSystemUserRole);
		return result;
	}
	/**
	 *分页FlxoaSystemUserRole pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public String queryForPage(int pageNo,int pageSize,String draw,FlxoaSystemUserRole flxoaSystemUserRole) {
		return dao.queryForPage(pageNo,pageSize,draw,flxoaSystemUserRole);
	}
	/**
	 *查询FlxoaSystemUserRole数据条数
	 */ 
	public Long queryCount(FlxoaSystemUserRole flxoaSystemUserRole) {
		Long result = dao.queryCount(flxoaSystemUserRole);
		return result;
	}

}