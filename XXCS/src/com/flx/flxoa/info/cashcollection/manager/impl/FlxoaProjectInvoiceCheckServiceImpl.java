package com.flx.flxoa.info.cashcollection.manager.impl;


import java.util.List;
import com.flx.flxoa.info.cashcollection.entity.FlxoaProjectInvoiceCheck;
import com.flx.flxoa.info.cashcollection.manager.FlxoaProjectInvoiceCheckService;
import com.flx.flxoa.info.cashcollection.dao.FlxoaProjectInvoiceCheckDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * 类名称：FlxoaProjectInvoiceCheckServiceImpl.java
 * 类描述：
 * 创建时间：2018-03-26, 下午03:32:57
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 赵鹏辉 
 */ 
@Service
@Transactional
public class FlxoaProjectInvoiceCheckServiceImpl implements FlxoaProjectInvoiceCheckService {
	private FlxoaProjectInvoiceCheckDao dao;
	@Autowired
	public void setDao(FlxoaProjectInvoiceCheckDao dao) {
		this.dao = dao;
	}
	public FlxoaProjectInvoiceCheckDao getDao() {
		return dao;
	}
	/**
	 *添加FlxoaProjectInvoiceCheck
	 */ 
	public boolean add(FlxoaProjectInvoiceCheck flxoaProjectInvoiceCheck) {
		boolean result = dao.add(flxoaProjectInvoiceCheck);
		return result;
	}
	/**
	 * 根据发票信息表id查询
	 * @param username
	 * @return
	 */
	public boolean isExist(String username) {
		boolean result = dao.isExist(username);
		
		return result;
	}
	/**
	 *删除FlxoaProjectInvoiceCheck
	 */ 
	public boolean delete(FlxoaProjectInvoiceCheck flxoaProjectInvoiceCheck) {
		boolean result = dao.delete(flxoaProjectInvoiceCheck);
		return result;
	}
	/**
	 *修改FlxoaProjectInvoiceCheck
	 */ 
	public boolean update(FlxoaProjectInvoiceCheck flxoaProjectInvoiceCheck) {
		boolean result = dao.update(flxoaProjectInvoiceCheck);
		return result;
	}
	/**
	 *查询FlxoaProjectInvoiceCheck列表
	 */ 
	public List<FlxoaProjectInvoiceCheck> query(FlxoaProjectInvoiceCheck flxoaProjectInvoiceCheck) {
		List<FlxoaProjectInvoiceCheck> list = dao.query(flxoaProjectInvoiceCheck);
		return list;
	}
	/**
	 *查询FlxoaProjectInvoiceCheck ByID
	 */ 
	public FlxoaProjectInvoiceCheck queryById(FlxoaProjectInvoiceCheck flxoaProjectInvoiceCheck) {
		FlxoaProjectInvoiceCheck result = dao.queryById(flxoaProjectInvoiceCheck);
		return result;
	}
	/**
	 *分页FlxoaProjectInvoiceCheck pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<FlxoaProjectInvoiceCheck> queryForPage(int pageNo,int pageSize,FlxoaProjectInvoiceCheck flxoaProjectInvoiceCheck) {
		List<FlxoaProjectInvoiceCheck> list = dao.queryForPage(pageNo,pageSize,flxoaProjectInvoiceCheck);
		return list;
	}
	/**
	 *查询FlxoaProjectInvoiceCheck数据条数
	 */ 
	public Long queryCount(FlxoaProjectInvoiceCheck flxoaProjectInvoiceCheck) {
		Long result = dao.queryCount(flxoaProjectInvoiceCheck);
		return result;
	}

}