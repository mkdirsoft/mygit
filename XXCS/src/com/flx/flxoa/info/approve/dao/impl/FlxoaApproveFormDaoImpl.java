package com.flx.flxoa.info.approve.dao.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import com.flx.flxoa.info.approve.entity.FlxoaApproveForm;
import com.flx.flxoa.info.approve.dao.FlxoaApproveFormDao;
import org.springframework.stereotype.Repository;
import com.flx.flxoa.common.hibernate3.HibernateBaseDao;
import com.flx.flxoa.common.util.CommonUtils;
import com.flx.flxoa.common.util.DateUtils;
import com.flx.flxoa.common.util.weixin.CommonUtil;

/**
 *
 * 类名称：FlxoaApproveFormDaoImpl.java
 * 类描述：
 * 创建时间：2018-03-23, 下午04:41:33
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 刘凯 
 */ 
@Repository
public class FlxoaApproveFormDaoImpl extends HibernateBaseDao<FlxoaApproveForm, Integer> implements FlxoaApproveFormDao {
	/**
	 *添加FlxoaApproveForm
	 */ 
	public boolean add(FlxoaApproveForm flxoaApproveForm) {
		return save(flxoaApproveForm);
	}
	/**
	 *删除FlxoaApproveForm
	 */ 
	public boolean delete(FlxoaApproveForm flxoaApproveForm) {
		flxoaApproveForm.setDeleteFlag("1");
		return save(flxoaApproveForm);
	}
	/**
	 *修改FlxoaApproveForm
	 */ 
	public boolean update(FlxoaApproveForm flxoaApproveForm) {
		return modify(flxoaApproveForm);
	}
	/**
	 *查询FlxoaApproveForm列表
	 */ 
	public ConcurrentHashMap<String, Object> query(String start ,String length,FlxoaApproveForm flxoaApproveForm) {
		Boolean leftDataFlag = false;
		String leftFormData = "";
		String sql = "select distinct " +
				//查询(0申请类型 1申请时间 2项目编号 3项目名称 4审批状态 5审批进度 6申请表模板id 7id 8创建者部门id 9工作流id 10申请人 11审批人id 12确认人ids 13是否已读审批备注 14状态 15form更新时间)
				" (select flxoa_approve_formtemplate.name from flxoa_approve_formtemplate " +
				" where flxoa_approve_formtemplate.id = flxoa_approve_form.template_id)," +
				" flxoa_approve_form.submit_time," +
				" (select flxoa_approve_formdata.data_value from flxoa_approve_formdata" +
				" where flxoa_approve_formdata.data_key = 'projNumber' and flxoa_approve_formdata.form_id = flxoa_approve_form.id)," +
				" (select flxoa_approve_formdata.data_value from flxoa_approve_formdata" +
				" where flxoa_approve_formdata.data_key = 'projName' and flxoa_approve_formdata.form_id = flxoa_approve_form.id)," +
				" flxoa_approve_form.submit_status," +
				" flxoa_approve_form.status," +
				" flxoa_approve_form.template_id," +
				" flxoa_approve_form.id," +
				" flxoa_approve_form.create_department_id," +
				" flxoa_approve_form.workflow_id," +
				" flxoa_system_user.real_name," +
				" flxoa_approve_form.update_user_id," +
				" flxoa_approve_form.check_user_ids," +
				" flxoa_approve_form.is_read," +
				" flxoa_approve_form.now_form_status," +
				" flxoa_approve_form.update_time" +
				//主表
				" from flxoa_approve_form" +
				//连表
				" left join flxoa_approve_formtemplate " +
				" on flxoa_approve_form.template_id = flxoa_approve_formtemplate.id " +
				" left join flxoa_system_user " +
				" on flxoa_approve_form.create_user_id = flxoa_system_user.id " +
				"leftFormData" +				
				//where 条件
				" where flxoa_approve_form.delete_flag = '0' ";
		if(null != flxoaApproveForm.getCreateUserId()){
			sql += " and flxoa_approve_form.create_user_id = '"+flxoaApproveForm.getCreateUserId()+"' ";
		}
		//审批状态和工作流id
		if(null != flxoaApproveForm.getList()){
			if(flxoaApproveForm.getList().size() > 0){
				List<FlxoaApproveForm> list = flxoaApproveForm.getList();
				sql += " and (";
				//遍历map
				for (int i = 0; i < list.size(); i++) {
					sql += " (flxoa_approve_form.workflow_id = "+list.get(i).getWorkflowId()+
							" and flxoa_approve_form.status = "+(Integer.parseInt(list.get(i).getStatus())-1)+
							" and (flxoa_approve_form.submit_status = '1' or flxoa_approve_form.submit_status = '2')) or";
				}
				sql = sql.substring(0, sql.length()-2);
				sql += ") ";
			}
		}
		String DepartmentIds = flxoaApproveForm.getDepartmentIds();
		//权限范围内的部门ids
		if(null != DepartmentIds){
			if(!"".equals(DepartmentIds)){
				if(DepartmentIds.indexOf(",") != -1){
					String [] temp = DepartmentIds.split(",");
					sql += " and (";
					//遍历map
					for (int i = 0; i < temp.length; i++) {
						sql += " flxoa_approve_form.create_department_id = "+temp[i]+ " or ";
					}
					sql = sql.substring(0, sql.length()-3);
					sql += ") ";					
				}else{
					sql += " and flxoa_approve_form.create_department_id = "+DepartmentIds;
				}
			}
		}
		//审批状态
		if(null != flxoaApproveForm.getApproveStatus()){
			sql += " and flxoa_approve_form.submit_status ='"+flxoaApproveForm.getApproveStatus()+"'";
		}
		//申请表类型
		if(null != flxoaApproveForm.getApproveType()){
			sql += " and flxoa_approve_form.template_id ='"+flxoaApproveForm.getApproveType()+"'";
		}
		String startTime = "";
		//申请时间 开始时间
		if(null != flxoaApproveForm.getStartTime()){
			startTime = " and flxoa_approve_form.submit_time >='"+flxoaApproveForm.getStartTime()+"'";
			sql += startTime;
		}
		String endTime = "";
		//申请时间 结束时间 86400 1天的时间戳
		if(null != flxoaApproveForm.getEndTime()){
			endTime = " and flxoa_approve_form.submit_time <'"+(flxoaApproveForm.getEndTime()+86400)+"'";
			sql += endTime;
		}
		//申请时间:开始时间 结束时间 相等 为同一天
		if(null != flxoaApproveForm.getStartTime() && null != flxoaApproveForm.getEndTime()){
			if(flxoaApproveForm.getStartTime().intValue() == flxoaApproveForm.getEndTime().intValue()){
				sql = sql.replace(startTime, "");
				sql = sql.replace(endTime, "");
				sql += " and flxoa_approve_form.submit_time >='"+flxoaApproveForm.getStartTime()+"' " +
					" and flxoa_approve_form.submit_time <'"+(flxoaApproveForm.getEndTime()+86400)+"' ";
			}
		}
		//申请人
		if(null != flxoaApproveForm.getRealName()){
			sql += " and flxoa_system_user.real_name like '%"+flxoaApproveForm.getRealName()+"%'";
		}
		//特殊状态
		if(null != flxoaApproveForm.getNowFormStatus()){
			sql += " and flxoa_approve_form.now_form_status ='"+flxoaApproveForm.getNowFormStatus()+"'";
		}		
		//首页 审批状态 1,2
		if(null != flxoaApproveForm.getStates()){
			sql += " and flxoa_approve_form.submit_status in ( "+flxoaApproveForm.getStates()+")";
		}
		String formIds = flxoaApproveForm.getFormIds();
		//审批记录 自己能查看的formIds
		if(null != formIds){
			if(!"".equals(formIds)){
				if(formIds.indexOf(",") != -1){
					String [] temp = formIds.split(",");
					sql += " and (";
					//遍历map
					for (int i = 0; i < temp.length; i++) {
						sql += " flxoa_approve_form.id = "+temp[i]+ " or ";
					}
					sql = sql.substring(0, sql.length()-3);
					sql += ") ";					
				}else{
					sql += " and flxoa_approve_form.id = "+formIds;
				}
			}
		}
		//关键字英文名称
		String keywordName = flxoaApproveForm.getKeywordName();
		//关键字检索选择或者输入的值
		String keywordValue = flxoaApproveForm.getKeywordValue();	
		//关键字类型
		String keywordType = flxoaApproveForm.getKeywordType();		
		if(!CommonUtils.isEmpty(keywordName)){
			leftDataFlag = true;
			String [] keywordNameArray = keywordName.split(",");
			String [] keywordValueArray = keywordValue.split(",");
			String [] keywordTypeArray = keywordType.split(",");
			sql += " and (";
			//遍历map
			for (int i = 0; i < keywordNameArray.length; i++) {
				sql += " (flxoa_approve_formdata.data_key = '"+keywordNameArray[i]+"'";
				//1：下拉列表 2：单选 8:复选框
				if("1".equals(keywordTypeArray[i])
					||"2".equals(keywordTypeArray[i])
					||"8".equals(keywordTypeArray[i])){
					sql += " and flxoa_approve_formdata.data_value = '"+keywordValueArray[i]+"'";
				}else{
					sql += " and flxoa_approve_formdata.data_value like '%"+keywordValueArray[i]+"%'";
				}
				sql += " ) or";
			}
			sql = sql.substring(0, sql.length()-2);
			sql += ") ";			
		}
		//项目名称
		String projectName = flxoaApproveForm.getProjName();
		if(!CommonUtils.isEmpty(projectName)){
			leftDataFlag = true;
			sql += " and (flxoa_approve_formdata.data_key = 'projNumber'" +
					"and flxoa_approve_formdata.data_value like '%"+projectName+"%') ";
		}
		
		//项目编号
		String projectNo = flxoaApproveForm.getProjNumber();
		if(!CommonUtils.isEmpty(projectNo)){
			leftDataFlag = true;
			sql += " and (flxoa_approve_formdata.data_key = 'projName'" +
					"and flxoa_approve_formdata.data_value like '%"+projectNo+"%') ";
		}
		
		//需要查询formData数据时候 左连  formData表
		if(leftDataFlag){
			leftFormData = " left join flxoa_approve_formdata " +
					" on flxoa_approve_form.id = flxoa_approve_formdata.form_id ";	
			sql = sql.replace("leftFormData", leftFormData);
		}else{
			sql = sql.replace("leftFormData", "");
		}
		
		String checkUserId = flxoaApproveForm.getCheckUserIds();
		//确认者id
		if(null != checkUserId){
			if(!"".equals(checkUserId)){
				sql += " or (flxoa_approve_form.check_user_ids like '%,"+checkUserId+",%' ";
				//审批状态
				if(null != flxoaApproveForm.getApproveStatus()){
					sql += " and flxoa_approve_form.submit_status ='"+flxoaApproveForm.getApproveStatus()+"'";
				}
				//申请表类型
				if(null != flxoaApproveForm.getApproveType()){
					sql += " and flxoa_approve_form.template_id ='"+flxoaApproveForm.getApproveType()+"'";
				}
				//申请时间
				if(null != flxoaApproveForm.getStartTime()){
					sql += " and flxoa_approve_form.submit_time >='"+flxoaApproveForm.getStartTime()+"'";
				}
				//申请人
				if(null != flxoaApproveForm.getRealName()){
					sql += " and flxoa_system_user.real_name like '%"+flxoaApproveForm.getRealName()+"%'";
				}				
				sql += " and flxoa_approve_form.delete_flag = '0')";
			}
		}
		String orderBy = flxoaApproveForm.getOrderBy();
		String orderBySql = " order by flxoa_approve_form.submit_time desc";
		if(null != orderBy){
			if(!"".equals(orderBy)){
				orderBySql = " order by flxoa_approve_form."+orderBy+" desc";
			}
		}
		sql += orderBySql;
		System.out.println("sql:"+sql);
		List list = queryListForPageBySQL(Integer.valueOf(start), Integer.valueOf(length), sql);
		String countsql = "select count(*) from ("+sql+") as count";
		System.out.println(countsql);
		long total = countBySql(countsql);
		List<FlxoaApproveForm> formList = new ArrayList<FlxoaApproveForm>();
		for (int i = 0; i < list.size(); i++) {
			FlxoaApproveForm form = new FlxoaApproveForm();
			Object[] objects = (Object[])list.get(i);
			form.setApproveType(String.valueOf(objects[0]));
			form.setApproveTime(DateUtils.timestampToDate(Integer.parseInt(String.valueOf(objects[1])),"yyyy-MM-dd"));
			form.setProjNumber(String.valueOf(objects[2]));
			form.setProjName(String.valueOf(objects[3]));
			form.setSubmitStatus(String.valueOf(objects[4]));
			form.setStatus(String.valueOf(objects[5]));
			form.setTemplateId((Integer)(objects[6]));
			form.setId((Integer)(objects[7]));
			form.setCreateDepartmentId((Integer)(objects[8]));
			form.setWorkflowId((Integer)(objects[9]));
			form.setRealName(String.valueOf(objects[10]));
			form.setUpdateUserId((Integer)(objects[11]));
			form.setCheckUserIds(String.valueOf(objects[12]));
			form.setIsRead(String.valueOf(objects[13]));
			form.setNowFormStatus(String.valueOf(objects[14]));
			form.setUpdateTime((Integer)(objects[15]));
			formList.add(form);
		}
		ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<String,Object>();
		map.put("data", formList);
		map.put("total", total);
		return map;
	}
	/**
	 *查询FlxoaApproveForm列表
	 */ 
	public List<FlxoaApproveForm> query(FlxoaApproveForm flxoaApproveForm) {
		Boolean leftDataFlag = false;
		String leftFormData = "";
		String sql = "select distinct " +
				//查询(0申请类型 1申请时间 2项目编号 3项目名称 4审批状态 5审批进度 6申请表模板id 7id 8创建者部门id 9工作流id 10申请人 11审批人id 12确认人ids 13是否已读审批备注 14状态 15form更新时间)
				" (select flxoa_approve_formtemplate.name from flxoa_approve_formtemplate " +
				" where flxoa_approve_formtemplate.id = flxoa_approve_form.template_id)," +
				" flxoa_approve_form.submit_time," +
				" (select flxoa_approve_formdata.data_value from flxoa_approve_formdata" +
				" where flxoa_approve_formdata.data_key = 'projNumber' and flxoa_approve_formdata.form_id = flxoa_approve_form.id)," +
				" (select flxoa_approve_formdata.data_value from flxoa_approve_formdata" +
				" where flxoa_approve_formdata.data_key = 'projName' and flxoa_approve_formdata.form_id = flxoa_approve_form.id)," +
				" flxoa_approve_form.submit_status," +
				" flxoa_approve_form.status," +
				" flxoa_approve_form.template_id," +
				" flxoa_approve_form.id," +
				" flxoa_approve_form.create_department_id," +
				" flxoa_approve_form.workflow_id," +
				" flxoa_system_user.real_name," +
				" flxoa_approve_form.update_user_id," +
				" flxoa_approve_form.check_user_ids," +
				" flxoa_approve_form.is_read," +
				" flxoa_approve_form.now_form_status," +
				" flxoa_approve_form.update_time" +
				//主表
				" from flxoa_approve_form" +
				//连表
				" left join flxoa_approve_formtemplate " +
				" on flxoa_approve_form.template_id = flxoa_approve_formtemplate.id " +
				" left join flxoa_system_user " +
				" on flxoa_approve_form.create_user_id = flxoa_system_user.id " +
				"leftFormData" +				
				//where 条件
				" where flxoa_approve_form.delete_flag = '0' ";
		if(null != flxoaApproveForm.getCreateUserId()){
			sql += " and flxoa_approve_form.create_user_id = '"+flxoaApproveForm.getCreateUserId()+"' ";
		}
		//审批状态和工作流id
		if(null != flxoaApproveForm.getList()){
			if(flxoaApproveForm.getList().size() > 0){
				List<FlxoaApproveForm> list = flxoaApproveForm.getList();
				sql += " and (";
				//遍历map
				for (int i = 0; i < list.size(); i++) {
					sql += " (flxoa_approve_form.workflow_id = "+list.get(i).getWorkflowId()+
							" and flxoa_approve_form.status = "+(Integer.parseInt(list.get(i).getStatus())-1)+
							" and (flxoa_approve_form.submit_status = '1' or flxoa_approve_form.submit_status = '2')) or";
				}
				sql = sql.substring(0, sql.length()-2);
				sql += ") ";
			}
		}
		String DepartmentIds = flxoaApproveForm.getDepartmentIds();
		//权限范围内的部门ids
		if(null != DepartmentIds){
			if(!"".equals(DepartmentIds)){
				if(DepartmentIds.indexOf(",") != -1){
					String [] temp = DepartmentIds.split(",");
					sql += " and (";
					//遍历map
					for (int i = 0; i < temp.length; i++) {
						sql += " flxoa_approve_form.create_department_id = "+temp[i]+ " or ";
					}
					sql = sql.substring(0, sql.length()-3);
					sql += ") ";					
				}else{
					sql += " and flxoa_approve_form.create_department_id = "+DepartmentIds;
				}
			}
		}
		//审批状态
		if(null != flxoaApproveForm.getApproveStatus()){
			sql += " and flxoa_approve_form.submit_status ='"+flxoaApproveForm.getApproveStatus()+"'";
		}
		//申请表类型
		if(null != flxoaApproveForm.getApproveType()){
			sql += " and flxoa_approve_form.template_id ='"+flxoaApproveForm.getApproveType()+"'";
		}
		String startTime = "";
		//申请时间 开始时间
		if(null != flxoaApproveForm.getStartTime()){
			startTime = " and flxoa_approve_form.submit_time >='"+flxoaApproveForm.getStartTime()+"'";
			sql += startTime;
		}
		String endTime = "";
		//申请时间 结束时间 86400 1天的时间戳
		if(null != flxoaApproveForm.getEndTime()){
			endTime = " and flxoa_approve_form.submit_time <'"+(flxoaApproveForm.getEndTime()+86400)+"'";
			sql += endTime;
		}
		//申请时间:开始时间 结束时间 相等 为同一天
		if(null != flxoaApproveForm.getStartTime() && null != flxoaApproveForm.getEndTime()){
			if(flxoaApproveForm.getStartTime().intValue() == flxoaApproveForm.getEndTime().intValue()){
				sql = sql.replace(startTime, "");
				sql = sql.replace(endTime, "");
				sql += " and flxoa_approve_form.submit_time >='"+flxoaApproveForm.getStartTime()+"' " +
					" and flxoa_approve_form.submit_time <'"+(flxoaApproveForm.getEndTime()+86400)+"' ";
			}
		}
		//申请人
		if(null != flxoaApproveForm.getRealName()){
			sql += " and flxoa_system_user.real_name like '%"+flxoaApproveForm.getRealName()+"%'";
		}
		//特殊状态
		if(null != flxoaApproveForm.getNowFormStatus()){
			sql += " and flxoa_approve_form.now_form_status ='"+flxoaApproveForm.getNowFormStatus()+"'";
		}		
		//首页 审批状态 1,2
		if(null != flxoaApproveForm.getStates()){
			sql += " and flxoa_approve_form.submit_status in ( "+flxoaApproveForm.getStates()+")";
		}
		String formIds = flxoaApproveForm.getFormIds();
		//审批记录 自己能查看的formIds
		if(null != formIds){
			if(!"".equals(formIds)){
				if(formIds.indexOf(",") != -1){
					String [] temp = formIds.split(",");
					sql += " and (";
					//遍历map
					for (int i = 0; i < temp.length; i++) {
						sql += " flxoa_approve_form.id = "+temp[i]+ " or ";
					}
					sql = sql.substring(0, sql.length()-3);
					sql += ") ";					
				}else{
					sql += " and flxoa_approve_form.id = "+formIds;
				}
			}
		}
		//关键字英文名称
		String keywordName = flxoaApproveForm.getKeywordName();
		//关键字检索选择或者输入的值
		String keywordValue = flxoaApproveForm.getKeywordValue();	
		//关键字类型
		String keywordType = flxoaApproveForm.getKeywordType();		
		if(!CommonUtils.isEmpty(keywordName)){
			leftDataFlag = true;
			String [] keywordNameArray = keywordName.split(",");
			String [] keywordValueArray = keywordValue.split(",");
			String [] keywordTypeArray = keywordType.split(",");
			sql += " and (";
			//遍历map
			for (int i = 0; i < keywordNameArray.length; i++) {
				sql += " (flxoa_approve_formdata.data_key = '"+keywordNameArray[i]+"'";
				//1：下拉列表 2：单选 8:复选框
				if("1".equals(keywordTypeArray[i])
					||"2".equals(keywordTypeArray[i])
					||"8".equals(keywordTypeArray[i])){
					sql += " and flxoa_approve_formdata.data_value = '"+keywordValueArray[i]+"'";
				}else{
					sql += " and flxoa_approve_formdata.data_value like '%"+keywordValueArray[i]+"%'";
				}
				sql += " ) or";
			}
			sql = sql.substring(0, sql.length()-2);
			sql += ") ";			
		}
		//项目名称
		String projectName = flxoaApproveForm.getProjName();
		if(!CommonUtils.isEmpty(projectName)){
			leftDataFlag = true;
			sql += " and (flxoa_approve_formdata.data_key = 'projNumber'" +
					"and flxoa_approve_formdata.data_value like '%"+projectName+"%') ";
		}
		
		//项目编号
		String projectNo = flxoaApproveForm.getProjNumber();
		if(!CommonUtils.isEmpty(projectNo)){
			leftDataFlag = true;
			sql += " and (flxoa_approve_formdata.data_key = 'projName'" +
					"and flxoa_approve_formdata.data_value like '%"+projectNo+"%') ";
		}
		
		//需要查询formData数据时候 左连  formData表
		if(leftDataFlag){
			leftFormData = " left join flxoa_approve_formdata " +
					" on flxoa_approve_form.id = flxoa_approve_formdata.form_id ";	
			sql = sql.replace("leftFormData", leftFormData);
		}else{
			sql = sql.replace("leftFormData", "");
		}
		
		String checkUserId = flxoaApproveForm.getCheckUserIds();
		//确认者id
		if(null != checkUserId){
			if(!"".equals(checkUserId)){
				sql += " or (flxoa_approve_form.check_user_ids like '%,"+checkUserId+",%' ";
				//审批状态
				if(null != flxoaApproveForm.getApproveStatus()){
					sql += " and flxoa_approve_form.submit_status ='"+flxoaApproveForm.getApproveStatus()+"'";
				}
				//申请表类型
				if(null != flxoaApproveForm.getApproveType()){
					sql += " and flxoa_approve_form.template_id ='"+flxoaApproveForm.getApproveType()+"'";
				}
				//申请时间
				if(null != flxoaApproveForm.getStartTime()){
					sql += " and flxoa_approve_form.submit_time >='"+flxoaApproveForm.getStartTime()+"'";
				}
				//申请人
				if(null != flxoaApproveForm.getRealName()){
					sql += " and flxoa_system_user.real_name like '%"+flxoaApproveForm.getRealName()+"%'";
				}				
				sql += " and flxoa_approve_form.delete_flag = '0')";
			}
		}
		String orderBy = flxoaApproveForm.getOrderBy();
		String orderBySql = " order by flxoa_approve_form.submit_time desc";
		if(null != orderBy){
			if(!"".equals(orderBy)){
				orderBySql = " order by flxoa_approve_form."+orderBy+" desc";
			}
		}
		sql += orderBySql;
		System.out.println("sql:"+sql);
		List list = getListBySQL(sql, null);
		List<FlxoaApproveForm> formList = new ArrayList<FlxoaApproveForm>();
		for (int i = 0; i < list.size(); i++) {
			FlxoaApproveForm form = new FlxoaApproveForm();
			Object[] objects = (Object[])list.get(i);
			form.setApproveType(String.valueOf(objects[0]));
			form.setApproveTime(DateUtils.timestampToDate(Integer.parseInt(String.valueOf(objects[1])),"yyyy-MM-dd"));
			form.setProjNumber(String.valueOf(objects[2]));
			form.setProjName(String.valueOf(objects[3]));
			form.setSubmitStatus(String.valueOf(objects[4]));
			form.setStatus(String.valueOf(objects[5]));
			form.setTemplateId((Integer)(objects[6]));
			form.setId((Integer)(objects[7]));
			form.setCreateDepartmentId((Integer)(objects[8]));
			form.setWorkflowId((Integer)(objects[9]));
			form.setRealName(String.valueOf(objects[10]));
			form.setUpdateUserId((Integer)(objects[11]));
			form.setCheckUserIds(String.valueOf(objects[12]));
			form.setIsRead(String.valueOf(objects[13]));
			form.setNowFormStatus(String.valueOf(objects[14]));
			form.setUpdateTime((Integer)(objects[15]));
			formList.add(form);
		}
		return formList;
	}
	/**
	 *查询FlxoaApproveForm ByID
	 */ 
	public FlxoaApproveForm queryById(FlxoaApproveForm flxoaApproveForm) {
		return get(flxoaApproveForm.getId());
	}
	
