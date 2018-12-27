package com.flx.flxoa.info.market.dao.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.flx.flxoa.info.market.dao.HxSubscribeDao;
import com.flx.flxoa.info.market.entity.HxSubscribe;
import org.springframework.stereotype.Repository;
import com.flx.flxoa.common.hibernate3.HibernateBaseDao;
import com.flx.flxoa.common.util.CommonUtils;

/**
 *
 * 类名称：HxSubscribeDaoImpl.java
 * 类描述：
 * 创建时间：2018-11-08, 下午03:05:40
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author leijun 
 */ 
@Repository
public class HxSubscribeDaoImpl extends HibernateBaseDao<HxSubscribe, Integer> implements HxSubscribeDao {
	/**
	 *添加HxSubscribe
	 */ 
	public boolean add(HxSubscribe hxSubscribe) {
		return save(hxSubscribe);
	}
	/**
	 *删除HxSubscribe
	 */ 
	public boolean delete(HxSubscribe hxSubscribe) {
		return deleteById(hxSubscribe.getSubscribeId());
	}
	/**
	 *修改HxSubscribe
	 */ 
	public boolean update(HxSubscribe hxSubscribe) {
		return modify(hxSubscribe);
	}
	/**
	 * 订阅-不等重复订阅
	 */
	@Override
	public boolean isExist(String userID,String RegionCodeID,String CropCategoryID) {
		String hql="from HxSubscribe where UserID='"+userID+"' and RegionCode='"+RegionCodeID+"' and CropCategoryCode='"+CropCategoryID+"' ";
		List list=queryByHQL(hql);
		if(list.size()<1){
			return true;
		}
		return false;
	} 
	/**
	 *查询HxSubscribe列表
	 */ 
	public List<HxSubscribe> query(HxSubscribe hxSubscribe) {
		String hql = " from HxSubscribe where delete_flag = '0' ";
		return getListByHQL(hql, null);
	}
	/**
	 *查询HxSubscribe ByID
	 */ 
	public HxSubscribe queryById(HxSubscribe hxSubscribe) {
		String hql = "  from HxSubscribe where subscribeId = '"+hxSubscribe.getSubscribeId()+"'    ";
		return getByHQL(hql,null);
	}
	/**
	 *分页HxSubscribe pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public String queryForPage(Map<String,String> map) {
		int start=Integer.valueOf(map.get("start"));
		int length=Integer.valueOf(map.get("length"));
		int personal = 1;
		List<Map<String,String>> dataList=new ArrayList<Map<String,String>>();
		List<Map<String,String>> otherDataList=new ArrayList<Map<String,String>>();
		
		String hql = "";
		//当PersonalSubscriptions=1时 个人订阅（个人订阅-显示最新一天订阅数据），否则为我的订阅
		if("1".equals(map.get("PersonalSubscriptions"))) {
			hql +="	SELECT " + 
					"  cropofferOld.CropOfferID, " + 
					"  cropofferOld.RegionCode, " + 
					"  cropofferOld.RegionName, " + 
					"  cropofferOld.CropCategoryCode, " + 
					"  cropofferOld.CropCategoryName, " + 
					"  cropofferOld.Price, " + 
					"  cropofferOld.Unit, " + 
					"  cropofferOld.UnitName, " + 
					"  cropofferOld.TodayTrend, " + 
					"  cropofferNew.SubscribeID, " + 
					"  cropofferOld.UserID, " + 
					"  cropofferOld.CropOfferStr, " + 
					"  cropofferOld.OfferDate " + 
					"FROM " + 
					" hx_cropoffer cropofferOld " + 
					"INNER JOIN ( " + 
					" SELECT " + 
					"  hx_cropoffer.CropOfferID, " + 
					"  hx_cropoffer.RegionCode, " + 
					"  hx_cropoffer.RegionName, " + 
					"  hx_cropoffer.CropCategoryCode, " + 
					"  hx_cropoffer.CropCategoryName, " + 
					"  hx_cropoffer.Price, " + 
					"  hx_cropoffer.Unit, " + 
					"  hx_cropoffer.UnitName, " + 
					"  hx_cropoffer.TodayTrend, " + 
					"  hx_subscribe.SubscribeID, " + 
					"  hx_subscribe.UserID, " + 
					"  hx_cropoffer.CropOfferStr, " + 
					"  MAX(hx_cropoffer.OfferDate) OfferDate " + 
					" FROM " + 
					"  hx_cropoffer, " + 
					"  hx_subscribe " + 
					" WHERE " + 
					"  hx_cropoffer.RegionCode = hx_subscribe.RegionCode " + 
					" AND hx_cropoffer.CropCategoryCode = hx_subscribe.CropCategoryCode " + 
					" AND hx_subscribe.UserID = '"+map.get("UserID")+"'" + 
					" GROUP BY " + 
					"  CropOfferStr " + 
					") cropofferNew ON cropofferOld.CropOfferStr = cropofferNew.CropOfferStr " + 
					"AND cropofferOld.OfferDate = cropofferNew.OfferDate " + 
					"WHERE cropofferOld.CropOfferID NOT in (SELECT " + 
					"   hx_personalsubscriptionsdel.CropOfferCode " + 
					"  FROM " + 
					"   hx_subscribe, " + 
					"   hx_personalsubscriptionsdel " + 
					"  WHERE " + 
					"   hx_subscribe.SubscribeID = hx_personalsubscriptionsdel.SubscribeCode " + 
					"  AND hx_subscribe.UserID = '"+map.get("UserID")+"') " + 
					"GROUP BY cropofferOld.CropOfferStr";
			List list= queryListForPageBySQL(start, length, hql);
			
			for(int i=0;i<list.size();i++){
				Map<String,String> dataMap=new HashMap<String,String>();
				Object[] obj=(Object[]) list.get(i);
				dataMap.put("CropOfferID", String.valueOf(obj[0]));
				dataMap.put("RegionCode", String.valueOf(obj[1]));
				dataMap.put("RegionName", String.valueOf(obj[2]));
				dataMap.put("CropCategoryCode", String.valueOf(obj[3]));
				dataMap.put("CropCategoryName", String.valueOf(obj[4]));
				dataMap.put("Price", String.valueOf(obj[5]));
				dataMap.put("Unit", String.valueOf(obj[6]));
				dataMap.put("UnitName", String.valueOf(obj[7]));
				dataMap.put("TodayTrend", String.valueOf(obj[8]));
				dataMap.put("SubscribeID", String.valueOf(obj[9]));
				dataMap.put("UserID", String.valueOf(obj[10]));
				dataMap.put("CropOfferStr", String.valueOf(obj[11]));
				dataMap.put("OfferDate", String.valueOf(obj[12]));
				dataList.add(dataMap);
			}
		}else {
			hql += " select * from hx_subscribe where 0 = 0 ";
			//地区
			if(!CommonUtils.isEmpty(map.get("UserID"))) {
				hql += " and UserID = '"+map.get("UserID")+"'";
			}
			List lists= queryListForPageBySQL(start, length, hql);
			for(int i=0;i<lists.size();i++){
				Map<String,String> dataMap=new HashMap<String,String>();
				Object[] obj=(Object[]) lists.get(i);
				dataMap.put("SubscribeID", String.valueOf(obj[0]));
				dataMap.put("RegionCode", String.valueOf(obj[1]));
				dataMap.put("Region", String.valueOf(obj[2]));
				dataMap.put("CropCategoryCode", String.valueOf(obj[3]));
				dataMap.put("CropCategoryName", String.valueOf(obj[4]));
				dataMap.put("UserID", String.valueOf(obj[5]));
				dataList.add(dataMap);
			}
		}
		String countSql="select count(*) "+"from hx_subscribe";
		Long totalCount= countBySql(countSql,null);
		
		//hql += "  GROUP BY subscribeId asc  ";
		
		return CommonUtils.getMarketPageJson(start, length,totalCount,dataList);
	}
	/**
	 *查询HxSubscribe数据条数 
	 */ 
	public Long queryCount(HxSubscribe hxSubscribe) {
		String hql = "select count(*) from HxSubscribe where delete_flag = '0' ";
		return countByHql(hql,null);
	}
	
	@Override
	protected Class<HxSubscribe> getEntityClass() {
		return HxSubscribe.class;
	} 

}