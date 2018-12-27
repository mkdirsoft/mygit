package com.flx.flxoa.info.market.dao.impl;


import java.util.List;

import com.flx.flxoa.info.market.dao.HxIdDao;
import com.flx.flxoa.info.market.entity.HxId;
import org.springframework.stereotype.Repository;
import com.flx.flxoa.common.hibernate3.HibernateBaseDao;

/**
 *
 * 类名称：HxIdDaoImpl.java
 * 类描述：
 * 创建时间：2018-11-08, 下午03:05:40
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author leijun 
 */ 
@Repository
public class HxIdDaoImpl extends HibernateBaseDao<HxId, Integer> implements HxIdDao {
	/**
	 *添加HxId
	 */ 
	public boolean add(HxId hxId) {
		return save(hxId);
	}
	/**
	 *删除HxId
	 */ 
	public boolean delete(HxId hxId) {
		hxId.setDeleteFlag("1");
		return save(hxId);
	}
	/**
	 *修改HxId
	 */ 
	public boolean update(HxId hxId) {
		return modify(hxId);
	}
	/**
	 *查询HxId列表
	 */ 
	public List<HxId> query(HxId hxId) {
		String hql = " from HxId where delete_flag = '0' ";
		return getListByHQL(hql, null);
	}
	/**
	 *查询HxId ByID
	 */ 
//	public HxId queryById(HxId hxId) {
//		return get(hxId.getId());
//	}
	/**
	 *分页HxId pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<HxId> queryForPage(int pageNo,int pageSize,HxId hxId) {
		String hql = " from HxId where delete_flag = '0' ";
		return queryForPageByHQL(pageNo, pageSize, hql);
	}
	/**
	 *查询HxId数据条数 
	 */ 
	public Long queryCount(HxId hxId) {
		String hql = "select count(*) from HxId where delete_flag = '0' ";
		return countByHql(hql,null);
	}
	
	@Override
	protected Class<HxId> getEntityClass() {
		return HxId.class;
	} 

}