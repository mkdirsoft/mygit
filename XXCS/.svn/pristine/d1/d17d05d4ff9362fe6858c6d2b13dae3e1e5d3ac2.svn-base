package com.flx.flxoa.info.approve.dao.impl;


import java.util.List;
import com.flx.flxoa.info.approve.entity.FlxoaApproveFormlog;
import com.flx.flxoa.info.approve.dao.FlxoaApproveFormlogDao;
import org.springframework.stereotype.Repository;
import com.flx.flxoa.common.hibernate3.HibernateBaseDao;

/**
 *
 * 类名称：FlxoaApproveFormlogDaoImpl.java
 * 类描述：
 * 创建时间：2018-03-23, 下午04:41:33
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 刘凯 
 */ 
@Repository
public class FlxoaApproveFormlogDaoImpl extends HibernateBaseDao<FlxoaApproveFormlog, Integer> implements FlxoaApproveFormlogDao {
	/**
	 *添加FlxoaApproveFormlog
	 */ 
	public boolean add(FlxoaApproveFormlog flxoaApproveFormlog) {
		return save(flxoaApproveFormlog);
	}
	/**
	 *删除FlxoaApproveFormlog
	 */ 
	public boolean delete(FlxoaApproveFormlog flxoaApproveFormlog) {
		flxoaApproveFormlog.setDeleteFlag("1");
		return save(flxoaApproveFormlog);
	}
	/**
	 *修改FlxoaApproveFormlog
	 */ 
	public boolean update(FlxoaApproveFormlog flxoaApproveFormlog) {
		return modify(flxoaApproveFormlog);
	}
	/**
	 * 删除撤销的审批流程
	 */
	public boolean deleteLog(FlxoaApproveFormlog flxoaApproveFormlog){
		//更改有效，失效的flag
		//先查询
		boolean flag = false;
		String hql = " from FlxoaApproveFormlog where form_id="+flxoaApproveFormlog.getFormId()+" and delete_flag = '0' ";
		List<FlxoaApproveFormlog>  speList = getListByHQL(hql, null);
		if(speList.size()>0){
			//查询前先进行修改flag 的值
			String updateSql="UPDATE  Flxoa_Approve_Formlog SET delete_flag = '1 ' WHERE form_id="+flxoaApproveFormlog.getFormId()+"  ";
			executeSql(updateSql);
			flag = true;
		}
		return flag;
	}
	/**
	 *查询FlxoaApproveFormlog列表
	 */ 
	public List<FlxoaApproveFormlog> query(FlxoaApproveFormlog flxoaApproveFormlog) {
		String hql = " from FlxoaApproveFormlog where delete_flag = '0'  ";
		if(null != flxoaApproveFormlog){
			if(null != flxoaApproveFormlog.getCreateUserId()){
				hql += " and create_user_id = "+flxoaApproveFormlog.getCreateUserId();
			}
			if(null != flxoaApproveFormlog.getFormId()){
				hql += " and form_id = "+flxoaApproveFormlog.getFormId();
			}			
		}
		hql += " order by create_time desc";
		return getListByHQL(hql, null);
	}
	/**
	 *查询FlxoaApproveFormlog ByID
	 */ 
	public FlxoaApproveFormlog queryById(FlxoaApproveFormlog flxoaApproveFormlog) {
		return get(flxoaApproveFormlog.getId());
	}
	/**
	 *分页FlxoaApproveFormlog pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<FlxoaApproveFormlog> queryForPage(int pageNo,int pageSize,FlxoaApproveFormlog flxoaApproveFormlog) {
		String hql = " from FlxoaApproveFormlog where delete_flag = '0' ";
		return queryForPageByHQL(pageNo, pageSize, hql);
	}
	/**
	 *查询FlxoaApproveFormlog数据条数 
	 */ 
	public Long queryCount(FlxoaApproveFormlog flxoaApproveFormlog) {
		String hql = "select count(*) from FlxoaApproveFormlog where delete_flag = '0' ";
		return countByHql(hql,null);
	}
	
	@Override
	protected Class<FlxoaApproveFormlog> getEntityClass() {
		return FlxoaApproveFormlog.class;
	} 

}