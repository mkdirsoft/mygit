package com.flx.flxoa.info.approve.dao.impl;


import java.util.List;
import com.flx.flxoa.info.approve.entity.FlxoaApproveConditionWorkflow;
import com.flx.flxoa.info.approve.entity.FlxoaApproveFormdata;
import com.flx.flxoa.info.approve.dao.FlxoaApproveConditionWorkflowDao;
import org.springframework.stereotype.Repository;
import com.flx.flxoa.common.hibernate3.HibernateBaseDao;

/**
 *
 * 类名称：FlxoaApproveConditionWorkflowDaoImpl.java
 * 类描述：
 * 创建时间：2018-03-29, 下午02:11:40
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 刘凯 
 */ 
@Repository
public class FlxoaApproveConditionWorkflowDaoImpl extends HibernateBaseDao<FlxoaApproveConditionWorkflow, Integer> implements FlxoaApproveConditionWorkflowDao {
	/**
	 *添加FlxoaApproveConditionWorkflow
	 */ 
	public boolean add(FlxoaApproveConditionWorkflow flxoaApproveConditionWorkflow) {
		return save(flxoaApproveConditionWorkflow);
	}
	/**
	 *删除FlxoaApproveConditionWorkflow
	 */ 
	public boolean delete(FlxoaApproveConditionWorkflow flxoaApproveConditionWorkflow) {
		flxoaApproveConditionWorkflow.setDeleteFlag("1");
		return save(flxoaApproveConditionWorkflow);
	}
	/**
	 *修改FlxoaApproveConditionWorkflow
	 */ 
	public boolean update(FlxoaApproveConditionWorkflow flxoaApproveConditionWorkflow) {
		return modify(flxoaApproveConditionWorkflow);
	}
	/**
	 *查询FlxoaApproveConditionWorkflow列表
	 */ 
	public List<FlxoaApproveConditionWorkflow> query(FlxoaApproveConditionWorkflow flxoaApproveConditionWorkflow) {
		String hql = " from FlxoaApproveConditionWorkflow where delete_flag = '0' " +
				" and template_id = '"+flxoaApproveConditionWorkflow.getTemplateId()+"' ";
		return getListByHQL(hql, null);
	}
	/**
	 *查询FlxoaApproveConditionWorkflow ByID
	 */ 
	public FlxoaApproveConditionWorkflow queryById(FlxoaApproveConditionWorkflow flxoaApproveConditionWorkflow) {
		return get(flxoaApproveConditionWorkflow.getId());
	}
	/**
	 *分页FlxoaApproveConditionWorkflow pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<FlxoaApproveConditionWorkflow> queryForPage(int pageNo,int pageSize,FlxoaApproveConditionWorkflow flxoaApproveConditionWorkflow) {
		String hql = " from FlxoaApproveConditionWorkflow where delete_flag = '0' ";
		return queryForPageByHQL(pageNo, pageSize, hql);
	}
	/**
	 *查询FlxoaApproveConditionWorkflow数据条数 
	 */ 
	public Long queryCount(FlxoaApproveConditionWorkflow flxoaApproveConditionWorkflow) {
		String hql = "select count(*) from FlxoaApproveConditionWorkflow where delete_flag = '0' ";
		return countByHql(hql,null);
	}
	
	/**
	 *根据其他条件查询 FlxoaApproveConditionWorkflow 唯一实体
	 */	
	@Override
	public FlxoaApproveConditionWorkflow queryByEntity(FlxoaApproveConditionWorkflow flxoaApproveConditionWorkflow) {
		String hql = " from FlxoaApproveConditionWorkflow where delete_flag = '0' " +
				" and template_id = '"+flxoaApproveConditionWorkflow.getTemplateId()+"' ";
		if(null != flxoaApproveConditionWorkflow.getFormdataDataKey()){
			if(!"".equals(flxoaApproveConditionWorkflow.getFormdataDataKey())){
				hql +=" and formdata_data_key = '"+flxoaApproveConditionWorkflow.getFormdataDataKey()+"'";
			}
		}
		List<FlxoaApproveConditionWorkflow> list = getListByHQL(hql, null);
		if(null != list){
			if(list.size() > 0)
			{
				return list.get(0);
			}
		}
		return null;
	} 
	
	@Override
	protected Class<FlxoaApproveConditionWorkflow> getEntityClass() {
		return FlxoaApproveConditionWorkflow.class;
	} 

}