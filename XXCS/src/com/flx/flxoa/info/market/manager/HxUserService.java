package com.flx.flxoa.info.market.manager;


import java.util.List;
import com.flx.flxoa.info.market.entity.HxUser;
import com.flx.flxoa.info.system.entity.FlxoaSystemUser;

/**
 *
 * 类名称：HxUserService.java
 * 类描述：
 * 创建时间：2018-11-08, 下午03:05:40
 *
 *@version 1.0 
 *@since JDK版本1.7 
 *@author leijun 
 */ 
public interface HxUserService {
	/**
	 *添加HxUser
	 */ 
	public boolean add(HxUser hxUser);
	/**
	 *删除HxUser
	 */ 
	public boolean delete(HxUser hxUser);
	/**
	 *修改HxUser
	 */ 
	public boolean update(HxUser hxUser);
	/**
	 *查询HxUser列表
	 */ 
	public List<HxUser> query(HxUser hxUser);
	/**
	 *查询HxUser
	 */ 
	public boolean isExist(String username);
	/**
	 * 根据用户属性查询用户详细信息
	 */
	public HxUser findUserDetialByUserName(HxUser hxUser);	
	/**
	 *查询HxUser ByID
	 */ 
	public HxUser queryById(HxUser hxUser);
	/**
	 *分页HxUser pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<HxUser> queryForPage(int pageNo,int pageSize,HxUser hxUser);
	/**
	 *查询HxUser数据条数
	 */ 
	public Long queryCount(HxUser hxUser);

 }