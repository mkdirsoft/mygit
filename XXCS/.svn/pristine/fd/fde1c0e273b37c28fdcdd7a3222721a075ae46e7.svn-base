package com.flx.flxoa.info.conference.dao.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.flx.flxoa.info.conference.dao.FlxoaConferenceHistoryDao;
import com.flx.flxoa.info.conference.entity.FlxoaConferenceHistory;
import com.flx.flxoa.info.conference.entity.FlxoaConferenceInformation;

import org.springframework.stereotype.Repository;
import com.flx.flxoa.common.hibernate3.HibernateBaseDao;
import com.flx.flxoa.common.util.CommonUtils;

/**
 *
 * 类名称：FlxoaConferenceHistoryDaoImpl.java
 * 类描述：
 * 创建时间：2018-09-04, 下午04:58:03
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 雷君 
 */ 
@Repository
public class FlxoaConferenceHistoryDaoImpl extends HibernateBaseDao<FlxoaConferenceHistory, Integer> implements FlxoaConferenceHistoryDao {
	/**
	 *添加FlxoaConferenceHistory
	 */ 
	public boolean add(FlxoaConferenceHistory flxoaConferenceHistory) {
		return save(flxoaConferenceHistory);
	}
	/**
	 *删除FlxoaConferenceHistory
	 */ 
	public boolean delete(FlxoaConferenceHistory flxoaConferenceHistory) {
		flxoaConferenceHistory.setDeleteFlag("1");
		return save(flxoaConferenceHistory);
	}
	/**
	 *修改FlxoaConferenceHistory
	 */ 
	public boolean update(FlxoaConferenceHistory flxoaConferenceHistory) {
		return modify(flxoaConferenceHistory);
	}
	/**
	 *查询FlxoaConferenceInformation列表
	 */ 
	public List<FlxoaConferenceHistory> queryHistory(FlxoaConferenceHistory flxoaConferenceHistory) {
		String hql = "SELECT "
				+ "h.id , "
				+ "h.conference_id , "
				+ "h.conference_number ,  "
				+ "h.conference_start_time , "
				+ "h.conference_end_time , "
				+ "h.is_cancel "
				+ "FROM flxoa_conference_history h" 
				+ " where unix_timestamp(now()) between conference_start_time and conference_end_time ";
		System.out.println("hql==="+hql);
		List list = getListBySQL(hql);
		System.out.println(list);
		List<FlxoaConferenceHistory> formList = new ArrayList<FlxoaConferenceHistory>();
		for (int i = 0; i < list.size(); i++) {
			FlxoaConferenceHistory form = new FlxoaConferenceHistory();
			Object[] objects = (Object[])list.get(i);
			form.setId((Integer)objects[0]);
			form.setConferenceId(String.valueOf(objects[1]));
			form.setConferenceNumber(String.valueOf(objects[2]));
			form.setConferenceStartTime((Integer)(objects[3]));
			form.setConferenceEndTime((Integer)(objects[4]));
			form.setIsCancel(String.valueOf(objects[5]));
			formList.add(form);
		}
		return formList;
	}
	/**
	 *查询FlxoaConferenceInformation列表
	 */ 
	public List<FlxoaConferenceHistory> queryHistoryFree(FlxoaConferenceHistory flxoaConferenceHistory) {
		String hql = "SELECT "
				+ "h.id , "
				+ "h.conference_id , "
				+ "h.conference_number ,  "
				+ "h.conference_start_time , "
				+ "h.conference_end_time , "
				+ "h.is_cancel  "
				+ "FROM flxoa_conference_history h" 
				+ " where unix_timestamp(now()) < conference_end_time ";
		System.out.println("hql==="+hql);
		List list = getListBySQL(hql);
		System.out.println(list);
		List<FlxoaConferenceHistory> formList = new ArrayList<FlxoaConferenceHistory>();
		for (int i = 0; i < list.size(); i++) {
			FlxoaConferenceHistory form = new FlxoaConferenceHistory();
			Object[] objects = (Object[])list.get(i);
			form.setId((Integer)objects[0]);
			form.setConferenceId(String.valueOf(objects[1]));
			form.setConferenceNumber(String.valueOf(objects[2]));
			form.setConferenceStartTime((Integer)(objects[3]));
			form.setConferenceEndTime((Integer)(objects[4]));
			form.setIsCancel(String.valueOf(objects[5]));
			formList.add(form);
		}
		return formList;
	}
	/**
	 *查询FlxoaConferenceHistory列表
	 */ 
	public List<FlxoaConferenceHistory> query(FlxoaConferenceHistory flxoaConferenceHistory) {
		String sql = " select "
				+ "h.id , "
				+ "h.conference_id , "
				+ "h.application_time , "
				+ "h.reservations_people , "
				+ "h.reservations_purpose , "
				+ "h.conference_start_time , "
				+ "h.conference_end_time , "
				+ "h.is_cancel , "
				+ "h.conference_number , "
				+ "reservations_type.enumeration_value "
				+ "from "
				+ "flxoa_conference_history h "
				+ "left join"
				+ "( "
				+ "select "
				+ "e.enumeration_value , "
				+ "e.enumeration_key "
				+ "from "
				+ "flxoa_system_enumeration e "
				+ "where "
				+ "enumeration_name = 'reservations_type'"
				+ ") "
				+ " reservations_type on h.reservations_type = reservations_type.enumeration_key ";
			sql += "where "
				+ "h.create_user_id = "+flxoaConferenceHistory.getCreateUserId()+" "
				+ "and  h.conference_number = '0' "
				+ "and h.conference_id = "+flxoaConferenceHistory.getConferenceId()+" "
				+ "and unix_timestamp(now()) < conference_end_time "
				+ "and  h.delete_flag = '0'";
			
			
			if(!"100000".equals(String.valueOf(flxoaConferenceHistory.getId( )))){
				sql += "and flxoa_conference_history.id = '"+Integer.valueOf(flxoaConferenceHistory.getId())+"'";
			}
			List list = getListBySQL(sql);
			System.out.println(list);
			List<FlxoaConferenceHistory> formList = new ArrayList<FlxoaConferenceHistory>();
			for (int i = 0; i < list.size(); i++) {
				FlxoaConferenceHistory form = new FlxoaConferenceHistory();
				Object[] objects = (Object[])list.get(i);
				form.setId((Integer)objects[0]);
				form.setConferenceId(String.valueOf(objects[1]));
				form.setApplicationTime((Integer)(objects[2]));
				form.setReservationsPeople(String.valueOf(objects[3]));
				form.setReservationsPurpose(String.valueOf(objects[4]));
				form.setConferenceStartTime((Integer)(objects[5]));
				form.setConferenceEndTime((Integer)(objects[6]));
				form.setIsCancel(String.valueOf(objects[7]));
				form.setConferenceNumber(String.valueOf(objects[8]));
				form.setConferenceType(String.valueOf(objects[9]));
				formList.add(form);
			}
			return formList;
	}
	/**
	 *查询FlxoaConferenceHistory ByID
	 */ 
	public FlxoaConferenceHistory queryById(FlxoaConferenceHistory flxoaConferenceHistory) {
		return get(flxoaConferenceHistory.getId());
	}
	/**
	 *分页FlxoaConferenceHistory pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public String queryForPage(int start,int length,String draw,int userId,String deptIds,FlxoaConferenceHistory flxoaConferenceHistory) {
		String sql=" from  "
				+ "flxoa_conference_history c "
				+ "left join "
				+ "( "
				+ "select "
				+ "e.enumeration_value , "
				+ "e.enumeration_key "
				+ "from "
				+ "flxoa_system_enumeration e "
				+ "where "
				+ "enumeration_name = 'reservations_type'"
				+ ") "
				+ "reservations_type on c.reservations_type = reservations_type.enumeration_key "
				+ "left join "
				+ "flxoa_conference_information i on i.id = c.conference_id "
				+ "left join "
				+ "flxoa_system_user u on u.id = c.create_user_id "
				+ "where c.delete_flag =  '0' ";
				
		//查询条件:
		//预约人
		if(!CommonUtils.isEmpty(flxoaConferenceHistory.getReservationsPeople()) ){
			sql += "and c.reservations_people like '%"+flxoaConferenceHistory.getReservationsPeople()+"%'"; 
		}
		
		if(!CommonUtils.isEmpty(flxoaConferenceHistory.getEnumerationValue()) ){
			sql += "and c.reservations_type = '"+flxoaConferenceHistory.getEnumerationValue()+"'"; 
		}
		if(!CommonUtils.isEmpty(flxoaConferenceHistory.getUserName()) ){
			sql += "and u.user_name like '%"+flxoaConferenceHistory.getUserName()+"%'"; 
		}
		if(!CommonUtils.isEmpty(flxoaConferenceHistory.getConferenceHistoryNumber()) ){
			sql += "and i.conference_number like '%"+flxoaConferenceHistory.getConferenceHistoryNumber()+"%'"; 
		}
		sql += "ORDER BY  " +
			   "c.create_time DESC ";
		
		String querySql = "select "
				+ "c.id , "
				+ "c.conference_number , "
				+ "c.application_time , "
				+ "c.reservations_people , "
				+ "c.reservations_purpose , "
				+ "c.conference_start_time , "
				+ "c.conference_end_time , "
				+ "c.create_time , "
				+ "c.is_cancel , "
				+ "i.conference_number conference_History_number, "
				+ "u.user_name , "
				+ "u.phone , "
				+ "reservations_type.enumeration_value"+sql;
		
		System.out.println("会议室历史信息查询sql:----"+querySql);
		String countSql="select count(*) "+sql;
		List list= queryListForPageBySQL(start, length, querySql);
		List<Map<String,String>> dataList=new ArrayList<Map<String,String>>();
		List<Map<String,String>> otherDataList=new ArrayList<Map<String,String>>();
		for (int i = 0; i < list.size(); i++) {
			Map<String,String> dataMap=new HashMap<String,String>();
			Object[] obj = (Object[])list.get(i);
				dataMap.put("id", String.valueOf(obj[0]));
				dataMap.put("conferenceNumber", String.valueOf(obj[1]));
				dataMap.put("applicationTime", String.valueOf(obj[2]));
				dataMap.put("reservationsPeople", String.valueOf(obj[3]));
				dataMap.put("reservationsPurpose", String.valueOf(obj[4]));
				dataMap.put("conferenceStartTime", String.valueOf(obj[5]));
				dataMap.put("conferenceEndTime", String.valueOf(obj[6]));
				dataMap.put("createTime", String.valueOf(obj[7]));
				dataMap.put("isCancel", String.valueOf(obj[8]));
				dataMap.put("conferenceHistoryNumber", String.valueOf(obj[9]));
				dataMap.put("userName", String.valueOf(obj[10]));
				dataMap.put("phone", String.valueOf(obj[11]));
				dataMap.put("enumerationValue", String.valueOf(obj[12]));
				dataList.add(dataMap);
		}
		Long totalCount= countBySql(countSql,null);
		return CommonUtils.getPageJson(start, length,draw,totalCount,dataList,otherDataList);
	
	}
	/**
	 *查询FlxoaConferenceHistory数据条数 
	 */ 
	public Long queryCount(FlxoaConferenceHistory flxoaConferenceHistory) {
		String hql = "select count(*) from FlxoaConferenceHistory where delete_flag = '0' ";
		return countByHql(hql,null);
	}
	
