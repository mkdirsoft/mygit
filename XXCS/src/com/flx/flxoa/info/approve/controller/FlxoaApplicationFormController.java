package com.flx.flxoa.info.approve.controller;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flx.flxoa.common.util.CommonUtils;
import com.flx.flxoa.common.util.DateUtils;
import com.flx.flxoa.info.approve.entity.ApproveFormDataJsonBean;
import com.flx.flxoa.info.approve.entity.FlxoaApproveConditionWorkflow;
import com.flx.flxoa.info.approve.entity.FlxoaApproveForm;
import com.flx.flxoa.info.approve.entity.FlxoaApproveFormdata;
import com.flx.flxoa.info.approve.entity.FlxoaApproveFormlog;
import com.flx.flxoa.info.approve.entity.FlxoaApproveFormtemplate;
import com.flx.flxoa.info.approve.manager.FlxoaApproveConditionWorkflowService;
import com.flx.flxoa.info.approve.manager.FlxoaApproveFormService;
import com.flx.flxoa.info.approve.manager.FlxoaApproveFormdataService;
import com.flx.flxoa.info.approve.manager.FlxoaApproveFormlogService;
import com.flx.flxoa.info.approve.manager.FlxoaApproveFormtemplateService;
import com.flx.flxoa.info.cashcollection.entity.FlxoaProjectInvoice;
import com.flx.flxoa.info.cashcollection.manager.FlxoaProjectInvoiceCheckService;
import com.flx.flxoa.info.cashcollection.manager.FlxoaProjectInvoiceService;
import com.flx.flxoa.info.projectmanagement.entity.FlxoaProjectBidInformation;
import com.flx.flxoa.info.projectmanagement.entity.FlxoaProjectInformation;
import com.flx.flxoa.info.projectmanagement.manager.FlxoaProjectBidInformationService;
import com.flx.flxoa.info.projectmanagement.manager.FlxoaProjectInformationService;
import com.flx.flxoa.info.signin.entity.FlxoaAttendanceSigndetails;
import com.flx.flxoa.info.signin.manager.FlxoaAttendanceSigndetailsService;
import com.flx.flxoa.info.system.comon.Permission;
import com.flx.flxoa.info.system.entity.FlxoaApproveWorkflow;
import com.flx.flxoa.info.system.entity.FlxoaSystemEnumeration;
import com.flx.flxoa.info.system.entity.FlxoaSystemFuncation;
import com.flx.flxoa.info.system.entity.FlxoaSystemUser;
import com.flx.flxoa.info.system.entity.FlxoaSystemUserRole;
import com.flx.flxoa.info.system.manager.FlxoaApproveWorkflowService;
import com.flx.flxoa.info.system.manager.FlxoaSystemEnumerationService;
import com.flx.flxoa.info.system.manager.FlxoaSystemUserRoleService;
import com.flx.flxoa.info.system.manager.FlxoaSystemUserService;


/**
 * 类名称：FlxoaApplicationFormController.java
 * 类描述：
 * 创建时间：2018-3-18, 下午2:21:29
 * 
 * @version 1.0 
 * @since JDK版本 1.7
 * @author 刘凯 
 */
@Controller
public class FlxoaApplicationFormController {

	//申请数据
	protected FlxoaApproveFormdataService flxoaApproveFormdataService;

	@Autowired
	public void setFlxoaApproveFormdataService(FlxoaApproveFormdataService flxoaApproveFormdataService) {
		this.flxoaApproveFormdataService = flxoaApproveFormdataService;
	}
	
	//申请记录
	protected FlxoaApproveFormService flxoaApproveFormService;

	@Autowired
	public void setFlxoaApproveFormService(FlxoaApproveFormService flxoaApproveFormService) {
		this.flxoaApproveFormService = flxoaApproveFormService;
	}
	
	//审批记录
	protected FlxoaApproveFormlogService flxoaApproveFormlogService;

	@Autowired
	public void setFlxoaApproveFormlogService(FlxoaApproveFormlogService flxoaApproveFormlogService) {
		this.flxoaApproveFormlogService = flxoaApproveFormlogService;
	}

	//工作流
	protected FlxoaApproveWorkflowService flxoaApproveWorkflowService;

	@Autowired
	public void setFlxoaApproveWorkflowService(FlxoaApproveWorkflowService flxoaApproveWorkflowService) {
		this.flxoaApproveWorkflowService = flxoaApproveWorkflowService;
	}
	
	//申请表模板
	protected FlxoaApproveFormtemplateService flxoaApproveFormtemplateService;

	@Autowired
	public void setFlxoaApproveFormtemplateService(FlxoaApproveFormtemplateService flxoaApproveFormtemplateService) {
		this.flxoaApproveFormtemplateService = flxoaApproveFormtemplateService;
	}
	
	//申请模板不同选项调用不同的工作流
	protected FlxoaApproveConditionWorkflowService flxoaApproveConditionWorkflowService;

	@Autowired
	public void setFlxoaApproveConditionWorkflowService(FlxoaApproveConditionWorkflowService flxoaApproveConditionWorkflowService) {
		this.flxoaApproveConditionWorkflowService = flxoaApproveConditionWorkflowService;
	}
	
	//用户
	protected  FlxoaSystemUserService flxoaSystemUserService;
	@Autowired
	public void setSystemUserService(FlxoaSystemUserService flxoaSystemUserService) {
		this.flxoaSystemUserService = flxoaSystemUserService;
	}
	
	//用户角色
	protected  FlxoaSystemUserRoleService flxoaSystemUserRoleService;
	
	@Autowired
	public void setSystemUserRoleService(FlxoaSystemUserRoleService flxoaSystemUserRoleService) {
		this.flxoaSystemUserRoleService = flxoaSystemUserRoleService;
	}

	//枚举
	protected  FlxoaSystemEnumerationService flxoaSystemEnumerationService;
	
	@Autowired
	public void setFlxoaSystemEnumeration(FlxoaSystemEnumerationService flxoaSystemEnumerationService) {
		this.flxoaSystemEnumerationService = flxoaSystemEnumerationService;
	}
	
	//项目管理
	protected FlxoaProjectInformationService flxoaProjectInformationService;

	@Autowired
	public void setFlxoaProjectInformationService(
			FlxoaProjectInformationService flxoaProjectInformationService) {
		this.flxoaProjectInformationService = flxoaProjectInformationService;
	}	
	
	//回款发票
	protected FlxoaProjectInvoiceService flxoaProjectInvoiceService;
	
	@Autowired
	public void setCashcollectionRecordService(FlxoaProjectInvoiceService flxoaProjectInvoiceService) {
		this.flxoaProjectInvoiceService = flxoaProjectInvoiceService;
	}
	//投标信息
	protected FlxoaProjectBidInformationService flxoaProjectBidInformationService;
	
	@Autowired
	public void setFlxoaProjectBidInformationService(FlxoaProjectBidInformationService flxoaProjectBidInformationService) {
		this.flxoaProjectBidInformationService = flxoaProjectBidInformationService;
	}	

	//考勤详情
	protected FlxoaAttendanceSigndetailsService flxoaAttendanceSigndetailsService;
	
	@Autowired
	public void setFlxoaAttendanceSigndetailsService(
			FlxoaAttendanceSigndetailsService flxoaAttendanceSigndetailsService) {
		this.flxoaAttendanceSigndetailsService = flxoaAttendanceSigndetailsService;
	}	
	/**
	 * 保存申请数据
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/approve/save")
	@ResponseBody
	public String save(HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		//根据申请模板id
		int templateId = Integer.parseInt(request.getParameter("templateId"));
		//根据模板id 查找申请模板条件表是否有对应的工作流id
//		boolean flag = false;
//		FlxoaApproveConditionWorkflow flxoaApproveConditionWorkflow = new FlxoaApproveConditionWorkflow();
//		flxoaApproveConditionWorkflow.setTemplateId(templateId);
//		List<FlxoaApproveConditionWorkflow> workflowFindConditionList = flxoaApproveConditionWorkflowService.query(flxoaApproveConditionWorkflow);
//		if(null != workflowFindConditionList){
//			if(workflowFindConditionList.size() > 0){
//				flag = true;
//			}
//		}		
		//查询出模板json
		FlxoaApproveFormtemplate flxoaApproveFormtemplate = new FlxoaApproveFormtemplate();
		flxoaApproveFormtemplate.setId(templateId);
		FlxoaApproveFormtemplate queryFormData = flxoaApproveFormtemplateService.queryById(flxoaApproveFormtemplate);
		String json = queryFormData.getLayout();
		System.out.println(json);
		JSONObject root = JSONObject.fromObject(json);
		String names = root.getString("names");
		//用request获取 遍历出模板json的 key 对应的页面填写的信息
		JSONArray jsonList = JSONArray.fromObject(names);
		//存放页面的数据以及页面的value值
		List<FlxoaApproveFormdata> listFormdata = new ArrayList<FlxoaApproveFormdata>();
		for (int i = 0; i < jsonList.size(); i++) {
			JSONObject jsonObj = JSONObject.fromObject(jsonList.get(i));
			//数据项中文名称
			String name = jsonObj.getString("name");
			//数据项英文名称
			String key = jsonObj.getString("key");
			String enumeration_name = jsonObj.getString("enumeration_name");
        	//页面提交的数据
        	String data = null;
        	if(null != request.getParameter(key) && !"".equals(request.getParameter(data))){
        		data = request.getParameter(key);
        	}else{
        		data = request.getParameter(enumeration_name);
        	}
        	FlxoaApproveFormdata formdata = new FlxoaApproveFormdata();
        	if(null != data){
        		formdata.setDataKey(key);
        		formdata.setDataValue(data);
        		formdata.setDataDescription(name);
        		listFormdata.add(formdata);
        	}else{
        		formdata.setDataKey(key);
        		formdata.setDataValue("");
        		formdata.setDataDescription(name);
        		listFormdata.add(formdata);
        	}
        	JSONArray array = jsonObj.getJSONArray("list_items");
        	if(array.size() > 0){
        		for (int j = 0; j < array.size(); j++) {
        			JSONObject childJsonObj = array.getJSONObject(j);
        			//数据项子项中文名称
        			String childName = childJsonObj.getString("name");
        			//数据项子项英文名称
        			String childKey = childJsonObj.getString("key");
        			String childData = "";
        			if("bc_construction_cost".equals(childKey)){
        				String arr[] = request.getParameterValues(childKey);
        				for(int x = 0 ; x < arr.length ; x++){
        					childData += arr[x]+",";
        				}
        			}else{
        				//数据项子项提交的数据
        				 childData = request.getParameter(childKey);
        			}
                	FlxoaApproveFormdata childFormdata = new FlxoaApproveFormdata();
                	if(null != childData){
                		childFormdata.setDataKey(childKey);
                		childFormdata.setDataValue(childData);
                		childFormdata.setDataDescription(childName);
                		listFormdata.add(childFormdata);
                	}else{ 
                		childFormdata.setDataKey(childKey);
                		childFormdata.setDataValue("");
                		childFormdata.setDataDescription(childName);
                		listFormdata.add(childFormdata);
                	}                	
				}
        	}
        	//根据页面选择项 获取工作流
//        	if(flag)
//        	{
//        		for (int j = 0; j < workflowFindConditionList.size(); j++) {
//        			if(null != data){
//            			//根据key进行查找   条件保存到list里面
//            			if(key.equals(workflowFindConditionList.get(j).getFormdataDataKey()))
//            			{
//            				workflowConditionList.add(workflowFindConditionList.get(j));
//            			}       				
//        			}
//    			}
//        	}        	
		}
		
//		FlxoaApproveWorkflow queryWorkFlow = null;
//		//根据优先级获取最高级的工作流id 并且满足对应的条件
//		if(workflowConditionList.size() > 0)
//		{
//			//优先级降序排序
//			//升序排序
//			Collections.sort(workflowConditionList);
//			//反转之后降序
//	        Collections.reverse(workflowConditionList);
//	        FlxoaApproveWorkflow flxoaApproveWorkflow = new FlxoaApproveWorkflow();
//	        for (int i = 0; i < workflowConditionList.size(); i++) {
//	        	//获取页面输入的值来和条件进行比较
//	        	String key  = request.getParameter(workflowConditionList.get(i).getFormdataDataKey());
//	        	if(null != key){
//		        	if("=".equals(workflowConditionList.get(i).getExpression())){
//		        		//页面的值和条件相等 返回工作流
//		        		//页面的值和条件相等 返回工作流
//		        		boolean flagCondition = false;
//		        		if(-1 != key.indexOf(",")){
//		        			String [] temp = key.split(",");
//		        			for (int j = 0; j < temp.length; j++) {
//								if(temp[j].equals(workflowConditionList.get(i).getCondition())){
//									flxoaApproveWorkflow.setId(workflowConditionList.get(i).getWorkflowId());
//									queryWorkFlow = flxoaApproveWorkflowService.queryById(flxoaApproveWorkflow);		        			
//									flagCondition = true;
//									break;							
//								}
//							}
//		        		}else{
//			        		if(key.equals(workflowConditionList.get(i).getCondition())){
//								flxoaApproveWorkflow.setId(workflowConditionList.get(i).getWorkflowId());
//								queryWorkFlow = flxoaApproveWorkflowService.queryById(flxoaApproveWorkflow);		        			
//								break;
//			        		}		        			
//		        		}
//		        		if(flagCondition){
//		        			break;
//		        		}
//			        }else if(">".equals(workflowConditionList.get(i).getExpression())){
//		        		//页面的值大于条件 返回工作流
//		        		if((Integer.parseInt(key) > Integer.parseInt(workflowConditionList.get(i).getCondition()))){
//							flxoaApproveWorkflow.setId(workflowConditionList.get(i).getWorkflowId());
//							queryWorkFlow = flxoaApproveWorkflowService.queryById(flxoaApproveWorkflow);		        			
//							break;
//		        		}	
//			        }else if("<".equals(workflowConditionList.get(i).getExpression())){
//		        		//页面的值小于条件 返回工作流
//		        		if((Integer.parseInt(key) < Integer.parseInt(workflowConditionList.get(i).getCondition()))){
//							flxoaApproveWorkflow.setId(workflowConditionList.get(i).getWorkflowId());
//							queryWorkFlow = flxoaApproveWorkflowService.queryById(flxoaApproveWorkflow);		        			
//							break;
//		        		}			        	
//			        }else if("!=".equals(workflowConditionList.get(i).getExpression())){
//		        		//页面的值不等于条件 返回工作流
//		        		if(!key.equals(workflowConditionList.get(i).getCondition())){
//							flxoaApproveWorkflow.setId(workflowConditionList.get(i).getWorkflowId());
//							queryWorkFlow = flxoaApproveWorkflowService.queryById(flxoaApproveWorkflow);		        			
//							break;
//		        		}			        	
//			        }		        	
//	        	}
//			}
//		}
//		
//		//获取提交者、角色、所在部门，  读取 模板id对应的工作流，插入数据并插入 工作流当前用户角色提交的下一步状态
//		//当前角色
//		int userId = Integer.parseInt(String.valueOf(request.getSession().getAttribute("userId")));
//		String role = Permission.getRolesByUserId(userId);
//		//根据部门id和申请模板id查询对应的工作流json
//		//int departmentId = 2;
//		int departmentId = Integer.parseInt(String.valueOf(request.getSession().getAttribute("departmentId")));
//		//工作流json   
//		String workflowJson = "";
//		//如果有页面选择项或者时间长短（如请假申请表）走不同的工作流，优先默认工作流
//		if(null != queryWorkFlow)
//		{
//			workflowJson = queryWorkFlow.getWorkflowJson();
//		}
//		else
//		{
//			queryWorkFlow = getWorkflowJsonById(templateId,departmentId);
//			//默认工作流   
//			workflowJson = queryWorkFlow.getWorkflowJson();			
//		}
//		if("".equals(workflowJson))
//		{
//			return "0";
//		}		
		
		//开始插入数据
		//formId 0 新添加   有的话从 request中获取
		int formId = 0;
		FlxoaApproveForm flxoaApproveForm = new FlxoaApproveForm();
		if(null != request.getParameter("formId"))
		{
			formId = Integer.parseInt(request.getParameter("formId"));
			flxoaApproveForm.setId(formId);
			flxoaApproveForm = flxoaApproveFormService.queryById(flxoaApproveForm);
		}
		//当前状态
		flxoaApproveForm.setStatus("-1");
		//未提交
		flxoaApproveForm.setSubmitStatus("0");
		//确认人ids
		flxoaApproveForm.setCheckUserIds("");
		//设置未读状态
		flxoaApproveForm.setIsRead("0");
		//设置当前特殊状态
		flxoaApproveForm.setNowFormStatus("");		
		//工作流id
//		flxoaApproveForm.setWorkflowId(queryWorkFlow.getId());
		flxoaApproveForm.setWorkflowId(0);
		flxoaApproveForm.setSubmitTime(0);
		boolean formFlag = false;
		boolean dataFlag = false;
		if(0 == formId){
			//模板id
			flxoaApproveForm.setTemplateId(templateId);
			formFlag = flxoaApproveFormService.add(flxoaApproveForm);
			formId = flxoaApproveForm.getId();
			//保存申请记录
			if(formFlag){
				//遍历list 并保存数据到数据库
				for (FlxoaApproveFormdata flxoaApproveFormdata : listFormdata) {
					flxoaApproveFormdata.setFormId(formId);
					dataFlag = flxoaApproveFormdataService.add(flxoaApproveFormdata);
				}
				//29项目立项申请
				if(29 == templateId){
					updataProject(listFormdata,"0",true);
				}
				//50投标报名申请 
				else if(50 == templateId){
					updataBid(listFormdata, "0", true);
				}
				//31项目投标审批表
				else if(31 == templateId){
					updataBid(listFormdata, "4", true);
				}				
			}			
		}else{
			formFlag = flxoaApproveFormService.update(flxoaApproveForm);
			//修改申请记录
			if(formFlag){
				//遍历list 并更新数据到数据库
				for (FlxoaApproveFormdata flxoaApproveFormdata : listFormdata) {
					flxoaApproveFormdata.setFormId(formId);
					//根据formID和dataKey 查出数据库flxoa_approve_formdata对应的数据项
					FlxoaApproveFormdata queryEntity = flxoaApproveFormdataService.queryByEntity(flxoaApproveFormdata);
					queryEntity.setDataValue(flxoaApproveFormdata.getDataValue());
					dataFlag = flxoaApproveFormdataService.update(queryEntity);
				}
				//29项目立项申请
				if(29 == templateId){
					updataProject(listFormdata,"0",true);
				}
				//50投标报名申请 
				else if(50 == templateId){
					updataBid(listFormdata, "0", true);
				}
				//31项目投标审批表
				else if(31 == templateId){
					updataBid(listFormdata, "4", true);
				}					
			}
		}
		//0 失败  1成功
		String result="0";
		if (formFlag && dataFlag) {
			result = "1";
		}
		return result;
	}
	
	/**
	 * 更新项目信息
	 * listFormdata 申请表数据  
	 * projState立项状态 0未立项  1已立项
	 * flag 是否需要更新基本数据 false 不更新   true 更新
	 * */
	private void updataProject(List<FlxoaApproveFormdata> listFormdata,String projState,boolean flag){
		//项目实体
		FlxoaProjectInformation project = new FlxoaProjectInformation();				
		for (FlxoaApproveFormdata flxoaApproveFormdata : listFormdata) {
				//根据项目id 查找项目
				if("id".equals(flxoaApproveFormdata.getDataKey())){
					String id = flxoaApproveFormdata.getDataValue();
					if(!"".equals(id)){
						project.setId(Integer.parseInt(id));
						project = flxoaProjectInformationService.queryById(project);
					}
				}
		}
		if(null != project.getId()){
			if(flag){
				for (FlxoaApproveFormdata flxoaApproveFormdata : listFormdata) {
					//项目名称全称
					if("projName".equals(flxoaApproveFormdata.getDataKey())){
						//项目名称
						project.setProjName(flxoaApproveFormdata.getDataValue());
					}
					else if("es_contract_amount".equals(flxoaApproveFormdata.getDataKey())){
						//预计合同额
						project.setPredictContractMoney(flxoaApproveFormdata.getDataValue());
					}
					else if("proj_type".equals(flxoaApproveFormdata.getDataKey())){
						//项目类型
						project.setBusClassification(flxoaApproveFormdata.getDataValue());
					}else if("proj_attribute".equals(flxoaApproveFormdata.getDataKey())){
						//项目属性
						project.setProjAttribute(flxoaApproveFormdata.getDataValue());
					}else if("proj_stage".equals(flxoaApproveFormdata.getDataKey())){
						//项目阶段
						project.setProjStage(flxoaApproveFormdata.getDataValue());
					}else if("projNumber".equals(flxoaApproveFormdata.getDataKey())){
						//项目编号
						project.setProjNumber(flxoaApproveFormdata.getDataValue());
					}
				}				
			}
			//立项状态
			project.setProjState(projState);
			flxoaProjectInformationService.update(project);
		}
	}
	
