package com.flx.flxoa.info.system.dao.impl;


import java.util.List;
import com.flx.flxoa.info.system.entity.FlxoaSystemSso;
import com.flx.flxoa.info.system.dao.FlxoaSystemSsoDao;
import org.springframework.stereotype.Repository;
import com.flx.flxoa.common.hibernate3.HibernateBaseDao;

/**
 *
 * 类名称：FlxoaSystemSsoDaoImpl.java
 * 类描述：
 * 创建时间：2018-05-07, 下午02:35:50
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 刘凯 
 */ 
@Repository
public class FlxoaSystemSsoDaoImpl extends HibernateBaseDao<FlxoaSystemSso, Integer> implements FlxoaSystemSsoDao {
	/**
	 *添加FlxoaSystemSso
	 */ 
	public boolean add(FlxoaSystemSso flxoaSystemSso) {
		return save(flxoaSystemSso);
	}
	/**
	 *删除FlxoaSystemSso
	 */ 
	public boolean delete(FlxoaSystemSso flxoaSystemSso) {
		flxoaSystemSso.setDeleteFlag("1");
		return save(flxoaSystemSso);
	}
	/**
	 *修改FlxoaSystemSso
	 */ 
	public boolean update(FlxoaSystemSso flxoaSystemSso) {
		return modify(flxoaSystemSso);
	}
	/**
	 *查询FlxoaSystemSso列表
	 */ 
	public List<FlxoaSystemSso> query(FlxoaSystemSso flxoaSystemSso) {
		String hql = " from FlxoaSystemSso where delete_flag = '0' ";
		return getListByHQL(hql, null);
	}
	
	/**
	 *根据属性查询FlxoaSystemSso
	 */ 
	public FlxoaSystemSso queryByPro(FlxoaSystemSso flxoaSystemSso) {
		String hql = " from FlxoaSystemSso where delete_flag = '0' ";
		if(null != flxoaSystemSso.getClientId()){
			if(!"".equals(flxoaSystemSso.getClientId())){
				hql += " and client_id = '"+flxoaSystemSso.getClientId()+"'";
			}
		}
		if(null != flxoaSystemSso.getClientSecret()){
			if(!"".equals(flxoaSystemSso.getClientSecret())){
				hql += " and client_secret = '"+flxoaSystemSso.getClientSecret()+"'";
			}
		}
		if(null != flxoaSystemSso.getRedirectUri()){
			if(!"".equals(flxoaSystemSso.getRedirectUri())){
				hql += " and redirect_uri = '"+flxoaSystemSso.getRedirectUri()+"'";
			}
		}		
		List<FlxoaSystemSso> list = getListByHQL(hql, null);
		if(list.size() > 0){
			return list.get(0);
		}else{
			return null;
		}
	}
	
	/**
	 *查询FlxoaSystemSso ByID
	 */ 
	public FlxoaSystemSso queryById(FlxoaSystemSso flxoaSystemSso) {
		return get(flxoaSystemSso.getId());
	}
	/**
	 *分页FlxoaSystemSso pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<FlxoaSystemSso> queryForPage(int pageNo,int pageSize,FlxoaSystemSso flxoaSystemSso) {
		String hql = " from FlxoaSystemSso where delete_flag = '0' ";
		return queryForPageByHQL(pageNo, pageSize, hql);
	}
	/**
	 *查询FlxoaSystemSso数据条数 
	 */ 
	public Long queryCount(FlxoaSystemSso flxoaSystemSso) {
		String hql = "select count(*) from FlxoaSystemSso where delete_flag = '0' ";
		return countByHql(hql,null);
	}
	
	@Override
	protected Class<FlxoaSystemSso> getEntityClass() {
		return FlxoaSystemSso.class;
	} 

}