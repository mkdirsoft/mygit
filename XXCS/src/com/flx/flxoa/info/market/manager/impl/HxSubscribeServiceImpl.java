package com.flx.flxoa.info.market.manager.impl;

import java.util.List;
import java.util.Map;

import com.flx.flxoa.info.market.entity.HxSubscribe;
import com.flx.flxoa.info.market.manager.HxSubscribeService;
import com.flx.flxoa.info.market.dao.HxSubscribeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * 类名称：HxSubscribeServiceImpl.java
 * 类描述：
 * 创建时间：2018-11-08, 下午03:05:40
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author leijun 
 */ 
@Service
@Transactional
public class HxSubscribeServiceImpl implements HxSubscribeService {
	private HxSubscribeDao dao;
	@Autowired
	public void setDao(HxSubscribeDao dao) {
		this.dao = dao;
	}
	public HxSubscribeDao getDao() {
		return dao;
	}
	/**
	 *添加HxSubscribe
	 */ 
	public boolean add(HxSubscribe hxSubscribe) {
		boolean result = dao.add(hxSubscribe);
		return result;
	}
	/**
	 *查询HxSubscribe
	 */ 
	@Override
	public boolean isExist(String userID,String RegionCodeID,String CropCategoryID) {
		boolean result = dao.isExist(userID,RegionCodeID,CropCategoryID);
		
		return result;
	}
	/**
	 *删除HxSubscribe
	 */ 
	public boolean delete(HxSubscribe hxSubscribe) {
		boolean result = dao.delete(hxSubscribe);
		return result;
	}
	/**
	 *修改HxSubscribe
	 */ 
	public boolean update(HxSubscribe hxSubscribe) {
		boolean result = dao.update(hxSubscribe);
		return result;
	}
	/**
	 *查询HxSubscribe列表
	 */ 
	public List<HxSubscribe> query(HxSubscribe hxSubscribe) {
		List<HxSubscribe> list = dao.query(hxSubscribe);
		return list;
	}
	/**
	 *查询HxSubscribe ByID
	 */ 
//	public HxSubscribe queryById(HxSubscribe hxSubscribe) {
//		HxSubscribe result = dao.queryById(hxSubscribe);
//		return result;
//	}
	/**
	 *分页HxSubscribe pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public String queryForPage(Map<String,String> map) {
		String list = dao.queryForPage(map);
		return list;
	}
	/**
	 *查询HxSubscribe数据条数
	 */ 
	public Long queryCount(HxSubscribe hxSubscribe) {
		Long result = dao.queryCount(hxSubscribe);
		return result;
	}

}