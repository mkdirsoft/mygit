package com.flx.flxoa.info.cashcollection.dao.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.flx.flxoa.info.approve.entity.FlxoaApproveFormdata;
import com.flx.flxoa.info.cashcollection.entity.FlxoaCashcollectionRecord;
import com.flx.flxoa.info.cashcollection.dao.FlxoaCashcollectionRecordDao;
import com.flx.flxoa.info.system.comon.Permission;

import org.springframework.stereotype.Repository;
import com.flx.flxoa.common.hibernate3.HibernateBaseDao;
import com.flx.flxoa.common.util.CommonUtils;
import com.flx.flxoa.common.util.DateUtils;

/**
 *
 * 类名称：FlxoaCashcollectionRecordDaoImpl.java
 * 类描述：
 * 创建时间：2018-03-16, 下午06:54:26
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 赵鹏辉
 */ 
@Repository
public class FlxoaCashcollectionRecordDaoImpl extends HibernateBaseDao<FlxoaCashcollectionRecord, Integer> implements FlxoaCashcollectionRecordDao {
	/**
	 *添加FlxoaCashcollectionRecord
	 */ 
	public boolean add(FlxoaCashcollectionRecord flxoaCashcollectionRecord) {
		return save(flxoaCashcollectionRecord);
	}
	/**
	 *删除FlxoaCashcollectionRecord
	 */ 
	public boolean delete(FlxoaCashcollectionRecord flxoaCashcollectionRecord) {
		flxoaCashcollectionRecord.setDeleteFlag("1");
		return save(flxoaCashcollectionRecord);
	}
	/**
	 *修改FlxoaCashcollectionRecord
	 */ 
	public boolean update(FlxoaCashcollectionRecord flxoaCashcollectionRecord) {
		return modify(flxoaCashcollectionRecord);
	}
	/**
	 *查询FlxoaCashcollectionRecord列表
	 */ 
	public List<FlxoaCashcollectionRecord> query(FlxoaCashcollectionRecord flxoaCashcollectionRecord) {
		String hql = " from FlxoaCashcollectionRecord where delete_flag = '0' ";
		return getListByHQL(hql, null);
	}
	/**
	 *查询FlxoaCashcollectionRecord ByID
	 */ 
	public FlxoaCashcollectionRecord queryById(FlxoaCashcollectionRecord flxoaCashcollectionRecord) {
		return get(flxoaCashcollectionRecord.getId());
	}