	/**
	 *查询 审批记录详情  FlxoaApproveForm 
	 */ 
	public List<FlxoaApproveForm> queryApproveFormLog(FlxoaApproveForm flxoaApproveForm) {
		//查询(0申请类型 1申请时间 2审批时间 3审批人 4审批意见 5审批备注 6当前状态 7下一状态 8工作流id 9提交状态)
		String sql  = "select " +
				" (select flxoa_approve_formtemplate.name from flxoa_approve_formtemplate " +
				" where flxoa_approve_formtemplate.id = flxoa_approve_form.template_id)," +
				" flxoa_approve_form.submit_time," +
				" flxoa_approve_formlog.approve_time," +
				" flxoa_approve_formlog.approve_user," +
				" flxoa_approve_formlog.approve_idea," +
				" flxoa_approve_formlog.approve_remark," +				
				" flxoa_approve_formlog.now_status," +
				" flxoa_approve_formlog.next_status," +
				" flxoa_approve_form.workflow_id," +
				" flxoa_approve_form.submit_status" +
				" from flxoa_approve_form " +
				//连表
				" left join flxoa_approve_formlog on " +
				" flxoa_approve_form.id = flxoa_approve_formlog.form_id " +
				//where
				" where flxoa_approve_form.delete_flag = '0' "+
				"  AND flxoa_approve_formlog.delete_flag='0' ";

		//form id
		if(null != flxoaApproveForm.getId()){
			sql += " and flxoa_approve_formlog.form_id = '"+flxoaApproveForm.getId()+"' ";
		}
		//审批用户id
		if(null != flxoaApproveForm.getApproveUserId()){
			sql += " and flxoa_approve_formlog.create_user_id = '"+flxoaApproveForm.getApproveUserId()+"' ";
		}
		String DepartmentIds = flxoaApproveForm.getDepartmentIds();
		//权限范围内的部门ids
		if(null != DepartmentIds){
			if(!"".equals(DepartmentIds)){
				if(DepartmentIds.indexOf(",") != -1){
					String [] temp = DepartmentIds.split(",");
					sql += " and (";
					//遍历map
					for (int i = 0; i < temp.length; i++) {
						sql += " flxoa_approve_form.create_department_id = "+temp[i]+ " or ";
					}
					sql = sql.substring(0, sql.length()-3);
					sql += ") ";					
				}else{
					sql += " and flxoa_approve_form.create_department_id = "+DepartmentIds;
				}
			}
		}		
		sql += " order by flxoa_approve_formlog.create_time desc";
		System.out.println("sql:"+sql);
		List list = getListBySQL(sql, null);
		List<FlxoaApproveForm> formList = new ArrayList<FlxoaApproveForm>();
		for (int i = 0; i < list.size(); i++) {
			FlxoaApproveForm form = new FlxoaApproveForm();
			Object[] objects = (Object[])list.get(i);
			if(list.size() == 1 && null == objects[2]){
				break;
			}			
			form.setApproveType(String.valueOf(objects[0]));
			form.setApproveTime(DateUtils.timestampToDate(Integer.parseInt(String.valueOf(objects[1])),"yyyy-MM-dd"));
			form.setApproveLogTime(DateUtils.timestampToDate(Integer.parseInt(String.valueOf(objects[2])),"yyyy-MM-dd"));
			form.setApproveUser(String.valueOf(objects[3]));
			form.setApproveIdea(String.valueOf(objects[4]));
			form.setApproveRemark(String.valueOf(objects[5]));
			form.setNowStatus(String.valueOf(objects[6]));
			form.setStatus(String.valueOf(objects[6]));
			form.setNextStatus(String.valueOf(objects[7]));
			form.setWorkflowId((Integer)(objects[8]));
			form.setSubmitStatus(String.valueOf(objects[9]));
			formList.add(form);
		}
		return formList;
	}
	
