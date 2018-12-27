package com.flx.flxoa.info.market.dao.impl;


import java.util.List;

import com.flx.flxoa.info.market.dao.HxSourceDao;
import com.flx.flxoa.info.market.entity.HxSource;
import org.springframework.stereotype.Repository;
import com.flx.flxoa.common.hibernate3.HibernateBaseDao;

/**
 *
 * 类名称：HxSourceDaoImpl.java
 * 类描述：
 * 创建时间：2018-11-08, 下午03:05:40
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author leijun 
 */ 
@Repository
public class HxSourceDaoImpl extends HibernateBaseDao<HxSource, Integer> implements HxSourceDao {
	/**
	 *添加HxSource
	 */ 
	public boolean add(HxSource hxSource) {
		return save(hxSource);
	}
	/**
	 *删除HxSource
	 */ 
//	public boolean delete(HxSource hxSource) {
//		hxSource.setDeleteFlag("1");
//		return save(hxSource);
//	}
	/**
	 *修改HxSource
	 */ 
	public boolean update(HxSource hxSource) {
		return modify(hxSource);
	}
	/**
	 *查询HxSource列表
	 */ 
	public List<HxSource> query(HxSource hxSource) {
		String hql = " from HxSource where delete_flag = '0' ";
		return getListByHQL(hql, null);
	}
	@Override
	public boolean isExist(String username ,String UserID) {
		String hql="from HxSource where sourceCode='"+username+"' and UserID = '"+UserID+"' ";
		List list=queryByHQL(hql);
		if(list.size()<1){
			return true;
		}
		return false;
	} 
	/**
	 *查询HxSource ByID
	 */ 
	public HxSource queryById(HxSource hxSource) {
		String hql = "  from HxSource where sourceCode = '"+hxSource.getSourceCode()+"'    ";
		return getByHQL(hql,null);
	}
	/**
	 *分页HxSource pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<HxSource> queryForPage(int pageNo,int pageSize,HxSource hxSource) {
		String hql = " from HxSource where delete_flag = '0' ";
		return queryForPageByHQL(pageNo, pageSize, hql);
	}
	/**
	 *查询HxSource数据条数 
	 */ 
	public Long queryCount(HxSource hxSource) {
		String hql = "select count(*) from HxSource where delete_flag = '0' ";
		return countByHql(hql,null);
	}
	
	@Override
	protected Class<HxSource> getEntityClass() {
		return HxSource.class;
	} 

}