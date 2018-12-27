package com.flx.flxoa.info.market.dao.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.flx.flxoa.common.hibernate3.HibernateBaseDao;
import com.flx.flxoa.common.util.CommonUtils;
import com.flx.flxoa.info.market.dao.HxStatisticsdataDao;
import com.flx.flxoa.info.market.entity.HxStatisticsdata;

/**
 *
 * 类名称：HxStatisticsdataDaoImpl.java
 * 类描述：
 * 创建时间：2018-11-02, 上午11:02:11
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author leijun 
 */ 
@Repository
public class HxStatisticsdataDaoImpl extends HibernateBaseDao<HxStatisticsdata, Integer> implements HxStatisticsdataDao {
	/**
	 *添加HxStatisticsdata
	 */ 
	public boolean add(HxStatisticsdata hxStatisticsdata) {
		return save(hxStatisticsdata);
	}
	/**
	 *删除HxStatisticsdata
	 */ 
	public boolean delete(HxStatisticsdata hxStatisticsdata) {
		hxStatisticsdata.setDeleteFlag("1");
		return save(hxStatisticsdata);
	}
	/**
	 *修改HxStatisticsdata
	 */ 
	public boolean update(HxStatisticsdata hxStatisticsdata) {
		return modify(hxStatisticsdata);
	}
	/**
	 *查询HxStatisticsdata列表
	 */ 
	public List<HxStatisticsdata> query(HxStatisticsdata hxStatisticsdata) {
		
		String hql = " from HxStatisticsdata where OfferType = '1' ";
		return getListByHQL(hql, null);
	}
	/**
	 *查询HxStatisticsdata ByID
	 */ 
	public HxStatisticsdata queryById(HxStatisticsdata hxStatisticsdata) {
		return get(hxStatisticsdata.getStatisticsDataId());
	}
	/**
	 *分页HxStatisticsdata pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public String queryForPage(Map<String,String> map) {
		String hql = "select * from hx_statisticsdata where 0 = 0";
		//地区
		if(!CommonUtils.isEmpty(map.get("RegionCode"))) {
			hql += " and RegionCode = '"+map.get("RegionCode")+"'";
		}
		//品类
		if(!CommonUtils.isEmpty(map.get("CropCategoryCode"))) {
			hql += " and CropCategoryCode = '"+map.get("CropCategoryCode")+"'";
		}
		//类型
		if(!CommonUtils.isEmpty(map.get("OfferType"))) {
			hql += " and OfferType = '"+map.get("OfferType")+"'";
		}
		
		//开始日期
		if( !CommonUtils.isEmpty(map.get("OfferDateStart")) && CommonUtils.isEmpty(map.get("OfferDateEnd")) ) {
			hql += " and offerDate = '"+map.get("OfferDateStart")+"'";
		}
		//时间段查询6
		if(!CommonUtils.isEmpty(map.get("OfferDateEnd")) && !CommonUtils.isEmpty(map.get("OfferDateStart"))) {
			hql += " AND offerDate between  '"+map.get("OfferDateStart")+"' and '"+map.get("OfferDateEnd")+"'";
		}
		hql += "  GROUP BY statisticsDataId asc  ";
		List list= queryListMarketForPageBySQL(hql);
		System.out.println("list"+list);
		List<Map<String,String>> dataList=new ArrayList<Map<String,String>>();
		List<Map<String,String>> otherDataList=new ArrayList<Map<String,String>>();
		for(int i=0;i<list.size();i++){
			Map<String,String> dataMap=new HashMap<String,String>();
			Object[] obj=(Object[]) list.get(i);
			dataMap.put("statisticsDataId", String.valueOf(obj[0]));
			dataMap.put("RegionCode", String.valueOf(obj[1]));
			dataMap.put("RegionName", String.valueOf(obj[2]));
			dataMap.put("CropCategoryCode", String.valueOf(obj[3]));
			dataMap.put("CropCategoryName", String.valueOf(obj[4]));
			dataMap.put("cropOfferStr", String.valueOf(obj[5]));
			dataMap.put("OfferDate", String.valueOf(obj[6]));
			dataMap.put("offerWeek", String.valueOf(obj[7]));
			dataMap.put("price", String.valueOf(obj[8]));
			dataMap.put("unit", String.valueOf(obj[9]));
			dataMap.put("UnitName", String.valueOf(obj[10]));
			dataMap.put("offerType", String.valueOf(obj[11]));
			dataList.add(dataMap);
		}
		
		return CommonUtils.getMarketPageIconJson(dataList);
	}
	/**
	 *查询HxStatisticsdata数据条数 
	 */ 
	public Long queryCount(HxStatisticsdata hxStatisticsdata) {
		String hql = "select count(*) from HxStatisticsdata where delete_flag = '0' ";
		return countByHql(hql,null);
	}
	
	@Override
	protected Class<HxStatisticsdata> getEntityClass() {
		return HxStatisticsdata.class;
	} 

}