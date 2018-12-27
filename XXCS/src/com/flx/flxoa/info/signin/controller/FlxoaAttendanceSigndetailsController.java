package com.flx.flxoa.info.signin.controller;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.Date;
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
import com.flx.flxoa.common.util.DateUtils;
import com.flx.flxoa.info.signin.entity.FlxoaAttendanceSigndetails;
import com.flx.flxoa.info.signin.entity.FlxoaAttendanceSummary;
import com.flx.flxoa.info.signin.manager.FlxoaAttendanceSigndetailsService;

/**
 * 类名称：FlxoaAttendanceSigndetailsController.java
 * 类描述：考勤签到明细控制类
 * 创建时间：2018-3-16, 下午3:10:46
 * 
 * @version 1.0 
 * @since JDK版本 1.7
 * @author 张海英
 */
@Controller
public class FlxoaAttendanceSigndetailsController {
	
	protected FlxoaAttendanceSigndetailsService flxoaAttendanceSigndetailsService;
	
	
	@Autowired
	public void setFlxoaAttendanceSigndetailsService(
			FlxoaAttendanceSigndetailsService flxoaAttendanceSigndetailsService) {
		this.flxoaAttendanceSigndetailsService = flxoaAttendanceSigndetailsService;
	}
	
	@RequestMapping(value="/goTodayAllSign")
	public String goTodayAllSign(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		System.out.println("******查询全员当天考勤*******");
		return "goTodayAllSign";
	}
	
	/**
	 * 查询全员当天考勤
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws ParseException
	 */
	@RequestMapping(value="/showTodayAllSign",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String showTodayAllSign(HttpServletRequest request,HttpServletResponse response,FlxoaAttendanceSummary model){
		List<FlxoaAttendanceSigndetails> list = flxoaAttendanceSigndetailsService.query(null);
		for (int i = 0; i < list.size(); i++) {
			//获取签到时间
			int signTime = list.get(i).getSignTime();
			//将时间戳转化为String
			String newSignTime = DateUtils.timestampToDate(signTime);
			//获取签到备注
			String commetns = list.get(i).getCommens();
			//获取签到地点
			String signLocale = list.get(i).getSignLocale();
			//获取签到类型
			String signType = list.get(i).getSignType();
		}
		JSONArray json = JSONArray.fromObject(list);
		System.out.println(json);
		return json.toString();
	}
	
	/**
	 * 查询考勤明细     
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws ParseException
	 */
	@RequestMapping(value="/showSignDetail",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String showSignDetail(HttpServletRequest request,HttpServletResponse response,FlxoaAttendanceSummary model) throws ParseException {
		FlxoaAttendanceSigndetails flxoaAttendanceSigndetails = new FlxoaAttendanceSigndetails();
		//获取要查询的用户id
		String userId  = request.getParameter("userId");
		//获取签到日期
		String signDate = request.getParameter("signDate");		
		//将当天日期凌晨时间戳
		int currentDay = DateUtils.getMorningTimestamp();
		if(CommonUtils.isEmpty(signDate)){
			flxoaAttendanceSigndetails.setSignDate(currentDay);
		}else{
			int signDate1 = Integer.parseInt(signDate);
			flxoaAttendanceSigndetails.setSignDate(signDate1);
			//flxoaAttendanceSigndetails.setSignDate(DateUtils.getSecondTimestamp(DateUtils.parse(signDate)));
		}
		//获取cardid
		String cardId = request.getParameter("cardId");
		
		//获取realname
		String realname = request.getParameter("realname");
		
		System.out.println(realname);
		//获取部门名称 dname
		String dname = request.getParameter("dname");
		
		System.out.println(dname);
		//String userId  = "2";
		//String signDate ="2018-04-12";
		//将日期转换为时间戳
		flxoaAttendanceSigndetails.setCreateUserId(Integer.parseInt(userId));		
		flxoaAttendanceSigndetails.setCard_id(cardId);
		flxoaAttendanceSigndetails.setRealname(realname);
		flxoaAttendanceSigndetails.setDname(dname);
		//根据用户id 和 签到日期查询数据
		List<FlxoaAttendanceSigndetails> detailsList = flxoaAttendanceSigndetailsService.querySignDetail(flxoaAttendanceSigndetails);
		//遍历detailsList
		Map<String,List<FlxoaAttendanceSigndetails>> maplist = new HashMap<String,List<FlxoaAttendanceSigndetails>>();
		maplist.put("signdetailsList", detailsList);
		JSONArray json = JSONArray.fromObject(maplist);
		return json.toString();
	}
	/**
	 * 手机签到 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value="/addSignDetail",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String insertAppSign(HttpServletRequest request,HttpServletResponse response,FlxoaAttendanceSigndetails model){
		//返回当前系统时间  年月日 时分秒  星期三
		Date date = new Date();
		String date1 = DateUtils.format2(date);
		//参数为null时表示获取当前日期是星期几
		String weekOfDate = null; 
		weekOfDate = DateUtils.getWeekOfDate(null);
		//将当天日期凌晨时间戳
		int currentDay = DateUtils.getMorningTimestamp();
		//类型  0 手机签到（上下班） 3 公出 4出差  空的情况下 返回当前系统时间
		String type = request.getParameter("type");
		String address = request.getParameter("address");
		/*if(!CommonUtils.isEmpty(address)){
			address = URLDecoder.decode(request.getParameter("address"), "UTF-8");
		}*/		 
		//经度
		String longitude = request.getParameter("longitude");
		//纬度
		String latitude = request.getParameter("latitude");
		//事由 类型为 0 时 为空 ，3,4时必填
		String comment =request.getParameter("comment");
		//获取登录人的id 
		//String userId = String.valueOf(request.getSession().getAttribute("userId"));
		//获取登录人的部门id
		//String deptId = String.valueOf(request.getSession().getAttribute("departmentId"));
		//获取登录人的cardid (可有可无)
		//String cardId = String.valueOf(request.getSession().getAttribute("cardId"));
		boolean flag=false;
		String result="0";
		System.out.println("签到日期----"+new Date());
		if(!CommonUtils.isEmpty(type)){
			model.setCommens(comment);
			model.setSignDate(currentDay);
			model.setSignTime(DateUtils.getSecondTimestamp(new Date()));
			model.setSignLocale(address);
			model.setSignLatitude(latitude);
			model.setSignLongitude(longitude);
			model.setSignType(type);			
			
			flag = flxoaAttendanceSigndetailsService.add(model);
			
			if (flag) {
				result = "1";
			}else{
				result="0";
			}
		}else{
			result=date1+"\t"+weekOfDate;
		}
		//Map<String,String> map = new HashMap<String,String>();
		//0失败 1成功
		
		/*map.put("result", result);
		JSONArray js =JSONArray.fromObject(map);
		System.out.print(js.toString());		
		return js.toString();*/
		System.out.println(result);
		return result;
	}
}
