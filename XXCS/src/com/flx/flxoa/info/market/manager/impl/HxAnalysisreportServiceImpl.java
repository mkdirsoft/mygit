package com.flx.flxoa.info.market.manager.impl;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flx.flxoa.info.market.dao.HxAnalysisreportDao;
import com.flx.flxoa.info.market.entity.HxAnalysisreport;
import com.flx.flxoa.info.market.manager.HxAnalysisreportService;

/**
 *
 * 类名称：HxAnalysisreportServiceImpl.java
 * 类描述：
 * 创建时间：2018-11-02, 上午11:02:11
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author leijun 
 */ 
@Service
@Transactional
public class HxAnalysisreportServiceImpl implements HxAnalysisreportService {
	private HxAnalysisreportDao dao;
	@Autowired
	public void setDao(HxAnalysisreportDao dao) {
		this.dao = dao;
	}
	public HxAnalysisreportDao getDao() {
		return dao;
	}
	/**
	 *添加HxAnalysisreport
	 */ 
	public boolean add(HxAnalysisreport hxAnalysisreport) {
		boolean result = dao.add(hxAnalysisreport);
		return result;
	}
	/**
	 *删除HxAnalysisreport
	 */ 
	public boolean delete(HxAnalysisreport hxAnalysisreport) {
		boolean result = dao.delete(hxAnalysisreport);
		return result;
	}
	/**
	 *修改HxAnalysisreport
	 */ 
	public boolean update(HxAnalysisreport hxAnalysisreport) {
		boolean result = dao.update(hxAnalysisreport);
		return result;
	}
	/**
	 *查询HxAnalysisreport列表
	 */ 
	public List<HxAnalysisreport> query(HxAnalysisreport hxAnalysisreport) {
		List<HxAnalysisreport> list = dao.query(hxAnalysisreport);
		return list;
	}
	/**
	 *查询HxAnalysisreport ByID
	 */ 
	public HxAnalysisreport queryById(HxAnalysisreport hxAnalysisreport) {
		HxAnalysisreport result = dao.queryById(hxAnalysisreport);
		return result;
	}
	/**
	 *分页HxAnalysisreport pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public String queryForPage(Map<String, String> map) {
		String list = dao.queryForPage(map);
		return list;
	}
	/**
	 *查询HxAnalysisreport数据条数
	 */ 
	public Long queryCount(HxAnalysisreport hxAnalysisreport) {
		Long result = dao.queryCount(hxAnalysisreport);
		return result;
	}

}