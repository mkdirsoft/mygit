package com.flx.flxoa.info.system.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flx.flxoa.common.util.DateUtils;
import com.flx.flxoa.info.system.entity.FlxoaApproveWorkflow;
import com.flx.flxoa.info.system.manager.FlxoaApproveWorkflowService;

/**
 * 类名称：FlxoaApproveWorkflowController.java
 * 类描述：
 * 创建时间：2018-3-18, 下午2:21:29
 * 
 * @version 1.0 
 * @since JDK版本 1.7
 * @author 刘凯 
 */
@Controller
public class FlxoaApproveWorkflowController {

	protected FlxoaApproveWorkflowService flxoaApproveWorkflowService;

	@Autowired
	public void setFlxoaApproveWorkflowService(FlxoaApproveWorkflowService flxoaApproveWorkflowService) {
		this.flxoaApproveWorkflowService = flxoaApproveWorkflowService;
	}
	
	@RequestMapping(value = "/workflow/golist")
	public String goList(HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		
		return "nk/pages/system/workflow";
	}
	
	@RequestMapping(value = "/workflow/getlist",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getList(HttpServletRequest request,HttpServletResponse response, FlxoaApproveWorkflow flxoaApproveWorkflow) throws UnsupportedEncodingException {
		List<FlxoaApproveWorkflow> list = flxoaApproveWorkflowService.query(flxoaApproveWorkflow);
		JSONArray json = JSONArray.fromObject(list);
		return json.toString();
	}
	
	@RequestMapping(value = "/workflow/getbyid",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getById(HttpServletRequest request,HttpServletResponse response,FlxoaApproveWorkflow model) throws UnsupportedEncodingException {
		FlxoaApproveWorkflow flxoaApproveWorkflow = flxoaApproveWorkflowService.queryById(model);
		JSONObject json = JSONObject.fromObject(flxoaApproveWorkflow);
		return json.toString();
	}
	
	@RequestMapping(value = "/workflow/add",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String add(HttpServletRequest request,HttpServletResponse response, FlxoaApproveWorkflow model) throws UnsupportedEncodingException {
		int nowTime = DateUtils.getSecondTimestamp(new Date());
		//工作流默认使用 飞利信
		model.setCompanyId(1);
		model.setDepartmentId(1);
//		//未删除 0  已删除1
//		model.setDeleteFlag("0");
//		//创建用户id
//		model.setCreateUserId(1);
//		model.setCreateTime(nowTime);
//		//创建用户部门id
//		model.setCreateDepartmentId(1);
//		//更新用户id
//		model.setUpdateUserId(1);
//		model.setUpdateTime(nowTime);
//		//更新用户部门id
//		model.setUpdateDepartmentId(1);
		boolean flag = flxoaApproveWorkflowService.add(model);
		String result="0";
		if (flag) {
			result = "1";
		}
		return result;
	}
	
	@RequestMapping(value = "/workflow/update",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String update(HttpServletRequest request,HttpServletResponse response,FlxoaApproveWorkflow model) throws UnsupportedEncodingException {
		FlxoaApproveWorkflow flxoaApproveWorkflow = flxoaApproveWorkflowService.queryById(model);
		//更新工作流名称
		flxoaApproveWorkflow.setWorkflowName(model.getWorkflowName());
		//更新工作流信息
		flxoaApproveWorkflow.setWorkflowJson(model.getWorkflowJson());
//		//更新用户id
//		flxoaApproveWorkflow.setUpdateUserId(1);
//		flxoaApproveWorkflow.setUpdateTime(DateUtils.getSecondTimestamp(new Date()));
//		//更新用户部门id
//		flxoaApproveWorkflow.setUpdateDepartmentId(1);
		boolean flag = flxoaApproveWorkflowService.update(flxoaApproveWorkflow);
		//0失败 1成功
		String result="0";
		if (flag) {
			result = "1";
		}
		return result;
	}
	
	@RequestMapping(value = "/workflow/delete",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String delete(HttpServletRequest request,HttpServletResponse response,FlxoaApproveWorkflow model) throws UnsupportedEncodingException {
		FlxoaApproveWorkflow flxoaApproveWorkflow = flxoaApproveWorkflowService.queryById(model);
//		//更新用户id
//		flxoaApproveWorkflow.setUpdateUserId(1);
//		flxoaApproveWorkflow.setUpdateTime(DateUtils.getSecondTimestamp(new Date()));
//		//更新用户部门id
//		flxoaApproveWorkflow.setUpdateDepartmentId(1);
		boolean flag = flxoaApproveWorkflowService.delete(flxoaApproveWorkflow);
		//0失败 1成功
		String result="0";
		if (flag) {
			result = "1";
		}
		return result;
	}
	 
}
