package com.flx.flxoa.info.conference.manager.impl;


import java.util.List;
import com.flx.flxoa.info.conference.entity.FlxoaConferenceHistory;
import com.flx.flxoa.info.conference.manager.FlxoaConferenceHistoryService;
import com.flx.flxoa.info.conference.dao.FlxoaConferenceHistoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * 类名称：FlxoaConferenceHistoryServiceImpl.java
 * 类描述：
 * 创建时间：2018-09-04, 下午04:58:03
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 雷君 
 */ 
@Service
@Transactional
public class FlxoaConferenceHistoryServiceImpl implements FlxoaConferenceHistoryService {
	private FlxoaConferenceHistoryDao dao;
	@Autowired
	public void setDao(FlxoaConferenceHistoryDao dao) {
		this.dao = dao;
	}
	public FlxoaConferenceHistoryDao getDao() {
		return dao;
	}
	/**
	 *添加FlxoaConferenceHistory
	 */ 
	public boolean add(FlxoaConferenceHistory flxoaConferenceHistory) {
		boolean result = dao.add(flxoaConferenceHistory);
		return result;
	}
	/**
	 *删除FlxoaConferenceHistory
	 */ 
	public boolean delete(FlxoaConferenceHistory flxoaConferenceHistory) {
		boolean result = dao.delete(flxoaConferenceHistory);
		return result;
	}
	/**
	 *修改FlxoaConferenceHistory
	 */ 
	public boolean update(FlxoaConferenceHistory flxoaConferenceHistory) {
		boolean result = dao.update(flxoaConferenceHistory);
		return result;
	}
	/**
	 *查询FlxoaConferenceHistory列表
	 */ 
	public List<FlxoaConferenceHistory> query(FlxoaConferenceHistory flxoaConferenceHistory) {
		List<FlxoaConferenceHistory> list = dao.query(flxoaConferenceHistory);
		return list;
	}
	 /**
	 *查询FlxoaConferenceHistory列表
	 */ 
	public List<FlxoaConferenceHistory> queryHistory(FlxoaConferenceHistory flxoaConferenceHistory) {
		List<FlxoaConferenceHistory> list = dao.queryHistory(flxoaConferenceHistory);
		return list;
	}
	 /**
	 *查询FlxoaConferenceHistory列表
	 */ 
	public List<FlxoaConferenceHistory> queryHistoryFree(FlxoaConferenceHistory flxoaConferenceHistory) {
		List<FlxoaConferenceHistory> list = dao.queryHistoryFree(flxoaConferenceHistory);
		return list;
	}
	/**
	 *查询FlxoaConferenceHistory ByID
	 */ 
	public FlxoaConferenceHistory queryById(FlxoaConferenceHistory flxoaConferenceHistory) {
		FlxoaConferenceHistory result = dao.queryById(flxoaConferenceHistory);
		return result;
	}
	/**
	 *分页FlxoaConferenceHistory pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public String queryForPage(int start,int length ,String draw,int userId,String deptIds,FlxoaConferenceHistory flxoaConferenceHistory) {
		return dao.queryForPage(start,length,draw,userId,deptIds,flxoaConferenceHistory);
	}
	/**
	 *查询FlxoaConferenceHistory数据条数
	 */ 
	public Long queryCount(FlxoaConferenceHistory flxoaConferenceHistory) {
		Long result = dao.queryCount(flxoaConferenceHistory);
		return result;
	}
	/**
	 *查询FlxoaConferenceHistory
	 */ 
	@Override
	public Boolean isExist(int startTime,int endTime,String conferenceId) {
		boolean result = dao.isExist(startTime,endTime,conferenceId);
		return result;
	}
}