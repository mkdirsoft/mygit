package com.flx.flxoa.info.statistical.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flx.flxoa.common.util.CommonUtils;
import com.flx.flxoa.common.util.DateUtils;
import com.flx.flxoa.info.approve.entity.FlxoaApproveForm;
import com.flx.flxoa.info.approve.manager.FlxoaApproveFormService;
import com.flx.flxoa.info.approve.manager.FlxoaApproveFormdataService;
import com.flx.flxoa.info.approve.entity.FlxoaApproveFormdata;
import com.flx.flxoa.info.signin.entity.FlxoaAttendanceSummary;
import com.flx.flxoa.info.statistical.entity.FlxoaBarCharts;
import com.flx.flxoa.info.statistical.manager.FlxoaStatisticalService;
import com.flx.flxoa.info.system.comon.Permission;
import com.flx.flxoa.info.system.manager.FlxoaSystemDepartmentService;

/**
 * 类名称：FlxoaStatisticaController.java<br>
 * 类描述：<br> 首页数据
 * 创建时间：2018-4-12, 上午10:10:30
 * 
 * @version 1.0 
 * @since JDK版本 1.7
 * @author 夏改翠 
 */
@Controller
public class FlxoaStatisticaController {

	protected FlxoaStatisticalService flxoaStatisticalService;
	protected FlxoaSystemDepartmentService flxoaSystemDepartmentService;
	@Autowired
	public void setFlxoaSystemDepartmentService(
			FlxoaSystemDepartmentService flxoaSystemDepartmentService) {
		this.flxoaSystemDepartmentService = flxoaSystemDepartmentService;
	}

	@Autowired
	public void setFlxoaStatisticalService(
			FlxoaStatisticalService flxoaStatisticalService) {
		this.flxoaStatisticalService = flxoaStatisticalService;
	}
	
	//申请表数据
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
	
