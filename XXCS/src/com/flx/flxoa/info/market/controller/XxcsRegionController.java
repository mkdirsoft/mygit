package com.flx.flxoa.info.market.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flx.flxoa.info.market.entity.HxCropcategory;
import com.flx.flxoa.info.market.entity.HxRegion;
import com.flx.flxoa.info.market.manager.HxRegionService;

import net.sf.json.JSONArray;

@Controller
public class XxcsRegionController {
	protected HxRegionService hxRegionService;
	
	
	@Autowired
	public void setHxRegionService(
			HxRegionService hxRegionService) {
		this.hxRegionService = hxRegionService;
	}
	
	
	@RequestMapping(value = "/Region", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String marketRegion(HttpServletRequest request,HttpServletResponse response ,HxCropcategory model) throws UnsupportedEncodingException  {
		HxRegion hxRegion = new HxRegion();
		//地区ID（暂时没用）
		String regionCode = request.getParameter("RegionCode");
		//查询地区信息
		List<HxRegion> list = hxRegionService.query(null);
		JSONArray jsonArray = JSONArray.fromObject(list);  
		System.out.println(list);
		return jsonArray.toString();
	}
	
	
	
}
