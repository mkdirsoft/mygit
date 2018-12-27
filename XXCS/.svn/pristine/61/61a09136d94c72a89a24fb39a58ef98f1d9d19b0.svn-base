package com.flx.flxoa.info.system.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flx.flxoa.common.util.CommonUtils;
import com.flx.flxoa.info.signin.entity.FlxoaAttendanceSummary;
import com.flx.flxoa.info.system.comon.Permission;
import com.flx.flxoa.info.system.entity.DepartmentTree;
import com.flx.flxoa.info.system.entity.FlxoaSystemDepartment;
import com.flx.flxoa.info.system.entity.FlxoaSystemFuncation;
import com.flx.flxoa.info.system.entity.FlxoaSystemUser;
import com.flx.flxoa.info.system.entity.FunctionJsonBean;
import com.flx.flxoa.info.system.manager.FlxoaSystemDepartmentService;
import com.flx.flxoa.info.system.manager.FlxoaSystemUserService;

/**
 * 类名称：FlxoaSystemDepartmentController.java<br>
 * 类描述：<br>
 * 创建时间：2018-3-28, 下午3:39:47
 * 
 * @version 1.0 
 * @since JDK版本 1.7
 * @author 夏改翠 
 */
@Controller
public class FlxoaSystemDepartmentController {
	
	protected FlxoaSystemDepartmentService flxoaSystemDepartmentService;	
	protected FlxoaSystemUserService   flxoaSystemUserService;
	@Autowired
	public void setFlxoaSystemUserService(
			FlxoaSystemUserService flxoaSystemUserService) {
		this.flxoaSystemUserService = flxoaSystemUserService;
	}
	@Autowired
	public void setFlxoaSystemDepartmentService(
			FlxoaSystemDepartmentService flxoaSystemDepartmentService) {
		this.flxoaSystemDepartmentService = flxoaSystemDepartmentService;
	}

	/**
	 * 含有人的树形结构
	 */
	@ResponseBody
	@RequestMapping(value = "system/showpersondept")
	public String showPersonDept(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		//排除的用户ids
		String ids = "";
		//需要选中的ids
		String checkIds = "";
		if(null != request.getParameter("ids")){
			ids = request.getParameter("ids");
		}
		if(null != request.getParameter("checkIds")){
			checkIds = request.getParameter("checkIds");
		}		
		List<DepartmentTree>  deptList  =  flxoaSystemDepartmentService.querySQL();
		
		List<DepartmentTree>  dpList= new ArrayList<DepartmentTree>();
		
		List<FlxoaSystemUser> userList = flxoaSystemUserService.queryAllUser();
		for(int i = 0 ;i<deptList.size();i++){
			int deptid = deptList.get(i).getId();
			deptList.get(i).setId(deptList.get(i).getId()+1000000);
			deptList.get(i).setPid(deptList.get(i).getPid()+1000000);
			deptList.get(i).setNocheck(true);
			dpList.add(deptList.get(i));
			for(int j=0;j<userList.size();j++){
				int udeptid = userList.get(j).getDepartmentId();
				if(deptid == udeptid){
					DepartmentTree dept = new DepartmentTree();					
					dept.setId(userList.get(j).getId());
					dept.setPid(deptid+1000000);
					dept.setName(userList.get(j).getRealName());
					dept.setNocheck(false);
					//根据传来的参数需要选中的ids
					if(!"".equals(checkIds)){
						if(-1 != checkIds.indexOf(",")){
							String [] temp = checkIds.split(",");
							for (int k = 0; k < temp.length; k++) {
								if(userList.get(j).getId() == Integer.parseInt(temp[k])){
									dept.setChecked(true);
								}
							}
						}else{
							if(userList.get(j).getId() == Integer.parseInt(checkIds)){
								dept.setChecked(true);
							}
						}						
					}
					//根据传来的参数需要排除的ids
					if("".equals(ids)){
						dpList.add(dept);						
					}else{
						if(-1 != ids.indexOf(",")){
							String [] temp = ids.split(",");
							for (int k = 0; k < temp.length; k++) {
								if(userList.get(j).getId() != Integer.parseInt(temp[k])){
									dpList.add(dept);
								}
							}
						}else{
							if(userList.get(j).getId() != Integer.parseInt(ids)){
								dpList.add(dept);
							}
						}
					}

				}
			}
			
		}
		JSONArray json = JSONArray.fromObject(dpList);
		System.out.print(json.toString());
		return json.toString();
	}
	/*
	 * 部门树结构
	 */
	@ResponseBody
	@RequestMapping(value = "system/showSystemDept")
	public String showSystemDept(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		String path =request.getServletPath()+request.getPathInfo();
		int userId = Integer.parseInt(String.valueOf(request.getSession().getAttribute("userId")));
		Map<String,List<Integer>>  map = Permission.getRolePermission(userId, path);
		String deptIds =  Permission.getDepartMentIds(map);
		request.getParameter("flag");
		List<DepartmentTree>  deptList=null;
		if(!CommonUtils.isEmpty(request.getParameter("flag"))){
			deptList  =  flxoaSystemDepartmentService.querySQLById(deptIds);
		}
		else{			
			deptList  =  flxoaSystemDepartmentService.querySQL();	
		}
		
		JSONArray json = JSONArray.fromObject(deptList);
		System.out.print(json.toString());
		return json.toString();
	}
	
