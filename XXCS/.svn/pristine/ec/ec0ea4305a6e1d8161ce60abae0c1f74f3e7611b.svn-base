package com.flx.flxoa.info.clientsManagement.dao.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.flx.flxoa.info.clientsManagement.entity.FlxoaClientInformation;
import com.flx.flxoa.info.clientsManagement.dao.FlxoaClientInformationDao;
import org.springframework.stereotype.Repository;
import com.flx.flxoa.common.hibernate3.HibernateBaseDao;
import com.flx.flxoa.common.util.CommonUtils;

/**
 *
 * 类名称：FlxoaClientInformationDaoImpl.java
 * 类描述：
 * 创建时间：2018-09-05, 下午03:19:41
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 孙进 
 */ 
@Repository
public class FlxoaClientInformationDaoImpl extends HibernateBaseDao<FlxoaClientInformation, Integer> implements FlxoaClientInformationDao {
	/**
	 *添加FlxoaClientInformation
	 */ 
	public boolean add(FlxoaClientInformation flxoaClientInformation) {
		return save(flxoaClientInformation);
	}
	/**
	 *删除FlxoaClientInformation
	 */ 
	public boolean delete(FlxoaClientInformation flxoaClientInformation) {
		flxoaClientInformation.setDeleteFlag("1");
		return save(flxoaClientInformation);
	}
	/**
	 *修改FlxoaClientInformation
	 */ 
	public boolean update(FlxoaClientInformation flxoaClientInformation) {
		return modify(flxoaClientInformation);
	}
	/**
	 *查询FlxoaClientInformation列表
	 */ 
	public List<FlxoaClientInformation> query(FlxoaClientInformation flxoaClientInformation) {
		String hql = " from FlxoaClientInformation where delete_flag = '0' ";
		return getListByHQL(hql, null);
	}
	/**
	 *查询FlxoaClientInformation ByID
	 */ 
	public FlxoaClientInformation queryById(FlxoaClientInformation flxoaClientInformation) {
		return get(flxoaClientInformation.getId());
	}
	/**
	 *分页FlxoaClientInformation pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public String queryForPage(Map<String, String> map) {
		String hql = " from flxoa_client_information Cinfo" 
				+" left join flxoa_project_information projInfo on Cinfo.client_name=projInfo.client_name" 
				+" left join " 
				+"("
				+ "select "
				+ "enumeration_name,"
				+ "enumeration_key,"
				+ "enumeration_value "
				+ "from "
				+ "flxoa_system_enumeration"
				+ " where "
				+ "enumeration_name='client_rank' and delete_flag='0'"
				+ ") Crank on Cinfo.client_rank=Crank.enumeration_key"
				+" left join flxoa_system_user Fuser on Fuser.id=projInfo.whether_follow" 
				+" left join flxoa_system_department Fdept on Fdept.id=Fuser.department_id " +
				" where Cinfo.delete_flag = '0' ";
		
		String querySql="select "+ 
				"Cinfo.id," +
				"Cinfo.client_name," +
				"Cinfo.client_rank," +
				"Cinfo.client_trade," +
				"Cinfo.client_address," +
				"Cinfo.client_business,"+
				"Cinfo.client_salesman,"+
				"Cinfo.client_siteURL,"+
				"Cinfo.client_phone,"+
				"Cinfo.client_mail,"+
				"Cinfo.client_cellphone,"+
				"Cinfo.client_postcode,"+
				"Cinfo.client_fax,"+
				"Cinfo.comments,"+
				"Cinfo.delete_flag,"+
				"Cinfo.create_user_id,"+
				"Cinfo.create_department_id,"+
				"Cinfo.create_time,"+
				"Cinfo.update_user_id,"+
				"Cinfo.update_department_id,"+
				"Cinfo.update_time,"+
				"Fuser.user_name," +
				"Fdept.name";
		
		String orderSql=" group by Cinfo.client_name ORDER BY Cinfo.id ASC";
		/*获取查询参数*/
		String draw=map.get("draw");
		String start=map.get("start");
		String length=map.get("length");
		String clientName=map.get("client_name");
		String clientRank=map.get("client_rank");
		String clientTrade=map.get("client_trade");
		String clientFollower=map.get("client_follower");
		String clientFollowerDept=map.get("client_follower_dept");
		if(!CommonUtils.isEmpty(clientName)){
			hql+=" and Cinfo.client_name like '%"+clientName+"%'";
		}
		if(!CommonUtils.isEmpty(clientRank)){
			hql+=" and Cinfo.client_rank="+clientRank;
		}
		if(!CommonUtils.isEmpty(clientTrade)){
			hql+=" and Cinfo.client_trade="+clientTrade;
		}
		if(!CommonUtils.isEmpty(clientFollower)){
			hql+=" and Fuser.user_name like '%"+clientFollower+"%'";
		}
		if(!CommonUtils.isEmpty(clientFollowerDept)){
			hql+=" and Fdept.id="+clientFollowerDept;
		}
		
