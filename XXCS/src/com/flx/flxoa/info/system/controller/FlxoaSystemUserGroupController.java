/**
 * 
 */
package com.flx.flxoa.info.system.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.flx.flxoa.common.util.CommonUtils;
import com.flx.flxoa.common.util.DateUtils;
import com.flx.flxoa.info.system.entity.FlxoaSystemUserGroup;
import com.flx.flxoa.info.system.manager.FlxoaSystemUserGroupDepartmentService;
import com.flx.flxoa.info.system.manager.FlxoaSystemUserGroupRoleService;
import com.flx.flxoa.info.system.manager.FlxoaSystemUserGroupService;
import com.flx.flxoa.info.system.manager.FlxoaSystemUserGroupUserService;

/**
 * @author 赵鹏辉
 * @date 2018-3-28 上午11:08:08
 * 描述：
 */
@Controller
public class FlxoaSystemUserGroupController {

	protected FlxoaSystemUserGroupService flxoaSystemUserGroupService;
	protected FlxoaSystemUserGroupRoleService flxoaSystemUserGroupRoleService;
	protected FlxoaSystemUserGroupUserService flxoaSystemUserGroupUserService;
	protected FlxoaSystemUserGroupDepartmentService flxoaSystemUserGroupDepartmentService;

	@Autowired
	public void setFlxoaSystemUserGroupService(FlxoaSystemUserGroupService flxoaSystemUserGroupService) {
		this.flxoaSystemUserGroupService = flxoaSystemUserGroupService;
	}
	@Autowired
	public void setFlxoaSystemUserGroupRoleService(FlxoaSystemUserGroupRoleService flxoaSystemUserGroupRoleService) {
		this.flxoaSystemUserGroupRoleService = flxoaSystemUserGroupRoleService;
	}
	@Autowired
	public void setFlxoaSystemUserGroupUserService(FlxoaSystemUserGroupUserService flxoaSystemUserGroupUserService) {
		this.flxoaSystemUserGroupUserService = flxoaSystemUserGroupUserService;
	}
	@Autowired
	public void setFlxoaSystemUserGroupDepartmentService(FlxoaSystemUserGroupDepartmentService flxoaSystemUserGroupDepartmentService) {
		this.flxoaSystemUserGroupDepartmentService = flxoaSystemUserGroupDepartmentService;
	}

