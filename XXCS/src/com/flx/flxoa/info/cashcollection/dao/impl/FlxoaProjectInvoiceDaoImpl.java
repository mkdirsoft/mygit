package com.flx.flxoa.info.cashcollection.dao.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.flx.flxoa.info.cashcollection.entity.FlxoaCashcollectionClaimAffirm;
import com.flx.flxoa.info.cashcollection.entity.FlxoaProjectInvoice;
import com.flx.flxoa.info.cashcollection.dao.FlxoaProjectInvoiceDao;
import org.springframework.stereotype.Repository;
import com.flx.flxoa.common.hibernate3.HibernateBaseDao;
import com.flx.flxoa.common.util.CommonUtils;

/**
 *
 * 类名称：FlxoaProjectInvoiceDaoImpl.java
 * 类描述：
 * 创建时间：2018-03-16, 下午06:54:26
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 赵鹏辉
 */ 
@Repository
public class FlxoaProjectInvoiceDaoImpl extends HibernateBaseDao<FlxoaProjectInvoice, Integer> implements FlxoaProjectInvoiceDao {
	/**
	 *添加FlxoaProjectInvoice
	 */ 
	public boolean add(FlxoaProjectInvoice flxoaProjectInvoice) {
		return save(flxoaProjectInvoice);
	}
	/**
	 *删除FlxoaProjectInvoice
	 */ 
	public boolean delete(FlxoaProjectInvoice flxoaProjectInvoice) {
		flxoaProjectInvoice.setDeleteFlag("1");
		return save(flxoaProjectInvoice);
	}
	/**
	 *修改FlxoaProjectInvoice
	 */ 
	public boolean update(FlxoaProjectInvoice flxoaProjectInvoice) {
		return modify(flxoaProjectInvoice);
	}
	/**
	 *分页FlxoaProjectInvoice pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public String queryForPage(Map<String,String> map) {
		//查询hql语句
		
		String hql=" from flxoa_project_invoice invoice left join flxoa_approve_form form on invoice.invoice_id=form.id left join flxoa_system_department dept on form.create_department_id=dept.id LEFT JOIN flxoa_project_invoice_check  invoicecheck ON invoice.id = invoicecheck.invoice_manager_id  left join flxoa_system_user sysUser on form.create_user_id=sysUser.id " +
				"left join (select enumeration_key,enumeration_value from flxoa_system_enumeration where enumeration_name='accessory_status' and delete_flag='0')accessory on invoice.accessory_status=accessory.enumeration_key " +
				"left join (select enumeration_key,enumeration_value from flxoa_system_enumeration where enumeration_name='invoice_type' and delete_flag='0')invoiceType on invoice.invoice_type=invoiceType.enumeration_key " +
				"left join flxoa_approve_formdata formdata on form.id=formdata.form_id left join flxoa_approve_formdata formdata2 on form.id=formdata2.form_id left join flxoa_approve_formdata formdata3 on form.id=formdata3.form_id left join flxoa_approve_formdata formdata4 on form.id=formdata4.form_id " +
				"where formdata.data_key='company_name' and formdata2.data_key='projNumber' and formdata3.data_key='projName' and formdata4.data_key='invoice_amount' " +
				"and form.submit_status='3' and form.template_id in(40,43)  and invoice.delete_flag='0' and form.delete_flag='0' and dept.delete_flag='0' and formdata.delete_flag='0' and formdata2.delete_flag='0' and formdata3.delete_flag='0' and formdata4.delete_flag='0' " +
				"";
		String deptWhere=map.get("deptWhere");
		String invoiceType=map.get("invoiceType");
		String projName=map.get("projName");
		String projNumber=map.get("projNumber");
		String startTime=map.get("startTime");
		String endTime=map.get("endTime");
		String companyName=map.get("companyName");
		String createUserName=map.get("createUserName");
		String accessoryStatus=map.get("accessoryStatus");
		int start=Integer.valueOf(map.get("start"));
		int length=Integer.valueOf(map.get("length"));
		String draw=map.get("draw");

		if(!CommonUtils.isEmpty(deptWhere)){
			hql+=" and invoice.create_department_id in(select pro.project_id from flxoa_project_bid_information pro left join flxoa_system_user sysUser on pro.follower_id=sysUser.id where ";
			hql+=deptWhere;
			hql+=") ";		
		}
		if(!CommonUtils.isEmpty(invoiceType)){
			hql+=" and invoice.invoice_type='";
			hql+=invoiceType;
			hql+="'";
		}
		if(!CommonUtils.isEmpty(projName)){
			hql+=" and formdata3.data_value like '%";
			hql+=projName;
			hql+="%'";
		}
		if(!CommonUtils.isEmpty(projNumber)){
			hql+=" and formdata2.data_value like'%";
			hql+=projNumber;
			hql+="%'";
		}
		if(!CommonUtils.isEmpty(startTime)){
			hql+=" and form.submit_time>=";
			hql+=startTime;
		}
		if(!CommonUtils.isEmpty(endTime)){
			hql+=" and form.submit_time<=";
			hql+=endTime;
		}
		if(!CommonUtils.isEmpty(startTime) && CommonUtils.isEmpty(endTime)) {
			int startDataTime = Integer.valueOf(startTime) + 86400;
			System.out.println("startDataTime="+startDataTime);
			hql+=" and form.submit_time  >='"+startTime+"' ";
			hql+="and form.submit_time < '"+startDataTime+"'";
		}
		if(!CommonUtils.isEmpty(startTime) && !CommonUtils.isEmpty(endTime)){
			int startDataTime = Integer.valueOf(startTime) + 86300;
			hql+=" and form.submit_time Between ";
			hql+=startTime;
			hql+=" and ";
			hql+=startDataTime;
		}
		
		if(!CommonUtils.isEmpty(companyName)){
			hql+=" and formdata.data_value like '%";
			hql+=companyName;
			hql+="%'";
		}
		if(!CommonUtils.isEmpty(createUserName)){
			hql+=" and sysUser.real_name like '%";
			hql+=createUserName;
			hql+="%'";
		}
		if(!CommonUtils.isEmpty(accessoryStatus)){
			hql+=" and invoice.accessory_status='";
			hql+=accessoryStatus;
			hql+="'";
		}
		hql+=" order by invoice.id";
		//查询参数
		String querySql="select invoice.id,invoicecheck.is_receive,invoicecheck.id invoicecheckId,form.submit_time submitTime,dept.name deptName,sysUser.real_name,formdata2.data_value projNumber,formdata3.data_value projName,accessory.enumeration_value accessoryStatus," +
				"formdata.data_value companyName,formdata4.data_value invoiceAmount,invoiceType.enumeration_value invoiceType "+hql;
		//求和查询sql
		String countSql="select count(*) "+hql;

		List list= queryListForPageBySQL(start, length, querySql);
		List<Map<String,String>> dataList=new ArrayList<Map<String,String>>();
		List<Map<String,String>> otherDataList=new ArrayList<Map<String,String>>();

		for(int i=0;i<list.size();i++){
			Map<String,String> dataMap=new HashMap<String,String>();
			Object[] obj=(Object[]) list.get(i);
			dataMap.put("id", String.valueOf(obj[0]));
			dataMap.put("isReceive", String.valueOf(obj[1]));
			dataMap.put("invoiceCheckId", String.valueOf(obj[2]));
			dataMap.put("submitTime", String.valueOf(obj[3]));
			dataMap.put("deptName", String.valueOf(obj[4]));
			dataMap.put("createUserName", String.valueOf(obj[5]));
			dataMap.put("projNumber", String.valueOf(obj[6]));
			dataMap.put("projName", String.valueOf(obj[7]));
			dataMap.put("accessoryStatus", String.valueOf(obj[8]));
			dataMap.put("companyName", String.valueOf(obj[9]));
			dataMap.put("invoiceAmount", String.valueOf(obj[10]));
			dataMap.put("invoiceType", String.valueOf(obj[11]));
			
			dataList.add(dataMap);
		}
		Long totalCount= countBySql(countSql,null);
		Map<String,String> otherDataMap=new HashMap<String,String>();
		return CommonUtils.getPageJson(start, length,draw,totalCount,dataList,otherDataList);
	}
	
	/**
	 *查询FlxoaProjectInvoice数据条数 
	 */ 
	public Long queryCount(FlxoaProjectInvoice flxoaProjectInvoice) {
		String hql = "select count(*) from FlxoaProjectInvoice where delete_flag = '0' ";
		return countByHql(hql,null);
	}
	/**
	 *查询FlxoaProjectInvoice列表
	 */ 
	public List<FlxoaProjectInvoice> query(FlxoaProjectInvoice flxoaProjectInvoice) {
		String hql = " from FlxoaProjectInvoice where delete_flag = '0' ";
		return getListByHQL(hql, null);
	}
	/**
	 *查询FlxoaProjectInvoice ByID
	 */ 
	public FlxoaProjectInvoice queryById(FlxoaProjectInvoice flxoaProjectInvoice) {
		return get(flxoaProjectInvoice.getId());
	}

	@Override
	protected Class<FlxoaProjectInvoice> getEntityClass() {
		return FlxoaProjectInvoice.class;
	} 

}