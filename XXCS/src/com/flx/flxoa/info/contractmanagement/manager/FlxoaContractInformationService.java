package com.flx.flxoa.info.contractmanagement.manager;


import java.util.List;
import java.util.Map;

import com.flx.flxoa.info.contractmanagement.entity.FlxoaContractInformation;

/**
 *
 * 类名称：FlxoaContractInformationService.java
 * 类描述：
 * 创建时间：2018-09-04, 上午09:26:56
 *
 *@version 1.0 
 *@since JDK版本1.7 
 *@author 夏改翠 
 */ 
public interface FlxoaContractInformationService {
	/**
	 *添加FlxoaContractInformation
	 */ 
	public boolean add(FlxoaContractInformation flxoaContractInformation);
	/**
	 *删除FlxoaContractInformation
	 */ 
	public boolean delete(FlxoaContractInformation flxoaContractInformation);
	/**
	 *修改FlxoaContractInformation
	 */ 
	public boolean update(FlxoaContractInformation flxoaContractInformation);
	/**
	 *查询FlxoaContractInformation列表
	 */ 
	public List<FlxoaContractInformation> query(FlxoaContractInformation flxoaContractInformation);
	/**
	 *查询FlxoaContractInformation ByID
	 */ 
	public FlxoaContractInformation queryById(FlxoaContractInformation flxoaContractInformation);
	/**
	 *分页FlxoaContractInformation pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<FlxoaContractInformation> queryForPage(int pageNo,int pageSize,FlxoaContractInformation flxoaContractInformation);
	/**
	 *查询FlxoaContractInformation数据条数
	 */ 
	public Long queryCount(FlxoaContractInformation flxoaContractInformation);
	/**
	 * 查询合同信息列表 FlxoaContractList  
	 */
	public String queryContractList(Map<String,String> map);
	/**
	 * 根据id查合同详情
	 */
	public List<Map<String,String>> queryContractById(int id);

 }