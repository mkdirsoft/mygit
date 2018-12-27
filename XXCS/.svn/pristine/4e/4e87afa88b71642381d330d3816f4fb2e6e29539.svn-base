package com.flx.flxoa.info.projectmanagement.manager.impl;


import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.flx.flxoa.info.cashcollection.entity.FlxoaCashcollectionRecord;
import com.flx.flxoa.info.projectmanagement.entity.FlxoaProjectInformation;
import com.flx.flxoa.info.projectmanagement.manager.FlxoaProjectInformationService;
import com.flx.flxoa.info.projectmanagement.dao.FlxoaProjectInformationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * 类名称：FlxoaProjectInformationServiceImpl.java
 * 类描述：
 * 创建时间：2018-03-16, 下午03:28:25
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 雷君 
 */ 
@Service
@Transactional
public class FlxoaProjectInformationServiceImpl implements FlxoaProjectInformationService {
	private FlxoaProjectInformationDao dao;
	@Autowired
	public void setDao(FlxoaProjectInformationDao dao) {
		this.dao = dao;
	}
	public FlxoaProjectInformationDao getDao() {
		return dao;
	}
	/**
	 *添加FlxoaProjectInformation
	 */ 
	public boolean add(FlxoaProjectInformation flxoaProjectInformation) {
		boolean result = dao.add(flxoaProjectInformation);
		return result;
	}
	/**
	 *删除FlxoaProjectInformation
	 */ 
	public boolean delete(FlxoaProjectInformation flxoaProjectInformation) {
		boolean result = dao.delete(flxoaProjectInformation);
		return result;
	}
	
	/**
	 *修改FlxoaProjectInformation
	 */ 
	public boolean update(FlxoaProjectInformation flxoaProjectInformation) {
		boolean result = dao.update(flxoaProjectInformation);
		return result;
	}
	/**
	 *验证FlxoaProjectInformation
	 */ 
	public boolean isExist(String  projectName) {
		boolean result = dao.isExist(projectName);
		return result;
	}
	/**
	 *查询FlxoaProjectInformation列表
	 */ 
	public ConcurrentHashMap<String, Object> query(FlxoaProjectInformation flxoaProjectInformation,int userId,String deptIds,int start,int length) {
		ConcurrentHashMap<String, Object> map = dao.query(flxoaProjectInformation,userId,deptIds, start,length);
		return map;
	}
	/**
	 *查询FlxoaProjectInformation列表
	 */ 
	public List<FlxoaProjectInformation> queryExcel(FlxoaProjectInformation flxoaProjectInformation,int userId,String deptIds) {
		List<FlxoaProjectInformation> list = dao.queryExcel(flxoaProjectInformation,userId,deptIds);
		return list;
	}
	/**
	 *查询FlxoaProjectInformation列表
	 */ 
	public List<FlxoaProjectInformation> querySql(FlxoaProjectInformation flxoaProjectInformation) {
		List<FlxoaProjectInformation> list = dao.querySql(flxoaProjectInformation);
		return list;
	}
	
	/**
	 * 分页
	 */
	public String queryForPage(int start,int length,String draw,int userId,String deptIds,FlxoaProjectInformation flxoaProjectInformation,String myproj){
		 return dao.queryForPage(start,length,draw,userId, deptIds,flxoaProjectInformation,myproj);
	}
	/**
	 *查询FlxoaProjectInformation列表
	 */ 
	public List<FlxoaProjectInformation> queryProperty(FlxoaProjectInformation flxoaProjectInformation) {
		List<FlxoaProjectInformation> list = dao.queryProperty(flxoaProjectInformation);
		return list;
	}
	/**
	 *查询FlxoaProjectInformation ByID
	 */ 
	public FlxoaProjectInformation queryById(FlxoaProjectInformation flxoaProjectInformation) {
		FlxoaProjectInformation result = dao.queryById(flxoaProjectInformation);
		return result;
	}
	@Override
	public String queryProject(int start, int length, String draw,String searchInfo) {
		return dao.queryProject(start, length, draw, searchInfo);
	}
}