	@RequestMapping(value = "homepage/goShow",produces="text/html;charset=UTF-8")
	public String goList(HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		return "nk/pages/signIn/signIn";
	}
	/**
	 * 首页根据部门统计的项目 合同额、回款、费用、储备金、中标的金额
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "homepage/money",produces="text/html;charset=UTF-8")
	public String showHomePageMoney(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		String path =request.getServletPath()+request.getPathInfo();
		int userId = Integer.parseInt(String.valueOf(request.getSession().getAttribute("userId")));
		//int deptId = Integer.parseInt(String.valueOf(req.getSession().getAttribute("departmentId")));
		Map<String,List<Integer>>  map = Permission.getRolePermission(userId, path);
		//查到它具有部门权限的部门id
		String deptIds =  Permission.getDepartMentIdsNo(map);
		List<Map<String,Object>> list =flxoaStatisticalService.queryByDeptid(deptIds);
		
		JSONArray js =JSONArray.fromObject(list);
		System.out.print(js.toString());
		
		return js.toString();
	}
	/*
	 * 首页回款柱状图
	 */
	@ResponseBody
	@RequestMapping(value = "homepage/huikuan",produces="text/html;charset=UTF-8")
	public String showHomePageHuiKuan(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		List<Map<String,Object>> returnList = new ArrayList<Map<String,Object>>();
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		List<FlxoaBarCharts> barList = new ArrayList<FlxoaBarCharts>();
		List<Map<String,String>> mapList = flxoaSystemDepartmentService.queryDept();
		for(Map<String, String> map : mapList){
		     for(String k : map.keySet()){
		    	 System.out.println(k + " : " + map.get(k));
		    	 String deptids = map.get(k);
		    	 list =flxoaStatisticalService.queryHuiKuan(k,deptids);
		    	 returnList.addAll(list);
			 }
		 }		
		List<Map<String, Object>> countList = new ArrayList<Map<String,Object>>();//用于存放最后的结果 
        for(int i = 0; i < returnList.size(); i++) {  
            String name = returnList.get(i).get("name").toString();
            int flag = 0;//0为新增数据，1为增加count  
            for(int j = 0; j < countList.size(); j++) {  
                String newname = countList.get(j).get("name").toString();
                if(name.equals(newname)){
                	String value = String.valueOf(returnList.get(i).get("sun")) +","+ String.valueOf(countList.get(j).get("sun"));  
                	String months = String.valueOf(returnList.get(i).get("months")) +","+ String.valueOf(countList.get(j).get("months"));
                    countList.get(j).put("months", months);  
                    countList.get(j).put("sun", value);
                    flag = 1;  
                    continue; 
                }
            }
            if(flag == 0){  
            	countList.add(returnList.get(i));  
            }  
        }
        for(Map<String, Object> count : countList) {  
            System.out.println(count);           
        }
        for(int i = 0; i < countList.size(); i++) {  
            String name = countList.get(i).get("name").toString();
            String sun = countList.get(i).get("sun").toString();
            String months = countList.get(i).get("months").toString();
            String mon = months;
            String[] arrayMon = mon.split(",");
            List<String> monList = new ArrayList<String>();
            for (String strMon : arrayMon)
            	{
            		monList.add(strMon);
            	}           
            String sum = sun;
            String[] array = sum.split(",");
            List<String> sumList = new ArrayList<String>();
            for (String str : array)
            	{
            		sumList.add(str);
            	}
            FlxoaBarCharts barCharts = new FlxoaBarCharts();
           
    		barCharts.setName(name);
    		barCharts.setType("bar");
    		barCharts.setData(sumList);
    		
    		barList.add(barCharts);
        }
        String[]  arrayColor = {"#4099ff","#FFB64D","#2ed8b6","#FF5370","#00bcd4","#EA4C89","#3c5a99","#DD4B39","#BDC3C7","#CB2027","#81e73e","#ff8933","#4ea5e0","#ba33ff","#ea6557"};

        for(int i=0;i< barList.size();i++){
        	
        	for(int p=0;p<arrayColor.length;p++){
        		if(i==p){        			
        			barList.get(i).setColor(arrayColor[p]);
        		}
        	}
        }       
        JSONArray js =JSONArray.fromObject(barList);
		System.out.print(js.toString());		
		return js.toString();
	}
	//待审批
	@ResponseBody
	@RequestMapping(value = "homepage/formnoapply",produces="text/html;charset=UTF-8")
	public String showFormNoapply(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		
		String start = request.getParameter("start"); 
		String length = request.getParameter("length");
		String draw = request.getParameter("draw");
		if (start==""||start==null){
			start="0";
		}
		if(length==""||length==null){
			length="6";
		}
		String userid = request.getSession().getAttribute("userId").toString();
		
		
		return flxoaStatisticalService.queryFormNoApproval(Integer.valueOf(start),Integer.valueOf(length),draw,userid);

	}
	/**
	 * 首页 我的项目 （包括 保存项目 + 立项）
	 */
	@ResponseBody
	@RequestMapping(value = "homepage/myproject",produces="text/html;charset=UTF-8")
	public String showMyProject(HttpServletRequest request,HttpServletResponse response,ModelMap model){		
		String start = request.getParameter("start"); 
		String length = request.getParameter("length");
		String draw = request.getParameter("draw");
		if (start==""||start==null){
			start="0";
		}
		if(length==""||length==null){
			length="6";
		}
		String userid = request.getSession().getAttribute("userId").toString();		
		
		return flxoaStatisticalService.queryMyProject(Integer.valueOf(start),Integer.valueOf(length),draw,userid);

	}
	/**
	 * 统计个人考勤情况
	 */
	@ResponseBody
	@RequestMapping(value ="homepage/signinpersonal",produces = "text/html;charset=utf-8")
	public String personalAttendanceStatistics(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		
		String start = request.getParameter("start"); 
		String length = request.getParameter("length");
		String draw = request.getParameter("draw");
		if (start==""||start==null){
			start="0";
		}
		if(length==""||length==null){
			length="10";
		}
		//根据权限判断 传userid 还是deptid 查询人员的cardid
		String userid = request.getSession().getAttribute("userId").toString();	
		
		return flxoaStatisticalService.queryPersonSign(Integer.valueOf(start),Integer.valueOf(length),draw, userid);		
	}
	/**
	 * 首页 所管部门的考勤统计次数
	 */
	@ResponseBody
	@RequestMapping(value = "homepage/showdeptsign",produces="text/html;charset=UTF-8")
	public String showMyDeptSign(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		
		String start = request.getParameter("start"); 
		String length = request.getParameter("length");
		String draw = request.getParameter("draw");
		if (start==""||start==null){
			start="0";
		}
		if(length==""||length==null){
			length="10";
		}
		
		String path =request.getServletPath()+request.getPathInfo();
		int userId = Integer.parseInt(String.valueOf(request.getSession().getAttribute("userId")));
		Map<String,List<Integer>>  map = Permission.getRolePermission(userId, path);	
		String deptIds =  Permission.getDepartMentIds(map);
		
		return flxoaStatisticalService.querySumDept(Integer.valueOf(start),Integer.valueOf(length),draw,deptIds);

	}
	/**
	 * 首页 我的报销 我的借款 统计
	 */
	@ResponseBody
	@RequestMapping(value = "homepage/showmymoney",produces="text/html;charset=UTF-8")
	public String showMyMoney(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		//1本月 2本年
		String dateType = request.getParameter("dateType");
		//48报销申请单 47借款单
		int templateId = Integer.parseInt(String.valueOf(request.getParameter("templateId")));
		//申请人 UserID
		int createUserId = Integer.parseInt(String.valueOf(request.getSession().getAttribute("userId")));
		FlxoaApproveForm flxoaApproveForm = new FlxoaApproveForm();
		flxoaApproveForm.setCreateUserId(createUserId);
		if(null != dateType){
			if("1".equals(dateType)){
				//获取当月的第一天时间戳,作为当月查询
				flxoaApproveForm.setStartTime(DateUtils.getMonthStart());					
			}else if("2".equals(dateType)){
				//获取今年的第一天时间戳,作为本年查询
				flxoaApproveForm.setStartTime(DateUtils.getYearStart());					
			}
		}
		//1待审核 2审核中 3通过
		flxoaApproveForm.setStates("1,2,3");
		flxoaApproveForm.setTemplateId(templateId);
		List<FlxoaApproveForm> list = null;

		list = flxoaApproveFormService.query(flxoaApproveForm);

		
		
		
		FlxoaApproveFormdata flxoaApproveFormdata = new FlxoaApproveFormdata();
		for (int i = 0; i < list.size(); i++) {
			FlxoaApproveFormdata data = new FlxoaApproveFormdata();
			//48报销申请单 47借款单
			if(48 == templateId){
				//金额合计
				data.setDataKey("reim_money_sum");
			}else if(47 == templateId){
				//小写
				data.setDataKey("money_lower");
			}
			data.setFormId(list.get(i).getId());
			flxoaApproveFormdata.getList().add(data);
		}
		//合计金额
		BigDecimal sum = new BigDecimal(0);
		if(flxoaApproveFormdata.getList().size() > 0){
			List<FlxoaApproveFormdata> listFormData =  flxoaApproveFormdataService.query(flxoaApproveFormdata);
			for (int i = 0; i < listFormData.size(); i++) {
				String money = "0";
				if(!"".equals(listFormData.get(i).getDataValue())&&!CommonUtils.isNumber(listFormData.get(i).getDataValue())){
					money = listFormData.get(i).getDataValue();
					sum = sum.add(new BigDecimal(money));
				}
			}			
		}

		JSONObject obj = new JSONObject();
		obj.put("sum", sum.toString());
		return obj.toString();
	}
	/**
	 * 首页 我的关注项目
	 */
	@ResponseBody
	@RequestMapping(value = "homepage/showmyfocusproject",produces="text/html;charset=UTF-8")
	public String showMyFocusProject(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		
		String start = request.getParameter("start"); 
		String length = request.getParameter("length");
		String draw = request.getParameter("draw");
		if (start==""||start==null){
			start="0";
		}
		if(length==""||length==null){
			length="6";
		}
		String userid = request.getSession().getAttribute("userId").toString();		
		
		return flxoaStatisticalService.queryMyFocusProject(Integer.valueOf(start),Integer.valueOf(length),draw,userid);

	}
}

