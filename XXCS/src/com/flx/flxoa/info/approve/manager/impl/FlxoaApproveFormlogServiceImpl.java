package com.flx.flxoa.info.approve.manager.impl;


import java.util.List;
import com.flx.flxoa.info.approve.entity.FlxoaApproveFormlog;
import com.flx.flxoa.info.approve.manager.FlxoaApproveFormlogService;
import com.flx.flxoa.info.approve.dao.FlxoaApproveFormlogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * 类名称：FlxoaApproveFormlogServiceImpl.java
 * 类描述：
 * 创建时间：2018-03-23, 下午04:41:33
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 刘凯 
 */ 
@Service
@Transactional
public class FlxoaApproveFormlogServiceImpl implements FlxoaApproveFormlogService {
	private FlxoaApproveFormlogDao dao;
	@Autowired
	public void setDao(FlxoaApproveFormlogDao dao) {
		this.dao = dao;
	}
	public FlxoaApproveFormlogDao getDao() {
		return dao;
	}
	/**
	 *添加FlxoaApproveFormlog
	 */ 
	public boolean add(FlxoaApproveFormlog flxoaApproveFormlog) {
		boolean result = dao.add(flxoaApproveFormlog);
		return result;
	}
	/**
	 *删除FlxoaApproveFormlog
	 */ 
	public boolean delete(FlxoaApproveFormlog flxoaApproveFormlog) {
		boolean result = dao.delete(flxoaApproveFormlog);
		return result;
	}
	/**
	 *修改FlxoaApproveFormlog
	 */ 
	public boolean update(FlxoaApproveFormlog flxoaApproveFormlog) {
		boolean result = dao.update(flxoaApproveFormlog);
		return result;
	}
	/**
	 * 撤销的申请，删除审批流程
	 */
	public boolean deleteLog(FlxoaApproveFormlog flxoaApproveFormlog){
		boolean result = dao.deleteLog(flxoaApproveFormlog);
		return result;
	}
	/**
	 *查询FlxoaApproveFormlog列表
	 */ 
	public List<FlxoaApproveFormlog> query(FlxoaApproveFormlog flxoaApproveFormlog) {
		List<FlxoaApproveFormlog> list = dao.query(flxoaApproveFormlog);
		return list;
	}
	/**
	 *查询FlxoaApproveFormlog ByID
	 */ 
	public FlxoaApproveFormlog queryById(FlxoaApproveFormlog flxoaApproveFormlog) {
		FlxoaApproveFormlog result = dao.queryById(flxoaApproveFormlog);
		return result;
	}
	/**
	 *分页FlxoaApproveFormlog pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<FlxoaApproveFormlog> queryForPage(int pageNo,int pageSize,FlxoaApproveFormlog flxoaApproveFormlog) {
		List<FlxoaApproveFormlog> list = dao.queryForPage(pageNo,pageSize,flxoaApproveFormlog);
		return list;
	}
	/**
	 *查询FlxoaApproveFormlog数据条数
	 */ 
	public Long queryCount(FlxoaApproveFormlog flxoaApproveFormlog) {
		Long result = dao.queryCount(flxoaApproveFormlog);
		return result;
	}

}