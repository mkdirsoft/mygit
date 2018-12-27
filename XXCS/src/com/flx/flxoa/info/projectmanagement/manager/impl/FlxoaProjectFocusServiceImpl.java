package com.flx.flxoa.info.projectmanagement.manager.impl;


import java.util.List;
import com.flx.flxoa.info.projectmanagement.entity.FlxoaProjectFocus;
import com.flx.flxoa.info.projectmanagement.manager.FlxoaProjectFocusService;
import com.flx.flxoa.info.projectmanagement.dao.FlxoaProjectFocusDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * 类名称：FlxoaProjectFocusServiceImpl.java
 * 类描述：
 * 创建时间：2018-05-04, 上午10:38:52
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 张海英 
 */ 
@Service
@Transactional
public class FlxoaProjectFocusServiceImpl implements FlxoaProjectFocusService {
	private FlxoaProjectFocusDao dao;
	@Autowired
	public void setDao(FlxoaProjectFocusDao dao) {
		this.dao = dao;
	}
	public FlxoaProjectFocusDao getDao() {
		return dao;
	}
	/**
	 *添加FlxoaProjectFocus
	 */ 
	public boolean add(FlxoaProjectFocus flxoaProjectFocus) {
		boolean result = dao.add(flxoaProjectFocus);
		return result;
	}
	/**
	 *删除FlxoaProjectFocus
	 */ 
	public boolean delete(FlxoaProjectFocus flxoaProjectFocus) {
		boolean result = dao.delete(flxoaProjectFocus);
		return result;
	}
	/**
	 *删除FlxoaProjectFocus
	 */ 
	public boolean deleteName(FlxoaProjectFocus flxoaProjectFocus) {
		boolean result = dao.deleteName(flxoaProjectFocus);
		return result;
	}
	/**
	 *修改FlxoaProjectFocus
	 */ 
	public boolean update(FlxoaProjectFocus flxoaProjectFocus) {
		boolean result = dao.update(flxoaProjectFocus);
		return result;
	}
	/**
	 *查询FlxoaProjectFocus列表
	 */ 
	public List<FlxoaProjectFocus> query(FlxoaProjectFocus flxoaProjectFocus) {
		List<FlxoaProjectFocus> list = dao.query(flxoaProjectFocus);
		return list;
	}
	/**
	 *查询FlxoaProjectFocus ByID
	 */ 
	public FlxoaProjectFocus queryById(FlxoaProjectFocus flxoaProjectFocus) {
		FlxoaProjectFocus result = dao.queryById(flxoaProjectFocus);
		return result;
	}
	/**
	 *分页FlxoaProjectFocus pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<FlxoaProjectFocus> queryForPage(int pageNo,int pageSize,FlxoaProjectFocus flxoaProjectFocus) {
		List<FlxoaProjectFocus> list = dao.queryForPage(pageNo,pageSize,flxoaProjectFocus);
		return list;
	}
	/**
	 *查询FlxoaProjectFocus数据条数
	 */ 
	public Long queryCount(FlxoaProjectFocus flxoaProjectFocus) {
		Long result = dao.queryCount(flxoaProjectFocus);
		return result;
	}
	/**
	 * 根据项目id和用户名查询关注项目
	 */
	@Override
	public List<FlxoaProjectFocus> getProjectFocus(
			FlxoaProjectFocus flxoaProjectFocus) {
		return dao.getProjectFocus(flxoaProjectFocus);
	}

}