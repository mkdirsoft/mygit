package com.flx.flxoa.info.conference.controller;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flx.flxoa.info.conference.entity.FlxoaConferenceHistory;
import com.flx.flxoa.info.conference.entity.FlxoaConferenceInformation;
import com.flx.flxoa.info.conference.manager.FlxoaConferenceHistoryService;

@Controller
public class FlxoaConferenceHistoryController {
	protected FlxoaConferenceHistoryService flxoaConferenceHistoryService;
	@Autowired
	public void setFlxoaConferenceHistoryService(FlxoaConferenceHistoryService flxoaConferenceHistoryService) {
		this.flxoaConferenceHistoryService = flxoaConferenceHistoryService;
	}
	/**
	 * @param request
	 * @param response
	 * @param model
	 * @return 会议室历史记录信息
	 */
	@RequestMapping(value = "conferenceHistory")
	public String conference(HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		return "nk/pages/conference/conferenceHistory";
	}
	
	/**
	 * @param request
	 * @param response
	 * @param model
	 * @return 会议室历史信息列表
	 */
	@RequestMapping(value = "/flxoaConferenceHistory", produces = "text/html;charset=utf-8")
	@ResponseBody
	private String flxoaConferenceHistory(HttpServletRequest request,HttpServletResponse response, FlxoaConferenceHistory model) throws  UnsupportedEncodingException, ParseException {
		HttpServletRequest req = (HttpServletRequest) request;
		String path =req.getServletPath()+req.getPathInfo();
		//获取当前登录用户的userID
		int userId = Integer.parseInt(String.valueOf(req.getSession().getAttribute("userId")));
		//获取当前登录用户的部门ID
		int deptId = Integer.parseInt(String.valueOf(req.getSession().getAttribute("departmentId")));
		String deptIds="";
		//分页
		String start = request.getParameter("start"); 
		String length = request.getParameter("length");
		String draw = request.getParameter("draw");
		if (start==""||start==null){
			start="0";
		}
		if(length==""||length==null){
			length="10";
		}
		//查询条件:
  	    //申请人
		model.setUserName(request.getParameter("userName"));
		//会议室编号
		model.setConferenceHistoryNumber(request.getParameter("conferenceHistoryNumber"));
		//会议室类型
		model.setEnumerationValue(request.getParameter("enumerationValue"));
		//预约人
		model.setReservationsPeople(request.getParameter("reservationsPeople"));
		return flxoaConferenceHistoryService.queryForPage(Integer.valueOf(start),Integer.valueOf(length),draw,userId,deptIds,model);
	}
	
	
	
	/**
	 * @param request
	 * @param response
	 * @param model
	 * @return 会议室预约-查看
	 */
	@RequestMapping(value = "/flxoaConferenceHistoryInif", produces = "text/html;charset=utf-8")
	@ResponseBody
	private String flxoaConferenceHistoryInif(HttpServletRequest request,HttpServletResponse response, FlxoaConferenceHistory model) throws  UnsupportedEncodingException, ParseException {
		HttpServletRequest req = (HttpServletRequest) request;
		String path =req.getServletPath()+req.getPathInfo();
		//获取当前登录用户的userID
		int userId = Integer.parseInt(String.valueOf(req.getSession().getAttribute("userId")));
		//获取当前登录用户的部门ID
		int deptId = Integer.parseInt(String.valueOf(req.getSession().getAttribute("departmentId")));
		model.setConferenceId(request.getParameter("conference_id"));
		model.setCreateUserId(userId);
		model.setId(Integer.valueOf(request.getParameter("id")));
		List<FlxoaConferenceHistory> d = flxoaConferenceHistoryService.query(model);
		System.out.println("会议室预约查看="+d);
		JSONArray json = new JSONArray(d);
		return json.toString();
	}
	
	/**
	 * @param request
	 * @param response
	 * @param model
	 * @return 会议室预约-取消
	 */
	@RequestMapping(value = "/flxoaConferenceHistoryDelete", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String  flxoaConferenceHistoryDelete(HttpServletRequest request,HttpServletResponse response, FlxoaConferenceHistory model){
		String result = "";
		model.setId(Integer.valueOf(request.getParameter("id")));
		//先查在删 -逻辑删除
		FlxoaConferenceHistory flxoaConferenceHistory = flxoaConferenceHistoryService.queryById(model);
		flxoaConferenceHistory.setIsCancel("是");
		flxoaConferenceHistory.setDeleteFlag("1");
		Boolean b = flxoaConferenceHistoryService.update(flxoaConferenceHistory);
		if(b) {
			result = "1";
		}
		return result;
	}
	
}
