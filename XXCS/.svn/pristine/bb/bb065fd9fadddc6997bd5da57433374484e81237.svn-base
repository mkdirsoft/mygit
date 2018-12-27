package com.flx.flxoa.info.clientsManagement.dao.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.flx.flxoa.info.clientsManagement.entity.FlxoaClientCommunication;
import com.flx.flxoa.info.clientsManagement.dao.FlxoaClientCommunicationDao;
import org.springframework.stereotype.Repository;
import com.flx.flxoa.common.hibernate3.HibernateBaseDao;
import com.flx.flxoa.common.util.CommonUtils;
import com.flx.flxoa.common.util.DateUtils;

/**
 *
 * 类名称：FlxoaClientCommunicationDaoImpl.java
 * 类描述：
 * 创建时间：2018-09-05, 下午03:19:41
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 孙进 
 */ 
@Repository
public class FlxoaClientCommunicationDaoImpl extends HibernateBaseDao<FlxoaClientCommunication, Integer> implements FlxoaClientCommunicationDao {
	/**
	 *添加FlxoaClientCommunication
	 */ 
	public boolean add(FlxoaClientCommunication flxoaClientCommunication) {
		return save(flxoaClientCommunication);
	}
	/**
	 *删除FlxoaClientCommunication
	 */ 
	public boolean delete(FlxoaClientCommunication flxoaClientCommunication) {
		flxoaClientCommunication.setDeleteFlag("1");
		return save(flxoaClientCommunication);
	}
	/**
	 *修改FlxoaClientCommunication
	 */ 
	public boolean update(FlxoaClientCommunication flxoaClientCommunication) {
		return modify(flxoaClientCommunication);
	}
	/**
	 *查询FlxoaClientCommunication列表
	 */ 
	public List<FlxoaClientCommunication> query(FlxoaClientCommunication flxoaClientCommunication) {
		String hql = " from FlxoaClientCommunication where delete_flag = '0' ";
		return getListByHQL(hql, null);
	}
	/**
	 *查询FlxoaClientCommunication ByID
	 */ 
	public FlxoaClientCommunication queryById(FlxoaClientCommunication flxoaClientCommunication) {
		return get(flxoaClientCommunication.getId());
	}
	/**
	 *分页FlxoaClientCommunication pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public String queryForPage(Map<String,String> map) {
		String hql = "SELECT ComInfo.id," +
				" Cinfo.client_name," +
				" SysUser.real_name," +
				" projInfo.proj_name," +
				" ConInfo.contact_name," +
				" ConInfo.contact_duty," +
				" ConInfo.contact_phone," +
				" ConInfo.contact_mail," +
				" ComInfo.comm_start_time," +
				" ComInfo.comm_end_time," +
				" ComInfo.comm_pattern," +
				" ComInfo.comm_main_content," +
				" ComInfo.delete_flag," +
				" ComInfo.create_user_id," +
				" ComInfo.create_department_id," +
				" ComInfo.create_time," +
				" ComInfo.update_user_id," +
				" ComInfo.update_department_id," +
				" ComInfo.update_time, " +
				" Coninfo.client_id, "+
				" ComInfo.proj_id "+
				"FROM flxoa_client_communication ComInfo " +
				"LEFT JOIN flxoa_client_contact Coninfo ON ComInfo.contact_id = Coninfo.id " +
				"LEFT JOIN flxoa_client_information Cinfo ON Coninfo.client_id = Cinfo.id " +
				"LEFT JOIN flxoa_project_information projInfo ON ComInfo.proj_id = projInfo.id " +
				"LEFT JOIN flxoa_system_user SysUser ON ComInfo.create_user_id=SysUser.id " +
				"LEFT JOIN (" +
				" SELECT enumeration_name," +
				" enumeration_key," +
				" enumeration_value " +
				"FROM flxoa_system_enumeration WHERE enumeration_name = 'comm_pattern' AND delete_flag = '0'" +
				" ) ComPattern ON ComPattern.enumeration_key = ComInfo.comm_pattern " +
				"WHERE" +
				" ComInfo.delete_flag = '0'"; 
		
		String orderSql=" GROUP BY ComInfo.id ORDER BY ComInfo.id ASC";
		
		String commId=map.get("comm_id");
		String draw=map.get("draw");
		String start=map.get("start");
		String length=map.get("length");
		String clientName=map.get("client_name");
		String projName=map.get("proj_name");
		String contactName=map.get("contact_name");
		String receiverName=map.get("receiver_name");
		String commStartDate=map.get("comm_startdate");
		String commEndDate=map.get("comm_enddate");
		int startDate=0;
		int endDate=0;
		if(!CommonUtils.isEmpty(commId)){
			hql+=" and ComInfo.id="+commId;
		}
		if(!CommonUtils.isEmpty(clientName)){
			hql+=" and Cinfo.client_name like '%"+clientName+"%'";
		}
		if(!CommonUtils.isEmpty(projName)){
			hql+=" and projInfo.proj_name like '%"+projName+"%'";
		}
		if(!CommonUtils.isEmpty(contactName)){
			hql+=" and ConInfo.contact_name like '%"+contactName+"%'";
		}
		if(!CommonUtils.isEmpty(receiverName)){
			hql+=" and SysUser.real_name liek '%"+receiverName+"%'";
		}
		if(!CommonUtils.isEmpty(commStartDate)&&!CommonUtils.isEmpty(commEndDate)){
			startDate=DateUtils.dateToTimestamp(commStartDate);
			endDate=DateUtils.dateToTimestamp(commEndDate);
			hql+=" and ComInfo.comm_start_time > "+startDate+" and ComInfo.comm_end_time <"+endDate;
		}
		hql+=orderSql;
		System.out.println("沟通查询SQL:==="+hql);
		/*计算数据总数*/
		String countSql="select count(*) from ("+hql+") as countTable";
		Long totalCount=countBySql(countSql,null);
		
