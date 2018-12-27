package com.flx.flxoa.info.cashcollection.dao;


import java.util.List;
import com.flx.flxoa.info.cashcollection.entity.FlxoaProjectInvoiceCheck;

/**
 *
 * 类名称：FlxoaProjectInvoiceCheckDao.java
 * 类描述：
 * 创建时间：2018-03-26, 下午03:32:57
 *
 *@version 1.0 
 *@since JDK版本1.7 
 *@author 赵鹏辉 
 */ 
public interface FlxoaProjectInvoiceCheckDao {
	/**
	 *添加FlxoaProjectInvoiceCheck
	 */ 
	public boolean add(FlxoaProjectInvoiceCheck flxoaProjectInvoiceCheck);

	/**
	 * 根据发票信息表id查询
	 * @param username
	 * @return
	 */
	public boolean isExist(String username);
	/**
	 *删除FlxoaProjectInvoiceCheck
	 */ 
	public boolean delete(FlxoaProjectInvoiceCheck flxoaProjectInvoiceCheck);
	/**
	 *修改FlxoaProjectInvoiceCheck
	 */ 
	public boolean update(FlxoaProjectInvoiceCheck flxoaProjectInvoiceCheck);
	/**
	 *查询FlxoaProjectInvoiceCheck列表
	 */ 
	public List<FlxoaProjectInvoiceCheck> query(FlxoaProjectInvoiceCheck flxoaProjectInvoiceCheck);
	/**
	 *查询FlxoaProjectInvoiceCheck ByID
	 */ 
	public FlxoaProjectInvoiceCheck queryById(FlxoaProjectInvoiceCheck flxoaProjectInvoiceCheck);
	/**
	 *分页FlxoaProjectInvoiceCheck pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<FlxoaProjectInvoiceCheck> queryForPage(int pageNo,int pageSize,FlxoaProjectInvoiceCheck flxoaProjectInvoiceCheck);
	/**
	 *查询FlxoaProjectInvoiceCheck数据条数
	 */ 
	public Long queryCount(FlxoaProjectInvoiceCheck flxoaProjectInvoiceCheck);

 }