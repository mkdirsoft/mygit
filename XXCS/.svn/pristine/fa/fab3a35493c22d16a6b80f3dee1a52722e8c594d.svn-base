package com.flx.flxoa.info.system.manager.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.flx.flxoa.common.util.CommonUtils;
import com.flx.flxoa.info.system.entity.DepartmentTree;
import com.flx.flxoa.info.system.entity.FlxoaSystemDepartment;
import com.flx.flxoa.info.system.manager.FlxoaSystemDepartmentService;
import com.flx.flxoa.info.system.dao.FlxoaSystemDepartmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * 类名称：FlxoaSystemDepartmentServiceImpl.java
 * 类描述：
 * 创建时间：2018-03-28, 下午03:34:14
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 夏改翠 
 */ 
@Service
@Transactional
public class FlxoaSystemDepartmentServiceImpl implements FlxoaSystemDepartmentService {
	private FlxoaSystemDepartmentDao dao;
	@Autowired
	public void setDao(FlxoaSystemDepartmentDao dao) {
		this.dao = dao;
	}
	public FlxoaSystemDepartmentDao getDao() {
		return dao;
	}
	/**
	 *添加FlxoaSystemDepartment
	 */ 
	public boolean add(FlxoaSystemDepartment flxoaSystemDepartment) {
		boolean result = dao.add(flxoaSystemDepartment);
		return result;
	}
	/**
	 *删除FlxoaSystemDepartment
	 */ 
	public boolean delete(FlxoaSystemDepartment flxoaSystemDepartment) {
		boolean result = dao.delete(flxoaSystemDepartment);
		return result;
	}
	/**
	 *修改FlxoaSystemDepartment
	 */ 
	public boolean update(FlxoaSystemDepartment flxoaSystemDepartment) {
		boolean result = dao.update(flxoaSystemDepartment);
		return result;
	}
	/**
	 *查询FlxoaSystemDepartment列表
	 */ 
	public List<FlxoaSystemDepartment> query(FlxoaSystemDepartment flxoaSystemDepartment) {
		List<FlxoaSystemDepartment> list = dao.query(flxoaSystemDepartment);
		return list;
	}
	@Override
	public boolean isExist(String username) {
		boolean result = dao.isExist(username);
		
		return result;
	}
	/**
	 *查询FlxoaSystemDepartment ByID
	 */ 
	public FlxoaSystemDepartment queryById(FlxoaSystemDepartment flxoaSystemDepartment) {
		FlxoaSystemDepartment result = dao.queryById(flxoaSystemDepartment);
		return result;
	}
	/**
	 *分页FlxoaSystemDepartment pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<FlxoaSystemDepartment> queryForPage(int pageNo,int pageSize,FlxoaSystemDepartment flxoaSystemDepartment) {
		List<FlxoaSystemDepartment> list = dao.queryForPage(pageNo,pageSize,flxoaSystemDepartment);
		return list;
	}
	/**
	 *查询FlxoaSystemDepartment数据条数
	 */ 
	public Long queryCount(FlxoaSystemDepartment flxoaSystemDepartment) {
		Long result = dao.queryCount(flxoaSystemDepartment);
		return result;
	}
	/**
	 * 查询部门id，部门名，父级部门id
	 */
	@Override
	public List<DepartmentTree> querySQL() {
		List<DepartmentTree> list = dao.querySQL();
		return list;
	}
	/**
	 * 查询部门id，部门名，父级部门id
	 */
	@Override
	public List<DepartmentTree> querySQLById(String deptIds) {
		List<DepartmentTree> list = dao.querySQLById(deptIds);
		return list;
	}
	/**
	 * 根据部门 id 查询是否有子部门，返回集合
	 */
	@Override
	public List<Map<String,String>> queryDept() {
		List<Map<String,String>> mapList = new ArrayList<Map<String,String>>();
		String dname="";
		int deptid=0;
		//查询各中心的id
		List<DepartmentTree> list = dao.queryDept();
		//查询所有的部门id
		List<DepartmentTree> allList = dao.querySQL();
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				String str="";
				Map<String,String> map = new HashMap<String,String>();
				deptid = list.get(i).getId();
				str += deptid;
				dname=list.get(i).getName();
				if(!CommonUtils.isEmpty(childrenDeptId(deptid,allList))){
					str+=childrenDeptId(deptid,allList);
				}
				map.put(dname, str);
				mapList.add(map);
			}
			
		}

		return mapList;
	}
	@Override
	public String childrenDeptId(int id, List<DepartmentTree> allList) {
		String returnStr="";
		for(int i=0;i<allList.size();i++){
			if(id==allList.get(i).getPid()){
				int pId = allList.get(i).getId();
				returnStr +=","+  pId;
				if(!CommonUtils.isEmpty(childrenDeptId(pId,allList))){
					returnStr += childrenDeptId(pId,allList);					
				}
			}
		}
		
		return returnStr;
	}
	@Override
	public int queryByMaxId() {
		int result = dao.queryByMaxId();
		return result;
	}
	
}