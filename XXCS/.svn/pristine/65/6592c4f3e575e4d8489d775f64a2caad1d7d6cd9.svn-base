package com.flx.flxoa.info.system.manager.impl;


import java.util.List;
import com.flx.flxoa.info.system.entity.FlxoaSystemUserGroupUser;
import com.flx.flxoa.info.system.manager.FlxoaSystemUserGroupUserService;
import com.flx.flxoa.info.system.dao.FlxoaSystemUserGroupUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * 类名称：FlxoaSystemUserGroupUserServiceImpl.java
 * 类描述：
 * 创建时间：2018-03-28, 上午11:15:33
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 赵鹏辉 
 */ 
@Service
@Transactional
public class FlxoaSystemUserGroupUserServiceImpl implements FlxoaSystemUserGroupUserService {
	private FlxoaSystemUserGroupUserDao dao;
	@Autowired
	public void setDao(FlxoaSystemUserGroupUserDao dao) {
		this.dao = dao;
	}
	public FlxoaSystemUserGroupUserDao getDao() {
		return dao;
	}
	/**
	 *添加FlxoaSystemUserGroupUser
	 */ 
	public boolean add(FlxoaSystemUserGroupUser flxoaSystemUserGroupUser) {
		boolean result = dao.add(flxoaSystemUserGroupUser);
		return result;
	}
	/**
	 *删除FlxoaSystemUserGroupUser
	 */ 
	public boolean delete(FlxoaSystemUserGroupUser flxoaSystemUserGroupUser) {
		boolean result = dao.delete(flxoaSystemUserGroupUser);
		return result;
	}
	/**
	 *修改FlxoaSystemUserGroupUser
	 */ 
	public boolean update(FlxoaSystemUserGroupUser flxoaSystemUserGroupUser) {
		boolean result = dao.update(flxoaSystemUserGroupUser);
		return result;
	}
	/**
	 *查询FlxoaSystemUserGroupUser列表
	 */ 
	public List<FlxoaSystemUserGroupUser> query(FlxoaSystemUserGroupUser flxoaSystemUserGroupUser) {
		List<FlxoaSystemUserGroupUser> list = dao.query(flxoaSystemUserGroupUser);
		return list;
	}
	/**
	 *查询FlxoaSystemUserGroupUser ByID
	 */ 
	public FlxoaSystemUserGroupUser queryById(FlxoaSystemUserGroupUser flxoaSystemUserGroupUser) {
		FlxoaSystemUserGroupUser result = dao.queryById(flxoaSystemUserGroupUser);
		return result;
	}
	/**
	 *分页FlxoaSystemUserGroupUser pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<FlxoaSystemUserGroupUser> queryForPage(int pageNo,int pageSize,FlxoaSystemUserGroupUser flxoaSystemUserGroupUser) {
		List<FlxoaSystemUserGroupUser> list = dao.queryForPage(pageNo,pageSize,flxoaSystemUserGroupUser);
		return list;
	}
	/**
	 *查询FlxoaSystemUserGroupUser数据条数
	 */ 
	public Long queryCount(FlxoaSystemUserGroupUser flxoaSystemUserGroupUser) {
		Long result = dao.queryCount(flxoaSystemUserGroupUser);
		return result;
	}
	/**
	 * 删除
	 */
	public boolean deleteByGroupId(FlxoaSystemUserGroupUser flxoaSystemUserGroupUser){
		boolean result = dao.deleteByGroupId(flxoaSystemUserGroupUser);
		return result;
	}
}