	/**
	 *查询 确认人确认状态  FlxoaApproveForm 
	 */ 
	public List<FlxoaApproveForm> queryChechUserApproveFormLog(FlxoaApproveForm flxoaApproveForm) {
		//查询(0确认人 1确认时间  2审批意见 3审批备注 4formId 5userId)
		String sql  = "select " +
				" flxoa_system_user.real_name," +
				" flxoa_approve_formlog.approve_time," +
				" flxoa_approve_formlog.approve_idea," +
				" flxoa_approve_formlog.approve_remark, "+
				" flxoa_approve_formlog.form_id, "+
				" flxoa_system_user.id "+
				" from flxoa_system_user " +
				//连表
				" left join flxoa_approve_formlog on " +
				" flxoa_system_user.id = flxoa_approve_formlog.create_user_id " +
				//where
				" where 1=1 ";
//				"flxoa_approve_formlog.delete_flag = '0' " +
//				" and flxoa_approve_formlog.approve_idea = '4' ";
//		//form id
//		if(null != flxoaApproveForm.getId()){
//			sql += " and flxoa_approve_formlog.form_id = '"+flxoaApproveForm.getId()+"' ";
//		}
		String checkUserIds = flxoaApproveForm.getCheckUserIds();
		//确认人ids
//		if(null != checkUserIds){
//			if(!"".equals(checkUserIds)){
//				if(checkUserIds.indexOf(",") != -1){
//					if(checkUserIds.length() > 3 ){
//						String [] temp = checkUserIds.split(",");
//						sql += " and (";
//						//遍历map
//						for (int i = 0; i < temp.length; i++) {
//							if(!"".equals(temp[i])){
//								sql += " flxoa_system_user.id = "+temp[i]+ " or ";							
//							}
//						}
//						sql = sql.substring(0, sql.length()-3);
//						sql += ") ";							
//					}
//				
//				}
//			}
//		}
		
		sql += " order by flxoa_approve_formlog.create_time desc";
		System.out.println("sql:"+sql);
		List list = getListBySQL(sql, null);
		List<FlxoaApproveForm> formList = new ArrayList<FlxoaApproveForm>();
		for (int i = 0; i < list.size(); i++) {
			FlxoaApproveForm form = new FlxoaApproveForm();
			Object[] objects = (Object[])list.get(i);
			form.setApproveUser(String.valueOf(objects[0]));
			if(null != objects[2]){
				form.setApproveLogTime(DateUtils.timestampToDate(Integer.parseInt(String.valueOf(objects[1])),"yyyy-MM-dd"));
				form.setIsCheck("是");
				form.setApproveIdea(String.valueOf(objects[2]));
				form.setApproveRemark(String.valueOf(objects[3]));
				form.setId(Integer.parseInt(String.valueOf(objects[4])));
				if("4".equals(form.getApproveIdea())&&form.getId() == flxoaApproveForm.getId()){
					formList.add(form);	
				}
			}else{
				if(null != checkUserIds){
					if(!"".equals(checkUserIds)){
						if(checkUserIds.indexOf(",") != -1){
							if(checkUserIds.length() > 3 ){
								String [] temp = checkUserIds.split(",");
								for (int k = 0; k < temp.length; k++) {
									if(!"".equals(temp[k])){
										if(String.valueOf(objects[5]).equals(temp[k])){
											form.setApproveLogTime("");
											form.setIsCheck("否");
											form.setApproveIdea("");
											form.setApproveRemark("");
											formList.add(form);												
										}
									}
								}		
							}
						
						}
					}
				}				
			}

		}
		return formList;
	}
	
