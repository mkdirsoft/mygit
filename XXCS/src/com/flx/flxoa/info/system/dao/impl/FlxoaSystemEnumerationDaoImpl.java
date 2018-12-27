package com.flx.flxoa.info.system.dao.impl;


import java.util.List;
import com.flx.flxoa.info.system.entity.FlxoaSystemEnumeration;
import com.flx.flxoa.info.system.dao.FlxoaSystemEnumerationDao;
import org.springframework.stereotype.Repository;
import com.flx.flxoa.common.hibernate3.HibernateBaseDao;

/**
 *
 * 类名称：FlxoaSystemEnumerationDaoImpl.java
 * 类描述：
 * 创建时间：2018-04-21, 下午03:11:35
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 刘凯 
 */ 
@Repository
public class FlxoaSystemEnumerationDaoImpl extends HibernateBaseDao<FlxoaSystemEnumeration, Integer> implements FlxoaSystemEnumerationDao {
	/**
	 *添加FlxoaSystemEnumeration
	 */ 
	public boolean add(FlxoaSystemEnumeration flxoaSystemEnumeration) {
		return save(flxoaSystemEnumeration);
	}
	/**
	 *删除FlxoaSystemEnumeration
	 */ 
	public boolean delete(FlxoaSystemEnumeration flxoaSystemEnumeration) {
		flxoaSystemEnumeration.setDeleteFlag("1");
		return save(flxoaSystemEnumeration);
	}
	/**
	 *修改FlxoaSystemEnumeration
	 */ 
	public boolean update(FlxoaSystemEnumeration flxoaSystemEnumeration) {
		return modify(flxoaSystemEnumeration);
	}
	/**
	 *查询FlxoaSystemEnumeration列表
	 */ 
	public List<FlxoaSystemEnumeration> query(FlxoaSystemEnumeration flxoaSystemEnumeration) {
		String hql = " from FlxoaSystemEnumeration where delete_flag = '0' ";
		if(null != flxoaSystemEnumeration){
			if(null != flxoaSystemEnumeration.getEnumerationName()){
				if(!"".equals(flxoaSystemEnumeration.getEnumerationName())){
					hql += " and enumeration_name = '"+flxoaSystemEnumeration.getEnumerationName()+"'";
				}
			}
		}
		return getListByHQL(hql, null);
	}
	/**
	 *查询FlxoaSystemEnumeration ByID
	 */ 
	public FlxoaSystemEnumeration queryById(FlxoaSystemEnumeration flxoaSystemEnumeration) {
		return get(flxoaSystemEnumeration.getId());
	}
	/**
	 *分页FlxoaSystemEnumeration pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<FlxoaSystemEnumeration> queryForPage(int pageNo,int pageSize,FlxoaSystemEnumeration flxoaSystemEnumeration) {
		String hql = " from FlxoaSystemEnumeration where  enumeration_name = 'team_role' ";
		System.out.println("team"+hql);
		return getListByHQL(hql, null);
	}
	/**
	 *查询FlxoaSystemEnumeration数据条数 
	 */ 
	public Long queryCount(FlxoaSystemEnumeration flxoaSystemEnumeration) {
		String hql = "select count(*) from FlxoaSystemEnumeration where delete_flag = '0' ";
		return countByHql(hql,null);
	}
	
	@Override
	protected Class<FlxoaSystemEnumeration> getEntityClass() {
		return FlxoaSystemEnumeration.class;
	} 

}