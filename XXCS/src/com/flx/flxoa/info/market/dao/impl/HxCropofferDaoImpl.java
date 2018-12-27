package com.flx.flxoa.info.market.dao.impl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Repository;

import com.flx.flxoa.common.hibernate3.HibernateBaseDao;
import com.flx.flxoa.common.util.CommonUtils;
import com.flx.flxoa.info.market.dao.HxCropofferDao;
import com.flx.flxoa.info.market.entity.HxCropoffer;
import com.flx.flxoa.info.market.entity.HxSubscribe;


/**
 *
 * 类名称：HxCropofferDaoImpl.java
 * 类描述：
 * 创建时间：2018-11-01, 下午04:26:12
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author leijun 
 */ 
@Repository
public class HxCropofferDaoImpl extends HibernateBaseDao<HxCropoffer, Integer> implements HxCropofferDao {
	private static final int Object = 0;
	private HttpServletRequest HttpServletRequest;

	/**
	 *添加HxCropoffer
	 */ 
	public boolean add(HxCropoffer HxCropoffer) {
		return save(HxCropoffer);
	}
	/**
	 *删除HxCropoffer
	 */ 
	public boolean delete(HxCropoffer HxCropoffer) {
		HxCropoffer.setDeleteFlag("1");
		return save(HxCropoffer);
	}
	/**
	 *修改HxCropoffer
	 */ 
	public boolean update(HxCropoffer HxCropoffer) {
		return modify(HxCropoffer);
	}
	/**
	 *查询HxCropoffer列表 暂时没用到该方法
	 */ 
	public List<HxCropoffer> query(HxCropoffer HxCropoffer) {
		//订阅信息表
		HxSubscribe hxSubscribe = new HxSubscribe();
		HttpServletRequest req = (HttpServletRequest);
		//用户id
		String UserID =String.valueOf(req.getSession().getAttribute("userId"));
		//根据用户ID查询订阅表信息	
		String SubscribeHql = "SELECT " + 
				"	hx_subscribe.RegionCode, " + 
				"	hx_subscribe.Region, " + 
				"	hx_subscribe.CropCategoryCode, " + 
				"	hx_subscribe.CropCategoryName, " + 
				"	hx_subscribe.Price, " + 
				"	hx_subscribe.CropOfferStr  " + 
				"FROM " + 
				"	hx_subscribe  " + 
				"WHERE " + 
				"	UserID = '"+UserID+"'  " + 
				"GROUP BY " + 
				"	SubscribeID DESC  " + 
				"	LIMIT 8";
		//订阅数据集合
		List list = getListBySQL(SubscribeHql, null);
		//查询报价表
		String hql = "SELECT " + 
				"	hx_cropoffer.RegionCode, " + 
				"	hx_cropoffer.RegionName, " + 
				"	hx_cropoffer.CropCategoryCode, " + 
				"	hx_cropoffer.CropCategoryName, " + 
				"	hx_cropoffer.Price, " + 
				"	hx_cropoffer.CropOfferStr  " + 
				"FROM " + 
				"	hx_cropoffer  " + 
				"GROUP BY " + 
				"	browseCount ASC  " + 
				"	LIMIT 8";
		List listCrop = getListBySQL(SubscribeHql, null);
		
		List<Map<String,String>> dataList=new ArrayList<Map<String,String>>();
		try {
			if(list.size() > 0) {
				for(int i=0;i<list.size();i++){
				Map<String,String> dataMap=new HashMap<String,String>();
				
				Object[] obj=(Object[]) list.get(i);
				dataMap.put("RegionCode", String.valueOf(obj[0]));
				dataMap.put("RegionName", String.valueOf(obj[1]));
				dataMap.put("CropCategoryCode", String.valueOf(obj[2]));
				dataMap.put("CropCategoryName", String.valueOf(obj[3]));
				dataMap.put("Price", String.valueOf(obj[4]));
				dataMap.put("CropOfferStr", String.valueOf(obj[5]));
				dataList.add(dataMap);
				
				}
			}else{
				for(int i=0;i<listCrop.size();i++){
					Map<String,String> dataMap=new HashMap<String,String>();
					Object[] obj=(Object[]) list.get(i);
					dataMap.put("RegionCode", String.valueOf(obj[0]));
					dataMap.put("RegionName", String.valueOf(obj[1]));
					dataMap.put("CropCategoryCode", String.valueOf(obj[2]));
					dataMap.put("CropCategoryName", String.valueOf(obj[3]));
					dataMap.put("Price", String.valueOf(obj[4]));
					dataMap.put("CropOfferStr", String.valueOf(obj[5]));
					dataList.add(dataMap);
				}
			}
		} catch (Exception e) {
		}
		
		return getListBySQL(hql, null);
	}
	
	
	/**
	 *查询HxCropoffer列表
	 */ 
	public String  queryWheel(Map<String,String> map) {
		//订阅信息表
		HxSubscribe hxSubscribe = new HxSubscribe();
		//根据用户ID查询订阅表信息	
		String SubscribeHql = "SELECT " + 
				"	hx_subscribe.RegionCode, " + 
				"	hx_subscribe.Region, " + 
				"	hx_subscribe.CropCategoryCode, " + 
				"	hx_subscribe.CropCategoryName, " + 
				"	hx_subscribe.Price, " + 
				"	hx_subscribe.CropOfferStr  " + 
				"FROM " + 
				"	hx_subscribe  " + 
				"WHERE " + 
				"	UserID = '"+map.get("UserID")+"'  " + 
				"GROUP BY " + 
				"	SubscribeID DESC  " + 
				"	LIMIT 8";
		//订阅数据集合
		List list = getListBySQL(SubscribeHql, null);
		//查询报价表
		String hql = "SELECT " + 
				"	hx_cropoffer.RegionCode, " + 
				"	hx_cropoffer.RegionName, " + 
				"	hx_cropoffer.CropCategoryCode, " + 
				"	hx_cropoffer.CropCategoryName, " + 
				"	hx_cropoffer.Price, " + 
				"	hx_cropoffer.CropOfferStr  " + 
				"FROM " + 
				"	hx_cropoffer  " + 
				"GROUP BY " + 
				"	browseCount ASC  " + 
				"	LIMIT 8";
		//报价表数据集合
		List listCrop = getListBySQL(hql, null);
		//轮播数据集合
		List<Map<String,String>> dataList=new ArrayList<Map<String,String>>();
		try {
			/**
			 * 1 分别获取两张表中的数据：hx_subscribe订阅表，hx_cropoffer报价表,数据分别存储为list和listCrop
			 * 2 当list大于0时，循环list集合，将数据取出存储到dataList集合中，小于0时，循环listCrop集合，将数据取出存储到dataList集合中
			 * 3 因list集合数据可能不满足8条，判断dataList集合数据不满8条时循环listCrop集合，使dataList集合满足8条时，跳出listCrop循环，
			 * 4 如走listCrop，必为8条，
			 */
			if(list.size() > 0) {
				for(int i=0;i<list.size();i++){
				Map<String,String> dataMap=new HashMap<String,String>();
				Object[] obj=(Object[]) list.get(i);
				dataMap.put("RegionCode", String.valueOf(obj[0]));
				dataMap.put("RegionName", String.valueOf(obj[1]));
				dataMap.put("CropCategoryCode", String.valueOf(obj[2]));
				dataMap.put("CropCategoryName", String.valueOf(obj[3]));
				dataMap.put("Price", String.valueOf(obj[4]));
				dataMap.put("CropOfferStr", String.valueOf(obj[5]));
				dataList.add(dataMap);
				}
			}else{
				for(int i=0;i<listCrop.size();i++){
					Map<String,String> dataMap=new HashMap<String,String>();
					Object[] obj=(Object[]) listCrop.get(i);
					dataMap.put("RegionCode", String.valueOf(obj[0]));
					dataMap.put("RegionName", String.valueOf(obj[1]));
					dataMap.put("CropCategoryCode", String.valueOf(obj[2]));
					dataMap.put("CropCategoryName", String.valueOf(obj[3]));
					dataMap.put("Price", String.valueOf(obj[4]));
					dataMap.put("CropOfferStr", String.valueOf(obj[5]));
					dataList.add(dataMap);
				}
			}
		} catch (Exception e) {
		}
		if(dataList.size() < 8) {
			for(int i=0;i<listCrop.size();i++){
				Map<String,String> dataMap=new HashMap<String,String>();
				Object[] obj=(Object[]) listCrop.get(i);
				dataMap.put("RegionCode", String.valueOf(obj[0]));
				dataMap.put("RegionName", String.valueOf(obj[1]));
				dataMap.put("CropCategoryCode", String.valueOf(obj[2]));
				dataMap.put("CropCategoryName", String.valueOf(obj[3]));
				dataMap.put("Price", String.valueOf(obj[4]));
				dataMap.put("CropOfferStr", String.valueOf(obj[5]));
				dataList.add(dataMap);
				if(dataList.size() == 8) {
					break;
				}
			}
		}
		return CommonUtils.getMarketPageIconJson(dataList);
	}
	
