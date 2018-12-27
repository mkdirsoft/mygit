package com.flx.flxoa.info.market.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.flx.flxoa.info.market.dao.HxNewsDao;
import com.flx.flxoa.info.market.entity.HxNews;
import org.springframework.stereotype.Repository;
import com.flx.flxoa.common.hibernate3.HibernateBaseDao;
import com.flx.flxoa.common.util.CommonUtils;

/**
 *
 * 类名称：HxNewsDaoImpl.java
 * 类描述：
 * 创建时间：2018-11-08, 下午03:05:40
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author leijun 
 */ 
@Repository
public class HxNewsDaoImpl extends HibernateBaseDao<HxNews, Integer> implements HxNewsDao {
	/**
	 *添加HxNews
	 */ 
	public boolean add(HxNews hxNews) {
		return save(hxNews);
	}
	/**
	 *删除HxNews
	 */ 
	public boolean delete(HxNews hxNews) {
		hxNews.setDeleteFlag("1");
		return save(hxNews);
	}
	/**
	 *修改HxNews
	 */ 
	public boolean update(HxNews hxNews) {
		return modify(hxNews);
	}
	/**
	 *查询HxNews列表
	 */ 
	public List<HxNews> query(HxNews hxNews) {
		String hql = " from HxNews where delete_flag = '0' ";
		return getListByHQL(hql, null);
	}
	/**
	 *查询HxNews ByID
	 */ 
	public HxNews queryById(HxNews hxNews) {
		String hql = "  from HxNews where newsId = '"+hxNews.getNewsId()+"'    ";
		return getByHQL(hql,null);
	}
	/**
	 *分页HxNews pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public String queryForPage(Map<String,String> map) {
		int start=Integer.valueOf(map.get("start"));
		int length=Integer.valueOf(map.get("length"));
		String hql ="";
		String hqlll = "";
		String hqll = "UNION ALL " + 
				"	SELECT " + 
				"	NewsID, " + 
				"	Title, " + 
				"	Content, " + 
				"	NewsCategoryID, " + 
				"	NewsCategoryName, " + 
				"	PublishDt, " + 
				"	SourceCode, " + 
				"	SourceName, " + 
				"	ImgUrl, " + 
				"	ApprovalState, " + 
				"	ReleaseState, " + 
				"	0 AS guanzhu, " + 
				"   0 AS FollowID  " + 
				" FROM " + 
				"	hx_news  " + 
				" WHERE " + 
				"	 SourceCode NOT IN ( SELECT SourceCode FROM hx_follow WHERE UserID = '"+map.get("UserID")+"' )";
				//新闻分类id
				if(!CommonUtils.isEmpty(map.get("NewsCategoryID"))) {
					 hqlll += " and hx_news.NewsCategoryID = '"+map.get("NewsCategoryID")+"'";
				}
		//当请求类型为0时 查询普通列表
		if("0".equals(map.get("Type"))) {
			 hql += " select "
			 		+ "hx_news.NewsID, "
			 		+ "hx_news.Title, "
			 		+ "hx_news.Content, "
			 		+ "hx_news.NewsCategoryID, "
			 		+ "hx_news.NewsCategoryName, "
			 		+ "hx_news.PublishDt,"
			 		+ "hx_news.SourceCode as SourceCode, "
			 		+ "hx_news.SourceName, "
			 		+ "hx_news.ImgUrl, "
			 		+ "hx_news.ApprovalState, "
			 		+ "hx_news.ReleaseState, 1 as isFollow, "
			 		+ "hx_follow.FollowID "
			 		+ "from "
			 		+ "hx_news,"
			 		+ "hx_follow "
			 		+ "WHERE "
			 		+ "hx_news.SourceCode = hx_follow.SourceCode "
			 		+ "AND "
			 		+ "hx_follow.UserID =  '"+map.get("UserID")+"' ";
			 		
				//新闻分类id
				if(!CommonUtils.isEmpty(map.get("NewsCategoryID"))) {
					hql += " and hx_news.NewsCategoryID = '"+map.get("NewsCategoryID")+"'";
				}
				//来源
				if(!CommonUtils.isEmpty(map.get("SourceCode"))) {
					hql += " and hx_news.SourceCode = '"+map.get("SourceCode")+"'";
				}
				//新闻id
				if(!CommonUtils.isEmpty(map.get("NewsID"))) {
					hql = "	SELECT " + 
							"	NewsID, " + 
							"	Title, " + 
							"	Content, " + 
							"	NewsCategoryID, " + 
							"	NewsCategoryName, " + 
							"	PublishDt, " + 
							"	SourceCode, " + 
							"	SourceName, " + 
							"	ImgUrl, " + 
							"	ApprovalState, " + 
							"	ReleaseState, " + 
							"	0 AS guanzhu, " + 
							"	0 AS FollowID  " + 
							" FROM " + 
							"	hx_news  " + 
							" WHERE ";
						hql += "  newsId = '"+map.get("NewsID")+"'";
				}
				//新闻id
				if(CommonUtils.isEmpty(map.get("NewsID"))) {
					hql +=hqll+hqlll;
				}
				
					hql += "  ORDER BY PublishDt  desc  ";
		}
		
		//请求类型 1：返回当前这个人的所有关注的来源的所有资讯
		if("1".equals(map.get("Type"))) {
			 hql += " select "
			 		+ "hx_news.NewsID,"
			 		+ "hx_news.Title,"
			 		+ "hx_news.Content,"
			 		+ "hx_news.NewsCategoryID,"
			 		+ "hx_news.NewsCategoryName,"
			 		+ "hx_news.PublishDt,"
			 		+ "hx_news.SourceCode as SourceCode,"
			 		+ "hx_news.SourceName,"
			 		+ "hx_news.ImgUrl,"
			 		+ "hx_news.ApprovalState,"
			 		+ "hx_news.ReleaseState, 1 as isFollow, "
			 		+ "hx_follow.FollowID "
			 		+ "from "
			 		+ "hx_news,"
			 		+ "hx_follow "
			 		+ "WHERE "
			 		+ "hx_news.SourceCode = hx_follow.SourceCode "
			 		+ "AND "
			 		+ "hx_follow.UserID =  '"+map.get("UserID")+"' ";
			 	//新闻id
				if(!CommonUtils.isEmpty(map.get("NewsID"))) {
					hql += " and hx_news.newsId = '"+map.get("NewsID")+"'";
				}
				//新闻分类id
				if(!CommonUtils.isEmpty(map.get("NewsCategoryID"))) {
					hql += " and hx_news.NewsCategoryID = '"+map.get("NewsCategoryID")+"'";
				}
				//来源
				if(!CommonUtils.isEmpty(map.get("SourceCode"))) {
					hql += " and hx_news.SourceCode = '"+map.get("SourceCode")+"'";
				}
		//	hql += "  GROUP BY hx_news.PublishDt desc  ";
		}
		
		//求和查询sql
		String countSql="select count(*) "+"from hx_news";
		Long totalCount= countBySql(countSql,null);
		
		
		
		
		List list= queryListForPageBySQL(start, length, hql);
		List<Map<String,String>> dataList=new ArrayList<Map<String,String>>();
		List<Map<String,String>> otherDataList=new ArrayList<Map<String,String>>();
		for(int i=0;i<list.size();i++){
			Map<String,String> dataMap=new HashMap<String,String>();
			Object[] obj=(Object[]) list.get(i);
			dataMap.put("NewsID", String.valueOf(obj[0]));
			dataMap.put("Title", String.valueOf(obj[1]));
			dataMap.put("Content", String.valueOf(obj[2]));
			dataMap.put("NewsCategoryID", String.valueOf(obj[3]));
			dataMap.put("NewsCategoryName", String.valueOf(obj[4]));
			dataMap.put("PublishDt", String.valueOf(obj[5]));
			dataMap.put("SourceCode", String.valueOf(obj[6]));
			dataMap.put("SourceName", String.valueOf(obj[7]));
			dataMap.put("ImgUrl", String.valueOf(obj[8]));
			dataMap.put("ApprovalState", String.valueOf(obj[9]));
			dataMap.put("ReleaseState", String.valueOf(obj[10]));
			dataMap.put("isFollow", String.valueOf(obj[11]));
			dataMap.put("Followid", String.valueOf(obj[12]));
			dataList.add(dataMap);
		}
		return CommonUtils.getMarketPageJson(start, length,totalCount,dataList);
	}
	/**
	 *查询HxNews数据条数 
	 */ 
	public Long queryCount(HxNews hxNews) {
		String hql = "select count(*) from HxNews where delete_flag = '0' ";
		return countByHql(hql,null);
	}
	
	@Override
	protected Class<HxNews> getEntityClass() {
		return HxNews.class;
	} 

}