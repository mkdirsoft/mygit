package com.flx.flxoa.info.system.manager;


import java.util.List;
import com.flx.flxoa.info.system.entity.FlxoaAccessory;

/**
 *
 * 类名称：FlxoaAccessoryService.java
 * 类描述：
 * 创建时间：2018-05-09, 下午04:43:23
 *
 *@version 1.0 
 *@since JDK版本1.7 
 *@author 赵鹏辉 
 */ 
public interface FlxoaAccessoryService {
	/**
	 *添加FlxoaAccessory
	 */ 
	public boolean add(FlxoaAccessory flxoaAccessory);
	/**
	 *删除FlxoaAccessory
	 */ 
	public boolean delete(FlxoaAccessory flxoaAccessory);
	/**
	 *修改FlxoaAccessory
	 */ 
	public boolean update(FlxoaAccessory flxoaAccessory);
	/**
	 *查询FlxoaAccessory列表
	 */ 
	public List<FlxoaAccessory> query(FlxoaAccessory flxoaAccessory);
	/**
	 *查询FlxoaAccessory ByID
	 */ 
	public FlxoaAccessory queryById(FlxoaAccessory flxoaAccessory);
	/**
	 *分页FlxoaAccessory pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<FlxoaAccessory> queryForPage(int pageNo,int pageSize,FlxoaAccessory flxoaAccessory);
	/**
	 *查询FlxoaAccessory数据条数
	 */ 
	public Long queryCount(FlxoaAccessory flxoaAccessory);
	
	/**
	 * 附件记录
	 * @param invoiceManagerId
	 * @return
	 */
	public List<FlxoaAccessory> fujianRecord(String invoiceManagerId);
 }