package com.flx.flxoa.info.cashcollection.dao.impl;


import java.util.List;
import com.flx.flxoa.info.cashcollection.entity.FlxoaProjectInvoiceCheck;
import com.flx.flxoa.info.cashcollection.dao.FlxoaProjectInvoiceCheckDao;
import org.springframework.stereotype.Repository;
import com.flx.flxoa.common.hibernate3.HibernateBaseDao;

/**
 *
 * 类名称：FlxoaProjectInvoiceCheckDaoImpl.java
 * 类描述：
 * 创建时间：2018-03-26, 下午03:32:57
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 赵鹏辉 
 */ 
@Repository
public class FlxoaProjectInvoiceCheckDaoImpl extends HibernateBaseDao<FlxoaProjectInvoiceCheck, Integer> implements FlxoaProjectInvoiceCheckDao {
	/**
	 *添加FlxoaProjectInvoiceCheck
	 */ 
	public boolean add(FlxoaProjectInvoiceCheck flxoaProjectInvoiceCheck) {
		return save(flxoaProjectInvoiceCheck);
	}
	@Override
	public boolean isExist(String username) {
		String hql="from FlxoaProjectInvoiceCheck where invoice_manager_id='"+username+"' ";
		List list=queryByHQL(hql);
		if(list.size()<1){
			return true;
		}
		return false;
	}
	/**
	 *删除FlxoaProjectInvoiceCheck
	 */ 
	public boolean delete(FlxoaProjectInvoiceCheck flxoaProjectInvoiceCheck) {
		flxoaProjectInvoiceCheck.setDeleteFlag("1");
		return save(flxoaProjectInvoiceCheck);
	}
	/**
	 *修改FlxoaProjectInvoiceCheck
	 */ 
	public boolean update(FlxoaProjectInvoiceCheck flxoaProjectInvoiceCheck) {
		return modify(flxoaProjectInvoiceCheck);
	}
	/**
	 *查询FlxoaProjectInvoiceCheck列表
	 */ 
	public List<FlxoaProjectInvoiceCheck> query(FlxoaProjectInvoiceCheck flxoaProjectInvoiceCheck) {
		String hql = " from FlxoaProjectInvoiceCheck where delete_flag = '0' ";
		return getListByHQL(hql, null);
	}
	/**
	 *查询FlxoaProjectInvoiceCheck ByID
	 */ 
	public FlxoaProjectInvoiceCheck queryById(FlxoaProjectInvoiceCheck flxoaProjectInvoiceCheck) {
		return get(flxoaProjectInvoiceCheck.getId());
	}
	/**
	 *分页FlxoaProjectInvoiceCheck pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<FlxoaProjectInvoiceCheck> queryForPage(int pageNo,int pageSize,FlxoaProjectInvoiceCheck flxoaProjectInvoiceCheck) {
		String hql = " from FlxoaProjectInvoiceCheck where delete_flag = '0' ";
		return queryForPageByHQL(pageNo, pageSize, hql);
	}
	/**
	 *查询FlxoaProjectInvoiceCheck数据条数 
	 */ 
	public Long queryCount(FlxoaProjectInvoiceCheck flxoaProjectInvoiceCheck) {
		String hql = "select count(*) from FlxoaProjectInvoiceCheck where delete_flag = '0' ";
		return countByHql(hql,null);
	}
	
	@Override
	protected Class<FlxoaProjectInvoiceCheck> getEntityClass() {
		return FlxoaProjectInvoiceCheck.class;
	} 

}