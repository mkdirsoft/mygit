package com.flx.flxoa.info.clientsManagement.manager;

import java.util.Map;


/**
*
* 类名称：FlxoaClientFollowerChangeService.java
* 类描述：
* 创建时间：2018-09-21, 上午09:53:41
*
*@version 1.0 
*@since JDK版本1.7 
*@author 孙进 
*/ 
public interface FlxoaClientFollowerChangeService {

	/**
	 * 查询所有用户角色为“销售人员”的用户详细信息
	 * */
	public String queryForPage(Map<String,String> map);
}
