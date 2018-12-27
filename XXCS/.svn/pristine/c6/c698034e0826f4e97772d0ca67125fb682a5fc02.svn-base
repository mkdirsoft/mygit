package com.flx.flxoa.common.util;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RRHeadSeting {

	/***
	 * @description 设置响应头
	 * @author sunjin
	 * @date 2018-9-4
	 * */
	public static Map<String,Object> setHeading(HttpServletRequest request,HttpServletResponse response)throws UnsupportedEncodingException,ParseException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/json; charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "");
		response.setHeader("Access-Control-Allow-Headers", "X-Requested-With");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Access-Control-Allow-Origin", "*");
		String path=request.getServletPath()+request.getPathInfo();
		int userId=Integer.parseInt(String.valueOf(request.getSession().getAttribute("userId")));
		int deptId=Integer.parseInt(String.valueOf(request.getSession().getAttribute("departmentId")));
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("request", request);
		map.put("response", response);
		map.put("path", path);
		map.put("userId", userId);
		map.put("deptId", deptId);
		return map;
	}
}
