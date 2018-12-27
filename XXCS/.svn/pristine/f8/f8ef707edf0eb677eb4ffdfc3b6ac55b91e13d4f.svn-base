package com.flx.flxoa.info.system.manager.impl;


import java.util.List;

import com.flx.flxoa.info.system.entity.FlxoaSystemUser;
import com.flx.flxoa.info.system.manager.FlxoaSystemUserService;
import com.flx.flxoa.info.projectmanagement.entity.FlxoaProjectBidInformation;
import com.flx.flxoa.info.system.dao.FlxoaSystemUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * 类名称：FlxoaSystemUserServiceImpl.java
 * 类描述：
 * 创建时间：2018-03-20, 下午06:22:03
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 张海英 
 */ 
@Service
@Transactional
public class FlxoaSystemUserServiceImpl implements FlxoaSystemUserService {
	private FlxoaSystemUserDao dao;
	@Autowired
	public void setDao(FlxoaSystemUserDao dao) {
		this.dao = dao;
	}
	public FlxoaSystemUserDao getDao() {
		return dao;
	}
	/**
	 *添加FlxoaSystemUser
	 */ 
	public boolean add(FlxoaSystemUser flxoaSystemUser) {
		boolean result = dao.add(flxoaSystemUser);
		return result;
	}
	/**
	 *删除FlxoaSystemUser
	 */ 
	public boolean delete(FlxoaSystemUser flxoaSystemUser) {
		boolean result = dao.delete(flxoaSystemUser);
		return result;
	}
	/**
	 *修改FlxoaSystemUser
	 */ 
	public boolean update(FlxoaSystemUser flxoaSystemUser) {
		boolean result = dao.update(flxoaSystemUser);
		return result;
	}
	/**
	 *查询FlxoaSystemUser列表
	 */ 
	public List<FlxoaSystemUser> query(FlxoaSystemUser flxoaSystemUser) {
		List<FlxoaSystemUser> list = dao.query(flxoaSystemUser);
		return list;
	}
	/**
	 *查询FlxoaSystemUser
	 */ 
	@Override
	public boolean isExist(String username) {
		boolean result = dao.isExist(username);
		
		return result;
	}
	/**
	 *查询FlxoaSystemUser ByID
	 */ 
	public FlxoaSystemUser queryById(FlxoaSystemUser flxoaSystemUser) {
		FlxoaSystemUser result = dao.queryById(flxoaSystemUser);
		return result;
	}
	/**
	 * 分页
	 */
	public List<FlxoaSystemUser> queryForPage(int pageNo,int pageSize){
		List<FlxoaSystemUser> list = dao.queryForPage(pageNo, pageSize);
		return list;
	}
	/**
	 * 根据用户名查询用户
	 */
	@Override
	@Transactional(readOnly = true)
	public FlxoaSystemUser findByUserName(String username) {
		FlxoaSystemUser entity = dao.findByUserName(username);
		return entity;
	}
	/**
	 * 根据用户id查询用户
	 */
	@Override
	public FlxoaSystemUser queryByUserId(FlxoaSystemUser flxoaSystemUser ) {
		return dao.queryByUserId(flxoaSystemUser);
	}
	
	/**
	 * 根据用户属性 查询用户权限
	 */	
	@Override
	public List<FlxoaSystemUser> findUserPermisson(FlxoaSystemUser flxoaSystemUser) {
		List<FlxoaSystemUser> list = dao.findUserPermisson(flxoaSystemUser);
		return list;
	}
	/**
	 * 查询部门人员的cardId
	 */
	@Override
	public List<FlxoaSystemUser> queryCardIds(int userid, String deptid) {
		List<FlxoaSystemUser> list = dao.queryCardIds(userid, deptid);
		return list;
	}
	/**
	 * 查询所有人员
	 */
	public List<FlxoaSystemUser> queryAllUser(){
		List<FlxoaSystemUser> list = dao.queryAllUser();
		return list;
	}
	/**
	 * 根据微信id查询用户
	 */
	@Override
	public FlxoaSystemUser getUserByWeixinId(FlxoaSystemUser flxoaSystemUser) {
		return dao.getUserByWeixinId(flxoaSystemUser);
	}
	/**
	 *分页FlxoaProjectBidInformation pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public String queryForPage(int pageNo,int pageSize,String draw,int userId, String deptIds,FlxoaSystemUser flxoaSystemUser) {
		 return dao.queryForPage(pageNo,pageSize,draw,userId,deptIds, flxoaSystemUser);
	}
	
	/**
	 * 根据用户属性查询用户详细信息
	 */
	public FlxoaSystemUser findUserDetialByUserName(FlxoaSystemUser flxoaSystemUser){
		FlxoaSystemUser entity = dao.findUserDetialByUserName(flxoaSystemUser);
		return entity;
	}
}