	/**
	 * 更新投标信息
	 * listFormdata 申请表数据  
	 * bidSchedule 投标进度0:未报名1:报名审批中2:已报名3:投标准备中4:投标中5:投标结束
	 * flag 是否需要更新基本数据 false:不更新   true:更新
	 * */
	private void updataBid(List<FlxoaApproveFormdata> listFormdata,String bidSchedule,boolean flag){
		//项目实体
		FlxoaProjectInformation project = new FlxoaProjectInformation();		
		//投标实体
		FlxoaProjectBidInformation flxoaProjectBidInformation = new FlxoaProjectBidInformation();				
		for (FlxoaApproveFormdata flxoaApproveFormdata : listFormdata) {
				//根据项目id 查找投标信息
				if("id".equals(flxoaApproveFormdata.getDataKey())){
					String id = flxoaApproveFormdata.getDataValue();
					if(!"".equals(id)){
						flxoaProjectBidInformation.setProjectId(Integer.parseInt(id));
						flxoaProjectBidInformation = flxoaProjectBidInformationService.queryByEntity(flxoaProjectBidInformation);
						
						project.setId(Integer.parseInt(id));
						project = flxoaProjectInformationService.queryById(project);
					}
				}
		}
		//更新数据
		if(null != flxoaProjectBidInformation.getId()){
			//基本数据更新
			if(flag){
				int formId = 0;
				for (FlxoaApproveFormdata flxoaApproveFormdata : listFormdata) {
					if("project_id".equals(flxoaApproveFormdata.getDataKey())){
						//项目id
						flxoaProjectBidInformation.setProjectId(Integer.parseInt(flxoaApproveFormdata.getDataValue()));
					}
					//项目投标审批表
					//合同额
					if("contract_amount".equals(flxoaApproveFormdata.getDataKey())){
						//预计合同额
						flxoaProjectBidInformation.setPredictContractMoney(flxoaApproveFormdata.getDataValue());
					}
					//投标日期
					if("bidding_date".equals(flxoaApproveFormdata.getDataKey())){
						String date = flxoaApproveFormdata.getDataValue();
						int biddingDate = DateUtils.dateToTimestamp(date, "yyyy/MM/dd");
						//招标日期
						flxoaProjectBidInformation.setBiddingDate(biddingDate);
					}
					formId = flxoaApproveFormdata.getFormId().intValue();
				}
				//投标结束  把formId 设置给投标表
				if("5".equals(bidSchedule)){
					flxoaProjectBidInformation.setReason(String.valueOf(formId));
				}
			}
			//通用数据更新
			flxoaProjectBidInformation.setBidSchedule(bidSchedule);
			flxoaProjectBidInformationService.update(flxoaProjectBidInformation);
		}else{
			for (FlxoaApproveFormdata flxoaApproveFormdata : listFormdata) {
				if("id".equals(flxoaApproveFormdata.getDataKey())){
					//项目id
					flxoaProjectBidInformation.setProjectId(Integer.parseInt(flxoaApproveFormdata.getDataValue()));
				}
			}
			//投标负责人
			flxoaProjectBidInformation.setBiddingDirector("");
			//招标日期
			flxoaProjectBidInformation.setBiddingDate(0);
			//跟单人id
			flxoaProjectBidInformation.setFollowerId(project.getCreateUserId());
			//投标准备进度 0 投标负责人
			flxoaProjectBidInformation.setProjectBiddingStatus("0");
			//投标结果0:中标
			flxoaProjectBidInformation.setBiddingResults("0");
			//投标进度0:未报名
			flxoaProjectBidInformation.setBidSchedule("0");
			//失败原因
			flxoaProjectBidInformation.setReason("");
			//插入数据
			flxoaProjectBidInformationService.add(flxoaProjectBidInformation);
		}
	}
	
	/**
	 * 更新请假详情
	 * listFormdata 申请表数据  
	 * */
	private void updataSign(List<FlxoaApproveFormdata> listFormdata,Map<String,String> userMap) {
		FlxoaAttendanceSigndetails sign = new FlxoaAttendanceSigndetails();
		//签到备注
		String commens = "";
		for (FlxoaApproveFormdata flxoaApproveFormdata : listFormdata) {
			//请假开始时间
			if("al_start_time".equals(flxoaApproveFormdata.getDataKey())){
				commens += "请假开始时间:"+flxoaApproveFormdata.getDataValue()+",";
			}
			//请假结束时间
			if("al_end_time".equals(flxoaApproveFormdata.getDataKey())){
				commens += "请假结束时间:"+flxoaApproveFormdata.getDataValue()+",";
			}
			//请假天数
			if("al_days".equals(flxoaApproveFormdata.getDataKey())){
				commens += "请假天数:"+flxoaApproveFormdata.getDataValue()+",";
			}
			//请假事由
			if("al_reason".equals(flxoaApproveFormdata.getDataKey())){
				commens += "请假事由:"+flxoaApproveFormdata.getDataValue()+".";
			}					
		}
		//签到日期
		sign.setSignDate(DateUtils.getMorningTimestamp());
		//签到时间
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sign.setSignTime(DateUtils.dateToTimestamp2(sdf.format(d)));
		//签到地点
		sign.setSignLocale("");
		//签到点所在经度
		sign.setSignLongitude("");
		//签到点所在纬度
		sign.setSignLatitude("");
		//签到类型有5种类型：0：手机签到1：门禁刷卡2：请假中3：公出4：出差 
		sign.setSignType("2");
		sign.setCommens(commens);
		//获取登录人的id 
		//String userId = userMap.get("userId");
		//获取登录人的部门id
		//String deptId = userMap.get("deptId");
		//获取登录人的cardid (可有可无)
		String cardId = userMap.get("cardId");
		sign.setCard_id(cardId);
		//插入详情表
		flxoaAttendanceSigndetailsService.add(sign);
		
	}
	