	/**
	 * 列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/usergroup/list")
	public String list(HttpServletRequest request,HttpServletResponse response ){
		return "/nk/pages/system/userGroupManage";
	}

	/**
	 * 查询
	 * @param modelAndView
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/usergroup/queryforlist",produces="text/html;charset=UTF-8")
	public String  queryForList(ModelAndView modelAndView,HttpServletRequest request,HttpServletResponse response){
		String start = request.getParameter("start"); 
		String length = request.getParameter("length");
		String draw = request.getParameter("draw");
		if (start==""||start==null){
			start="0";
		}
		if(length==""||length==null){
			length="10";
		}

		String userGroupName=request.getParameter("userGroupName");

		return flxoaSystemUserGroupService.queryForPage(Integer.valueOf(start),Integer.valueOf(length),userGroupName,draw);
	}

	/**
	 * 获取用户组
	 * @param flxoaSystemUserGroup
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/usergroup/getgroupname",produces="text/html;charset=UTF-8")
	public String  getGroupName(HttpServletRequest request,HttpServletResponse response){
		String result="0";
		String userGroupName=request.getParameter("userGroupName");
		FlxoaSystemUserGroup flxoaSystemUserGroup=new FlxoaSystemUserGroup();
		flxoaSystemUserGroup.setName(userGroupName);
		long count = flxoaSystemUserGroupService.getGroupName(flxoaSystemUserGroup);
		if (count>0) {
			result = "1";
		}
		return result;
	}

	/**
	 * 添加用户组
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/usergroup/add",produces="text/html;charset=UTF-8")
	public String  addGroup(HttpServletRequest request,HttpServletResponse response){
		String result="0";
		String userGroupName=request.getParameter("userGroupName");
		FlxoaSystemUserGroup flxoaSystemUserGroup=new FlxoaSystemUserGroup();
		flxoaSystemUserGroup.setName(userGroupName);
		long count = flxoaSystemUserGroupService.getGroupName(flxoaSystemUserGroup);
		if (count>0) {
			result = "1";
		}else{
			boolean flag = flxoaSystemUserGroupService.add(flxoaSystemUserGroup);
			if (flag) {
				result = "2";
			}
		}
		return result;
	}
	/**
	 * 修改用户组
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/usergroup/update",produces="text/html;charset=UTF-8")
	public String updateGroup(HttpServletRequest request,HttpServletResponse response){
		String userGroupId=request.getParameter("userGroupId"); 
		FlxoaSystemUserGroup model=new FlxoaSystemUserGroup();
		model.setId(Integer.valueOf(userGroupId));
		FlxoaSystemUserGroup flxoaSystemUserGroup = flxoaSystemUserGroupService.queryById(model);
		JSONArray json=JSONArray.fromObject(flxoaSystemUserGroup);
		return json.toString();
	}
	/**
	 * 修改用户组
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/usergroup/save",produces="text/html;charset=UTF-8")
	public String save(HttpServletRequest request,HttpServletResponse response){
		String result="0";
		String userGroupId=request.getParameter("userGroupId"); 
		String userGroupName=request.getParameter("userGroupName");
		FlxoaSystemUserGroup model=new FlxoaSystemUserGroup();
		model.setId(Integer.valueOf(userGroupId));
		model.setName(userGroupName);
		long count = flxoaSystemUserGroupService.getGroupName(model);
		if (count>0) {
			result = "1";
		}else{
			FlxoaSystemUserGroup flxoaSystemUserGroup = flxoaSystemUserGroupService.queryById(model);
			flxoaSystemUserGroup.setName(userGroupName);
			boolean flag = flxoaSystemUserGroupService.update(flxoaSystemUserGroup);
			if (flag) {
				result = "2";
			}
		}
		return result;
	}

	/**
	 * 删除用户组
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/usergroup/delete",produces="text/html;charset=UTF-8")
	public String  deleteGroup(HttpServletRequest request,HttpServletResponse response){
		String userGroupId=request.getParameter("userGroupId"); 
		FlxoaSystemUserGroup model=new FlxoaSystemUserGroup();
		model.setId(Integer.valueOf(userGroupId));
		FlxoaSystemUserGroup flxoaSystemUserGroup = flxoaSystemUserGroupService.queryById(model);
		boolean flag = flxoaSystemUserGroupService.deleteGroup(flxoaSystemUserGroup);
		String result="0";
		if (flag) {
			result = "1";
		}
		return result;
	}

	/**
	 * 授权添加
	 * @param modelAndView
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/FlxoaSystemUserGroupController/shouquanAdd",produces="text/html;charset=UTF-8")
	public String  shouquanAdd(FlxoaSystemUserGroup flxoaSystemUserGroup,HttpServletRequest request,HttpServletResponse response){
		int nowTime = DateUtils.getSecondTimestamp(new Date());
		int userId=0;
		int departmentId=0;
		String deleteFlag="0";
		//临时
		flxoaSystemUserGroup.setId(1);
		int[] groupUserIds={1,2,3,4,5,6};
		int[] groupRoleIds={1,2,3,4,5,6};
		int[] groupDeptIds={1,2,3,4,5,6};
		Boolean flag = flxoaSystemUserGroupService.shouquanAdd(flxoaSystemUserGroup,groupUserIds,groupRoleIds,groupDeptIds);
		String result="0";
		if (flag) {
			result = "1";
		}
		return result;
	}

	/**
	 * 授权列表
	 * @param modelAndView
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/FlxoaSystemUserGroupController/shouquanList",produces="text/html;charset=UTF-8")
	public String  shouquanList(ModelAndView modelAndView,HttpServletRequest request,HttpServletResponse response){
		String pageNo = request.getParameter("pageNo"); 
		String pageSize = request.getParameter("pageSize");
		if (pageNo==""||pageNo==null){
			pageNo="1";
		}
		if(pageSize==""||pageSize==null){
			pageSize="20";
		}
		FlxoaSystemUserGroup flxoaSystemUserGroup=new FlxoaSystemUserGroup();
		List systemUserGroupList=flxoaSystemUserGroupService.quanxianList(Integer.valueOf(pageNo),Integer.valueOf(pageSize),flxoaSystemUserGroup);
		JSONArray json=JSONArray.fromObject(systemUserGroupList);
		long totalCount=flxoaSystemUserGroupService.queryCount(flxoaSystemUserGroup);
		long totalPages=CommonUtils.getTotalPages(totalCount, Integer.valueOf(pageSize));
		System.out.println("------------totalPages="+totalPages);
		return json.toString();
	}






}
