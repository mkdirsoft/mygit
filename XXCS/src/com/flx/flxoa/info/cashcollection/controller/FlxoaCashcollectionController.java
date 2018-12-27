/**
 * 
 */
package com.flx.flxoa.info.cashcollection.controller;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.flx.flxoa.common.util.CommonUtils;
import com.flx.flxoa.common.util.DateUtils;
import com.flx.flxoa.common.util.PoiUtil;
import com.flx.flxoa.info.cashcollection.entity.FlxoaCashcollectionClaimAffirm;
import com.flx.flxoa.info.cashcollection.entity.FlxoaCashcollectionRecord;
import com.flx.flxoa.info.cashcollection.manager.FlxoaCashcollectionClaimAffirmService;
import com.flx.flxoa.info.cashcollection.manager.FlxoaCashcollectionRecordService;
import com.flx.flxoa.info.projectmanagement.entity.FlxoaProjectInformation;
import com.flx.flxoa.info.projectmanagement.manager.FlxoaProjectInformationService;
import com.flx.flxoa.info.system.comon.Permission;

/**
 * @author 赵鹏辉
 * @date 2018-3-16 下午12:50:44
 * 描述：回款
 */
@Controller
public class FlxoaCashcollectionController {

	protected FlxoaCashcollectionRecordService flxoaCashcollectionRecordService;
	protected FlxoaCashcollectionClaimAffirmService flxoaCashcollectionClaimAffirmService;
	protected FlxoaProjectInformationService flxoaProjectInformationService;

	@Autowired
	public void setCashcollectionRecordService(FlxoaCashcollectionRecordService flxoaCashcollectionRecordService) {
		this.flxoaCashcollectionRecordService = flxoaCashcollectionRecordService;
	}

	@Autowired
	public void setFlxoaCashcollectionClaimAffirmService(FlxoaCashcollectionClaimAffirmService flxoaCashcollectionClaimAffirmService) {
		this.flxoaCashcollectionClaimAffirmService = flxoaCashcollectionClaimAffirmService;
	}

