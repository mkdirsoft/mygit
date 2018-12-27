package com.flx.flxoa.info.contractmanagement.manager.impl;


import java.util.List;
import java.util.Map;

import com.flx.flxoa.info.contractmanagement.entity.FlxoaContractInformation;
import com.flx.flxoa.info.contractmanagement.manager.FlxoaContractInformationService;
import com.flx.flxoa.info.contractmanagement.dao.FlxoaContractInformationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * 类名称：FlxoaContractInformationServiceImpl.java
 * 类描述：
 * 创建时间：2018-09-04, 上午09:26:56
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 夏改翠 
 */ 
@Service
@Transactional
public class FlxoaContractInformationServiceImpl implements FlxoaContractInformationService {
	private FlxoaContractInformationDao dao;
	@Autowired
	public void setDao(FlxoaContractInformationDao dao) {
		this.dao = dao;
	}
	public FlxoaContractInformationDao getDao() {
		return dao;
	}
	/**
	 *添加FlxoaContractInformation
	 */ 
	public boolean add(FlxoaContractInformation flxoaContractInformation) {
		boolean result = dao.add(flxoaContractInformation);
		return result;
	}
	/**
	 *删除FlxoaContractInformation
	 */ 
	public boolean delete(FlxoaContractInformation flxoaContractInformation) {
		boolean result = dao.delete(flxoaContractInformation);
		return result;
	}
	/**
	 *修改FlxoaContractInformation
	 */ 
	public boolean update(FlxoaContractInformation flxoaContractInformation) {
		boolean result = dao.update(flxoaContractInformation);
		return result;
	}
	/**
	 *查询FlxoaContractInformation列表
	 */ 
	public List<FlxoaContractInformation> query(FlxoaContractInformation flxoaContractInformation) {
		List<FlxoaContractInformation> list = dao.query(flxoaContractInformation);
		return list;
	}
	/**
	 *查询FlxoaContractInformation ByID
	 */ 
	public FlxoaContractInformation queryById(FlxoaContractInformation flxoaContractInformation) {
		FlxoaContractInformation result = dao.queryById(flxoaContractInformation);
		return result;
	}
	/**
	 *分页FlxoaContractInformation pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<FlxoaContractInformation> queryForPage(int pageNo,int pageSize,FlxoaContractInformation flxoaContractInformation) {
		List<FlxoaContractInformation> list = dao.queryForPage(pageNo,pageSize,flxoaContractInformation);
		return list;
	}
	/**
	 *查询FlxoaContractInformation数据条数
	 */ 
	public Long queryCount(FlxoaContractInformation flxoaContractInformation) {
		Long result = dao.queryCount(flxoaContractInformation);
		return result;
	}
	/**
	 * 分页查询 FlxoaContractInformation List
	 */
	public String queryContractList(Map<String, String> map) {
		// TODO Auto-generated method stub
		return dao.queryContractList(map);
	}
	@Override
	public List<Map<String, String>> queryContractById(int id) {
		// TODO Auto-generated method stub
		return dao.queryContractById(id);
	}

}