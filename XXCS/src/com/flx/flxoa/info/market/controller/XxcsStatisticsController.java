package com.flx.flxoa.info.market.controller;

import java.io.UnsupportedEncodingException;
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
import com.flx.flxoa.info.market.entity.HxStatisticsdata;
import com.flx.flxoa.info.market.manager.HxStatisticsdataService;


@Controller
public class XxcsStatisticsController {
	protected HxStatisticsdataService hxStatisticsdataService;
	
	
	@Autowired
	public void setHxStatisticsdataService(
			HxStatisticsdataService hxStatisticsdataService) {
		this.hxStatisticsdataService = hxStatisticsdataService;
	}
	
	@RequestMapping(value = "/StatisticsData", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String marketStatisticsData(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException  {
		HxStatisticsdata hxStatisticsdata = new HxStatisticsdata();
		//地区id
		String RegionCode =request.getParameter("RegionCode");
		//作物品类id
		String CropCategoryCode =request.getParameter("CropCategoryCode");
		//报价开始日期（格式为20181030）
		String OfferDateStart =request.getParameter("OfferDateStart");
		//报价结束日期
		String OfferDateEnd =request.getParameter("OfferDateEnd");
		//0,日期倒序1，今日趋势倒序2，今日趋势正序3，今日趋势绝对值倒4，今日趋势绝对值正序
		String SortType =request.getParameter("SortType");
		//统计类型
		String OfferType =request.getParameter("OfferType");
		//将前台请求参数统一放入map中
		Map<String,String> map  = new HashMap<>();
		map.put("RegionCode", RegionCode);
		map.put("CropCategoryCode", CropCategoryCode);
		map.put("OfferDateStart", OfferDateStart);
		map.put("OfferDateEnd", OfferDateEnd);
		map.put("SortType", SortType);
		map.put("OfferType", OfferType);
		return hxStatisticsdataService.queryForPage(map);
	}
	/**
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	
	@RequestMapping(value = "/StatisticsDataActive", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String StatisticsDataActive(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException  {
		HxStatisticsdata hxStatisticsdata = new HxStatisticsdata();
		//用户ID
		String userID = request.getParameter("tokenid");
		JSONArray json = new JSONArray();
		//将前台请求参数统一放入map中
		List<HxStatisticsdata> list = hxStatisticsdataService.query(null);
		JSONArray jsonList = json.put(list);
		return json.toString();
	}
	
	
}
