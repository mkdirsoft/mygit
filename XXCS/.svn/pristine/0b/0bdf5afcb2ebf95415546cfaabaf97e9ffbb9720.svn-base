package com.flx.flxoa.info.system.manager.impl;


import java.util.List;
import com.flx.flxoa.info.system.entity.FlxoaSystemEnumeration;
import com.flx.flxoa.info.system.manager.FlxoaSystemEnumerationService;
import com.flx.flxoa.info.system.dao.FlxoaSystemEnumerationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * 类名称：FlxoaSystemEnumerationServiceImpl.java
 * 类描述：
 * 创建时间：2018-04-21, 下午03:11:35
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 刘凯 
 */ 
@Service
@Transactional
public class FlxoaSystemEnumerationServiceImpl implements FlxoaSystemEnumerationService {
	private FlxoaSystemEnumerationDao dao;
	@Autowired
	public void setDao(FlxoaSystemEnumerationDao dao) {
		this.dao = dao;
	}
	public FlxoaSystemEnumerationDao getDao() {
		return dao;
	}
	/**
	 *添加FlxoaSystemEnumeration
	 */ 
	public boolean add(FlxoaSystemEnumeration flxoaSystemEnumeration) {
		boolean result = dao.add(flxoaSystemEnumeration);
		return result;
	}
	/**
	 *删除FlxoaSystemEnumeration
	 */ 
	public boolean delete(FlxoaSystemEnumeration flxoaSystemEnumeration) {
		boolean result = dao.delete(flxoaSystemEnumeration);
		return result;
	}
	/**
	 *修改FlxoaSystemEnumeration
	 */ 
	public boolean update(FlxoaSystemEnumeration flxoaSystemEnumeration) {
		boolean result = dao.update(flxoaSystemEnumeration);
		return result;
	}
	/**
	 *查询FlxoaSystemEnumeration列表
	 */ 
	public List<FlxoaSystemEnumeration> query(FlxoaSystemEnumeration flxoaSystemEnumeration) {
		List<FlxoaSystemEnumeration> list = dao.query(flxoaSystemEnumeration);
		return list;
	}
	/**
	 *查询FlxoaSystemEnumeration ByID
	 */ 
	public FlxoaSystemEnumeration queryById(FlxoaSystemEnumeration flxoaSystemEnumeration) {
		FlxoaSystemEnumeration result = dao.queryById(flxoaSystemEnumeration);
		return result;
	}
	/**
	 *分页FlxoaSystemEnumeration pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<FlxoaSystemEnumeration> queryForPage(int pageNo,int pageSize,FlxoaSystemEnumeration flxoaSystemEnumeration) {
		List<FlxoaSystemEnumeration> list = dao.queryForPage(pageNo,pageSize,flxoaSystemEnumeration);
		return list;
	}
	/**
	 *查询FlxoaSystemEnumeration数据条数
	 */ 
	public Long queryCount(FlxoaSystemEnumeration flxoaSystemEnumeration) {
		Long result = dao.queryCount(flxoaSystemEnumeration);
		return result;
	}

}