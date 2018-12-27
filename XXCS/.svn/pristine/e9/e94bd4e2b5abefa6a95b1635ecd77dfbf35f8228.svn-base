package com.flx.flxoa.info.market.dao.impl;


import java.util.List;

import com.flx.flxoa.info.market.dao.HxSyslogDao;
import com.flx.flxoa.info.market.entity.HxSyslog;


import org.springframework.stereotype.Repository;
import com.flx.flxoa.common.hibernate3.HibernateBaseDao;

/**
 *
 * 类名称：HxSyslogDaoImpl.java
 * 类描述：
 * 创建时间：2018-11-08, 下午03:30:30
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author leijun 
 */ 
@Repository
public class HxSyslogDaoImpl extends HibernateBaseDao<HxSyslog, Integer> implements HxSyslogDao {
	/**
	 *添加HxSyslog
	 */ 
	public boolean add(HxSyslog hxSyslog) {
		return save(hxSyslog);
	}
	/**
	 *删除HxSyslog
	 */ 
	public boolean delete(HxSyslog hxSyslog) {
		hxSyslog.setDeleteFlag("1");
		return save(hxSyslog);
	}
	/**
	 *修改HxSyslog
	 */ 
	public boolean update(HxSyslog hxSyslog) {
		return modify(hxSyslog);
	}
	/**
	 *查询HxSyslog列表
	 */ 
	public List<HxSyslog> query(HxSyslog hxSyslog) {
		String hql = " from HxSyslog where delete_flag = '0' ";
		return getListByHQL(hql, null);
	}
	/**
	 *查询HxSyslog ByID
	 */ 
//	public HxSyslog queryById(HxSyslog hxSyslog) {
//		return get(hxSyslog.getId());
//	}
	/**
	 *分页HxSyslog pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<HxSyslog> queryForPage(int pageNo,int pageSize,HxSyslog hxSyslog) {
		String hql = " from HxSyslog where delete_flag = '0' ";
		return queryForPageByHQL(pageNo, pageSize, hql);
	}
	/**
	 *查询HxSyslog数据条数 
	 */ 
	public Long queryCount(HxSyslog hxSyslog) {
		String hql = "select count(*) from HxSyslog where delete_flag = '0' ";
		return countByHql(hql,null);
	}
	
	@Override
	protected Class<HxSyslog> getEntityClass() {
		return HxSyslog.class;
	} 

}