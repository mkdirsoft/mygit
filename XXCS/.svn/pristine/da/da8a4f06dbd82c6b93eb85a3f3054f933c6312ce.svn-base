package com.flx.flxoa.info.projectmanagement.controller;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flx.flxoa.common.util.CommonUtils;
import com.flx.flxoa.common.util.DateUtils;
import com.flx.flxoa.common.util.ExcelExport;
import com.flx.flxoa.info.projectmanagement.entity.FlxoaProjectFocus;
import com.flx.flxoa.info.projectmanagement.entity.FlxoaProjectInformation;
import com.flx.flxoa.info.projectmanagement.entity.FlxoaProjectTeam;
import com.flx.flxoa.info.projectmanagement.manager.FlxoaProjectFocusService;
import com.flx.flxoa.info.projectmanagement.manager.FlxoaProjectInformationService;
import com.flx.flxoa.info.system.comon.Permission;

/**
 * @author 雷君
 * @version 创建时间：2018-3-15 上午11:53:01 类说明 项目管理组
 */
@Controller
public class FlxoaProjectManagementController {

	protected FlxoaProjectInformationService flxoaProjectInformationService;
	protected FlxoaProjectFocusService flxoaProjectFocusService;

	@Autowired
	public void setFlxoaProjectInformationService(
			FlxoaProjectInformationService flxoaProjectInformationService) {
		this.flxoaProjectInformationService = flxoaProjectInformationService;
	}
	@Autowired
	public void setFlxoaProjectFocusService(
			FlxoaProjectFocusService flxoaProjectFocusService) {
		this.flxoaProjectFocusService = flxoaProjectFocusService;
	}
	@RequestMapping(value = "projectlist")
	public String projectList(HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		
		return "nk/pages/projectManage/projectManage";
	}
	
	
	@RequestMapping(value = "/market/active", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String marketActive(HttpServletRequest request,HttpServletResponse response) {
		String type = request.getParameter("type");
		JSONObject json = new JSONObject();
		String str = "";
		String active = "{" + 
				"	reason:查询成功" + 
				"	result:[" + 
				"		{" + 
				"			daogu:[ " + 
				"				{CropOfferStr:湖南长沙早籼稻报价,OfferDate:2018/10/25,price:2320,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"				{CropOfferStr:湖南常德早籼稻报价,OfferDate:2018/10/25,price:2310,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"				{CropOfferStr:广东广州早籼稻报价,OfferDate:2018/10/25,price:2720,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"				{CropOfferStr:广西桂林早籼稻报价,OfferDate:2018/10/25,price:2700,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"				{CropOfferStr:江西九江早籼稻报价,OfferDate:2018/10/25,price:2380,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"				{CropOfferStr:江西南昌早籼稻报价,OfferDate:2018/10/25,price:2380,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"				{CropOfferStr:湖北武汉早籼稻报价,OfferDate:2018/10/25,price:2220,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"				{CropOfferStr:福建福州早籼稻报价,OfferDate:2018/10/25,price:2700,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"				{CropOfferStr:湖南长沙中晚籼稻报价,OfferDate:2018/10/25,price:2450,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"				{CropOfferStr:湖南常德中晚籼稻报价,OfferDate:2018/10/25,price:2440,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"				{CropOfferStr:江西九江中晚籼稻报价,OfferDate:2018/10/25,price:2470,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"				{CropOfferStr:江西南昌中晚籼稻报价,OfferDate:2018/10/25,price:2480,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"				{CropOfferStr:广西桂林中晚籼稻报价,OfferDate:2018/10/25,price:2760,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"				{CropOfferStr:湖北武汉中晚籼稻报价,OfferDate:2018/10/25,price:2440,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"				{CropOfferStr:安徽合肥中晚籼稻报价,OfferDate:2018/10/25,price:2420,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"				{CropOfferStr:四川成都中晚籼稻报价,OfferDate:2018/10/25,price:2430,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"				{CropOfferStr:广东广州中晚籼稻报价,OfferDate:2018/10/25,price:2760,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"				{CropOfferStr:黑龙江佳木斯圆粒粳稻报价,OfferDate:2018/10/25,price:2580,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"				{CropOfferStr:黑龙江哈尔滨长粒粳稻报价,OfferDate:2018/10/25,price:3200,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"				{CropOfferStr:江苏南京粳稻报价,OfferDate:2018/10/25,price:2870,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"				{CropOfferStr:江苏苏州粳稻报价,OfferDate:2018/10/25,price:2880,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"				{CropOfferStr:安徽合肥粳稻报价,OfferDate:2018/10/25,price:2860,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"				{CropOfferStr:安徽巢湖粳稻报价,OfferDate:2018/10/25,price:2860,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"				{CropOfferStr:吉林长春粳稻报价,OfferDate:2018/10/25,price:2950,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"				{CropOfferStr:辽宁沈阳粳稻报价,OfferDate:2018/10/25,price:2930,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"				{CropOfferStr:辽宁盘锦粳稻报价,OfferDate:2018/10/25,price:2900,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68} " + 
				"			]," + 
				"		}" + 
				"	]," + 
				"error_code:0" + 
				"}";
		String fenlei = "{" + 
				"	reason:查询成功" + 
				"	result:[" + 
				"		{" + 
				"			daogu:[ " + 
				"				{id:1;CropCategoryName:小麦,ParentId:0}," + 
				"				{id:2;CropCategoryName:国产小麦,ParentId:1}," + 
				"				{id:3;CropCategoryName:普通小麦,ParentId:2}," + 
				"				{id:4;CropCategoryName:藁优2018,ParentId:2}," + 
				"				{id:5;CropCategoryName:郑麦366,ParentId:2}," + 
				"				{id:6;CropCategoryName:济南17,ParentId:2}," + 
				"				{id:7;CropCategoryName:进口小麦,ParentId:1}," + 
				"				{id:8;CropCategoryName:美国软红冬,ParentId:7}," + 
				"				{id:9;CropCategoryName:加麦一号,ParentId:7}," + 
				"				{id:10;CropCategoryName:加麦二号,ParentId:7}," + 
				"				{id:11;CropCategoryName:面粉,ParentId:1}," + 
				"				{id:12;CropCategoryName:小麦次粉,ParentId:1}," + 
				"				{id:13;CropCategoryName:麸皮,ParentId:1}," + 
				"				{id:14;CropCategoryName:稻米,ParentId:0}," + 
				"				{id:15;CropCategoryName:早籼稻,ParentId:14}," + 
				"				{id:16;CropCategoryName:中晚籼稻,ParentId:14}," + 
				"				{id:17;CropCategoryName:粳稻,ParentId:14}," + 
				"				{id:18;CropCategoryName:早籼米,ParentId:14}," + 
				"				{id:19;CropCategoryName:中晚籼米,ParentId:14}," + 
				"				{id:20;CropCategoryName:粳米,ParentId:14}," + 
				"				{id:21;CropCategoryName:玉米,ParentId:0}," + 
				"				{id:22;CropCategoryName:玉米,ParentId:21}," + 
				"				{id:23;CropCategoryName:玉米淀粉,ParentId:21}," + 
				"				{id:24;CropCategoryName:玉米淀粉糖,ParentId:21}," + 
				"				{id:25;CropCategoryName:玉米酒精,ParentId:21}," + 
				"				{id:26;CropCategoryName:DDGS,ParentId:21}," + 
				"				{id:27;CropCategoryName:玉米胚芽油,ParentId:21}," + 
				"				{id:28;CropCategoryName:玉米胚芽粕,ParentId:21}," + 
				"				{id:29;CropCategoryName:玉米蛋白粉,ParentId:21}," + 
				"				{id:30;CropCategoryName:玉米纤维,ParentId:21}," + 
				"				{id:31;CropCategoryName:玉米浆,ParentId:21}," + 
				"				{id:32;CropCategoryName:油料,ParentId:0}," + 
				"				{id:33;CropCategoryName:大豆,ParentId:32}," + 
				"				{id:34;CropCategoryName:国产大豆,ParentId:33}," + 
				"				{id:35;CropCategoryName:油用大豆,ParentId:34}," + 
				"				{id:36;CropCategoryName:食用大豆,ParentId:34}," + 
				"				{id:37;CropCategoryName:进口大豆,ParentId:33}," + 
				"				{id:38;CropCategoryName:蛋白豆粕,ParentId:32}," + 
				"				{id:39;CropCategoryName:油菜籽,ParentId:32}," + 
				"				{id:40;CropCategoryName:菜籽粕,ParentId:32}," + 
				"				{id:41;CropCategoryName:棉籽,ParentId:32}," + 
				"				{id:42;CropCategoryName:棉籽粕,ParentId:32}," + 
				"				{id:43;CropCategoryName:花生果,ParentId:32}," + 
				"				{id:44;CropCategoryName:花生粕,ParentId:32}," + 
				"				{id:45;CropCategoryName:油脂,ParentId:0}," + 
				"				{id:46;CropCategoryName:豆油,ParentId:45}," + 
				"				{id:47;CropCategoryName:菜籽油,ParentId:45}," + 
				"				{id:48;CropCategoryName:花生油,ParentId:45}," + 
				"				{id:49;CropCategoryName:棉籽油,ParentId:45}," + 
				"				{id:50;CropCategoryName:葵花籽油,ParentId:45}," + 
				"				{id:51;CropCategoryName:玉米油,ParentId:45}," + 
				"				{id:52;CropCategoryName:芝麻油,ParentId:45}," + 
				"				{id:53;CropCategoryName:茶籽油,ParentId:45}," + 
				"				{id:54;CropCategoryName:棕榈油,ParentId:45}," + 
				"			]," + 
				"		}" + 
				"	]," + 
				"error_code:0" + 
				"}";
		String grain = "{" + 
				"	reason:查询成功" + 
				"	result:[" + 
				"		{" + 
				"			chanliangyuce:[ " + 
				"				{chanliangyuce:2300万吨}," + 
				"			]," + 
				"			remendiqu:[ " + 
				"				{CropOfferStr:湖南长沙早籼稻报价,OfferDate:2018/10/25,price:2320,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"				{CropOfferStr:广东广州早籼稻报价,OfferDate:2018/10/25,price:2720,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"				{CropOfferStr:广西桂林早籼稻报价,OfferDate:2018/10/25,price:2700,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"				{CropOfferStr:江西九江早籼稻报价,OfferDate:2018/10/25,price:2380,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"			]," + 
				"			jinkoudami:[ " + 
				"				{CropOfferStr:上海港进口大米报价,OfferDate:2018/10/25,price:2320,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"				{CropOfferStr:天津港进口大米报价,OfferDate:2018/10/25,price:2310,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"				{CropOfferStr:天津港进口大米报价,OfferDate:2018/10/25,price:2720,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"				{CropOfferStr:天津港进口大米报价,OfferDate:2018/10/25,price:2700,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"				{CropOfferStr:天津港进口大米报价,OfferDate:2018/10/25,price:2380,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"				{CropOfferStr:天津港进口大米报价,OfferDate:2018/10/25,price:2380,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"				{CropOfferStr:天津港进口大米报价,OfferDate:2018/10/25,price:2220,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"				{CropOfferStr:天津港进口大米报价,OfferDate:2018/10/25,price:2700,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"			]," + 
				"			fenxibaogao:[ " + 
				"				{AnalysisReportName:2018年9月21日稻米市场分析报告}," + 
				"				{AnalysisReportName:2018年9月22日稻米市场分析报告}," + 
				"			]," + 
				"		}" + 
				"	]," + 
				"error_code:0" + 
				"}";
		String yumi = "{" + 
				"	reason:查询成功" + 
				"	result:[" + 
				"		{" + 
				"			chanliangyuce:[ " + 
				"				{chanliangyuce:2600万吨}," + 
				"			]," + 
				"			remendiqu:[ " + 
				"				{CropOfferStr:河北玉米报价,OfferDate:2018/10/25,price:2320,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"				{CropOfferStr:江苏玉米报价,OfferDate:2018/10/25,price:2720,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"				{CropOfferStr:黑龙江玉米报价,OfferDate:2018/10/25,price:2700,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"				{CropOfferStr:辽宁玉米报价,OfferDate:2018/10/25,price:2380,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"			]," + 
				"			jinkouyumi:[ " + 
				"				{CropOfferStr:上海港进口玉米报价,OfferDate:2018/10/25,price:2320,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"				{CropOfferStr:天津港进口玉米报价,OfferDate:2018/10/25,price:2310,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"				{CropOfferStr:天津港进口玉米报价,OfferDate:2018/10/25,price:2720,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"				{CropOfferStr:天津港进口玉米报价,OfferDate:2018/10/25,price:2700,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"				{CropOfferStr:天津港进口玉米报价,OfferDate:2018/10/25,price:2380,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"				{CropOfferStr:天津港进口玉米报价,OfferDate:2018/10/25,price:2380,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"				{CropOfferStr:天津港进口玉米报价,OfferDate:2018/10/25,price:2220,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"				{CropOfferStr:天津港进口玉米报价,OfferDate:2018/10/25,price:2700,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"			]," + 
				"			fenxibaogao:[ " + 
				"				{AnalysisReportName:2018年9月21日玉米市场分析报告}," + 
				"				{AnalysisReportName:2018年9月22日玉米市场分析报告}," + 
				"			]," + 
			    "		}" + 
				"		]," + 
				"error_code:0" + 
				"}";
		String xiaomai = "{" + 
				"	reason:查询成功" + 
				"	result:[" + 
				"		{" + 
				"			chanliangyuce:[ " + 
				"				{chanliangyuce:2620万吨}," + 
				"			]," + 
				"			remendiqu:[ " + 
				"				{CropOfferStr:河北小麦报价,OfferDate:2018/10/25,price:2320,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"				{CropOfferStr:江苏小麦报价,OfferDate:2018/10/25,price:2720,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"				{CropOfferStr:黑龙江小麦报价,OfferDate:2018/10/25,price:2700,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"				{CropOfferStr:辽宁小麦报价,OfferDate:2018/10/25,price:2380,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"			]," + 
				"			youzhixiaomai:[ " + 
				"				{CropOfferStr:上海港进口小麦报价,OfferDate:2018/10/25,price:2320,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"				{CropOfferStr:天津港进口小麦报价,OfferDate:2018/10/25,price:2310,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"				{CropOfferStr:天津港进口小麦报价,OfferDate:2018/10/25,price:2720,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"				{CropOfferStr:天津港进口小麦报价,OfferDate:2018/10/25,price:2700,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"				{CropOfferStr:天津港进口小麦报价,OfferDate:2018/10/25,price:2380,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"				{CropOfferStr:天津港进口小麦报价,OfferDate:2018/10/25,price:2380,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"				{CropOfferStr:天津港进口小麦报价,OfferDate:2018/10/25,price:2220,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"				{CropOfferStr:天津港进口小麦报价,OfferDate:2018/10/25,price:2700,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"			]," + 
				"			fenxibaogao:[ " + 
				"				{AnalysisReportName:2018年9月21日小麦市场分析报告}," + 
				"				{AnalysisReportName:2018年9月22日小麦市场分析报告}," + 
				"			]," + 
			    "		}" + 
				"		]," + 
				"error_code:0" + 
				"}";
		String dadou = "{" + 
				"	reason:查询成功" + 
				"	result:[" + 
				"		{" + 
				"			dadou:[ " + 
				"				{CropOfferStr:四川大豆报价,OfferDate:2018/10/25,price:2320,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"				{CropOfferStr:天津大豆报价,OfferDate:2018/10/25,price:2310,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"				{CropOfferStr:天津大豆报价,OfferDate:2018/10/25,price:2720,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"				{CropOfferStr:天津大豆报价,OfferDate:2018/10/25,price:2700,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"				{CropOfferStr:天津大豆报价,OfferDate:2018/10/25,price:2380,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"				{CropOfferStr:天津大豆报价,OfferDate:2018/10/25,price:2380,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"				{CropOfferStr:天津港大豆报价,OfferDate:2018/10/25,price:2220,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"				{CropOfferStr:天津港大豆报价,OfferDate:2018/10/25,price:2700,TodayTrend:+1.87%,Reason:关税增加,WeekTrend:+1.87,WeekAverage:2312，UnitName:吨/元，FiveDayTrend:+1.68}," + 
				"			]," + 
			    "		}" + 
				"		]," + 
				"error_code:0" + 
				"}";
		String baogao = "{" + 
				"	reason:查询成功" + 
				"	result:[" + 
				"		{" + 
				"			fenxibaogao:[ " + 
				"				{AnalysisReportName:2018年9月21日小麦市场分析报告}," + 
				"				{AnalysisReportName:2018年9月22日小麦市场分析报告}," + 
				"			]," + 
			    "		}" + 
				"		]," + 
				"error_code:0" + 
				"}";
		if("huoyue".equals(type)) {
			str = active;
		}
		if("daomi".equals(type)) {
			str = grain;
		}
		if("yumi".equals(type)) {
			str = yumi;
		}
		if("xiaomai".equals(type)) {
			str = xiaomai;
		}
		if("dadou".equals(type)) {
			str = dadou;
		}
		if("baogao".equals(type)) {
			str = baogao;
		}
		if("fenlei".equals(type)) {
			str = fenlei;
		}
		return str;
	}
	
	
	@RequestMapping(value = "/market/grain", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String marketGrain(HttpServletRequest request,HttpServletResponse response) {
		JSONObject json = new JSONObject();
		
		return null;
	}
	
	
	/**
	 * @param 
	 * @param response
	 * @param model
	 * @return 项目列表信息 及 查询
	 * @throws ParseException 
	 */
	@RequestMapping(value = "/project", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String projectInif(HttpServletRequest request,HttpServletResponse response, FlxoaProjectInformation flxoaProjectInformation) throws  UnsupportedEncodingException, ParseException {
		HttpServletRequest req = (HttpServletRequest) request;
		req.setCharacterEncoding("utf-8");
		String path =req.getServletPath()+req.getPathInfo();
		//获取当前登录用户的userID
		int userId = Integer.parseInt(String.valueOf(req.getSession().getAttribute("userId")));
		//获取当前登录用户的部门ID
		int deptId = Integer.parseInt(String.valueOf(req.getSession().getAttribute("departmentId")));
		//请求类型（首页请求：项目管理页请求）
		String resType=request.getParameter("resType");
		String deptIds="";
		//获取当前登录用户具有哪些权限
		if(userId!=1){			
			Map<String,List<Integer>>  mapjur = Permission.getRolePermission(userId, path);	
			//含普通员工的部门id
			deptIds =  Permission.getDepartMentIds(mapjur);	
			//不含普通员工的部门id
			//deptIds =  Permission.getDepartMentIdsNo(mapjur);
			String roles=Permission.getRolesByUserId(userId);
			System.out.println("当前用户所拥有的角色：======"+roles);
			if(roles.indexOf(",")>0){
				String [] role= roles.split(",");
				for(int i=0;i<role.length;i++){
					if("部门经理".equals(role[i])|| "领导".equals(role[i]) || "直管副总".equals(role[i])){						
						deptIds+=",";
					}
				}
				//deptIds+=",null";
			}
		}
		
		JSONArray json = new JSONArray();
		FlxoaProjectInformation project = new FlxoaProjectInformation();
		//分页
		String start = request.getParameter("start"); 
		String length = request.getParameter("length");
		
		String draw = request.getParameter("draw");
		String drawFoucs  = request.getParameter("focus");
		project.setDrawFoucs(drawFoucs);
		//首页-我的项目标志
		String myproj = request.getParameter("more");
		if(!CommonUtils.isEmpty(myproj)){
			project.setCreateUserId(userId);
		}
		if (start==""||start==null){
			start="0";
		}
		if(length==""||length==null){
			length="10";
		}
		//是否关注
		project.setFlag(request.getParameter("flag"));
		//阶段ID
		project.setProjState(request.getParameter("stateId"));
		//项目编号
		project.setProjNumber(request.getParameter("proj_number"));
		//项目名称
		project.setProjName(request.getParameter("proj_name"));
		//跟单人
		project.setProjectLeader(request.getParameter("signatory_name"));
		//项目名称
		project.setProjName(request.getParameter("proj_name"));
		//客户名称
		project.setClientName(request.getParameter("client_name"));
		//时间
		if(!CommonUtils.isEmpty(request.getParameter("projStartDate"))) {
			project.setProjStartDate(String.valueOf(DateUtils.dateToTimestamp(request.getParameter("projStartDate"))));
			System.out.println(request.getParameter("projStartDate"));
		}
		if(!CommonUtils.isEmpty(request.getParameter("projEndDate"))) {
			System.out.println(request.getParameter("projEndDate"));
			project.setProjEndDate(String.valueOf(DateUtils.dateToTimestamp(request.getParameter("projEndDate"))));
		}
		
		System.out.println("输出打印项目查询条件:===12233"+request.getParameter("proj_number"));
		
		return flxoaProjectInformationService.queryForPage(Integer.valueOf(start),Integer.valueOf(length),draw,userId,deptIds,project,myproj);
	}

	
	/**
	 * @param 項目信息導出
	 * @param response
	 * @param model
	 * @return項目信息導出
	 */
	@RequestMapping(value = "/projectExport", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String projectExport(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		HttpServletRequest req = (HttpServletRequest) request;
		String path =req.getServletPath()+req.getPathInfo();
		//获取当前登录用户的userID
		int userId = Integer.parseInt(String.valueOf(req.getSession().getAttribute("userId")));
		//获取当前登录用户的部门ID
		int deptId = Integer.parseInt(String.valueOf(req.getSession().getAttribute("departmentId")));
		//请求类型（首页请求：项目管理页请求）
		String resType=request.getParameter("resType");
		//获取当前登录用户具有哪些权限
		Map<String,List<Integer>>  mapjur = Permission.getRolePermission(userId, path);	
		String deptIds =  Permission.getDepartMentIds(mapjur);
		JSONArray json = new JSONArray();
		FlxoaProjectInformation project = new FlxoaProjectInformation();
		// 查询FlxoaProjectInformation实体列表
		List<FlxoaProjectInformation> list = flxoaProjectInformationService.queryExcel(project,userId,deptIds);
		JSONArray js = json.put(list);
		System.out.println(js);
		boolean falg = ExcelExport.excelExport(list, response);
		String result = "0";
		if (falg) {
			result = "1";
		}
		return result;
	}
	/**
	 * @param 
	 * @param response
	 * @param model
	 * @return 查看
	 */
	@RequestMapping(value = "/projectInquire", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String projectInquire(HttpServletRequest request,
			HttpServletResponse response, FlxoaProjectInformation model) {
		HttpServletRequest req = (HttpServletRequest) request;
		String path =req.getServletPath()+req.getPathInfo();
		//获取当前登录用户的userID
		int userId = Integer.parseInt(String.valueOf(req.getSession().getAttribute("userId")));
		//获取当前登录用户的部门ID
		int deptId = Integer.parseInt(String.valueOf(req.getSession().getAttribute("departmentId")));
		//请求类型（首页请求：项目管理页请求）
		String resType=request.getParameter("resType");
		//获取当前登录用户具有哪些权限
		Map<String,List<Integer>>  mapjur = Permission.getRolePermission(userId, path);	
		String deptIds =  Permission.getDepartMentIds(mapjur);
		Map<String,List<FlxoaProjectInformation>> mapList =new HashMap<String,List<FlxoaProjectInformation>>();
		JSONArray json = new JSONArray();
		//项目ID
		model.setId(Integer.valueOf(request.getParameter("id")));
		List<FlxoaProjectInformation> list = flxoaProjectInformationService.queryExcel(model,userId,deptIds);
		mapList.put("projectmessage", list);
		JSONArray jsonList = json.put(mapList);
		return json.toString();
	}

	/**	
	 * @param 取消關注
	 *            /關注
	 * @param response
	 * @param model
	 * @return 關注 取消關注
	 */
	@RequestMapping(value = "/projectFocus", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String projectFocus(HttpServletRequest request,
		HttpServletResponse response, FlxoaProjectFocus model) {
		HttpServletRequest req = (HttpServletRequest)request;
		String foucs = request.getParameter("proj_is_focus");		
		boolean flag=true;
		//0取消关注 1关注成功 2不能重复关注
		String result="0";
		if(foucs.equals("0")) {
			int userId = Integer.parseInt(String.valueOf(req.getSession().getAttribute("userId")));
			String projid = request.getParameter("id");
			FlxoaProjectFocus flxoaProjectFocus = new FlxoaProjectFocus();
			flxoaProjectFocus.setCreateUserId(userId);
			flxoaProjectFocus.setProjectId(Integer.valueOf(projid));
			List<FlxoaProjectFocus> projectFocusList = flxoaProjectFocusService.getProjectFocus(flxoaProjectFocus);
			if(projectFocusList.size() != 0){
				//如果存在不能重复关注
				result ="2";
				System.out.println("不能重复关注");
			}else{
				model.setProjectId(Integer.valueOf(projid));
				model.setFlag("1");
				flxoaProjectFocusService.add(model);
				result ="1";
				System.out.println("关注成功！");
			}
		}else {
			model.setId(Integer.valueOf(request.getParameter("focusid")));
			flxoaProjectFocusService.deleteName(model);
			result ="0";
			System.out.println("取消关注！");
		}
		System.out.print(result);				
		return result;
	}

	/**
	 * @param 根據ID刪除
	 * @param response
	 * @param model
	 * @return 根據ID刪除
	 */
	@RequestMapping(value = "/projectDelete", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String projectDelete(HttpServletRequest request,
			HttpServletResponse response, FlxoaProjectInformation model) {
		model.setId(Integer.valueOf(request.getParameter("id")));
		FlxoaProjectInformation flxoaCashcollectionRecord = flxoaProjectInformationService.queryById(model);
		boolean b = flxoaProjectInformationService.delete(flxoaCashcollectionRecord);
		String result = "0";
		if (b) {
			result = "1";
		}
		return result;
	}

	
	/**
	 * @param 
	 * @param response
	 * @param model
	 * @return 新增项目
	 */
	@RequestMapping(value = "/projectAdd", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String projectAdd(HttpServletRequest request,
			HttpServletResponse response, FlxoaProjectInformation model) {
		HttpServletRequest req = (HttpServletRequest)request;
		FlxoaProjectInformation projectadd = new FlxoaProjectInformation();
		//项目编号
		projectadd.setProjNumber("");
		//项目状态
		projectadd.setProjState("0");
		//项目开始时间
		projectadd.setProjStartTime(0);
		//项目结束时间
		projectadd.setProjEndTime(0);
		//项目对接人邮箱
		projectadd.setSignatory("");
		//项目对接人姓名
		projectadd.setSignatoryName("");
		//项目对接人电话
		projectadd.setSignatoryTelephone("");
		//阶段
		projectadd.setProjStage("0");
		projectadd.setWhetherFollow("0");
		projectadd.setPredictBidsTime(0);
		projectadd.setProjectLeader("");
		//项目名称
		projectadd.setProjName(request.getParameter("proj_name"));
		//预计合同额
		projectadd.setPredictContractMoney(request.getParameter("proj_money"));
		//跟单人
		projectadd.setWhetherFollow(request.getParameter("whether_follow"));
		//项目属性
		projectadd.setProjAttribute(request.getParameter("proj_attribute"));
		//业务类型
		projectadd.setBusClassification(request.getParameter("proj_classification"));
		//设计单位
		projectadd.setDesignCompany(request.getParameter("proj_company"));
		//客户名称
		projectadd.setClientName(request.getParameter("proj_client_name"));
		projectadd.setDeleteFlag("0");
		String result = "0";
		//验证项目名称不能重复
		boolean username = flxoaProjectInformationService.isExist(request.getParameter("proj_name"));
		if(username) {
			boolean b = flxoaProjectInformationService.add(projectadd);
			if (b) { 
				result = "1";
			}
		}
		if(username == false) {
			result = "2";
		}
		return result;
	}
	
	/**
	 * @param  
	 * @param response
	 * @param model
	 * @return 修改 根据状态修改  立项后不能修改
	 */
	@RequestMapping(value = "/projectAddedupdata", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String projectAddedupdata(HttpServletRequest request,
			HttpServletResponse response, FlxoaProjectInformation model) {
		HttpServletRequest req = (HttpServletRequest)request;
		model.setId(Integer.valueOf(request.getParameter("id")));
		FlxoaProjectInformation flxoaProjectInformation = flxoaProjectInformationService.queryById(model);
		//项目名称
		flxoaProjectInformation.setProjName(request.getParameter("proj_name"));
		//预计合同额
		flxoaProjectInformation.setPredictContractMoney(request.getParameter("proj_money"));
		//项目属性
		flxoaProjectInformation.setProjAttribute(request.getParameter("proj_attribute"));
		//业务类型
		flxoaProjectInformation.setBusClassification(request.getParameter("proj_classification"));
		//设计单位
		flxoaProjectInformation.setDesignCompany(request.getParameter("proj_company"));
		//客户名称
		flxoaProjectInformation.setClientName(request.getParameter("proj_client_name"));
		System.out.println(request.getParameter("proj_client_name"));
		boolean b = flxoaProjectInformationService.update(flxoaProjectInformation);
		String result = "0";
		if(b){
			result = "1";
		}
		return result;
	}
	/**
	 * （手机端项目搜索）
	 */
	@ResponseBody
	@RequestMapping(value = "/appProjectSearch",produces="text/html;charset=UTF-8")
	public String showProject(HttpServletRequest request,HttpServletResponse response,ModelMap model){		
		String start = request.getParameter("start"); 
		String length = request.getParameter("length");
		String draw = request.getParameter("draw");
		if (start==""||start==null){
			start="0";
		}
		if(length==""||length==null){
			length="100";
		}
		//搜索条件
		String searchInfo = request.getParameter("searchInfo");			
		
		return flxoaProjectInformationService.queryProject(Integer.valueOf(start),Integer.valueOf(length),draw,searchInfo);

	}
}