	@Override
	protected Class<FlxoaConferenceHistory> getEntityClass() {
		return FlxoaConferenceHistory.class;
	} 
	/**
	 * 会议室预约时-时间判断不能同时间段进行预约
	 */
	@Override
	public boolean isExist(int startTime,int endTime,String conferenceId) {
		String sql="select "
				+ "* "
				+ "from "
				+ "flxoa_conference_history "
				+ "where "
				+ "(conference_start_time > "+startTime+" and conference_end_time < "+endTime+") "
				+ "or "
				+ "(conference_start_time = "+startTime+" and conference_end_time > "+endTime+") "
				+ "or "
				+ "(conference_end_time >"+startTime+" and conference_end_time < "+endTime+") "
				+ "or "
				+ "(conference_start_time = "+startTime+"  and conference_end_time = "+endTime+" ) "
				+ "or "
				+ "(conference_start_time < "+startTime+"  and conference_end_time > "+endTime+" ) "
				+ "or "
				+ "(conference_start_time > "+startTime+"  and conference_end_time < "+endTime+" ) "
				+ "or "
				+ "(conference_end_time > "+startTime+"  and conference_end_time < "+endTime+" ) "
				+ "and conference_id = "+conferenceId+" "
				+ "and delete_flag = '0'";
		List list=getListBySQL(sql);
		if(list.size()<1){
			return true;
		}
		return false;
	} 
}