		/*获取数据*/
		List list=queryListForPageBySQL(Integer.parseInt(start),Integer.parseInt(length),hql);
		List<Map<String,String>> dataList=new ArrayList<Map<String,String>>();
		for(int i=0;i<list.size();i++){
			Map<String,String> dataMap=new HashMap<String,String>();
			Object[] obj=(Object[]) list.get(i);
			dataMap.put("id", String.valueOf(obj[0]));
			dataMap.put("client_name", String.valueOf(obj[1]));
			dataMap.put("receiver_name", String.valueOf(obj[2]));
			dataMap.put("proj_name", String.valueOf(obj[3]));
			dataMap.put("contact_name", String.valueOf(obj[4]));
			dataMap.put("contact_duty", String.valueOf(obj[5]));
			dataMap.put("contact_phone", String.valueOf(obj[6]));
			dataMap.put("contact_mail", String.valueOf(obj[7]));
			dataMap.put("comm_starttime", String.valueOf(obj[8]));
			dataMap.put("comm_endtime", String.valueOf(obj[9]));
			dataMap.put("comm_pattern", String.valueOf(obj[10]));
			dataMap.put("comm_maincontent", String.valueOf(obj[11]));
			dataMap.put("delete_flag", String.valueOf(obj[12]));
			dataMap.put("create_userid", String.valueOf(obj[13]));
			dataMap.put("create_departmentid", String.valueOf(14));
			dataMap.put("create_time", String.valueOf(obj[15]));
			dataMap.put("update_userid", String.valueOf(obj[16]));
			dataMap.put("uapdate_departmentid", String.valueOf(obj[17]));
			dataMap.put("update_time", String.valueOf(obj[18]));
			dataMap.put("client_id", String.valueOf(obj[19]));
			dataMap.put("project_id", String.valueOf(obj[20]));
			dataList.add(dataMap);
		}
		return CommonUtils.getPageJson(Integer.parseInt(start), Integer.parseInt(length), draw, totalCount, dataList, null);
	}
	/**
	 *查询FlxoaClientCommunication数据条数 
	 */ 
	public Long queryCount(FlxoaClientCommunication flxoaClientCommunication) {
		String hql = "select count(*) from FlxoaClientCommunication where delete_flag = '0' ";
		return countByHql(hql,null);
	}
	
	@Override
	protected Class<FlxoaClientCommunication> getEntityClass() {
		return FlxoaClientCommunication.class;
	} 

}