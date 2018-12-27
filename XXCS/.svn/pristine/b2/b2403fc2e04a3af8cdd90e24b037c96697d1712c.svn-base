package com.flx.flxoa.info.clientsManagement.dao.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.flx.flxoa.info.clientsManagement.entity.FlxoaClientContact;
import com.flx.flxoa.info.clientsManagement.dao.FlxoaClientContactDao;
import org.springframework.stereotype.Repository;
import com.flx.flxoa.common.hibernate3.HibernateBaseDao;
import com.flx.flxoa.common.util.CommonUtils;

/**
 *
 * 类名称：FlxoaClientContactDaoImpl.java
 * 类描述：
 * 创建时间：2018-09-05, 下午03:19:41
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 孙进 
 */ 
@Repository
public class FlxoaClientContactDaoImpl extends HibernateBaseDao<FlxoaClientContact, Integer> implements FlxoaClientContactDao {
	/**
	 *添加FlxoaClientContact
	 */ 
	public boolean add(FlxoaClientContact flxoaClientContact) {
		return save(flxoaClientContact);
	}
	/**
	 *删除FlxoaClientContact
	 */ 
	public boolean delete(FlxoaClientContact flxoaClientContact) {
		flxoaClientContact.setDeleteFlag("1");
		return save(flxoaClientContact);
	}
	/**
	 *修改FlxoaClientContact
	 */ 
	public boolean update(FlxoaClientContact flxoaClientContact) {
		return modify(flxoaClientContact);
	}
	/**
	 *查询FlxoaClientContact列表
	 */ 
	public List<FlxoaClientContact> query(FlxoaClientContact flxoaClientContact) {
		String hql = " from FlxoaClientContact where delete_flag = '0' ";
		return getListByHQL(hql, null);
	}
	/**
	 *查询FlxoaClientContact ByID
	 */ 
	public FlxoaClientContact queryById(FlxoaClientContact flxoaClientContact) {
		return get(flxoaClientContact.getId());
	}
	/**
	 *分页FlxoaClientContact pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public String queryForPage(Map<String,String> map) {
		String hql="SELECT ConInfo.id, " +
				"Cinfo.client_name," +
				"ConInfo.contact_name," +
				"ConInfo.contact_gender, " +
				"ConInfo.contact_duty, " +
				"ConInfo.contact_phone, " +
				"ConInfo.contact_mail, " +
				"ConInfo.delete_flag, " +
				"ConInfo.create_user_id, " +
				"ConInfo.create_department_id, " +
				"ConInfo.create_time," +
				"ConInfo.update_user_id," +
				"ConInfo.update_department_id," +
				"ConInfo.update_time " +
				"FROM flxoa_client_contact ConInfo " +
				"LEFT JOIN flxoa_client_information Cinfo ON ConInfo.client_id = Cinfo.id " +
				"LEFT JOIN (" +
				"SELECT" +
				" enumeration_name," +
				" enumeration_key," +
				" enumeration_value " +
				"FROM flxoa_system_enumeration " +
				"WHERE enumeration_name = 'gender' AND delete_flag = '0') " +
				"Cgender ON ConInfo.contact_gender = Cgender.enumeration_key " +
				"WHERE ConInfo.delete_flag = '0' ";
		
		String orderSql=" group by ConInfo.id ORDER BY ConInfo.id ASC";
		/*获取查询参数*/
		String start=map.get("start");
		String length=map.get("length");
		String draw=map.get("draw");
		String clientId=map.get("client_id");
		String clientName=map.get("client_name");
		String contactName=map.get("contact_name");
		String contactPhone=map.get("contact_phone");
		if(!CommonUtils.isEmpty(clientId)){
			hql+=" and ConInfo.client_id="+clientId;
		}
		if(!CommonUtils.isEmpty(clientName)){
			hql+=" and Cinfo.client_name like '%"+clientName+"%' ";
		}
		if(!CommonUtils.isEmpty(contactName)){
			hql+=" and ConInfo.contact_name like '%"+contactName+"%' ";
		}
		if(!CommonUtils.isEmpty(contactPhone)){
			hql+="and ConInfo.contact_phone like '%"+contactPhone+"%'";
		}
		hql+=orderSql;
		System.out.println("联系人查询sql:====="+hql);
		/*计算数据总数*/
		String countSql="select count(*) from ("+hql+") as countTable";
		Long totalCount= countBySql(countSql,null);
		
		/*数据分页查询*/
		List list=queryListForPageBySQL(Integer.parseInt(start),Integer.parseInt(length),hql);
		List<Map<String,String>> dataList=new ArrayList<Map<String,String>>();
		for(int i=0;i<list.size();i++){
			Map<String,String> dataMap=new HashMap<String,String>();
			Object[] obj=(Object[]) list.get(i);
			dataMap.put("id", String.valueOf(obj[0]));
			dataMap.put("client_name", String.valueOf(obj[1]));
			dataMap.put("contact_name", String.valueOf(obj[2]));
			dataMap.put("contact_gender", String.valueOf(obj[3]));
			dataMap.put("contact_duty", String.valueOf(obj[4]));
			dataMap.put("contact_phone", String.valueOf(obj[5]));
			dataMap.put("contact_mail", String.valueOf(obj[6]));
			dataMap.put("delete_flag", String.valueOf(obj[7]));
			dataMap.put("create_user_id", String.valueOf(obj[8]));
			dataMap.put("create_department_id", String.valueOf(obj[9]));
			dataMap.put("create_time", String.valueOf(obj[10]));
			dataMap.put("update_user_id", String.valueOf(obj[11]));
			dataMap.put("update_department_id", String.valueOf(obj[12]));
			dataMap.put("update_time", String.valueOf(obj[13]));
			dataList.add(dataMap);
		}
		return CommonUtils.getPageJson(Integer.parseInt(start), Integer.parseInt(length), draw, totalCount, dataList, null);
	}
	/**
	 *查询FlxoaClientContact数据条数 
	 */ 
	public Long queryCount(FlxoaClientContact flxoaClientContact) {
		String hql = "select count(*) from FlxoaClientContact where delete_flag = '0' ";
		return countByHql(hql,null);
	}
	
	@Override
	protected Class<FlxoaClientContact> getEntityClass() {
		return FlxoaClientContact.class;
	} 

}