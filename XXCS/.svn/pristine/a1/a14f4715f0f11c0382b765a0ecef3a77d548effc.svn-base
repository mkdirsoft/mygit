package com.flx.flxoa.info.projectmanagement.dao.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.flx.flxoa.info.projectmanagement.entity.FlxoaProjectBidInformation;
import com.flx.flxoa.info.projectmanagement.entity.FlxoaProjectInformation;
import com.flx.flxoa.info.projectmanagement.dao.FlxoaProjectBidInformationDao;
import com.flx.flxoa.info.system.entity.FlxoaSystemUserRole;

import org.springframework.stereotype.Repository;
import com.flx.flxoa.common.hibernate3.HibernateBaseDao;
import com.flx.flxoa.common.util.CommonUtils;

/**
 *
 * 类名称：FlxoaProjectBidInformationDaoImpl.java
 * 类描述：
 * 创建时间：2018-03-21, 下午07:11:37
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 雷君 
 */ 
@Repository
public class FlxoaProjectBidInformationDaoImpl extends HibernateBaseDao<FlxoaProjectBidInformation, Integer> implements FlxoaProjectBidInformationDao {
	/**
	 *添加FlxoaProjectBidInformation
	 */ 
	public boolean add(FlxoaProjectBidInformation flxoaProjectBidInformation) {
		return save(flxoaProjectBidInformation);
	}
	/**
	 *删除FlxoaProjectBidInformation
	 */ 
	public boolean delete(FlxoaProjectBidInformation flxoaProjectBidInformation) {
		flxoaProjectBidInformation.setDeleteFlag("1");
		return save(flxoaProjectBidInformation);
	}
	/**
	 *修改FlxoaProjectBidInformation
	 */ 
	public boolean update(FlxoaProjectBidInformation flxoaProjectBidInformation) {
		return modify(flxoaProjectBidInformation);
	}
	/**
	 *查询FlxoaProjectBidInformation列表
	 */ 
	public List<FlxoaProjectBidInformation> query(FlxoaProjectBidInformation flxoaProjectBidInformation) {
		String hql = " from FlxoaProjectBidInformation where delete_flag = '0' ";
		return getListByHQL(hql, null);
	}
	/**
	 *查询FlxoaProjectBidInformation ByID
	 */ 
	public FlxoaProjectBidInformation queryById(FlxoaProjectBidInformation flxoaProjectBidInformation) {
		return get(flxoaProjectBidInformation.getId());
	}
	
