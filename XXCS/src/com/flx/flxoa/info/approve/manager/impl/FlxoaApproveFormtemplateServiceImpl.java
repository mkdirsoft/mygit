package com.flx.flxoa.info.approve.manager.impl;


import java.util.List;
import com.flx.flxoa.info.approve.entity.FlxoaApproveFormtemplate;
import com.flx.flxoa.info.approve.manager.FlxoaApproveFormtemplateService;
import com.flx.flxoa.info.approve.dao.FlxoaApproveFormtemplateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * 类名称：FlxoaApproveFormtemplateServiceImpl.java
 * 类描述：
 * 创建时间：2018-03-23, 下午04:41:33
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 刘凯 
 */ 
@Service
@Transactional
public class FlxoaApproveFormtemplateServiceImpl implements FlxoaApproveFormtemplateService {
	private FlxoaApproveFormtemplateDao dao;
	@Autowired
	public void setDao(FlxoaApproveFormtemplateDao dao) {
		this.dao = dao;
	}
	public FlxoaApproveFormtemplateDao getDao() {
		return dao;
	}
	/**
	 *添加FlxoaApproveFormtemplate
	 */ 
	public boolean add(FlxoaApproveFormtemplate flxoaApproveFormtemplate) {
		boolean result = dao.add(flxoaApproveFormtemplate);
		return result;
	}
	/**
	 *删除FlxoaApproveFormtemplate
	 */ 
	public boolean delete(FlxoaApproveFormtemplate flxoaApproveFormtemplate) {
		boolean result = dao.delete(flxoaApproveFormtemplate);
		return result;
	}
	/**
	 *修改FlxoaApproveFormtemplate
	 */ 
	public boolean update(FlxoaApproveFormtemplate flxoaApproveFormtemplate) {
		boolean result = dao.update(flxoaApproveFormtemplate);
		return result;
	}
	/**
	 *查询FlxoaApproveFormtemplate列表
	 */ 
	public List<FlxoaApproveFormtemplate> query(FlxoaApproveFormtemplate flxoaApproveFormtemplate) {
		List<FlxoaApproveFormtemplate> list = dao.query(flxoaApproveFormtemplate);
		return list;
	}
	/**
	 *查询FlxoaApproveFormtemplate ByID
	 */ 
	public FlxoaApproveFormtemplate queryById(FlxoaApproveFormtemplate flxoaApproveFormtemplate) {
		FlxoaApproveFormtemplate result = dao.queryById(flxoaApproveFormtemplate);
		return result;
	}
	/**
	 *分页FlxoaApproveFormtemplate pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<FlxoaApproveFormtemplate> queryForPage(int pageNo,int pageSize,FlxoaApproveFormtemplate flxoaApproveFormtemplate) {
		List<FlxoaApproveFormtemplate> list = dao.queryForPage(pageNo,pageSize,flxoaApproveFormtemplate);
		return list;
	}
	/**
	 *查询FlxoaApproveFormtemplate数据条数
	 */ 
	public Long queryCount(FlxoaApproveFormtemplate flxoaApproveFormtemplate) {
		Long result = dao.queryCount(flxoaApproveFormtemplate);
		return result;
	}

}