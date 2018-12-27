package com.flx.flxoa.info.cashcollection.dao.impl;


import java.util.List;
import com.flx.flxoa.info.cashcollection.entity.FlxoaCashcollectionClaimAffirm;
import com.flx.flxoa.info.cashcollection.dao.FlxoaCashcollectionClaimAffirmDao;
import org.springframework.stereotype.Repository;
import com.flx.flxoa.common.hibernate3.HibernateBaseDao;

/**
 *
 * 类名称：FlxoaCashcollectionClaimAffirmDaoImpl.java
 * 类描述：
 * 创建时间：2018-03-23, 上午11:58:34
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 赵鹏辉 
 */ 
@Repository
public class FlxoaCashcollectionClaimAffirmDaoImpl extends HibernateBaseDao<FlxoaCashcollectionClaimAffirm, Integer> implements FlxoaCashcollectionClaimAffirmDao {
	/**
	 *添加FlxoaCashcollectionClaimAffirm
	 */ 
	public boolean add(FlxoaCashcollectionClaimAffirm flxoaCashcollectionClaimAffirm) {
		return save(flxoaCashcollectionClaimAffirm);
	}
	/**
	 *删除FlxoaCashcollectionClaimAffirm
	 */ 
	public boolean delete(FlxoaCashcollectionClaimAffirm flxoaCashcollectionClaimAffirm) {
		flxoaCashcollectionClaimAffirm.setDeleteFlag("1");
		return save(flxoaCashcollectionClaimAffirm);
	}
	/**
	 *修改FlxoaCashcollectionClaimAffirm
	 */ 
	public boolean update(FlxoaCashcollectionClaimAffirm flxoaCashcollectionClaimAffirm) {
		return modify(flxoaCashcollectionClaimAffirm);
	}
	/**
	 *查询FlxoaCashcollectionClaimAffirm列表
	 */ 
	public List<FlxoaCashcollectionClaimAffirm> query(FlxoaCashcollectionClaimAffirm flxoaCashcollectionClaimAffirm) {
		String hql = " from FlxoaCashcollectionClaimAffirm where delete_flag = '0' ";
		return getListByHQL(hql, null);
	}
	/**
	 *查询FlxoaCashcollectionClaimAffirm ByID
	 */ 
	public FlxoaCashcollectionClaimAffirm queryById(FlxoaCashcollectionClaimAffirm flxoaCashcollectionClaimAffirm) {
		return get(flxoaCashcollectionClaimAffirm.getId());
	}
	/**
	 *分页FlxoaCashcollectionClaimAffirm pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<FlxoaCashcollectionClaimAffirm> queryForPage(int pageNo,int pageSize,FlxoaCashcollectionClaimAffirm flxoaCashcollectionClaimAffirm) {
		String hql = " from FlxoaCashcollectionClaimAffirm where delete_flag = '0' ";
		return queryForPageByHQL(pageNo, pageSize, hql);
	}
	/**
	 *查询FlxoaCashcollectionClaimAffirm数据条数 
	 */ 
	public Long queryCount(FlxoaCashcollectionClaimAffirm flxoaCashcollectionClaimAffirm) {
		String hql = "select count(*) from FlxoaCashcollectionClaimAffirm where delete_flag = '0' ";
		return countByHql(hql,null);
	}
	
	/**
	 *查询FlxoaCashcollectionClaimAffirm列表
	 */ 
	public List<FlxoaCashcollectionClaimAffirm> queryByCaroId(FlxoaCashcollectionClaimAffirm flxoaCashcollectionClaimAffirm) {
		String hql = " from FlxoaCashcollectionClaimAffirm where delete_flag = '0' and caro_id=?";
		Object []obj={flxoaCashcollectionClaimAffirm.getCaroId()};
		return getListByHQL(hql, null);
	}
	@Override
	protected Class<FlxoaCashcollectionClaimAffirm> getEntityClass() {
		return FlxoaCashcollectionClaimAffirm.class;
	} 

}