	/**
	 * 提交申请数据
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = "/approve/submit")
	@ResponseBody
	public String submit(HttpServletRequest request,HttpServletResponse response, ModelMap model) throws UnsupportedEncodingException {
		//获取登录人的id 
		String userid = String.valueOf(request.getSession().getAttribute("userId"));
		//获取登录人的部门id
		String deptId = String.valueOf(request.getSession().getAttribute("departmentId"));
		//获取登录人的cardid (可有可无)
		String cardId = String.valueOf(request.getSession().getAttribute("cardId"));
		Map<String,String> userMap = new HashMap<String,String>();
		//userMap.put("userId", userid);
		//userMap.put("deptId", deptId);
		userMap.put("cardId", cardId);
		//根据申请模板id
		int templateId = Integer.parseInt(request.getParameter("templateId"));
		//根据模板id 查找申请模板条件表是否有对应的工作流id
		boolean flag = false;
		FlxoaApproveConditionWorkflow flxoaApproveConditionWorkflow = new FlxoaApproveConditionWorkflow();
		flxoaApproveConditionWorkflow.setTemplateId(templateId);
		List<FlxoaApproveConditionWorkflow> workflowFindConditionList = flxoaApproveConditionWorkflowService.query(flxoaApproveConditionWorkflow);
		if(null != workflowFindConditionList){
			if(workflowFindConditionList.size() > 0){
				flag = true;
			}
		}
		
		//查询出模板json
		FlxoaApproveFormtemplate flxoaApproveFormtemplate = new FlxoaApproveFormtemplate();
		flxoaApproveFormtemplate.setId(templateId);
		FlxoaApproveFormtemplate queryFormData = flxoaApproveFormtemplateService.queryById(flxoaApproveFormtemplate);
		String json = queryFormData.getLayout();
		JSONObject root = JSONObject.fromObject(json);
		String names = root.getString("names");
		//用request获取 遍历出模板json的 key 对应的页面填写的信息
		JSONArray jsonList = JSONArray.fromObject(names);
		//存放页面的数据以及页面的value值
		List<FlxoaApproveFormdata> listFormdata = new ArrayList<FlxoaApproveFormdata>();
		List<FlxoaApproveConditionWorkflow> workflowConditionList = new ArrayList<FlxoaApproveConditionWorkflow>();
		for (int i = 0; i < jsonList.size(); i++) {
			JSONObject jsonObj = JSONObject.fromObject(jsonList.get(i));
			//数据项中文名称
			String name = jsonObj.getString("name");
			//数据项英文名称
			String key = jsonObj.getString("key");
			
			String enumeration_name = jsonObj.getString("enumeration_name");
        	//页面提交的数据
        	String data = null;
        	if(null != request.getParameter(key) && !"".equals(request.getParameter(data))){
        		data = request.getParameter(key);
        	}else{
        		data = request.getParameter(enumeration_name);
        	}
        	FlxoaApproveFormdata formdata = new FlxoaApproveFormdata();
        	if(null != data){
        		formdata.setDataKey(key);
        		formdata.setDataValue(data);
        		formdata.setDataDescription(name);
        		listFormdata.add(formdata);
        	}else{
        		formdata.setDataKey(key);
        		formdata.setDataValue("");
        		formdata.setDataDescription(name);
        		listFormdata.add(formdata);
        	}
        	JSONArray array = jsonObj.getJSONArray("list_items");
        	if(array.size() > 0){
        		for (int j = 0; j < array.size(); j++) {
        			JSONObject childJsonObj = array.getJSONObject(j);
        			//数据项子项中文名称
        			String childName = childJsonObj.getString("name");
        			//数据项子项英文名称
        			String childKey = childJsonObj.getString("key");
                	//数据项子项提交的数据
                	String childData = request.getParameter(childKey);
                	FlxoaApproveFormdata childFormdata = new FlxoaApproveFormdata();
                	if(null != childData){
                		childFormdata.setDataKey(childKey);
                		childFormdata.setDataValue(childData);
                		childFormdata.setDataDescription(childName);
                		listFormdata.add(childFormdata);
                	}else{
                		childFormdata.setDataKey(childKey);
                		childFormdata.setDataValue("");
                		childFormdata.setDataDescription(childName);
                		listFormdata.add(childFormdata);
                	}                	
				}
        	}        	
        	//根据页面选择项 获取工作流
        	if(flag)
        	{
        		for (int j = 0; j < workflowFindConditionList.size(); j++) {
        			if(null != data){
            			//根据key进行查找   条件保存到list里面
            			if(key.equals(workflowFindConditionList.get(j).getFormdataDataKey()))
            			{
            				workflowConditionList.add(workflowFindConditionList.get(j));
            			}       				
        			}
    			}
        	}
		}
		
		FlxoaApproveWorkflow queryWorkFlow = null;
		//根据优先级获取最高级的工作流id 并且满足对应的条件
		if(workflowConditionList.size() > 0)
		{
			//优先级降序排序
			//升序排序
			Collections.sort(workflowConditionList);
			//反转之后 降序排序
	        Collections.reverse(workflowConditionList);
	        FlxoaApproveWorkflow flxoaApproveWorkflow = new FlxoaApproveWorkflow();
	        for (int i = 0; i < workflowConditionList.size(); i++) {
	        	//获取页面输入的值来和条件进行比较
	        	String key  = request.getParameter(workflowConditionList.get(i).getFormdataDataKey());
	        	if(null != key){
		        	if("=".equals(workflowConditionList.get(i).getExpression())){
		        		//页面的值和条件相等 返回工作流
		        		boolean flagCondition = false;
		        		if(-1 != key.indexOf(",")){
		        			String [] temp = key.split(",");
		        			for (int j = 0; j < temp.length; j++) {
								if(temp[j].equals(workflowConditionList.get(i).getCondition())){
									flxoaApproveWorkflow.setId(workflowConditionList.get(i).getWorkflowId());
									queryWorkFlow = flxoaApproveWorkflowService.queryById(flxoaApproveWorkflow);		        			
									flagCondition = true;
									break;							
								}
							}
		        		}else{
			        		if(key.equals(workflowConditionList.get(i).getCondition())){
								flxoaApproveWorkflow.setId(workflowConditionList.get(i).getWorkflowId());
								queryWorkFlow = flxoaApproveWorkflowService.queryById(flxoaApproveWorkflow);		        			
								break;
			        		}		        			
		        		}
		        		if(flagCondition){
		        			break;
		        		}
			        }
		        	else if(">".equals(workflowConditionList.get(i).getExpression())){
		        		//页面的值大于条件 返回工作流
		        		if((Integer.parseInt(key) > Integer.parseInt(workflowConditionList.get(i).getCondition()))){
							flxoaApproveWorkflow.setId(workflowConditionList.get(i).getWorkflowId());
							queryWorkFlow = flxoaApproveWorkflowService.queryById(flxoaApproveWorkflow);		        			
							break;
		        		}	
			        }
		        	else if("<".equals(workflowConditionList.get(i).getExpression())){
		        		//页面的值小于条件 返回工作流
		        		if((Integer.parseInt(key) < Integer.parseInt(workflowConditionList.get(i).getCondition()))){
							flxoaApproveWorkflow.setId(workflowConditionList.get(i).getWorkflowId());
							queryWorkFlow = flxoaApproveWorkflowService.queryById(flxoaApproveWorkflow);		        			
							break;
		        		}			        	
			        }else if("!=".equals(workflowConditionList.get(i).getExpression())){
		        		//页面的值不等于条件 返回工作流
		        		if(!key.equals(workflowConditionList.get(i).getCondition())){
							flxoaApproveWorkflow.setId(workflowConditionList.get(i).getWorkflowId());
							queryWorkFlow = flxoaApproveWorkflowService.queryById(flxoaApproveWorkflow);		        			
							break;
		        		}			        	
			        }	
	        	}
			}
		}
		
		//获取提交者、角色、所在部门，  读取 模板id对应的工作流，插入数据并插入 工作流当前用户角色提交的下一步状态
		//当前角色
		int userId = Integer.parseInt(String.valueOf(request.getSession().getAttribute("userId")));
		String role = Permission.getRolesByUserId(userId);
		//根据部门id和申请模板id查询对应的工作流json
		int departmentId = Integer.parseInt(String.valueOf(request.getSession().getAttribute("departmentId")));
		//工作流json   
		String workflowJson = "";
		//如果有页面选择项或者时间长短（如请假申请表）走不同的工作流，优先默认工作流
		if(null != queryWorkFlow)
		{
			workflowJson = queryWorkFlow.getWorkflowJson();
		}
		else
		{
			queryWorkFlow = getWorkflowJsonById(templateId,departmentId);
			//默认工作流  
			workflowJson = queryWorkFlow.getWorkflowJson();			
		}
		if("".equals(workflowJson))
		{
			return "0";
		}
		JSONObject rootWorkflowJson = JSONObject.fromObject(workflowJson);
		String nodes = rootWorkflowJson.getString("nodes");
		//当前状态
		String nowStatus = "";
		//form 状态
		String formStatus = "";		
		//下一级状态
		String nextStatus = "";
		JSONObject nodesJson = JSONObject.fromObject(nodes);
		//角色信息
		List<String> roleList = new ArrayList<String>();
		if(role.indexOf(",") != -1){
			String [] roles =  role.split(",");
			for (String temp : roles) {
				roleList.add(temp);
			}
		}
		else
		{
			roleList.add(role);
		}
		
		//保存工作流节点与角色信息匹配的索引
		List<Integer> indexList = new ArrayList<Integer>();
		//设置当前特殊状态
		String nowFormStatus = "";
		int workflowSize = 0;
		for (int i = 0; i < roleList.size(); i++) {
			workflowSize = 0;
			Iterator iterator = nodesJson.keys();
			while(iterator.hasNext()){
				String key = (String) iterator.next();
				String value = nodesJson.getString(key);
				JSONObject jsonObj = JSONObject.fromObject(value);
				//工作流节点名称
				String name = getNowName(jsonObj.getString("name"));
	        	//获取角色所在的位置索引,保存索引值 用来确认 走更高层角色的提交
	        	if(roleList.get(i).equals(name)){
	        		indexList.add(workflowSize);
	        		if(-1 != jsonObj.getString("name").indexOf("-")){
	        			String [] temp = jsonObj.getString("name").split("-");
	        			if(!"打印".equals(temp[1])){
	        				nowFormStatus = "未"+temp[1];
	        			}
	        		}
	        	}
	        	workflowSize++;
			}			
		}
		//升序排序 
		Collections.sort(indexList);
		//反转后变成降序
		Collections.reverse(indexList);
		//取出最大节点
		int MaxIndex = 0;
		JSONObject jsonObj = null;
		Iterator iterator = nodesJson.keys();
		while(iterator.hasNext()){
			String key = (String) iterator.next();
			String value = nodesJson.getString(key);
			jsonObj = JSONObject.fromObject(value);
			if(indexList.get(0).intValue() == MaxIndex)
			{
				break;
			}
			MaxIndex++;
		}		
    	//工作流节点类型
    	String type = jsonObj.getString("type");
    	//提交状态：0未提交 1待审核 2审核中 3已通过 4未通过
    	String submitStatus = "1";
    	//如果最大节点为确认者节点，则为第一层提交状态
    	if("node".equals(type)){
    		nowStatus = "0";
    		nextStatus = "1";
    	}
    	else{
    		//工作流节点索引
    		int index = indexList.get(0);
    		nowStatus = String.valueOf(index);
    		//达到最后一位 下一级状态 设置-1(结束) 并更新 提交状态为   已通过（提交状态：-1撤回 0未提交 1待审核 2审核中 3已通过 4未通过）
    		if(indexList.get(0).intValue() == workflowSize-1)
    		{
    			nextStatus = "-1";
    			//form 状态也要更新
    			formStatus = nowStatus;	    			
    			submitStatus = "3";
    		}else{
    			nextStatus = String.valueOf(index + 1);
    		}	
    	}

		//开始插入数据
//		//时间
		int nowTime = DateUtils.getSecondTimestamp(new Date());
		String approveUser = String.valueOf(request.getSession().getAttribute("realName"));		
		//formId 0 新添加   有的话从 request中获取
		int formId = 0;
		FlxoaApproveForm flxoaApproveForm = new FlxoaApproveForm();
		if(null != request.getParameter("formId"))
		{
			formId = Integer.parseInt(request.getParameter("formId"));
			flxoaApproveForm.setId(formId);
			flxoaApproveForm = flxoaApproveFormService.queryById(flxoaApproveForm);
		}
		//当前状态
		flxoaApproveForm.setStatus(nowStatus);
		//提交状态
		flxoaApproveForm.setSubmitStatus(submitStatus);
		//工作流id
		flxoaApproveForm.setWorkflowId(queryWorkFlow.getId());
		//确认人ids
		flxoaApproveForm.setCheckUserIds("");
		//设置未读状态
		flxoaApproveForm.setIsRead("0");
		//设置当前特殊状态
		flxoaApproveForm.setNowFormStatus(nowFormStatus);
		flxoaApproveForm.setSubmitTime(nowTime);
		boolean formFlag = false;
		boolean dataFlag = false;
		boolean logFlag = false;
		if(0 == formId){
			//模板id
			flxoaApproveForm.setTemplateId(templateId);
			formFlag = flxoaApproveFormService.add(flxoaApproveForm);
			formId = flxoaApproveForm.getId();
			//保存申请记录
			if(formFlag){
				//遍历list 并保存数据到数据库
				for (FlxoaApproveFormdata flxoaApproveFormdata : listFormdata) {
					flxoaApproveFormdata.setFormId(formId);
					dataFlag = flxoaApproveFormdataService.add(flxoaApproveFormdata);					
				}
				//项目立项申请
				if(29 == templateId){
					//通过状态  为 通过时 更新为已立项1
					if("3".equals(submitStatus)){
						updataProject(listFormdata,"1",true);
					}else{
						updataProject(listFormdata,"0",true);
					}
				}
				//50投标报名申请 
				else if(50 == templateId){
					//通过状态  为 通过时 更新为已报名2
					if("3".equals(submitStatus)){
						updataBid(listFormdata,"2",true);
					}else{
						updataBid(listFormdata,"1",true);
					}
				}
				//31项目投标审批表
				else if(31 == templateId){
					//更新为投标中4
					updataBid(listFormdata,"4",true);
				}
				//49请假申请表
				else if(49 == templateId){
					//插入考勤详情表
					updataSign(listFormdata,userMap);
				}				
			}			
		}else{
			formFlag = flxoaApproveFormService.update(flxoaApproveForm);
			//修改申请记录
			if(formFlag){
				//遍历list 并更新数据到数据库
				for (FlxoaApproveFormdata flxoaApproveFormdata : listFormdata) {
					flxoaApproveFormdata.setFormId(formId);
					//根据formID和dataKey 查出数据库flxoa_approve_formdata对应的数据项
					FlxoaApproveFormdata queryEntity = flxoaApproveFormdataService.queryByEntity(flxoaApproveFormdata);
					queryEntity.setDataValue(flxoaApproveFormdata.getDataValue());
					dataFlag = flxoaApproveFormdataService.update(queryEntity);					
				}
				//项目立项申请
				if(29 == templateId){
					//通过状态  为 通过时 更新为已立项
					if("3".equals(submitStatus)){
						updataProject(listFormdata,"1",true);
					}else{
						updataProject(listFormdata,"0",true);
					}
				}
				//50投标报名申请 
				else if(50 == templateId){
					//通过状态  为 通过时 更新为已报名2
					if("3".equals(submitStatus)){
						updataBid(listFormdata,"2",true);
					}else{
						updataBid(listFormdata,"1",true);
					}
				}
				//31项目投标审批表
				else if(31 == templateId){
					//更新为投标中4
					updataBid(listFormdata,"4",true);
				}
				//49请假申请表
				else if(49 == templateId){
					//插入考勤详情表
					updataSign(listFormdata,userMap);
				}				
			}
		}
		//保存审批记录
		FlxoaApproveFormlog flxoaApproveFormlog = new FlxoaApproveFormlog();
		//审批时间
		flxoaApproveFormlog.setApproveTime(nowTime);
		//审批用户
		flxoaApproveFormlog.setApproveUser(approveUser);
		//当前状态
		flxoaApproveFormlog.setNowStatus(nowStatus);
		//下一级状态
		flxoaApproveFormlog.setNextStatus(nextStatus);
		//formId
		flxoaApproveFormlog.setFormId(formId);
		//设置备注
		flxoaApproveFormlog.setApproveRemark(approveUser+"提交");
		//审批意见
		flxoaApproveFormlog.setApproveIdea("");		
		logFlag = flxoaApproveFormlogService.add(flxoaApproveFormlog);
		//0 失败  1成功
		String result="0";
		if (formFlag && dataFlag && logFlag) {
			result = "1";
		}
		return result;
	}

	/**
	 * 审核数据
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/approve/check")
	@ResponseBody
	public String check(HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		//formId
		int formId = 0;
		//时间
		int nowTime = DateUtils.getSecondTimestamp(new Date());
		boolean formFlag = false;
		boolean logFlag = false;		
		FlxoaApproveForm flxoaApproveForm = new FlxoaApproveForm();
		int userId = Integer.parseInt(String.valueOf(request.getSession().getAttribute("userId")));		
		//保存审批记录
		FlxoaApproveFormlog flxoaApproveFormlog = new FlxoaApproveFormlog();		
		if(null != request.getParameter("formId"))
		{
			formId = Integer.parseInt(request.getParameter("formId"));
			flxoaApproveForm.setId(formId);
			flxoaApproveForm = flxoaApproveFormService.queryById(flxoaApproveForm);
		}
		//获取页面点击操作  审批意见1通过 2不通过 3退回 4确认
		String approveIdea = request.getParameter("approveIdea");
		//确认时，不需要更改审批流程,只记录确认者 审批备注信息
		if(!"4".equals(approveIdea)){
			//获取提交者、角色、所在部门，  读取 模板id对应的工作流，插入数据并插入 工作流当前用户角色提交的下一步状态
			//当前角色
			String role = Permission.getRolesByUserId(userId);		
			//根据审核数据的工作流id获取 工作流json
			//FlxoaApproveWorkflow queryWorkFlow = getWorkflowJsonById(templateId,departmentId);
			FlxoaApproveWorkflow flxoaApproveWorkflow = new FlxoaApproveWorkflow();
			flxoaApproveWorkflow.setId(flxoaApproveForm.getWorkflowId());
			FlxoaApproveWorkflow queryWorkFlow = flxoaApproveWorkflowService.queryById(flxoaApproveWorkflow);
			String workflowJson = queryWorkFlow.getWorkflowJson();
			if("".equals(workflowJson))
			{
				return "0";
			}
			JSONObject rootWorkflowJson = JSONObject.fromObject(workflowJson);
			String nodes = rootWorkflowJson.getString("nodes");
			//form 状态
			String formStatus = "";		
			//当前状态
			String nowStatus = "";
			//下一级状态
			String nextStatus = "";
			JSONObject nodesJson = JSONObject.fromObject(nodes);
			//角色信息
			List<String> roleList = new ArrayList<String>();
			if(role.indexOf(",") != -1){
				String [] roles =  role.split(",");
				for (String temp : roles) {
					roleList.add(temp);
				}
			}
			else
			{
				roleList.add(role);
			}
			
			//保存工作流节点与角色信息匹配的索引
			List<Integer> indexList = new ArrayList<Integer>();
			int workflowSize = 0;
			//设置当前特殊状态
			String nowFormStatus = "";			
			for (int i = 0; i < roleList.size(); i++) {
				workflowSize = 0;
				Iterator iterator = nodesJson.keys();
				while(iterator.hasNext()){
					String key = (String) iterator.next();
					String value = nodesJson.getString(key);
					JSONObject jsonObj = JSONObject.fromObject(value);
					//工作流节点名称
					String name = getNowName(jsonObj.getString("name"));
		        	//获取角色所在的位置索引,保存索引值 用来确认 走更高层角色的审批
		        	if(roleList.get(i).equals(name)){
		        		indexList.add(workflowSize);
		        		if(-1 != jsonObj.getString("name").indexOf("-")){
		        			String [] temp = jsonObj.getString("name").split("-");
		        			if(!"打印".equals(temp[1])){
		        				nowFormStatus = "未"+temp[1];
		        				flxoaApproveForm.setNowFormStatus(nowFormStatus);
		        			}
		        		}		        		
		        	}
		        	workflowSize++;
				}			
			}
			//升序排序 
			Collections.sort(indexList);
			//反转之后 降序
			Collections.reverse(indexList);
	    	//提交状态：0未提交 1待审核 2审核中 3已通过 4未通过
	    	String submitStatus = "2";
			//工作流节点索引
			int index = indexList.get(0);
			nowStatus = String.valueOf(index);

			//根据操作 确定下一步状态以及提交状态
			if("1".equals(approveIdea)){
				//达到最后一位 下一级状态 设置-1(结束) 并更新 提交状态  （提交状态：-1撤回 0未提交 1待审核 2审核中 3已通过 4未通过）
				if(indexList.get(0).intValue() == workflowSize-1)
				{
					nextStatus = "-1";
					//form 状态也要更新
					formStatus = nextStatus;	
					submitStatus = "3";
					//29项目立项申请表	 更新formData表 
					if(29 == flxoaApproveForm.getTemplateId().intValue()){
						FlxoaApproveFormdata flxoaApproveFormdata = new FlxoaApproveFormdata();
						flxoaApproveFormdata.setFormId(flxoaApproveForm.getId().intValue());
						flxoaApproveFormdata.setDataKey("projNumber");
						//项目编号
						String approveProjectNo = request.getParameter("approveProjectNo");
						//根据formID和dataKey 查出数据库flxoa_approve_formdata对应的数据项
						FlxoaApproveFormdata queryEntity = flxoaApproveFormdataService.queryByEntity(flxoaApproveFormdata);
						queryEntity.setDataValue(approveProjectNo);
						flxoaApproveFormdataService.update(queryEntity);	
					}					
					//审核通过后对其他表进行插入或更新操作
					approveHandle(flxoaApproveForm.getId(),flxoaApproveForm.getTemplateId());
				}else{
					nextStatus = String.valueOf(index + 1);
					//form 状态也要更新
					formStatus = nowStatus;
				}			
			}else if("2".equals(approveIdea)){
				nextStatus = "-1";
				//form 状态也要更新
				formStatus = nextStatus;		
				submitStatus = "4";
				//审核不通过后对其他表进行插入或更新操作
				approveHandleNotPass(flxoaApproveForm.getId(),flxoaApproveForm.getTemplateId());
			}else if("3".equals(approveIdea)){
				//根据最低角色状态进行退回
				nextStatus = String.valueOf(indexList.get(indexList.size()-1) - 1);
				//form 状态也要更新
				formStatus = nextStatus;	
				//退回状态
				submitStatus = "-1";
			}

			//更新数据
			//当前状态
			flxoaApproveForm.setStatus(formStatus);
			//提交状态
			flxoaApproveForm.setSubmitStatus(submitStatus);
			//清空确认者
			flxoaApproveForm.setCheckUserIds("");
			//设置未读状态
			flxoaApproveForm.setIsRead("0");	
			formFlag = flxoaApproveFormService.update(flxoaApproveForm);
			//审批记录状态添加
			//当前状态
			flxoaApproveFormlog.setNowStatus(nowStatus);
			//下一级状态
			flxoaApproveFormlog.setNextStatus(nextStatus);			
		}else{
			//移除当前已经确认的userIds
			String checkUserIds = flxoaApproveForm.getCheckUserIds();
			checkUserIds = checkUserIds.replace(","+userId+",", ",");
			flxoaApproveForm.setCheckUserIds(checkUserIds);
			formFlag = flxoaApproveFormService.update(flxoaApproveForm);
			//当前状态
			flxoaApproveFormlog.setNowStatus(flxoaApproveForm.getStatus());
			//下一级状态
			flxoaApproveFormlog.setNextStatus(String.valueOf(Integer.parseInt(flxoaApproveForm.getStatus()) +1));				
			formFlag = true;
		}
		
		//审批记录添加
		String approveUser = String.valueOf(request.getSession().getAttribute("realName"));
		//备注信息
		String approveRemark = request.getParameter("approveRemark");
		//审批时间
		flxoaApproveFormlog.setApproveTime(nowTime);
		//审批用户
		flxoaApproveFormlog.setApproveUser(approveUser);
		flxoaApproveFormlog.setFormId(formId);
		//备注
		flxoaApproveFormlog.setApproveRemark(approveRemark);
		//审批意见
		flxoaApproveFormlog.setApproveIdea(approveIdea);
		logFlag = flxoaApproveFormlogService.add(flxoaApproveFormlog);
		//0 失败  1成功
		String result="0";
		if (formFlag && logFlag) {
			result = "1";
		}
		return result;
	}
	
	/**
	 * 审批通过后根据不同的申请表对不同的表进行插入或更新
	 * formId
	 * templateId
	 * */
	private void approveHandle(int formId,int templateId){
		//40飞利信支票领用单  插入发票表flxoa_project_invoice
		if(40 == templateId){
			//发票类型：0：收入 1：支出
			String invoiceType = "1";
			saveProjectInvoice(formId,invoiceType);
		}
		//43开票申请单	 插入发票表flxoa_project_invoice
		if(43 == templateId){
			//发票类型：0：收入 1：支出
			String invoiceType = "0";
			saveProjectInvoice(formId,invoiceType);
		}
		//29项目立项申请表	 更新项目信息表 flxoa_project_information
		if(29 == templateId){
			FlxoaApproveFormdata flxoaApproveFormdata = new FlxoaApproveFormdata();
			flxoaApproveFormdata.setFormId(formId);
			List<FlxoaApproveFormdata> formdataList = flxoaApproveFormdataService.query(flxoaApproveFormdata);
			updataProject(formdataList,"1",true);
		}
		//50投标报名申请  更新投标信息表 flxoa_project_information
		if(50 == templateId){
			FlxoaApproveFormdata flxoaApproveFormdata = new FlxoaApproveFormdata();
			flxoaApproveFormdata.setFormId(formId);
			List<FlxoaApproveFormdata> formdataList = flxoaApproveFormdataService.query(flxoaApproveFormdata);
			//通过状态  为 通过时 更新为已报名2
			updataBid(formdataList,"2",false);
		}
		//34投标项目失败报告 35流标报告 54弃标报告 56中标信息表  更新投标信息表 flxoa_project_information
		if(34 == templateId 
			|| 35 == templateId
			|| 54 == templateId
			|| 56 == templateId){
			FlxoaApproveFormdata flxoaApproveFormdata = new FlxoaApproveFormdata();
			flxoaApproveFormdata.setFormId(formId);
			List<FlxoaApproveFormdata> formdataList = flxoaApproveFormdataService.query(flxoaApproveFormdata);
			//通过状态  为 通过时 更新为投标结束5
			updataBid(formdataList,"5",false);
		}		
	}
	
