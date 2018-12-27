package com.flx.flxoa.info.market.dao.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.flx.flxoa.info.market.dao.HxFavoriteDao;
import com.flx.flxoa.info.market.entity.HxFavorite;
import org.springframework.stereotype.Repository;
import com.flx.flxoa.common.hibernate3.HibernateBaseDao;
import com.flx.flxoa.common.util.CommonUtils;

/**
 *
 * 类名称：HxFavoriteDaoImpl.java
 * 类描述：
 * 创建时间：2018-11-08, 下午03:05:40
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author leijun 
 */ 
@Repository
public class HxFavoriteDaoImpl extends HibernateBaseDao<HxFavorite, Integer> implements HxFavoriteDao {
	/**
	 *添加HxFavorite
	 */ 
	public boolean add(HxFavorite hxFavorite) {
		return save(hxFavorite);
	}
	/**
	 *删除HxFavorite
	 */ 
	public boolean delete(HxFavorite hxFavorite) {
		return deleteById(hxFavorite.getFavoriteId());
	}
	/**
	 *修改HxFavorite
	 */ 
	public boolean update(HxFavorite hxFavorite) {
		return modify(hxFavorite);
	}
	@Override
	public boolean isExist(String username , String UserID) {
		String hql="from HxFavorite where NewsID='"+username+"' and UserID = '"+UserID+"' ";
		List list=queryByHQL(hql);
		if(list.size()<1){
			return true;
		}
		return false;
	} 
	/**
	 *查询HxFavorite列表
	 */ 
	public List<HxFavorite> query(HxFavorite hxFavorite) {
		String hql = " from HxFavorite where delete_flag = '0' ";
		return getListByHQL(hql, null);
	}
	/**
	 *查询HxFavorite ByID
	 */ 
//	public HxFavorite queryById(HxFavorite hxFavorite) {
//		return get(hxFavorite.getId());
//	}
	/**
	 *分页HxFavorite pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public String queryForPage(Map<String,String> map) {
		int start=Integer.valueOf(map.get("start"));
		int length=Integer.valueOf(map.get("length"));
		//报价综合查询
		String hql = " select * from hx_favorite where 0 = 0 ";
		//求和查询sql
		String countSql="select count(*) "+"from hx_favorite";
		Long totalCount= countBySql(countSql,null);
		//地区
		if(!CommonUtils.isEmpty(map.get("UserID"))) {
			hql += " and UserID = '"+map.get("UserID")+"'";
		}
		hql += "  GROUP BY favoriteId asc  ";
		List<Map<String,String>> dataList=new ArrayList<Map<String,String>>();
		try {
			List list= queryListForPageBySQL(start, length, hql);
			for(int i=0;i<list.size();i++){
				Map<String,String> dataMap=new HashMap<String,String>();
				Object[] obj=(Object[]) list.get(i);
				dataMap.put("FavoriteID", String.valueOf(obj[0]));
				dataMap.put("NewsID", String.valueOf(obj[1]));
				dataMap.put("Title", String.valueOf(obj[2]));
				dataMap.put("UserID", String.valueOf(obj[3]));
				dataList.add(dataMap);
			}
		}catch (Exception e) {
			throw new RuntimeException();  
		}
		return CommonUtils.getMarketPageJson(start, length,totalCount,dataList);
	}
	/**
	 *查询HxFavorite数据条数 
	 */ 
	public Long queryCount(HxFavorite hxFavorite) {
		String hql = "select count(*) from HxFavorite where delete_flag = '0' ";
		return countByHql(hql,null);
	}
	
	@Override
	protected Class<HxFavorite> getEntityClass() {
		return HxFavorite.class;
	} 

}