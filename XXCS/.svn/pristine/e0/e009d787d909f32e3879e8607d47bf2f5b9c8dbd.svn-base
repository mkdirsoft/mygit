package com.flx.flxoa.info.market.manager.impl;


import java.util.List;
import com.flx.flxoa.info.market.entity.HxEnum;
import com.flx.flxoa.info.market.manager.HxEnumService;
import com.flx.flxoa.info.market.dao.HxEnumDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * 类名称：HxEnumServiceImpl.java
 * 类描述：
 * 创建时间：2018-11-08, 下午03:35:06
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author leijun 
 */ 
@Service
@Transactional
public class HxEnumServiceImpl implements HxEnumService {
	private HxEnumDao dao;
	@Autowired
	public void setDao(HxEnumDao dao) {
		this.dao = dao;
	}
	public HxEnumDao getDao() {
		return dao;
	}
	/**
	 *添加HxEnum
	 */ 
	public boolean add(HxEnum hxEnum) {
		boolean result = dao.add(hxEnum);
		return result;
	}
	/**
	 *删除HxEnum
	 */ 
	public boolean delete(HxEnum hxEnum) {
		boolean result = dao.delete(hxEnum);
		return result;
	}
	/**
	 *修改HxEnum
	 */ 
	public boolean update(HxEnum hxEnum) {
		boolean result = dao.update(hxEnum);
		return result;
	}
	/**
	 *查询HxEnum列表
	 */ 
	public List<HxEnum> query(HxEnum hxEnum) {
		List<HxEnum> list = dao.query(hxEnum);
		return list;
	}
	/**
	 *查询HxEnum ByID
	 */ 
//	public HxEnum queryById(HxEnum hxEnum) {
//		HxEnum result = dao.queryById(hxEnum);
//		return result;
//	}
	/**
	 *分页HxEnum pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<HxEnum> queryForPage(int pageNo,int pageSize,HxEnum hxEnum) {
		List<HxEnum> list = dao.queryForPage(pageNo,pageSize,hxEnum);
		return list;
	}
	/**
	 *查询HxEnum数据条数
	 */ 
	public Long queryCount(HxEnum hxEnum) {
		Long result = dao.queryCount(hxEnum);
		return result;
	}

}