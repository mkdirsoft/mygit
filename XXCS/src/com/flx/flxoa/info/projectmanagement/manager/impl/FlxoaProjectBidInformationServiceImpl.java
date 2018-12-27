package com.flx.flxoa.info.projectmanagement.manager.impl;


import java.util.List;
import com.flx.flxoa.info.projectmanagement.entity.FlxoaProjectBidInformation;
import com.flx.flxoa.info.projectmanagement.entity.FlxoaProjectInformation;
import com.flx.flxoa.info.projectmanagement.manager.FlxoaProjectBidInformationService;
import com.flx.flxoa.info.projectmanagement.dao.FlxoaProjectBidInformationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * 类名称：FlxoaProjectBidInformationServiceImpl.java
 * 类描述：
 * 创建时间：2018-03-21, 下午07:11:37
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 雷君 
 */ 
@Service
@Transactional
public class FlxoaProjectBidInformationServiceImpl implements FlxoaProjectBidInformationService {
	private FlxoaProjectBidInformationDao dao;
	@Autowired
	public void setDao(FlxoaProjectBidInformationDao dao) {
		this.dao = dao;
	}
	public FlxoaProjectBidInformationDao getDao() {
		return dao;
	}
	/**
	 *添加FlxoaProjectBidInformation
	 */ 
	public boolean add(FlxoaProjectBidInformation flxoaProjectBidInformation) {
		boolean result = dao.add(flxoaProjectBidInformation);
		return result;
	}
	/**
	 *删除FlxoaProjectBidInformation
	 */ 
	public boolean delete(FlxoaProjectBidInformation flxoaProjectBidInformation) {
		boolean result = dao.delete(flxoaProjectBidInformation);
		return result;
	}
	/**
	 *修改FlxoaProjectBidInformation
	 */ 
	public boolean update(FlxoaProjectBidInformation flxoaProjectBidInformation) {
		boolean result = dao.update(flxoaProjectBidInformation);
		return result;
	}
	/**
	 *查询FlxoaProjectBidInformation列表
	 */ 
	public List<FlxoaProjectBidInformation> query(FlxoaProjectBidInformation flxoaProjectBidInformation) {
		List<FlxoaProjectBidInformation> list = dao.query(flxoaProjectBidInformation);
		return list;
	}
	/**
	 *查询FlxoaProjectBidInformation ByID
	 */ 
	public FlxoaProjectBidInformation queryById(FlxoaProjectBidInformation flxoaProjectBidInformation) {
		FlxoaProjectBidInformation result = dao.queryById(flxoaProjectBidInformation);
		return result;
	}
	/**
	 *分页FlxoaProjectBidInformation pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public String queryForPage(int pageNo,int pageSize,String draw,int userId, String deptIds,FlxoaProjectBidInformation flxoaProjectBidInformation) {
		 return dao.queryForPage(pageNo,pageSize,draw,userId,deptIds, flxoaProjectBidInformation);
	}
	/**
	 *查询FlxoaProjectBidInformation数据条数
	 */ 
	public Long queryCount(FlxoaProjectBidInformation flxoaProjectBidInformation) {
		Long result = dao.queryCount(flxoaProjectBidInformation);
		return result;
	}
	/**
	 *按属性查询FlxoaProjectBidInformation queryByEntity
	 */ 
	public FlxoaProjectBidInformation queryByEntity(FlxoaProjectBidInformation flxoaProjectBidInformation) {
		FlxoaProjectBidInformation result = dao.queryByEntity(flxoaProjectBidInformation);
		return result;
	}

}