	//保存项目发票
	private void saveProjectInvoice(int formId,String invoiceType){
		FlxoaProjectInvoice flxoaProjectInvoice = new FlxoaProjectInvoice();
		flxoaProjectInvoice.setAccessory("");
		flxoaProjectInvoice.setAccessoryStatus("0");//0未上传附件
		flxoaProjectInvoice.setInvoiceId(formId);
		flxoaProjectInvoice.setInvoiceType(invoiceType);
		flxoaProjectInvoiceService.add(flxoaProjectInvoice);		
	}
	
	/**
	 * 审批未通过后根据不同的申请表对不同的表进行插入或更新
	 * formId
	 * templateId
	 * */
	private void approveHandleNotPass(int formId,int templateId){
		//31项目投标审批表  更新投标信息表 flxoa_project_information
		if(31 == templateId){
			FlxoaApproveFormdata flxoaApproveFormdata = new FlxoaApproveFormdata();
			flxoaApproveFormdata.setFormId(formId);
			List<FlxoaApproveFormdata> formdataList = flxoaApproveFormdataService.query(flxoaApproveFormdata);
			//通过状态  为 通过时 更新为3:投标准备中
			updataBid(formdataList,"3",false);
		}
	}

	/**
	 * 添加确认人
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/approve/addcheckuser")
	@ResponseBody
	public String addCheckUser(HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		int formId = Integer.parseInt(request.getParameter("formId"));
		String checkUserIds = request.getParameter("checkUserIds");
		boolean flag = false;
		FlxoaApproveForm flxoaApproveForm = new FlxoaApproveForm();
		flxoaApproveForm.setId(formId);
		flxoaApproveForm = flxoaApproveFormService.queryById(flxoaApproveForm);
		flxoaApproveForm.setCheckUserIds(checkUserIds);
		flag = flxoaApproveFormService.update(flxoaApproveForm);
		//0 失败  1成功
		String result="0";
		if (flag) {
			result = "1";
		}
		return result;
	}
	
	/**
	 * 更新form的最新审批备注读取状态为已读状态
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/approve/readremark")
	@ResponseBody
	public String readRemark(HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		int formId = Integer.parseInt(request.getParameter("formId"));
		boolean flag = false;
		FlxoaApproveForm flxoaApproveForm = new FlxoaApproveForm();
		flxoaApproveForm.setId(formId);
		flxoaApproveForm = flxoaApproveFormService.queryById(flxoaApproveForm);
		flxoaApproveForm.setIsRead("1");
		flag = flxoaApproveFormService.update(flxoaApproveForm);
		//0 失败  1成功
		String result="0";
		if (flag) {
			result = "1";
		}
		return result;
	}
	
	/**
	 * 查询确认人状态
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/approve/getcheckuserstatus")
	@ResponseBody
	public String getCheckUserStatus(HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		int formId = Integer.parseInt(request.getParameter("formId"));
		FlxoaApproveForm flxoaApproveForm = new FlxoaApproveForm();
		flxoaApproveForm.setId(formId);
		flxoaApproveForm = flxoaApproveFormService.queryById(flxoaApproveForm);
		List<FlxoaApproveForm> list = flxoaApproveFormService.queryChechUserApproveFormLog(flxoaApproveForm);
		JSONArray json = JSONArray.fromObject(list);
		return json.toString();
	}	
	
	/**
	 * 根据模板id返回json
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/approve/look")
	@ResponseBody
	public String look(HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		//根据申请模板id
		int templateId = Integer.parseInt(request.getParameter("templateId"));		
		//查询出模板json
		FlxoaApproveFormtemplate flxoaApproveFormtemplate = new FlxoaApproveFormtemplate();
		flxoaApproveFormtemplate.setId(templateId);
		FlxoaApproveFormtemplate queryFormData = flxoaApproveFormtemplateService.queryById(flxoaApproveFormtemplate);
		String json = queryFormData.getLayout();
		return json;
	}
	
	/**
	 * 根据form id返回formData
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/approve/getformdata")
	@ResponseBody
	public String getFormData(HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		//form id
		int formId = Integer.parseInt(request.getParameter("formId"));		
		FlxoaApproveFormdata formdata = new FlxoaApproveFormdata();
		formdata.setFormId(formId);
		List<FlxoaApproveFormdata> formdataList = flxoaApproveFormdataService.query(formdata);
		JSONArray json = JSONArray.fromObject(formdataList);
		return json.toString();
	}

	/**
	 * 根据form id templateId 返回 json模板 以及 数据
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/approve/getformdatadetail")
	@ResponseBody
	public String getFormDataDetail(HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		//form id
		int formId = Integer.parseInt(request.getParameter("formId"));	
		FlxoaApproveFormdata formdata = new FlxoaApproveFormdata();
		formdata.setFormId(formId);
		//查询formdata 数据
		List<FlxoaApproveFormdata> formdataList = flxoaApproveFormdataService.query(formdata);
		int templateId = 0;
		if(null != request.getParameter("templateId")){
			templateId = Integer.parseInt(request.getParameter("templateId"));		
		}else{
			FlxoaApproveForm flxoaApproveForm = new FlxoaApproveForm();
			flxoaApproveForm.setId(formId);
			flxoaApproveForm = flxoaApproveFormService.queryById(flxoaApproveForm);
			templateId = flxoaApproveForm.getTemplateId().intValue();
		}
		//查询出模板json
		FlxoaApproveFormtemplate flxoaApproveFormtemplate = new FlxoaApproveFormtemplate();
		flxoaApproveFormtemplate.setId(templateId);
		FlxoaApproveFormtemplate queryFormData = flxoaApproveFormtemplateService.queryById(flxoaApproveFormtemplate);
		String json = queryFormData.getLayout();
		JSONObject rootJson = JSONObject.fromObject(json);
		String names = rootJson.getString("names");
		JSONArray jsonArray = JSONArray.fromObject(names);
		//嵌套list  需要定义classMap
		Map classMap = new HashMap();
		classMap.put("list_items",ApproveFormDataJsonBean.class);
		List<ApproveFormDataJsonBean> list = (List<ApproveFormDataJsonBean>) JSONArray.toList(jsonArray,ApproveFormDataJsonBean.class,classMap);
		//List<ApproveFormDataJsonBean> list = JSONArray.toList(jsonArray,ApproveFormDataJsonBean.class);		
		//把模板json key 对应的formdata  存放数据
		for (int i = 0; i < formdataList.size(); i++) {
			for (int j = 0; j < list.size(); j++) {
				if(formdataList.get(i).getDataKey().equals(list.get(j).getKey())){
					list.get(j).setValue(formdataList.get(i).getDataValue());
				}
				if(list.get(j).getList_items().size() > 0){
					for (int k = 0; k < list.get(j).getList_items().size() ; k++) {
						if(formdataList.get(i).getDataKey().equals(list.get(j).getList_items().get(k).getKey())){
							list.get(j).getList_items().get(k).setValue(formdataList.get(i).getDataValue());
						}						
					}
				}
			}
		}
		JSONArray result = JSONArray.fromObject(list);
		return result.toString();
	}
	
	/**
	 * 手机端根据form id templateId 返回 json模板 以及 数据
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/approve/getAppFormDataDetail")
	@ResponseBody
	public String getAppFormDataDetail(HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		//查找所有枚举
		List<FlxoaSystemEnumeration> systemEnumeration = flxoaSystemEnumerationService.query(null);	
		//form id
		int formId = Integer.parseInt(request.getParameter("formId"));	
		FlxoaApproveFormdata formdata = new FlxoaApproveFormdata();
		formdata.setFormId(formId);
		//查询formdata 数据
		List<FlxoaApproveFormdata> formdataList = flxoaApproveFormdataService.query(formdata);
		int templateId = 0;
		if(null != request.getParameter("templateId")){
			templateId = Integer.parseInt(request.getParameter("templateId"));		
		}else{
			FlxoaApproveForm flxoaApproveForm = new FlxoaApproveForm();
			flxoaApproveForm.setId(formId);
			flxoaApproveForm = flxoaApproveFormService.queryById(flxoaApproveForm);
			templateId = flxoaApproveForm.getTemplateId().intValue();
		}
		//查询出模板json
		FlxoaApproveFormtemplate flxoaApproveFormtemplate = new FlxoaApproveFormtemplate();
		flxoaApproveFormtemplate.setId(templateId);
		FlxoaApproveFormtemplate queryFormData = flxoaApproveFormtemplateService.queryById(flxoaApproveFormtemplate);
		String json = queryFormData.getLayout();
		JSONObject rootJson = JSONObject.fromObject(json);
		String names = rootJson.getString("names");
		JSONArray jsonArray = JSONArray.fromObject(names);
		//嵌套list  需要定义classMap
		Map classMap = new HashMap();
		classMap.put("list_items",ApproveFormDataJsonBean.class);
		List<ApproveFormDataJsonBean> list = (List<ApproveFormDataJsonBean>) JSONArray.toList(jsonArray,ApproveFormDataJsonBean.class,classMap);
		//List<ApproveFormDataJsonBean> list = JSONArray.toList(jsonArray,ApproveFormDataJsonBean.class);		
		//把模板json key 对应的formdata  存放数据
		for (int i = 0; i < formdataList.size(); i++) {
			for (int j = 0; j < list.size(); j++) {
				//判断json中的Enumeration_name是否有值为true直接给组装的json串value赋值，为false是走下一步
				if(list.get(j).getEnumeration_name().equals("")) {
					if(formdataList.get(i).getDataKey().equals(list.get(j).getKey())){
						list.get(j).setValue(formdataList.get(i).getDataValue());
					}
				}else {
					//判断枚举表中的EnumerationName是否与json中的Enumeration_name值相等，如为true则循环枚举表，并比较formdataList中的DataValue与
					//枚举表中的EnumerationKey，将相等的值赋予json中的value
					//循环枚举表
					for (int l = 0; l < systemEnumeration.size(); l++) {
						if(systemEnumeration.get(l).getEnumerationName().equals(list.get(j).getEnumeration_name())) {
							if(formdataList.get(i).getDataValue().equals(systemEnumeration.get(l).getEnumerationKey())) {
								
								if(formdataList.get(i).getDataValue().contains(",")) {
									String arry = formdataList.get(i).getDataValue();
									List  arryValueList = Arrays.asList(arry);
									List<String> arryList=new ArrayList<String>();
									for(int v = 0; v < arryValueList.size(); v ++) {
										if(arryValueList.get(v).equals(systemEnumeration.get(l).getEnumerationKey())){
											arryList.add(systemEnumeration.get(l).getEnumerationValue());
										}
									}
									list.get(j).setValue(arryList.toString());
								}else{
									list.get(j).setValue(systemEnumeration.get(l).getEnumerationValue());
								}
								}
						}
					}
				}
				
				if(list.get(j).getList_items().size() > 0){
					for (int k = 0; k < list.get(j).getList_items().size() ; k++) {
						if(formdataList.get(i).getDataKey().equals(list.get(j).getList_items().get(k).getKey())){
							list.get(j).getList_items().get(k).setValue(formdataList.get(i).getDataValue());
						}						
					}
				}
				
				
			}
		}
		JSONArray result = JSONArray.fromObject(list);
		return result.toString();
	}	
		
	/**
	 * 查询项目列表
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/approve/gotoprojectinfo")
	public String gotoProjectInfo(HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		return "nk/pages/approval/publicproject";
	}
	
	/**
	 * 查询项目列表json
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/approve/getprojectinfo")
	@ResponseBody
	public String getProjectInfo(HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		int userId = 0;
		String deptIds = "";
		//申请表模板id
		String templateId = request.getParameter("templateId");
		//项目编号
		String projectNo = request.getParameter("selectProjectNo");
		//项目名称
		String projectName = request.getParameter("selectProjectName");
		String start = request.getParameter("start");
		String length  = request.getParameter("length");
		FlxoaProjectInformation flxoaProjectInformation = new FlxoaProjectInformation();
		if(projectNo != null){
			if(!"".equals(projectNo)){
				flxoaProjectInformation.setProjNumber(projectNo);
			}
		}
		if(projectName != null){
			if(!"".equals(projectName)){
				flxoaProjectInformation.setProjName(projectName);
			}			
		}
		if(templateId != null){
			//项目立项申请表模板id
			if("29".equals(templateId)){
				userId = Integer.parseInt(String.valueOf(request.getSession().getAttribute("userId")));
				//查询项目编号为空的
				flxoaProjectInformation.setSelectProjectNoHas("0");
			}else{
				//查询项目编号不为空的
				flxoaProjectInformation.setSelectProjectNoHas("1");
			}			
		}		
		ConcurrentHashMap<String, Object>	map  = flxoaProjectInformationService.query(flxoaProjectInformation,userId,deptIds,Integer.valueOf(start),Integer.valueOf(length));
		JSONArray json = JSONArray.fromObject(map);
		return json.toString();
	}
	
	/**
	 * 查询项目有关的申请表数据json
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/approve/getprojectform")
	@ResponseBody
	public String getProjectFrom(HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		//项目id
		String id = request.getParameter("id");

		//查询form data和项目id有关的form id
		FlxoaApproveFormdata flxoaApproveFormdata = new FlxoaApproveFormdata();
		flxoaApproveFormdata.setProjectId(id);
		List<FlxoaApproveFormdata> formdataList = flxoaApproveFormdataService.query(flxoaApproveFormdata);		
		List<Map<String,String>> mapList = new ArrayList<Map<String,String>>();
		//通过form id 获取 form data 相关数据
		String formIds = "";
		for (int i = 0; i < formdataList.size(); i++) {
			formIds += formdataList.get(i).getFormId()+",";
		}
		if(!"".equals(formIds)){
			formIds = formIds.substring(0,formIds.length()-1);
			FlxoaApproveFormdata dataFormIds = new FlxoaApproveFormdata();
			dataFormIds.setFormIds(formIds);
			//获取和项目id有关的所有申请表数据
			List<FlxoaApproveFormdata> list = flxoaApproveFormdataService.queryProjectForm(dataFormIds);
			
			int formId = 0;
			Map<String,String> map = null;
			String resultFormIds = "";
			Map<String,String> resultValues = new HashMap<String, String>();
			for (int i = 0; i < list.size(); i++) {
				if(formId != list.get(i).getFormId().intValue()){
					map = new LinkedHashMap<String, String>();
					mapList.add(map);
				}
				map.put("formId", String.valueOf(list.get(i).getFormId().intValue()));
				map.put("templateId", String.valueOf(list.get(i).getTemplateId().intValue()));
				map.put("templateName",list.get(i).getTemplateName());
				//map.put(list.get(i).getDataKey()+"-"+list.get(i).getDataDescription(), list.get(i).getDataValue());
				map.put(list.get(i).getDataKey(), list.get(i).getDataValue());
				//报销申请单
				if(list.get(i).getTemplateId().intValue() == 48){
					//合计金额
					if("reim_money_sum".equals(list.get(i).getDataKey())){
						resultFormIds += list.get(i).getFormId().intValue()+",";
						resultValues.put(String.valueOf(list.get(i).getFormId().intValue()), list.get(i).getDataValue());					
					}
				}
				formId = list.get(i).getFormId().intValue();
			}
			//统计已打款金额
			if(!"".equals(resultFormIds)){
				//合计金额
				BigDecimal sum = new BigDecimal(0);
				resultFormIds = resultFormIds.substring(0,resultFormIds.length()-1);
				FlxoaApproveForm flxoaApproveForm = new FlxoaApproveForm();
				flxoaApproveForm.setFormIds(resultFormIds);
				String start = request.getParameter("start"); 
				String length = request.getParameter("length");
				ConcurrentHashMap<String, Object> currmap = null;
				List<FlxoaApproveForm > listForm = null;
				if((!"".equals(start) && null != start) && (!"".equals(length) && null != length)){
					 currmap = flxoaApproveFormService.query(start,length,flxoaApproveForm); 
					 listForm =(List<FlxoaApproveForm>) currmap.get("data");

				}else{
					 listForm = flxoaApproveFormService.query(flxoaApproveForm);
				}
				for (int i = 0; i < listForm.size(); i++) {
					if(!"已打款".equals(listForm.get(i).getNowFormStatus())){
						resultValues.remove(String.valueOf(listForm.get(i).getId().intValue()));
					}
				}
				//遍历map
				for (Entry<String, String> entry : resultValues.entrySet()) {
					sum = sum.add(new BigDecimal(entry.getValue()));
				}
				if(mapList.size() > 0){
					for (int i = 0; i < mapList.size(); i++) {
						mapList.get(i).put("proj_total_cost_return", sum.toString());
						//mapList.get(i).put("proj_total_cost_return-本项目总费用(元)", sum.toString());
					}
				}
			}			
		}
		
		JSONArray json = JSONArray.fromObject(mapList);
		return json.toString();
	}	
	
	/**
	 * 报销添加页面
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/approve/gotoexpenseaccount")
	public String gotoExpenseAccount(HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		return "nk/pages/approval/expenseaccount";
	}
	
	/**
	 * 查询业务招待申请列表
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/approve/gotobusinesshospitality")
	public String gotoBusinessHospitality(HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		return "nk/pages/approval/businesshospitality";
	}
	
	/**
	 * 查询业务招待申请列表json
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/approve/getbusinesshospitality")
	@ResponseBody
	public String getBusinessHospitality(HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		return "";
	}	
	
	/**
	 * 根据枚举名称返回json
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/approve/getenumeration")
	@ResponseBody
	public String getEnumeration(HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		//根据枚举名称
		String enumerationName = request.getParameter("enumerationName");		
		FlxoaSystemEnumeration flxoaSystemEnumeration = new FlxoaSystemEnumeration();
		flxoaSystemEnumeration.setEnumerationName(enumerationName);
		List<FlxoaSystemEnumeration> list = flxoaSystemEnumerationService.query(flxoaSystemEnumeration);
		JSONArray json = JSONArray.fromObject(list);
		System.out.println(json.toString());
		return json.toString();
	}	
	
	
	/**
	 * 我的申请列表
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */	
	@RequestMapping(value = "/approve/gomyapplicationformlist")
	public String goMyApplicationFormList(HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		return "nk/pages/approval/myapplicationformlist";
	}
	
