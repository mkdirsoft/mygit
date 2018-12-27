package com.flx.flxoa.info.market.dao.impl;


import java.util.List;

import com.flx.flxoa.info.market.dao.HxPersonalsubscriptionsdelDao;
import com.flx.flxoa.info.market.entity.HxPersonalsubscriptionsdel;
import org.springframework.stereotype.Repository;
import com.flx.flxoa.common.hibernate3.HibernateBaseDao;

/**
 *
 * 类名称：HxPersonalsubscriptionsdelDaoImpl.java
 * 类描述：
 * 创建时间：2018-11-15, 下午03:17:08
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author leijun 
 */ 
@Repository
public class HxPersonalsubscriptionsdelDaoImpl extends HibernateBaseDao<HxPersonalsubscriptionsdel, Integer> implements HxPersonalsubscriptionsdelDao {
	/**
	 *添加HxPersonalsubscriptionsdel
	 */ 
	public boolean add(HxPersonalsubscriptionsdel hxPersonalsubscriptionsdel) {
		return save(hxPersonalsubscriptionsdel);
	}
	/**
	 *删除HxPersonalsubscriptionsdel
	 */ 
	public boolean delete(HxPersonalsubscriptionsdel hxPersonalsubscriptionsdel) {
		String sql = "delete from hx_personalsubscriptionsdel where subscribeCode = '"+hxPersonalsubscriptionsdel.getCropOfferCode()+"' and UserID ='"+hxPersonalsubscriptionsdel.getUserId()+"'";
		executeSql(sql);
		return true;
	}
	/**
	 *修改HxPersonalsubscriptionsdel
	 */ 
	public boolean update(HxPersonalsubscriptionsdel hxPersonalsubscriptionsdel) {
		return modify(hxPersonalsubscriptionsdel);
	}
	/**
	 *查询HxPersonalsubscriptionsdel列表
	 */ 
	public List<HxPersonalsubscriptionsdel> query(HxPersonalsubscriptionsdel hxPersonalsubscriptionsdel) {
		String hql = " from HxPersonalsubscriptionsdel where subscribeCode = '"+hxPersonalsubscriptionsdel.getSubscribeCode()+"' ";
		return getListByHQL(hql, null);
	}
	/**
	 *查询HxPersonalsubscriptionsdel ByID
	 */ 
	public HxPersonalsubscriptionsdel queryById(HxPersonalsubscriptionsdel hxPersonalsubscriptionsdel) {
		return get(hxPersonalsubscriptionsdel.getId());
	}
	/**
	 *分页HxPersonalsubscriptionsdel pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<HxPersonalsubscriptionsdel> queryForPage(int pageNo,int pageSize,HxPersonalsubscriptionsdel hxPersonalsubscriptionsdel) {
		String hql = " from HxPersonalsubscriptionsdel where delete_flag = '0' ";
		return queryForPageByHQL(pageNo, pageSize, hql);
	}
	/**
	 *查询HxPersonalsubscriptionsdel数据条数 
	 */ 
	public Long queryCount(HxPersonalsubscriptionsdel hxPersonalsubscriptionsdel) {
		String hql = "select count(*) from HxPersonalsubscriptionsdel where delete_flag = '0' ";
		return countByHql(hql,null);
	}
	
	@Override
	protected Class<HxPersonalsubscriptionsdel> getEntityClass() {
		return HxPersonalsubscriptionsdel.class;
	} 

}