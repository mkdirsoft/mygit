package com.flx.flxoa.info.system.manager.impl;


import java.util.List;
import com.flx.flxoa.info.system.entity.FlxoaSystemUserGroupDepartment;
import com.flx.flxoa.info.system.entity.FlxoaSystemUserGroupRole;
import com.flx.flxoa.info.system.manager.FlxoaSystemUserGroupDepartmentService;
import com.flx.flxoa.info.system.dao.FlxoaSystemUserGroupDepartmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * 类名称：FlxoaSystemUserGroupDepartmentServiceImpl.java
 * 类描述：
 * 创建时间：2018-03-29, 上午09:35:52
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 赵鹏辉 
 */ 
@Service
@Transactional
public class FlxoaSystemUserGroupDepartmentServiceImpl implements FlxoaSystemUserGroupDepartmentService {
	private FlxoaSystemUserGroupDepartmentDao dao;
	@Autowired
	public void setDao(FlxoaSystemUserGroupDepartmentDao dao) {
		this.dao = dao;
	}
	public FlxoaSystemUserGroupDepartmentDao getDao() {
		return dao;
	}
	/**
	 *添加FlxoaSystemUserGroupDepartment
	 */ 
	public boolean add(FlxoaSystemUserGroupDepartment flxoaSystemUserGroupDepartment) {
		boolean result = dao.add(flxoaSystemUserGroupDepartment);
		return result;
	}
	/**
	 *删除FlxoaSystemUserGroupDepartment
	 */ 
	public boolean delete(FlxoaSystemUserGroupDepartment flxoaSystemUserGroupDepartment) {
		boolean result = dao.delete(flxoaSystemUserGroupDepartment);
		return result;
	}
	/**
	 *修改FlxoaSystemUserGroupDepartment
	 */ 
	public boolean update(FlxoaSystemUserGroupDepartment flxoaSystemUserGroupDepartment) {
		boolean result = dao.update(flxoaSystemUserGroupDepartment);
		return result;
	}
	/**
	 *查询FlxoaSystemUserGroupDepartment列表
	 */ 
	public List<FlxoaSystemUserGroupDepartment> query(FlxoaSystemUserGroupDepartment flxoaSystemUserGroupDepartment) {
		List<FlxoaSystemUserGroupDepartment> list = dao.query(flxoaSystemUserGroupDepartment);
		return list;
	}
	/**
	 *查询FlxoaSystemUserGroupDepartment ByID
	 */ 
	public FlxoaSystemUserGroupDepartment queryById(FlxoaSystemUserGroupDepartment flxoaSystemUserGroupDepartment) {
		FlxoaSystemUserGroupDepartment result = dao.queryById(flxoaSystemUserGroupDepartment);
		return result;
	}
	/**
	 *分页FlxoaSystemUserGroupDepartment pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<FlxoaSystemUserGroupDepartment> queryForPage(int pageNo,int pageSize,FlxoaSystemUserGroupDepartment flxoaSystemUserGroupDepartment) {
		List<FlxoaSystemUserGroupDepartment> list = dao.queryForPage(pageNo,pageSize,flxoaSystemUserGroupDepartment);
		return list;
	}
	/**
	 *查询FlxoaSystemUserGroupDepartment数据条数
	 */ 
	public Long queryCount(FlxoaSystemUserGroupDepartment flxoaSystemUserGroupDepartment) {
		Long result = dao.queryCount(flxoaSystemUserGroupDepartment);
		return result;
	}
	/**
	 * 删除
	 */
	public boolean deleteByGroupId(FlxoaSystemUserGroupDepartment flxoaSystemUserGroupDepartment){
		boolean result = dao.deleteByGroupId(flxoaSystemUserGroupDepartment);
		return result;
	}
}