	/**
	 *查询HxCropoffer ByID
	 */ 
	public HxCropoffer queryById(HxCropoffer HxCropoffer) {
		return get(HxCropoffer.getCropOfferId());
	}
	/**
	 *分页HxCropoffer pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	@SuppressWarnings("unchecked")
	public String queryForPage(Map<String,String> map) {
		int start=Integer.valueOf(map.get("start"));
		int length=Integer.valueOf(map.get("length"));
		
		String hql = "";
		//求和查询sql
		String countSql="select count(*) "+"from hx_cropoffer";
		Long totalCount= countBySql(countSql,null);
		//大品类
		if("0".equals(map.get("iscropcategory"))) {
			//报价综合查询
			  hql += " SELECT * FROM hx_cropoffer,hx_cropcategory WHERE hx_cropoffer.CropCategoryCode = hx_cropcategory.CropCategoryCode  ";
			//品类父级ID
			if(!CommonUtils.isEmpty(map.get("ParentID"))) {
				hql += " and hx_cropcategory.ParentID = '"+map.get("ParentID")+"'";
			}
			  //地区
			if(!CommonUtils.isEmpty(map.get("RegionCode"))) {
				hql += " and RegionCode = '"+map.get("RegionCode")+"'";
			}
			//来源
			if(!CommonUtils.isEmpty(map.get("CropSourceCode"))) {
				hql += " and hx_cropoffer.RegionCode = '"+map.get("CropSourceCode")+"'";
			}
			
			//开始日期
			if( !CommonUtils.isEmpty(map.get("OfferDateStart")) && CommonUtils.isEmpty(map.get("OfferDateEnd")) ) {
				hql += " and hx_cropoffer.offerDate = '"+map.get("OfferDateStart")+"'";
			}
			//时间段查询
			if(!CommonUtils.isEmpty(map.get("OfferDateEnd")) && !CommonUtils.isEmpty(map.get("OfferDateStart"))) {
				hql += " AND  hx_cropoffer.OfferDate  between '"+map.get("OfferDateStart")+"' AND '"+map.get("OfferDateEnd")+"'";
			}
			//品类
			if(!CommonUtils.isEmpty(map.get("CropCategoryCode"))) {
				hql += " and hx_cropcategory.CropCategoryCode = '"+map.get("CropCategoryCode")+"'";
			}
				hql += " ORDER BY OfferDate desc ";
		}
		//小品类
		if("1".equals(map.get("iscropcategory"))) {
				hql +=  " SELECT * FROM  hx_cropoffer where 0 = '0'";
			//地区
			if(!CommonUtils.isEmpty(map.get("RegionCode"))) {
				hql += " and RegionCode = '"+map.get("RegionCode")+"'";
			}
			
			//来源
			if(!CommonUtils.isEmpty(map.get("CropSourceCode"))) {
				hql += " and RegionCode = '"+map.get("CropSourceCode")+"'";
			}
			
			//开始日期
			if( !CommonUtils.isEmpty(map.get("OfferDateStart")) && CommonUtils.isEmpty(map.get("OfferDateEnd")) ) {
				hql += " and offerDate = '"+map.get("OfferDateStart")+"'";
			}
			//时间段查询
			if(!CommonUtils.isEmpty(map.get("OfferDateEnd")) && !CommonUtils.isEmpty(map.get("OfferDateStart"))) {
				hql += " AND  OfferDate  between '"+map.get("OfferDateStart")+"' AND '"+map.get("OfferDateEnd")+"'";
			}
			//品类
			if(!CommonUtils.isEmpty(map.get("CropCategoryCode"))) {
				hql += " and  CropCategoryCode = '"+map.get("CropCategoryCode")+"'";
				//hql += " and  LEFT(CropCategoryCode,2) = '"+map.get("CropCategoryCode")+"'";
			}
		 	if(!"huoyue".equals(map.get("huoyue"))) {
		 		hql+="ORDER BY OfferDate  desc ";
		 	}
		}
		
		if("huoyue".equals(map.get("huoyue"))) {
			hql += "  ORDER  BY todayTrend desc  ";
		}
			
		//0,日期倒序1，今日趋势倒序2，今日趋势正序3，今日趋势绝对值倒4，今日趋势绝对值正序
//		if(!CommonUtils.isEmpty(map.get("RegionID"))) {
//			hql += " and regionName = '"+map.get("RegionID")+"'";
//		}
		List<Map<String,String>> dataList=new ArrayList<Map<String,String>>();
		try {
			//报价表数据集合
			List list= queryListForPageBySQL(start, length, hql);
			for(int i=0;i<list.size();i++){
				Map<String,String> dataMap=new HashMap<String,String>();
					Object[] obj=(Object[]) list.get(i);
					dataMap.put("HxCropofferID", String.valueOf(obj[0]));
					dataMap.put("RegionCode", String.valueOf(obj[1]));
					dataMap.put("RegionName", String.valueOf(obj[2]));
					dataMap.put("CropCategoryCode", String.valueOf(obj[3]));
					dataMap.put("CropCategoryName", String.valueOf(obj[4]));
					dataMap.put("HxCropofferStr", String.valueOf(obj[5]));
					dataMap.put("OfferDate", String.valueOf(obj[6]));
					dataMap.put("Price", String.valueOf(obj[7]));
					dataMap.put("Unit", String.valueOf(obj[8]));
					dataMap.put("UnitName", String.valueOf(obj[9]));
					if(obj[10] == null) {
						obj[10] = 0;
					}
					dataMap.put("todayTrend", String.valueOf(obj[10]));
					if(obj[11] == null) {
						obj[11] = 0;
					}
					dataMap.put("fiveDayTrend", String.valueOf(obj[11]));
					if(obj[12] == null) {
						obj[12] = 0;
					}
					dataMap.put("weekAverage", String.valueOf(obj[12]));
					if(obj[13] == null) {
						obj[13] = 0;
					}
					dataMap.put("weekTrend", String.valueOf(obj[13]));
					dataMap.put("reason", String.valueOf(obj[14]));
					dataMap.put("weekAverage", String.valueOf(obj[15]));
					dataList.add(dataMap);
			}
		}catch (Exception e) {
			throw new RuntimeException();  
		}
		return CommonUtils.getMarketPageJson(start, length,totalCount,dataList);
	}
	
	/**
	 *图表
	 */ 
	public String queryForPageIcon(Map<String,String> map) {
		String hql = "";
		//获取走势图品类id（可能多个id）
		String ibs = map.get("listChart");
		//地区id
		String regionList = map.get("regionList");
		List<String> lists = new ArrayList<>();
		
		List<String> regions = new ArrayList<>();
		
		//将String转list-地区
		
		//总数据集合（如查询多个品类近五条数据，则根据id参数循环查询添加到该集合中）
		List<Map<String,String>> dataList=new ArrayList<Map<String,String>>();
		try {
			//lists.size 大于2时   图解
			if(map.get("regionList") != "" && map.get("regionList") != null) {
				//将String转list-品类
				String strs[] = regionList.split(",");
				regions = Arrays.asList(strs);
				for(int i = 0; i<regions.size(); i++) {
					hql = "SELECT * FROM hx_cropoffer WHERE  RegionCode = '"+regions.get(i)+"'  and  CropCategoryCode = '"+map.get("CropCategoryCode")+"' ";
					
					//开始日期
					if( !CommonUtils.isEmpty(map.get("OfferDateStart")) && CommonUtils.isEmpty(map.get("OfferDateEnd")) ) {
						hql += " and offerDate = '"+map.get("OfferDateStart")+"'";
					}
					//时间段查询
					if(!CommonUtils.isEmpty(map.get("OfferDateEnd")) && !CommonUtils.isEmpty(map.get("OfferDateStart"))) {
						hql += " AND  OfferDate  between '"+map.get("OfferDateStart")+"' AND '"+map.get("OfferDateEnd")+"'";
					}
						hql +="ORDER BY OfferDate  asc ";
					
					List list= queryListForPageIconBySQL( hql);
					if(list.size() > 0) {
						System.out.println("list"+list);
						List<Map<String,String>> otherDataList=new ArrayList<Map<String,String>>();
						for(int j=0;j<list.size();j++){
							Map<String,String> dataMap=new HashMap<String,String>();
							Object[] obj=(Object[]) list.get(j);
							dataMap.put("HxCropofferID", String.valueOf(obj[0]));
							dataMap.put("RegionCode", String.valueOf(obj[1]));
							dataMap.put("RegionName", String.valueOf(obj[2]));
							dataMap.put("CropCategoryCode", String.valueOf(obj[3]));
							dataMap.put("CropCategoryName", String.valueOf(obj[4]));
							dataMap.put("HxCropofferStr", String.valueOf(obj[5]));
							dataMap.put("OfferDate", String.valueOf(obj[6]));
							dataMap.put("Price", String.valueOf(obj[7]));
							dataMap.put("Unit", String.valueOf(obj[8]));
							dataMap.put("UnitName", String.valueOf(obj[9]));
							dataMap.put("todayTrend", String.valueOf(obj[10]));
							dataMap.put("fiveDayTrend", String.valueOf(obj[11]));
							dataMap.put("weekAverage", String.valueOf(obj[12]));
							dataMap.put("weekTrend", String.valueOf(obj[13]));
							dataMap.put("reason", String.valueOf(obj[14]));
							dataMap.put("weekAverage", String.valueOf(obj[15]));
							dataList.add(dataMap);
						}
					}
				}
			}else {
				//将String转list-品类
				String str[] = ibs.split(",");
				lists = Arrays.asList(str);
				for(int k = 0; k<lists.size(); k++) {
					hql = "SELECT *  FROM hx_cropoffer WHERE  CropCategoryCode = '"+lists.get(k)+"' ";
					//开始日期
					if( !CommonUtils.isEmpty(map.get("OfferDateStart")) && CommonUtils.isEmpty(map.get("OfferDateEnd")) ) {
						hql += " and offerDate = '"+map.get("OfferDateStart")+"'";
					}
					//时间段查询
					if(!CommonUtils.isEmpty(map.get("OfferDateEnd")) && !CommonUtils.isEmpty(map.get("OfferDateStart"))) {
						hql += " AND  OfferDate  between '"+map.get("OfferDateStart")+"' AND '"+map.get("OfferDateEnd")+"'";
					}
						hql +="GROUP  BY  OfferDate  asc limit 10 ";
					List list= queryListForPageIconBySQL( hql);
					System.out.println("list"+list);
					List<Map<String,String>> otherDataList=new ArrayList<Map<String,String>>();
					for(int j=0;j<list.size();j++){
						Map<String,String> dataMap=new HashMap<String,String>();
						Object[] obj=(Object[]) list.get(j);
						dataMap.put("HxCropofferID", String.valueOf(obj[0]));
						dataMap.put("RegionCode", String.valueOf(obj[1]));
						dataMap.put("RegionName", String.valueOf(obj[2]));
						dataMap.put("CropCategoryCode", String.valueOf(obj[3]));
						dataMap.put("CropCategoryName", String.valueOf(obj[4]));
						dataMap.put("HxCropofferStr", String.valueOf(obj[5]));
						dataMap.put("OfferDate", String.valueOf(obj[6]));
						dataMap.put("Price", String.valueOf(obj[7]));
						dataMap.put("Unit", String.valueOf(obj[8]));
						dataMap.put("UnitName", String.valueOf(obj[9]));
						dataMap.put("todayTrend", String.valueOf(obj[10]));
						dataMap.put("fiveDayTrend", String.valueOf(obj[11]));
						dataMap.put("weekAverage", String.valueOf(obj[12]));
						dataMap.put("weekTrend", String.valueOf(obj[13]));
						dataMap.put("reason", String.valueOf(obj[14]));
						dataMap.put("weekAverage", String.valueOf(obj[15]));
						dataList.add(dataMap);
					}
				}
			}
		}catch (Exception e) {
			throw new RuntimeException();  
		}
		
		return CommonUtils.getMarketPageIconJson(dataList);
	}
	
	
	/**
	 *查询HxCropoffer数据条数 
	 */ 
	public Long queryCount(HxCropoffer hxCropoffer) {
		String hql = "select count(*) from HxCropoffer where delete_flag = '0' ";
		return countByHql(hql,null);
	}
	
	@Override
	protected Class<HxCropoffer> getEntityClass() {
		return HxCropoffer.class;
	} 

}