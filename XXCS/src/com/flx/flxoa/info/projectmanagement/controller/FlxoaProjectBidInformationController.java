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

import com.flx.flxoa.common.util.CommonUtils;
import com.flx.flxoa.common.util.DateUtils;
import com.flx.flxoa.info.projectmanagement.entity.FlxoaProjectBidInformation;
import com.flx.flxoa.info.projectmanagement.entity.FlxoaProjectBidRecord;
import com.flx.flxoa.info.projectmanagement.entity.FlxoaProjectInformation;
import com.flx.flxoa.info.projectmanagement.manager.FlxoaProjectBidInformationService;
import com.flx.flxoa.info.system.comon.Permission;

/**
 * @author 雷君
 * @version 创建时间：2018-3-22 上午9:31:59
 * 类说明
 */
@Controller
public class FlxoaProjectBidInformationController {
	
	protected FlxoaProjectBidInformationService flxoaProjectBidInformationService;
	@Autowired
	public void setFlxoaProjectBidInformationService(FlxoaProjectBidInformationService flxoaProjectBidInformationService) {
		this.flxoaProjectBidInformationService = flxoaProjectBidInformationService;
	}
	@RequestMapping(value = "bidManage")
	public String projectList(HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		
		return "nk/pages/projectManage/bidManage";
	}
	/**
	 * @param 投标信息列表及删除
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/FlxoaProjectBidInif",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String FlxoaProjectBidInif(HttpServletRequest request,HttpServletResponse response,FlxoaProjectBidInformation flxoaProjectBidInformation){
		FlxoaProjectBidInformation bid = new FlxoaProjectBidInformation();
		HttpServletRequest req = (HttpServletRequest) request;
		String path =req.getServletPath()+req.getPathInfo();
		//获取当前登录用户ID
		int userId = Integer.parseInt(String.valueOf(req.getSession().getAttribute("userId")));
		//获取当前登录用户部门ID
		int deptId = Integer.parseInt(String.valueOf(req.getSession().getAttribute("departmentId")));
		Map<String,List<Integer>>  mapjur = Permission.getRolePermission(userId, path);
		//获取当前用户具备的权限
		String deptIds =  Permission.getDepartMentIds(mapjur);	
		JSONArray json = new JSONArray();
		String pageNo = request.getParameter("pageNo");//数据起始（start）序号
		String pageSize = request.getParameter("pageSize");//数据长度（length）
		String draw=request.getParameter("draw");//datatable绘制次数
		System.out.println("起始数据就位置：===="+pageNo);
		System.out.println("数据长度+======="+pageSize);
		if (pageNo == "" || pageNo == null) {
			pageNo = "1";
		}
		if (pageSize == "" || pageSize == null) {
			pageSize = "10";
		}
		//投标负责人
		bid.setBiddingDirector(request.getParameter("bid_header"));
		//跟单人
		bid.setRealname(request.getParameter("bid_follower"));
		//项目名称
		bid.setProjName(request.getParameter("proj_name"));
		//项目名称
		bid.setProjNumber(request.getParameter("proj_number"));
		//投标结果
		bid.setBidding_results_type(request.getParameter("bidding_results"));
        //投标准备进度
		bid.setProject_bidding_status_type(request.getParameter("project_bidding_status"));
        //投标进度
		bid.setBid_schedule_type(request.getParameter("bid_schedule"));
		String bidData = request.getParameter("bid_date");
		if(!CommonUtils.isEmpty(request.getParameter("projStartDate"))) {
			bid.setStartTime(String.valueOf(DateUtils.dateToTimestamp(request.getParameter("projStartDate"))));
			System.out.println(request.getParameter("projStartDate"));
		}
		if(!CommonUtils.isEmpty(request.getParameter("projEndDate"))) {
			System.out.println(request.getParameter("projEndDate"));
			bid.setEndTime(String.valueOf(DateUtils.dateToTimestamp(request.getParameter("projEndDate"))));
		}
		/*List<FlxoaProjectBidInformation> list = flxoaProjectBidInformationService.queryForPage(Integer.valueOf(pageNo),Integer.valueOf(pageSize),userId,deptIds,bid);*/
		
		/*Map<String,List<FlxoaProjectBidInformation>>  map = new HashMap<String,List<FlxoaProjectBidInformation>>();*/
		/*map.put("bidmessage", list);
		JSONArray js = json.put(map);
		return json.toString();*/
		return flxoaProjectBidInformationService.queryForPage(Integer.valueOf(pageNo),Integer.valueOf(pageSize),draw,userId,deptIds,bid);
	}
	/**
	 * @param 根據ID刪除
	 * @param response
	 * @param model
	 * @return 根據ID刪除
	 */
	@RequestMapping(value = "/flxoaProjectBidDelete",produces = "text/html;charset=utf-8")
	@ResponseBody
	public String flxoaProjectBidDelete(HttpServletRequest request,HttpServletResponse response,FlxoaProjectBidInformation model) {
		//根据ID先查后删（）
		model.setId(Integer.valueOf(request.getParameter("id")));
		FlxoaProjectBidInformation project = flxoaProjectBidInformationService.queryById(model);
		boolean b = flxoaProjectBidInformationService.delete(project);
		String result = "0";
		if(b){
			 result = "1";
		}
		return result;
	}
	/**
	 * @param 
	 * @param response
	 * @param model
	 * @return 填写投标结果
	 */
	@RequestMapping(value = "/flxoaProjectBidResult", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String flxoaProjectBidResult(HttpServletRequest request,
			HttpServletResponse response, FlxoaProjectBidInformation model) {
		//获取修改对象ID
		model.setId(Integer.valueOf(request.getParameter("id")));
		FlxoaProjectBidInformation flxoaProjectBidInformation = flxoaProjectBidInformationService.queryById(model);
		flxoaProjectBidInformation.setBiddingResults(request.getParameter("bid_result_index"));
		flxoaProjectBidInformation.setReason(request.getParameter("bid_result_index"));
		boolean  b  = flxoaProjectBidInformationService.update(flxoaProjectBidInformation);
		String result = "0";
		if(b){
			 result = "1";
		}
		return result;
	}
}
