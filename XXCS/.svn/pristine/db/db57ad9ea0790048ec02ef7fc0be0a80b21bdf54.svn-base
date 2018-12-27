package com.flx.flxoa.info.feeManagement.controller;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FeeManageController {

	@RequestMapping("/projfeelist")
	public String projFeeList(HttpServletRequest request,HttpServletResponse response){
		return "nk/pages/feeManage/projectFeeManage";
	}
	@RequestMapping("/deptfeelist")
	public String deptFeeList(HttpServletRequest request,HttpServletResponse response){
		return "nk/pages/feeManage/departmentFeeManage";
	}
	@RequestMapping("/queryprojfees")
	@ResponseBody
	public String queryProjFees(HttpServletRequest request,HttpServletResponse response)throws UnsupportedEncodingException,ParseException{
		
		
		return "";
	}
}
