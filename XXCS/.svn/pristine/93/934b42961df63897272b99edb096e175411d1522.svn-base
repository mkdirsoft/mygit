package com.flx.flxoa.info.approve.dao.impl;


import java.util.ArrayList;
import java.util.List;

import com.flx.flxoa.info.approve.entity.FlxoaApproveForm;
import com.flx.flxoa.info.approve.entity.FlxoaApproveFormdata;
import com.flx.flxoa.info.approve.dao.FlxoaApproveFormdataDao;
import org.springframework.stereotype.Repository;
import com.flx.flxoa.common.hibernate3.HibernateBaseDao;
import com.flx.flxoa.common.util.DateUtils;

/**
 *
 * 类名称：FlxoaApproveFormdataDaoImpl.java
 * 类描述：
 * 创建时间：2018-03-23, 下午04:41:33
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 刘凯 
 */ 
@Repository
public class FlxoaApproveFormdataDaoImpl extends HibernateBaseDao<FlxoaApproveFormdata, Integer> implements FlxoaApproveFormdataDao {
	/**
	 *添加FlxoaApproveFormdata
	 */ 
	public boolean add(FlxoaApproveFormdata flxoaApproveFormdata) {
		return save(flxoaApproveFormdata);
	}
	/**
	 *删除FlxoaApproveFormdata
	 */ 
	public boolean delete(FlxoaApproveFormdata flxoaApproveFormdata) {
		flxoaApproveFormdata.setDeleteFlag("1");
		return save(flxoaApproveFormdata);
	}
	/**
	 *修改FlxoaApproveFormdata
	 */ 
	public boolean update(FlxoaApproveFormdata flxoaApproveFormdata) {
		return modify(flxoaApproveFormdata);
	}
	/**
	 *查询FlxoaApproveFormdata列表
	 */ 
	public List<FlxoaApproveFormdata> query(FlxoaApproveFormdata flxoaApproveFormdata) {
		String hql = " from FlxoaApproveFormdata where delete_flag = '0' ";
		if(null != flxoaApproveFormdata){
			if(flxoaApproveFormdata.getList().size() > 0)
			{
				hql += " and (";
				for (int i = 0; i < flxoaApproveFormdata.getList().size(); i++) {
					hql += " (form_id = '"+flxoaApproveFormdata.getList().get(i).getFormId()+"'" +
							" and data_key = '"+flxoaApproveFormdata.getList().get(i).getDataKey()+"')" +
							" or";
				}
				hql = hql.substring(0, hql.length() - 2);
				hql += " )";
			}
			if(null != flxoaApproveFormdata.getFormId()){
				hql += " and form_id = "+flxoaApproveFormdata.getFormId();
			}
			//项目id
			if(null != flxoaApproveFormdata.getProjectId()){
				hql += " and data_key = 'id' and data_value = '"+flxoaApproveFormdata.getProjectId()+"'";
			}
		}
		return getListByHQL(hql, null);
	}
	/**
	 *查询FlxoaApproveFormdata ByID
	 */ 
	public FlxoaApproveFormdata queryById(FlxoaApproveFormdata flxoaApproveFormdata) {
		return get(flxoaApproveFormdata.getId());
	}
	/**
	 *分页FlxoaApproveFormdata pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<FlxoaApproveFormdata> queryForPage(int pageNo,int pageSize,FlxoaApproveFormdata flxoaApproveFormdata) {
		String hql = " from FlxoaApproveFormdata where delete_flag = '0' ";
		return queryForPageByHQL(pageNo, pageSize, hql);
	}
	/**
	 *查询FlxoaApproveFormdata数据条数 
	 */ 
	public Long queryCount(FlxoaApproveFormdata flxoaApproveFormdata) {
		String hql = "select count(*) from FlxoaApproveFormdata where delete_flag = '0' ";
		return countByHql(hql,null);
	}
	
	@Override
	protected Class<FlxoaApproveFormdata> getEntityClass() {
		return FlxoaApproveFormdata.class;
	}
	@Override
	public FlxoaApproveFormdata queryByEntity(FlxoaApproveFormdata flxoaApproveFormdata) {
		String hql = " from FlxoaApproveFormdata where delete_flag = '0' and data_key = ? and form_id=?";
		Object [] obj = {flxoaApproveFormdata.getDataKey(),flxoaApproveFormdata.getFormId()};
		List<FlxoaApproveFormdata> list = getListByHQL(hql, obj);
		return list.get(0);
	}
	
	/**
	 *查询和项目有关的FlxoaApproveFormdata列表
	 */ 
	public List<FlxoaApproveFormdata> queryProjectForm(FlxoaApproveFormdata flxoaApproveFormdata) {
		//查询(0formid 1申请表id 2申请表名称 3数据项名称 4数据项的值 5数据项中文描述
		String sql = "select" +
				" flxoa_approve_formdata.form_id," +
				" flxoa_approve_form.template_id," +
				" flxoa_approve_formtemplate.name," +
				" flxoa_approve_formdata.data_key," +
				" flxoa_approve_formdata.data_description," +
				" flxoa_approve_formdata.data_value" +
				" from flxoa_approve_form" +
				" left join flxoa_approve_formdata" +
				" on flxoa_approve_form.id = flxoa_approve_formdata.form_id" +
				" left join flxoa_approve_formtemplate" +
				" on flxoa_approve_form.template_id = flxoa_approve_formtemplate.id" +
				" where flxoa_approve_form.delete_flag = '0' ";
		if(null != flxoaApproveFormdata){
			String formIds = flxoaApproveFormdata.getFormIds();
			//formIds
			if(null != formIds){			
				if(formIds.indexOf(",") != -1){
					String [] temp = formIds.split(",");
					sql += " and (";
					//遍历map
					for (int i = 0; i < temp.length; i++) {
						sql += " flxoa_approve_formdata.form_id = "+temp[i]+ " or ";
					}
					sql = sql.substring(0, sql.length()-3);
					sql += ") ";					
				}else{
					sql += " and flxoa_approve_formdata.form_id = "+formIds;
				}
			}
			sql += " order by flxoa_approve_formdata.form_id desc";
		}
		List list = getListBySQL(sql, null);
		List<FlxoaApproveFormdata> formDataList = new ArrayList<FlxoaApproveFormdata>();
		for (int i = 0; i < list.size(); i++) {
			FlxoaApproveFormdata data = new FlxoaApproveFormdata();
			Object[] objects = (Object[])list.get(i);
			data.setFormId((Integer)(objects[0]));
			data.setTemplateId((Integer)(objects[1]));
			data.setTemplateName(String.valueOf(objects[2]));
			data.setDataKey(String.valueOf(objects[3]));
			data.setDataDescription(String.valueOf(objects[4]));
			data.setDataValue(String.valueOf(objects[5]));
			formDataList.add(data);
		}
		return formDataList;		
	}

}