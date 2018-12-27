package com.flx.flxoa.info.projectmanagement.manager.impl;


import java.util.List;
import com.flx.flxoa.info.projectmanagement.entity.FlxoaProjectTeam;
import com.flx.flxoa.info.projectmanagement.manager.FlxoaProjectTeamService;
import com.flx.flxoa.info.projectmanagement.dao.FlxoaProjectTeamDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * 类名称：FlxoaProjectTeamServiceImpl.java
 * 类描述：
 * 创建时间：2018-03-19, 下午01:54:28
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 雷君 
 */ 
@Service
@Transactional
public class FlxoaProjectTeamServiceImpl implements FlxoaProjectTeamService {
	private FlxoaProjectTeamDao dao;
	@Autowired
	public void setDao(FlxoaProjectTeamDao dao) {
		this.dao = dao;
	}
	public FlxoaProjectTeamDao getDao() {
		return dao;
	}
	/**
	 *添加FlxoaProjectTeam
	 */ 
	public boolean add(FlxoaProjectTeam flxoaProjectTeam) {
		boolean result = dao.add(flxoaProjectTeam);
		return result;
	}
	/**
	 *删除FlxoaProjectTeam
	 */ 
	public boolean delete(FlxoaProjectTeam flxoaProjectTeam) {
		boolean result = dao.delete(flxoaProjectTeam);
		return result;
	}
	/**
	 *修改FlxoaProjectTeam
	 */ 
	public boolean update(FlxoaProjectTeam flxoaProjectTeam) {
		boolean result = dao.update(flxoaProjectTeam);
		return result;
	}
	public boolean isExist(String username) {
		boolean result = dao.isExist(username);
		
		return result;
	}
	/**
	 *查询FlxoaProjectTeam列表
	 */ 
	public List<FlxoaProjectTeam> query(FlxoaProjectTeam flxoaProjectTeam) {
		List<FlxoaProjectTeam> list = dao.query(flxoaProjectTeam);
		return list;
	}
	/**
	 *查询FlxoaProjectTeam ByID
	 */ 
	public FlxoaProjectTeam queryById(FlxoaProjectTeam flxoaProjectTeam) {
		FlxoaProjectTeam result = dao.queryById(flxoaProjectTeam);
		return result;
	}
}