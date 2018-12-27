package com.flx.flxoa.info.clientsManagement.manager.impl;


import java.util.List;
import java.util.Map;

import com.flx.flxoa.info.clientsManagement.entity.FlxoaClientInformation;
import com.flx.flxoa.info.clientsManagement.manager.FlxoaClientInformationService;
import com.flx.flxoa.info.clientsManagement.dao.FlxoaClientInformationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * 类名称：FlxoaClientInformationServiceImpl.java
 * 类描述：
 * 创建时间：2018-09-05, 下午03:19:41
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 孙进 
 */ 
@Service
@Transactional
public class FlxoaClientInformationServiceImpl implements FlxoaClientInformationService {
	private FlxoaClientInformationDao dao;
	@Autowired
	public void setDao(FlxoaClientInformationDao dao) {
		this.dao = dao;
	}
	public FlxoaClientInformationDao getDao() {
		return dao;
	}
	/**
	 *添加FlxoaClientInformation
	 */ 
	public boolean add(FlxoaClientInformation flxoaClientInformation) {
		boolean result = dao.add(flxoaClientInformation);
		return result;
	}
	/**
	 *删除FlxoaClientInformation
	 */ 
	public boolean delete(FlxoaClientInformation flxoaClientInformation) {
		boolean result = dao.delete(flxoaClientInformation);
		return result;
	}
	/**
	 *修改FlxoaClientInformation
	 */ 
	public boolean update(FlxoaClientInformation flxoaClientInformation) {
		boolean result = dao.update(flxoaClientInformation);
		return result;
	}
	/**
	 *查询FlxoaClientInformation列表
	 */ 
	public List<FlxoaClientInformation> query(FlxoaClientInformation flxoaClientInformation) {
		List<FlxoaClientInformation> list = dao.query(flxoaClientInformation);
		return list;
	}
	/**
	 *查询FlxoaClientInformation ByID
	 */ 
	public FlxoaClientInformation queryById(FlxoaClientInformation flxoaClientInformation) {
		FlxoaClientInformation result = dao.queryById(flxoaClientInformation);
		return result;
	}
	/**
	 *分页FlxoaClientInformation pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public String queryForPage(Map<String,String> map) {
		return dao.queryForPage(map);
	}
	/**
	 *查询FlxoaClientInformation数据条数
	 */ 
	public Long queryCount(FlxoaClientInformation flxoaClientInformation) {
		Long result = dao.queryCount(flxoaClientInformation);
		return result;
	}
	public String queryForPageByFid(Map<String, String> map) {
		return dao.queryForPageByFid(map);
	}

}