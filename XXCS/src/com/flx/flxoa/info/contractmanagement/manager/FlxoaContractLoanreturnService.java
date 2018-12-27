package com.flx.flxoa.info.contractmanagement.manager;


import java.util.List;
import java.util.Map;

import com.flx.flxoa.info.contractmanagement.entity.FlxoaContractLoanreturn;

/**
 *
 * 类名称：FlxoaContractLoanreturnService.java
 * 类描述：
 * 创建时间：2018-09-04, 上午09:26:56
 *
 *@version 1.0 
 *@since JDK版本1.7 
 *@author 夏改翠 
 */ 
public interface FlxoaContractLoanreturnService {
	/**
	 *添加FlxoaContractLoanreturn
	 */ 
	public boolean add(FlxoaContractLoanreturn flxoaContractLoanreturn);
	/**
	 *删除FlxoaContractLoanreturn
	 */ 
	public boolean delete(FlxoaContractLoanreturn flxoaContractLoanreturn);
	/**
	 *修改FlxoaContractLoanreturn
	 */ 
	public boolean update(FlxoaContractLoanreturn flxoaContractLoanreturn);
	/**
	 *查询FlxoaContractLoanreturn列表
	 */ 
	public List<FlxoaContractLoanreturn> query(FlxoaContractLoanreturn flxoaContractLoanreturn);
	/**
	 *查询FlxoaContractLoanreturn ByID
	 */ 
	public FlxoaContractLoanreturn queryById(FlxoaContractLoanreturn flxoaContractLoanreturn);
	/**
	 *分页FlxoaContractLoanreturn pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<FlxoaContractLoanreturn> queryForPage(int pageNo,int pageSize,FlxoaContractLoanreturn flxoaContractLoanreturn);
	/**
	 *查询FlxoaContractLoanreturn数据条数
	 */ 
	public Long queryCount(FlxoaContractLoanreturn flxoaContractLoanreturn);
	
	/**
	 * 分页查询合同借出列表
	 */
	public String queryPageContractLoan(Map<String,String> map);

 }