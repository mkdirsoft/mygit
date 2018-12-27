package com.flx.flxoa.info.market.manager.impl;

import java.util.List;
import com.flx.flxoa.info.market.entity.HxGrade;
import com.flx.flxoa.info.market.manager.HxGradeService;
import com.flx.flxoa.info.market.dao.HxGradeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * 类名称：HxGradeServiceImpl.java
 * 类描述：
 * 创建时间：2018-11-08, 下午03:05:40
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author leijun 
 */ 
@Service
@Transactional
public class HxGradeServiceImpl implements HxGradeService {
	private HxGradeDao dao;
	@Autowired
	public void setDao(HxGradeDao dao) {
		this.dao = dao;
	}
	public HxGradeDao getDao() {
		return dao;
	}
	/**
	 *添加HxGrade
	 */ 
	public boolean add(HxGrade hxGrade) {
		boolean result = dao.add(hxGrade);
		return result;
	}
	/**
	 *删除HxGrade
	 */ 
	public boolean delete(HxGrade hxGrade) {
		boolean result = dao.delete(hxGrade);
		return result;
	}
	/**
	 *修改HxGrade
	 */ 
	public boolean update(HxGrade hxGrade) {
		boolean result = dao.update(hxGrade);
		return result;
	}
	/**
	 *查询HxGrade列表
	 */ 
	public List<HxGrade> query(HxGrade hxGrade) {
		List<HxGrade> list = dao.query(hxGrade);
		return list;
	}
	/**
	 *查询HxGrade ByID
	 */ 
//	public HxGrade queryById(HxGrade hxGrade) {
//		HxGrade result = dao.queryById(hxGrade);
//		return result;
//	}
	/**
	 *分页HxGrade pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<HxGrade> queryForPage(int pageNo,int pageSize,HxGrade hxGrade) {
		List<HxGrade> list = dao.queryForPage(pageNo,pageSize,hxGrade);
		return list;
	}
	/**
	 *查询HxGrade数据条数
	 */ 
	public Long queryCount(HxGrade hxGrade) {
		Long result = dao.queryCount(hxGrade);
		return result;
	}

}