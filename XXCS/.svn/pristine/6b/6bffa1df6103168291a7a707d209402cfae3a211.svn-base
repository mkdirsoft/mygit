package com.flx.flxoa.info.market.dao.impl;

import java.util.List;

import com.flx.flxoa.info.market.dao.HxEnumDao;
import com.flx.flxoa.info.market.entity.HxEnum;


import org.springframework.stereotype.Repository;
import com.flx.flxoa.common.hibernate3.HibernateBaseDao;

/**
 *
 * 类名称：HxEnumDaoImpl.java
 * 类描述：
 * 创建时间：2018-11-08, 下午03:35:06
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author leijun 
 */ 
@Repository
public class HxEnumDaoImpl extends HibernateBaseDao<HxEnum, Integer> implements HxEnumDao {
	/**
	 *添加HxEnum
	 */ 
	public boolean add(HxEnum hxEnum) {
		return save(hxEnum);
	}
	/**
	 *删除HxEnum
	 */ 
	public boolean delete(HxEnum hxEnum) {
		hxEnum.setDeleteFlag("1");
		return save(hxEnum);
	}
	/**
	 *修改HxEnum
	 */ 
	public boolean update(HxEnum hxEnum) {
		return modify(hxEnum);
	}
	/**
	 *查询HxEnum列表
	 */ 
	public List<HxEnum> query(HxEnum hxEnum) {
		String hql = " from HxEnum where delete_flag = '0' ";
		return getListByHQL(hql, null);
	}
	/**
	 *查询HxEnum ByID
	 */ 
//	public HxEnum queryById(HxEnum hxEnum) {
//		return get(hxEnum.getId());
//	}
	/**
	 *分页HxEnum pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<HxEnum> queryForPage(int pageNo,int pageSize,HxEnum hxEnum) {
		String hql = " from HxEnum where delete_flag = '0' ";
		return queryForPageByHQL(pageNo, pageSize, hql);
	}
	/**
	 *查询HxEnum数据条数 
	 */ 
	public Long queryCount(HxEnum hxEnum) {
		String hql = "select count(*) from HxEnum where delete_flag = '0' ";
		return countByHql(hql,null);
	}
	
	@Override
	protected Class<HxEnum> getEntityClass() {
		return HxEnum.class;
	} 

}