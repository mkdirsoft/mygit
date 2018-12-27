package com.flx.flxoa.info.approve.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.flx.flxoa.common.util.FileUtils;
import com.flx.flxoa.info.approve.entity.FlxoaApproveFormtemplate;
import com.flx.flxoa.info.approve.manager.FlxoaApproveFormtemplateService;
import com.flx.flxoa.info.system.entity.FlxoaAccessory;

/**
 * 类名称：FlxoaApproveFormtemplate.java
 * 类描述：
 * 创建时间：2018-3-18, 下午2:21:29
 * 
 * @version 1.0 
 * @since JDK版本 1.7
 * @author 刘凯 
 */
@Controller
public class FlxoaApproveFormtemplateController {

	protected FlxoaApproveFormtemplateService flxoaApproveFormtemplateService;

	@Autowired
	public void setSystemFuncationService(FlxoaApproveFormtemplateService flxoaApproveFormtemplateService) {
		this.flxoaApproveFormtemplateService = flxoaApproveFormtemplateService;
	}
	
	//去申请表静态页
	@RequestMapping(value = "/formtemplate/golist")
	public String goList(HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		return "nk/pages/approval/formtemplate";
	}
	
	//获取申请表listjson
	@RequestMapping(value = "/formtemplate/getlist",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getList(HttpServletRequest request,HttpServletResponse response, FlxoaApproveFormtemplate model) throws UnsupportedEncodingException {
		List<FlxoaApproveFormtemplate> list = flxoaApproveFormtemplateService.query(model);
		JSONArray json = JSONArray.fromObject(list);
		return json.toString();
	}
	
	//根据id 获取申请表beanJson
	@RequestMapping(value = "/formtemplate/getbyid",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getById(HttpServletRequest request,HttpServletResponse response,FlxoaApproveFormtemplate model) throws UnsupportedEncodingException {
		FlxoaApproveFormtemplate flxoaApproveFormtemplate = flxoaApproveFormtemplateService.queryById(model);
		JSONObject json = JSONObject.fromObject(flxoaApproveFormtemplate);
		return json.toString();
	}
	
	//添加申请表
	@RequestMapping(value = "/formtemplate/add",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String add(HttpServletRequest request,HttpServletResponse response, FlxoaApproveFormtemplate model) throws UnsupportedEncodingException {
		boolean flag = flxoaApproveFormtemplateService.add(model);
		String result="0";
		if (flag) {
			result = "1";
		}
		return result;
	}
	
	//更新申请表
	@RequestMapping(value = "/formtemplate/update",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String update(HttpServletRequest request,HttpServletResponse response,FlxoaApproveFormtemplate model) throws UnsupportedEncodingException {
		FlxoaApproveFormtemplate flxoaApproveFormtemplate = flxoaApproveFormtemplateService.queryById(model);
		flxoaApproveFormtemplate.setLayout(model.getLayout());
		flxoaApproveFormtemplate.setName(model.getName());
		boolean flag = flxoaApproveFormtemplateService.update(flxoaApproveFormtemplate);
		//0失败 1成功
		String result="0";
		if (flag) {
			result = "1";
		}
		return result;
	}
	
	//删除申请表
	@RequestMapping(value = "/formtemplate/delete",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String delete(HttpServletRequest request,HttpServletResponse response,FlxoaApproveFormtemplate model) throws UnsupportedEncodingException {
		FlxoaApproveFormtemplate flxoaApproveFormtemplate = flxoaApproveFormtemplateService.queryById(model);
		boolean flag = flxoaApproveFormtemplateService.delete(flxoaApproveFormtemplate);
		//0失败 1成功
		String result="0";
		if (flag) {
			result = "1";
		}
		return result;
	}
	
	//文件上传
	@RequestMapping(value = "/formtemplate/fileupload")
	@ResponseBody
	public String fileUpload(HttpServletRequest request,HttpServletResponse response,FlxoaApproveFormtemplate model) throws UnsupportedEncodingException {
		List<FlxoaAccessory> list = FileUtils.fileUpload("approve", request);
		JSONArray json = JSONArray.fromObject(list);
		return URLEncoder.encode(json.toString(), "utf-8");
	}
	
	//文件下载
	@RequestMapping(value = "/formtemplate/filedownload")
	public String fileDownload(HttpServletRequest request,HttpServletResponse response,FlxoaApproveFormtemplate model) throws UnsupportedEncodingException {
		String fileRealName = request.getParameter("fileRealName");
		FileUtils.downLoadFile(fileRealName, "approve", request, response);
		return null;
	}
	 
}
