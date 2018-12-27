package com.flx.flxoa.info.system.manager;


import java.util.List;
import java.util.Map;

import com.flx.flxoa.info.system.entity.DepartmentTree;
import com.flx.flxoa.info.system.entity.FlxoaSystemDepartment;

/**
 *
 * 类名称：FlxoaSystemDepartmentService.java
 * 类描述：
 * 创建时间：2018-03-28, 下午03:34:14
 *
 *@version 1.0 
 *@since JDK版本1.7 
 *@author 夏改翠 
 */ 
public interface FlxoaSystemDepartmentService {
	/**
	 *添加FlxoaSystemDepartment
	 */ 
	public boolean add(FlxoaSystemDepartment flxoaSystemDepartment);
	/**
	 *删除FlxoaSystemDepartment
	 */ 
	public boolean delete(FlxoaSystemDepartment flxoaSystemDepartment);
	/**
	 *修改FlxoaSystemDepartment
	 */ 
	public boolean update(FlxoaSystemDepartment flxoaSystemDepartment);
	/**
	 *查询FlxoaSystemDepartment列表
	 */ 
	public List<FlxoaSystemDepartment> query(FlxoaSystemDepartment flxoaSystemDepartment);
	/**
	 *查询FlxoaSystemDepartment
	 */ 
	public boolean isExist(String username);
	/**
	 *查询FlxoaSystemDepartment ByID
	 */ 
	public FlxoaSystemDepartment queryById(FlxoaSystemDepartment flxoaSystemDepartment);
	/**
	 *分页FlxoaSystemDepartment pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<FlxoaSystemDepartment> queryForPage(int pageNo,int pageSize,FlxoaSystemDepartment flxoaSystemDepartment);
	/**
	 *查询FlxoaSystemDepartment数据条数
	 */ 
	public Long queryCount(FlxoaSystemDepartment flxoaSystemDepartment);
	/**
	 * 查询部门id，部门名，父级部门id
	 */
	public List<DepartmentTree> querySQL();
	public List<DepartmentTree> querySQLById(String deptIds);
	
	/**
	 * 查询各中心的部门id和子部门id 及名称
	 */
	public List<Map<String,String>> queryDept();
	public String childrenDeptId(int pid, List<DepartmentTree> list);
	public int queryByMaxId();
	
 }