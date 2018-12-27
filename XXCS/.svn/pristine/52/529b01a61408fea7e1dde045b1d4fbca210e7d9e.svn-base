package com.flx.flxoa.info.conference.dao.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.flx.flxoa.info.conference.dao.FlxoaConferenceInformationDao;
import com.flx.flxoa.info.conference.entity.FlxoaConferenceInformation;
import org.springframework.stereotype.Repository;
import com.flx.flxoa.common.hibernate3.HibernateBaseDao;
import com.flx.flxoa.common.util.CommonUtils;

/**
 *
 * 类名称：FlxoaConferenceInformationDaoImpl.java
 * 类描述：
 * 创建时间：2018-09-04, 下午04:58:03
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 雷君 
 */ 
@Repository
public class FlxoaConferenceInformationDaoImpl extends HibernateBaseDao<FlxoaConferenceInformation, Integer> implements FlxoaConferenceInformationDao {
	/**
	 *添加FlxoaConferenceInformation
	 */ 
	public boolean add(FlxoaConferenceInformation flxoaConferenceInformation) {
		return save(flxoaConferenceInformation);
	}
	/**
	 *删除FlxoaConferenceInformation
	 */ 
	public boolean delete(FlxoaConferenceInformation flxoaConferenceInformation) {
		flxoaConferenceInformation.setDeleteFlag("1");
		return save(flxoaConferenceInformation);
	}
	/**
	 *修改FlxoaConferenceInformation
	 */ 
	public boolean update(FlxoaConferenceInformation flxoaConferenceInformation) {
		return modify(flxoaConferenceInformation);
	}
	/**
	 *修改FlxoaConferenceInformation
	 */ 
	public boolean updateFree() {
		String hql = "UPDATE flxoa_conference_information set conference_states = '0' WHERE conference_states != '0'";
		executeSql(hql,null);
		return true;
	}
	/**
	 *查询FlxoaConferenceInformation列表
	 */ 
	public List<FlxoaConferenceInformation> query(FlxoaConferenceInformation flxoaConferenceInformation) {
		String hql = " from FlxoaConferenceInformation where unix_timestamp(now()) between conference_start_time and conference_end_time ";
		System.out.println("hql==="+hql);
		return getListByHQL(hql, null);
	}
	/**
	 *查询FlxoaConferenceInformation ByID
	 */ 
	public FlxoaConferenceInformation queryById(FlxoaConferenceInformation flxoaConferenceInformation) {
		return get(flxoaConferenceInformation.getId());
	}
	/**
	 *分页FlxoaConferenceInformation pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public String queryForPage(int start,int length,String draw,int userId,String deptIds,FlxoaConferenceInformation flxoaConferenceInformation) {
		String sql="from "
				+ "flxoa_conference_information c "
				+ "left join"
				+ "( "
				+ "select "
				+ "e.enumeration_value , "
				+ "e.enumeration_key "
				+ "from flxoa_system_enumeration e "
				+ "where "
				+ "enumeration_name = 'conference_states'"
				+ ") "
				+ "conference_states on c.conference_states = conference_states.enumeration_key "
				+ "left join "
				+ "flxoa_system_user u on u.id = c.create_user_id "
				+ "where c.delete_flag = '0' ";
		
		//查询条件
		if(!CommonUtils.isEmpty(flxoaConferenceInformation.getConferenceNumber()) ){
			sql += "and c.conference_number like '%"+flxoaConferenceInformation.getConferenceNumber()+"%'"; 
		}
		if(!CommonUtils.isEmpty(flxoaConferenceInformation.getConferenceName()) ){
			sql += "and c.conference_name like '%"+flxoaConferenceInformation.getConferenceName()+"%'"; 
		}
		if(!CommonUtils.isEmpty(flxoaConferenceInformation.getConferenceFloor()) ){
			sql += "and c.conference_floor like '%"+flxoaConferenceInformation.getConferenceFloor()+"%'"; 
		}
		if(!CommonUtils.isEmpty(flxoaConferenceInformation.getConferenceStates()) ){
			sql += "and c.conference_states like '%"+flxoaConferenceInformation.getConferenceStates()+"%'"; 
		}

		
		String querySql = " select "
				+ "c.id , "
				+ "c.conference_number , "
				+ "c.conference_name , "
				+ "c.conference_floor , "
				+ "c.conference_scale , "
				+ "c.conference_configure , "
				+ "c.conference_remarks , "
				+ "c.conference_states , "
				+ "u.user_name , "
				+ "u.real_name , "
				+ "conference_states.enumeration_value "+sql;
		
		System.out.println("项目查询sql:----"+querySql);
		String countSql="select count(*) "+sql;
		List list= queryListForPageBySQL(start, length, querySql);
		List<Map<String,String>> dataList=new ArrayList<Map<String,String>>();
		List<Map<String,String>> otherDataList=new ArrayList<Map<String,String>>();
		for (int i = 0; i < list.size(); i++) {
			Map<String,String> dataMap=new HashMap<String,String>();
			Object[] obj = (Object[])list.get(i);
				dataMap.put("id", String.valueOf(obj[0]));
				dataMap.put("conferenceNumber", String.valueOf(obj[1]));
				dataMap.put("conferenceName", String.valueOf(obj[2]));
				dataMap.put("conferenceFloor", String.valueOf(obj[3]));
				dataMap.put("conferenceScale", String.valueOf(obj[4]));
				dataMap.put("conferenceConfigure", String.valueOf(obj[5]));
				dataMap.put("conferenceRemarks", String.valueOf(obj[6]));
				dataMap.put("enumerationValue", String.valueOf(obj[7]));
				dataMap.put("userName", String.valueOf(obj[8]));
				dataMap.put("conferenceStates", String.valueOf(obj[9]));
				dataMap.put("enumerationValue", String.valueOf(obj[10]));
				dataList.add(dataMap);
		}
		Long totalCount= countBySql(countSql,null);
		return CommonUtils.getPageJson(start, length,draw,totalCount,dataList,otherDataList);
	}
	/**
	 *查询FlxoaConferenceInformation数据条数 
	 */ 
	public Long queryCount(FlxoaConferenceInformation flxoaConferenceInformation) {
		String hql = "select count(*) from FlxoaConferenceInformation where delete_flag = '0' ";
		return countByHql(hql,null);
	}
	
	@Override
	protected Class<FlxoaConferenceInformation> getEntityClass() {
		return FlxoaConferenceInformation.class;
	} 

}