	/**
	 * 分页
	 */
	public String queryForPage(Map<String,String> map){
		//查询hql语句
		String hql=" from "
				+ "flxoa_cashcollection_record Cash "
				+ "left join "
				+ "flxoa_project_information project on Cash.project_id=project.id "
				+ "left join "
				+ "flxoa_system_user claimUser on Cash.claim_id=claimUser.id "
				+ "left join "
				+ "flxoa_system_user affirmUser on Cash.affirm_id=affirmUser.id " 
				+ "left join "
				+ "flxoa_system_department  on claimUser.department_id = flxoa_system_department.id " 
				+ "left join "
				+ "("
				+ "select "
				+ "enumeration_name,"
				+ "enumeration_key,"
				+ "enumeration_value typeValue "
				+ "from "
				+ "flxoa_system_enumeration"
				+ " where "
				+ "enumeration_name='caro_type' and delete_flag='0'"
				+ ") "
				+ "caroTypeEnu on caroTypeEnu.enumeration_key=Cash.caro_type "
				+ "left join "
				+ "("
				+ "select "
				+ "enumeration_name,"
				+ "enumeration_key,"
				+ "enumeration_value statusValue "
				+ "from "
				+ "flxoa_system_enumeration "
				+ "where "
				+ "enumeration_name='caro_status' and delete_flag='0'"
				+ ") "
				+ "caroStatusEnu on caroStatusEnu.enumeration_key=Cash.status "
				+ "where "
				+ "Cash.delete_flag = '0' and Cash.isshow = '0'  ";
		String deptWhere=map.get("deptWhere");
		String caroOrgName=map.get("caroOrgName");
		String projName=map.get("projName");
		String projNumber=map.get("projNumber");
		String startTime=map.get("startTime");
		String endTime=map.get("endTime");
		String claimUserName=map.get("claimUserName");
		String affirmUserName=map.get("affirmUserName");
		String caroMoney=map.get("caroMoney");
		String caroType=map.get("caroType");
		String caroState=map.get("caroState");
		String statusWhere=map.get("statusWhere");
		String deptData=map.get("deptData");
		String unitName=map.get("unitName");
		String caroStatusCheck=map.get("caroStatusCheck");
		int start=Integer.valueOf(map.get("start"));
		int length=Integer.valueOf(map.get("length"));
		
		System.out.println("回款查询dao层数据开始位置：===="+start);
		System.out.println("回款查询dao层数据长度：======"+length);
		String draw=map.get("draw");
		String flagDo = map.get("flagDo");


		if(!CommonUtils.isEmpty(deptWhere)){
			if(!deptData.equals("0")&&!deptData.equals("1")){
				if(deptData.equals("2")){
					hql+=" and Cash.project_id='0'";
				}else if(deptData.equals("3")){
					hql+=" and Cash.project_id in(select pro.project_id from flxoa_project_bid_information pro left join flxoa_system_user sysUser on pro.follower_id=sysUser.id where ";
					hql+=deptWhere;
					hql+=") ";
				}else if(deptData.equals("4")){
					hql+=" and (Cash.project_id in(select pro.project_id from flxoa_project_bid_information pro left join flxoa_system_user sysUser on pro.follower_id=sysUser.id where ";
					hql+=deptWhere;
					hql+=") or Cash.project_id='0') ";
				}
			}
		}

		if(!CommonUtils.isEmpty(caroOrgName)){
			hql+=" and Cash.caro_org_name like '%";
			hql+=caroOrgName;
			hql+="%'";
		}
		if(!CommonUtils.isEmpty(projName)){
			hql+=" and project.proj_name like '%";
			hql+=projName;
			hql+="%'";
		}
		if(!CommonUtils.isEmpty(projNumber)){
			hql+=" and project.proj_number like'%";
			hql+=projNumber;
			hql+="%'";
		}
		if(!CommonUtils.isEmpty(unitName)){
			hql+=" and flxoa_system_department.name like'%";
			hql+=unitName;
			hql+="%'";
		}
		if(!CommonUtils.isEmpty(startTime)){
			int startDataTime = DateUtils.getSecondTimestamp(DateUtils.getCurrYearFirst());
			hql+=" and Cash.create_time  >= '"+startDataTime+"' ";
		}
		if(!CommonUtils.isEmpty(startTime) && CommonUtils.isEmpty(endTime)) {
			int startDataTime = Integer.valueOf(startTime) + 86400;
			System.out.println("startDataTime="+startDataTime);
			hql+=" and Cash.create_time  >= '"+startTime+"' ";
			hql+="and Cash.create_time < '"+startDataTime+"'";
		}		
		if(!CommonUtils.isEmpty(startTime) && !CommonUtils.isEmpty(endTime)){
			int EndDataTime = Integer.valueOf(endTime) + 86400;
			hql+=" and Cash.create_time Between ";
			hql+=startTime;
			hql+=" and ";
			hql+=EndDataTime;
		}
		if(!CommonUtils.isEmpty(claimUserName)){
			hql+=" and claimUser.real_name like '%";
			hql+=claimUserName;
			hql+="%'";
		}
		if(!CommonUtils.isEmpty(affirmUserName)){
			hql+=" and affirmUser.real_name like '%";
			hql+=affirmUserName;
			hql+="%'";
		}
		if(!CommonUtils.isEmpty(caroMoney)){
			hql+=" and Cash.caro_money='";
			hql+=caroMoney;
			hql+="'";
		}
		if(!CommonUtils.isEmpty(caroType)){
			hql+=" and Cash.caro_type='";
			hql+=caroType;
			hql+="'";
		}
		if(!CommonUtils.isEmpty(caroStatusCheck)){
			hql+=" and Cash.status='";
			hql+=caroStatusCheck;
			hql+="'";
		}else{
			if(!CommonUtils.isEmpty(flagDo)){
				hql+=" and Cash.status!='4'";
			}
		}
		if(!CommonUtils.isEmpty(statusWhere)){
			hql+=statusWhere;
		}
		//hql+=" order by Cash.create_time , Cash.caro_org_name, Cash.id desc";
		hql+=" order by Cash.create_time desc ";
		//查询参数
		String querySql="select "
				+ "Cash.id,"
				+ "Cash.create_time,"
				+ "Cash.caro_org_name,"
				+ "Cash.caro_money,"
				+ "project.proj_name,"
				+ "project.proj_number,"
				+ "claimUser.real_name claim_name,"
				+ "Cash.claim_time,"
				+ "affirmUser.real_name affirm_name,"
				+ "Cash.affirm_time,"
				+ "caroTypeEnu.typeValue,"
				+ "Cash.caro_use,"
				+ "caroStatusEnu.statusValue,"
				+ "flxoa_system_department.name unit_name,"
				+ "claimUser.department_id"+hql;

		//求和查询sql
		String countSql="select count(*) "+hql;
		String sumSql="select sum(Cash.caro_money*1.0) "+hql;

		System.out.println("回款统计计算数据获取sql001:==="+sumSql);
		//后台分页，暂时注销
		System.out.println("回款分页数据获取sql:==="+querySql);
		List list= queryListForPageBySQL(start, length, querySql);
		//List list= querySQL(querySql,null);
		List<Map<String,String>> dataList=new ArrayList<Map<String,String>>();
		List<Map<String,String>> otherDataList=new ArrayList<Map<String,String>>();

		for(int i=0;i<list.size();i++){
			Map<String,String> dataMap=new HashMap<String,String>();
			Object[] obj=(Object[]) list.get(i);
			dataMap.put("id", String.valueOf(obj[0]));
			dataMap.put("createTime", String.valueOf(obj[1]));
			dataMap.put("caroOrgName", String.valueOf(obj[2]));
			dataMap.put("caroMoney", String.valueOf(obj[3]));
			dataMap.put("projName", String.valueOf(obj[4]));
			dataMap.put("projNumber", String.valueOf(obj[5]));
			dataMap.put("claimUserName", String.valueOf(obj[6]));
			dataMap.put("claimTime", String.valueOf(obj[7]));
			dataMap.put("affirmUserName", String.valueOf(obj[8]));
			dataMap.put("affirmTime", String.valueOf(obj[9]));
			dataMap.put("caroType", String.valueOf(obj[10]));
			dataMap.put("caroUse", String.valueOf(obj[11]));
			dataMap.put("caroStatus", String.valueOf(obj[12]));
			dataMap.put("unitNameValue", String.valueOf(obj[13]));
			dataList.add(dataMap);
		}
		Long totalCount= countBySql(countSql,null);
		if(null != flagDo){
			//页面点击统计
			if("1".equals(flagDo)){
				System.out.println("回款统计计算数据获取sql002:==="+sumSql);
				String sum=sumBySql(sumSql,null);
				Map<String,String> otherDataMap=new HashMap<String,String>();
				otherDataMap.put("sum", sum);
				otherDataList.add(otherDataMap);				
			}
		}
		return CommonUtils.getPageJson(start, length,draw,totalCount,dataList,otherDataList);
	}

