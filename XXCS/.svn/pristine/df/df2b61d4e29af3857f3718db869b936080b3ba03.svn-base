package com.flx.flxoa.info.clientsManagement.controller;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flx.flxoa.common.util.CommonUtils;
import com.flx.flxoa.common.util.DateUtils;
import com.flx.flxoa.common.util.RRHeadSeting;
import com.flx.flxoa.info.clientsManagement.entity.FlxoaClientCommunication;
import com.flx.flxoa.info.clientsManagement.manager.FlxoaClientCommunicationService;

@Controller
public class FlxoaClientCommunicationController {

	protected FlxoaClientCommunicationService clientCommunicationService;
	
	@Autowired
	public void getCommunicationService(FlxoaClientCommunicationService clientCommunicationService){
		this.clientCommunicationService=clientCommunicationService;
	}
	
	@RequestMapping("/commuincationlist")
	public String commuicationList(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		return "/nk/pages/clientsManage/clientCommunicationManage";
	}
	/*获取沟通信息列表*/
	@RequestMapping("/querycomms")
	@ResponseBody
	public String getCommList(HttpServletRequest request,HttpServletResponse response,FlxoaClientCommunication clientComm)throws UnsupportedEncodingException,ParseException{
		/*设置请求响应字符格式*/
		Map<String,Object> headMap=RRHeadSeting.setHeading(request,response);
		request=(HttpServletRequest) headMap.get("request");
		response=(HttpServletResponse) headMap.get("response");
		/*获取分页参数*/
		String draw=request.getParameter("draw");
		String start = request.getParameter("start"); 
		String length = request.getParameter("length");
		if (start==""||start==null){
			start="0";
		}
		if(length==""||length==null){
			length="10";
		}
		/*获取沟通id  用于根据id多表关联查询对应的沟通信息*/
		String commId=request.getParameter("comm_id");//沟通id
		/*获取查询参数*/
		String clientName=request.getParameter("client_name");//客户名称
		String projectName=request.getParameter("proj_name");//项目名称
		String contactName=request.getParameter("contact_name");//客户联系人名称
		String receiverName=request.getParameter("receiver_name");//接待人员名称
		String commStartDate=request.getParameter("comm_startdate");//沟通日期范围开始日期
		String commEndDate=request.getParameter("comm_enddate");//沟通日期范围结束日期
		/*构建分页查询map*/
		Map<String,String> map=new HashMap<String,String>();
		map.put("draw", draw);
		map.put("start", start);
		map.put("length", length);
		map.put("comm_id", commId);
		map.put("client_name", clientName);
		map.put("proj_name", projectName);
		map.put("contact_name",contactName);
		map.put("receiver_name",receiverName);
		map.put("comm_startdate", commStartDate);
		map.put("comm_enddate", commEndDate);
		return clientCommunicationService.queryForPage(map);
	}
	/*根据id获取沟通信息列表 查看沟通信息*/
	@RequestMapping("/querycomm")
	@ResponseBody
	public String getCommById(HttpServletRequest request,HttpServletResponse response,FlxoaClientCommunication clientComm)throws UnsupportedEncodingException,ParseException{
		/*设置请求响应字符格式*/
		Map<String,Object> headMap=RRHeadSeting.setHeading(request,response);
		request=(HttpServletRequest) headMap.get("request");
		response=(HttpServletResponse) headMap.get("response");
		String commId=request.getParameter("comm_id");
		if(!CommonUtils.isEmpty(commId)){
			clientComm.setId(Integer.parseInt(commId));
		}
		JSONObject json=new JSONObject();
		json=JSONObject.fromObject(clientCommunicationService.queryById(clientComm));
		return json.toString();
	}
	/*添加沟通信息*/
	@RequestMapping("/addcomm")
	@ResponseBody
	public String addComm(HttpServletRequest request,HttpServletResponse response,FlxoaClientCommunication clientComm)throws UnsupportedEncodingException,ParseException{
		/*设置请求响应字符格式*/
		Map<String,Object> headMap=RRHeadSeting.setHeading(request,response);
		request=(HttpServletRequest) headMap.get("request");
		response=(HttpServletResponse) headMap.get("response");
		/*是否添加成功标记   0：失败  1：成功*/
		String isAdd="0";
		/*获取要填加的数据*/
		String projectId=request.getParameter("proj_id");//需要添加沟通的项目id
		String contactId=request.getParameter("contact_id");//客户联系人id,前台需要显示名称,电话，职务，邮箱
		//int receiverId=(int) headMap.get("userId");//公司接待人员id，默认为当前登录用
		String commStartTime=request.getParameter("comm_starttime");//沟通开始时间
		String commEndTime=request.getParameter("comm_endtime");//沟通结束时间
		String commPattern=request.getParameter("comm_pattern");//沟通方式  0：电话   1：面谈
		String commMainContent=request.getParameter("comm_maincontent");//沟通的主要内容
		if(!CommonUtils.isEmpty(projectId)){
			clientComm.setProjId(Integer.parseInt(projectId));
		}
		if(!CommonUtils.isEmpty(contactId)){
			clientComm.setContactId(Integer.parseInt(contactId));
		}
		if(!CommonUtils.isEmpty(commStartTime)){
			clientComm.setCommStartTime(DateUtils.dateToTimestamp(commStartTime));
		}
		if(!CommonUtils.isEmpty(commEndTime)){
			clientComm.setCommEndTime(DateUtils.dateToTimestamp(commEndTime));
		}
		if(!CommonUtils.isEmpty(commPattern)){
			clientComm.setCommPattern(Integer.parseInt(commPattern));
		}
		if(!CommonUtils.isEmpty(commMainContent)){
			clientComm.setCommMainContent(commMainContent);
		}
		clientComm.setCreateUserId(Integer.parseInt(String.valueOf(headMap.get("userId"))));
		clientComm.setCreateDepartmentId(Integer.parseInt(String.valueOf(headMap.get("deptId"))));
		clientComm.setCreateTime(DateUtils.getSecondTimestamp(new Date()));
		clientComm.setUpdateUserId(Integer.parseInt(String.valueOf(headMap.get("userId"))));
		clientComm.setUpdateDepartmentId(Integer.parseInt(String.valueOf(headMap.get("deptId"))));
		clientComm.setUpdateTime(DateUtils.getSecondTimestamp(new Date()));
		if(clientCommunicationService.add(clientComm)){
			isAdd="1";
		}
		return isAdd;
	}
	/*根据id删除沟通信息*/
	@RequestMapping("/deletecomm")
	@ResponseBody
	public String deleteComm(HttpServletRequest request,HttpServletResponse response,FlxoaClientCommunication clientComm)throws UnsupportedEncodingException,ParseException{
		/*设置请求响应字符格式*/
		Map<String,Object> headMap=RRHeadSeting.setHeading(request,response);
		request=(HttpServletRequest) headMap.get("request");
		response=(HttpServletResponse) headMap.get("response");
		/*是否删除成功标价  0：失败  1：成功*/
		String isDel="0";
		boolean delResult=false;
		String commId=request.getParameter("comm_id");
		if(!CommonUtils.isEmpty(commId)){
			clientComm.setId(Integer.parseInt(commId));
			delResult=clientCommunicationService.delete(clientCommunicationService.queryById(clientComm));
		}
		if(delResult){
			isDel="1";
		}
		return isDel;
	}
	/*根据id修改沟通信息*/
	@RequestMapping("/updatecomm")
	@ResponseBody
	public String updateComm(HttpServletRequest request,HttpServletResponse response,FlxoaClientCommunication clientComm)throws UnsupportedEncodingException,ParseException{
		/*设置请求响应字符格式*/
		Map<String,Object> headMap=RRHeadSeting.setHeading(request,response);
		request=(HttpServletRequest) headMap.get("request");
		response=(HttpServletResponse) headMap.get("response");
		/*是否修改成功 0：失败  1：成功*/
		String isUpdate="0";
		/*获取沟通id*/
		String commId=request.getParameter("comm_id");
		String contactId=request.getParameter("contact_id");
		/*获取修改参数*/
		String commStartTime=request.getParameter("comm_starttime");//沟通开始时间
		String commEndTime=request.getParameter("comm_endtime");//沟通结束时间
		String commPattern=request.getParameter("comm_pattern");//沟通方式
		String commMainContent=request.getParameter("comm_maincontent");//沟通主要内容
		if(!CommonUtils.isEmpty(commId)){
			clientComm.setId(Integer.parseInt(commId));
		}
		clientComm=clientCommunicationService.queryById(clientComm);
		if(!CommonUtils.isEmpty(contactId)){
			clientComm.setContactId(Integer.parseInt(contactId));
		}
		if(!CommonUtils.isEmpty(commStartTime)){
			clientComm.setCommStartTime(DateUtils.dateToTimestamp(commStartTime));
		}
		if(!CommonUtils.isEmpty(commEndTime)){
			clientComm.setCommEndTime(DateUtils.dateToTimestamp(commEndTime));
		}
		if(!CommonUtils.isEmpty(commMainContent)){
			clientComm.setCommMainContent(commMainContent);
		}
		if(!CommonUtils.isEmpty(commPattern)){
			clientComm.setCommPattern(Integer.parseInt(commPattern));
		}
		clientComm.setUpdateUserId(Integer.parseInt(String.valueOf(headMap.get("userId"))));
		clientComm.setUpdateDepartmentId(Integer.parseInt(String.valueOf(headMap.get("deptId"))));
		clientComm.setUpdateTime(DateUtils.getSecondTimestamp(new Date()));
		if(clientCommunicationService.update(clientComm)){
			isUpdate="1";
		}
		return isUpdate;
	}
}
