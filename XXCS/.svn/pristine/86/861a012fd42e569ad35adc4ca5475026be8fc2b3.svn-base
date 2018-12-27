package com.flx.flxoa.info.conference.controller;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.flx.flxoa.common.util.CommonUtils;
import com.flx.flxoa.common.util.DateUtils;
import com.flx.flxoa.info.conference.entity.FlxoaConferenceHistory;
import com.flx.flxoa.info.conference.entity.FlxoaConferenceInformation;
import com.flx.flxoa.info.conference.manager.FlxoaConferenceHistoryService;
import com.flx.flxoa.info.conference.manager.FlxoaConferenceInformationService;

import sun.security.util.Length;
@Controller
public class FlxoaConferenceController {
	protected SessionFactory sessionFactory;

	protected FlxoaConferenceInformationService flxoaConferenceInformationService;
	@Autowired
	public void setFlxoaConferenceInformationService(FlxoaConferenceInformationService flxoaConferenceInformationService) {
		this.flxoaConferenceInformationService = flxoaConferenceInformationService;
	}
	protected FlxoaConferenceHistoryService flxoaConferenceHistoryService;
	@Autowired
	public void setFlxoaConferenceHistoryService(FlxoaConferenceHistoryService flxoaConferenceHistoryService) {
		this.flxoaConferenceHistoryService = flxoaConferenceHistoryService;
	}
	/**
	 * @param request
	 * @param response
	 * @param model
	 * @return 会议室管理页面
	 */
	@RequestMapping(value = "conference")
	public String conference(HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		return "nk/pages/conference/conference";
	}
	
	/**
	 * @param request
	 * @param response
	 * @param model
	 * @return 会议室管理信息列表
	 */
	@RequestMapping(value = "/flxoaConferenceInif", produces = "text/html;charset=utf-8")
	@ResponseBody
	private String flxoaConferenceInif(HttpServletRequest request,HttpServletResponse response, FlxoaConferenceInformation model) throws  UnsupportedEncodingException, ParseException {
		HttpServletRequest req = (HttpServletRequest) request;
		//进入会议室管理页前，先更新预约状态
		this.flxoaConferenceAppointmentHistory(req, response, null);
		
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
		model.setConferenceNumber(request.getParameter("conferenceNumber"));
		model.setConferenceName(request.getParameter("conferenceName"));
		model.setConferenceFloor(request.getParameter("conferenceFloor"));
		model.setConferenceStates(request.getParameter("conferenceStates"));
		return flxoaConferenceInformationService.queryForPage(Integer.valueOf(start),Integer.valueOf(length),draw,userId,deptIds,model);
	}
	
