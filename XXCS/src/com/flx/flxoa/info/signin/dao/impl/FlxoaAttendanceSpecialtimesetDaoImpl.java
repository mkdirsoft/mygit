package com.flx.flxoa.info.signin.dao.impl;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.flx.flxoa.info.signin.entity.FlxoaAttendanceSpecialtimeset;
import com.flx.flxoa.info.signin.dao.FlxoaAttendanceSpecialtimesetDao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import com.flx.flxoa.common.hibernate3.HibernateBaseDao;
import com.flx.flxoa.common.util.CommonUtils;
import com.flx.flxoa.common.util.DateUtils;

/**
 *
 * 类名称：FlxoaAttendanceSpecialtimesetDaoImpl.java
 * 类描述：
 * 创建时间：2018-03-26, 下午02:36:07
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 夏改翠 
 */ 
@Repository
public class FlxoaAttendanceSpecialtimesetDaoImpl extends HibernateBaseDao<FlxoaAttendanceSpecialtimeset, Integer> implements FlxoaAttendanceSpecialtimesetDao {
	/**
	 *添加FlxoaAttendanceSpecialtimeset
	 */ 
	public boolean add(FlxoaAttendanceSpecialtimeset flxoaAttendanceSpecialtimeset) {
		return save(flxoaAttendanceSpecialtimeset);
	}
	/**
	 *删除FlxoaAttendanceSpecialtimeset
	 */ 
	public boolean delete(FlxoaAttendanceSpecialtimeset flxoaAttendanceSpecialtimeset) {
		flxoaAttendanceSpecialtimeset.setDeleteFlag("1");
		return save(flxoaAttendanceSpecialtimeset);
	}
	/**
	 *修改FlxoaAttendanceSpecialtimeset
	 */ 
	public boolean update(FlxoaAttendanceSpecialtimeset flxoaAttendanceSpecialtimeset) {
		return modify(flxoaAttendanceSpecialtimeset);
	}
	/**
	 *查询FlxoaAttendanceSpecialtimeset列表
	 */ 
	public List<FlxoaAttendanceSpecialtimeset> query(FlxoaAttendanceSpecialtimeset flxoaAttendanceSpecialtimeset) {
		String hql = " from FlxoaAttendanceSpecialtimeset where delete_flag = '0' ";
		return getListByHQL(hql, null);
	}
	/**
	 * 分页查询
	 */
	public String querySpecialtimeset(Map<String,String> map){
		
		//将当天日期凌晨时间戳
		int currentDay = DateUtils.getMorningTimestamp();
		//更改有效，失效的flag
		//先查询
		String selhql = " from FlxoaAttendanceSpecialtimeset where special_end_date <'"+currentDay+"'and flag='0' and delete_flag = '0' ";
		List<FlxoaAttendanceSpecialtimeset>  speList = getListByHQL(selhql, null);
		if(speList.size()>0){
			//查询前先进行修改flag 的值
			String updateSql="UPDATE  flxoa_attendance_specialtimeset SET flag = '1 ' WHERE  special_end_date <'"+currentDay+"'";
			executeSql(updateSql);			
		}
		
		//查询hql语句
		String hql=" FROM (SELECT flxoa_attendance_specialtimeset.*,flxoa_system_user.real_name as details FROM flxoa_attendance_specialtimeset LEFT JOIN flxoa_system_user on flxoa_system_user.id =special_group_details where special_group='0' " +
				"UNION SELECT flxoa_attendance_specialtimeset.*,flxoa_system_department.name as details FROM flxoa_attendance_specialtimeset LEFT JOIN flxoa_system_department on flxoa_system_department.id = special_group_details WHERE special_group='1' " +
				" UNION SELECT 	flxoa_attendance_specialtimeset.*, A.enumeration_value as details FROM	flxoa_attendance_specialtimeset LEFT JOIN (	SELECT flxoa_system_enumeration.enumeration_key as enumeration_key,	flxoa_system_enumeration.enumeration_name as enumeration_name, " +
				" flxoa_system_enumeration.enumeration_value as enumeration_value FROM flxoa_system_enumeration	WHERE flxoa_system_enumeration.enumeration_name = 'gender'	AND delete_flag = '0') AS A ON A.enumeration_key = special_group_details WHERE special_group = '2' " +
				" ) as B  WHERE  b.delete_flag='0' " ;
		String flag = map.get("flag");
		String details = map.get("details");
		String startdate = map.get("startdate");
		String enddate = map.get("enddate");
		String endstartdate = map.get("endstartdate");
		String endenddate = map.get("endenddate");
		//String group = map.get("group");
		String id = map.get("id");
		int start=Integer.valueOf(map.get("start"));
		int length=Integer.valueOf(map.get("length"));
		String draw=map.get("draw");
		
		if(!CommonUtils.isEmpty(id)){
			hql += " and b.id = "+id+" ";
			
		}          
		if(!CommonUtils.isEmpty(flag)){
			hql += " and B.flag = '"+flag+"' ";
			
		}
		if(!CommonUtils.isEmpty(details)){
			hql += " and B.details like '%"+details+"%' ";
			
		}if(!CommonUtils.isEmpty(startdate) && CommonUtils.isEmpty(enddate)){			
			hql += " and b.special_start_date ='"+DateUtils.dateToTimestamp(startdate)+"' ";
		}if(!CommonUtils.isEmpty(startdate) && !CommonUtils.isEmpty(enddate)){
			hql += " and b.special_start_date >='"+DateUtils.dateToTimestamp(startdate)+"' and b.special_start_date <= '"+DateUtils.dateToTimestamp(enddate)+"' ";

		}if(!CommonUtils.isEmpty(endstartdate) && CommonUtils.isEmpty(endenddate)){			
			hql += " and b.special_end_date ='"+DateUtils.dateToTimestamp(endstartdate)+"' ";
		}if(!CommonUtils.isEmpty(endstartdate) && !CommonUtils.isEmpty(endenddate)){
			hql += " and b.special_end_date >='"+DateUtils.dateToTimestamp(endstartdate)+"' and b.special_end_date <= '"+DateUtils.dateToTimestamp(endenddate)+"' ";

		}/*if(!CommonUtils.isEmpty(group)){
			hql += " and b.special_group  = '"+group+"' ";
			
		}*/
		
		hql+=" ORDER BY b.create_time DESC ";
		//查询参数
		String querySql=" SELECT b.id ,b.special_start_date,b.special_end_date,b.gotoworktime,b.afterworktime,b.special_group,b.special_group_details,b.flag,b.details,b.delete_flag  "+hql;

		//求和查询sql
		String countSql="select count(*) "+hql;
		

		List list= queryListForPageBySQL(start, length, querySql);
		List<Map<String,String>> dataList=new ArrayList<Map<String,String>>();
		List<Map<String,String>> otherDataList=new ArrayList<Map<String,String>>();
		for(int i=0;i<list.size();i++){
			Map<String,String> dataMap=new HashMap<String,String>();			
			Object[] obj=(Object[]) list.get(i);			
			dataMap.put("id", String.valueOf(obj[0]));
			dataMap.put("start_date", String.valueOf(obj[1]));
			dataMap.put("end_date", String.valueOf(obj[2]));
			dataMap.put("gotoworktime", String.valueOf(obj[3]));
			dataMap.put("afterworktime", String.valueOf(obj[4]));
			dataMap.put("special_group", String.valueOf(obj[5]));
			dataMap.put("group_details", String.valueOf(obj[6]));
			dataMap.put("flag", String.valueOf(obj[7]));
			dataMap.put("details", String.valueOf(obj[8]));
			dataMap.put("delete_flag", String.valueOf(obj[9]));
			dataList.add(dataMap);
		}		
		Long totalCount= countBySql(countSql,null);
		Map<String,String> otherDataMap=new HashMap<String,String>();
		return CommonUtils.getPageJson(start, length,draw,totalCount,dataList,otherDataList);
		
	}
	/**
	 *查询FlxoaAttendanceSpecialtimeset ByID
	 */ 
	public FlxoaAttendanceSpecialtimeset queryById(FlxoaAttendanceSpecialtimeset flxoaAttendanceSpecialtimeset) {
		return get(flxoaAttendanceSpecialtimeset.getId());
	}
	/**
	 *分页FlxoaAttendanceSpecialtimeset pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<FlxoaAttendanceSpecialtimeset> queryForPage(int pageNo,int pageSize,FlxoaAttendanceSpecialtimeset flxoaAttendanceSpecialtimeset) {
		String hql = " from FlxoaAttendanceSpecialtimeset where delete_flag = '0' ";
		return queryForPageByHQL(pageNo, pageSize, hql);
	}
	/**
	 *查询FlxoaAttendanceSpecialtimeset数据条数 
	 */ 
	public Long queryCount(FlxoaAttendanceSpecialtimeset flxoaAttendanceSpecialtimeset) {
		String hql = "select count(*) from FlxoaAttendanceSpecialtimeset where delete_flag = '0' ";
		return countByHql(hql,null);
	}
	
	@Override
	protected Class<FlxoaAttendanceSpecialtimeset> getEntityClass() {
		return FlxoaAttendanceSpecialtimeset.class;
	}
	/**
	 * 查询FlxoaAttendanceSpecialtimeset 包括今天的特殊时间
	 */
	
	public List<FlxoaAttendanceSpecialtimeset> queryToday(int date,	List<String> statusList,List<String> detailsList) {
		String hql=" from FlxoaAttendanceSpecialtimeset where delete_flag = '0'  ";		
		hql+=" and (";
		for(int i=0;i<statusList.size();i++){
			hql += " (special_start_date <= "+date+"  and  special_end_date >="+date+"  and special_group ='"+statusList.get(i)+"'  and special_group_details = '"+detailsList.get(i)+"' ) or";
		}
		hql = hql.substring(0,hql.length()-2);
		hql+= " )";
		return getListByHQL(hql,null);
	} 

	
}