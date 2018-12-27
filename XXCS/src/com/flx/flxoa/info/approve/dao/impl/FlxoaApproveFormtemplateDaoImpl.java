package com.flx.flxoa.info.approve.dao.impl;


import java.util.List;
import com.flx.flxoa.info.approve.entity.FlxoaApproveFormtemplate;
import com.flx.flxoa.info.approve.dao.FlxoaApproveFormtemplateDao;
import org.springframework.stereotype.Repository;
import com.flx.flxoa.common.hibernate3.HibernateBaseDao;

/**
 *
 * 类名称：FlxoaApproveFormtemplateDaoImpl.java
 * 类描述：
 * 创建时间：2018-03-23, 下午04:41:33
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 刘凯 
 */ 
@Repository
public class FlxoaApproveFormtemplateDaoImpl extends HibernateBaseDao<FlxoaApproveFormtemplate, Integer> implements FlxoaApproveFormtemplateDao {
	/**
	 *添加FlxoaApproveFormtemplate
	 */ 
	public boolean add(FlxoaApproveFormtemplate flxoaApproveFormtemplate) {
		return save(flxoaApproveFormtemplate);
	}
	/**
	 *删除FlxoaApproveFormtemplate
	 */ 
	public boolean delete(FlxoaApproveFormtemplate flxoaApproveFormtemplate) {
		flxoaApproveFormtemplate.setDeleteFlag("1");
		return save(flxoaApproveFormtemplate);
	}
	/**
	 *修改FlxoaApproveFormtemplate
	 */ 
	public boolean update(FlxoaApproveFormtemplate flxoaApproveFormtemplate) {
		return modify(flxoaApproveFormtemplate);
	}
	/**
	 *查询FlxoaApproveFormtemplate列表
	 */ 
	public List<FlxoaApproveFormtemplate> query(FlxoaApproveFormtemplate flxoaApproveFormtemplate) {
		String hql = " from FlxoaApproveFormtemplate where delete_flag = '0' ";
		if(null != flxoaApproveFormtemplate){
			if(null != flxoaApproveFormtemplate.getName()){
				if(!"".equals(flxoaApproveFormtemplate.getName())){
					hql += " and name like '%"+flxoaApproveFormtemplate.getName()+"%'";
				}
			}			
		}
		return getListByHQL(hql, null);
	}
	/**
	 *查询FlxoaApproveFormtemplate ByID
	 */ 
	public FlxoaApproveFormtemplate queryById(FlxoaApproveFormtemplate flxoaApproveFormtemplate) {
		return get(flxoaApproveFormtemplate.getId());
	}
	/**
	 *分页FlxoaApproveFormtemplate pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<FlxoaApproveFormtemplate> queryForPage(int pageNo,int pageSize,FlxoaApproveFormtemplate flxoaApproveFormtemplate) {
		String hql = " from FlxoaApproveFormtemplate where delete_flag = '0' ";
		return queryForPageByHQL(pageNo, pageSize, hql);
	}
	/**
	 *查询FlxoaApproveFormtemplate数据条数 
	 */ 
	public Long queryCount(FlxoaApproveFormtemplate flxoaApproveFormtemplate) {
		String hql = "select count(*) from FlxoaApproveFormtemplate where delete_flag = '0' ";
		return countByHql(hql,null);
	}
	
	@Override
	protected Class<FlxoaApproveFormtemplate> getEntityClass() {
		return FlxoaApproveFormtemplate.class;
	} 

}