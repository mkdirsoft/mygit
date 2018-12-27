package com.flx.flxoa.info.market.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flx.flxoa.info.market.entity.HxCropoffer;
import com.flx.flxoa.info.market.manager.HxCropofferService;
import com.flx.flxoa.info.projectmanagement.entity.FlxoaProjectBidRecord;


@Controller
public class XxcsMarketController {
	protected HxCropofferService cropOfferService;
	
	
	@Autowired
	public void setHxCropofferService(
			HxCropofferService cropOfferService) {
		this.cropOfferService = cropOfferService;
	}
	
	 @RequestMapping(value = "/err2or",produces = "text/html;charset=UTF-8")
	    public void test(){
	       int b=10/0;
	        System.out.println(b);
	    }
	
	@RequestMapping(value = "/CropOffer", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String market(HttpServletRequest request,HttpServletResponse response) {
		String start = request.getParameter("PageNum"); 
		String length = request.getParameter("PerPageNum");
		if (start==""||start==null){
			start="0";
		}
		if(length==""||length==null){
			length="10";
		}
		
		//地区id
		String RegionCode =request.getParameter("RegionCode");
		//作物品类id
		String CropCategoryCode =request.getParameter("CropCategoryCode");
		//作物来源id
		String CropSourceCode =request.getParameter("CropSourceCode");
		String ParentID =request.getParameter("ParentID");
		//报价开始日期（格式为20181030）
		String OfferDateStart =request.getParameter("OfferDateStart");
		//报价结束日期
		String OfferDateEnd =request.getParameter("OfferDateEnd");
		//0,日期倒序1，今日趋势倒序2，今日趋势正序3，今日趋势绝对值倒4，今日趋势绝对值正序
		String SortType =request.getParameter("SortType");
		//品类标识 0 大品类  1 小品类
		String iscropcategory =request.getParameter("iscropcategory");
		//活跃市场标识
		String huoyue =request.getParameter("huoyue");
		//每页条数
		String PerPageNum =start;
		//页码
		String PageNum =length;
		//将前台请求参数统一放入map中
		Map<String,String> map  = new HashMap<>();
		map.put("RegionCode", RegionCode);
		map.put("CropCategoryCode", CropCategoryCode);
		map.put("CropSourceCode", CropSourceCode);
		map.put("OfferDateStart", OfferDateStart);
		map.put("OfferDateEnd", OfferDateEnd);
		map.put("SortType", SortType);
		map.put("iscropcategory", iscropcategory);
		map.put("huoyue", huoyue);
		map.put("length", PageNum);
		map.put("start", PerPageNum);
		map.put("ParentID", ParentID);
		
		
		return cropOfferService.queryForPage(map);
	}
	/**
	 * 轮播
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/CropOfferBroadcast", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String marketBroadcast(HttpServletRequest request,HttpServletResponse response) {
		HttpServletRequest req = (HttpServletRequest)request;
		//用户ID
		String UserID =request.getParameter("tokenid");
		//将前台请求参数统一放入map中
		Map<String,String> map  = new HashMap<>();
		map.put("UserID", UserID);
		JSONArray json = new JSONArray();
		return cropOfferService.queryWheel(map);
	}
	
	/**
	 * 走势图数据
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/CropOfferIcon", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String marketIcon(HttpServletRequest request,HttpServletResponse response) {
		//作物品类id
		String listChart = request.getParameter("listChart");
		String CropCategoryCode= request.getParameter("CropCategoryCode");
		//地区id
		String regionList = request.getParameter("regionList");
		//时间区间
		String OfferDateStart =request.getParameter("OfferDateStart");
		String OfferDateEnd =request.getParameter("OfferDateEnd");
		//将前台请求参数统一放入map中
		Map<String,String> map  = new HashMap<>();
		map.put("listChart", listChart);
		map.put("regionList", regionList);
		map.put("OfferDateStart", OfferDateStart);
		map.put("OfferDateEnd", OfferDateEnd);
		map.put("CropCategoryCode", CropCategoryCode);
		return cropOfferService.queryForPageIcon(map);
	}
	
}
