package com.flx.flxoa.info.market.dao.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.flx.flxoa.common.hibernate3.HibernateBaseDao;
import com.flx.flxoa.common.util.CommonUtils;
import com.flx.flxoa.info.market.dao.HxCropcategoryDao;
import com.flx.flxoa.info.market.entity.HxCropcategory;

/**
 *
 * 类名称：HxCropcategoryDaoImpl.java
 * 类描述：
 * 创建时间：2018-11-02, 上午11:02:11
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author leijun 
 */ 
@Repository
public class HxCropcategoryDaoImpl extends HibernateBaseDao<HxCropcategory, Integer> implements HxCropcategoryDao {
	/**
	 *添加HxCropcategory
	 */ 
	public boolean add(HxCropcategory hxCropcategory) {
		return save(hxCropcategory);
	}
	/**
	 *删除HxCropcategory
	 */ 
	public boolean delete(HxCropcategory hxCropcategory) {
		hxCropcategory.setDeleteFlag("1");
		return save(hxCropcategory);
	}
	/**
	 *修改HxCropcategory
	 */ 
	public boolean update(HxCropcategory hxCropcategory) {
		return modify(hxCropcategory);
	}
	/**
	 *查询HxCropcategory列表
	 */ 
	public List<HxCropcategory> query(HxCropcategory hxCropcategory) {
		String hql = "  from  HxCropcategory where 0 = '0' ";
		return getListByHQL(hql, null);
	}
	/**
	 *查询HxCropcategory ByID
	 */ 
	public HxCropcategory queryById(HxCropcategory hxCropcategory) {
		String hql = "  from HxCropcategory where cropCategoryCode = '"+hxCropcategory.getCropCategoryCode()+"'    ";
		return getByHQL(hql,null);
	}
	/**
	 *分页HxCropcategory pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<HxCropcategory> queryForPage1(int pageNo,int pageSize,HxCropcategory hxCropcategory) {
		String hql = " from HxCropcategory where delete_flag = '0' ";
		return queryForPageByHQL(pageNo, pageSize, hql);
	}
	/**
	 *油脂油料-营养词料等热门品种JSON
	 */ 
	@SuppressWarnings("unchecked")
	public String queryForPage(Map<String,String> map) {
		String  yingyanghql = "select * from hx_cropcategory where CropCategoryType = '营养词料'";
		String  youzhiremenhql = "select * from hx_cropcategory where CropCategoryType = '油脂油料-热门品种'";
		String  youzhiyouchanghql = "select * from hx_cropcategory where CropCategoryType = '油脂油料-油厂报价'";
		List  yingyangHqlList = getListBySQL(yingyanghql, null);
		List  youzhiremenHqlList = getListBySQL(youzhiremenhql, null);
		List  youzhiyouchangHqlList = getListBySQL(youzhiyouchanghql, null);
		return CommonUtils.getCropCategoryJson(yingyangHqlList,youzhiremenHqlList,youzhiyouchangHqlList);
	}
	/**
	 *查询HxCropcategory数据条数 
	 */ 
	public Long queryCount(HxCropcategory hxCropcategory) {
		String hql = "select count(*) from HxCropcategory where delete_flag = '0' ";
		return countByHql(hql,null);
	}
	
	@Override
	protected Class<HxCropcategory> getEntityClass() {
		return HxCropcategory.class;
	} 

}