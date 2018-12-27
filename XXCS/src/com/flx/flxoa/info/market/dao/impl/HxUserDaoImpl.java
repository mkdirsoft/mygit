package com.flx.flxoa.info.market.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.flx.flxoa.info.market.dao.HxUserDao;
import com.flx.flxoa.info.market.entity.HxUser;
import com.flx.flxoa.info.system.entity.FlxoaSystemUser;

import org.springframework.stereotype.Repository;
import com.flx.flxoa.common.hibernate3.HibernateBaseDao;

/**
 *
 * 类名称：HxUserDaoImpl.java
 * 类描述：
 * 创建时间：2018-11-08, 下午03:05:40
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author leijun 
 */ 
@Repository
public class HxUserDaoImpl extends HibernateBaseDao<HxUser, Integer> implements HxUserDao {
	/**
	 *添加HxUser
	 */ 
	public boolean add(HxUser hxUser) {
		return save(hxUser);
	}
	/**
	 *删除HxUser
	 */ 
	public boolean delete(HxUser hxUser) {
		hxUser.setDeleteFlag("1");
		return save(hxUser);
	}
	/**
	 *修改HxUser
	 */ 
	public boolean update(HxUser hxUser) {
		return modify(hxUser);
	}
	/**
	 *查询HxUser列表
	 */ 
	public List<HxUser> query(HxUser hxUser) {
		String hql = " from HxUser where delete_flag = '0' ";
		return getListByHQL(hql, null);
	}
	@Override
	public boolean isExist(String username) {
		String hql="from HxUser where tel='"+username+"' ";
		List list=queryByHQL(hql);
		if(list.size()<1){
			return true;
		}
		return false;
	} 
	/**
	 * 根据用户属性查询用户详细信息
	 */
	public HxUser findUserDetialByUserName(HxUser hxUser){
		
		String sql = "select * from  hx_user  where tel = '"+hxUser.getTel()+"'" ;
		List list = getListBySQL(sql, null);
		List<HxUser> formList = new ArrayList<HxUser>();
		for (int i = 0; i < list.size(); i++) {
			HxUser form = new HxUser();
			Object[] objects = (Object[])list.get(i);
			form.setUserId((Integer)(objects[0]));
			form.setUserName(String.valueOf(objects[1]));
			form.setUserRealName(String.valueOf(objects[2]));
			form.setPassWord(String.valueOf(objects[3]));
			form.setTel(String.valueOf(objects[4]));
			form.setEmail(String.valueOf(objects[5]));
			form.setUserType(String.valueOf(objects[6]));
			form.setTokenId(String.valueOf(objects[7]));
			formList.add(form);
		}
		if(formList.size() == 1){
			return formList.get(0);  
		}else{
			return null;
		}
	}
	/**
	 *查询HxUser ByID
	 */ 
	public HxUser queryById(HxUser hxUser) {
		String hql = "  from HxUser where tel = '"+hxUser.getTel()+"'    ";
		return getByHQL(hql,null);
	}
	/**
	 *分页HxUser pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<HxUser> queryForPage(int pageNo,int pageSize,HxUser hxUser) {
		String hql = " from HxUser where delete_flag = '0' ";
		return queryForPageByHQL(pageNo, pageSize, hql);
	}
	/**
	 *查询HxUser数据条数 
	 */ 
	public Long queryCount(HxUser hxUser) {
		String hql = "select count(*) from HxUser where delete_flag = '0' ";
		return countByHql(hql,null);
	}
	
	@Override
	protected Class<HxUser> getEntityClass() {
		return HxUser.class;
	} 

}