	/**
	 * 我的申请列表json
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/approve/myapplicationformlist")
	@ResponseBody
	public String myApplicationFormList(HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		//申请人 UserID
		int createUserId = Integer.parseInt(String.valueOf(request.getSession().getAttribute("userId")));
		FlxoaApproveForm flxoaApproveForm = new FlxoaApproveForm();
		flxoaApproveForm.setCreateUserId(createUserId);
		//分页
		String start = request.getParameter("start"); 
		String length = request.getParameter("length");
		//开始和结束时间
		String time = request.getParameter("time");
		//类型
		String approveType = request.getParameter("approveType");
		//审批状态
		String approveStatus = request.getParameter("approveStatus");
		//首頁
		String statues = request.getParameter("more");
		if(!CommonUtils.isEmpty(statues)){
			flxoaApproveForm.setStates(statues);
		}
		//关键字检索英文名称
		String keywordName = request.getParameter("keywordName");		
		if(!CommonUtils.isEmpty(keywordName)){
			flxoaApproveForm.setKeywordName(keywordName);
		}
		//关键字检索选择或者输入的值
		String keywordValue = request.getParameter("keywordValue");		
		if(!CommonUtils.isEmpty(keywordValue)){
			flxoaApproveForm.setKeywordValue(keywordValue);
		}
		//关键字类型
		String keywordType = request.getParameter("keywordType");
		if(!CommonUtils.isEmpty(keywordType)){
			flxoaApproveForm.setKeywordType(keywordType);
		}
		//项目名称
		String projectName = request.getParameter("projectName");
		if(!CommonUtils.isEmpty(projectName)){
			flxoaApproveForm.setProjName(projectName);
		}
		//项目编号
		String projectNo = request.getParameter("projectNo");
		if(!CommonUtils.isEmpty(projectNo)){
			flxoaApproveForm.setProjNumber(projectNo);
		}
		//特殊状态
		String nowFormStatus = request.getParameter("nowFormStatus");
		if(!CommonUtils.isEmpty(nowFormStatus)){
			flxoaApproveForm.setNowFormStatus(nowFormStatus);
		}		
		if(time != null)
		{
			if(!"全部".equals(time)){
				if(time.indexOf("-") != -1){
					String [] temp = time.split("-");
					if(!"".equals(temp[0])){
						flxoaApproveForm.setStartTime(DateUtils.dateToTimestamp(temp[0],"yyyy/MM/dd"));
					}
					if(!"".equals(temp[1])){
						flxoaApproveForm.setEndTime(DateUtils.dateToTimestamp(temp[1],"yyyy/MM/dd"));
					}
				}else{
					if(!"".equals(time)){
						int setTime = DateUtils.dateToTimestamp(time,"yyyy/MM/dd");
						flxoaApproveForm.setStartTime(setTime);
						flxoaApproveForm.setEndTime(setTime);						
					}
				}
			}
		}
		if(approveType != null){
			if(!"".equals(approveType)){
				flxoaApproveForm.setApproveType(approveType);
			}
		}
		if(approveStatus != null){
			if(!"".equals(approveStatus)){
				flxoaApproveForm.setApproveStatus(approveStatus);
			}			
		}
		//按创建时间排序
		flxoaApproveForm.setOrderBy("create_time");
		//页面展示申请类型 申请时间 项目编号 项目名称 状态 审批进度 关键字
		//查询(申请类型  申请时间  项目编号  项目名称  状态  审批进度  申请表模板id id 创建者部门id)
		
		String listJson = null;
		if((null != start && !"".equals(start)) && (null != length && !"".equals(length))){
			
			listJson = getApproveListJosn(start,length,flxoaApproveForm);
		}else{
			listJson = getApproveListJosn(flxoaApproveForm);

		}
		return listJson;
	}
	
	/**
	 * 删除我的申请
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/approve/deletemyapplicationform")
	@ResponseBody
	public String deleteMyApplicationForm(HttpServletRequest request,HttpServletResponse response, FlxoaApproveForm model) {
		FlxoaApproveForm flxoaApproveForm = flxoaApproveFormService.queryById(model);
		boolean flag = flxoaApproveFormService.delete(flxoaApproveForm);
		//0失败 1成功
		String result="0";
		if (flag) {
			result = "1";
		}
		return result;
	}
	
	/**
	 * 撤回我的申请
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/approve/backmyapplicationform")
	@ResponseBody
	public String backMyApplicationForm(HttpServletRequest request,HttpServletResponse response, FlxoaApproveForm model) {
		FlxoaApproveForm flxoaApproveForm = flxoaApproveFormService.queryById(model);
		System.out.println("formid======"+model.getId());//delete	
		//删除撤回申请的审批流程 
		FlxoaApproveFormlog flxoaApproveFormlog = new FlxoaApproveFormlog();
		flxoaApproveFormlog.setFormId(model.getId());
		
		boolean flag1= flxoaApproveFormlogService.deleteLog(flxoaApproveFormlog);
		System.out.println(flag1);
		String result="0";
		//审批流程删除成功，申请表申请 提交状态：未提交 为“0”，流程状态：初始状态‘-1’ 
		if(flag1){
			//流程状态：初始状态
			flxoaApproveForm.setStatus("-1");
			//提交状态：未提交 
			flxoaApproveForm.setSubmitStatus("0");
			boolean flag = flxoaApproveFormService.update(flxoaApproveForm);
			//0失败 1成功
			if (flag) {
				result = "1";
			}			
		}
		return result;
	}
	
	/**
	 * 获取关键字
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/approve/getkeyword")
	@ResponseBody
	public String getKeyWord(HttpServletRequest request,HttpServletResponse response, FlxoaApproveForm model) {
		int templateId = Integer.parseInt(request.getParameter("templateId"));
		FlxoaApproveFormtemplate queryFlxoaApproveFormtemplate = new FlxoaApproveFormtemplate();
		queryFlxoaApproveFormtemplate.setId(templateId);
		//查询申请模板
		FlxoaApproveFormtemplate flxoaApproveFormtemplate = flxoaApproveFormtemplateService.queryById(queryFlxoaApproveFormtemplate);
		//查找所有枚举
		List<FlxoaSystemEnumeration> enumerationList = flxoaSystemEnumerationService.query(null);		
		JSONObject root = JSONObject.fromObject(flxoaApproveFormtemplate.getLayout());
		String names = root.getString("names");
		JSONArray jsonList = JSONArray.fromObject(names);
		//存放关键字及枚举列表信息
		Map<String,List<Map<String,String>>> map = new LinkedHashMap<String,List<Map<String,String>>>();
		for (int j = 0; j < jsonList.size(); j++) {
			JSONObject jsonObj = JSONObject.fromObject(jsonList.get(j));
			//数据项英文名称
			String key = jsonObj.getString("key");			
			//数据项中文名称
			String name = jsonObj.getString("name");
			//数据项类别
			String type = jsonObj.getString("type");			
			//枚举名称
			String enumerationName = jsonObj.getString("enumeration_name");	
			//是否是关键字 0不是  1是 2是 并且是检索条件
			String iskeyword = jsonObj.getString("iskeyword");
			//测试用等于1  实际是2
        	if("1".equals(iskeyword))
        	{
        		//枚举名称
	        	if(!"".equals(enumerationName)){
	        		List<Map<String,String>> enListMap = new ArrayList<Map<String,String>>(); 
	        		for (int i = 0; i < enumerationList.size(); i++) {
						if(enumerationName.equals(enumerationList.get(i).getEnumerationName())){
							Map<String,String> enMap = new LinkedHashMap<String,String>();
							enMap.put("name", enumerationList.get(i).getEnumerationName());
							enMap.put("description", enumerationList.get(i).getEnumerationValue());
							enMap.put("value", enumerationList.get(i).getEnumerationKey());
							enMap.put("id", key);
							enMap.put("type", type);
							enListMap.add(enMap);
						}
					}
	        		map.put(name, enListMap);
	        	}else{
	        		List<Map<String,String>> enListMap = new ArrayList<Map<String,String>>();
	        		Map<String,String> enMap = new LinkedHashMap<String,String>();
					enMap.put("id", key);
					enMap.put("type", type);
					enListMap.add(enMap);
	        		map.put(name, enListMap);
	        	}
        	}
		}
		JSONObject jsonObj = JSONObject.fromObject(map);
		return jsonObj.toString();
	}
	
	/**
	 * 根据templateId返回状态 list json
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/approve/getnowstatusbytemplateid")
	@ResponseBody
	public String getNowStatusByTemplateId(HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		String templateId = request.getParameter("templateId");

		FlxoaApproveForm flxoaApproveForm = new FlxoaApproveForm();
		flxoaApproveForm.setApproveType(templateId);
		List<FlxoaApproveForm> formList = flxoaApproveFormService.query(flxoaApproveForm);
		Map<String,String> map = new LinkedHashMap<String, String>();
		for (int i = 0; i < formList.size(); i++) {
			if(!"".equals(formList.get(i).getNowFormStatus())){
				String temp = formList.get(i).getNowFormStatus();
				temp = temp.replace("未", "").replace("已","");
				map.put(temp, temp);				
			}
		}
		List<String> list = new ArrayList<String>();
		//遍历map
		for (Entry<String, String> entry : map.entrySet()) {
			list.add("未"+entry.getKey());
			list.add("已"+entry.getKey());
		}	
		JSONArray json = JSONArray.fromObject(list);
		return json.toString();
	}
	
	/**
	 * 我的审批列表
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */	
	@RequestMapping(value = "/approve/gomyapprovelist")
	public String goMyApproveList(HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		return "nk/pages/approval/myapprovelist";
	}
	
