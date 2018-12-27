package com.flx.flxoa.info.market.manager.impl;

import java.util.List;
import com.flx.flxoa.info.market.entity.HxId;
import com.flx.flxoa.info.market.manager.HxIdService;
import com.flx.flxoa.info.market.dao.HxIdDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * 类名称：HxIdServiceImpl.java
 * 类描述：
 * 创建时间：2018-11-08, 下午03:05:40
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author leijun 
 */ 
@Service
@Transactional
public class HxIdServiceImpl implements HxIdService {
	private HxIdDao dao;
	@Autowired
	public void setDao(HxIdDao dao) {
		this.dao = dao;
	}
	public HxIdDao getDao() {
		return dao;
	}
	/**
	 *添加HxId
	 */ 
	public boolean add(HxId hxId) {
		boolean result = dao.add(hxId);
		return result;
	}
	/**
	 *删除HxId
	 */ 
	public boolean delete(HxId hxId) {
		boolean result = dao.delete(hxId);
		return result;
	}
	/**
	 *修改HxId
	 */ 
	public boolean update(HxId hxId) {
		boolean result = dao.update(hxId);
		return result;
	}
	/**
	 *查询HxId列表
	 */ 
	public List<HxId> query(HxId hxId) {
		List<HxId> list = dao.query(hxId);
		return list;
	}
	/**
	 *查询HxId ByID
	 */ 
//	public HxId queryById(HxId hxId) {
//		HxId result = dao.queryById(hxId);
//		return result;
//	}
	/**
	 *分页HxId pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<HxId> queryForPage(int pageNo,int pageSize,HxId hxId) {
		List<HxId> list = dao.queryForPage(pageNo,pageSize,hxId);
		return list;
	}
	/**
	 *查询HxId数据条数
	 */ 
	public Long queryCount(HxId hxId) {
		Long result = dao.queryCount(hxId);
		return result;
	}

}