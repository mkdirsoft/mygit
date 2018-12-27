package com.flx.flxoa.info.clientsManagement.manager;


import java.util.List;
import java.util.Map;

import com.flx.flxoa.info.clientsManagement.entity.FlxoaClientInformation;

/**
 *
 * 类名称：FlxoaClientInformationService.java
 * 类描述：
 * 创建时间：2018-09-05, 下午03:19:41
 *
 *@version 1.0 
 *@since JDK版本1.7 
 *@author 孙进 
 */ 
public interface FlxoaClientInformationService {
	/**
	 *添加FlxoaClientInformation
	 */ 
	public boolean add(FlxoaClientInformation flxoaClientInformation);
	/**
	 *删除FlxoaClientInformation
	 */ 
	public boolean delete(FlxoaClientInformation flxoaClientInformation);
	/**
	 *修改FlxoaClientInformation
	 */ 
	public boolean update(FlxoaClientInformation flxoaClientInformation);
	/**
	 *查询FlxoaClientInformation列表
	 */ 
	public List<FlxoaClientInformation> query(FlxoaClientInformation flxoaClientInformation);
	/**
	 *查询FlxoaClientInformation ByID
	 */ 
	public FlxoaClientInformation queryById(FlxoaClientInformation flxoaClientInformation);
	/**
	 *分页FlxoaClientInformation pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public String queryForPage(Map<String,String> map);
	/**
	 *查询FlxoaClientInformation数据条数
	 */ 
	public Long queryCount(FlxoaClientInformation flxoaClientInformation);
	/**
	 * 根据跟单人id查询客户信息并分页
	 * */
	public String queryForPageByFid(Map<String,String> map);
 }