	/**
	 * 查看
	 */
	public String view(int start,int length,String caroId,String draw){
		List<Map<String,String>> dataList=new ArrayList<Map<String,String>>();
		List<Map<String,String>> otherDataList=new ArrayList<Map<String,String>>();
		if(!CommonUtils.isEmpty(caroId)){
			//查询hql语句
			String hql=" from flxoa_cashcollection_claim_affirm cash left join flxoa_system_user sysUser on cash.create_user_id=sysUser.id left join (select enumeration_name,enumeration_key,enumeration_value statusValue from flxoa_system_enumeration where enumeration_name='caro_record' and delete_flag='0') caroRecordEnu on caroRecordEnu.enumeration_key=cash.status where cash.delete_flag='0' and cash.caro_id='";
			hql+=caroId;
			hql+="' order by cash.id desc";
			//查询参数
			String querySql="select sysUser.real_name,cash.create_time,caroRecordEnu.statusValue,cash.operation_content "+hql;

			//求和查询sql
			String countSql="select count(*) "+hql;

			List list= queryListForPageBySQL(start, length, querySql);
			for(int i=0;i<list.size();i++){
				Map<String,String> dataMap=new HashMap<String,String>();
				Object[] obj=(Object[]) list.get(i);
				dataMap.put("realName", String.valueOf(obj[0]));
				dataMap.put("createTime", String.valueOf(obj[1]));
				dataMap.put("caroStatus", String.valueOf(obj[2]));
				dataMap.put("operationContent", String.valueOf(obj[3]));
				dataList.add(dataMap);
			}
			Long totalCount= countBySql(countSql,null);
			Map<String,String> otherDataMap=new HashMap<String,String>();
			otherDataList.add(otherDataMap);
			return CommonUtils.getPageJson(start,length,draw,totalCount,dataList,otherDataList);
		}else{
			return CommonUtils.getPageJson(start,length,draw,0,dataList,otherDataList);
		}
	}

