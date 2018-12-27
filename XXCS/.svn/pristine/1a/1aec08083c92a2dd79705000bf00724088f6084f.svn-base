package com.flx.flxoa.info.market.manager.impl;

import java.util.List;
import com.flx.flxoa.info.market.entity.Hx;
import com.flx.flxoa.info.market.manager.HxService;
import com.flx.flxoa.info.market.dao.HxDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * 类名称：HxServiceImpl.java
 * 类描述：
 * 创建时间：2018-11-08, 下午03:05:40
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author leijun 
 */ 
@Service
@Transactional
public class HxServiceImpl implements HxService {
	private HxDao dao;
	@Autowired
	public void setDao(HxDao dao) {
		this.dao = dao;
	}
	public HxDao getDao() {
		return dao;
	}
	/**
	 *添加Hx
	 */ 
	public boolean add(Hx hx) {
		boolean result = dao.add(hx);
		return result;
	}
	/**
	 *删除Hx
	 */ 
	public boolean delete(Hx hx) {
		boolean result = dao.delete(hx);
		return result;
	}
	/**
	 *修改Hx
	 */ 
	public boolean update(Hx hx) {
		boolean result = dao.update(hx);
		return result;
	}
	/**
	 *查询Hx列表
	 */ 
	public List<Hx> query(Hx hx) {
		List<Hx> list = dao.query(hx);
		return list;
	}
	/**
	 *查询Hx ByID
	 */ 
//	public Hx queryById(Hx hx) {
//		Hx result = dao.queryById(hx);
//		return result;
//	}
	/**
	 *分页Hx pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<Hx> queryForPage(int pageNo,int pageSize,Hx hx) {
		List<Hx> list = dao.queryForPage(pageNo,pageSize,hx);
		return list;
	}
	/**
	 *查询Hx数据条数
	 */ 
	public Long queryCount(Hx hx) {
		Long result = dao.queryCount(hx);
		return result;
	}

}