	/**
	 * 我的审批列表json
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/approve/myapprovelist")
	@ResponseBody
	public String myApproveList(HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		//当前角色
		int userId = Integer.parseInt(String.valueOf(request.getSession().getAttribute("userId")));
		String role = Permission.getRolesByUserId(userId);		
		String url = request.getServletPath()+request.getPathInfo();
		//根据授权 获取能查看的部门ids
		String departmentIds = Permission.getPermissionDepartMentIds(userId, url, false);
		//根据角色查找工作流id 和工作流对应的 角色的位置（审批进度）
		List<FlxoaApproveForm> workList = getWorkflowByRoleName(role);
		
		FlxoaApproveForm flxoaApproveForm = new FlxoaApproveForm();
		flxoaApproveForm.setList(workList);
		flxoaApproveForm.setDepartmentIds(departmentIds);
		flxoaApproveForm.setCheckUserIds(String.valueOf(userId));
		String start = request.getParameter("start"); 
		String length = request.getParameter("length");
		//开始和结束时间
		String time = request.getParameter("time");
		//类型
		String approveType = request.getParameter("approveType");
		//审批状态
		String approveStatus = request.getParameter("approveStatus");
		//申请人
		String realName = request.getParameter("realName");
		//关键字检索英文名称
		String keywordName = request.getParameter("keywordName");		
		if(!CommonUtils.isEmpty(keywordName)){
			flxoaApproveForm.setKeywordName(keywordName);
		}
		//关键字检索选择或者输入的值
		String keywordValue = request.getParameter("keywordValue");		
		if(!CommonUtils.isEmpty(keywordValue)){
			flxoaApproveForm.setKeywordValue(keywordValue);
		}
		//关键字类型
		String keywordType = request.getParameter("keywordType");
		if(!CommonUtils.isEmpty(keywordType)){
			flxoaApproveForm.setKeywordType(keywordType);
		}
		//项目名称
		String projectName = request.getParameter("projectName");
		if(!CommonUtils.isEmpty(projectName)){
			flxoaApproveForm.setProjName(projectName);
		}
		//项目编号
		String projectNo = request.getParameter("projectNo");
		if(!CommonUtils.isEmpty(projectNo)){
			flxoaApproveForm.setProjNumber(projectNo);
		}
		//特殊状态
		String nowFormStatus = request.getParameter("nowFormStatus");
		if(!CommonUtils.isEmpty(nowFormStatus)){
			flxoaApproveForm.setNowFormStatus(nowFormStatus);
		}			
		if(time != null)
		{
			if(!"全部".equals(time)){
				if(time.indexOf("-") != -1){
					String [] temp = time.split("-");
					if(!"".equals(temp[0])){
						flxoaApproveForm.setStartTime(DateUtils.dateToTimestamp(temp[0],"yyyy/MM/dd"));
					}
					if(!"".equals(temp[1])){
						flxoaApproveForm.setEndTime(DateUtils.dateToTimestamp(temp[1],"yyyy/MM/dd"));
					}
				}else{
					if(!"".equals(time)){
						int setTime = DateUtils.dateToTimestamp(time,"yyyy/MM/dd");
						flxoaApproveForm.setStartTime(setTime);
						flxoaApproveForm.setEndTime(setTime);						
					}
				}
			}
		}
		if(approveType != null){
			if(!"".equals(approveType)){
				flxoaApproveForm.setApproveType(approveType);
			}
		}
		if(approveStatus != null){
			if(!"".equals(approveStatus)){
				flxoaApproveForm.setApproveStatus(approveStatus);
			}			
		}
		if(realName != null){
			if(!"".equals(realName)){
				flxoaApproveForm.setRealName(realName);
			}			
		}		

		//页面展示 申请类型 申请时间 项目编号 项目名称 申请人 申请部门 审批状态 审批进度 关键字
		//查询( 申请类型  申请时间  项目编号  项目名称  状态  审批进度  申请表模板id id 创建者部门id)
		String listJson = null;
		if((null != start && !"".equals(start)) && (null != length && !"".equals(length))){
			
			listJson = getApproveListJosn(start,length,flxoaApproveForm);
		}else{
			listJson = getApproveListJosn(flxoaApproveForm);

		}
		
		return listJson;
	}
	
	/**
	 * 我的历史审批列表json
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/approve/myhistoryapprovelist")
	@ResponseBody
	public String myHistoryApproveList(HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		int userId = Integer.parseInt(String.valueOf(request.getSession().getAttribute("userId")));
		//查询自己审批记录的formId
		FlxoaApproveFormlog	flxoaApproveFormlog = new FlxoaApproveFormlog();
		flxoaApproveFormlog.setCreateUserId(userId);
		List<FlxoaApproveFormlog> list = flxoaApproveFormlogService.query(flxoaApproveFormlog);
		String start = request.getParameter("start"); 
		String length = request.getParameter("length");
		String formIds = "";
		for (int i = 0; i < list.size(); i++) {
			formIds += list.get(i).getFormId()+",";
		}
		if(!"".equals(formIds)){
			formIds = formIds.substring(0, formIds.length()-1);
		}
		FlxoaApproveForm flxoaApproveForm = new FlxoaApproveForm();
		flxoaApproveForm.setFormIds(formIds);
		//开始和结束时间
		String time = request.getParameter("time");
		//类型
		String approveType = request.getParameter("approveType");
		//审批状态
		String approveStatus = request.getParameter("approveStatus");
		//申请人
		String realName = request.getParameter("realName");
		//关键字检索英文名称
		String keywordName = request.getParameter("keywordName");		
		if(!CommonUtils.isEmpty(keywordName)){
			flxoaApproveForm.setKeywordName(keywordName);
		}
		//关键字检索选择或者输入的值
		String keywordValue = request.getParameter("keywordValue");		
		if(!CommonUtils.isEmpty(keywordValue)){
			flxoaApproveForm.setKeywordValue(keywordValue);
		}
		//关键字类型
		String keywordType = request.getParameter("keywordType");
		if(!CommonUtils.isEmpty(keywordType)){
			flxoaApproveForm.setKeywordType(keywordType);
		}
		//项目名称
		String projectName = request.getParameter("projectName");
		if(!CommonUtils.isEmpty(projectName)){
			flxoaApproveForm.setProjName(projectName);
		}
		//项目编号
		String projectNo = request.getParameter("projectNo");
		if(!CommonUtils.isEmpty(projectNo)){
			flxoaApproveForm.setProjNumber(projectNo);
		}
		//特殊状态
		String nowFormStatus = request.getParameter("nowFormStatus");
		if(!CommonUtils.isEmpty(nowFormStatus)){
			flxoaApproveForm.setNowFormStatus(nowFormStatus);
		}		
		if(time != null)
		{
			if(!"全部".equals(time)){
				if(time.indexOf("-") != -1){
					String [] temp = time.split("-");
					if(!"".equals(temp[0])){
						flxoaApproveForm.setStartTime(DateUtils.dateToTimestamp(temp[0],"yyyy/MM/dd"));
					}
					if(!"".equals(temp[1])){
						flxoaApproveForm.setEndTime(DateUtils.dateToTimestamp(temp[1],"yyyy/MM/dd"));
					}
				}else{
					if(!"".equals(time)){
						int setTime = DateUtils.dateToTimestamp(time,"yyyy/MM/dd");
						flxoaApproveForm.setStartTime(setTime);
						flxoaApproveForm.setEndTime(setTime);						
					}
				}
			}
		}
		if(approveType != null){
			if(!"".equals(approveType)){
				flxoaApproveForm.setApproveType(approveType);
			}
		}
		if(approveStatus != null){
			if(!"".equals(approveStatus)){
				flxoaApproveForm.setApproveStatus(approveStatus);
			}			
		}
		if(realName != null){
			if(!"".equals(realName)){
				flxoaApproveForm.setRealName(realName);
			}			
		}		

		//页面展示 申请类型 申请时间 项目编号 项目名称 申请人 申请部门 审批状态 审批进度 关键字
		//查询( 申请类型  申请时间  项目编号  项目名称  状态  审批进度  申请表模板id id 创建者部门id)
		String listJson = null;
		if((null != start && !"".equals(start)) && (null != length && !"".equals(length))){
			
			listJson = getApproveListJosn(start,length,flxoaApproveForm);
		}else{
			listJson = getApproveListJosn(flxoaApproveForm);

		}
		return listJson;
	}
	
	/**
	 * 更新form的特殊状态
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/approve/updatestatus")
	@ResponseBody
	public String updateStatus(HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		int formId = Integer.parseInt(request.getParameter("formId"));
		String nowFormStatus = request.getParameter("nowFormStatus");
		boolean flag = false;
		FlxoaApproveForm flxoaApproveForm = new FlxoaApproveForm();
		flxoaApproveForm.setId(formId);
		flxoaApproveForm = flxoaApproveFormService.queryById(flxoaApproveForm);
		flxoaApproveForm.setNowFormStatus(nowFormStatus);
		flag = flxoaApproveFormService.update(flxoaApproveForm);
		//0 失败  1成功
		String result="0";
		if (flag) {
			result = "1";
		}
		return result;
	}
	
	
	/**
	 * 审批监控列表
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */	
	@RequestMapping(value = "/approve/goapprovelist")
	public String goApproveList(HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		
		return "nk/pages/approval/approvelist";
	}
	
	/**
	 * 审批监控列表json
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/approve/approvelist")
	@ResponseBody
	public String approveList(HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		int userId = Integer.parseInt(String.valueOf(request.getSession().getAttribute("userId")));
		String url = request.getServletPath()+request.getPathInfo();
		//根据授权 获取能查看的部门ids
		String departmentIds = Permission.getPermissionDepartMentIds(userId, url, false);
		FlxoaApproveForm flxoaApproveForm = new FlxoaApproveForm();
		flxoaApproveForm.setDepartmentIds(departmentIds);
		//开始和结束时间
		String time = request.getParameter("time");
		//类型
		String approveType = request.getParameter("approveType");
		//审批状态
		String approveStatus = request.getParameter("approveStatus");
		//申请人
		String realName = request.getParameter("realName");
		//关键字检索英文名称
		String keywordName = request.getParameter("keywordName");		
		if(!CommonUtils.isEmpty(keywordName)){
			flxoaApproveForm.setKeywordName(keywordName);
		}
		//关键字检索选择或者输入的值
		String keywordValue = request.getParameter("keywordValue");		
		if(!CommonUtils.isEmpty(keywordValue)){
			flxoaApproveForm.setKeywordValue(keywordValue);
		}
		//关键字类型
		String keywordType = request.getParameter("keywordType");
		if(!CommonUtils.isEmpty(keywordType)){
			flxoaApproveForm.setKeywordType(keywordType);
		}
		//项目名称
		String projectName = request.getParameter("projectName");
		if(!CommonUtils.isEmpty(projectName)){
			flxoaApproveForm.setProjName(projectName);
		}
		//项目编号
		String projectNo = request.getParameter("projectNo");
		if(!CommonUtils.isEmpty(projectNo)){
			flxoaApproveForm.setProjNumber(projectNo);
		}
		//特殊状态
		String nowFormStatus = request.getParameter("nowFormStatus");
		if(!CommonUtils.isEmpty(nowFormStatus)){
			flxoaApproveForm.setNowFormStatus(nowFormStatus);
		}		
		if(time != null)
		{
			if(!"全部".equals(time)){
				if(time.indexOf("-") != -1){
					String [] temp = time.split("-");
					if(!"".equals(temp[0])){
						flxoaApproveForm.setStartTime(DateUtils.dateToTimestamp(temp[0],"yyyy/MM/dd"));
					}
					if(!"".equals(temp[1])){
						flxoaApproveForm.setEndTime(DateUtils.dateToTimestamp(temp[1],"yyyy/MM/dd"));
					}
				}else{
					if(!"".equals(time)){
						int setTime = DateUtils.dateToTimestamp(time,"yyyy/MM/dd");
						flxoaApproveForm.setStartTime(setTime);
						flxoaApproveForm.setEndTime(setTime);						
					}
				}
			}
		}
		if(approveType != null){
			if(!"".equals(approveType)){
				flxoaApproveForm.setApproveType(approveType);
			}
		}
		if(approveStatus != null){
			if(!"".equals(approveStatus)){
				flxoaApproveForm.setApproveStatus(approveStatus);
			}			
		}
		if(realName != null){
			if(!"".equals(realName)){
				flxoaApproveForm.setRealName(realName);
			}			
		}		
		//页面展示 申请类型 申请时间  审批状态 关键字  上一步审批人  下一步审批人
		//查询(申请类型  申请时间  项目编号  项目名称  状态  审批进度  申请表模板id id 创建者部门id)
		String listJson = getApproveLogDetailListJosn(flxoaApproveForm);
		return listJson;
	}

	
	
	/**
	 * 审批监控详情
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */	
	@RequestMapping(value = "/approve/goapprovelogdetail")
	public String goApproveLogDetail(HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		
		return "nk/pages/approval/approvelogdetail";
	}
	
