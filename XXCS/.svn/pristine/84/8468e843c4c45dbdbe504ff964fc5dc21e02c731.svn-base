package com.flx.flxoa.info.system.manager.impl;


import java.util.List;
import com.flx.flxoa.info.system.entity.FlxoaApproveWorkflow;
import com.flx.flxoa.info.system.manager.FlxoaApproveWorkflowService;
import com.flx.flxoa.info.system.dao.FlxoaApproveWorkflowDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * 类名称：FlxoaApproveWorkflowServiceImpl.java
 * 类描述：
 * 创建时间：2018-03-19, 下午05:30:55
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 刘凯 
 */ 
@Service
@Transactional
public class FlxoaApproveWorkflowServiceImpl implements FlxoaApproveWorkflowService {
	private FlxoaApproveWorkflowDao dao;
	@Autowired
	public void setDao(FlxoaApproveWorkflowDao dao) {
		this.dao = dao;
	}
	public FlxoaApproveWorkflowDao getDao() {
		return dao;
	}
	/**
	 *添加FlxoaApproveWorkflow
	 */ 
	public boolean add(FlxoaApproveWorkflow flxoaApproveWorkflow) {
		boolean result = dao.add(flxoaApproveWorkflow);
		return result;
	}
	/**
	 *删除FlxoaApproveWorkflow
	 */ 
	public boolean delete(FlxoaApproveWorkflow flxoaApproveWorkflow) {
		boolean result = dao.delete(flxoaApproveWorkflow);
		return result;
	}
	/**
	 *修改FlxoaApproveWorkflow
	 */ 
	public boolean update(FlxoaApproveWorkflow flxoaApproveWorkflow) {
		boolean result = dao.update(flxoaApproveWorkflow);
		return result;
	}
	/**
	 *查询FlxoaApproveWorkflow列表
	 */ 
	public List<FlxoaApproveWorkflow> query(FlxoaApproveWorkflow flxoaApproveWorkflow) {
		List<FlxoaApproveWorkflow> list = dao.query(flxoaApproveWorkflow);
		return list;
	}
	/**
	 *查询FlxoaApproveWorkflow ByID
	 */ 
	public FlxoaApproveWorkflow queryById(FlxoaApproveWorkflow flxoaApproveWorkflow) {
		FlxoaApproveWorkflow result = dao.queryById(flxoaApproveWorkflow);
		return result;
	}

}