package com.flx.flxoa.info.conference.manager;


import java.util.List;
import com.flx.flxoa.info.conference.entity.FlxoaConferenceHistory;

/**
 *
 * 类名称：FlxoaConferenceHistoryService.java
 * 类描述：
 * 创建时间：2018-09-04, 下午04:58:03
 *
 *@version 1.0 
 *@since JDK版本1.7 
 *@author 雷君 
 */ 
public interface FlxoaConferenceHistoryService {
	/**
	 *添加FlxoaConferenceHistory
	 */ 
	public boolean add(FlxoaConferenceHistory flxoaConferenceHistory);
	/**
	 *删除FlxoaConferenceHistory
	 */ 
	public boolean delete(FlxoaConferenceHistory flxoaConferenceHistory);
	/**
	 *修改FlxoaConferenceHistory
	 */ 
	public boolean update(FlxoaConferenceHistory flxoaConferenceHistory);
	/**
	 *查询FlxoaConferenceHistory列表
	 */ 
	public List<FlxoaConferenceHistory> query(FlxoaConferenceHistory flxoaConferenceHistory);
	/**
	 *查询FlxoaConferenceHistory列表
	 */ 
	public List<FlxoaConferenceHistory> queryHistory(FlxoaConferenceHistory flxoaConferenceHistory);
	/**
	 *查询FlxoaConferenceHistory列表
	 */ 
	public List<FlxoaConferenceHistory> queryHistoryFree(FlxoaConferenceHistory flxoaConferenceHistory);
	/**
	 *查询FlxoaConferenceHistory ByID
	 */ 
	public FlxoaConferenceHistory queryById(FlxoaConferenceHistory flxoaConferenceHistory);
	/**
	 *分页FlxoaConferenceHistory pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public String queryForPage(int start,int length ,String draw,int userId,String deptIds,FlxoaConferenceHistory flxoaConferenceHistory);
	/**
	 *查询FlxoaConferenceHistory数据条数
	 */ 
	public Long queryCount(FlxoaConferenceHistory flxoaConferenceHistory);
	/**
	 *查询FlxoaConferenceHistory
	 */ 
	public Boolean isExist(int startTime,int endTime,String conferenceId);
	

 }