	public Long queryCount(){
		String hql="select count(*) from FlxoaCashcollectionRecord where delete_flag = '0'";
		return countByHql(hql,null);
	}
	/**
	 * 认领
	 */
	public List<FlxoaCashcollectionRecord> renlingRecord(String projectId) {
		String hql = " from FlxoaCashcollectionRecord where delete_flag = '0' and status in(1,3) and project_id=? ";
		Object [] obj = {projectId};
		return getListByHQL(hql, obj);
	}

	/**
	 *查询FlxoaCashcollectionRecord ByID
	 */ 
	public List<FlxoaCashcollectionRecord> queryByPId(String pid) {
		String hql = " from FlxoaCashcollectionRecord where delete_flag = '0' and pid=? ";
		Object [] obj = {pid};
		return getListByHQL(hql, obj);
	}
	
	public List<Map<String,String>> query(Map<String,String> map) {
		//查询hql语句
		String hql="select Cash.id,Cash.create_time,Cash.caro_org_name,Cash.caro_money,project.proj_name,project.proj_number," +
				"claimUser.real_name claim_name,Cash.claim_time,affirmUser.real_name affirm_name,Cash.affirm_time,caroTypeEnu.typeValue,Cash.caro_use,caroStatusEnu.statusValue,lixiang.lixiang_name " +
				" from flxoa_cashcollection_record Cash left join flxoa_project_information project on Cash.project_id=project.id " +
				" left join (select project.proj_number,lixiangUser.real_name lixiang_name from flxoa_project_information project left join  flxoa_approve_formdata formdata on project.proj_number=formdata.data_value " +
				"left join flxoa_approve_form form on  form.id=formdata.form_id left join flxoa_system_user lixiangUser on lixiangUser.id=form.create_user_id where form.template_id='29' and form.submit_status='3' " +
				"and form.delete_flag='0' and project.delete_flag='0' and formdata.data_key='projNumber') lixiang on project.proj_number=lixiang.proj_number left join flxoa_system_user claimUser "+
				"on Cash.claim_id=claimUser.id left join flxoa_system_user affirmUser on Cash.affirm_id=affirmUser.id " +
				"left join (select enumeration_name,enumeration_key,enumeration_value typeValue from flxoa_system_enumeration where enumeration_name='caro_type' and delete_flag='0') caroTypeEnu " +
				"on caroTypeEnu.enumeration_key=Cash.caro_type left join (select enumeration_name,enumeration_key,enumeration_value statusValue from flxoa_system_enumeration where enumeration_name='caro_status' and delete_flag='0') caroStatusEnu " +
				"on caroStatusEnu.enumeration_key=Cash.status where Cash.delete_flag = '0' and Cash.isshow='0' ";
		String deptWhere=map.get("deptWhere");
		String caroOrgName=map.get("caroOrgName");
		String projName=map.get("projName");
		String projNumber=map.get("projNumber");
		String startTime=map.get("startTime");
		String endTime=map.get("endTime");
		String claimUserName=map.get("claimUserName");
		String affirmUserName=map.get("affirmUserName");
		String caroMoney=map.get("caroMoney");
		String caroType=map.get("caroType");
		String statusWhere=map.get("statusWhere");
		String deptData=map.get("deptData");
		String unitName=map.get("unitName");

		if(!CommonUtils.isEmpty(deptWhere)){
			if(!deptData.equals("0")&&!deptData.equals("1")){
				if(deptData.equals("2")){
					hql+=" and Cash.project_id='0'";
				}else if(deptData.equals("3")){
					hql+=" and Cash.project_id in(select pro.project_id from flxoa_project_bid_information pro left join flxoa_system_user sysUser on pro.follower_id=sysUser.id where ";
					hql+=deptWhere;
					hql+=") ";
				}else if(deptData.equals("4")){
					hql+=" and (Cash.project_id in(select pro.project_id from flxoa_project_bid_information pro left join flxoa_system_user sysUser on pro.follower_id=sysUser.id where ";
					hql+=deptWhere;
					hql+=") or Cash.project_id='0') ";
				}
			}
		}

		if(!CommonUtils.isEmpty(caroOrgName)){
			hql+=" and Cash.caro_org_name like '%";
			hql+=caroOrgName;
			hql+="%'";
		}
		if(!CommonUtils.isEmpty(projName)){
			hql+=" and project.proj_name like '%";
			hql+=projName;
			hql+="%'";
		}
		if(!CommonUtils.isEmpty(projNumber)){
			hql+=" and project.proj_number like'%";
			hql+=projNumber;
			hql+="%'";
		}
		if(!CommonUtils.isEmpty(startTime)){
			hql+=" and Cash.create_time>=";
			hql+=startTime;
		}
		if(!CommonUtils.isEmpty(endTime)){
			hql+=" and Cash.create_time<=";
			hql+=endTime;
		}
		if(!CommonUtils.isEmpty(claimUserName)){
			hql+=" and claimUser.real_name like '%";
			hql+=claimUserName;
			hql+="%'";
		}
		if(!CommonUtils.isEmpty(unitName)){
			hql+=" and flxoa_system_department.name like'%";
			hql+=unitName;
			hql+="%'";
		}
		if(!CommonUtils.isEmpty(affirmUserName)){
			hql+=" and affirmUser.real_name like '%";
			hql+=affirmUserName;
			hql+="%'";
		}
		if(!CommonUtils.isEmpty(caroMoney)){
			hql+=" and Cash.caro_money='";
			hql+=caroMoney;
			hql+="'";
		}
		if(!CommonUtils.isEmpty(caroType)){
			hql+=" and Cash.caro_type='";
			hql+=caroType;
			hql+="'";
		}
		if(!CommonUtils.isEmpty(statusWhere)){
			hql+=statusWhere;
		}
		hql+=" order by Cash.caro_org_name, Cash.id desc";
		System.out.println("回款导出功能sql======="+hql);
		List list= querySQL(hql.toString(),null);
		List<Map<String,String>> dataList=new ArrayList<Map<String,String>>();
		for(int i=0;i<list.size();i++){
			Map<String,String> dataMap=new HashMap<String,String>();
			Object[] obj=(Object[]) list.get(i);
			dataMap.put("id", String.valueOf(obj[0]));
			if(CommonUtils.isEmpty(CommonUtils.returnStr(obj[1]))||CommonUtils.returnStr(obj[1]).equals("0")){
				dataMap.put("createTime"," ");
			}else{
				dataMap.put("createTime", DateUtils.timestampToDate(Integer.valueOf(CommonUtils.returnStr(obj[1]))));
			}
			dataMap.put("caroOrgName", String.valueOf(obj[2]));
			dataMap.put("caroMoney", String.valueOf(obj[3]));
			dataMap.put("projName", String.valueOf(obj[4]));
			dataMap.put("projNumber", String.valueOf(obj[5]));
			dataMap.put("claimUserName", String.valueOf(obj[6]));
			if(CommonUtils.isEmpty(CommonUtils.returnStr(obj[7]))||CommonUtils.returnStr(obj[7]).equals("0")){
				dataMap.put("claimTime"," ");
			}else{
				dataMap.put("claimTime",DateUtils.timestampToDate(Integer.valueOf(CommonUtils.returnStr(obj[7]))));
			}
			dataMap.put("affirmUserName", String.valueOf(obj[8]));
			if(CommonUtils.isEmpty(CommonUtils.returnStr(obj[9]))||CommonUtils.returnStr(obj[9]).equals("0")){
				dataMap.put("affirmTime"," ");
			}else{
				dataMap.put("affirmTime",DateUtils.timestampToDate(Integer.valueOf(CommonUtils.returnStr(obj[9]))));
			}
			dataMap.put("caroType", String.valueOf(obj[10]));
			dataMap.put("caroUse", String.valueOf(obj[11]));
			dataMap.put("caroStatus", String.valueOf(obj[12]));
			dataMap.put("lixiangName", String.valueOf(obj[13]));
			//dataMap.put("unitName", String.valueOf(obj[14]));
			dataList.add(dataMap);
			System.out.println(dataMap);
		}
		return dataList;
	}

