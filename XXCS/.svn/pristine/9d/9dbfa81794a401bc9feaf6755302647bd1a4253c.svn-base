package com.flx.flxoa.info.market.manager.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flx.flxoa.info.market.dao.HxPersonalsubscriptionsdelDao;
import com.flx.flxoa.info.market.entity.HxPersonalsubscriptionsdel;
import com.flx.flxoa.info.market.manager.HxPersonalsubscriptionsdelService;



/**
 *
 * 类名称：HxPersonalsubscriptionsdelServiceImpl.java
 * 类描述：
 * 创建时间：2018-11-15, 下午03:17:08
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author leijun 
 */ 
@Service
@Transactional
public class HxPersonalsubscriptionsdelServiceImpl implements HxPersonalsubscriptionsdelService {
	private HxPersonalsubscriptionsdelDao dao;
	@Autowired
	public void setDao(HxPersonalsubscriptionsdelDao dao) {
		this.dao = dao;
	}
	public HxPersonalsubscriptionsdelDao getDao() {
		return dao;
	}
	/**
	 *添加HxPersonalsubscriptionsdel
	 */ 
	public boolean add(HxPersonalsubscriptionsdel hxPersonalsubscriptionsdel) {
		boolean result = dao.add(hxPersonalsubscriptionsdel);
		return result;
	}
	/**
	 *删除HxPersonalsubscriptionsdel
	 */ 
	public boolean delete(HxPersonalsubscriptionsdel hxPersonalsubscriptionsdel) {
		boolean result = dao.delete(hxPersonalsubscriptionsdel);
		return result;
	}
	/**
	 *修改HxPersonalsubscriptionsdel
	 */ 
	public boolean update(HxPersonalsubscriptionsdel hxPersonalsubscriptionsdel) {
		boolean result = dao.update(hxPersonalsubscriptionsdel);
		return result;
	}
	/**
	 *查询HxPersonalsubscriptionsdel列表
	 */ 
	public List<HxPersonalsubscriptionsdel> query(HxPersonalsubscriptionsdel hxPersonalsubscriptionsdel) {
		List<HxPersonalsubscriptionsdel> list = dao.query(hxPersonalsubscriptionsdel);
		return list;
	}
	/**
	 *查询HxPersonalsubscriptionsdel ByID
	 */ 
	public HxPersonalsubscriptionsdel queryById(HxPersonalsubscriptionsdel hxPersonalsubscriptionsdel) {
		HxPersonalsubscriptionsdel result = dao.queryById(hxPersonalsubscriptionsdel);
		return result;
	}
	/**
	 *分页HxPersonalsubscriptionsdel pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<HxPersonalsubscriptionsdel> queryForPage(int pageNo,int pageSize,HxPersonalsubscriptionsdel hxPersonalsubscriptionsdel) {
		List<HxPersonalsubscriptionsdel> list = dao.queryForPage(pageNo,pageSize,hxPersonalsubscriptionsdel);
		return list;
	}
	/**
	 *查询HxPersonalsubscriptionsdel数据条数
	 */ 
	public Long queryCount(HxPersonalsubscriptionsdel hxPersonalsubscriptionsdel) {
		Long result = dao.queryCount(hxPersonalsubscriptionsdel);
		return result;
	}

}