package com.flx.flxoa.info.system.dao.impl;


import java.util.ArrayList;
import java.util.List;

import com.flx.flxoa.info.system.entity.DepartmentTree;
import com.flx.flxoa.info.system.entity.FlxoaSystemDepartment;
import com.flx.flxoa.info.system.dao.FlxoaSystemDepartmentDao;
import org.springframework.stereotype.Repository;
import com.flx.flxoa.common.hibernate3.HibernateBaseDao;

/**
 *
 * 类名称：FlxoaSystemDepartmentDaoImpl.java
 * 类描述：
 * 创建时间：2018-03-28, 下午03:34:14
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 夏改翠 
 */ 
@Repository
public class FlxoaSystemDepartmentDaoImpl extends HibernateBaseDao<FlxoaSystemDepartment, Integer> implements FlxoaSystemDepartmentDao {
	/**
	 *添加FlxoaSystemDepartment
	 */ 
	public boolean add(FlxoaSystemDepartment flxoaSystemDepartment) {
		return save(flxoaSystemDepartment);
	}
	/**
	 *删除FlxoaSystemDepartment
	 */ 
	public boolean delete(FlxoaSystemDepartment flxoaSystemDepartment) {
		flxoaSystemDepartment.setDeleteFlag("1");
		return save(flxoaSystemDepartment);
	}
	/**
	 *修改FlxoaSystemDepartment
	 */ 
	public boolean update(FlxoaSystemDepartment flxoaSystemDepartment) {
		return modify(flxoaSystemDepartment);
	}
	/**
	 *查询FlxoaSystemDepartment列表
	 */ 
	public List<FlxoaSystemDepartment> query(FlxoaSystemDepartment flxoaSystemDepartment) {
		String hql =" from FlxoaSystemDepartment where delete_flag = '0'";
		if(null != flxoaSystemDepartment){
			if(flxoaSystemDepartment.getId() != null && !"".equals(flxoaSystemDepartment.getId())){
				hql += "  and id ='"+flxoaSystemDepartment.getId()+"'";
			}
			if(flxoaSystemDepartment.getName() != null && !"".equals(flxoaSystemDepartment.getName())){
				hql += "  and name ='"+flxoaSystemDepartment.getName()+"'";
			}			
		}
		return getListByHQL(hql, null);
	}
	/**
	 *查询FlxoaSystemDepartment列表
	 */ 
	@Override
	public boolean isExist(String username) {
		String hql="from FlxoaSystemDepartment where name='"+username+"' ";
		List list=queryByHQL(hql);
		if(list.size()<1){
			return true;
		}
		return false;
	} 
	/**
	 *查询FlxoaSystemDepartment ByID
	 */ 
	public FlxoaSystemDepartment queryById(FlxoaSystemDepartment flxoaSystemDepartment) {
		return get(flxoaSystemDepartment.getId());
	}
	/**
	 *分页FlxoaSystemDepartment pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<FlxoaSystemDepartment> queryForPage(int pageNo,int pageSize,FlxoaSystemDepartment flxoaSystemDepartment) {
		String hql = " from FlxoaSystemDepartment where delete_flag = '0'";
		return queryForPageByHQL(pageNo, pageSize, hql);
	}
	/**
	 *查询FlxoaSystemDepartment数据条数 
	 */ 
	public Long queryCount(FlxoaSystemDepartment flxoaSystemDepartment) {
		String hql = "select count(*) from FlxoaSystemDepartment where delete_flag = '0' ";
		return countByHql(hql,null);
	}
	/**
	 * 查询部门id，部门名，父级部门id
	 * @param flxoaSystemDepartment
	 * @return
	 */
	public List<DepartmentTree> querySQL() {
		String hql = " from FlxoaSystemDepartment where delete_flag = '0' ";
		List<FlxoaSystemDepartment> list = getListByHQL(hql,null);
		List<DepartmentTree> treeList = new ArrayList<DepartmentTree>();
		for(int i=0;i<list.size();i++){
			DepartmentTree deptTree = new DepartmentTree();
			deptTree.setId(list.get(i).getId());
			deptTree.setPid(list.get(i).getParentId());
			deptTree.setName(list.get(i).getName());
			treeList.add(deptTree);
		}
		return treeList;
	}
	
	@Override
	protected Class<FlxoaSystemDepartment> getEntityClass() {
		return FlxoaSystemDepartment.class;
	}
	/**
	 * 查询组织类型为中心‘2’的部门
	 */
	@Override
	public List<DepartmentTree> queryDept() {
		String hql = "select id,parent_id,name from flxoa_system_department where organization_type='2' and delete_flag = '0' ";
		  //List<FlxoaSystemDepartment> list = getListByHQL(hql,null);
		  List<Object> list = querySQL(hql,null);
		  List<DepartmentTree> treeList = new ArrayList<DepartmentTree>();
		  for(int i=0;i<list.size();i++){
		   Object[] listValue= (Object[]) list.get(i);
		   DepartmentTree deptTree = new DepartmentTree();
		   deptTree.setId(Integer.valueOf(listValue[0].toString()));
		   deptTree.setPid(Integer.valueOf(listValue[1].toString()));
		   deptTree.setName(listValue[2].toString());
		   treeList.add(deptTree);
		  }
		  return treeList;
	}
	@Override
	public int queryByMaxId() {
		String sql = "select Max(id) from flxoa_system_department";
		int maxId = 0;
		List list = getListBySQL(sql, null);
		if(list.size() > 0){
			maxId = (Integer)list.get(0);
		}
		return maxId;
	}
	@Override
	public List<DepartmentTree> querySQLById(String deptIds) {
		String parm="";// 费用 申请人部门条件
		if(deptIds.indexOf(",") >= 0){
			String [] deptids= deptIds.split(",");
			for(int i=0;i<deptids.length;i++){
				parm += "  id = "+deptids[i]+"  or";
			}
			parm = parm.substring(0,parm.length()-2);
		}else{
			parm += "id ="+deptIds+" " ;
		}
		String hql = " from FlxoaSystemDepartment where delete_flag = '0' and ("+parm+") ";
		List<FlxoaSystemDepartment> list = getListByHQL(hql,null);
		List<DepartmentTree> treeList = new ArrayList<DepartmentTree>();
		for(int i=0;i<list.size();i++){
			DepartmentTree deptTree = new DepartmentTree();
			deptTree.setId(list.get(i).getId());
			deptTree.setPid(list.get(i).getParentId());
			deptTree.setName(list.get(i).getName());
			treeList.add(deptTree);
		}
		return treeList;
	} 
	

}