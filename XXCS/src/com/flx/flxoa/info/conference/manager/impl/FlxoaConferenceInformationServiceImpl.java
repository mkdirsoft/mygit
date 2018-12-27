package com.flx.flxoa.info.conference.manager.impl;


import java.util.List;
import com.flx.flxoa.info.conference.entity.FlxoaConferenceInformation;
import com.flx.flxoa.info.conference.manager.FlxoaConferenceInformationService;
import com.flx.flxoa.info.conference.dao.FlxoaConferenceInformationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * 类名称：FlxoaConferenceInformationServiceImpl.java
 * 类描述：
 * 创建时间：2018-09-04, 下午04:58:03
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 雷君 
 */ 
@Service
@Transactional
public class FlxoaConferenceInformationServiceImpl implements FlxoaConferenceInformationService {
	private FlxoaConferenceInformationDao dao;
	@Autowired
	public void setDao(FlxoaConferenceInformationDao dao) {
		this.dao = dao;
	}
	public FlxoaConferenceInformationDao getDao() {
		return dao;
	}
	/**
	 *添加FlxoaConferenceInformation
	 */ 
	public boolean add(FlxoaConferenceInformation flxoaConferenceInformation) {
		boolean result = dao.add(flxoaConferenceInformation);
		return result;
	}
	/**
	 *删除FlxoaConferenceInformation
	 */ 
	public boolean delete(FlxoaConferenceInformation flxoaConferenceInformation) {
		boolean result = dao.delete(flxoaConferenceInformation);
		return result;
	}
	/**
	 *修改FlxoaConferenceInformation
	 */ 
	public boolean update(FlxoaConferenceInformation flxoaConferenceInformation) {
		boolean result = dao.update(flxoaConferenceInformation);
		return result;
	}
	/**
	 *修改FlxoaConferenceInformation
	 */ 
	public boolean updateFree() {
		boolean result = dao.updateFree();
		return result;
	}
	/**
	 *查询FlxoaConferenceInformation列表
	 */ 
	public List<FlxoaConferenceInformation> query(FlxoaConferenceInformation flxoaConferenceInformation) {
		List<FlxoaConferenceInformation> list = dao.query(flxoaConferenceInformation);
		return list;
	}
	/**
	 *查询FlxoaConferenceInformation ByID
	 */ 
	public FlxoaConferenceInformation queryById(FlxoaConferenceInformation flxoaConferenceInformation) {
		FlxoaConferenceInformation result = dao.queryById(flxoaConferenceInformation);
		return result;
	}
	/**
	 *分页FlxoaConferenceInformation pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public String  queryForPage(int start,int length ,String draw,int userId,String deptIds,FlxoaConferenceInformation flxoaConferenceInformation) {
		return dao.queryForPage(start,length,draw,userId,deptIds,flxoaConferenceInformation);
	}
	/**
	 *查询FlxoaConferenceInformation数据条数
	 */ 
	public Long queryCount(FlxoaConferenceInformation flxoaConferenceInformation) {
		Long result = dao.queryCount(flxoaConferenceInformation);
		return result;
	}

}