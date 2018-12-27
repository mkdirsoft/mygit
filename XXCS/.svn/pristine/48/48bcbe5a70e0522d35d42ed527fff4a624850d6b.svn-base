package com.flx.flxoa.info.clientsManagement.manager.impl;


import java.util.List;
import java.util.Map;

import com.flx.flxoa.info.clientsManagement.entity.FlxoaClientCommunication;
import com.flx.flxoa.info.clientsManagement.manager.FlxoaClientCommunicationService;
import com.flx.flxoa.info.clientsManagement.dao.FlxoaClientCommunicationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * 类名称：FlxoaClientCommunicationServiceImpl.java
 * 类描述：
 * 创建时间：2018-09-05, 下午03:19:41
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 孙进 
 */ 
@Service
@Transactional
public class FlxoaClientCommunicationServiceImpl implements FlxoaClientCommunicationService {
	private FlxoaClientCommunicationDao dao;
	@Autowired
	public void setDao(FlxoaClientCommunicationDao dao) {
		this.dao = dao;
	}
	public FlxoaClientCommunicationDao getDao() {
		return dao;
	}
	/**
	 *添加FlxoaClientCommunication
	 */ 
	public boolean add(FlxoaClientCommunication flxoaClientCommunication) {
		boolean result = dao.add(flxoaClientCommunication);
		return result;
	}
	/**
	 *删除FlxoaClientCommunication
	 */ 
	public boolean delete(FlxoaClientCommunication flxoaClientCommunication) {
		boolean result = dao.delete(flxoaClientCommunication);
		return result;
	}
	/**
	 *修改FlxoaClientCommunication
	 */ 
	public boolean update(FlxoaClientCommunication flxoaClientCommunication) {
		boolean result = dao.update(flxoaClientCommunication);
		return result;
	}
	/**
	 *查询FlxoaClientCommunication列表
	 */ 
	public List<FlxoaClientCommunication> query(FlxoaClientCommunication flxoaClientCommunication) {
		List<FlxoaClientCommunication> list = dao.query(flxoaClientCommunication);
		return list;
	}
	/**
	 *查询FlxoaClientCommunication ByID
	 */ 
	public FlxoaClientCommunication queryById(FlxoaClientCommunication flxoaClientCommunication) {
		FlxoaClientCommunication result = dao.queryById(flxoaClientCommunication);
		return result;
	}
	/**
	 *分页FlxoaClientCommunication pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public String queryForPage(Map<String,String> map) {
		return dao.queryForPage(map);
	}
	/**
	 *查询FlxoaClientCommunication数据条数
	 */ 
	public Long queryCount(FlxoaClientCommunication flxoaClientCommunication) {
		Long result = dao.queryCount(flxoaClientCommunication);
		return result;
	}

}