package com.flx.flxoa.info.projectmanagement.dao.impl;


import java.util.List;
import com.flx.flxoa.info.projectmanagement.entity.FlxoaProjectFocus;
import com.flx.flxoa.info.system.entity.FlxoaSystemRoleFuncation;
import com.flx.flxoa.info.projectmanagement.dao.FlxoaProjectFocusDao;
import org.springframework.stereotype.Repository;
import com.flx.flxoa.common.hibernate3.HibernateBaseDao;

/**
 *
 * 类名称：FlxoaProjectFocusDaoImpl.java
 * 类描述：
 * 创建时间：2018-05-04, 上午10:38:52
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 张海英 
 */ 
@Repository
public class FlxoaProjectFocusDaoImpl extends HibernateBaseDao<FlxoaProjectFocus, Integer> implements FlxoaProjectFocusDao {
	/**
	 *添加FlxoaProjectFocus
	 */ 
	public boolean add(FlxoaProjectFocus flxoaProjectFocus) {
		return save(flxoaProjectFocus);
	}
	/**
	 *删除FlxoaProjectFocus
	 */ 
	public boolean delete(FlxoaProjectFocus flxoaProjectFocus) {
		flxoaProjectFocus.setDeleteFlag("1");
		return save(flxoaProjectFocus);
	}
	/**
	 *删除FlxoaSystemRole
	 */ 
	public boolean deleteName(FlxoaProjectFocus flxoaProjectFocus) {
		String sql = "delete from flxoa_project_focus Where id='"+flxoaProjectFocus.getId()+"'";
		System.out.println("hql========"+sql);
		executeSql(sql,null);
		return true;
	}
	/**
	 *修改FlxoaProjectFocus
	 */ 
	public boolean update(FlxoaProjectFocus flxoaProjectFocus) {
		return modify(flxoaProjectFocus);
	}
	/**
	 *查询FlxoaProjectFocus列表
	 */ 
	public List<FlxoaProjectFocus> query(FlxoaProjectFocus flxoaProjectFocus) {
		String hql = " from FlxoaProjectFocus where delete_flag = '0' ";
		return getListByHQL(hql, null);
	}
	/**
	 *查询FlxoaProjectFocus ByID
	 */ 
	public FlxoaProjectFocus queryById(FlxoaProjectFocus flxoaProjectFocus) {
		return get(flxoaProjectFocus.getId());
	}
	/**
	 *分页FlxoaProjectFocus pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<FlxoaProjectFocus> queryForPage(int pageNo,int pageSize,FlxoaProjectFocus flxoaProjectFocus) {
		String hql = " from FlxoaProjectFocus where delete_flag = '0' ";
		return queryForPageByHQL(pageNo, pageSize, hql);
	}
	/**
	 *查询FlxoaProjectFocus数据条数 
	 */ 
	public Long queryCount(FlxoaProjectFocus flxoaProjectFocus) {
		String hql = "select count(*) from FlxoaProjectFocus where delete_flag = '0' ";
		return countByHql(hql,null);
	}
	
	/**
	 * 根据用户名id和项目id查询关注项目
	 */
	@Override
	public List<FlxoaProjectFocus> getProjectFocus(
			FlxoaProjectFocus flxoaProjectFocus) {
		String hql = " from FlxoaProjectFocus where delete_flag = '0' and project_id ="+flxoaProjectFocus.getProjectId()+" and create_user_id ="+flxoaProjectFocus.getCreateUserId()+" ";
		return getListByHQL(hql, null);
		
	} 
	
	@Override
	protected Class<FlxoaProjectFocus> getEntityClass() {
		return FlxoaProjectFocus.class;
	}
	

}