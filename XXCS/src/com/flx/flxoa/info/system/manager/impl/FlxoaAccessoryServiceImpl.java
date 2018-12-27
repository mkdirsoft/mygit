package com.flx.flxoa.info.system.manager.impl;


import java.util.List;
import com.flx.flxoa.info.system.entity.FlxoaAccessory;
import com.flx.flxoa.info.system.manager.FlxoaAccessoryService;
import com.flx.flxoa.info.system.dao.FlxoaAccessoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * 类名称：FlxoaAccessoryServiceImpl.java
 * 类描述：
 * 创建时间：2018-05-09, 下午04:43:23
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 赵鹏辉 
 */ 
@Service
@Transactional
public class FlxoaAccessoryServiceImpl implements FlxoaAccessoryService {
	private FlxoaAccessoryDao dao;
	@Autowired
	public void setDao(FlxoaAccessoryDao dao) {
		this.dao = dao;
	}
	public FlxoaAccessoryDao getDao() {
		return dao;
	}
	/**
	 *添加FlxoaAccessory
	 */ 
	public boolean add(FlxoaAccessory flxoaAccessory) {
		boolean result = dao.add(flxoaAccessory);
		return result;
	}
	/**
	 *删除FlxoaAccessory
	 */ 
	public boolean delete(FlxoaAccessory flxoaAccessory) {
		boolean result = dao.delete(flxoaAccessory);
		return result;
	}
	/**
	 *修改FlxoaAccessory
	 */ 
	public boolean update(FlxoaAccessory flxoaAccessory) {
		boolean result = dao.update(flxoaAccessory);
		return result;
	}
	/**
	 *查询FlxoaAccessory列表
	 */ 
	public List<FlxoaAccessory> query(FlxoaAccessory flxoaAccessory) {
		List<FlxoaAccessory> list = dao.query(flxoaAccessory);
		return list;
	}
	/**
	 *查询FlxoaAccessory ByID
	 */ 
	public FlxoaAccessory queryById(FlxoaAccessory flxoaAccessory) {
		FlxoaAccessory result = dao.queryById(flxoaAccessory);
		return result;
	}
	/**
	 *分页FlxoaAccessory pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<FlxoaAccessory> queryForPage(int pageNo,int pageSize,FlxoaAccessory flxoaAccessory) {
		List<FlxoaAccessory> list = dao.queryForPage(pageNo,pageSize,flxoaAccessory);
		return list;
	}
	/**
	 *查询FlxoaAccessory数据条数
	 */ 
	public Long queryCount(FlxoaAccessory flxoaAccessory) {
		Long result = dao.queryCount(flxoaAccessory);
		return result;
	}
	
	/**
	 * 附件记录
	 * @param invoiceManagerId
	 * @return
	 */
	public List<FlxoaAccessory> fujianRecord(String invoiceManagerId){
		List<FlxoaAccessory> list=dao.fujianRecord(invoiceManagerId);
		return list;
	}

}