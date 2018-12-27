package com.flx.flxoa.info.contractmanagement.manager.impl;


import java.util.List;
import java.util.Map;

import com.flx.flxoa.info.contractmanagement.entity.FlxoaContractLoanreturn;
import com.flx.flxoa.info.contractmanagement.manager.FlxoaContractLoanreturnService;
import com.flx.flxoa.info.contractmanagement.dao.FlxoaContractLoanreturnDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * 类名称：FlxoaContractLoanreturnServiceImpl.java
 * 类描述：
 * 创建时间：2018-09-04, 上午09:26:56
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 夏改翠 
 */ 
@Service
@Transactional
public class FlxoaContractLoanreturnServiceImpl implements FlxoaContractLoanreturnService {
	private FlxoaContractLoanreturnDao dao;
	@Autowired
	public void setDao(FlxoaContractLoanreturnDao dao) {
		this.dao = dao;
	}
	public FlxoaContractLoanreturnDao getDao() {
		return dao;
	}
	/**
	 *添加FlxoaContractLoanreturn
	 */ 
	public boolean add(FlxoaContractLoanreturn flxoaContractLoanreturn) {
		boolean result = dao.add(flxoaContractLoanreturn);
		return result;
	}
	/**
	 *删除FlxoaContractLoanreturn
	 */ 
	public boolean delete(FlxoaContractLoanreturn flxoaContractLoanreturn) {
		boolean result = dao.delete(flxoaContractLoanreturn);
		return result;
	}
	/**
	 *修改FlxoaContractLoanreturn
	 */ 
	public boolean update(FlxoaContractLoanreturn flxoaContractLoanreturn) {
		boolean result = dao.update(flxoaContractLoanreturn);
		return result;
	}
	/**
	 *查询FlxoaContractLoanreturn列表
	 */ 
	public List<FlxoaContractLoanreturn> query(FlxoaContractLoanreturn flxoaContractLoanreturn) {
		List<FlxoaContractLoanreturn> list = dao.query(flxoaContractLoanreturn);
		return list;
	}
	/**
	 *查询FlxoaContractLoanreturn ByID
	 */ 
	public FlxoaContractLoanreturn queryById(FlxoaContractLoanreturn flxoaContractLoanreturn) {
		FlxoaContractLoanreturn result = dao.queryById(flxoaContractLoanreturn);
		return result;
	}
	/**
	 *分页FlxoaContractLoanreturn pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<FlxoaContractLoanreturn> queryForPage(int pageNo,int pageSize,FlxoaContractLoanreturn flxoaContractLoanreturn) {
		List<FlxoaContractLoanreturn> list = dao.queryForPage(pageNo,pageSize,flxoaContractLoanreturn);
		return list;
	}
	/**
	 *查询FlxoaContractLoanreturn数据条数
	 */ 
	public Long queryCount(FlxoaContractLoanreturn flxoaContractLoanreturn) {
		Long result = dao.queryCount(flxoaContractLoanreturn);
		return result;
	}
	@Override
	public String queryPageContractLoan(Map<String, String> map) {
		
		return dao.queryPageContractLoan(map);
	}

}