	/**
	 * 审批监控详情
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/approve/approvelogdetail")
	@ResponseBody	
	private String approveLogDetail(HttpServletRequest request,HttpServletResponse response, ModelMap model){
		//formID
		String formId = request.getParameter("formId");
		//是否查询自己的审批记录
		String isMy = request.getParameter("isMy");
		String jsonString = "";
		if(null != formId){
			if(!"".equals(formId)){
				FlxoaApproveForm flxoaApproveForm = new FlxoaApproveForm();
				flxoaApproveForm.setId(Integer.parseInt(formId));
				if(null != isMy){
					flxoaApproveForm.setApproveUserId(String.valueOf(request.getSession().getAttribute("userId")));
				}
				List<FlxoaApproveForm> list = flxoaApproveFormService.queryApproveFormLog(flxoaApproveForm);			
				//获取当前状态 下级状态对应的角色名称
				List<FlxoaApproveForm> formListDetail = new ArrayList<FlxoaApproveForm>();
				for (int j = 0; j < list.size(); j++) {
					//根据审核数据的工作流id获取 工作流json
					FlxoaApproveWorkflow flxoaApproveWorkflow = new FlxoaApproveWorkflow();
					flxoaApproveWorkflow.setId(list.get(j).getWorkflowId());
					FlxoaApproveWorkflow queryWorkFlow = flxoaApproveWorkflowService.queryById(flxoaApproveWorkflow);
					String workflowJson = queryWorkFlow.getWorkflowJson();
					//获取当前状态 下级状态对应的角色名称
					FlxoaApproveForm form = getFormDetail(list.get(j),workflowJson);
					formListDetail.add(form);
				}				
				JSONArray json = JSONArray.fromObject(formListDetail);
				jsonString = json.toString();				
			}
		
		}
		return jsonString;
	}
		
	
	//根据条件 查询 审批监控列表
	private String getApproveLogDetailListJosn(FlxoaApproveForm flxoaApproveForm){
		List<FlxoaApproveForm> list = flxoaApproveFormService.query(flxoaApproveForm);
		//组装上一步审批人 下一步审批人
		//获取上一步审批人id
		String userIds = "";
		for (int i = 0; i < list.size(); i++) {
			userIds += list.get(i).getUpdateUserId()+",";
		}
		if(!"".equals(userIds)){
			userIds = userIds.substring(0,userIds.length()-1);
		}
		FlxoaSystemUser flxoaSystemUser = new FlxoaSystemUser();
		flxoaSystemUser.setIds(userIds);
		List<FlxoaSystemUser> flxoaSystemUserList = flxoaSystemUserService.query(flxoaSystemUser);
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < flxoaSystemUserList.size(); j++) {
				if(list.get(i).getUpdateUserId().intValue() == flxoaSystemUserList.get(j).getId().intValue()){
					//上一步审批人
					list.get(i).setNowUser(flxoaSystemUserList.get(j).getRealName());
				}
			}
		}
		
		//组装 审批进度 以及审批进度详情
		List<FlxoaApproveForm> formListDetail = new ArrayList<FlxoaApproveForm>();
		List<FlxoaApproveWorkflow> queryWorkFlowList = flxoaApproveWorkflowService.query(null);
		List<FlxoaSystemUserRole> rolelist = flxoaSystemUserRoleService.query(null);
		for (int i = rolelist.size() -1; i >= 0; i--) {
			if("null".equals(rolelist.get(i).getUserName())){
				rolelist.remove(i);
			}
		}
		for (int j = 0; j < list.size(); j++) {
			//根据审核数据的工作流id获取 工作流json
			FlxoaApproveWorkflow flxoaApproveWorkflow = new FlxoaApproveWorkflow();
			flxoaApproveWorkflow.setId(list.get(j).getWorkflowId());
//			FlxoaApproveWorkflow queryWorkFlow = flxoaApproveWorkflowService.queryById(flxoaApproveWorkflow);
//			String workflowJson = queryWorkFlow.getWorkflowJson();
			for (int i = 0; i < queryWorkFlowList.size(); i++) {
				//保存时工作流id 为0
				if(list.get(j).getWorkflowId().intValue() == 0){
					formListDetail.add(list.get(j));
					break;
				}
				else if(queryWorkFlowList.get(i).getId().intValue() == flxoaApproveWorkflow.getId().intValue()){
					FlxoaApproveWorkflow queryWorkFlow = queryWorkFlowList.get(i);
					String workflowJson = queryWorkFlow.getWorkflowJson();
					//获取审批进度及进度详情 下一步审批人
					FlxoaApproveForm form = getFormLogDetail(list.get(j),workflowJson,rolelist);
					formListDetail.add(form);				
				}
			}			
		}		
		
		/*---------start:根据申请模板  组装关键字-----------*/
		//查询申请模板
		List<FlxoaApproveFormtemplate> flxoaApproveFormtemplate = flxoaApproveFormtemplateService.query(null);
		List<FlxoaApproveFormdata> formdataList = flxoaApproveFormdataService.query(null);
		//查找所有枚举
		List<FlxoaSystemEnumeration> enumerationList = flxoaSystemEnumerationService.query(null);		
		for (int i = 0; i < flxoaApproveFormtemplate.size(); i++) {
			JSONObject root = JSONObject.fromObject(flxoaApproveFormtemplate.get(i).getLayout());
			String names = root.getString("names");
			JSONArray jsonList = JSONArray.fromObject(names);
			//存放关键字 key
			List<FlxoaApproveFormdata> listFormdata = new ArrayList<FlxoaApproveFormdata>();
			for (int j = 0; j < jsonList.size(); j++) {
				JSONObject jsonObj = JSONObject.fromObject(jsonList.get(j));
				//数据项英文名称
				String key = jsonObj.getString("key");
				//是否是关键字 0不是  1是 2是 并且是检索条件
				String iskeyword = jsonObj.getString("iskeyword");
				//枚举名称
				String enumerationName = jsonObj.getString("enumeration_name");				
	        	FlxoaApproveFormdata formdata = new FlxoaApproveFormdata();
	        	if("1".equals(iskeyword)||"2".equals(iskeyword))
	        	{
	        		formdata.setDataKey(key);
	        		//枚举名称
		        	if(!"".equals(enumerationName)){
		        		formdata.setEnumerationName(enumerationName);
		        	}
		        	listFormdata.add(formdata);	        		
	        	}
			}
			//组装关键字信息
			for (int j = 0; j < formListDetail.size(); j++) {
				if(formListDetail.get(j).getTemplateId().intValue() == flxoaApproveFormtemplate.get(i).getId().intValue())
				{
					FlxoaApproveFormdata flxoaApproveFormdata = new FlxoaApproveFormdata();
					flxoaApproveFormdata.setFormId(formListDetail.get(j).getId());
					flxoaApproveFormdata.getList().addAll(listFormdata);
					String keyword = "";
					for (int k = 0; k < formdataList.size(); k++) {
						if(flxoaApproveFormdata.getFormId().intValue() == formdataList.get(k).getFormId().intValue()){
							for (int q = 0; q < flxoaApproveFormdata.getList().size(); q++) {
								if(flxoaApproveFormdata.getList().get(q).getDataKey().equals(formdataList.get(k).getDataKey())){
									//有枚举值时，通过枚举名称查找枚举表找到对应的描述 拼接到关键字中
									if(null != flxoaApproveFormdata.getList().get(q).getEnumerationName()){
										for (int l = 0; l < enumerationList.size(); l++) {
											//枚举名称比较
											if(flxoaApproveFormdata.getList().get(q).getEnumerationName().equals(enumerationList.get(l).getEnumerationName())){
												//枚举key比较
												if(formdataList.get(k).getDataValue().equals(enumerationList.get(l).getEnumerationKey())){
													//关键字拼接									
													keyword += formdataList.get(k).getDataDescription()+":"+enumerationList.get(l).getEnumerationValue()+",";														
												}
											}
										}
									}else{
										//关键字拼接
										keyword += formdataList.get(k).getDataDescription()+":"+formdataList.get(k).getDataValue()+",";
									}									
								}
							}
						}
					}
					if(!"".equals(keyword)){
						keyword = keyword.substring(0,keyword.length()-1);
					}
//					List<FlxoaApproveFormdata> formdataList = flxoaApproveFormdataService.query(flxoaApproveFormdata);
//					String keyword = "";
//					for (int k = 0; k < formdataList.size(); k++) {
//						keyword += formdataList.get(k).getDataDescription()+":"+formdataList.get(k).getDataValue()+",";
//					}
//					if(!"".equals(keyword)){
//						keyword = keyword.substring(0,keyword.length()-1);
//					}
					formListDetail.get(j).setKeyword(keyword);
				}
				
			}
			
		}
		
