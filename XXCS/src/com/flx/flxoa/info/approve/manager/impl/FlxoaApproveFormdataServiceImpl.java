package com.flx.flxoa.info.approve.manager.impl;


import java.util.List;
import com.flx.flxoa.info.approve.entity.FlxoaApproveFormdata;
import com.flx.flxoa.info.approve.manager.FlxoaApproveFormdataService;
import com.flx.flxoa.info.approve.dao.FlxoaApproveFormdataDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * 类名称：FlxoaApproveFormdataServiceImpl.java
 * 类描述：
 * 创建时间：2018-03-23, 下午04:41:33
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 刘凯 
 */ 
@Service
@Transactional
public class FlxoaApproveFormdataServiceImpl implements FlxoaApproveFormdataService {
	private FlxoaApproveFormdataDao dao;
	@Autowired
	public void setDao(FlxoaApproveFormdataDao dao) {
		this.dao = dao;
	}
	public FlxoaApproveFormdataDao getDao() {
		return dao;
	}
	/**
	 *添加FlxoaApproveFormdata
	 */ 
	public boolean add(FlxoaApproveFormdata flxoaApproveFormdata) {
		boolean result = dao.add(flxoaApproveFormdata);
		return result;
	}
	/**
	 *删除FlxoaApproveFormdata
	 */ 
	public boolean delete(FlxoaApproveFormdata flxoaApproveFormdata) {
		boolean result = dao.delete(flxoaApproveFormdata);
		return result;
	}
	/**
	 *修改FlxoaApproveFormdata
	 */ 
	public boolean update(FlxoaApproveFormdata flxoaApproveFormdata) {
		boolean result = dao.update(flxoaApproveFormdata);
		return result;
	}
	/**
	 *查询FlxoaApproveFormdata列表
	 */ 
	public List<FlxoaApproveFormdata> query(FlxoaApproveFormdata flxoaApproveFormdata) {
		List<FlxoaApproveFormdata> list = dao.query(flxoaApproveFormdata);
		return list;
	}
	/**
	 *查询FlxoaApproveFormdata ByID
	 */ 
	public FlxoaApproveFormdata queryById(FlxoaApproveFormdata flxoaApproveFormdata) {
		FlxoaApproveFormdata result = dao.queryById(flxoaApproveFormdata);
		return result;
	}
	/**
	 *分页FlxoaApproveFormdata pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<FlxoaApproveFormdata> queryForPage(int pageNo,int pageSize,FlxoaApproveFormdata flxoaApproveFormdata) {
		List<FlxoaApproveFormdata> list = dao.queryForPage(pageNo,pageSize,flxoaApproveFormdata);
		return list;
	}
	/**
	 *查询FlxoaApproveFormdata数据条数
	 */ 
	public Long queryCount(FlxoaApproveFormdata flxoaApproveFormdata) {
		Long result = dao.queryCount(flxoaApproveFormdata);
		return result;
	}
	/**
	 *查询FlxoaApproveFormdata数据
	 */ 
	public FlxoaApproveFormdata queryByEntity(
			FlxoaApproveFormdata flxoaApproveFormdata) {
		FlxoaApproveFormdata result = dao.queryByEntity(flxoaApproveFormdata);
		return result;
	}
	/**
	 *查询和项目有关的FlxoaApproveFormdata列表
	 */ 	
	@Override
	public List<FlxoaApproveFormdata> queryProjectForm(
			FlxoaApproveFormdata flxoaApproveFormdata) {
		List<FlxoaApproveFormdata> list = dao.queryProjectForm(flxoaApproveFormdata);
		return list;
	}

}