		/*sql语句拼接*/
		hql+=orderSql;
		querySql+=hql;
		System.out.println("客户查询sql:======="+querySql);
		/*获取总数据条数sql*/
		String countSql="select count(*) from ("+querySql+") as countTable";
		System.out.println("客户数据求和SQL：======="+countSql);
		Long totalCount= countBySql(countSql,null);
		
		/*数据分页查询*/
		List list=queryListForPageBySQL(Integer.parseInt(start),Integer.parseInt(length),querySql);
		List<Map<String,String>> dataList=new ArrayList<Map<String,String>>();
		for(int i=0;i<list.size();i++){
			Map<String,String> dataMap=new HashMap<String,String>();
			Object[] obj=(Object[]) list.get(i);
			dataMap.put("id", String.valueOf(obj[0]));
			dataMap.put("clientName", String.valueOf(obj[1]));
			dataMap.put("clientRank", String.valueOf(obj[2]));
			dataMap.put("clientTrade", String.valueOf(obj[3]));
			dataMap.put("clientAddress", String.valueOf(obj[4]));
			dataMap.put("clientBusiness", String.valueOf(obj[5]));
			dataMap.put("clientSalesman", String.valueOf(obj[6]));
			dataMap.put("clientSiteURL", String.valueOf(obj[7]));
			dataMap.put("clientPhone", String.valueOf(obj[8]));
			dataMap.put("clientMail", String.valueOf(obj[9]));
			dataMap.put("clientCellphone", String.valueOf(obj[10]));
			dataMap.put("clientPostcode", String.valueOf(obj[11]));
			dataMap.put("clientFax", String.valueOf(obj[12]));
			dataMap.put("comments", String.valueOf(obj[13]));
			dataMap.put("deleteFlag", String.valueOf(obj[14]));
			dataMap.put("createUser_id", String.valueOf(obj[15]));
			dataMap.put("createDepartment_id", String.valueOf(obj[16]));
			dataMap.put("createTime", String.valueOf(obj[17]));
			dataMap.put("updateUser_id", String.valueOf(obj[18]));
			dataMap.put("updateDepartment_id", String.valueOf(obj[19]));
			dataMap.put("updateTime", String.valueOf(obj[20]));
			dataMap.put("clientFollower", String.valueOf(obj[21]));
			dataMap.put("clientFollowerDept",String.valueOf(obj[22]) );
			dataList.add(dataMap);
		}
		return CommonUtils.getPageJson(Integer.parseInt(start), Integer.parseInt(length),draw,totalCount,dataList,null);
	}
	/**
	 *查询FlxoaClientInformation数据条数 
	 */ 
	public Long queryCount(FlxoaClientInformation flxoaClientInformation) {
		String hql = "select count(*) from FlxoaClientInformation where delete_flag = '0' ";
		return countByHql(hql,null);
	}
	
	@Override
	protected Class<FlxoaClientInformation> getEntityClass() {
		return FlxoaClientInformation.class;
	}
	public String queryForPageByFid(Map<String, String> map) {
		String hql="select Cinfo.id," +
				"Cinfo.client_name " +
				"from flxoa_client_information Cinfo" +
				" where Cinfo.delete_flag = '0' ";
		String draw=map.get("draw");
		String start=map.get("start");
		String length=map.get("length");
		String fid=map.get("fid");
		if(!CommonUtils.isEmpty(fid)){
			hql+="and Cinfo.create_user_id="+fid;
		}
		String countSql="select count(*) from ("+hql+") as countTable";
		Long totalCount=countBySql(countSql,null);
		List list=queryListForPageBySQL(Integer.parseInt(start),Integer.parseInt(length),hql);
		List<Map<String,String>> dataList=new ArrayList<Map<String,String>>();
		for(int i=0;i<list.size();i++){
			Map<String,String> dataMap=new HashMap<String,String>();
			Object[] obj=(Object[]) list.get(i);
			dataMap.put("id", String.valueOf(obj[0]));
			dataMap.put("clientName", String.valueOf(obj[1]));
			dataList.add(dataMap);
		}
		return CommonUtils.getPageJson(Integer.parseInt(start), Integer.parseInt(length), draw, totalCount, dataList, null);
	} 

}