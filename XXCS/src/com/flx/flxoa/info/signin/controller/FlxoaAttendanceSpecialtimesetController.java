package com.flx.flxoa.info.signin.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;


import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flx.flxoa.common.util.DateUtils;
import com.flx.flxoa.info.signin.entity.FlxoaAttendanceSpecialtimeset;
import com.flx.flxoa.info.signin.manager.FlxoaAttendanceSpecialtimesetService;


/**
 * 类名称：FlxoaAttendanceSpecialtimesetController.java<br>
 * 类描述：<br>
 * 创建时间：2018-3-26, 上午10:20:33
 * 
 * @version 1.0 
 * @since JDK版本 1.7
 * @author 夏改翠 
 */
@Controller
public class FlxoaAttendanceSpecialtimesetController {

	protected FlxoaAttendanceSpecialtimesetService flxoaAttendanceSpecialtimesetService;

	@Autowired
	public void setFlxoaAttendanceSpecialtimesetService(
			FlxoaAttendanceSpecialtimesetService flxoaAttendanceSpecialtimesetService) {
		this.flxoaAttendanceSpecialtimesetService = flxoaAttendanceSpecialtimesetService;
	}
	
	@RequestMapping(value = "signin/specialTime")
	public String goList(HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		
		return "nk/pages/signIn/specialTimeSet";
	}
	
