package com.flx.flxoa.info.clientsManagement.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.flx.flxoa.common.hibernate3.HibernateBaseDao;
import com.flx.flxoa.common.util.CommonUtils;
import com.flx.flxoa.info.clientsManagement.dao.FlxoaClientFollowerChangeDao;

@Repository
public class FlxoaClientFollowerChangeDaoImpl extends HibernateBaseDao<Object, Integer> implements FlxoaClientFollowerChangeDao{

	public String queryForPage(Map<String, String> map) {
		String hql="SELECT " +
				" u.id as userId," +
				" u.user_name," +
				" u.real_name," +
				" d.`name` as deptName," +
				" r.`name` as roleName, " +
				" u.position, "+
				" u.phone "+
				"FROM flxoa_system_user u  " +
				"LEFT JOIN flxoa_system_department d ON d.id=u.department_id "+
				"LEFT JOIN flxoa_system_user_role ur ON u.id = ur.user_id " +
				"LEFT JOIN flxoa_system_role r ON r.id = ur.role_id " +
				"WHERE r.`name` = '销售人员' "; 
				String orderSql=" ORDER BY u.id";
		String keyIn=map.get("keyIn");
		if(!CommonUtils.isEmpty(keyIn)){
			hql+=" and u.real_name like '%"+keyIn+"%'";
		}
		hql+=orderSql;
		/*计算数据总数*/
		String countSql="select count(*) from ("+hql+") as countTable";
		Long totalCount=countBySql(countSql,null);
		String draw=map.get("draw");
		String start=map.get("start");
		String length=map.get("length");
		/*获取数据*/
		List list=queryListForPageBySQL(Integer.parseInt(start),Integer.parseInt(length),hql);
		List<Map<String,String>> dataList=new ArrayList<Map<String,String>>();
		for(int i=0;i<list.size();i++){
			Map<String,String> dataMap=new HashMap<String,String>();
			Object[] obj=(Object[]) list.get(i);
			/*dataMap.put("clientId", String.valueOf(obj[0]));
			dataMap.put("clientName", String.valueOf(obj[1]));*/
			dataMap.put("userId", String.valueOf(obj[0]));
			dataMap.put("userName", String.valueOf(obj[1]));
			dataMap.put("realName", String.valueOf(obj[2]));
			dataMap.put("deptName", String.valueOf(obj[3]));
			dataMap.put("roleName", String.valueOf(obj[4]));
			dataMap.put("userPosition", String.valueOf(obj[5]));
			dataMap.put("userPhone", String.valueOf(obj[6]));
			dataList.add(dataMap);
		}
		return CommonUtils.getPageJson(Integer.parseInt(start), Integer.parseInt(length), draw, totalCount, dataList, null);
	}

	@Override
	protected Class<Object> getEntityClass() {
		// TODO Auto-generated method stub
		return null;
	}

}