		//最新审批备注
		List<FlxoaApproveFormlog> logList = flxoaApproveFormlogService.query(null);
		for (int j = 0; j < formListDetail.size(); j++) {		
			FlxoaApproveFormlog queryFormLog = new FlxoaApproveFormlog();
			queryFormLog.setFormId(formListDetail.get(j).getId());
			Boolean flag = false;
			for (int k = 0; k < logList.size(); k++) {
				if(queryFormLog.getFormId().intValue() == logList.get(k).getFormId().intValue()){
					formListDetail.get(j).setApproveRemark("最新审批备注："+logList.get(k).getApproveRemark());
					flag = true;
				}else{
					formListDetail.get(j).setApproveRemark("");
				}
				if(flag){
					break;
				}
			}
//			List<FlxoaApproveFormlog> logList = flxoaApproveFormlogService.query(queryFormLog);			
//			if(logList.size() > 0){
//				formListDetail.get(j).setApproveRemark("最新审批备注："+logList.get(0).getApproveRemark());
//			}else{
//				formListDetail.get(j).setApproveRemark("");
//			}
		}
		/*---------end:根据申请模板  组装关键字-----------*/
		JSONArray json = JSONArray.fromObject(formListDetail);
		return json.toString();
	}
	
	/**
	 * 审批监控  根据审批状态 获取 审批详情
	 * */	
	private FlxoaApproveForm getFormLogDetail(FlxoaApproveForm flxoaApproveForm,String workflowJson,List<FlxoaSystemUserRole> rolelist){
		JSONObject rootWorkflowJson = JSONObject.fromObject(workflowJson);
		String nodes = rootWorkflowJson.getString("nodes");
		JSONObject nodesJson = JSONObject.fromObject(nodes);
		
		int workflowSize = 0;
		Iterator iterator = nodesJson.keys();
		//审批进度
		String approveProgressDetail = "";
		//审批状态
		String approveProgress = "";
		boolean flag = false;
		boolean isPass = false;
		while(iterator.hasNext()){;
			String key = (String) iterator.next();
			String value = nodesJson.getString(key);
			JSONObject jsonObj = JSONObject.fromObject(value);
			//工作流节点名称
			String name = getNowName(jsonObj.getString("name"));
        	if(!flag){
        		if(isPass){
        			approveProgressDetail += name + "→";
        		}else{
        			approveProgressDetail += "<span style='color:gray;'>"+name + "</span>→";
        		}
        		
        	}else{
        		isPass = true;
        		approveProgressDetail += "<span style='color:red;'>"+name + "</span>→";
        	}			
        	//根据当前申请数据审批状态  获取与之对应的工作流节点 与下一步工作流节点
			if(flag){
				approveProgress += ","+name+"待审";
				flag = false;
				//根据角色名称查询下一步审批人
//				FlxoaSystemUserRole flxoaSystemUserRole = new FlxoaSystemUserRole();
//				flxoaSystemUserRole.setRoleName(name);
//				List<FlxoaSystemUserRole> rolelist = flxoaSystemUserRoleService.query(flxoaSystemUserRole);
				String realNames = "";
				for (int i = 0; i < rolelist.size(); i++) {
					if(name.equals(rolelist.get(i).getRoleName())){
						if(!realNames.contains(rolelist.get(i).getUserName()+",")){
							realNames += rolelist.get(i).getUserName()+",";
						}						
					}
				}
				if(!"".equals(realNames)){
					realNames = realNames.substring(0,realNames.length()-1);
				}
				flxoaApproveForm.setNextUser(realNames);
			}
        	if(Integer.parseInt(flxoaApproveForm.getStatus()) == workflowSize){
        		flag = true;
        		approveProgress += name+"已审";
        	}
        	workflowSize++;
		}
//		if(-1 == approveProgress.indexOf("待审")){
//			approveProgress += ",流程已结束";
//		}		
		approveProgressDetail = approveProgressDetail.substring(0,approveProgressDetail.length()-1);
		flxoaApproveForm.setApproveProgressDetail(approveProgressDetail);
		flxoaApproveForm.setApproveProgress(approveProgress);
		return flxoaApproveForm;
	}
	
	//根据条件 查询 审批列表
	private String getApproveListJosn(String start,String length,FlxoaApproveForm flxoaApproveForm){
		ConcurrentHashMap<String, Object> map = flxoaApproveFormService.query(start,length,flxoaApproveForm);
		List<FlxoaApproveForm> list =(List<FlxoaApproveForm>) map.get("data");
		//组装 审批进度 以及审批进度详情
		List<FlxoaApproveForm> formListDetail = new ArrayList<FlxoaApproveForm>();
		List<FlxoaApproveWorkflow> queryWorkFlowList = flxoaApproveWorkflowService.query(null);
		for (int j = 0; j < list.size(); j++) {
			//根据审核数据的工作流id获取 工作流json
			FlxoaApproveWorkflow flxoaApproveWorkflow = new FlxoaApproveWorkflow();
			flxoaApproveWorkflow.setId(list.get(j).getWorkflowId());
//			FlxoaApproveWorkflow queryWorkFlow = flxoaApproveWorkflowService.queryById(flxoaApproveWorkflow);
			for (int i = 0; i < queryWorkFlowList.size(); i++) {
				//保存时工作流id 为0
				if(list.get(j).getWorkflowId().intValue() == 0){
					formListDetail.add(list.get(j));
					break;
				}
				else if(queryWorkFlowList.get(i).getId().intValue() == flxoaApproveWorkflow.getId().intValue()){
					FlxoaApproveWorkflow queryWorkFlow = queryWorkFlowList.get(i);
					String workflowJson = queryWorkFlow.getWorkflowJson();
					//获取审批进度及进度详情
					FlxoaApproveForm form = getFormDetail(list.get(j),workflowJson);
					formListDetail.add(form);					
				}
			}
		}		
		
		/*---------start:根据申请模板  组装关键字-----------*/
		//查询申请模板
		List<FlxoaApproveFormtemplate> flxoaApproveFormtemplate = flxoaApproveFormtemplateService.query(null);
		//查找申请表所有数据
		List<FlxoaApproveFormdata> formdataList = flxoaApproveFormdataService.query(null);
		//查找所有枚举
		List<FlxoaSystemEnumeration> enumerationList = flxoaSystemEnumerationService.query(null);
		for (int i = 0; i < flxoaApproveFormtemplate.size(); i++) {
			JSONObject root = JSONObject.fromObject(flxoaApproveFormtemplate.get(i).getLayout());
			String names = root.getString("names");
			JSONArray jsonList = JSONArray.fromObject(names);
			//存放关键字 key
			List<FlxoaApproveFormdata> listFormdata = new ArrayList<FlxoaApproveFormdata>();
			for (int j = 0; j < jsonList.size(); j++) {
				JSONObject jsonObj = JSONObject.fromObject(jsonList.get(j));
				//数据项英文名称
				String key = jsonObj.getString("key");
				//是否是关键字 0不是  1是 2是 并且是检索条件
				String iskeyword = jsonObj.getString("iskeyword");
				//枚举名称
				String enumerationName = jsonObj.getString("enumeration_name");				
	        	FlxoaApproveFormdata formdata = new FlxoaApproveFormdata();
	        	if("1".equals(iskeyword)||"2".equals(iskeyword))
	        	{
	        		formdata.setDataKey(key);
	        		//枚举名称
		        	if(!"".equals(enumerationName)){
		        		formdata.setEnumerationName(enumerationName);
		        	}
		        	listFormdata.add(formdata);	        		
	        	}

			}
			
			//组装关键字信息
			for (int j = 0; j < formListDetail.size(); j++) {
				if(formListDetail.get(j).getTemplateId().intValue() == flxoaApproveFormtemplate.get(i).getId().intValue())
				{
					FlxoaApproveFormdata flxoaApproveFormdata = new FlxoaApproveFormdata();
					flxoaApproveFormdata.setFormId(formListDetail.get(j).getId());
					flxoaApproveFormdata.getList().addAll(listFormdata);
					String keyword = "";
					for (int k = 0; k < formdataList.size(); k++) {
						if(flxoaApproveFormdata.getFormId().intValue() == formdataList.get(k).getFormId().intValue()){
							for (int q = 0; q < flxoaApproveFormdata.getList().size(); q++) {
								if(flxoaApproveFormdata.getList().get(q).getDataKey().equals(formdataList.get(k).getDataKey())){
									//有枚举值时，通过枚举名称查找枚举表找到对应的描述 拼接到关键字中
									if(null != flxoaApproveFormdata.getList().get(q).getEnumerationName()){
										for (int l = 0; l < enumerationList.size(); l++) {
											//枚举名称比较
											if(flxoaApproveFormdata.getList().get(q).getEnumerationName().equals(enumerationList.get(l).getEnumerationName())){
												//枚举key比较
												if(formdataList.get(k).getDataValue().equals(enumerationList.get(l).getEnumerationKey())){
													//关键字拼接									
													keyword += formdataList.get(k).getDataDescription()+":"+enumerationList.get(l).getEnumerationValue()+",";														
												}
											}
										}
									}else{
										//关键字拼接									
										keyword += formdataList.get(k).getDataDescription()+":"+formdataList.get(k).getDataValue()+",";										
									}
								}
							}
						}
					}
					if(!"".equals(keyword)){
						keyword = keyword.substring(0,keyword.length()-1);
					}
//					List<FlxoaApproveFormdata> formdataList = flxoaApproveFormdataService.query(flxoaApproveFormdata);
//					String keyword = "";
//					for (int k = 0; k < formdataList.size(); k++) {
//						keyword += formdataList.get(k).getDataDescription()+":"+formdataList.get(k).getDataValue()+",";
//					}
//					if(!"".equals(keyword)){
//						keyword = keyword.substring(0,keyword.length()-1);
//					}
					formListDetail.get(j).setKeyword(keyword);
				}
				
			}
			
		}
		
		//最新审批备注
		List<FlxoaApproveFormlog> logList = flxoaApproveFormlogService.query(null);
		for (int j = 0; j < formListDetail.size(); j++) {		
			FlxoaApproveFormlog queryFormLog = new FlxoaApproveFormlog();
			queryFormLog.setFormId(formListDetail.get(j).getId());
			boolean flag= false;
			for (int k = 0; k < logList.size(); k++) {
				if(queryFormLog.getFormId().intValue() == logList.get(k).getFormId().intValue()){
					formListDetail.get(j).setApproveRemark("最新审批备注："+logList.get(k).getApproveRemark());
					flag = true;
				}else{
					formListDetail.get(j).setApproveRemark("");
				}
				if(flag){
					break;
				}
			}
//			List<FlxoaApproveFormlog> logList = flxoaApproveFormlogService.query(queryFormLog);			
//			if(logList.size() > 0){
//				formListDetail.get(j).setApproveRemark("最新审批备注："+logList.get(0).getApproveRemark());
//			}else{
//				formListDetail.get(j).setApproveRemark("");
//			}
		}
		/*---------end:根据申请模板  组装关键字-----------*/
		map.put("data", formListDetail);
		JSONArray json = JSONArray.fromObject(map);
		return json.toString();
	}
	//根据条件 查询 审批列表
	private String getApproveListJosn(FlxoaApproveForm flxoaApproveForm){
		List<FlxoaApproveForm> list = flxoaApproveFormService.query(flxoaApproveForm);
		//组装 审批进度 以及审批进度详情
		List<FlxoaApproveForm> formListDetail = new ArrayList<FlxoaApproveForm>();
		List<FlxoaApproveWorkflow> queryWorkFlowList = flxoaApproveWorkflowService.query(null);
		for (int j = 0; j < list.size(); j++) {
			//根据审核数据的工作流id获取 工作流json
			FlxoaApproveWorkflow flxoaApproveWorkflow = new FlxoaApproveWorkflow();
			flxoaApproveWorkflow.setId(list.get(j).getWorkflowId());
//			FlxoaApproveWorkflow queryWorkFlow = flxoaApproveWorkflowService.queryById(flxoaApproveWorkflow);
			for (int i = 0; i < queryWorkFlowList.size(); i++) {
				//保存时工作流id 为0
				if(list.get(j).getWorkflowId().intValue() == 0){
					formListDetail.add(list.get(j));
					break;
				}
				else if(queryWorkFlowList.get(i).getId().intValue() == flxoaApproveWorkflow.getId().intValue()){
					FlxoaApproveWorkflow queryWorkFlow = queryWorkFlowList.get(i);
					String workflowJson = queryWorkFlow.getWorkflowJson();
					//获取审批进度及进度详情
					FlxoaApproveForm form = getFormDetail(list.get(j),workflowJson);
					formListDetail.add(form);					
				}
			}
		}		
		
		/*---------start:根据申请模板  组装关键字-----------*/
		//查询申请模板
		List<FlxoaApproveFormtemplate> flxoaApproveFormtemplate = flxoaApproveFormtemplateService.query(null);
		//查找申请表所有数据
		List<FlxoaApproveFormdata> formdataList = flxoaApproveFormdataService.query(null);
		//查找所有枚举
		List<FlxoaSystemEnumeration> enumerationList = flxoaSystemEnumerationService.query(null);
		for (int i = 0; i < flxoaApproveFormtemplate.size(); i++) {
			JSONObject root = JSONObject.fromObject(flxoaApproveFormtemplate.get(i).getLayout());
			String names = root.getString("names");
			JSONArray jsonList = JSONArray.fromObject(names);
			//存放关键字 key
			List<FlxoaApproveFormdata> listFormdata = new ArrayList<FlxoaApproveFormdata>();
			for (int j = 0; j < jsonList.size(); j++) {
				JSONObject jsonObj = JSONObject.fromObject(jsonList.get(j));
				//数据项英文名称
				String key = jsonObj.getString("key");
				//是否是关键字 0不是  1是 2是 并且是检索条件
				String iskeyword = jsonObj.getString("iskeyword");
				//枚举名称
				String enumerationName = jsonObj.getString("enumeration_name");				
				FlxoaApproveFormdata formdata = new FlxoaApproveFormdata();
				if("1".equals(iskeyword)||"2".equals(iskeyword))
				{
					formdata.setDataKey(key);
					//枚举名称
					if(!"".equals(enumerationName)){
						formdata.setEnumerationName(enumerationName);
					}
					listFormdata.add(formdata);	        		
				}
				
			}
			
			//组装关键字信息
			for (int j = 0; j < formListDetail.size(); j++) {
				if(formListDetail.get(j).getTemplateId().intValue() == flxoaApproveFormtemplate.get(i).getId().intValue())
				{
					FlxoaApproveFormdata flxoaApproveFormdata = new FlxoaApproveFormdata();
					flxoaApproveFormdata.setFormId(formListDetail.get(j).getId());
					flxoaApproveFormdata.getList().addAll(listFormdata);
					String keyword = "";
					for (int k = 0; k < formdataList.size(); k++) {
						if(flxoaApproveFormdata.getFormId().intValue() == formdataList.get(k).getFormId().intValue()){
							for (int q = 0; q < flxoaApproveFormdata.getList().size(); q++) {
								if(flxoaApproveFormdata.getList().get(q).getDataKey().equals(formdataList.get(k).getDataKey())){
									//有枚举值时，通过枚举名称查找枚举表找到对应的描述 拼接到关键字中
									if(null != flxoaApproveFormdata.getList().get(q).getEnumerationName()){
										for (int l = 0; l < enumerationList.size(); l++) {
											//枚举名称比较
											if(flxoaApproveFormdata.getList().get(q).getEnumerationName().equals(enumerationList.get(l).getEnumerationName())){
												//枚举key比较
												if(formdataList.get(k).getDataValue().equals(enumerationList.get(l).getEnumerationKey())){
													//关键字拼接									
													keyword += formdataList.get(k).getDataDescription()+":"+enumerationList.get(l).getEnumerationValue()+",";														
												}
											}
										}
									}else{
										//关键字拼接									
										keyword += formdataList.get(k).getDataDescription()+":"+formdataList.get(k).getDataValue()+",";										
									}
								}
							}
						}
					}
					if(!"".equals(keyword)){
						keyword = keyword.substring(0,keyword.length()-1);
					}
//					List<FlxoaApproveFormdata> formdataList = flxoaApproveFormdataService.query(flxoaApproveFormdata);
//					String keyword = "";
//					for (int k = 0; k < formdataList.size(); k++) {
//						keyword += formdataList.get(k).getDataDescription()+":"+formdataList.get(k).getDataValue()+",";
//					}
//					if(!"".equals(keyword)){
//						keyword = keyword.substring(0,keyword.length()-1);
//					}
					formListDetail.get(j).setKeyword(keyword);
				}
				
			}
			
		}
		
		//最新审批备注
		List<FlxoaApproveFormlog> logList = flxoaApproveFormlogService.query(null);
		for (int j = 0; j < formListDetail.size(); j++) {		
			FlxoaApproveFormlog queryFormLog = new FlxoaApproveFormlog();
			queryFormLog.setFormId(formListDetail.get(j).getId());
			boolean flag= false;
			for (int k = 0; k < logList.size(); k++) {
				if(queryFormLog.getFormId().intValue() == logList.get(k).getFormId().intValue()){
					formListDetail.get(j).setApproveRemark("最新审批备注："+logList.get(k).getApproveRemark());
					flag = true;
				}else{
					formListDetail.get(j).setApproveRemark("");
				}
				if(flag){
					break;
				}
			}
//			List<FlxoaApproveFormlog> logList = flxoaApproveFormlogService.query(queryFormLog);			
//			if(logList.size() > 0){
//				formListDetail.get(j).setApproveRemark("最新审批备注："+logList.get(0).getApproveRemark());
//			}else{
//				formListDetail.get(j).setApproveRemark("");
//			}
		}
		/*---------end:根据申请模板  组装关键字-----------*/
		JSONArray json = JSONArray.fromObject(formListDetail);
		return json.toString();
	}
	
	/**
	 * 根据审批状态 获取 审批详情
	 * */	
	private FlxoaApproveForm getFormDetail(FlxoaApproveForm flxoaApproveForm,String workflowJson){
		JSONObject rootWorkflowJson = JSONObject.fromObject(workflowJson);
		String nodes = rootWorkflowJson.getString("nodes");
		JSONObject nodesJson = JSONObject.fromObject(nodes);
		
		int workflowSize = 0;
		Iterator iterator = nodesJson.keys();
		//审批进度
		String approveProgressDetail = "";
		//审批状态
		String approveProgress = "";
		boolean flag = false;
		boolean isPass = false;
		String nowFlowNodeName = "";
		while(iterator.hasNext()){;
			String key = (String) iterator.next();
			String value = nodesJson.getString(key);
			JSONObject jsonObj = JSONObject.fromObject(value);
			//工作流节点名称
			String name = getNowName(jsonObj.getString("name"));
        	if(!flag){
        		if(isPass){
        			//未通过的流程
        			approveProgressDetail += "<span style='color:gray;'><img src='/view/flxoa/page/nk/public/img/no_pass.png' >"+name + "</span>" +
        					"<br><img style='padding-left:7px;' src='/view/flxoa/page/nk/public/img/no_line.png' >→";
        		}else{
        			//已经通过的流程
        			approveProgressDetail += "<span style='color:black;'><img src='/view/flxoa/page/nk/public/img/pass.png' >"+name + "</span>" +
        					"<br><img style='padding-left:7px;' src='/view/flxoa/page/nk/public/img/line.png' >→";
        		}
        		
        	}else{
        		isPass = true;
        		//即将通过的流程
        		approveProgressDetail += "<span style='color:black;'><img id='progress"+flxoaApproveForm.getId()+"'  src='/view/flxoa/page/nk/public/img/passing.gif'>"+name + "</span>" +
        				"<br><img style='padding-left:7px;' src='/view/flxoa/page/nk/public/img/line.png' >→";
        	}			
        	//根据当前申请数据审批状态  获取与之对应的工作流节点 与下一步工作流节点
			if(flag){
				approveProgress += ","+name+"待审";
				flxoaApproveForm.setNextStatus(name);
				flag = false;
			}
			if(!"".equals(flxoaApproveForm.getStatus())){
	        	if(Integer.parseInt(flxoaApproveForm.getStatus()) == workflowSize){
	        		flag = true;
	        		flxoaApproveForm.setNowStatus(name);
	        		approveProgress += name+"已审";
	        		nowFlowNodeName = jsonObj.getString("name");
	    			//设置当前工作流节点名称，用于前端打印或者其他状态处理
	    			flxoaApproveForm.setNowFlowNodeName(nowFlowNodeName);	        		
	        	}
	        	//流程结束时
	        	if("-1".equals(flxoaApproveForm.getStatus())){
	        		flxoaApproveForm.setNowStatus(name);
	        		approveProgress = name+"已审";
	        		nowFlowNodeName = jsonObj.getString("name");
	    			//设置当前工作流节点名称，用于前端打印或者其他状态处理
	    			flxoaApproveForm.setNowFlowNodeName(nowFlowNodeName); 	        		
	        	}	        	
			}
 	
        	workflowSize++;
		}
		flxoaApproveForm.setNowFlowNodeName(nowFlowNodeName);
		//去掉最后一个图片线
		approveProgressDetail = approveProgressDetail.substring(0, approveProgressDetail.lastIndexOf("<br><img"));
		//审批记录:流程结束时设置
		if(-1 == approveProgress.indexOf("待审")){
//			approveProgress += ",流程已结束";
			flxoaApproveForm.setNextStatus("无");
		}
		//审批记录:不通过或退回时  下一步状态显示无
		if("2".equals(flxoaApproveForm.getApproveIdea()) || "3".equals(flxoaApproveForm.getApproveIdea()) ){
			flxoaApproveForm.setNextStatus("无");
		}
		approveProgressDetail = approveProgressDetail.substring(0,approveProgressDetail.length()-1);
		//未提交或退回状态时， 不显示审批进度信息
		if("0".equals(flxoaApproveForm.getSubmitStatus())||"-1".equals(flxoaApproveForm.getSubmitStatus())){
			approveProgressDetail = "";
			approveProgress = "";
		}
		flxoaApproveForm.setApproveProgressDetail(approveProgressDetail);
		flxoaApproveForm.setApproveProgress(approveProgress);
		return flxoaApproveForm;
	}
	
	/**
	 * 获取角色名称对应的工作流id和所在位置(审批进度)
	 * */	
	private List<FlxoaApproveForm> getWorkflowByRoleName(String roleName){
		//查询所有申请模板对应的工作流json
		List<FlxoaApproveWorkflow> workflowList = flxoaApproveWorkflowService.query(null);
		List<FlxoaApproveForm> list = new ArrayList<FlxoaApproveForm>();
		for (int i = 0; i < workflowList.size(); i++) {
			JSONObject rootWorkflowJson = JSONObject.fromObject(workflowList.get(i).getWorkflowJson());
			String nodes = rootWorkflowJson.getString("nodes");
			JSONObject nodesJson = JSONObject.fromObject(nodes);
			int workflowSize = 0;
			Iterator iterator = nodesJson.keys();
			while(iterator.hasNext()){
				String key = (String) iterator.next();
				String value = nodesJson.getString(key);
				JSONObject jsonObj = JSONObject.fromObject(value);
				//工作流节点名称
				String name = getNowName(jsonObj.getString("name"));
				if(roleName.indexOf(",")!= -1){
					String [] temp = roleName.split(",");
					for (int j = 0; j < temp.length; j++) {
						if(temp[j].equals(name))
						{
							FlxoaApproveForm form = new FlxoaApproveForm();
							form.setWorkflowId(workflowList.get(i).getId());
							form.setStatus(String.valueOf(workflowSize));
							list.add(form);
						}
					}
				}else{
					if(roleName.equals(name))
					{
						FlxoaApproveForm form = new FlxoaApproveForm();
						form.setWorkflowId(workflowList.get(i).getId());
						form.setStatus(String.valueOf(workflowSize));
						list.add(form);
					}
				}
	        	workflowSize++;
			}			
		}
		return list;
	}
	
	
	/**
	 * 根据模板id和部门id获取对应的工作流
	 * */
	private FlxoaApproveWorkflow getWorkflowJsonById(int templateId,int departmentId){
		//查询所有申请模板对应的工作流json
		List<FlxoaApproveWorkflow> workflowList = flxoaApproveWorkflowService.query(null);
		//部门id和申请模板id对应的工作流json
		FlxoaApproveWorkflow flxoaApproveWorkflow = null;
		//飞利信部门id（1） 申请模板id对应的工作流json（默认）
		FlxoaApproveWorkflow tempFlxoaApproveWorkflow = null;
		//获取和部门相关的工作流json，如果没有就用默认的（部门id为1），如果没有申请模板对应的工作流，则返回
		for (int i = 0; i < workflowList.size(); i++) {
			//模板ids
			String workflowTemplateId = workflowList.get(i).getTemplageIds();
			if(!"".equals(workflowTemplateId)){
				if(workflowTemplateId.indexOf(",")!= -1){
					String [] temp = workflowTemplateId.split(",");
					for (int k = 0; k < temp.length; k++) {
						if(Integer.parseInt(temp[k]) == templateId){
							if(workflowList.get(i).getDepartmentId().intValue() == departmentId){
								//工作流json
								flxoaApproveWorkflow = new FlxoaApproveWorkflow();
								flxoaApproveWorkflow.setId(workflowList.get(i).getId());
								flxoaApproveWorkflow.setWorkflowJson(workflowList.get(i).getWorkflowJson());
							}else if(workflowList.get(i).getDepartmentId().intValue() == 1){
								tempFlxoaApproveWorkflow = new FlxoaApproveWorkflow();
								tempFlxoaApproveWorkflow.setId(workflowList.get(i).getId());
								tempFlxoaApproveWorkflow.setWorkflowJson(workflowList.get(i).getWorkflowJson());								
							}
						}							
					}
				}else{
					if(Integer.parseInt(workflowTemplateId) == templateId){
						if(workflowList.get(i).getDepartmentId().intValue() == departmentId){
							//工作流json
							flxoaApproveWorkflow = new FlxoaApproveWorkflow();
							flxoaApproveWorkflow.setId(workflowList.get(i).getId());
							flxoaApproveWorkflow.setWorkflowJson(workflowList.get(i).getWorkflowJson());							
						}else if(workflowList.get(i).getDepartmentId().intValue() == 1){
							tempFlxoaApproveWorkflow = new FlxoaApproveWorkflow();
							tempFlxoaApproveWorkflow.setId(workflowList.get(i).getId());
							tempFlxoaApproveWorkflow.setWorkflowJson(workflowList.get(i).getWorkflowJson());							
						}					
					}
				}
			}
		}
		
		if(null == flxoaApproveWorkflow)
		{
			//如果没有部门对应的申请模板工作流 就采用默认 飞利信工作流
			if(null != tempFlxoaApproveWorkflow)
			{
				flxoaApproveWorkflow = tempFlxoaApproveWorkflow;
			}
		}
		return flxoaApproveWorkflow;
	}
	
	/**
	 * 获取当前节点角色名称 去掉- 返回
	 * */
	private String getNowName(String name){
		String newName = name;
		if(-1 != name.indexOf("-")){
			newName = newName.substring(0, name.indexOf("-"));
		}
		return newName;
	}
	
}
