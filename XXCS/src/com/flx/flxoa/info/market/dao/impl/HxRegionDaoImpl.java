package com.flx.flxoa.info.market.dao.impl;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.flx.flxoa.common.hibernate3.HibernateBaseDao;
import com.flx.flxoa.info.market.dao.HxRegionDao;
import com.flx.flxoa.info.market.entity.HxRegion;

/**
 *
 * 类名称：HxRegionDaoImpl.java
 * 类描述：
 * 创建时间：2018-11-02, 上午11:02:11
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author leijun 
 */ 
@Repository
public class HxRegionDaoImpl extends HibernateBaseDao<HxRegion, Integer> implements HxRegionDao {
	/**
	 *添加HxRegion
	 */ 
	public boolean add(HxRegion hxRegion) {
		return save(hxRegion);
	}
	/**
	 *删除HxRegion
	 */ 
	public boolean delete(HxRegion hxRegion) {
		hxRegion.setDeleteFlag("1");
		return save(hxRegion);
	}
	/**
	 *修改HxRegion
	 */ 
	public boolean update(HxRegion hxRegion) {
		return modify(hxRegion);
	}
	/**
	 *查询HxRegion列表
	 */ 
	public List<HxRegion> query(HxRegion hxRegion) {
		String sql = " from  HxRegion where 0 = '0' ";
		return getListByHQL(sql, null);
	}
	/**
	 *查询HxRegion ByID
	 */ 
	public HxRegion queryById(HxRegion hxRegion) {
		String hql = "  from HxRegion where regionCode = '"+hxRegion.getRegionCode()+"'  ";
		return getByHQL(hql,null);
	}
	/**
	 *分页HxRegion pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<HxRegion> queryForPage(int pageNo,int pageSize,HxRegion hxRegion) {
		String hql = " from HxRegion where delete_flag = '0' ";
		return queryForPageByHQL(pageNo, pageSize, hql);
	}
	/**
	 *查询HxRegion数据条数 
	 */ 
	public Long queryCount(HxRegion hxRegion) {
		String hql = "select count(*) from HxRegion where delete_flag = '0' ";
		return countByHql(hql,null);
	}
	
	@Override
	protected Class<HxRegion> getEntityClass() {
		return HxRegion.class;
	} 

}