package com.flx.flxoa.info.approve.manager.impl;


import java.util.List;
import com.flx.flxoa.info.approve.entity.FlxoaApproveConditionWorkflow;
import com.flx.flxoa.info.approve.manager.FlxoaApproveConditionWorkflowService;
import com.flx.flxoa.info.approve.dao.FlxoaApproveConditionWorkflowDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * 类名称：FlxoaApproveConditionWorkflowServiceImpl.java
 * 类描述：
 * 创建时间：2018-03-29, 下午02:11:40
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 刘凯 
 */ 
@Service
@Transactional
public class FlxoaApproveConditionWorkflowServiceImpl implements FlxoaApproveConditionWorkflowService {
	private FlxoaApproveConditionWorkflowDao dao;
	@Autowired
	public void setDao(FlxoaApproveConditionWorkflowDao dao) {
		this.dao = dao;
	}
	public FlxoaApproveConditionWorkflowDao getDao() {
		return dao;
	}
	/**
	 *添加FlxoaApproveConditionWorkflow
	 */ 
	public boolean add(FlxoaApproveConditionWorkflow flxoaApproveConditionWorkflow) {
		boolean result = dao.add(flxoaApproveConditionWorkflow);
		return result;
	}
	/**
	 *删除FlxoaApproveConditionWorkflow
	 */ 
	public boolean delete(FlxoaApproveConditionWorkflow flxoaApproveConditionWorkflow) {
		boolean result = dao.delete(flxoaApproveConditionWorkflow);
		return result;
	}
	/**
	 *修改FlxoaApproveConditionWorkflow
	 */ 
	public boolean update(FlxoaApproveConditionWorkflow flxoaApproveConditionWorkflow) {
		boolean result = dao.update(flxoaApproveConditionWorkflow);
		return result;
	}
	/**
	 *查询FlxoaApproveConditionWorkflow列表
	 */ 
	public List<FlxoaApproveConditionWorkflow> query(FlxoaApproveConditionWorkflow flxoaApproveConditionWorkflow) {
		List<FlxoaApproveConditionWorkflow> list = dao.query(flxoaApproveConditionWorkflow);
		return list;
	}
	/**
	 *查询FlxoaApproveConditionWorkflow ByID
	 */ 
	public FlxoaApproveConditionWorkflow queryById(FlxoaApproveConditionWorkflow flxoaApproveConditionWorkflow) {
		FlxoaApproveConditionWorkflow result = dao.queryById(flxoaApproveConditionWorkflow);
		return result;
	}
	/**
	 *分页FlxoaApproveConditionWorkflow pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<FlxoaApproveConditionWorkflow> queryForPage(int pageNo,int pageSize,FlxoaApproveConditionWorkflow flxoaApproveConditionWorkflow) {
		List<FlxoaApproveConditionWorkflow> list = dao.queryForPage(pageNo,pageSize,flxoaApproveConditionWorkflow);
		return list;
	}
	/**
	 *查询FlxoaApproveConditionWorkflow数据条数
	 */ 
	public Long queryCount(FlxoaApproveConditionWorkflow flxoaApproveConditionWorkflow) {
		Long result = dao.queryCount(flxoaApproveConditionWorkflow);
		return result;
	}
	/**
	 *根据其他条件查询 FlxoaApproveConditionWorkflow 唯一实体
	 */	
	@Override
	public FlxoaApproveConditionWorkflow queryByEntity(FlxoaApproveConditionWorkflow flxoaApproveConditionWorkflow) {
		FlxoaApproveConditionWorkflow result = dao.queryByEntity(flxoaApproveConditionWorkflow);
		return result;
	}

}