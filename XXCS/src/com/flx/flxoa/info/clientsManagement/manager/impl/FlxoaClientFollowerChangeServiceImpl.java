package com.flx.flxoa.info.clientsManagement.manager.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flx.flxoa.info.clientsManagement.dao.FlxoaClientFollowerChangeDao;
import com.flx.flxoa.info.clientsManagement.manager.FlxoaClientFollowerChangeService;
@Service
@Transactional
public class FlxoaClientFollowerChangeServiceImpl implements FlxoaClientFollowerChangeService {

	private FlxoaClientFollowerChangeDao dao;
	@Autowired
	public void setDao(FlxoaClientFollowerChangeDao dao) {
		this.dao = dao;
	}
	public FlxoaClientFollowerChangeDao getDao() {
		return dao;
	}
	
	public String queryForPage(Map<String, String> map) {
		return dao.queryForPage(map);
	}

}