	/**
	 * 显示特殊时间表
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "signin/showSpecialTime")
	public String showSpecialTime(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		String start = request.getParameter("pageNo"); 
		String length = request.getParameter("pageSize");
		String draw = request.getParameter("draw");
		if (start==""||start==null){
			start="0";
		}
		if(length==""||length==null){
			length="10";
		}
		//开始时间的时间范围
		String specialStartDate = request.getParameter("specialStartDate");
		String specialEndDate = request.getParameter("specialEndDate");
		//结束时间的时间范围
		String enddpecialStartDate = request.getParameter("specialStartDate1");
		String endspecialEndDate = request.getParameter("specialEndDate1");
		String specialGroupDetails = request.getParameter("specialGroupDetails");
		String flag= request.getParameter("flag");
		String id= request.getParameter("id");
		Map<String,String> map = new HashMap<String,String>();
		map.put("startdate", specialStartDate);//开始时间的
		map.put("enddate", specialEndDate);//开始时间的
		//结束时间
		map.put("endstartdate", enddpecialStartDate);//结束时间的
		map.put("endenddate", endspecialEndDate);
		map.put("details", specialGroupDetails);
		map.put("flag", flag);
		map.put("start", start);
		map.put("length", length);
		map.put("draw", draw);
		map.put("id", id);//结束时间
		
		return flxoaAttendanceSpecialtimesetService.querySpecialtimeset(map);
	}
	/**
	 * 插入特殊时间
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "signin/insertspecialtime")
	public String insertSpecialTime(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		String specialStartDate  = request.getParameter("specialStartDate");
		String specialEndDate = request.getParameter("specialEndDate");
		String gotoworktime = request.getParameter("gotoworktime");
		System.out.println(gotoworktime.length());
		if(gotoworktime.length()==5){
			gotoworktime += ":00";
		}
		String afterworktime = request.getParameter("afterworktime");
		if(afterworktime.length()==5){
			afterworktime += ":00";
		}
		String type = request.getParameter("type");
		String details = request.getParameter("details");
		String[] str =  details.split(",");
		System.out.println(str);
		
		boolean flag=true;
		for(int i =0;i<str.length;i++){
			FlxoaAttendanceSpecialtimeset flxoaAttendanceSpecialtimeset = new FlxoaAttendanceSpecialtimeset();
			flxoaAttendanceSpecialtimeset.setSpecialStartDate(DateUtils.dateToTimestamp(specialStartDate));
			flxoaAttendanceSpecialtimeset.setSpecialEndDate(DateUtils.dateToTimestamp(specialEndDate));
			flxoaAttendanceSpecialtimeset.setGotoworktime(gotoworktime);
			flxoaAttendanceSpecialtimeset.setAfterworktime(afterworktime);
			flxoaAttendanceSpecialtimeset.setSpecialGroup(type);
			flxoaAttendanceSpecialtimeset.setSpecialGroupDetails(str[i]);
			flxoaAttendanceSpecialtimeset.setFlag("0");
			flag = flxoaAttendanceSpecialtimesetService.add(flxoaAttendanceSpecialtimeset);
			
		}
		//0失败 1成功
		String result="0";
		if (flag) {
					result = "1";
				}
				
		System.out.print(result);	
		
		return result;
	}
	/** 
	 * 修改特殊时间设置--删除
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "signin/delspecialtime")
	public String updateSpecialTimeFlag(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		
		String id = request.getParameter("id");
		System.out.println(id);
		FlxoaAttendanceSpecialtimeset flxoaAttendanceSpecialtimeset = new FlxoaAttendanceSpecialtimeset();
		flxoaAttendanceSpecialtimeset.setId(Integer.valueOf(id));
		FlxoaAttendanceSpecialtimeset bean = flxoaAttendanceSpecialtimesetService.queryById(flxoaAttendanceSpecialtimeset);
		
		bean.setDeleteFlag("1");		
		boolean flag = flxoaAttendanceSpecialtimesetService.update(bean);
		Map<String,String> map = new HashMap<String,String>();
		//0失败 1成功
		String result="0";
		if (flag) {
			result = "1";
		}
		map.put("result", result);
		JSONArray js =JSONArray.fromObject(map);
		System.out.print(js.toString());		
		return js.toString();
	}
	/** 
	 * 修改特殊时间设置
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "signin/updatespecialtime")
	public String updateSpecialTime(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		
		String id = request.getParameter("id");
		System.out.println(id);
		String specialStartDate  = request.getParameter("specialStartDate");
		String specialEndDate = request.getParameter("specialEndDate");
		String gotoworktime = request.getParameter("gotoworktime");
		String flag = request.getParameter("flag");
		if(gotoworktime.length()==5){
			gotoworktime += ":00";
		}
		String afterworktime = request.getParameter("afterworktime");
		if(afterworktime.length()==5){
			afterworktime += ":00";
		}
		FlxoaAttendanceSpecialtimeset flxoaAttendanceSpecialtimeset = new FlxoaAttendanceSpecialtimeset();
		flxoaAttendanceSpecialtimeset.setId(Integer.valueOf(id));
		FlxoaAttendanceSpecialtimeset bean = flxoaAttendanceSpecialtimesetService.queryById(flxoaAttendanceSpecialtimeset);
		bean.setSpecialStartDate(DateUtils.dateToTimestamp(specialStartDate));
		bean.setSpecialEndDate(DateUtils.dateToTimestamp(specialEndDate));
		bean.setGotoworktime(gotoworktime);
		bean.setAfterworktime(afterworktime);
		bean.setFlag(flag);		
		boolean flg = flxoaAttendanceSpecialtimesetService.update(bean);
		Map<String,String> map = new HashMap<String,String>();
		//0失败 1成功
		String result="0";
		if (flg) {
			result = "1";
		}
		map.put("result", result);
		JSONArray js =JSONArray.fromObject(map);
		System.out.print(js.toString());		
		return js.toString();
	}
	/**
	 * 删除特殊时间信息（真删）
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "signin/deleteSpecialTime")
	public String deleteSpecialTime(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		FlxoaAttendanceSpecialtimeset flxoaAttendanceSpecialtimeset = new FlxoaAttendanceSpecialtimeset();
		
		flxoaAttendanceSpecialtimeset.setId(1);
		FlxoaAttendanceSpecialtimeset bean = flxoaAttendanceSpecialtimesetService.queryById(flxoaAttendanceSpecialtimeset);
		
		
		//bean.setFlag("1");
		bean.setDeleteFlag("1");
		//更新用户
		bean.setUpdateUserId(1);
		//更新部门
		bean.setUpdateDepartmentId(1);
		//更新时间
		bean.setUpdateTime(DateUtils.getSecondTimestamp(new Date()));
		boolean flag = flxoaAttendanceSpecialtimesetService.update(bean);
		//0失败 1成功
		String result="0";
		if (flag){
					result = "1";
				}
						
		System.out.print(result);		
		return "";
	}
}

