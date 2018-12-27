package com.flx.flxoa.info.market.manager.impl;

import java.util.List;
import com.flx.flxoa.info.market.entity.HxUser;
import com.flx.flxoa.info.market.manager.HxUserService;
import com.flx.flxoa.info.system.entity.FlxoaSystemUser;
import com.flx.flxoa.info.market.dao.HxUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * 类名称：HxUserServiceImpl.java
 * 类描述：
 * 创建时间：2018-11-08, 下午03:05:40
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author leijun 
 */ 
@Service
@Transactional
public class HxUserServiceImpl implements HxUserService {
	private HxUserDao dao;
	@Autowired
	public void setDao(HxUserDao dao) {
		this.dao = dao;
	}
	public HxUserDao getDao() {
		return dao;
	}
	/**
	 *添加HxUser
	 */ 
	public boolean add(HxUser hxUser) {
		boolean result = dao.add(hxUser);
		return result;
	}
	/**
	 *删除HxUser
	 */ 
	public boolean delete(HxUser hxUser) {
		boolean result = dao.delete(hxUser);
		return result;
	}
	/**
	 *修改HxUser
	 */ 
	public boolean update(HxUser hxUser) {
		boolean result = dao.update(hxUser);
		return result;
	}
	/**
	 *查询HxUser列表
	 */ 
	public List<HxUser> query(HxUser hxUser) {
		List<HxUser> list = dao.query(hxUser);
		return list;
	}
	/**
	 *查询HxUser
	 */ 
	@Override
	public boolean isExist(String username) {
		boolean result = dao.isExist(username);
		
		return result;
	}
	/**
	 * 根据用户属性查询用户详细信息
	 */
	public HxUser findUserDetialByUserName(HxUser hxUser){
		HxUser entity = dao.findUserDetialByUserName(hxUser);
		return entity;
	}
	/**
	 *查询HxUser ByID
	 */ 
	public HxUser queryById(HxUser hxUser) {
		HxUser result = dao.queryById(hxUser);
		return result;
	}
	/**
	 *分页HxUser pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<HxUser> queryForPage(int pageNo,int pageSize,HxUser hxUser) {
		List<HxUser> list = dao.queryForPage(pageNo,pageSize,hxUser);
		return list;
	}
	/**
	 *查询HxUser数据条数
	 */ 
	public Long queryCount(HxUser hxUser) {
		Long result = dao.queryCount(hxUser);
		return result;
	}

}