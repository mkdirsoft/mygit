package com.flx.flxoa.info.market.manager.impl;

import java.util.List;
import java.util.Map;

import com.flx.flxoa.info.market.entity.HxNews;
import com.flx.flxoa.info.market.manager.HxNewsService;
import com.flx.flxoa.info.market.dao.HxNewsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * 类名称：HxNewsServiceImpl.java
 * 类描述：
 * 创建时间：2018-11-08, 下午03:05:40
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author leijun 
 */ 
@Service
@Transactional
public class HxNewsServiceImpl implements HxNewsService {
	private HxNewsDao dao;
	@Autowired
	public void setDao(HxNewsDao dao) {
		this.dao = dao;
	}
	public HxNewsDao getDao() {
		return dao;
	}
	/**
	 *添加HxNews
	 */ 
	public boolean add(HxNews hxNews) {
		boolean result = dao.add(hxNews);
		return result;
	}
	/**
	 *删除HxNews
	 */ 
	public boolean delete(HxNews hxNews) {
		boolean result = dao.delete(hxNews);
		return result;
	}
	/**
	 *修改HxNews
	 */ 
	public boolean update(HxNews hxNews) {
		boolean result = dao.update(hxNews);
		return result;
	}
	/**
	 *查询HxNews列表
	 */ 
	public List<HxNews> query(HxNews hxNews) {
		List<HxNews> list = dao.query(hxNews);
		return list;
	}
	/**
	 *查询HxNews ByID
	 */ 
	public HxNews queryById(HxNews hxNews) {
		HxNews result = dao.queryById(hxNews);
		return result;
	}
	/**
	 *分页HxNews pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public String queryForPage(Map<String,String> map) {
		String list = dao.queryForPage(map);
		return list;
	}
	/**
	 *查询HxNews数据条数
	 */ 
	public Long queryCount(HxNews hxNews) {
		Long result = dao.queryCount(hxNews);
		return result;
	}

}