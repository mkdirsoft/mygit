package com.flx.flxoa.info.system.dao.impl;


import java.util.ArrayList;
import java.util.List;
import com.flx.flxoa.info.system.entity.FlxoaApproveWorkflow;
import com.flx.flxoa.info.system.entity.FlxoaSystemUser;
import com.flx.flxoa.info.system.dao.FlxoaApproveWorkflowDao;
import org.springframework.stereotype.Repository;
import com.flx.flxoa.common.hibernate3.HibernateBaseDao;

/**
 *
 * 类名称：FlxoaApproveWorkflowDaoImpl.java
 * 类描述：
 * 创建时间：2018-03-19, 下午05:30:55
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 刘凯 
 */ 
@Repository
public class FlxoaApproveWorkflowDaoImpl extends HibernateBaseDao<FlxoaApproveWorkflow, Integer> implements FlxoaApproveWorkflowDao {
	/**
	 *添加FlxoaApproveWorkflow
	 */ 
	public boolean add(FlxoaApproveWorkflow flxoaApproveWorkflow) {
		return save(flxoaApproveWorkflow);
	}
	/**
	 *删除FlxoaApproveWorkflow
	 */ 
	public boolean delete(FlxoaApproveWorkflow flxoaApproveWorkflow) {
		flxoaApproveWorkflow.setDeleteFlag("1");
		return save(flxoaApproveWorkflow);
	}
	/**
	 *修改FlxoaApproveWorkflow
	 */ 
	public boolean update(FlxoaApproveWorkflow flxoaApproveWorkflow) {
		return modify(flxoaApproveWorkflow);
	}
	/**
	 *查询FlxoaApproveWorkflow列表
	 */ 
	public List<FlxoaApproveWorkflow> query(FlxoaApproveWorkflow flxoaApproveWorkflow) {
		String hql =" from FlxoaApproveWorkflow where delete_flag = '0'";
		String sql = "select w.id," +
				"w.workflow_name," +
				"w.workflow_json," +
				"w.templage_names," +
				"company.name as cname," +
				"dept.name as dname, " +
				"w.templage_ids, " +
				"w.company_id, " +
				"w.department_id " +
				"from flxoa_approve_workflow  w" +
				" left join (select id,name from flxoa_system_department ) company on w.company_id=company.id" +
				" left join (select id,name from flxoa_system_department ) dept on w.department_id=dept.id" +
				" where w.delete_flag = '0'";
		if(null != flxoaApproveWorkflow){
			if(null != flxoaApproveWorkflow.getWorkflowName()){
				if(!"".equals(flxoaApproveWorkflow.getWorkflowName())){
					sql+= " and  w.workflow_name like '%"+flxoaApproveWorkflow.getWorkflowName()+"%'";
				}
			}
			if(null != flxoaApproveWorkflow.getTemplageNames()){
				if(!"".equals(flxoaApproveWorkflow.getTemplageNames())){
					sql+= " and  w.templage_names like '%"+flxoaApproveWorkflow.getTemplageNames()+"%'";
				}
			}
			if(null != flxoaApproveWorkflow.getCompanyName()){
				if(!"".equals(flxoaApproveWorkflow.getCompanyName())){
					sql+= " and  company.name like '%"+flxoaApproveWorkflow.getCompanyName()+"%'";
				}
			}
			if(null != flxoaApproveWorkflow.getDepartmentName()){
				if(!"".equals(flxoaApproveWorkflow.getDepartmentName())){
					sql+= " and  dept.name like '%"+flxoaApproveWorkflow.getDepartmentName()+"%'";
				}
			}
			List list = getListBySQL(sql, null);
			List<FlxoaApproveWorkflow> formList = new ArrayList<FlxoaApproveWorkflow>();
			for (int i = 0; i < list.size(); i++) {
				FlxoaApproveWorkflow form = new FlxoaApproveWorkflow();
				Object[] objects = (Object[])list.get(i);
				form.setId((Integer)objects[0]);
				form.setWorkflowName(String.valueOf(objects[1]));
				form.setWorkflowJson(String.valueOf(objects[2]));
				form.setTemplageNames(String.valueOf(objects[3]));
				form.setCompanyName(String.valueOf(objects[4]));
				if(null != objects[5]){
					form.setDepartmentName(String.valueOf(objects[5]));
				}else{
					form.setDepartmentName("");
				}
				form.setTemplageIds(String.valueOf(objects[6]));
				form.setCompanyId((Integer)objects[7]);
				form.setDepartmentId((Integer)objects[8]);
				formList.add(form);
			}
			return formList;
		}else{
			return getListByHQL(hql, null);
		}
	} 
	/**
	 *查询FlxoaApproveWorkflow ByID
	 */ 
	public FlxoaApproveWorkflow queryById(FlxoaApproveWorkflow flxoaApproveWorkflow) {
		return get(flxoaApproveWorkflow.getId());
	}
	
	@Override
	protected Class<FlxoaApproveWorkflow> getEntityClass() {
		return FlxoaApproveWorkflow.class;
	} 

}