	/**
	 *分页FlxoaApproveForm pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<FlxoaApproveForm> queryForPage(int pageNo,int pageSize,FlxoaApproveForm flxoaApproveForm) {
		String hql = " from FlxoaApproveForm where delete_flag = '0' ";
		return queryForPageByHQL(pageNo, pageSize, hql);
	}
	/**
	 *查询FlxoaApproveForm数据条数 
	 */ 
	public Long queryCount(FlxoaApproveForm flxoaApproveForm) {
		String hql = "select count(*) from FlxoaApproveForm where delete_flag = '0' ";
		return countByHql(hql,null);
	}
	
	@Override
	protected Class<FlxoaApproveForm> getEntityClass() {
		return FlxoaApproveForm.class;
	}
	/**
	 * 根据用户id、请假申请表和签到时间查询审批状态
	 */
	@Override
	public List<Map<String,Object>> queryLeaveRecord(int userIds, int templateId,int signDateNew) {
		//请假比较的时间点 每天的 9:05:00  凌晨时间+9::05
		int Date = signDateNew+32700;
		String sql ="select c.startstatus from"+ 
				"(SELECT startformid,startstatus,startkey,startvalue,endformid,endstatus,endkey,endvalue from"+
				"(SELECT flxoa_approve_formdata.form_id as startformid,flxoa_approve_form.submit_status as startstatus,flxoa_approve_formdata.data_key as startkey,flxoa_approve_formdata.data_value as startvalue from  flxoa_approve_form"+
				" left JOIN flxoa_approve_formdata on flxoa_approve_form.id = flxoa_approve_formdata.form_id"+
				" WHERE (data_key='al_start_time')"+
				" and flxoa_approve_form.create_user_id ="+userIds+" AND flxoa_approve_form.template_id="+templateId+""+
				" order by flxoa_approve_form.id) a,"+
				" (SELECT flxoa_approve_formdata.form_id as endformid,flxoa_approve_form.submit_status as endstatus,flxoa_approve_formdata.data_key as endkey,flxoa_approve_formdata.data_value as endvalue from  flxoa_approve_form"+
				" left JOIN flxoa_approve_formdata on flxoa_approve_form.id = flxoa_approve_formdata.form_id"+
				" WHERE (data_key='al_end_time')"+
				" and flxoa_approve_form.create_user_id ="+userIds+" AND flxoa_approve_form.template_id="+templateId+""+
				" order by flxoa_approve_form.id) b"+
				" where startformid = endformid) as c"+
				" where  c.startkey < "+Date+" and c.endkey > "+Date+" "
				;
		List list= querySQL(sql);
		List<Map<String,Object>> mapList = new ArrayList<Map<String,Object>>(); 
		for(int i=0;i<list.size();i++){
			Map<String,Object> map = new HashMap<String,Object>();
			//Object[] listValue = (Object[]) list.get(i);
			map.put("startstatus", String.valueOf(list.get(i)));
			//map.put("startstatus", CommonUtils.returnStr(listValue[1]));
			//map.put("startkey", CommonUtils.returnStr(listValue[2]));
			//map.put("startvalue", CommonUtils.returnStr(listValue[3]));
			//map.put("endformid", CommonUtils.returnInt(listValue[4]));
			//map.put("endstatus", CommonUtils.returnStr(listValue[5]));
			//map.put("endkey", CommonUtils.returnStr(listValue[6]));
			//map.put("endvalue", CommonUtils.returnStr(listValue[7]));
			mapList.add(map);
		}
		return mapList;
	} 

}