	/**
	 * @param request
	 * @param response
	 * @param model
	 * @return 会议室添加
	 */
	@RequestMapping(value = "/flxoaConferenceAdd", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String  flxoaConferenceAdd(HttpServletRequest request,HttpServletResponse response, FlxoaConferenceInformation model){
		String result = "";
		//会议室编号
		model.setConferenceNumber(request.getParameter("conference_number"));
		//会议室名称
		model.setConferenceName(request.getParameter("conference_name"));
		//会议室楼层
		model.setConferenceFloor(request.getParameter("conference_floor"));
		//会议室配置
		model.setConferenceConfigure(request.getParameter("conference_configure"));
		//会议室规模
		model.setConferenceScale(request.getParameter("conference_scale"));
		//会议室备注
		model.setConferenceRemarks(request.getParameter("conference_remarks"));
		//会议室状态
		model.setConferenceStates(request.getParameter("conference_states"));
		//默认为“0”
		model.setDeleteFlag("0");
		Boolean b = flxoaConferenceInformationService.add(model);
		if(b) {
			result = "1";
		}
		return result;
	}
	
	/**
	 * @param request
	 * @param response
	 * @param model
	 * @return 会议室修改
	 */
	@RequestMapping(value = "/flxoaConferenceUpdata", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String  flxoaConferenceUpdata(HttpServletRequest request,HttpServletResponse response, FlxoaConferenceInformation model){
		String result = "";
		model.setId(Integer.valueOf(request.getParameter("id")));
		FlxoaConferenceInformation flxoaConferenceInformation = flxoaConferenceInformationService.queryById(model);
		
		
		//会议室编号
		flxoaConferenceInformation.setConferenceNumber(request.getParameter("conference_number"));
		//会议室名称
		flxoaConferenceInformation.setConferenceName(request.getParameter("conference_name"));
		//会议室楼层
		flxoaConferenceInformation.setConferenceFloor(request.getParameter("conference_floor"));
		//会议室配置
		flxoaConferenceInformation.setConferenceConfigure(request.getParameter("conference_configure"));
		//会议室规模
		flxoaConferenceInformation.setConferenceScale(request.getParameter("conference_scale"));
		//会议室备注
		flxoaConferenceInformation.setConferenceRemarks(request.getParameter("conference_remarks"));
		//会议室状态
		flxoaConferenceInformation.setConferenceStates(request.getParameter("conference_states"));
		//默认为“0”
		flxoaConferenceInformation.setDeleteFlag("0");
		Boolean b = flxoaConferenceInformationService.update(flxoaConferenceInformation);
		if(b) {
			result = "1";
		}
		return result;
	}

	
	/**
	 * @param request
	 * @param response
	 * @param model
	 * @return 会议室删除
	 */
	@RequestMapping(value = "/flxoaConferenceDelete", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String  flxoaConferenceDelete(HttpServletRequest request,HttpServletResponse response, FlxoaConferenceInformation model){
		String result = "";
		model.setId(Integer.valueOf(request.getParameter("id")));
		//先查在删 -逻辑删除
		FlxoaConferenceInformation flxoaConferenceInformation = flxoaConferenceInformationService.queryById(model);
		Boolean b = flxoaConferenceInformationService.delete(flxoaConferenceInformation);
		if(b) {
			result = "1";
		}
		return result;
	}
	
	/**
	 * @param request
	 * @param response
	 * @param model
	 * @return 会议室预约
	 */
	@RequestMapping(value = "/flxoaConferenceAppointmentAdd", produces = "text/html;charset=utf-8")
	@ResponseBody 
	public String  flxoaConferenceAppointmentAdd(HttpServletRequest request,HttpServletResponse response, FlxoaConferenceHistory model){
		String result = "false";
		int startTime = Integer.valueOf(DateUtils.dateToTimestamp2(request.getParameter("conference_start_time")));
		int endTime = Integer.valueOf(DateUtils.dateToTimestamp2(request.getParameter("conference_end_time")));
		String conferenceId = request.getParameter("conference_id");
		Boolean h = flxoaConferenceHistoryService.isExist(startTime, endTime,conferenceId);
		if(h) {
			//会议室管理信息表
			FlxoaConferenceInformation flxoaConferenceInformation = new FlxoaConferenceInformation();
			//会议室信息ID
			model.setConferenceId(request.getParameter("conference_id"));
			//会议室预约标识
			model.setConferenceNumber("0");
			//会议室申请人
			model.setApplicant("");
			//会议室参会人数
			model.setApplicationTime(Integer.valueOf(request.getParameter("application_time")));
			//联系方式
			model.setApplicationInformation("");
			//会议室预约人
			model.setReservationsPeople(request.getParameter("reservations_people"));
			//会议室预约类型
			model.setReservationsType(request.getParameter("reservations_type"));
			//会议室预约用途
			model.setReservationsPurpose(request.getParameter("reservations_purpose"));
			//会议室开始时间
			model.setConferenceStartTime(Integer.valueOf(DateUtils.dateToTimestamp2(request.getParameter("conference_start_time"))));
			//会议室结束时间
			model.setConferenceEndTime(Integer.valueOf(DateUtils.dateToTimestamp2(request.getParameter("conference_end_time"))));
			//会议室是否取消
			model.setIsCancel("否");
			//会议室删除标志
			model.setDeleteFlag("0");
			Boolean b = flxoaConferenceHistoryService.add(model);
			if(b) {
				//预约成功后改变会议室管理中状态为预约中
				flxoaConferenceInformation.setId(Integer.valueOf(request.getParameter("conference_id")));
				FlxoaConferenceInformation flxoaConferenceInformationUp = flxoaConferenceInformationService.queryById(flxoaConferenceInformation);
				flxoaConferenceInformationUp.setConferenceStates("1");
				Boolean f = flxoaConferenceInformationService.update(flxoaConferenceInformationUp);
				result = "1";
			}
		}
		return result;
	}
	
	/**
	 * @param request
	 * @param response
	 * @param model
	 * @return 会议室管理 预约状态变更
	 */
	@RequestMapping(value = "/flxoaConferenceAppointmentHistory", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String  flxoaConferenceAppointmentHistory(HttpServletRequest request,HttpServletResponse response, FlxoaConferenceHistory model){
		
		//会议室管理信息表
		FlxoaConferenceInformation flxoaConferenceInformation = new FlxoaConferenceInformation();
		FlxoaConferenceInformation flxoaConferenceInformations = new FlxoaConferenceInformation();
		//先默认全部状态为空闲中（0）
		Boolean fd = flxoaConferenceInformationService.updateFree();
		//根据当前系统时间查询是否有预约
		List<FlxoaConferenceHistory> queryListFree = flxoaConferenceHistoryService.queryHistoryFree(model);
		//queryListFree大于0时，根据返回conference_id改变会议室管理中状态“conference_states”为有预约
		if(queryListFree.size() > 0) {
			for(int i = 0; i < queryListFree.size();i++) {
				flxoaConferenceInformation.setId(Integer.valueOf(queryListFree.get(i).getConferenceId()));
				FlxoaConferenceInformation flxoaConferenceInformationFree = flxoaConferenceInformationService.queryById(flxoaConferenceInformation);
				flxoaConferenceInformationFree.setConferenceStates("1");
				Boolean f = flxoaConferenceInformationService.update(flxoaConferenceInformationFree);
			}
		}
		
		//根据当前系统时间查询是否在预约时间段类，如queryList大于0 根据返回的conference_idid 改变会议室管理中状态“conference_states”为使用中
		List<FlxoaConferenceHistory> queryList = flxoaConferenceHistoryService.queryHistory(model);
		if(queryList.size() > 0) {
			for(int i = 0; i < queryList.size();i++) {
				flxoaConferenceInformations.setId(Integer.valueOf(queryList.get(i).getConferenceId()));
				FlxoaConferenceInformation flxoaConferenceInformationUp = flxoaConferenceInformationService.queryById(flxoaConferenceInformations);
				flxoaConferenceInformationUp.setConferenceStates("2");
				Boolean f = flxoaConferenceInformationService.update(flxoaConferenceInformationUp);
			}
		}
		return null;
	}
	
}
