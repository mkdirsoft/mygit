package com.flx.flxoa.info.market.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flx.flxoa.info.market.manager.HxNewsService;

@Controller
public class XxcsNewsController {
	protected HxNewsService hxNewsService;
	@Autowired
	public void setHxNewsService(
			HxNewsService hxNewsService) {
		this.hxNewsService = hxNewsService;
	}
	
	
	@RequestMapping(value = "/News", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String News(HttpServletRequest request,HttpServletResponse response) {
		HttpServletRequest req = (HttpServletRequest)request;
		String start = request.getParameter("PageNum"); 
		String length = request.getParameter("PerPageNum");
		if (start==""||start==null){
			start="0";
		}
		if(length==""||length==null){
			length="100";
		}
		//请求类型 1：返回当前这个人的所有关注的来源的所有资讯
		String Type = request.getParameter("Type");
		//新闻id
		String NewsID =request.getParameter("NewsID");
		//新闻分类id
		String NewsCategoryID =request.getParameter("NewsCategoryID");
		//来源id
		String SourceCode =request.getParameter("SourceCode");
		String UserID =request.getParameter("tokenid");
		//每页条数
		String PerPageNum =start;
		//页码
		String PageNum =length;
		//将前台请求参数统一放入map中
		Map<String,String> map  = new HashMap<>();
		map.put("NewsID", NewsID);
		map.put("NewsCategoryID", NewsCategoryID);
		map.put("SourceCode", SourceCode);
		map.put("length", PageNum);
		map.put("start", PerPageNum);
		map.put("Type", Type);
		map.put("UserID", UserID);
		return hxNewsService.queryForPage(map);
	}
	

}