	@Autowired
	public void setFlxoaProjectInformationService(FlxoaProjectInformationService flxoaProjectInformationService) {
		this.flxoaProjectInformationService = flxoaProjectInformationService;
	}
	/**
	 * 列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/cash/list")
	public String list(HttpServletRequest request,HttpServletResponse response ){
		return "/nk/pages/cashCollection/cashCollection";
	}

	/**
	 * 查询
	 * @param modelAndView
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/cash/queryforlist",produces="text/html;charset=UTF-8")
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
		String roles=Permission.getRolesByUserId(userId);
		String role[]=roles.split(",");
		boolean renling=false;
		boolean shenhe=false;
		boolean caiwu=false;
		boolean chaifen=false;
		for(int i=0;i<role.length;i++){
			if(role[i].equals("回款认领")){
				renling=true;
			}else if(role[i].equals("回款审核")){
				shenhe=true;
			}else if(role[i].equals("财务回款")){
				caiwu=true;
			}else if(role[i].equals("回款拆分")){
				chaifen=true;
			}
		}
		
		String statusWhere="";
		String statusValue="";
		String deptData="0";
		
		if(caiwu){
			statusWhere="";
			deptData="1";
		}else{
			if(renling){//认领
				if(!CommonUtils.isEmpty(statusValue)){
					statusValue+=",'0','5','6','7','8'";
				}else{
					statusValue="'0','5','6','7','8'";
					statusWhere=" and ( Cash.claim_id = "+userId+"   or ";
				}
			}
			if(shenhe){//审核
				if(!CommonUtils.isEmpty(statusValue)){
					statusValue+=",'1','5','6','7','8'";
				}else{
					statusValue="'1','5','6','7','8'";
					statusWhere=" and ( Cash.affirm_id = "+userId+"   or ";
				}
			}
			if(chaifen){//拆分
				if(!CommonUtils.isEmpty(statusValue)){
					statusValue+=",'0','7'";
				}else{
					statusValue="'0','7'";
					statusWhere=" and ( ";
				}
			}
			if(!CommonUtils.isEmpty(statusValue)){
				statusWhere +=" Cash.status in("+statusValue+")  ) ";				
			}
			
			if(shenhe){//审核
				if(!renling&&!chaifen){
					deptData="3";
				}else if(renling||chaifen){
					deptData="4";
				}
			}else{//其他
				if(renling||chaifen){
					deptData="2";
				}
			}
		} 

		String deptIds=Permission.getPermissionDepartMentIds(userId, path,true);
		String caroOrgName=request.getParameter("caroOrgName");
		String projName=request.getParameter("projName");
		String projNumber=request.getParameter("projNumber");
		String createStartDate=request.getParameter("createStartDate");
		String createEndDate=request.getParameter("createEndDate");
		String deptId=request.getParameter("deptId");
		String claimUserName=request.getParameter("claimUserName");
		String affirmUserName=request.getParameter("affirmUserName");
		String caroMoney=request.getParameter("caroMoney");
		String caroType=request.getParameter("caroType");
		String flagDo = request.getParameter("flagDo");
		String unitName = request.getParameter("unitName");
		String caroStatusCheck = request.getParameter("caroStatusCheck");
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
		System.out.println(startTime);
		System.out.println(endTime);
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
		map.put("caroOrgName", caroOrgName);
		map.put("projName", projName);
		map.put("projNumber", projNumber);
		map.put("startTime", startTime);
		map.put("endTime", endTime);
		map.put("deptWhere", deptWhere);
		map.put("claimUserName", claimUserName);
		map.put("affirmUserName", affirmUserName);
		map.put("caroMoney", caroMoney);
		map.put("caroType", caroType);
		map.put("flagDo",flagDo);
		map.put("statusWhere", statusWhere);
		map.put("deptData", deptData);
		map.put("start", start);
		map.put("length", length);
		map.put("draw", draw);
		map.put("unitName", unitName);
		map.put("caroStatusCheck",caroStatusCheck);
		return flxoaCashcollectionRecordService.queryForPage(map);
	}
	/**
	 * 查看
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/cash/view",produces="text/html;charset=UTF-8")
	public String  view(HttpServletRequest request,HttpServletResponse response){
		String start = request.getParameter("start"); 
		String length = request.getParameter("length");
		String draw = request.getParameter("draw");
		if (start==""||start==null){
			start="0";
		}
		if(length==""||length==null){
			length="10";
		}
		String caroId=request.getParameter("caroId");
		return flxoaCashcollectionRecordService.view(Integer.valueOf(start),Integer.valueOf(length),caroId,draw);
	}


	/**
	 * 添加
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@ResponseBody
	@RequestMapping(value = "/cash/add",produces="text/html;charset=UTF-8")
	public String add(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		int createTime=0;
		if(!CommonUtils.isEmpty(request.getParameter("createTime"))){
			createTime=DateUtils.dateToTimestamp(request.getParameter("createTime"));
		}
		String caroOrgName=request.getParameter("caroOrgName");
		String caroMoney=request.getParameter("caroMoney");
		if(CommonUtils.isEmpty(caroMoney)){
			caroMoney="0";
		}
		BigDecimal caroMoney2=new BigDecimal(caroMoney);
		FlxoaCashcollectionRecord model=new FlxoaCashcollectionRecord();
		model.setFundSource("");
		model.setAccountNumber("");
		model.setCaroOrgName(caroOrgName);
		model.setCaroMoney(caroMoney2);
		model.setCaroUse("");
		model.setAffirmId(0);
		model.setAffirmTime(0);
		model.setCaroType("");
		model.setClaimId(0);
		model.setClaimTime(0);
		model.setProjectId(0);
		model.setStatus("0");
		model.setPid(0);
		model.setIsshow("0");
		model.setCreateTime(createTime);

		boolean flag = flxoaCashcollectionRecordService.add(model);
		String result="0";
		if (flag) {
			result = "1";
		}
		return result;
	}
	/**
	 * 修改
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/cash/update",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String update(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		String caroId=request.getParameter("caroId");
		if(!CommonUtils.isEmpty(caroId)){
			FlxoaCashcollectionRecord model=new FlxoaCashcollectionRecord();
			model.setId(Integer.valueOf(caroId));
			FlxoaCashcollectionRecord flxoaCashcollectionRecord = flxoaCashcollectionRecordService.queryById(model);
			JSONArray json=JSONArray.fromObject(flxoaCashcollectionRecord);
			return json.toString();
		}else{
			return "";
		}
	}

	/**
	 * 修改
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/cash/save",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String save(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		String result="0";
		String caroId=request.getParameter("caroId");
		if(!CommonUtils.isEmpty(caroId)){
			String caroOrgName=request.getParameter("caroOrgName");
			String caroMoney=request.getParameter("caroMoney");
			if(CommonUtils.isEmpty(caroMoney)){
				caroMoney="0";
			}
			BigDecimal caroMoney2=new BigDecimal(caroMoney);
			FlxoaCashcollectionRecord model=new FlxoaCashcollectionRecord();
			model.setId(Integer.valueOf(caroId));

			FlxoaCashcollectionRecord flxoaCashcollectionRecord = flxoaCashcollectionRecordService.queryById(model);
			flxoaCashcollectionRecord.setCaroOrgName(caroOrgName);
			flxoaCashcollectionRecord.setCaroMoney(caroMoney2);
			boolean flag = flxoaCashcollectionRecordService.update(flxoaCashcollectionRecord);

			if (flag) {
				result = "1";
			}
		}
		return result;
	}


	/**
	 * 删除
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/cash/delete",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String delete(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		String result="0";
		String caroId=request.getParameter("caroId");
		if(!CommonUtils.isEmpty(caroId)){
			FlxoaCashcollectionRecord model=new FlxoaCashcollectionRecord();
			model.setId(Integer.valueOf(caroId));
			FlxoaCashcollectionRecord flxoaCashcollectionRecord = flxoaCashcollectionRecordService.queryById(model);
			boolean flag = flxoaCashcollectionRecordService.delete(flxoaCashcollectionRecord);

			if (flag) {
				result = "1";
			}
		}
		return result;
	}

	/**
	 * 清空
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/cash/clear",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String clear(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		String result="0";
		String caroId=request.getParameter("caroId");
		if(!CommonUtils.isEmpty(caroId)){
			FlxoaCashcollectionRecord model=new FlxoaCashcollectionRecord();
			model.setId(Integer.valueOf(caroId));

			FlxoaCashcollectionRecord flxoaCashcollectionRecord = flxoaCashcollectionRecordService.queryById(model);
			flxoaCashcollectionRecord.setFundSource("");
			flxoaCashcollectionRecord.setAccountNumber("");
			flxoaCashcollectionRecord.setCaroUse("");
			flxoaCashcollectionRecord.setAffirmId(0);
			flxoaCashcollectionRecord.setAffirmTime(0);
			flxoaCashcollectionRecord.setCaroType("");
			flxoaCashcollectionRecord.setClaimId(0);
			flxoaCashcollectionRecord.setClaimTime(0);
			flxoaCashcollectionRecord.setProjectId(0);
			flxoaCashcollectionRecord.setStatus("0");
			
			List<FlxoaCashcollectionRecord> list=flxoaCashcollectionRecordService.queryByPId(caroId);
			if(list.size()>0){
				for(int i=0;i<list.size();i++){
					FlxoaCashcollectionRecord cashcollectionRecord=list.get(i);
					flxoaCashcollectionRecordService.delete(cashcollectionRecord);
				}
			}
			boolean flag = flxoaCashcollectionRecordService.update(flxoaCashcollectionRecord);
			
			String operationContent="清空";
			FlxoaCashcollectionClaimAffirm flxoaCashcollectionClaimAffirm=new FlxoaCashcollectionClaimAffirm();
			flxoaCashcollectionClaimAffirm.setCaroId(model.getId());
			flxoaCashcollectionClaimAffirm.setProjectId(0);
			flxoaCashcollectionClaimAffirm.setStatus("4");
			flxoaCashcollectionClaimAffirm.setRevocationReason("");
			flxoaCashcollectionClaimAffirm.setOperationContent(operationContent);
			flag = flxoaCashcollectionRecordService.renling(flxoaCashcollectionRecord,flxoaCashcollectionClaimAffirm);
			
			if (flag) {
				result = "1";
			}
		}
		return result;
	}

	/**
	 * 导入
	 * @param request
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@ResponseBody
	@RequestMapping(value = "/cash/upload",produces="text/html;charset=UTF-8")
	public String uploadHKJL(HttpServletRequest request,HttpServletResponse response,@RequestParam(value="file",required=false) MultipartFile file) throws UnsupportedEncodingException{
		String result="0";
		try{
			if(file!=null&&!file.isEmpty()){
				InputStream in=file.getInputStream();
				List<List<String>> list = new ArrayList<List<String>>();
				list = PoiUtil.replaceModelByxls1(in);
				if(list!=null){
					boolean flag = flxoaCashcollectionRecordService.replaceModelByxls(list);
					if(flag){
						//成功
						result = "1";
					}
				}else {
					//文件内容为空！
					result = "2";
				}
			}else{
				//文件内容为空！
				result = "2";
			}
		} catch (Exception e) {
			result = "0";
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 导出
	 * @param request
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@ResponseBody
	@RequestMapping(value = "/cash/export",produces="text/html;charset=UTF-8")
	public String export(HttpServletRequest request,HttpServletResponse response)throws UnsupportedEncodingException{
		String result="导出失败！";
		String path = request.getServletPath()+request.getPathInfo();
		int userId = Integer.parseInt(String.valueOf(request.getSession().getAttribute("userId")));
		String roles=Permission.getRolesByUserId(userId);
		String role[]=roles.split(",");
		boolean renling=false;
		boolean shenhe=false;
		boolean caiwu=false;
		boolean chaifen=false;
		for(int i=0;i<role.length;i++){
			if(role[i].equals("回款认领")){
				renling=true;
			}else if(role[i].equals("回款审核")){
				shenhe=true;
			}else if(role[i].equals("财务回款")){
				caiwu=true;
			}else if(role[i].equals("回款拆分")){
				chaifen=true;
			}
		}
		
		String statusWhere="";
		String statusValue="";
		String deptData="0";
		
		if(caiwu){
			statusWhere="";
			deptData="1";
		}else{
			if(renling){//认领
				if(!CommonUtils.isEmpty(statusValue)){
					statusValue+=",'0','5','6','7','8'";
				}else{
					statusValue="'0','5','6','7','8'";
				}
			}
			if(shenhe){//审核
				if(!CommonUtils.isEmpty(statusValue)){
					statusValue+=",'1','5','6','7','8'";
				}else{
					statusValue="'1','5','6','7','8'";
				}
			}
			if(chaifen){//拆分
				if(!CommonUtils.isEmpty(statusValue)){
					statusValue+=",'0','7'";
				}else{
					statusValue="'0','7'";
				}
			}
			statusWhere=" and Cash.status in("+statusValue+") ";
			
			if(shenhe){//审核
				if(!renling&&!chaifen){
					deptData="3";
				}else if(renling||chaifen){
					deptData="4";
				}
			}else{//其他
				if(renling||chaifen){
					deptData="2";
				}
			}
		} 

		String deptIds=Permission.getPermissionDepartMentIds(userId, path,true);
		String caroOrgName=request.getParameter("caroOrgName");
		String projName=request.getParameter("projName");
		String projNumber=request.getParameter("projNumber");
		String createTime=request.getParameter("createTime");
		String deptId=request.getParameter("deptId");
		String claimUserName=request.getParameter("claimUserName");
		String affirmUserName=request.getParameter("affirmUserName");
		String caroMoney=request.getParameter("caroMoney");
		String caroType=request.getParameter("caroType");
		String startTime="";
		String endTime="";
		if(!CommonUtils.isEmpty(createTime)){
			if(createTime.contains("-")){
				startTime=String.valueOf(DateUtils.dateToTimestamp(createTime.split("-")[0].replace("/", "-")));
				endTime=String.valueOf(DateUtils.dateToTimestamp(createTime.split("-")[1].replace("/", "-")));
			}else{
				startTime=String.valueOf(DateUtils.dateToTimestamp(createTime.replace("/", "-")));
				endTime=String.valueOf(DateUtils.dateToTimestamp(createTime.replace("/", "-")));
			}
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
		map.put("caroOrgName", caroOrgName);
		map.put("projName", projName);
		map.put("projNumber", projNumber);
		map.put("startTime", startTime);
		map.put("endTime", endTime);
		map.put("deptWhere", deptWhere);
		map.put("deptData", deptData);
		map.put("claimUserName", claimUserName);
		map.put("affirmUserName", affirmUserName);
		map.put("caroMoney", caroMoney);
		map.put("caroType", caroType);
		map.put("statusWhere", statusWhere);
		try{
			List<Map<String,String>> list=flxoaCashcollectionRecordService.query(map);
			boolean flag=PoiUtil.excelExport(list,response);
			if(flag){
				result = "导出成功！";
			}
		} catch (Exception e) {
			result = "导出失败！";
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 认领记录
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/cash/renlingrecord",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String renlingRecord(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		String returnStr="";
		String projectId=request.getParameter("projectId");
		if(!CommonUtils.isEmpty(projectId)){
			List<FlxoaCashcollectionRecord> cashcollectionList=flxoaCashcollectionRecordService.renlingRecord(projectId);
			JSONArray json=JSONArray.fromObject(cashcollectionList);
			returnStr=json.toString();
		}
		return returnStr;
	}



	/**
	 * 认领
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/cash/renling",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String renling(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		String result="0";
		String caroId=request.getParameter("caroId");
		String projectId=request.getParameter("projectId");
		if(!CommonUtils.isEmpty(projectId)&&!CommonUtils.isEmpty(projectId)){
			String caroType=request.getParameter("caroType");
			String caroUse=request.getParameter("caroUse");
			String projName=request.getParameter("projName");
			String projNumber=request.getParameter("projNumber");
			FlxoaCashcollectionRecord model=new FlxoaCashcollectionRecord();
			model.setId(Integer.valueOf(caroId));

			int nowTime = DateUtils.getSecondTimestamp(new Date());
			int userId = Integer.parseInt((String)request.getSession().getAttribute("userId"));
			FlxoaCashcollectionRecord flxoaCashcollectionRecord = flxoaCashcollectionRecordService.queryById(model);
			flxoaCashcollectionRecord.setProjectId(Integer.valueOf(projectId));
			flxoaCashcollectionRecord.setCaroType(caroType);
			flxoaCashcollectionRecord.setCaroUse(caroUse);
			flxoaCashcollectionRecord.setClaimId(userId);
			flxoaCashcollectionRecord.setClaimTime(nowTime);
			flxoaCashcollectionRecord.setStatus("1");

			String operationContent="项目编号："+projNumber+"， 项目名称："+projName;
			FlxoaCashcollectionClaimAffirm flxoaCashcollectionClaimAffirm=new FlxoaCashcollectionClaimAffirm();
			flxoaCashcollectionClaimAffirm.setCaroId(model.getId());
			flxoaCashcollectionClaimAffirm.setProjectId(Integer.valueOf(projectId));
			flxoaCashcollectionClaimAffirm.setStatus("0");
			flxoaCashcollectionClaimAffirm.setRevocationReason("");
			flxoaCashcollectionClaimAffirm.setOperationContent(operationContent);
			boolean flag = flxoaCashcollectionRecordService.renling(flxoaCashcollectionRecord,flxoaCashcollectionClaimAffirm);
			if (flag) {
				result = "1";
			}
		}
		return result;
	}
	
	/**
	 * 审核前
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/cash/shenhebefore",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String shenheBefore(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		String result="0";
		String caroId=request.getParameter("caroId"); 
		if(!CommonUtils.isEmpty(caroId)){
			FlxoaCashcollectionRecord model=new FlxoaCashcollectionRecord();
			model.setId(Integer.valueOf(caroId));
			FlxoaCashcollectionRecord flxoaCashcollectionRecord = flxoaCashcollectionRecordService.queryById(model);
			String oldStatus=flxoaCashcollectionRecord.getStatus();
			if(oldStatus.equals("5")){//认领或者审核
				result="1";
			}else if(oldStatus.equals("1")){//财务拆分审核
				result="2";
			}
		}
		return result;
	}
	
	/**
	 * 审核通过记录
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/cash/shenherecord",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String shenheRecord(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		String returnStr="";
		String caroId=request.getParameter("caroId");
		if(!CommonUtils.isEmpty(caroId)){
			List<Map<String,String>> cashcollectionList=flxoaCashcollectionRecordService.shenheRecord(caroId);
			JSONArray json=JSONArray.fromObject(cashcollectionList);
			returnStr= json.toString();
		}
		return returnStr;
	}
	
	

	/**
	 * 审核
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/cash/shenhe",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String shenhe(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		String result="0";
		String caroId=request.getParameter("caroId");
		if(!CommonUtils.isEmpty(caroId)){
			String revocationReason=CommonUtils.returnStr(request.getParameter("revocationReason"));
			String shenheStatus=request.getParameter("shenheStatus");
			int nowTime = DateUtils.getSecondTimestamp(new Date());
			int userId = Integer.parseInt((String)request.getSession().getAttribute("userId"));
			String userName =(String) request.getSession().getAttribute("userName");
			
			FlxoaCashcollectionRecord model=new FlxoaCashcollectionRecord();
			model.setId(Integer.valueOf(caroId));
			FlxoaCashcollectionRecord flxoaCashcollectionRecord = flxoaCashcollectionRecordService.queryById(model);
			String oldStatus=flxoaCashcollectionRecord.getStatus();

			FlxoaCashcollectionClaimAffirm flxoaCashcollectionClaimAffirm=new FlxoaCashcollectionClaimAffirm();
			boolean flag=false;
			if(shenheStatus.equals("0")){//通过
				String status="";
				String operationContent="审核通过";
				if(oldStatus.equals("5")){
					status="6";
					List<FlxoaCashcollectionRecord> list=flxoaCashcollectionRecordService.queryByPId(flxoaCashcollectionRecord.getId().toString());
					if(list.size()>0){
						for(int i=0;i<list.size();i++){
							FlxoaCashcollectionRecord flxoaCashcollectionRecord2=list.get(i);
							flxoaCashcollectionRecord2.setStatus(status);
							flxoaCashcollectionRecord2.setAffirmId(userId);
							flxoaCashcollectionRecord2.setAffirmTime(nowTime);

							FlxoaCashcollectionClaimAffirm flxoaCashcollectionClaimAffirm2=new FlxoaCashcollectionClaimAffirm();
							flxoaCashcollectionClaimAffirm2.setCaroId(model.getId());
							flxoaCashcollectionClaimAffirm2.setStatus("1");
							flxoaCashcollectionClaimAffirm2.setProjectId(flxoaCashcollectionRecord.getProjectId());
							flxoaCashcollectionClaimAffirm2.setRevocationReason("");
							flxoaCashcollectionClaimAffirm2.setOperationContent(operationContent);

							flag= flxoaCashcollectionRecordService.shenhe(flxoaCashcollectionRecord2,flxoaCashcollectionClaimAffirm2);
						}
					}
				}else{
					status="3";
					FlxoaProjectInformation project=new FlxoaProjectInformation();
					project.setId(flxoaCashcollectionRecord.getProjectId());
					FlxoaProjectInformation flxoaProjectInformation =flxoaProjectInformationService.queryById(project);
					String projNumber=flxoaProjectInformation.getProjNumber();
					String projName=flxoaProjectInformation.getProjName();
					operationContent="项目编号："+projNumber+"， 项目名称："+projName;
				}

				flxoaCashcollectionRecord.setStatus(status);
				flxoaCashcollectionRecord.setAffirmId(userId);
				flxoaCashcollectionRecord.setAffirmTime(nowTime);

				flxoaCashcollectionClaimAffirm.setCaroId(model.getId());
				flxoaCashcollectionClaimAffirm.setStatus("1");
				flxoaCashcollectionClaimAffirm.setProjectId(flxoaCashcollectionRecord.getProjectId());
				flxoaCashcollectionClaimAffirm.setRevocationReason("");
				flxoaCashcollectionClaimAffirm.setOperationContent(operationContent);

				flag= flxoaCashcollectionRecordService.shenhe(flxoaCashcollectionRecord,flxoaCashcollectionClaimAffirm);
			}else{//未通过
				if(oldStatus.equals("5")){
					String status="7";
					List<FlxoaCashcollectionRecord> list=flxoaCashcollectionRecordService.queryByPId(flxoaCashcollectionRecord.getId().toString());
					if(list.size()>0){
						for(int i=0;i<list.size();i++){
							FlxoaCashcollectionRecord flxoaCashcollectionRecord2=list.get(i);
							flxoaCashcollectionRecord2.setFundSource("");
							flxoaCashcollectionRecord2.setAccountNumber("");
							flxoaCashcollectionRecord2.setCaroUse("退回原因："+revocationReason);
							flxoaCashcollectionRecord2.setAffirmId(0);
							flxoaCashcollectionRecord2.setAffirmTime(0);
							flxoaCashcollectionRecord2.setCaroType("");
							flxoaCashcollectionRecord2.setClaimId(0);
							flxoaCashcollectionRecord2.setClaimTime(0);
							flxoaCashcollectionRecord2.setProjectId(0);
							flxoaCashcollectionRecord2.setStatus(status);

							FlxoaCashcollectionClaimAffirm flxoaCashcollectionClaimAffirm2=new FlxoaCashcollectionClaimAffirm();
							flxoaCashcollectionClaimAffirm2.setCaroId(model.getId());
							flxoaCashcollectionClaimAffirm2.setStatus("2");
							flxoaCashcollectionClaimAffirm2.setProjectId(flxoaCashcollectionRecord.getProjectId());
							flxoaCashcollectionClaimAffirm2.setRevocationReason(revocationReason);
							flxoaCashcollectionClaimAffirm2.setOperationContent("操作人："+userName+"； 操作时间："+DateUtils.format2(new Date())+"； 退回原因："+revocationReason);
							flag= flxoaCashcollectionRecordService.shenhe(flxoaCashcollectionRecord2,flxoaCashcollectionClaimAffirm2);
						} 
					}
				}

				if(oldStatus.equals("6")){
					List<FlxoaCashcollectionRecord> list=flxoaCashcollectionRecordService.queryByPId(caroId);
					if(list.size()>0){
						for(int i=0;i<list.size();i++){
							FlxoaCashcollectionRecord cashcollectionRecord=list.get(i);
							flxoaCashcollectionRecordService.delete(cashcollectionRecord);
						}
					}
				}
				flxoaCashcollectionRecord.setFundSource("");
				flxoaCashcollectionRecord.setAccountNumber("");
				flxoaCashcollectionRecord.setCaroUse("退回原因："+revocationReason);
				flxoaCashcollectionRecord.setAffirmId(0);
				flxoaCashcollectionRecord.setAffirmTime(0);
				flxoaCashcollectionRecord.setCaroType("");
				flxoaCashcollectionRecord.setClaimId(0);
				flxoaCashcollectionRecord.setClaimTime(0);
				flxoaCashcollectionRecord.setProjectId(0);
				flxoaCashcollectionRecord.setStatus("0");

				flxoaCashcollectionClaimAffirm.setCaroId(model.getId());
				flxoaCashcollectionClaimAffirm.setStatus("2");
				flxoaCashcollectionClaimAffirm.setProjectId(flxoaCashcollectionRecord.getProjectId());
				flxoaCashcollectionClaimAffirm.setRevocationReason(revocationReason);
				flxoaCashcollectionClaimAffirm.setOperationContent("操作人："+userName+"； 操作时间："+DateUtils.format2(new Date())+"； 退回原因："+revocationReason);
				flag= flxoaCashcollectionRecordService.shenhe(flxoaCashcollectionRecord,flxoaCashcollectionClaimAffirm);
			}
			if (flag) {
				result = "1";
			}
		}
		return result;
	}

	/**
	 * 拆分前
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/cash/chaifenbefore",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String chaifenbefore(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		String result="0";
		int userId = Integer.parseInt(String.valueOf(request.getSession().getAttribute("userId")));
		String roles=Permission.getRolesByUserId(userId);
		String role[]=roles.split(",");
		boolean renling=false;
		boolean shenhe=false;
		boolean caiwu=false;
		for(int i=0;i<role.length;i++){
			if(role[i].equals("回款认领")){
				renling=true;
			}else if(role[i].equals("回款审核")){
				shenhe=true;
			}else if(role[i].equals("财务回款")){
				caiwu=true;
			}
		}
		if(caiwu){//财务
			result="2";
		}else{
			if(renling||shenhe){//认领或者审核
				result="1";
			}
		}
		return result;
	}

	/**
	 * 拆分记录
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/cash/chaifenRecord",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String chaifenRecord(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		String returnStr="";
		String caroId=request.getParameter("caroId");
		if(!CommonUtils.isEmpty(caroId)){
			List<Map<String,String>> cashcollectionList=flxoaCashcollectionRecordService.chaifenRecord(caroId);
			JSONArray json=JSONArray.fromObject(cashcollectionList);
			returnStr= json.toString();
		}
		return returnStr;
	}

	/**
	 * 拆分
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/cash/chaifen",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String chaifen(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		String result="0";
		String data=request.getParameter("data");
		if(!CommonUtils.isEmpty(data)){
			JSONArray arry = JSONArray.fromObject(data);
			List<Map<String, String>> rsList = new ArrayList<Map<String, String>>();
			for (int i = 0; i < arry.size(); i++){
				JSONObject jsonObject = arry.getJSONObject(i);
				Map<String, String> map = new HashMap<String, String>();
				for (Iterator<?> iter = jsonObject.keys(); iter.hasNext();){
					String key = (String) iter.next();
					String value = jsonObject.get(key).toString();
					map.put(key, value);
				}
				rsList.add(map);
			}

			String oldId=rsList.get(0).get("oldId");
			FlxoaCashcollectionRecord model=new FlxoaCashcollectionRecord();
			model.setId(Integer.valueOf(oldId));
			FlxoaCashcollectionRecord oldFlxoaCashcollectionRecord = flxoaCashcollectionRecordService.queryById(model);
			oldFlxoaCashcollectionRecord.setId(Integer.valueOf(oldId));

			BigDecimal amount = new BigDecimal(0); 
			for(int i=0;i<rsList.size();i++){
				String caroMoney=rsList.get(i).get("caroMoney");
				if(CommonUtils.isEmpty(caroMoney)){
					caroMoney="0";
				}
				BigDecimal caroMoney2=new BigDecimal(caroMoney);
				amount=amount.add(caroMoney2);
			}

			if(oldFlxoaCashcollectionRecord.getCaroMoney().compareTo(amount)!=0){
				result="1";
			}else{
				int nowTime = DateUtils.getSecondTimestamp(new Date());
				int userId = Integer.parseInt(String.valueOf(request.getSession().getAttribute("userId")));
				String roles=Permission.getRolesByUserId(userId);
				if(rsList.size()>0){
					boolean flag = flxoaCashcollectionRecordService.chaifen(oldFlxoaCashcollectionRecord,rsList,roles,userId,nowTime);
					if (flag) {
						result = "2";
					}
				}
			}
		}
		return result;
	}
	/**
	 * 确认
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/cash/queren",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String queren(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		String returnStr="0";
		String caroId=request.getParameter("caroId");
		if(!CommonUtils.isEmpty(caroId)){
			FlxoaCashcollectionRecord model=new FlxoaCashcollectionRecord();
			model.setId(Integer.valueOf(caroId));
			FlxoaCashcollectionRecord flxoaCashcollectionRecord=flxoaCashcollectionRecordService.queryById(model);
			flxoaCashcollectionRecord.setStatus("4");
			flxoaCashcollectionRecordService.update(flxoaCashcollectionRecord);
			List<FlxoaCashcollectionRecord> list=flxoaCashcollectionRecordService.queryByPId(caroId);
			for(int i=0;i<list.size();i++){
				FlxoaCashcollectionRecord cashcollectionRecord=list.get(i);
				cashcollectionRecord.setStatus("8");
				cashcollectionRecord.setIsshow("0");
				flxoaCashcollectionRecordService.update(flxoaCashcollectionRecord);
			}
			returnStr="1";
		}
		return returnStr;
	}
	
	
	/**
	 * 导入u8
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/cash/importu",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String importU(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		String caroId=request.getParameter("caroId");
		FlxoaCashcollectionRecord flxoaCashcollectionRecord=new FlxoaCashcollectionRecord();
		flxoaCashcollectionRecord.setId(Integer.valueOf(caroId));
		flxoaCashcollectionRecord.setStatus("2");

		//查询是否有权限
		boolean bResult = true;
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		if(bResult){
			boolean flag = flxoaCashcollectionRecordService.update(flxoaCashcollectionRecord);
			if(flag){
				jsonMap.put("msg", true);
			}
		} else{
			jsonMap.put("msg", false);
			jsonMap.put("msg1", "对不起您没有确认权限!");
		}
		response.setCharacterEncoding("UTF-8");
		JSONObject result = new JSONObject();
		result = JSONObject.fromObject(jsonMap);
		return result.toString();
	}
}
