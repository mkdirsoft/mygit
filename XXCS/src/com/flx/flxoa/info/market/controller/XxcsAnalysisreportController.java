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

import com.flx.flxoa.info.market.entity.HxAnalysisreport;
import com.flx.flxoa.info.market.entity.HxCropoffer;
import com.flx.flxoa.info.market.manager.HxAnalysisreportService;
import com.flx.flxoa.info.market.manager.HxCropofferService;

@Controller
public class XxcsAnalysisreportController {
	
protected HxAnalysisreportService hxAnalysisreportService;
	
	@Autowired
	public void setHxAnalysisreportService(
			HxAnalysisreportService hxAnalysisreportService) {
		this.hxAnalysisreportService = hxAnalysisreportService;
	}
	
	/**
	 *分析报告
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/AnalysisReport", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String analysisReport(HttpServletRequest request,HttpServletResponse response) {
		HxAnalysisreport hxAnalysisreport = new HxAnalysisreport();
		String CropCategoryCode = request.getParameter("CropCategoryCode");
		String ReportDateStart = request.getParameter("ReportDateStart");
		//将前台请求参数统一放入map中
		Map<String,String> map  = new HashMap<>();
		map.put("CropCategoryCode", CropCategoryCode);
		map.put("ReportDateStart", ReportDateStart);
		return  hxAnalysisreportService.queryForPage(map);
	}
	
	
	
	
	
}
