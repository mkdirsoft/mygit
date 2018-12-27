package com.flx.flxoa.info.market.dao.impl;


import java.util.List;

import com.flx.flxoa.info.market.dao.HxNewscategoryDao;
import com.flx.flxoa.info.market.entity.HxNewscategory;
import org.springframework.stereotype.Repository;
import com.flx.flxoa.common.hibernate3.HibernateBaseDao;

/**
 *
 * 类名称：HxNewscategoryDaoImpl.java
 * 类描述：
 * 创建时间：2018-11-08, 下午03:05:40
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author leijun 
 */ 
@Repository
public class HxNewscategoryDaoImpl extends HibernateBaseDao<HxNewscategory, Integer> implements HxNewscategoryDao {
	/**
	 *添加HxNewscategory
	 */ 
	public boolean add(HxNewscategory hxNewscategory) {
		return save(hxNewscategory);
	}
	/**
	 *删除HxNewscategory
	 */ 
	public boolean delete(HxNewscategory hxNewscategory) {
		hxNewscategory.setDeleteFlag("1");
		return save(hxNewscategory);
	}
	/**
	 *修改HxNewscategory
	 */ 
	public boolean update(HxNewscategory hxNewscategory) {
		return modify(hxNewscategory);
	}
	/**
	 *查询HxNewscategory列表
	 */ 
	public List<HxNewscategory> query(HxNewscategory hxNewscategory) {
		String hql = " from HxNewscategory where delete_flag = '0' ";
		return getListByHQL(hql, null);
	}
	/**
	 *查询HxNewscategory ByID
	 */ 
//	public HxNewscategory queryById(HxNewscategory hxNewscategory) {
//		return get(hxNewscategory.getId());
//	}
	/**
	 *分页HxNewscategory pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<HxNewscategory> queryForPage(int pageNo,int pageSize,HxNewscategory hxNewscategory) {
		String hql = " from HxNewscategory where delete_flag = '0' ";
		return queryForPageByHQL(pageNo, pageSize, hql);
	}
	/**
	 *查询HxNewscategory数据条数 
	 */ 
	public Long queryCount(HxNewscategory hxNewscategory) {
		String hql = "select count(*) from HxNewscategory where delete_flag = '0' ";
		return countByHql(hql,null);
	}
	
	@Override
	protected Class<HxNewscategory> getEntityClass() {
		return HxNewscategory.class;
	} 

}