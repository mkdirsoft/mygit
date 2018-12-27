package com.flx.flxoa.info.market.dao.impl;


import java.util.List;

import com.flx.flxoa.info.market.dao.HxDao;
import com.flx.flxoa.info.market.entity.Hx;
import org.springframework.stereotype.Repository;
import com.flx.flxoa.common.hibernate3.HibernateBaseDao;

/**
 *
 * 类名称：HxDaoImpl.java
 * 类描述：
 * 创建时间：2018-11-08, 下午03:05:40
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author leijun 
 */ 
@Repository
public class HxDaoImpl extends HibernateBaseDao<Hx, Integer> implements HxDao {
	/**
	 *添加Hx
	 */ 
	public boolean add(Hx hx) {
		return save(hx);
	}
	/**
	 *删除Hx
	 */ 
	public boolean delete(Hx hx) {
		hx.setDeleteFlag("1");
		return save(hx);
	}
	/**
	 *修改Hx
	 */ 
	public boolean update(Hx hx) {
		return modify(hx);
	}
	/**
	 *查询Hx列表
	 */ 
	public List<Hx> query(Hx hx) {
		String hql = " from Hx where delete_flag = '0' ";
		return getListByHQL(hql, null);
	}
	/**
	 *查询Hx ByID
	 */ 
//	public Hx queryById(Hx hx) {
//		return get(hx.getId());
//	}
	/**
	 *分页Hx pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<Hx> queryForPage(int pageNo,int pageSize,Hx hx) {
		String hql = " from Hx where delete_flag = '0' ";
		return queryForPageByHQL(pageNo, pageSize, hql);
	}
	/**
	 *查询Hx数据条数 
	 */ 
	public Long queryCount(Hx hx) {
		String hql = "select count(*) from Hx where delete_flag = '0' ";
		return countByHql(hql,null);
	}
	
	@Override
	protected Class<Hx> getEntityClass() {
		return Hx.class;
	} 

}