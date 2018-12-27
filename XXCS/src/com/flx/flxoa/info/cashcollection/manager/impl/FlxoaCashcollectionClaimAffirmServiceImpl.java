package com.flx.flxoa.info.cashcollection.manager.impl;


import java.util.List;
import com.flx.flxoa.info.cashcollection.entity.FlxoaCashcollectionClaimAffirm;
import com.flx.flxoa.info.cashcollection.manager.FlxoaCashcollectionClaimAffirmService;
import com.flx.flxoa.info.cashcollection.dao.FlxoaCashcollectionClaimAffirmDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * 类名称：FlxoaCashcollectionClaimAffirmServiceImpl.java
 * 类描述：
 * 创建时间：2018-03-23, 上午11:58:34
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 赵鹏辉 
 */ 
@Service
@Transactional
public class FlxoaCashcollectionClaimAffirmServiceImpl implements FlxoaCashcollectionClaimAffirmService {
	private FlxoaCashcollectionClaimAffirmDao dao;
	@Autowired
	public void setDao(FlxoaCashcollectionClaimAffirmDao dao) {
		this.dao = dao;
	}
	public FlxoaCashcollectionClaimAffirmDao getDao() {
		return dao;
	}
	
	/**
	 *添加FlxoaCashcollectionClaimAffirm
	 */ 
	public boolean add(FlxoaCashcollectionClaimAffirm flxoaCashcollectionClaimAffirm) {
		boolean result = dao.add(flxoaCashcollectionClaimAffirm);
		return result;
	}
	/**
	 *删除FlxoaCashcollectionClaimAffirm
	 */ 
	public boolean delete(FlxoaCashcollectionClaimAffirm flxoaCashcollectionClaimAffirm) {
		boolean result = dao.delete(flxoaCashcollectionClaimAffirm);
		return result;
	}
	/**
	 *修改FlxoaCashcollectionClaimAffirm
	 */ 
	public boolean update(FlxoaCashcollectionClaimAffirm flxoaCashcollectionClaimAffirm) {
		boolean result = dao.update(flxoaCashcollectionClaimAffirm);
		return result;
	}
	/**
	 *查询FlxoaCashcollectionClaimAffirm列表
	 */ 
	public List<FlxoaCashcollectionClaimAffirm> query(FlxoaCashcollectionClaimAffirm flxoaCashcollectionClaimAffirm) {
		List<FlxoaCashcollectionClaimAffirm> list = dao.query(flxoaCashcollectionClaimAffirm);
		return list;
	}
	/**
	 *查询FlxoaCashcollectionClaimAffirm ByID
	 */ 
	public FlxoaCashcollectionClaimAffirm queryById(FlxoaCashcollectionClaimAffirm flxoaCashcollectionClaimAffirm) {
		FlxoaCashcollectionClaimAffirm result = dao.queryById(flxoaCashcollectionClaimAffirm);
		return result;
	}
	/**
	 *分页FlxoaCashcollectionClaimAffirm pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<FlxoaCashcollectionClaimAffirm> queryForPage(int pageNo,int pageSize,FlxoaCashcollectionClaimAffirm flxoaCashcollectionClaimAffirm) {
		List<FlxoaCashcollectionClaimAffirm> list = dao.queryForPage(pageNo,pageSize,flxoaCashcollectionClaimAffirm);
		return list;
	}
	/**
	 *查询FlxoaCashcollectionClaimAffirm数据条数
	 */ 
	public Long queryCount(FlxoaCashcollectionClaimAffirm flxoaCashcollectionClaimAffirm) {
		Long result = dao.queryCount(flxoaCashcollectionClaimAffirm);
		return result;
	}
	/**
	 * 查询
	 * @param flxoaCashcollectionClaimAffirm
	 * @return
	 */
	public List<FlxoaCashcollectionClaimAffirm> queryByCaroId(FlxoaCashcollectionClaimAffirm flxoaCashcollectionClaimAffirm){
		List<FlxoaCashcollectionClaimAffirm> list = dao.queryByCaroId(flxoaCashcollectionClaimAffirm);
		return list;
	}
	
}