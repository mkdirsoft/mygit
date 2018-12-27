package com.flx.flxoa.info.system.manager.impl;


import java.util.List;
import com.flx.flxoa.info.system.entity.FlxoaSystemSso;
import com.flx.flxoa.info.system.manager.FlxoaSystemSsoService;
import com.flx.flxoa.info.system.dao.FlxoaSystemSsoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * 类名称：FlxoaSystemSsoServiceImpl.java
 * 类描述：
 * 创建时间：2018-05-07, 下午02:35:50
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 刘凯 
 */ 
@Service
@Transactional
public class FlxoaSystemSsoServiceImpl implements FlxoaSystemSsoService {
	private FlxoaSystemSsoDao dao;
	@Autowired
	public void setDao(FlxoaSystemSsoDao dao) {
		this.dao = dao;
	}
	public FlxoaSystemSsoDao getDao() {
		return dao;
	}
	/**
	 *添加FlxoaSystemSso
	 */ 
	public boolean add(FlxoaSystemSso flxoaSystemSso) {
		boolean result = dao.add(flxoaSystemSso);
		return result;
	}
	/**
	 *删除FlxoaSystemSso
	 */ 
	public boolean delete(FlxoaSystemSso flxoaSystemSso) {
		boolean result = dao.delete(flxoaSystemSso);
		return result;
	}
	/**
	 *修改FlxoaSystemSso
	 */ 
	public boolean update(FlxoaSystemSso flxoaSystemSso) {
		boolean result = dao.update(flxoaSystemSso);
		return result;
	}
	/**
	 *查询FlxoaSystemSso列表
	 */ 
	public List<FlxoaSystemSso> query(FlxoaSystemSso flxoaSystemSso) {
		List<FlxoaSystemSso> list = dao.query(flxoaSystemSso);
		return list;
	}
	/**
	 *查询FlxoaSystemSso ByID
	 */ 
	public FlxoaSystemSso queryById(FlxoaSystemSso flxoaSystemSso) {
		FlxoaSystemSso result = dao.queryById(flxoaSystemSso);
		return result;
	}
	/**
	 *分页FlxoaSystemSso pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<FlxoaSystemSso> queryForPage(int pageNo,int pageSize,FlxoaSystemSso flxoaSystemSso) {
		List<FlxoaSystemSso> list = dao.queryForPage(pageNo,pageSize,flxoaSystemSso);
		return list;
	}
	/**
	 *查询FlxoaSystemSso数据条数
	 */ 
	public Long queryCount(FlxoaSystemSso flxoaSystemSso) {
		Long result = dao.queryCount(flxoaSystemSso);
		return result;
	}
	
	/**
	 *根据属性查询FlxoaSystemSso
	 */ 
	public FlxoaSystemSso queryByPro(FlxoaSystemSso flxoaSystemSso) {
		FlxoaSystemSso result = dao.queryByPro(flxoaSystemSso);
		return result;
	}

}