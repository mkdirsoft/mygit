package com.flx.flxoa.info.projectmanagement.manager.impl;


import java.util.List;
import com.flx.flxoa.info.projectmanagement.entity.FlxoaProjectBidRecord;
import com.flx.flxoa.info.projectmanagement.manager.FlxoaProjectBidRecordService;
import com.flx.flxoa.info.projectmanagement.dao.FlxoaProjectBidRecordDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * 类名称：FlxoaProjectBidRecordServiceImpl.java
 * 类描述：
 * 创建时间：2018-03-21, 下午07:11:37
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 雷君 
 */ 
@Service
@Transactional
public class FlxoaProjectBidRecordServiceImpl implements FlxoaProjectBidRecordService {
	private FlxoaProjectBidRecordDao dao;
	@Autowired
	public void setDao(FlxoaProjectBidRecordDao dao) {
		this.dao = dao;
	}
	public FlxoaProjectBidRecordDao getDao() {
		return dao;
	}
	/**
	 *添加FlxoaProjectBidRecord
	 */ 
	public boolean add(FlxoaProjectBidRecord flxoaProjectBidRecord) {
		boolean result = dao.add(flxoaProjectBidRecord);
		return result;
	}
	/**
	 *删除FlxoaProjectBidRecord
	 */ 
	public boolean delete(FlxoaProjectBidRecord flxoaProjectBidRecord) {
		boolean result = dao.delete(flxoaProjectBidRecord);
		return result;
	}
	/**
	 *修改FlxoaProjectBidRecord
	 */ 
	public boolean update(FlxoaProjectBidRecord flxoaProjectBidRecord) {
		boolean result = dao.update(flxoaProjectBidRecord);
		return result;
	}
	/**
	 *查询FlxoaProjectBidRecord列表
	 */ 
	public List<FlxoaProjectBidRecord> query(FlxoaProjectBidRecord flxoaProjectBidRecord) {
		List<FlxoaProjectBidRecord> list = dao.query(flxoaProjectBidRecord);
		return list;
	}
	/**
	 *查询FlxoaProjectBidRecord ByID
	 */ 
	public FlxoaProjectBidRecord queryById(FlxoaProjectBidRecord flxoaProjectBidRecord) {
		FlxoaProjectBidRecord result = dao.queryById(flxoaProjectBidRecord);
		return result;
	}
	/**
	 *分页FlxoaProjectBidRecord pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<FlxoaProjectBidRecord> queryForPage(int pageNo,int pageSize,FlxoaProjectBidRecord flxoaProjectBidRecord) {
		List<FlxoaProjectBidRecord> list = dao.queryForPage(pageNo,pageSize,flxoaProjectBidRecord);
		return list;
	}
	/**
	 *查询FlxoaProjectBidRecord数据条数
	 */ 
	public Long queryCount(FlxoaProjectBidRecord flxoaProjectBidRecord) {
		Long result = dao.queryCount(flxoaProjectBidRecord);
		return result;
	}

}