	/**
	 *按属性查询FlxoaProjectBidInformation queryByEntity
	 */ 
	public FlxoaProjectBidInformation queryByEntity(FlxoaProjectBidInformation flxoaProjectBidInformation) {
		String hql = "from FlxoaProjectBidInformation where delete_flag = '0'";
		if(null != flxoaProjectBidInformation.getProjectId()){
			hql += " and project_id = "+flxoaProjectBidInformation.getProjectId();
		}
		System.out.println(hql);
		List<FlxoaProjectBidInformation> list = getListByHQL(hql);
		if(null != null && list.size() > 0){
			
			return list.get(0);
		}else{
			return new FlxoaProjectBidInformation();
		}
	} 	
	/**
	 *分页FlxoaProjectBidInformation pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public String queryForPage(int pageNo,int pageSize,String draw,int userId, String deptIds,FlxoaProjectBidInformation flxoaProjectBidInformation) {
		String sql = "from "
				+ "flxoa_project_bid_information "
				+ "left join "
				+ "flxoa_project_information on flxoa_project_bid_information.project_id = flxoa_project_information.id "
				+ "left join "
				+ "flxoa_system_user on flxoa_project_bid_information.follower_id = flxoa_system_user.id "
				+ "left join"
				+ "( select "
				+ "flxoa_system_enumeration.enumeration_key , "
				+ "flxoa_system_enumeration.enumeration_value "
				+ "from "
				+ "flxoa_system_enumeration "
				+ "where "
				+ "enumeration_name = 'bidding_results'"
				+ ") "
				+ "bidding_results on flxoa_project_bid_information.bidding_results = bidding_results.enumeration_key "
				+ "left join"
				+ "( select "
				+ "flxoa_system_enumeration.enumeration_key, "
				+ "flxoa_system_enumeration.enumeration_value "
				+ "from "
				+ "flxoa_system_enumeration "
				+ "where"
				+ " enumeration_name = 'project_bidding_status'"
				+ ") "
				+ "project_bidding_status on flxoa_project_bid_information.project_bidding_status = project_bidding_status.enumeration_key "
				+ "left join"
				+ "( select "
				+ "flxoa_system_enumeration.enumeration_key, "
				+ "flxoa_system_enumeration.enumeration_value "
				+ "from "
				+ "flxoa_system_enumeration "
				+ "where "
				+ "enumeration_name = 'bid_schedule'"
				+ ") "
				+ "bid_schedule on flxoa_project_bid_information.bid_schedule = bid_schedule.enumeration_key " ;
			sql +="  where flxoa_project_bid_information.delete_flag = '0'";
			
			System.out.println("查询条件中的部门id字符串：==="+deptIds);
			String deptIds01=deptIds.replaceAll(",", "|");
			System.out.println("重新修改后的部门id列表：===="+deptIds01);
		if(deptIds.length() > 1) {
			sql += "  and  flxoa_project_bid_information.create_department_id REGEXP '["+deptIds+"]' ";
		}else {
			sql += "  and  flxoa_project_bid_information.update_user_id = ("+userId+")  ";
		}
		if(!CommonUtils.isEmpty(flxoaProjectBidInformation.getStartTime()) && CommonUtils.isEmpty(flxoaProjectBidInformation.getEndTime())) {
			int  dey = Integer.valueOf(flxoaProjectBidInformation.getStartTime()) + 86400;
			sql+=" and flxoa_project_bid_information.bidding_date >= '"+flxoaProjectBidInformation.getStartTime()+"' ";
			sql+=" and flxoa_project_bid_information.bidding_date < '"+dey+"'";
		}
		if(!CommonUtils.isEmpty(flxoaProjectBidInformation.getStartTime()) && !CommonUtils.isEmpty(flxoaProjectBidInformation.getEndTime())){
			sql+=" and flxoa_project_bid_information.bidding_date Between ";
			sql+=flxoaProjectBidInformation.getStartTime();
			sql+=" and ";
			sql+=flxoaProjectBidInformation.getEndTime();
		}
		if(flxoaProjectBidInformation.getBiddingDirector() != null &&  !"".equals(flxoaProjectBidInformation.getBiddingDirector()) ) {
			sql +=" and  bidding_director like '%"+flxoaProjectBidInformation.getBiddingDirector()+"%'";
		}
		if(flxoaProjectBidInformation.getRealname() != null && !"".equals(flxoaProjectBidInformation.getRealname())) {
			sql +=" and flxoa_system_user.real_name like '%"+flxoaProjectBidInformation.getRealname()+"%'";
		}
		if(flxoaProjectBidInformation.getProjName() != null && !"".equals(flxoaProjectBidInformation.getProjName())) {
			sql += " and flxoa_project_information.proj_name like '%"+flxoaProjectBidInformation.getProjName()+"%'";
		}
		if(flxoaProjectBidInformation.getProjNumber() != null && !"".equals(flxoaProjectBidInformation.getProjNumber())) {
			sql += " and flxoa_project_information.proj_number like '%"+flxoaProjectBidInformation.getProjNumber()+"%'";
		}
		if(flxoaProjectBidInformation.getBidding_results_type() != null && !"".equals(flxoaProjectBidInformation.getBidding_results_type())) {
			sql += " and flxoa_project_bid_information.bidding_results = "+flxoaProjectBidInformation.getBidding_results_type()+"";
		}
		if(flxoaProjectBidInformation.getBid_schedule_type() != null && !"".equals(flxoaProjectBidInformation.getBid_schedule_type())) {
			sql += " and flxoa_project_bid_information.bid_schedule = "+flxoaProjectBidInformation.getBid_schedule_type()+"";
		}
		if(flxoaProjectBidInformation.getProject_bidding_status_type() != null && !"".equals(flxoaProjectBidInformation.getProject_bidding_status_type())) {
			sql += " and flxoa_project_bid_information.project_bidding_status = "+flxoaProjectBidInformation.getProject_bidding_status_type()+"";
		}
		
			sql += " ORDER BY flxoa_project_bid_information.id DESC";
		String querysql = "select "
				+ "flxoa_project_bid_information.id, "
				+ "flxoa_project_information.proj_name, "
				+ "flxoa_project_information.predict_contract_money, "
				+ "flxoa_project_bid_information.bidding_director, "
				+ "flxoa_project_bid_information.bidding_date, "
				+ "flxoa_project_bid_information.follower_id, "
				+ "bidding_results.enumeration_value bidding_results_type, "
				+ "project_bidding_status.enumeration_value project_bidding_status_type, "
				+ "bid_schedule.enumeration_value bid_schedule_type, "
				+ "flxoa_project_information.create_department_id, "
				+ "flxoa_project_information.create_user_id, "
				+ "flxoa_system_user.real_name realname, "
				+ "flxoa_project_information.proj_number, "
				+ "flxoa_project_bid_information.project_bidding_status, "
				+ "flxoa_project_bid_information.bid_schedule,"
				+ "flxoa_project_bid_information.bidding_results, "
				+ "flxoa_project_bid_information.project_id  "+sql;
		System.out.println("投标数据查询sql=========="+querysql);
		List list = queryListForPageBySQL(pageNo, pageSize, querysql);
		//Long totalCount=queryCount(flxoaProjectBidInformation);//获取数据总数，用于分页
		String countSql="select count(*) "+sql;
		Long totalCount= countBySql(countSql,null);
		List<Map<String,String>> formList = new ArrayList<Map<String,String>>();
		for (int i = 0; i < list.size(); i++) {
			Map<String,String> form = new HashMap<String,String>();
			Object[] objects = (Object[])list.get(i);
			/*form.setId((Integer)objects[0]);
			form.setProjName(String.valueOf(objects[1]));
			form.setPredictContractMoney(String.valueOf(objects[2]));
			form.setBiddingDirector(String.valueOf(objects[3]));
			form.setBiddingDate((Integer)objects[4]);
			form.setFollowerId((Integer)objects[5]);
			form.setBidding_results_type(String.valueOf(objects[6]));
			form.setProject_bidding_status_type(String.valueOf(objects[7]));
			form.setBid_schedule_type(String.valueOf(objects[8]));
			form.setCreateDepartmentId((Integer)objects[9]);
			form.setCreateUserId((Integer)objects[10]);
			form.setRealname(String.valueOf(objects[11]));
			form.setProjNumber(String.valueOf(objects[12]));
			formList.add(form);*/
			form.put("id", String.valueOf(objects[0]));
			form.put("projName", String.valueOf(objects[1]));
			form.put("predictContractMoney", String.valueOf(objects[2]));
			form.put("biddingDirector", String.valueOf(objects[3]));
			form.put("biddingDate", String.valueOf(objects[4]));
			form.put("followerId", String.valueOf(objects[5]));
			form.put("biddingResultsType", String.valueOf(objects[6]));
			form.put("projBiddingStatusType",String.valueOf(objects[7]));
			form.put("bidScheduleType", String.valueOf(objects[8]));
			form.put("createDepartmentId", String.valueOf(objects[9]));
			form.put("createUserId", String.valueOf(objects[10]));
			form.put("realName", String.valueOf(objects[11]));
			form.put("projNumber", String.valueOf(objects[12]));
			form.put("projectBiddingStatus",String.valueOf(objects[13]));
			form.put("bidSchedule",String.valueOf(objects[14]));
			form.put("biddingResults",String.valueOf(objects[13]));
			form.put("projId", String.valueOf(objects[16]));
			formList.add(form);
		}
		return CommonUtils.getPageJson(pageNo, pageSize, draw, totalCount, formList, null);
	}
	/**
	 *查询FlxoaProjectBidInformation数据条数 
	 */ 
	public Long queryCount(FlxoaProjectBidInformation flxoaProjectBidInformation) {
		String hql = "select count(*) from FlxoaProjectBidInformation where delete_flag = '0' ";
		return countByHql(hql,null);
	}
	
	@Override
	protected Class<FlxoaProjectBidInformation> getEntityClass() {
		return FlxoaProjectBidInformation.class;
	} 

}