	/**
	 * 审核
	 */
	public List<Map<String,String>> shenheRecord(String caroId) {
		String sql = "select Cash.create_time,Cash.caro_org_name,Cash.caro_money,leaderUser.real_name leaderUserName " +
				"from flxoa_cashcollection_record Cash left join flxoa_project_information project on Cash.project_id=project.id left join flxoa_system_user leaderUser on leaderUser.id=project.project_leader " +
				"where Cash.delete_flag = '0' and Cash.status in('3','8') and Cash.project_id=(select project_id from flxoa_cashcollection_record where id=?) ";
		Object [] objWhere = {caroId};
		List list= querySQL(sql,objWhere);
		List<Map<String,String>> dataList=new ArrayList<Map<String,String>>();
		for(int i=0;i<list.size();i++){
			Map<String,String> dataMap=new HashMap<String,String>();
			Object[] obj=(Object[]) list.get(i);
			dataMap.put("createTime", String.valueOf(obj[0]));
			dataMap.put("caroOrgName", String.valueOf(obj[1]));
			dataMap.put("caroMoney", String.valueOf(obj[2]));
			dataMap.put("leaderUserName", String.valueOf(obj[3]));
			dataList.add(dataMap);
		}
		return dataList;
	}
	/**
	 * 拆分
	 */
	public List<Map<String,String>> chaifenRecord(String caroId) {
		String sql="select Cash.id,Cash.create_time,Cash.caro_org_name,Cash.caro_money,project.proj_name,project.proj_number," +
				"claimUser.real_name claim_name,Cash.claim_time,affirmUser.real_name affirm_name,Cash.affirm_time,caroTypeEnu.typeValue,Cash.caro_use,caroStatusEnu.statusValue "+
				" from flxoa_cashcollection_record Cash left join flxoa_project_information project on Cash.project_id=project.id left join flxoa_system_user claimUser " +
				"on Cash.claim_id=claimUser.id left join flxoa_system_user affirmUser on Cash.affirm_id=affirmUser.id " +
				"left join (select enumeration_name,enumeration_key,enumeration_value typeValue from flxoa_system_enumeration where enumeration_name='caro_type' and delete_flag='0') caroTypeEnu " +
				"on caroTypeEnu.enumeration_key=Cash.caro_type left join (select enumeration_name,enumeration_key,enumeration_value statusValue from flxoa_system_enumeration where enumeration_name='caro_status' and delete_flag='0') caroStatusEnu " +
				"on caroStatusEnu.enumeration_key=Cash.status where Cash.delete_flag = '0' and pid=? ";
		
		Object [] objWhere = {caroId};
		List list= querySQL(sql,objWhere);
		List<Map<String,String>> dataList=new ArrayList<Map<String,String>>();
		for(int i=0;i<list.size();i++){
			Map<String,String> dataMap=new HashMap<String,String>();
			Object[] obj=(Object[]) list.get(i);
			dataMap.put("id", String.valueOf(obj[0]));
			dataMap.put("createTime", String.valueOf(obj[1]));
			dataMap.put("caroOrgName", String.valueOf(obj[2]));
			dataMap.put("caroMoney", String.valueOf(obj[3]));
			dataMap.put("projName", String.valueOf(obj[4]));
			dataMap.put("projNumber", String.valueOf(obj[5]));
			dataMap.put("claimUserName", String.valueOf(obj[6]));
			dataMap.put("claimTime", String.valueOf(obj[7]));
			dataMap.put("affirmUserName", String.valueOf(obj[8]));
			dataMap.put("affirmTime", String.valueOf(obj[9]));
			dataMap.put("caroType", String.valueOf(obj[10]));
			dataMap.put("caroUse", String.valueOf(obj[11]));
			dataMap.put("caroStatus", String.valueOf(obj[12]));
			dataList.add(dataMap);
		}
		return dataList;
	}
	
	@Override
	protected Class<FlxoaCashcollectionRecord> getEntityClass() {
		return FlxoaCashcollectionRecord.class;
	}
	/* (non-Javadoc)
	 * @see com.flx.flxoa.info.cashcollection.dao.FlxoaCashcollectionRecordDao#query(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */


}