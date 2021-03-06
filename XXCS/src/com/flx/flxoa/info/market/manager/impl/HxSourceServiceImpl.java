package com.flx.flxoa.info.market.manager.impl;

import java.util.List;
import com.flx.flxoa.info.market.entity.HxSource;
import com.flx.flxoa.info.market.manager.HxSourceService;
import com.flx.flxoa.info.market.dao.HxSourceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * 类名称：HxSourceServiceImpl.java
 * 类描述：
 * 创建时间：2018-11-08, 下午03:05:40
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author leijun 
 */ 
@Service
@Transactional
public class HxSourceServiceImpl implements HxSourceService {
	private HxSourceDao dao;
	@Autowired
	public void setDao(HxSourceDao dao) {
		this.dao = dao;
	}
	public HxSourceDao getDao() {
		return dao;
	}
	/**
	 *添加HxSource
	 */ 
	public boolean add(HxSource hxSource) {
		boolean result = dao.add(hxSource);
		return result;
	}
	/**
	 *删除HxSource
	 */ 
//	public boolean delete(HxSource hxSource) {
//		boolean result = dao.delete(hxSource);
//		return result;
//	}
	/**
	 *修改HxSource
	 */ 
	public boolean update(HxSource hxSource) {
		boolean result = dao.update(hxSource);
		return result;
	}
	/**
	 *查询HxSource列表
	 */ 
	public List<HxSource> query(HxSource hxSource) {
		List<HxSource> list = dao.query(hxSource);
		return list;
	}
	
	@Override
	public boolean isExist(String username,String UserID) {
		boolean result = dao.isExist(username,UserID);
		
		return result;
	}
	/**
	 *查询HxSource ByID
	 */ 
	public HxSource queryById(HxSource hxSource) {
		HxSource result = dao.queryById(hxSource);
		return result;
	}
	/**
	 *分页HxSource pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<HxSource> queryForPage(int pageNo,int pageSize,HxSource hxSource) {
		List<HxSource> list = dao.queryForPage(pageNo,pageSize,hxSource);
		return list;
	}
	/**
	 *查询HxSource数据条数
	 */ 
	public Long queryCount(HxSource hxSource) {
		Long result = dao.queryCount(hxSource);
		return result;
	}

}