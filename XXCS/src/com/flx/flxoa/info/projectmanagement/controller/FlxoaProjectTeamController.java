package com.flx.flxoa.info.projectmanagement.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flx.flxoa.common.util.DateUtils;
import com.flx.flxoa.info.projectmanagement.entity.FlxoaProjectInformation;
import com.flx.flxoa.info.projectmanagement.entity.FlxoaProjectTeam;
import com.flx.flxoa.info.projectmanagement.manager.FlxoaProjectInformationService;
import com.flx.flxoa.info.projectmanagement.manager.FlxoaProjectTeamService;
import com.flx.flxoa.info.system.entity.FlxoaSystemEnumeration;
import com.flx.flxoa.info.system.entity.FlxoaSystemFuncation;
import com.flx.flxoa.info.system.manager.FlxoaSystemEnumerationService;

/**
 * @author 雷君
 * @version 创建时间：2018-3-19 下午5:51:22 类说明
 */
@Controller
public class FlxoaProjectTeamController {
	protected FlxoaProjectInformationService flxoaProjectInformationService;
	protected FlxoaProjectTeamService flxoaProjectTeamService;
	protected FlxoaSystemEnumerationService flxoaSystemEnumerationService;
	@Autowired
	public void setFlxoaProjectTeamService(
			FlxoaProjectTeamService flxoaProjectTeamService) {
		this.flxoaProjectTeamService = flxoaProjectTeamService;
	}
	@Autowired
	public void setFlxoaSystemEnumerationService(
			FlxoaSystemEnumerationService flxoaSystemEnumerationService) {
		this.flxoaSystemEnumerationService = flxoaSystemEnumerationService;
	}
	
