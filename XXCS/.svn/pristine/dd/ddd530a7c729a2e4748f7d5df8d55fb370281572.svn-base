package com.flx.flxoa.info.market.manager.impl;



import java.util.List;
import com.flx.flxoa.info.market.entity.HxSyslog;
import com.flx.flxoa.info.market.manager.HxSyslogService;
import com.flx.flxoa.info.market.dao.HxSyslogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * 类名称：HxSyslogServiceImpl.java
 * 类描述：
 * 创建时间：2018-11-08, 下午03:30:30
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author leijun 
 */ 
@Service
@Transactional
public class HxSyslogServiceImpl implements HxSyslogService {
	private HxSyslogDao dao;
	@Autowired
	public void setDao(HxSyslogDao dao) {
		this.dao = dao;
	}
	public HxSyslogDao getDao() {
		return dao;
	}
	/**
	 *添加HxSyslog
	 */ 
	public boolean add(HxSyslog hxSyslog) {
		boolean result = dao.add(hxSyslog);
		return result;
	}
	/**
	 *删除HxSyslog
	 */ 
	public boolean delete(HxSyslog hxSyslog) {
		boolean result = dao.delete(hxSyslog);
		return result;
	}
	/**
	 *修改HxSyslog
	 */ 
	public boolean update(HxSyslog hxSyslog) {
		boolean result = dao.update(hxSyslog);
		return result;
	}
	/**
	 *查询HxSyslog列表
	 */ 
	public List<HxSyslog> query(HxSyslog hxSyslog) {
		List<HxSyslog> list = dao.query(hxSyslog);
		return list;
	}
	/**
	 *查询HxSyslog ByID
	 */ 
//	public HxSyslog queryById(HxSyslog hxSyslog) {
//		HxSyslog result = dao.queryById(hxSyslog);
//		return result;
//	}
	/**
	 *分页HxSyslog pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<HxSyslog> queryForPage(int pageNo,int pageSize,HxSyslog hxSyslog) {
		List<HxSyslog> list = dao.queryForPage(pageNo,pageSize,hxSyslog);
		return list;
	}
	/**
	 *查询HxSyslog数据条数
	 */ 
	public Long queryCount(HxSyslog hxSyslog) {
		Long result = dao.queryCount(hxSyslog);
		return result;
	}

}