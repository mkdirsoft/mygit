package com.flx.flxoa.info.projectmanagement.dao;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.flx.flxoa.common.util.CommonUtils;
import com.flx.flxoa.info.cashcollection.entity.FlxoaCashcollectionRecord;
import com.flx.flxoa.info.projectmanagement.entity.FlxoaProjectInformation;

/**
 *
 * 类名称：FlxoaProjectInformationDao.java
 * 类描述：
 * 创建时间：2018-03-16, 下午03:28:25
 *
 *@version 1.0 
 *@since JDK版本1.7 
 *@author 雷君 
 */ 
public interface FlxoaProjectInformationDao {
	/**
	 *添加FlxoaProjectInformation
	 */ 
	public boolean add(FlxoaProjectInformation flxoaProjectInformation);
	/**
	 *删除FlxoaProjectInformation
	 */ 
	public boolean delete(FlxoaProjectInformation flxoaProjectInformation);
	/**
	 *修改FlxoaProjectInformation
	 */ 
	public boolean update(FlxoaProjectInformation flxoaProjectInformation);
	/**
	 *验证FlxoaProjectInformation
	 */  
	public boolean isExist(String projectName);
	/**
	 *查询FlxoaProjectInformation列表
	 */ 
	public ConcurrentHashMap<String, Object> query(FlxoaProjectInformation flxoaProjectInformation,int userId,String deptIds,int start , int length);
	/**
	 *查询FlxoaProjectInformation列表
	 */ 
	public List<FlxoaProjectInformation> queryExcel(FlxoaProjectInformation flxoaProjectInformation,int userId,String deptIds);
	/**
	 *查询FlxoaProjectInformation列表
	 */ 
	public List<FlxoaProjectInformation> querySql(FlxoaProjectInformation flxoaProjectInformation);
	/**
	 *通过属性查询FlxoaProjectInformation列表
	 */ 
	public List<FlxoaProjectInformation> queryProperty(FlxoaProjectInformation flxoaProjectInformation);
	/**
	 *查询FlxoaProjectInformation ByID
	 */ 
	public FlxoaProjectInformation queryById(FlxoaProjectInformation flxoaProjectInformation);
		/**
	 * 分页
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public String queryForPage(int start,int length,String draw,int userId,String deptIds,FlxoaProjectInformation flxoaProjectInformation,String myproj);

	/**
	 * 我的项目
	 */
	public String queryProject(int start,int length,String draw,String searchInfo);
}