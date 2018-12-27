package com.flx.flxoa.info.signin.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
import com.flx.flxoa.info.signin.entity.FlxoaAttendanceHolidayset;
import com.flx.flxoa.info.signin.entity.FlxoaAttendanceSigndetails;
import com.flx.flxoa.info.signin.manager.FlxoaAttendanceHolidaysetService;

/**
 * 类名称：FlxoaAttendanceHolidaysetController.java
 * 类描述：节假日设定
 * 创建时间：2018-3-27, 下午1:32:46
 * 
 * @version 1.0 
 * @since JDK版本 1.7
 * @author 张海英
 */
@Controller
public class FlxoaAttendanceHolidaysetController {
	
	protected FlxoaAttendanceHolidaysetService flxoaAttendanceHolidaysetService;

	public FlxoaAttendanceHolidaysetService getFlxoaAttendanceHolidaysetService() {
		return flxoaAttendanceHolidaysetService;
	}

	@Autowired
	public void setFlxoaAttendanceHolidaysetService(
			FlxoaAttendanceHolidaysetService flxoaAttendanceHolidaysetService) {
		this.flxoaAttendanceHolidaysetService = flxoaAttendanceHolidaysetService;
	}
	/**
	 * 去节假日页面
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "signin/holidayset",produces="text/html;charset=UTF-8")
	public String goList(HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		return "nk/pages/signIn/holidaySet";
	}
	/**
	 * 初始化节假日
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/signin/initHoliday",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String initHoliday(HttpServletRequest request,HttpServletResponse response,FlxoaAttendanceHolidayset model){
		//获取session中的数值
		HttpServletRequest rep = (HttpServletRequest)request;
		//获取用户id
		String userId = String.valueOf(rep.getSession().getAttribute("userId"));
		//获取部门id
		String departmentId = String.valueOf(rep.getSession().getAttribute("departmentId"));
		//时间
		int nowTime = DateUtils.getSecondTimestamp(new Date());
		//未删除 0  已删除1
		String deleteFlag = "0";
		//类型 周末 0 节假日 1 上班 2 
		String types = "0";
		//从request中获取年份
		int year = Integer.valueOf(request.getParameter("year"));
		//int year =2017;
		//0表是一月，1表示周日
		Calendar calendar=new GregorianCalendar(year,0,1);  
        int i=1;  
        String result = "0";
        //在初始化前先去查询数据库中是否有这一年的数据
        FlxoaAttendanceHolidayset holiday = new FlxoaAttendanceHolidayset();
        holiday.setYears(String.valueOf(year));
        List<FlxoaAttendanceHolidayset> holidaysetList = flxoaAttendanceHolidaysetService.showAllHolidaysEveryYear(holiday);
        
        if(holidaysetList.size() == 0 ){
        	//如果holidaysetList为空，进行初始化操作
        	while(calendar.get(Calendar.YEAR)<year+1){  
                calendar.set(Calendar.WEEK_OF_YEAR,i++);  
                calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);  
                if(calendar.get(Calendar.YEAR)==year){
            		FlxoaAttendanceHolidayset holidayset = new FlxoaAttendanceHolidayset();
                    System.out.printf("星期天:%tF%n",calendar);
                    Date date = calendar.getTime();
                    //节假日
                    int legalHolidays = DateUtils.getSecondTimestamp(date);
                    System.out.println("星期天:"+legalHolidays);
                    holidayset.setLegalHolidays(legalHolidays);
                    //年份
                    holidayset.setYears(String.valueOf(year));
                    holidayset.setCreateUserId(Integer.valueOf(userId));
                    holidayset.setUpdateUserId(Integer.valueOf(userId));
                    holidayset.setCreateDepartmentId(Integer.valueOf(departmentId));
                    holidayset.setUpdateDepartmentId(Integer.valueOf(departmentId));
                    holidayset.setCreateTime(nowTime);
                    holidayset.setUpdateTime(nowTime);
                    holidayset.setDeleteFlag(deleteFlag);
                    holidayset.setTypes(types);
                    boolean b = flxoaAttendanceHolidaysetService.add(holidayset);
                    if (b) {
        				result = "1";
        				System.out.println("节假日设置成功！");
        			}
                }  
                calendar.set(Calendar.DAY_OF_WEEK,Calendar.SATURDAY);  
                if(calendar.get(Calendar.YEAR)==year){
                	FlxoaAttendanceHolidayset holidayset = new FlxoaAttendanceHolidayset();
                    System.out.printf("星期六:%tF%n",calendar); 
                    Date date = calendar.getTime();
                    //节假日
                    int legalHolidays = DateUtils.getSecondTimestamp(date);
                    holidayset.setLegalHolidays(legalHolidays);
                    //年份
                    holidayset.setYears(String.valueOf(year));
                    holidayset.setCreateUserId(Integer.valueOf(userId));
                    holidayset.setUpdateUserId(Integer.valueOf(userId));
                    holidayset.setCreateDepartmentId(Integer.valueOf(departmentId));
                    holidayset.setUpdateDepartmentId(Integer.valueOf(departmentId));
                    holidayset.setCreateTime(nowTime);
                    holidayset.setUpdateTime(nowTime);
                    holidayset.setDeleteFlag(deleteFlag);
                    holidayset.setTypes(types);
                    boolean b = flxoaAttendanceHolidaysetService.add(holidayset);
                    if (b) {
        				result = "1";
        				System.out.println("节假日设置成功！");
        			}
                }  
            }
            System.out.println("节假日初始化成功！");
        	
        }else{
        	//如果holidaysetList不为空，无法进行初始化操作
        	result = "0";
        	System.out.println("节假日初始化失败！");
        }
        return result;
	}

	/**
	 * 获取每年中的所有节假日
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/signin/showallholidayseveryyear",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String showAllHolidaysEveryYear(HttpServletRequest request,HttpServletResponse response,FlxoaAttendanceHolidayset model){
		//year 有的话从 request中获取
		String year = request.getParameter("year") ;
		//String year = "2018";
		JSONArray json = new JSONArray();
		Map<String,String> map = new HashMap<String,String>();
		FlxoaAttendanceHolidayset holidayset = new FlxoaAttendanceHolidayset();
		JSONArray jsonMap = new JSONArray();
		if(year != null && year !=""){
			holidayset.setYears(year);
			List<FlxoaAttendanceHolidayset> holidaysetList = flxoaAttendanceHolidaysetService.showAllHolidaysEveryYear(holidayset);
			for(int i=0;i<holidaysetList.size();i++){
				//获取法定节假日
				int legalHoliday = holidaysetList.get(i).getLegalHolidays();
				//获取节假日类型
				String holidayType = holidaysetList.get(i).getTypes();
				String type ="";
				if(holidayType.equals("0")){
					//周末
					type = "freeday";
				}else if(holidayType.equals("1")){
					//节假日
					type = "lawday";
				}else if(holidayType.equals("2")){
					//节假日加班
					type = "tradeday";
				}
				String legalHolidays = DateUtils.timestampDate(legalHoliday).substring(5);
				map.put("legalHolidays", legalHolidays);
				map.put("type", type);
				jsonMap = json.put(map);
			}
		}else{
			return null;
		}
		System.out.print(map);
		return jsonMap.toString();
	}

	/**
	 * 设置选中的节假日
	 * @param request
	 * @param response
	 * @param model
	 * @throws ParseException 
	 */
	@RequestMapping(value="/signin/setholidays",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String addSelectedHoliday(HttpServletRequest request,HttpServletResponse response,FlxoaAttendanceHolidayset model) throws ParseException{
		//获取session中的数值
		HttpServletRequest rep = (HttpServletRequest)request;
		//获取用户id
		String userId = String.valueOf(rep.getSession().getAttribute("userId"));
		//获取部门id
		String departmentId = String.valueOf(rep.getSession().getAttribute("departmentId"));
		//时间
		int nowTime = DateUtils.getSecondTimestamp(new Date());
		//未删除 0  已删除1
		String deleteFlag = "0";
		//获取节假日设定的类型(周末:freeday 法定假日:lawday 节假日加班:workday)
		String holidayType = request.getParameter("holidayType");
		String type = "";
		if(holidayType.equals("freeday")){
			//周末
			type = "0";
		}else if(holidayType.equals("lawday")){
			//节假日
			type = "1";
		}else if(holidayType.equals("tradeday")){
			//节假日加班
			type = "2";
		}
		//获取年份
		String year = request.getParameter("year");
		//获取开始日期
		String startDate = year +"-"+ request.getParameter("startDate");
		//获取结束日期
		String endDdate = year +"-"+ request.getParameter("endDdate");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dBegin = sdf.parse(startDate);  
        Date dEnd = sdf.parse(endDdate);  
        //根据开始时间和结束时间返回时间段内的时间集合 
        List<Date> listDate = DateUtils.getDatesBetweenTwoDate(dBegin, dEnd);
        //int legalHolidays =0;
        String result = "0";
        for(int i=0;i<listDate.size();i++){
        	FlxoaAttendanceHolidayset holidayset = new FlxoaAttendanceHolidayset();
        	String dates = sdf.format(listDate.get(i));
        	int legalHolidays = DateUtils.getSecondTimestamp(DateUtils.parse(dates));
        	//设置时要判断是设置节假日（休）还是调休上班（班）
    		model.setLegalHolidays(legalHolidays);
    		FlxoaAttendanceHolidayset flxoaAttendanceHolidayset = flxoaAttendanceHolidaysetService.queryByLegalHolidays(model);
    		if(flxoaAttendanceHolidayset == null){
    			//如果为空，则新增节假日，并且状态为节假日 （休）1
    			holidayset.setLegalHolidays(legalHolidays);
    			//年份
    			holidayset.setYears(year);
    	
    	        holidayset.setTypes(type);
    	        boolean b = flxoaAttendanceHolidaysetService.add(holidayset);
    	        if (b) {
    				result = "1";
    				System.out.println("节假日设置成功！");
    			}
    		}else{
    			//如果不为空，则修改节假日为上班，并且状态为调休上班（班） 2
    			flxoaAttendanceHolidayset.setLegalHolidays(legalHolidays);
    			//年份
    			flxoaAttendanceHolidayset.setYears(year);
 
    			flxoaAttendanceHolidayset.setTypes(type);
    	        boolean b = flxoaAttendanceHolidaysetService.update(flxoaAttendanceHolidayset);
    	        if (b) {
    				result = "1";
    				System.out.println("节假日设置成功！");
    			}
    		}
        }
		return result;
	}
	
	/**
	 * 删除设置的节假日，恢复到原来
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(value="/signin/deleteholidays",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String deleteSelectedHoliday(HttpServletRequest request,HttpServletResponse response,FlxoaAttendanceHolidayset model) throws ParseException{
		//获取节假日设定的类型(周末:freeday 法定假日:lawday 节假日加班:workday)
				String holidayType = request.getParameter("holidayType");
				String type = "";
				if(holidayType.equals("freeday")){
					//周末
					type = "0";
				}else if(holidayType.equals("lawday")){
					//节假日
					type = "1";
				}else if(holidayType.equals("tradeday")){
					//节假日加班
					type = "2";
				}
				//获取年份
				String year = request.getParameter("year");
				//获取开始日期
				String startDate = year +"-"+ request.getParameter("startDate");
				//获取结束日期
				String endDdate = year +"-"+ request.getParameter("endDdate");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date dBegin = sdf.parse(startDate);  
		        Date dEnd = sdf.parse(endDdate);
		        
		        //根据开始时间和结束时间返回时间段内的时间集合 
		        String result = "0";
		        if(startDate.equals(endDdate)){
		        	String dates = sdf.format(dBegin);
		        	int legalHoliday = DateUtils.getSecondTimestamp(DateUtils.parse(dates));
		        	//删除时要判断是设置节假日（休）还是调休上班（班）
		    		model.setLegalHolidays(legalHoliday);
		    		model.setYears(year);
		    		FlxoaAttendanceHolidayset flxoaAttendanceHolidayset = flxoaAttendanceHolidaysetService.queryByLegalHolidays(model);
		    		if(flxoaAttendanceHolidayset == null || "".equals(flxoaAttendanceHolidayset)){
		    			//如果为空,则是这天未设置节假日，不能删除		    			
		    	        boolean b = true;
		    	        if (!b) {
		    				result = "2";
		    				System.out.println("这天不曾为节假日，无需删除");
		    			}
		    		}else{
		    			//如果不为空，则修改节假日为上班，并且状态为调休上班（班） 2		    			
		    	        boolean b = flxoaAttendanceHolidaysetService.deleteHoliday(flxoaAttendanceHolidayset);
		    	        if (b) {
		    				result = "1";
		    				System.out.println("恢复为工作日！");
		    			}
		    		}
		        }else{
		        	List<Date> listDate  = DateUtils.getDatesBetweenTwoDate(dBegin, dEnd);		        	
		        	//int legalHolidays =0;
		        	for(int i=0;i<listDate.size();i++){
		        		String dates = sdf.format(listDate.get(i));
		        		int legalHolidays = DateUtils.getSecondTimestamp(DateUtils.parse(dates));
		        		//设置时要判断是设置节假日（休）还是调休上班（班）
		        		model.setLegalHolidays(legalHolidays);
		        		model.setYears(year);
		        		FlxoaAttendanceHolidayset flxoaAttendanceHolidayset = flxoaAttendanceHolidaysetService.queryByLegalHolidays(model);
		        		if(flxoaAttendanceHolidayset == null && "".equals(flxoaAttendanceHolidayset)){
		        			//如果为空,则是这天未设置节假日，不能删除		    			
		        			boolean b = true;
		        			if (!b) {
		        				result = "2";
		        				System.out.println("这天不曾为节假日，无需删除");
		        			}
		        		}else{
		        			//如果不为空，则修改节假日为上班，并且状态为调休上班（班） 2		    			
		        			boolean b = flxoaAttendanceHolidaysetService.deleteHoliday(flxoaAttendanceHolidayset);
		        			if (b) {
		        				result = "1";
		        				System.out.println("恢复为工作日！");
		        			}
		        		}
		        	}
		        	
		        }
		       
				return result;
	}
}
