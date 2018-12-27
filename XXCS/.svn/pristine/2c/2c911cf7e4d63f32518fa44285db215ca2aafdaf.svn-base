package com.flx.flxoa.info.projectmanagement.dao.impl;


import java.util.List;
import com.flx.flxoa.info.projectmanagement.entity.FlxoaProjectBidRecord;
import com.flx.flxoa.info.projectmanagement.dao.FlxoaProjectBidRecordDao;
import org.springframework.stereotype.Repository;
import com.flx.flxoa.common.hibernate3.HibernateBaseDao;

/**
 *
 * 类名称：FlxoaProjectBidRecordDaoImpl.java
 * 类描述：
 * 创建时间：2018-03-21, 下午07:11:37
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 雷君 
 */ 
@Repository
public class FlxoaProjectBidRecordDaoImpl extends HibernateBaseDao<FlxoaProjectBidRecord, Integer> implements FlxoaProjectBidRecordDao {
	/**
	 *添加FlxoaProjectBidRecord
	 */ 
	public boolean add(FlxoaProjectBidRecord flxoaProjectBidRecord) {
		return save(flxoaProjectBidRecord);
	}
	/**
	 *删除FlxoaProjectBidRecord
	 */ 
	public boolean delete(FlxoaProjectBidRecord flxoaProjectBidRecord) {
		flxoaProjectBidRecord.setDeleteFlag("1");
		return save(flxoaProjectBidRecord);
	}
	/**
	 *修改FlxoaProjectBidRecord
	 */ 
	public boolean update(FlxoaProjectBidRecord flxoaProjectBidRecord) {
		return modify(flxoaProjectBidRecord);
	}
	/**
	 *查询FlxoaProjectBidRecord列表
	 */ 
	public List<FlxoaProjectBidRecord> query(FlxoaProjectBidRecord flxoaProjectBidRecord) {
		String hql = " from FlxoaProjectBidRecord where delete_flag = '0' and bid_id = '"+flxoaProjectBidRecord.getBidId()+"' order by id";
		return getListByHQL(hql, null);
	}
	/**
	 *查询FlxoaProjectBidRecord ByID
	 */ 
	public FlxoaProjectBidRecord queryById(FlxoaProjectBidRecord flxoaProjectBidRecord) {
		return get(flxoaProjectBidRecord.getId());
	}
	/**
	 *分页FlxoaProjectBidRecord pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<FlxoaProjectBidRecord> queryForPage(int pageNo,int pageSize,FlxoaProjectBidRecord flxoaProjectBidRecord) {
		String hql = " from FlxoaProjectBidRecord where delete_flag = '0' ";
		return queryForPageByHQL(pageNo, pageSize, hql);
	}
	/**
	 *查询FlxoaProjectBidRecord数据条数 
	 */ 
	public Long queryCount(FlxoaProjectBidRecord flxoaProjectBidRecord) {
		String hql = "select count(*) from FlxoaProjectBidRecord where delete_flag = '0' ";
		return countByHql(hql,null);
	}
	
	@Override
	protected Class<FlxoaProjectBidRecord> getEntityClass() {
		return FlxoaProjectBidRecord.class;
	} 

}