/**
 * 
 */
package com.flx.flxoa.info.cashcollection.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.flx.flxoa.common.util.CommonUtils;
import com.flx.flxoa.common.util.DateUtils;
import com.flx.flxoa.common.util.FileUtils;
import com.flx.flxoa.info.cashcollection.entity.FlxoaProjectInvoice;
import com.flx.flxoa.info.cashcollection.entity.FlxoaProjectInvoiceCheck;
import com.flx.flxoa.info.cashcollection.manager.FlxoaProjectInvoiceCheckService;
import com.flx.flxoa.info.cashcollection.manager.FlxoaProjectInvoiceService;
import com.flx.flxoa.info.system.comon.Permission;
import com.flx.flxoa.info.system.entity.FlxoaAccessory;
import com.flx.flxoa.info.system.manager.FlxoaAccessoryService;

/**
 * @author 赵鹏辉
 * @date 2018-3-16 下午1:38:57
 * 描述：发票
 */
@Controller
public class FlxoaProjectInvoiceController {
	protected FlxoaProjectInvoiceService flxoaProjectInvoiceService;
	protected FlxoaProjectInvoiceCheckService flxoaProjectInvoiceCheckService;
	protected FlxoaAccessoryService flxoaAccessoryService;
	
	@Autowired
	public void setCashcollectionRecordService(FlxoaProjectInvoiceService flxoaProjectInvoiceService) {
		this.flxoaProjectInvoiceService = flxoaProjectInvoiceService;
	}
	@Autowired
	public void setFlxoaProjectInvoiceCheckService(FlxoaProjectInvoiceCheckService flxoaProjectInvoiceCheckService) {
		this.flxoaProjectInvoiceCheckService = flxoaProjectInvoiceCheckService;
	}
	@Autowired
	public void setFlxoaAccessoryService(FlxoaAccessoryService flxoaAccessoryService) {
		this.flxoaAccessoryService = flxoaAccessoryService;
	}
	
