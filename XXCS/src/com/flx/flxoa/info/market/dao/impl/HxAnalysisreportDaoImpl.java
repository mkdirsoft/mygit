package com.flx.flxoa.info.market.dao.impl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.flx.flxoa.common.hibernate3.HibernateBaseDao;
import com.flx.flxoa.common.util.CommonUtils;
import com.flx.flxoa.info.market.dao.HxAnalysisreportDao;
import com.flx.flxoa.info.market.entity.HxAnalysisreport;


/**
 *
 * 类名称：HxAnalysisreportDaoImpl.java
 * 类描述：
 * 创建时间：2018-11-02, 上午11:02:11
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author leijun 
 */ 
@Repository
public class HxAnalysisreportDaoImpl extends HibernateBaseDao<HxAnalysisreport, Integer> implements HxAnalysisreportDao {
	/**
	 *添加HxAnalysisreport
	 */ 
	public boolean add(HxAnalysisreport hxAnalysisreport) {
		return save(hxAnalysisreport);
	}
	/**
	 *删除HxAnalysisreport
	 */ 
	public boolean delete(HxAnalysisreport hxAnalysisreport) {
		hxAnalysisreport.setDeleteFlag("1");
		return save(hxAnalysisreport);
	}
	/**
	 *修改HxAnalysisreport
	 */ 
	public boolean update(HxAnalysisreport hxAnalysisreport) {
		return modify(hxAnalysisreport);
	}
	/**
	 *查询HxAnalysisreport列表
	 */ 
	public List<HxAnalysisreport> query(HxAnalysisreport hxAnalysisreport) {
		String hql = " from HxAnalysisreport where delete_flag = '0' ";
		return getListByHQL(hql, null);
	}
	/**
	 *查询HxAnalysisreport ByID
	 */ 
	public HxAnalysisreport queryById(HxAnalysisreport hxAnalysisreport) {
		return get(hxAnalysisreport.getAnalysisReportId());
	}
	/**
	 *分页HxAnalysisreport pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public String queryForPage(Map<String, String> map) {
		
		List<Map<String,String>> dataList=new ArrayList<Map<String,String>>();
		String hql = " select * from  hx_analysisreport  where 0 = '0' ";
		//地区
		if(!CommonUtils.isEmpty(map.get("CropCategoryCode"))) {
			hql += " and cropCategoryCode = '"+map.get("CropCategoryCode")+"'";
		}
		//品类
		if(!CommonUtils.isEmpty(map.get("Top"))) {
			hql += " and cropCategoryName = '%"+map.get("Top")+"'";
		}
		//开始日期
		if( !CommonUtils.isEmpty(map.get("ReportDateStart")) && CommonUtils.isEmpty(map.get("ReportDateEnd")) ) {
			hql += " and analysisReportDate = '"+map.get("OfferDateStart")+"'";
		}
		//时间段查询
		if(!CommonUtils.isEmpty(map.get("ReportDateEnd")) && !CommonUtils.isEmpty(map.get("ReportDateStart"))) {
			hql += " AND analysisReportDate between  '"+map.get("ReportDateStart")+"' and '"+map.get("ReportDateEnd")+"'";
		}
		try {
			List list= queryListForPageIconBySQL(hql);
			
			for(int i=0;i<list.size();i++){
				Map<String,String> dataMap=new HashMap<String,String>();
				Object[] obj=(Object[]) list.get(i);
				dataMap.put("analysisReportId", String.valueOf(obj[0]));
				dataMap.put("cropCategoryCode", String.valueOf(obj[1]));
				dataMap.put("cropCategoryName", String.valueOf(obj[2]));
				dataMap.put("analysisReportDate", String.valueOf(obj[3]));
				dataMap.put("analysisReportName", String.valueOf(obj[4]));
				dataMap.put("analysisReportContent", String.valueOf(obj[5]));
				dataMap.put("attachmentUrl", String.valueOf(obj[6]));
				dataList.add(dataMap);
			}
		}catch (Exception e) {
			throw new RuntimeException();
		}
		
		return CommonUtils.getMarketPageIconJson(dataList);
	}
		
	/**
	 *查询HxAnalysisreport数据条数 
	 */ 
	public Long queryCount(HxAnalysisreport hxAnalysisreport) {
		String hql = "select count(*) from HxAnalysisreport where delete_flag = '0' ";
		return countByHql(hql,null);
	}
	
	@Override
	protected Class<HxAnalysisreport> getEntityClass() {
		return HxAnalysisreport.class;
	} 

}