	@Autowired
	public void setFlxoaProjectInformationService(
			FlxoaProjectInformationService flxoaProjectInformationService) {
		this.flxoaProjectInformationService = flxoaProjectInformationService;
	}
	/**
	 * @param 添加項目團隊人員
	 * @param response
	 * @param model
	 * @return 添加项目团队人员
	 */
	@RequestMapping(value = "/projectTeamAdd", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String projectTeamAdd(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		FlxoaProjectTeam team = new FlxoaProjectTeam();
		String proj_team_name = request.getParameter("proj_team_name");
		//根据用户名查询   有为true
		//boolean username = flxoaProjectTeamService.isExist(proj_team_name);
		String result = "0";
		//当指定项目团队负责人时 将指定的负责人信息插入项目信息表
		if("项目负责人".equals(request.getParameter("team_role"))) {
			FlxoaProjectInformation projectUpdata = new FlxoaProjectInformation();
			projectUpdata.setId(Integer.valueOf(request.getParameter("proj_number")));
			FlxoaProjectInformation flxoaProjectInformation = flxoaProjectInformationService.queryById(projectUpdata);
			flxoaProjectInformation.setProjectLeader(request.getParameter("team_name"));
			flxoaProjectInformation.setProjState("7");
			flxoaProjectInformation.setProjStartTime(Integer.valueOf(DateUtils.dateToTimestamp(request.getParameter("team_sta_time"))));
			flxoaProjectInformation.setProjEndTime(Integer.valueOf(DateUtils.dateToTimestamp(request.getParameter("team_end_time"))));
			boolean b = flxoaProjectInformationService.update(flxoaProjectInformation);
			if(b != true) {
				System.out.println("FlxoaProjectTeamController.java中的projectTeamAdd方法出现");
			}
		}
		//删除标记（0默认不删除）
		team.setDeleteFlag("0");
		//名称
		team.setProjTeam(request.getParameter("team_name"));
		//用户名
		team.setProjTeamName(request.getParameter("proj_team_name"));
		//角色
		team.setRole(request.getParameter("team_role"));
		//天数
		team.setWorkDay(Integer.valueOf(request.getParameter("team_deys")));
		//项目ID
		team.setProjInformationId(Integer.valueOf(request.getParameter("proj_number")));
		//加入时间
		team.setJoinTime(Integer.valueOf(DateUtils.dateToTimestamp(request.getParameter("team_sta_time"))));
		//离开时间
		team.setLeaveTime(Integer.valueOf(DateUtils.dateToTimestamp(request.getParameter("team_end_time"))));
		boolean b = flxoaProjectTeamService.add(team);
		if (b) { 
			result = "1";
		}
	return result;
	}
	
	/**
	 * @param 修改項目團隊人員信息 
	 * @param response
	 * @param model
	 * @return 修改
	 */
	@RequestMapping(value = "/projectTeamupdata", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String projectTeamupdata(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		HttpServletRequest req = (HttpServletRequest)request;
		FlxoaProjectTeam team = new FlxoaProjectTeam();
		String proj_team_name = request.getParameter("proj_team_name");
		String result = "0";
		//根据用户名查询   有为true
		//boolean username = flxoaProjectTeamService.isExist(proj_team_name);
			team.setDeleteFlag("0");
			team.setId(Integer.valueOf(request.getParameter("teamid")));
			team.setProjTeam(request.getParameter("team_name"));
			team.setProjTeamName(request.getParameter("proj_team_name"));
			team.setRole(request.getParameter("team_role"));
			team.setWorkDay(Integer.valueOf(request.getParameter("team_deys")));
			team.setProjInformationId(Integer.valueOf(request.getParameter("proj_number")));
			team.setJoinTime(DateUtils.dateToTimestamp(request.getParameter("team_sta_time")));
			team.setLeaveTime(DateUtils.dateToTimestamp(request.getParameter("team_end_time")));
			team.setCreateTime(DateUtils.getSecondTimestamp(new Date()));
			team.setCreateDepartmentId(Integer.parseInt(String.valueOf(req.getSession().getAttribute("departmentId"))));
			team.setCreateUserId(Integer.parseInt(String.valueOf(req.getSession().getAttribute("userId"))));
			boolean b = flxoaProjectTeamService.update(team);
			if(b){
				result = "1";
			}
		return result;
	}
	/**
	 * @param 刪除
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/projeectTeamDelete", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String projeectTeamDelete(HttpServletRequest request,
			HttpServletResponse response, FlxoaProjectTeam model){
		model.setId(Integer.valueOf(request.getParameter("teamid")));
		FlxoaProjectTeam team = flxoaProjectTeamService.queryById(model);
		boolean b = flxoaProjectTeamService.delete(team);
		String result = "0";
		if(b){
			 result = "1";
		}
		return result;
	}
	
	/**
	 * 查询项目团队人员角色树
	 */
	
	@RequestMapping(value = "/projeectTeamRole", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String projeectTeamRole(HttpServletRequest request,HttpServletResponse response, FlxoaSystemEnumeration flxoaSystemEnumeration){
		int pageNo = 0;
		int pageSize = 0;
		List<FlxoaSystemEnumeration> list = flxoaSystemEnumerationService.queryForPage(pageNo, pageSize,flxoaSystemEnumeration);
		JSONArray json = new JSONArray(list);
		System.out.println("json"+json);
		return json.toString();
	}
	
	/**
	 * @param 查看項目團隊人員信息
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/projeectTeamCheck", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String projeectTeamCheck(HttpServletRequest request,
			HttpServletResponse response, FlxoaProjectTeam model){
		model.setProjInformationId(Integer.valueOf(request.getParameter("proj_number")));
		Map<String,List<FlxoaProjectTeam>> mapteam = new HashMap<String, List<FlxoaProjectTeam>>();
		List<FlxoaProjectTeam> team = flxoaProjectTeamService.query(model);
		JSONArray json = new JSONArray();
		mapteam.put("mapteam", team);
		JSONArray jsonList =  json.put(mapteam);
		return json.toString();
	}
	
}
