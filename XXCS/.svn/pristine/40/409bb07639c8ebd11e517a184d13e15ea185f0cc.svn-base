package com.flx.flxoa.info.signin.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flx.flxoa.common.util.CommonUtils;
import com.flx.flxoa.common.util.DateUtils;
import com.flx.flxoa.common.util.ExcelExport;
import com.flx.flxoa.info.signin.entity.FlxoaAttendanceSummary;
import com.flx.flxoa.info.signin.manager.FlxoaAttendanceSigndetailsService;
import com.flx.flxoa.info.signin.manager.FlxoaAttendanceSummaryService;
import com.flx.flxoa.info.system.comon.Permission;
import com.flx.flxoa.info.system.entity.FlxoaSystemUser;
import com.flx.flxoa.info.system.manager.FlxoaSystemUserService;

/**
 * 类名称：FlxoaAttendanceSummaryController.java
 * 类描述：考勤汇总控制类
 * 创建时间：2018-3-16, 下午3:11:47
 * 
 * @version 1.0 
 * @since JDK版本 1.7
 * @author 夏改翠
 */
@Controller
public class FlxoaAttendanceSummaryController {
	
	protected FlxoaAttendanceSummaryService flxoaAttendanceSummaryService;
	protected FlxoaAttendanceSigndetailsService flxoaAttendanceSigndetailsService;
	protected FlxoaSystemUserService flxoaSystemUserService; 
	@Autowired
	public void setFlxoaAttendanceSummaryService(
			FlxoaAttendanceSummaryService flxoaAttendanceSummaryService) {
		this.flxoaAttendanceSummaryService = flxoaAttendanceSummaryService;
	}
	@Autowired
	public void setFlxoaAttendanceSigndetailsService(
			FlxoaAttendanceSigndetailsService flxoaAttendanceSigndetailsService) {
		this.flxoaAttendanceSigndetailsService = flxoaAttendanceSigndetailsService;
	}
	@Autowired
	public void setFlxoaSystemUserService(
			FlxoaSystemUserService flxoaSystemUserService) {
		this.flxoaSystemUserService = flxoaSystemUserService;
	}
	@RequestMapping(value = "signin/goShow",produces = "text/html;charset=utf-8")
	public String goList(HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		return "nk/pages/signIn/signIn";
	}
	/**
	 * 我的考勤列表	 
	 */
	@ResponseBody
	@RequestMapping(value = "signin/showMySignSummary",produces = "text/html;charset=utf-8")
	public String searchMySignSummary(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		System.out.print("我的考勤汇总查询。。。。。。。。。。。。。controller");
		String pageNo = request.getParameter("pageNo"); 
		String pageSize = request.getParameter("pageSize");
		String draw = request.getParameter("draw");
		if (pageNo==""||pageNo==null){
			pageNo="0";
		}
		if(pageSize==""||pageSize==null){
			pageSize="10";
		}
		FlxoaAttendanceSummary flxoaAttendanceSummary = new FlxoaAttendanceSummary();
		String status = request.getParameter("signstatus");
		String starttime = request.getParameter("signInStartDate");
		String endtime = request.getParameter("signInEndDate");
		flxoaAttendanceSummary.setSignStatus(status);
		if(!CommonUtils.isEmpty(starttime)){
			flxoaAttendanceSummary.setStartDate(DateUtils.dateToTimestamp(starttime));			
		}else{//初始化加载‘我的签到’时，显示近一个月的数据
			//获取当天一个月前的日期
			flxoaAttendanceSummary.setStartDate(DateUtils.getCouMonthStart());			
			//初始化加载‘我的签到’时，显示近一个月的数据
			//当天凌晨时间
			flxoaAttendanceSummary.setEndDate(DateUtils.getMorningTimestamp());
		}
		if(!CommonUtils.isEmpty(endtime)){
			flxoaAttendanceSummary.setEndDate(DateUtils.dateToTimestamp(endtime));
		}
		
			
		HttpServletRequest req = (HttpServletRequest) request;
		String path =req.getServletPath()+req.getPathInfo();
		String userId = String.valueOf(req.getSession().getAttribute("userId"));
			
		String cardId = String.valueOf(req.getSession().getAttribute("cardId"));
		List<FlxoaSystemUser> cardList =null;
		List<FlxoaAttendanceSummary> returnList = new ArrayList<FlxoaAttendanceSummary>();
		//查询汇总表的信息（除当天以外的）
		//查询汇总表的信息（除当天以外的）
		flxoaAttendanceSummary.setCreateUserId(Integer.valueOf(userId));
		List<FlxoaAttendanceSummary> MySqlList  = flxoaAttendanceSummaryService.queryByUserIds(flxoaAttendanceSummary,userId);
		//将当天日期凌晨时间戳
		int currentDay = DateUtils.getMorningTimestamp();
		
		if(CommonUtils.isEmpty(starttime)){
			if(CommonUtils.isEmpty(status)||status.equals("10")){
				//查询我的当天考勤的信息		
				List<FlxoaAttendanceSummary> list = flxoaAttendanceSummaryService.queryCurrentSign(flxoaAttendanceSummary,userId,cardId,cardList);
				//遍历当天考勤的list
				returnList.addAll(list);				
			}
		}
		else if(!CommonUtils.isEmpty(starttime)&&!CommonUtils.isEmpty(endtime)){
			if(DateUtils.dateToTimestamp(starttime)<=currentDay && DateUtils.dateToTimestamp(endtime)>=currentDay){
				if(status.equals("10")){
					//查询我的当天考勤的信息		
					List<FlxoaAttendanceSummary> list = flxoaAttendanceSummaryService.queryCurrentSign(flxoaAttendanceSummary,userId,cardId,cardList);
					//遍历当天考勤的list
					returnList.addAll(list);					
				}
			}			
		}
		else if(!CommonUtils.isEmpty(starttime)&&CommonUtils.isEmpty(endtime)){
			if(DateUtils.dateToTimestamp(starttime)==currentDay){
				if(status.equals("10")){
					//查询我的当天考勤的信息		
					List<FlxoaAttendanceSummary> list = flxoaAttendanceSummaryService.queryCurrentSign(flxoaAttendanceSummary,userId,cardId,cardList);
					//遍历当天考勤的list
					returnList.addAll(list);					
				}
			}
		}
		returnList.addAll(MySqlList);
		Map<String,String> map = new HashMap<String,String>();
		map.put("pageNo", pageNo);
		map.put("pageSize", pageSize);
		map.put("draw", draw);
		
		Map<String,List<FlxoaAttendanceSummary>> maplist = new HashMap<String, List<FlxoaAttendanceSummary>>();
		maplist.put("returnList", returnList);
		JSONArray js =JSONArray.fromObject(maplist);
		return flxoaAttendanceSummaryService.queryPageSign(map, returnList);
	}
	/**
	 * 领导添加备注
	 */
	@ResponseBody
	@RequestMapping(value = "signin/updateSignSummary",produces = "text/html;charset=utf-8")
	public String updateSignSummary(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		FlxoaAttendanceSummary flxoaAttendanceSummary = new FlxoaAttendanceSummary();
		//获取批注人信息
		String realName = String.valueOf(request.getSession().getAttribute("realName"));
		//获取当前批注时间
		Date date1 = new Date(); 
		String date = DateUtils.format2(date1);
		//获取id
		String id = request.getParameter("id");
		//获取批注
		String comments = request.getParameter("comments");
		comments += "\n"+"(批注人："+realName+",批注时间："+date+") ";
		flxoaAttendanceSummary.setId(Integer.valueOf(id));
		//根据id查询记录
		FlxoaAttendanceSummary summary = flxoaAttendanceSummaryService.queryById(flxoaAttendanceSummary);
		summary.setLeaderComments(comments);
		boolean flag = flxoaAttendanceSummaryService.update(summary);
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
	 * 部门签到信息(当天+之前)
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@ResponseBody
	@RequestMapping(value = "signin/showSignSummary",produces = "text/html;charset=utf-8")
	public String searchSignSummary(HttpServletRequest request,HttpServletResponse response,ModelMap model) throws UnsupportedEncodingException{
		FlxoaAttendanceSummary  summary  =new FlxoaAttendanceSummary();
		String pageNo = request.getParameter("pageNo"); 
		String pageSize = request.getParameter("pageSize");
		String draw = request.getParameter("draw");
		if (pageNo==""||pageNo==null){
			pageNo="0";
		}
		if(pageSize==""||pageSize==null){
			pageSize="10";
		}
		String realname = request.getParameter("realname");
		if(!CommonUtils.isEmpty(realname)){
			realname =  URLDecoder.decode(request.getParameter("realname"), "UTF-8");
		}
		String status = request.getParameter("signstatus");
		String dname = request.getParameter("department");
		if(!CommonUtils.isEmpty(dname)){
			dname = URLDecoder.decode(request.getParameter("department"), "UTF-8");
		}		
		String starttime = request.getParameter("signInStartDate");
		String endtime = request.getParameter("signInEndDate");
		//批注是否为空条件
		String isPostil = request.getParameter("isPostil");
		summary.setRealname(realname);
		summary.setSignStatus(status);
		summary.setLeaderComments(isPostil);
		summary.setDname(dname);	
		if(!CommonUtils.isEmpty(starttime)){
			summary.setStartDate(DateUtils.dateToTimestamp(starttime));			
		}else{
			//初始化‘部门签到’时，默认查询近一周的考勤记录
			//获取当天一周的日期
			summary.setStartDate(DateUtils.getCouWeekStart());
			//当天凌晨时间点
			summary.setEndDate(DateUtils.getMorningTimestamp());
		}
		if(!CommonUtils.isEmpty(endtime)){
			summary.setEndDate(DateUtils.dateToTimestamp(endtime));
		}
		String path =request.getServletPath()+request.getPathInfo();
		int userId = Integer.parseInt(String.valueOf(request.getSession().getAttribute("userId")));
		Map<String,List<Integer>>  map = Permission.getRolePermission(userId, path);		

		List<FlxoaSystemUser> cardList =null;
		//根据权限判断 传userid 还是deptid 查询人员的cardid
		//普通员工
		/*if(map.size()==1){
			System.out.println();
			if("普通员工".equals(StringUtils.strip(map.keySet().toString(),"[]")) || "子公司普通员工".equals(StringUtils.strip(map.keySet().toString(),"[]")) || "超级管理员".equals(StringUtils.strip(map.keySet().toString(),"[]"))){
				String deptIds =  Permission.getDepartMentIds(map);				
				cardList = flxoaSystemUserService.queryCardIds(userId,deptIds);
			}			
		}
		else{
				String deptIds =  Permission.getDepartMentIds(map);
				cardList = flxoaSystemUserService.queryCardIds(userId,deptIds);			
		}*/
		/*部门签到  SQL拼接条件deptids*/
		userId=0;
		String deptIds =  Permission.getDepartMentIds(map);				
		cardList = flxoaSystemUserService.queryCardIds(userId,deptIds);
		StringBuffer cardIds = new StringBuffer();   
		StringBuffer userIds = new StringBuffer();   
		for(int i=0;i<cardList.size();i++){	
			cardIds.append(cardList.get(i).getCardId().toString()) ;
			userIds.append(cardList.get(i).getId().toString());
			if(i<cardList.size()-1){
				cardIds.append(",");
				userIds.append(",");
			}
		}
		
		//将当天日期凌晨时间戳
		int currentDay = DateUtils.getMorningTimestamp();
		List<FlxoaAttendanceSummary> returnList = new ArrayList<FlxoaAttendanceSummary>();;
		//时间不为空时
		//判断是否查询今天的
		if(!CommonUtils.isEmpty(starttime) && !CommonUtils.isEmpty(endtime)){
			if(DateUtils.dateToTimestamp(starttime)<=currentDay && DateUtils.dateToTimestamp(endtime)>=currentDay){
				if(status.equals("10")&&CommonUtils.isEmpty(isPostil)){
					//查询当天考勤的信息
					List<FlxoaAttendanceSummary> list = flxoaAttendanceSummaryService.queryCurrentSign(summary,userIds.toString(),cardIds.toString(),cardList);
					returnList.addAll(list);					
				}
			}			
		}else if(!CommonUtils.isEmpty(starttime) && CommonUtils.isEmpty(endtime)){
			if(DateUtils.dateToTimestamp(starttime)==currentDay){
				if(status.equals("10")&&CommonUtils.isEmpty(isPostil)){
					//查询当天考勤的信息
					List<FlxoaAttendanceSummary> list = flxoaAttendanceSummaryService.queryCurrentSign(summary,userIds.toString(),cardIds.toString(),cardList);
					returnList.addAll(list);					
				}
			}
		}//时间为空，查询条件‘考勤状态为10’，其他条件有值都需查询今天的考勤
		else if(CommonUtils.isEmpty(starttime)){
			//if(CommonUtils.isEmpty(realname)&&CommonUtils.isEmpty(realname)&&CommonUtils.isEmpty(status)){
			if(CommonUtils.isEmpty(status)||status.equals("10")){//查询当天考勤的信息
				if(CommonUtils.isEmpty(isPostil)){ //是否为空除当天外
					List<FlxoaAttendanceSummary> list = flxoaAttendanceSummaryService.queryCurrentSign(summary,userIds.toString(),cardIds.toString(),cardList);
					returnList.addAll(list);					
				}
			}
		}
		
		//查询汇总表的信息（除当天以外的）
		List<FlxoaAttendanceSummary> MySqlList  = flxoaAttendanceSummaryService.queryByUserIds(summary,deptIds);
		returnList.addAll(MySqlList);

		String expFlag = request.getParameter("flag");
		if(!CommonUtils.isEmpty(expFlag)){
			boolean Flag = ExcelExport.excelExportSign(returnList, response);
			if(Flag=true){
				System.out.println("考勤导出成功！");
			}
			else{
				System.out.println("导出失败！");
			}			
		}
		Map<String,String> pageMap = new HashMap<String,String>();
		pageMap.put("pageNo", pageNo);
		pageMap.put("pageSize", pageSize);
		pageMap.put("draw", draw);
		return flxoaAttendanceSummaryService.queryPageSign(pageMap, returnList);
	}

}
