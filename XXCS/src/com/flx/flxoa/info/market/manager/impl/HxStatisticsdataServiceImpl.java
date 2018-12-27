package com.flx.flxoa.info.market.manager.impl;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flx.flxoa.info.market.dao.HxStatisticsdataDao;
import com.flx.flxoa.info.market.entity.HxStatisticsdata;
import com.flx.flxoa.info.market.manager.HxStatisticsdataService;


/**
 *
 * 类名称：HxStatisticsdataServiceImpl.java
 * 类描述：
 * 创建时间：2018-11-02, 上午11:02:11
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author leijun 
 */ 
@Service
@Transactional
public class HxStatisticsdataServiceImpl implements HxStatisticsdataService {
	private HxStatisticsdataDao dao;
	@Autowired
	public void setDao(HxStatisticsdataDao dao) {
		this.dao = dao;
	}
	public HxStatisticsdataDao getDao() {
		return dao;
	}
	/**
	 *添加HxStatisticsdata
	 */ 
	public boolean add(HxStatisticsdata hxStatisticsdata) {
		boolean result = dao.add(hxStatisticsdata);
		return result;
	}
	/**
	 *删除HxStatisticsdata
	 */ 
	public boolean delete(HxStatisticsdata hxStatisticsdata) {
		boolean result = dao.delete(hxStatisticsdata);
		return result;
	}
	/**
	 *修改HxStatisticsdata
	 */ 
	public boolean update(HxStatisticsdata hxStatisticsdata) {
		boolean result = dao.update(hxStatisticsdata);
		return result;
	}
	/**
	 *查询HxStatisticsdata列表
	 */ 
	public List<HxStatisticsdata> query(HxStatisticsdata hxStatisticsdata) {
		List<HxStatisticsdata> list = dao.query(hxStatisticsdata);
		return list;
	}
	/**
	 *查询HxStatisticsdata ByID
	 */ 
	public HxStatisticsdata queryById(HxStatisticsdata hxStatisticsdata) {
		HxStatisticsdata result = dao.queryById(hxStatisticsdata);
		return result;
	}
	/**
	 *分页HxStatisticsdata pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public String queryForPage(Map<String, String> map) {
		String list = dao.queryForPage(map);
		return list;
	}
	/**
	 *查询HxStatisticsdata数据条数
	 */ 
	public Long queryCount(HxStatisticsdata hxStatisticsdata) {
		Long result = dao.queryCount(hxStatisticsdata);
		return result;
	}

}