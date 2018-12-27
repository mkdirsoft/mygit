package com.flx.flxoa.info.system.dao.impl;


import java.util.List;

import com.flx.flxoa.info.cashcollection.entity.FlxoaCashcollectionRecord;
import com.flx.flxoa.info.system.entity.FlxoaAccessory;
import com.flx.flxoa.info.system.dao.FlxoaAccessoryDao;
import org.springframework.stereotype.Repository;
import com.flx.flxoa.common.hibernate3.HibernateBaseDao;

/**
 *
 * 类名称：FlxoaAccessoryDaoImpl.java
 * 类描述：
 * 创建时间：2018-05-09, 下午04:43:23
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 赵鹏辉 
 */ 
@Repository
public class FlxoaAccessoryDaoImpl extends HibernateBaseDao<FlxoaAccessory, Integer> implements FlxoaAccessoryDao {
	/**
	 *添加FlxoaAccessory
	 */ 
	public boolean add(FlxoaAccessory flxoaAccessory) {
		return save(flxoaAccessory);
	}
	/**
	 *删除FlxoaAccessory
	 */ 
	public boolean delete(FlxoaAccessory flxoaAccessory) {
		flxoaAccessory.setDeleteFlag("1");
		return save(flxoaAccessory);
	}
	/**
	 *修改FlxoaAccessory
	 */ 
	public boolean update(FlxoaAccessory flxoaAccessory) {
		return modify(flxoaAccessory);
	}
	/**
	 *查询FlxoaAccessory列表
	 */ 
	public List<FlxoaAccessory> query(FlxoaAccessory flxoaAccessory) {
		String hql = " from FlxoaAccessory where delete_flag = '0' ";
		return getListByHQL(hql, null);
	}
	/**
	 *查询FlxoaAccessory ByID
	 */ 
	public FlxoaAccessory queryById(FlxoaAccessory flxoaAccessory) {
		return get(flxoaAccessory.getId());
	}
	/**
	 *分页FlxoaAccessory pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<FlxoaAccessory> queryForPage(int pageNo,int pageSize,FlxoaAccessory flxoaAccessory) {
		String hql = " from FlxoaAccessory where delete_flag = '0' ";
		return queryForPageByHQL(pageNo, pageSize, hql);
	}
	/**
	 *查询FlxoaAccessory数据条数 
	 */ 
	public Long queryCount(FlxoaAccessory flxoaAccessory) {
		String hql = "select count(*) from FlxoaAccessory where delete_flag = '0' ";
		return countByHql(hql,null);
	}
	
	/**
	 * 附件记录
	 * @param projectId
	 * @return
	 */
	public List<FlxoaAccessory> fujianRecord(String invoiceManagerId) {
		String hql = " from FlxoaAccessory where delete_flag = '0' and source_id=? ";
		Object [] obj = {invoiceManagerId};
		return getListByHQL(hql, obj);
	}
	
	@Override
	protected Class<FlxoaAccessory> getEntityClass() {
		return FlxoaAccessory.class;
	} 

}