	/**
	 * 列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/invoice/list")
	public String list(HttpServletRequest request,HttpServletResponse response ){
		return "/nk/pages/cashCollection/invoice";
	}
	
	/**
	 * 查询
	 * @param modelAndView
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/invoice/queryforlist",produces="text/html;charset=UTF-8")
	public String  queryForList(ModelAndView modelAndView,HttpServletRequest request,HttpServletResponse response){
		String start = request.getParameter("start"); 
		String length = request.getParameter("length");
		String draw = request.getParameter("draw");
		if (start==""||start==null){
			start="0";
		}
		if(length==""||length==null){
			length="10";
		}

		String path = request.getServletPath()+request.getPathInfo();
		int userId = Integer.parseInt(String.valueOf(request.getSession().getAttribute("userId")));
		String deptIds=Permission.getPermissionDepartMentIds(userId, path,true);
		String createStartDate=request.getParameter("createStartDate");
		String createEndDate=request.getParameter("createEndDate");
		String invoiceType=request.getParameter("invoiceType");
		String companyName=request.getParameter("companyName");
		String projNumber=request.getParameter("projNumber");
		String projName=request.getParameter("projName");
		String createUserName=request.getParameter("createUserName");
		String deptId=request.getParameter("deptId");
		String accessoryStatus=request.getParameter("accessoryStatus");
		String startTime="";
		String endTime="";
		//时间
		if(!CommonUtils.isEmpty(createStartDate)) {
			startTime = String.valueOf(DateUtils.dateToTimestamp(request.getParameter("createStartDate")));
			System.out.println(request.getParameter("createStartDate"));
		}
		if(!CommonUtils.isEmpty(createEndDate)) {
			System.out.println(request.getParameter("createEndDate"));
			endTime = String.valueOf(DateUtils.dateToTimestamp(request.getParameter("createEndDate")));
		}
		String deptWhere="";
		int m=1;
		if(CommonUtils.isEmpty(deptId)){
			if(CommonUtils.isEmpty(deptIds)){
				deptWhere=" sysUser.department_id='0' ";
			}else{
				String[] strs=deptIds.split(",");
				deptWhere=" sysUser.department_id in(";
				for(int i=0;i<strs.length;i++){
					deptWhere+=strs[i];
					if(i!=m*500&&i!=strs.length-1){
						deptWhere+=",";
					}
					if(i==m*500&&i!=strs.length-1){
						deptWhere+=") or sysUser.department_id in(";
						m+=1;
					}
					if(i==strs.length-1){
						deptWhere+=") ";
					}
				}
			}
		}else{
			String[] deptIds1=deptIds.split(",");
			String[] deptIds2=deptId.split(",");
			List list=new ArrayList();
			for(int i=0;i<deptIds2.length;i++){
				for(int j=0;j<deptIds1.length;j++){
					if(deptIds2[i].equals(deptIds1[j])){
						list.add(deptIds2[i]);
					}
				}
			}
			if(list.size()>0){
				deptWhere=" sysUser.department_id in(";
				for(int i=0;i<list.size();i++){
					deptWhere+=list.get(i);
					if(i!=m*500&&i!=list.size()-1){
						deptWhere+=",";
					}
					if(i==m*500&&i!=list.size()-1){
						deptWhere+=") or sysUser.department_id in(";
						m+=1;
					}
					if(i==list.size()-1){
						deptWhere+=") ";
					}
				}
			}else{
				deptWhere=" sysUser.department_id='0' ";
			}
		}
		
		Map<String,String> map=new HashMap<String,String>();
		map.put("invoiceType", invoiceType);
		map.put("companyName", companyName);
		map.put("projName", projName);
		map.put("projNumber", projNumber);
		map.put("startTime", startTime);
		map.put("endTime", endTime);
		map.put("deptWhere", deptWhere);
		map.put("createUserName", createUserName);
		map.put("accessoryStatus", accessoryStatus);
		map.put("start", start);
		map.put("length", length);
		map.put("draw", draw);
		
		return flxoaProjectInvoiceService.queryForPage(map);
	}
	
	/**
	 * 审核
	 * @param request
	 * @param response
	 * @param flxoaProjectInvoiceCheck
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@ResponseBody
	@RequestMapping(value = "/invoice/shenhe",produces="text/html;charset=UTF-8")
	public String shenhe(HttpServletRequest request,HttpServletResponse response, FlxoaProjectInvoiceCheck flxoaProjectInvoiceCheck) throws UnsupportedEncodingException {
		String result="0";
		String invoiceManagerId = request.getParameter("invoiceManagerId");
		//发票审核记录表ID
		String invoiceCheckId = request.getParameter("invoiceCheckId");
		//通过未通过原因
		String remark=request.getParameter("remark");
		//审核未审核标记
		String isReceive=request.getParameter("isReceive");
		if(!CommonUtils.isEmpty(invoiceManagerId)){
			//根据发票管理表ID查询   为true增加一条数据  为false是修改数据
			boolean invoice = flxoaProjectInvoiceCheckService.isExist(request.getParameter("invoiceManagerId"));
			if(invoice) {
				flxoaProjectInvoiceCheck.setInvoiceManagerId(Integer.valueOf(invoiceManagerId));
				flxoaProjectInvoiceCheck.setRemark(remark);
				flxoaProjectInvoiceCheck.setIsReceive(isReceive);
				boolean flag = flxoaProjectInvoiceCheckService.add(flxoaProjectInvoiceCheck);
				if (flag) {
					result = "1";
				}
			}else { 
				//先根据flxoaProjectInvoiceCheck中ID查询在修改
				FlxoaProjectInvoiceCheck flxoaProjectInvoiceCheckUpdata = new FlxoaProjectInvoiceCheck();
				flxoaProjectInvoiceCheckUpdata.setId(Integer.parseInt(invoiceCheckId));
				FlxoaProjectInvoiceCheck FlxoaProjectInvoiceChecks = flxoaProjectInvoiceCheckService.queryById(flxoaProjectInvoiceCheckUpdata);
				FlxoaProjectInvoiceChecks.setRemark(request.getParameter("remark"));
				
				FlxoaProjectInvoiceChecks.setIsReceive(isReceive);
				boolean flag = flxoaProjectInvoiceCheckService.update(FlxoaProjectInvoiceChecks);
				if (flag) {
					result = "1";
				}
			}
			
		}
		return result;
	}
	/**
	 * 附件上传
	 * @param request
	 * @param response
	 * @param flxoaProjectInvoiceCheck
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@ResponseBody
	@RequestMapping(value = "/invoice/fujianupload",produces="text/html;charset=UTF-8")
	public String fujianUpload(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		FlxoaProjectInvoice flxoaProjectInvoice = new FlxoaProjectInvoice();
		String result="0";
		String invoiceManagerId=request.getParameter("invoiceManagerId");
		//发票管理上传附件时-改变发票管理信息表附件状态
		flxoaProjectInvoice.setId(Integer.valueOf(invoiceManagerId));
		//根据ID查询
		FlxoaProjectInvoice flxoaProjectInvoices = flxoaProjectInvoiceService.queryById(flxoaProjectInvoice);
		flxoaProjectInvoices.setAccessoryStatus("1");
		//根据ID修改状态
		boolean flxoaProjectInvoicesUpdata = flxoaProjectInvoiceService.update(flxoaProjectInvoices);
		if(!CommonUtils.isEmpty(invoiceManagerId)){
			String dirName="invoice";
			String accessorySource="invoice";
			List<FlxoaAccessory> list=FileUtils.fileUpload(dirName, request);
			boolean flag=false;
			for(int i=0;i<list.size();i++){
				FlxoaAccessory flxoaAccessory=list.get(i);
				flxoaAccessory.setAccessorySource(accessorySource);
				flxoaAccessory.setSourceId(Integer.valueOf(invoiceManagerId));
				flag=flxoaAccessoryService.add(flxoaAccessory);
			}
			if (flag) {
				result = "1";
			}
		}
		return result;
	}
	
	/**
	 * 附件下载
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@ResponseBody
	@RequestMapping(value = "/invoice/fujiandownload",produces="text/html;charset=UTF-8")
	public String fujianDownload(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		String result="0";
		String dirName="invoice";
		String fileRealName=request.getParameter("fileRealName");
		if(!CommonUtils.isEmpty(fileRealName)){
			FileUtils.downLoadFile(fileRealName, dirName, request, response);
			result="1";
		}
		return result;
	}
	
	/**
	 * 附件记录
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@ResponseBody
	@RequestMapping(value = "/invoice/fujianrecord",produces="text/html;charset=UTF-8")
	public String fujianRecord(HttpServletRequest request,HttpServletResponse response, FlxoaProjectInvoice model) throws UnsupportedEncodingException {
		String returnStr="";
		String invoiceManagerId=request.getParameter("invoiceManagerId");
		if(!CommonUtils.isEmpty(invoiceManagerId)){
			List<FlxoaAccessory> list=flxoaAccessoryService.fujianRecord(invoiceManagerId);
			JSONArray json=JSONArray.fromObject(list);
			returnStr= json.toString();
		}
		return returnStr;
	}
	
	/**
	 * 附件删除
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@ResponseBody
	@RequestMapping(value = "/invoice/fujiandelete",produces="text/html;charset=UTF-8")
	public String fujianDelete(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		String result="0";
		String accessoryId=request.getParameter("accessoryId");
		if(!CommonUtils.isEmpty(accessoryId)){
			FlxoaAccessory model=new FlxoaAccessory();
			model.setId(Integer.valueOf(accessoryId));
			FlxoaAccessory flxoaAccessory = flxoaAccessoryService.queryById(model);
			boolean flag = flxoaAccessoryService.delete(flxoaAccessory);
			if (flag) {
				result = "1";
			}
		}
		return result;
	}
	
}
