package com.flx.flxoa.info.system.comon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.flx.flxoa.info.signin.manager.FlxoaAttendanceSigndetailsImportService;
import com.flx.flxoa.info.system.entity.FlxoaSystemDepartment;
import com.flx.flxoa.info.system.entity.FlxoaSystemUser;
import com.flx.flxoa.info.system.manager.FlxoaSystemDepartmentService;
import com.flx.flxoa.info.system.manager.FlxoaSystemUserRoleService;
import com.flx.flxoa.info.system.manager.FlxoaSystemUserService;

/**
 * 类名称：Permission.java
 * 类描述：
 * 创建时间：2018-4-3, 上午10:21:18
 * 
 * @version 1.0 
 * @since JDK版本 1.7
 * @author 刘凯 
 */
public class Permission {
	
	/**
	 * 用户权限
	 * userId 用户id
	 * */		
	public static List<FlxoaSystemUser> getUserPermission(Integer userId)
	{
		//根据用户id 获取其所对应的角色id以及部门id
		//根据角色id 获取对应的角色名称和其所对应的功能id
		//根据功能id获取所有的url
		FlxoaSystemUser flxoaSystemUser = new FlxoaSystemUser();
		flxoaSystemUser.setId(userId);
		List<FlxoaSystemUser> list = new ArrayList<FlxoaSystemUser>();
		//得到Service Bean
		WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();		
		FlxoaSystemUserService flxoaSystemUserService = (FlxoaSystemUserService)webApplicationContext.getBean("FlxoaSystemUserService");
		list = flxoaSystemUserService.findUserPermisson(flxoaSystemUser);
		return list;
	}
	
	/**
	 * 返回访问此url可以查看的角色和部门ids  map
	 * userId 用户id       url 当前请求的url
	 * */	
	public static Map<String,List<Integer>> getRolePermission(Integer userId,String url)
	{
		Map<String,List<Integer>> map = new HashMap<String, List<Integer>>();
        //超级管理员 拥有最高数据权限
        if(1 != userId)
		{
    		//获取用户权限
    		List<FlxoaSystemUser> list = getUserPermission(userId);
    		//保存上一次的角色名称
    		String roleName = "";
    		//保存部门ids
    		List<Integer> departMentlist = null;
    		for (int i = 0; i < list.size(); i++) {
    			if(!roleName.equals(list.get(i).getRoleName())){
    				departMentlist = new ArrayList<Integer>();
    			}
    			if(url.equals(list.get(i).getUrl())){
    				departMentlist.add(list.get(i).getManageDepartmentId());
    				boolean flag = map.containsKey(list.get(i).getRoleName());
    				if(!flag)
    				{
    					map.put(list.get(i).getRoleName(), departMentlist);
    				}
    			}
    			roleName = list.get(i).getRoleName();
    		}			
		}else{
			String roleName = "超级管理员";
			//得到Service Bean
			WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();		
			FlxoaSystemDepartmentService flxoaSystemDepartmentService = (FlxoaSystemDepartmentService)webApplicationContext.getBean("FlxoaSystemDepartmentService");
			FlxoaSystemDepartment flxoaSystemDepartment = new FlxoaSystemDepartment();
			List<FlxoaSystemDepartment> list = flxoaSystemDepartmentService.query(flxoaSystemDepartment);
    		//保存部门ids
    		List<Integer> departMentlist = new ArrayList<Integer>();
    		for (int i = 0; i < list.size(); i++) {
    			departMentlist.add(list.get(i).getId());
    		}
    		map.put(roleName, departMentlist);
		}

        return map;
	}
	
	/**
	 * 根据(角色 部门ids)String 返回不重复的部门ids  含普通员工
	 * 
	 * */	
	public static String getDepartMentIds(Map<String,List<Integer>> map)
	{
		String ids = "";
		Map<Integer,String> mapList = new HashMap<Integer,String>();
		if(null != map){
			if(map.size() > 0){
				//遍历map
				for (Entry<String, List<Integer>> entry : map.entrySet()) {
					for (int i = 0; i < entry.getValue().size(); i++) {
						mapList.put(entry.getValue().get(i),"");
					}
				}
				//遍历map
				for (Entry<Integer, String> entry : mapList.entrySet()) {
					ids += entry.getKey()+",";
				}
				if(!"".equals(ids)){
					ids = ids.substring(0, ids.length()-1);
				}				
			}
		}
		return ids;
	}
	
	
	/**
	 * 根据(角色 部门ids)String 返回不重复的部门ids  不含普通员工（但是包含 回款认领，回款确认 等不具有 查看部门内容的角色 的部门id）
	 * 
	 * */
	public static String getDepartMentIdsNo(Map<String,List<Integer>> map)
	{
		String ids = "";
		Map<Integer,String> mapList = new HashMap<Integer,String>();
		if(null != map){
			if(map.size() > 0){
				//遍历map
				for (Entry<String, List<Integer>> entry : map.entrySet()) {
					for (int i = 0; i < entry.getValue().size(); i++) {
						if(!entry.getKey().equals("普通员工")&&!entry.getKey().equals("子公司普通员工")){
							mapList.put(entry.getValue().get(i),"");
						}
					}
				}
				//遍历map
				for (Entry<Integer, String> entry : mapList.entrySet()) {
					ids += entry.getKey()+",";
				}
				if(!"".equals(ids)){
					ids = ids.substring(0, ids.length()-1);
				}
			}
		}
		return ids;
	}
	
	/**
	 * 返回用户    当前url请求 所能查看的 部门ids
	 * userId 用户id
	 * url 当前请求url
	 * flag  true  包含普通员工部门、子公司普通员工id  false 不包含普通员工部门、子公司普通员工id
	 * */
	public static String getPermissionDepartMentIds(Integer userId,String url,boolean flag){
		Map<String,List<Integer>> map = getRolePermission(userId,url);
		String ids = "";
		if(flag){
			ids = getDepartMentIds(map);
		}else{
			ids = getDepartMentIdsNo(map);
		}
		return ids;
	}
	
	
	/**
	 * 返回用户所有角色
	 * userId 用户id
	 * */	
	public static String getRolesByUserId(Integer userId){
		Map<String,String> map = new HashMap<String, String>();
		String roles = "";
		//获取用户权限
		List<FlxoaSystemUser> list = getUserPermission(userId);
		for (int i = 0; i < list.size(); i++) {
			map.put(list.get(i).getRoleName(), list.get(i).getRoleName());
		}
		//遍历map
		for (Entry<String, String> entry : map.entrySet()) {
			roles += entry.getValue()+",";
		}
		if(!"".equals(roles)){
			roles = roles.substring(0, roles.length()-1);
		}		
		return roles;
	}
	
}