	@RequestMapping(value = "/department/golist")
	public String goList(HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		
		return "nk/pages/system/department";
	}

	@RequestMapping(value = "/department/getlist",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getList(HttpServletRequest request,HttpServletResponse response, ModelMap model) throws UnsupportedEncodingException {
		List<FlxoaSystemDepartment> list = flxoaSystemDepartmentService.query(null);
		JSONArray json = JSONArray.fromObject(list);
		return json.toString();
	}
	
	@RequestMapping(value = "/department/add",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String add(HttpServletRequest request,HttpServletResponse response, FlxoaSystemDepartment model) throws UnsupportedEncodingException {
		//查询最大的id+1作为排序id
		int maxId = flxoaSystemDepartmentService.queryByMaxId();
		int sortId = maxId+1;
		model.setSortId(sortId);
		List<FlxoaSystemDepartment> list = flxoaSystemDepartmentService.query(null);
		//获取公司id
		int companyId = getCompanyIdByPid(model.getParentId(),list);
		model.setCompanyId(companyId);
		boolean flag = flxoaSystemDepartmentService.add(model);
		String result="0";
		if (flag) {
			result = "1";
		}
		return result;
	}
	/**
	 * 修改部门类型
	 */
	@RequestMapping(value = "/department/update",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String update(HttpServletRequest request,HttpServletResponse response,FlxoaSystemDepartment model) throws UnsupportedEncodingException {
		FlxoaSystemDepartment flxoaSystemDepartment = flxoaSystemDepartmentService.queryById(model);
		flxoaSystemDepartment.setName(model.getName());
		flxoaSystemDepartment.setParentId(model.getParentId());
		flxoaSystemDepartment.setOrganizationType(model.getOrganizationType());

		boolean flag = flxoaSystemDepartmentService.update(flxoaSystemDepartment);
		//0失败 1成功
		String result="0";
		if (flag) {
			result = "1";
		}
		return result;
	}
	
	@RequestMapping(value = "/department/updatesort",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String updateSort(HttpServletRequest request,HttpServletResponse response,FlxoaSystemDepartment model) throws UnsupportedEncodingException {
		FlxoaSystemDepartment flxoaSystemDepartment = flxoaSystemDepartmentService.queryById(model);
		flxoaSystemDepartment.setSortId(model.getSortId());
		if(flxoaSystemDepartment.getParentId() != model.getParentId()){
			List<FlxoaSystemDepartment> list = flxoaSystemDepartmentService.query(null);
			int companyId = getCompanyIdByPid(model.getParentId(),list);
			flxoaSystemDepartment.setCompanyId(companyId);
			flxoaSystemDepartment.setParentId(model.getParentId());			
		}
		boolean flag = flxoaSystemDepartmentService.update(flxoaSystemDepartment);
		//0失败 1成功
		String result="0";
		if (flag) {
			result = "1";
		}
		return result;
	}
	
	@RequestMapping(value = "/department/delete",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String delete(HttpServletRequest request,HttpServletResponse response,FlxoaSystemDepartment model) throws UnsupportedEncodingException {
		FlxoaSystemDepartment flxoaSystemDepartment = flxoaSystemDepartmentService.queryById(model);
		boolean flag = flxoaSystemDepartmentService.delete(flxoaSystemDepartment);
		//0失败 1成功
		String result="0";
		if (flag) {
			result = "1";
		}
		return result;
	}
	
	
	//递归根据父级id 查找公司id
	private int getCompanyIdByPid(int pid,List<FlxoaSystemDepartment> list){
		for (int i = 0; i < list.size(); i++) 
		{
			if(pid == list.get(i).getId()){
				//公司id
				if("0".equals(list.get(i).getOrganizationType())){
					return pid;
				}
				FlxoaSystemDepartment flxoaSystemDepartment = list.get(i);
				return getCompanyIdByPid(flxoaSystemDepartment.getParentId(),list);
			}

		}
		return 1;
	}
}

