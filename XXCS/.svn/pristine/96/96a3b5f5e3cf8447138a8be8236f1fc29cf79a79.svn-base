package com.flx.flxoa.info.approve.dao;


import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.flx.flxoa.info.approve.entity.FlxoaApproveForm;

/**
 *
 * 类名称：FlxoaApproveFormDao.java
 * 类描述：
 * 创建时间：2018-03-23, 下午04:41:33
 *
 *@version 1.0 
 *@since JDK版本1.7 
 *@author 刘凯 
 */ 
public interface FlxoaApproveFormDao {
	/**
	 *添加FlxoaApproveForm
	 */ 
	public boolean add(FlxoaApproveForm flxoaApproveForm);
	/**
	 *删除FlxoaApproveForm
	 */ 
	public boolean delete(FlxoaApproveForm flxoaApproveForm);
	/**
	 *修改FlxoaApproveForm
	 */ 
	public boolean update(FlxoaApproveForm flxoaApproveForm);
	/**
	 *查询FlxoaApproveForm列表
	 */ 
	public ConcurrentHashMap<String, Object> query(String start,String length,FlxoaApproveForm flxoaApproveForm);
	/**
	 *查询FlxoaApproveForm列表
	 */ 
	public List<FlxoaApproveForm> query(FlxoaApproveForm flxoaApproveForm);
	/**
	 *查询FlxoaApproveForm ByID
	 */ 
	public FlxoaApproveForm queryById(FlxoaApproveForm flxoaApproveForm);
	/**
	 *分页FlxoaApproveForm pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<FlxoaApproveForm> queryForPage(int pageNo,int pageSize,FlxoaApproveForm flxoaApproveForm);
	/**
	 *查询FlxoaApproveForm数据条数
	 */ 
	public Long queryCount(FlxoaApproveForm flxoaApproveForm);
	/**
	 * 根据用户id、请假申请表和签到时间查询审批状态
	 * @param userIds
	 * @param templateId
	 * @return
	 */
	public List<Map<String,Object>> queryLeaveRecord(int userIds, int templateId,int signDateNew);
	/**
	 *查询 审批记录详情  FlxoaApproveForm 
	 */ 
	public List<FlxoaApproveForm> queryApproveFormLog(FlxoaApproveForm flxoaApproveForm);
	/**
	 *查询 确认人确认状态  FlxoaApproveForm 
	 */ 
	public List<FlxoaApproveForm> queryChechUserApproveFormLog(FlxoaApproveForm flxoaApproveForm);

 }