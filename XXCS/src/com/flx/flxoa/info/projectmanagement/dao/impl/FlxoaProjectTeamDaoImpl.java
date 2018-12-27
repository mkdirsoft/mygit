package com.flx.flxoa.info.projectmanagement.dao.impl;


import java.util.List;
import com.flx.flxoa.info.projectmanagement.entity.FlxoaProjectTeam;
import com.flx.flxoa.info.system.entity.FlxoaSystemEnumeration;
import com.flx.flxoa.info.projectmanagement.dao.FlxoaProjectTeamDao;
import org.springframework.stereotype.Repository;
import com.flx.flxoa.common.hibernate3.HibernateBaseDao;

/**
 *
 * 类名称：FlxoaProjectTeamDaoImpl.java
 * 类描述：
 * 创建时间：2018-03-19, 下午01:54:28
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 雷君 
 */ 
@Repository
public class FlxoaProjectTeamDaoImpl extends HibernateBaseDao<FlxoaProjectTeam, Integer> implements FlxoaProjectTeamDao {
	/**
	 *添加FlxoaProjectTeam
	 */ 
	public boolean add(FlxoaProjectTeam flxoaProjectTeam) {
		return save(flxoaProjectTeam);
	}
	/**
	 *删除FlxoaProjectTeam
	 */ 
	public boolean delete(FlxoaProjectTeam flxoaProjectTeam) {
		flxoaProjectTeam.setDeleteFlag("1");
		return save(flxoaProjectTeam);
	}
	/**
	 *修改FlxoaProjectTeam
	 */ 
	public boolean update(FlxoaProjectTeam flxoaProjectTeam) {
		return modify(flxoaProjectTeam);
	}
	@Override
	public boolean isExist(String username) {
		String hql="from FlxoaProjectTeam where proj_team_name='"+username+"' ";
		List list=queryByHQL(hql);
		if(list.size()<1){
			return true;
		}
		return false;
	} 
	/**
	 *查询FlxoaProjectTeam列表
	 */ 
	public List<FlxoaProjectTeam> query(FlxoaProjectTeam flxoaProjectTeam) {
		String hql = " from FlxoaProjectTeam where delete_flag = '0' and  proj_information_id = '"+flxoaProjectTeam.getProjInformationId()+"'";
		return getListByHQL(hql, null);
	}
	
	/**
	 *查询FlxoaProjectTeam列表
	 */ 
	public List<FlxoaProjectTeam> queryRole(FlxoaSystemEnumeration flxoaSystemEnumeration) {
		String hql = " from FlxoaSystemEnumeration where enumeration_name = 'team_role' ";
		return getListByHQL(hql, null);
	}
	/**
	 *查询FlxoaProjectTeam ByID
	 */ 
	public FlxoaProjectTeam queryById(FlxoaProjectTeam flxoaProjectTeam) {
		return get(flxoaProjectTeam.getId());
	}
	
	@Override
	protected Class<FlxoaProjectTeam> getEntityClass() {
		return FlxoaProjectTeam.class;
	} 

}