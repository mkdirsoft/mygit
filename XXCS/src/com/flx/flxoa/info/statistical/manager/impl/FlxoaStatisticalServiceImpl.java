package com.flx.flxoa.info.statistical.manager.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flx.flxoa.info.statistical.dao.FlxoaStatisticalDao;
import com.flx.flxoa.info.statistical.manager.FlxoaStatisticalService;

/**
 * 类名称：FlxoaStatisticalServiceImpl.java<br>
 * 类描述：<br>
 * 创建时间：2018-4-11, 下午7:36:37
 * 
 * @version 1.0 
 * @since JDK版本 1.7
 * @author 夏改翠 
 */
@Service
@Transactional
public class FlxoaStatisticalServiceImpl implements FlxoaStatisticalService{
	
	private FlxoaStatisticalDao dao;
	
	@Autowired
	public void setDao(FlxoaStatisticalDao dao) {
		this.dao = dao;
	}
	public FlxoaStatisticalDao getDao() {
		return dao;
	}

	@Override
	public List<Map<String, Object>> queryByDeptid(String deptid) {
		 List<Map<String, Object>> list = dao.queryByDeptid(deptid);
		return list;
	}
	@Override
	public String queryFormNoApproval(int start,int length,String draw,String userid) {
		 
		return dao.queryFormNoApproval(start, length,draw,userid);
	}
	@Override
	public String queryMyProject(int start, int length, String draw,String userid) {
		return dao.queryMyProject(start, length, draw, userid);
	}
	/**
	 * 首页 求个人本月内的打卡情况（迟到，打卡异常，正常，请假）的次数
	 */
	@Override
	public List<Map<String,Object>>  querySumPerson(int userid){
		return dao.querySumPerson(userid);
	}
	@Override
	public String querySumDept(int start, int length, String draw, String deptid) {
		return dao.querySumDept(start, length, draw, deptid);
	}
	@Override
	public String queryMyFocusProject(int start, int length, String draw,String userid) {
		
		return dao.queryMyFocusProject(start, length, draw, userid);
	}
	@Override
	public String queryPersonSign(int start, int length, String draw,String userid) {
		
		return dao.queryPersonSign(start, length, draw, userid);
	}
	@Override
	public List<Map<String, Object>> queryHuiKuan(String name, String deptIds) {
		
		
		return dao.queryHuiKuan(name,deptIds);
	}

}

