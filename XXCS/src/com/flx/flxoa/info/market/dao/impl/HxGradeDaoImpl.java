package com.flx.flxoa.info.market.dao.impl;


import java.util.List;

import com.flx.flxoa.info.market.dao.HxGradeDao;
import com.flx.flxoa.info.market.entity.HxGrade;
import org.springframework.stereotype.Repository;
import com.flx.flxoa.common.hibernate3.HibernateBaseDao;

/**
 *
 * 类名称：HxGradeDaoImpl.java
 * 类描述：
 * 创建时间：2018-11-08, 下午03:05:40
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author leijun 
 */ 
@Repository
public class HxGradeDaoImpl extends HibernateBaseDao<HxGrade, Integer> implements HxGradeDao {
	/**
	 *添加HxGrade
	 */ 
	public boolean add(HxGrade hxGrade) {
		return save(hxGrade);
	}
	/**
	 *删除HxGrade
	 */ 
	public boolean delete(HxGrade hxGrade) {
		hxGrade.setDeleteFlag("1");
		return save(hxGrade);
	}
	/**
	 *修改HxGrade
	 */ 
	public boolean update(HxGrade hxGrade) {
		return modify(hxGrade);
	}
	/**
	 *查询HxGrade列表
	 */ 
	public List<HxGrade> query(HxGrade hxGrade) {
		String hql = " from HxGrade where delete_flag = '0' ";
		return getListByHQL(hql, null);
	}
	/**
	 *查询HxGrade ByID
	 */ 
//	public HxGrade queryById(HxGrade hxGrade) {
//		return get(hxGrade.getId());
//	}
	/**
	 *分页HxGrade pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<HxGrade> queryForPage(int pageNo,int pageSize,HxGrade hxGrade) {
		String hql = " from HxGrade where delete_flag = '0' ";
		return queryForPageByHQL(pageNo, pageSize, hql);
	}
	/**
	 *查询HxGrade数据条数 
	 */ 
	public Long queryCount(HxGrade hxGrade) {
		String hql = "select count(*) from HxGrade where delete_flag = '0' ";
		return countByHql(hql,null);
	}
	
	@Override
	protected Class<HxGrade> getEntityClass() {
		return HxGrade.class;
	} 

}