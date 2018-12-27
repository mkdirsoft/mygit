package com.flx.flxoa.info.market.manager.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flx.flxoa.info.market.dao.HxCropofferDao;
import com.flx.flxoa.info.market.entity.HxCropoffer;
import com.flx.flxoa.info.market.manager.HxCropofferService;


/**
 *
 * 类名称：HxCropofferServiceImpl.java
 * 类描述：
 * 创建时间：2018-11-01, 下午04:26:12
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author leijun 
 */ 
@Service
@Transactional
public class HxCropofferServiceImpl implements HxCropofferService {
	private HxCropofferDao dao;
	@Autowired
	public void setDao(HxCropofferDao dao) {
		this.dao = dao;
	}
	public HxCropofferDao getDao() {
		return dao;
	}
	/**
	 *添加HxCropoffer
	 */ 
	public boolean add(HxCropoffer hxCropoffer) {
		boolean result = dao.add(hxCropoffer);
		return result;
	}
	/**
	 *删除HxCropoffer
	 */ 
	public boolean delete(HxCropoffer hxCropoffer) {
		boolean result = dao.delete(hxCropoffer);
		return result;
	}
	/**
	 *修改HxCropoffer
	 */ 
	public boolean update(HxCropoffer hxCropoffer) {
		boolean result = dao.update(hxCropoffer);
		return result;
	}
	/**
	 *查询HxCropoffer列表 
	 */ 
	public List<HxCropoffer> query(HxCropoffer hxCropoffer) {
		List<HxCropoffer> list = dao.query(hxCropoffer);
		return list;
	}
	/**
	 *分页HxCropoffer pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public String queryWheel(Map<String,String> map) {
		String list = dao.queryWheel(map);
		return list;
	}
	/**
	 *查询HxCropoffer ByID
	 */ 
	public HxCropoffer queryById(HxCropoffer hxCropoffer) {
		HxCropoffer result = dao.queryById(hxCropoffer);
		return result;
	}
	/**
	 *分页HxCropoffer pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public String queryForPage(Map<String,String> map) {
		String list = dao.queryForPage(map);
		return list;
	}
	/**
	 *分页HxCropoffer pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public String queryForPageIcon(Map<String,String> map) {
		String list = dao.queryForPageIcon(map);
		return list;
	}
	/**
	 *查询HxCropoffer数据条数
	 */ 
	public Long queryCount(HxCropoffer hxCropoffer) {
		Long result = dao.queryCount(hxCropoffer);
		return result;
	}

}