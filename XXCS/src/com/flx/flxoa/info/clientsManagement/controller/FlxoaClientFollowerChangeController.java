package com.flx.flxoa.info.clientsManagement.controller;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flx.flxoa.common.util.CommonUtils;
import com.flx.flxoa.common.util.RRHeadSeting;
import com.flx.flxoa.info.clientsManagement.manager.FlxoaClientFollowerChangeService;

@Controller
public class FlxoaClientFollowerChangeController {

	protected FlxoaClientFollowerChangeService clientFollowerChangeService;
	@Autowired
	public void getFollowerChangeService(FlxoaClientFollowerChangeService clientFollowerChangeService){
		this.clientFollowerChangeService=clientFollowerChangeService;
	}
	
	@RequestMapping("/clientfollowerchange")
	public String followerChange(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		return "/nk/pages/clientsManage/followerChangeManage";
	}
	/**
	 * @description 获取所有跟单人（销售）信息json数据
	 * */
	@RequestMapping("/getfollowers")
	@ResponseBody
	public String getFollowers(HttpServletRequest request,HttpServletResponse response)throws UnsupportedEncodingException,ParseException{
		/*设置请求响应字符格式*/
		Map<String,Object> headMap=RRHeadSeting.setHeading(request, response);
		request=(HttpServletRequest) headMap.get("request");
		response=(HttpServletResponse) headMap.get("response");
		
		/*获取分页参数*/
		String draw=request.getParameter("draw");
		String start=request.getParameter("start");
		String length=request.getParameter("length");
		if(start==""||start==null){
			start="0";
		}
		if(length==""||length==null){
			length="10";
		}
		String keyIn=request.getParameter("name_startsWith");
		System.out.println("keyIn:====="+keyIn);
		/*
		String preFollower=request.getParameter("pre_follower");
		String afterFollower=request.getParameter("after_follower");*/
		
		/**
		 * 需求分析：1、需要查询的是客户信息列表，是根据跟单人id来查找客户信息列表，跟单人id应该是从前台入例框中传入的数据，
		 * 而前台如理框需要所有跟单人（销售的）信息，所以在该方法中需要获取所有用户角色为“跟单人（销售）”的用户信息列表，返回给跟单人入例框
		 * 
		 * 获取所有角色为“销售人员”的用户信息
		 * */
		Map<String,String> map=new HashMap<String,String>();
		map.put("draw", draw);
		map.put("start", start);
		map.put("length", length);
		map.put("keyIn", keyIn);
		/*map.put("pre_follower", preFollower);
		map.put("after_follower", afterFollower);*/
		System.out.println("start:==="+start);
		System.out.println("map.getStart:===="+map.get("start"));
		return clientFollowerChangeService.queryForPage(map);
	}
	
}
