package com.flx.flxoa.info.clientsManagement.controller;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flx.flxoa.common.util.CommonUtils;
import com.flx.flxoa.common.util.DateUtils;
import com.flx.flxoa.common.util.RRHeadSeting;
import com.flx.flxoa.info.clientsManagement.entity.FlxoaClientInformation;
import com.flx.flxoa.info.system.comon.Permission;
import com.flx.flxoa.info.clientsManagement.manager.FlxoaClientInformationService;

@Controller
public class FlxoaClientInformationController {

	protected FlxoaClientInformationService flxoaClientInformationService;
	@Autowired
	public void getFlxoaClientInformationService(FlxoaClientInformationService flxoaClientInformationService){
		this.flxoaClientInformationService=flxoaClientInformationService;
	}
	//显示客户列表页面
	@RequestMapping(value = "clientslist")
	public String projectList(HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		
		return "nk/pages/clientsManage/clientInfoManage";
	}
	/*查询客户列表数据信息*/
	@RequestMapping("queryclients")
	@ResponseBody
	public String getClientsInfo(HttpServletRequest request,HttpServletResponse response,FlxoaClientInformation flxoaclientInfo)throws UnsupportedEncodingException,ParseException{
		
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
		
		/*获取查询参数*/
		String clientName=request.getParameter("clientName");//客户名称
		String clientRank=request.getParameter("clientRank");//客户等级
		String clientTrade=request.getParameter("clientTrade");//客户行业
		String clientFollower=request.getParameter("clientFollower");//客户跟单人
		String clientFollowerDept=request.getParameter("clientFollowerDept");//客户跟单人部门
		
		
		Map<String,String> map=new HashMap<String,String>();
		map.put("draw", draw);
		map.put("start", start);
		map.put("length", length);
		map.put("client_name",clientName );
		map.put("client_rank",clientRank );
		map.put("client_trade",clientTrade );
		map.put("client_follower",clientFollower );
		map.put("client_follower_dept",clientFollowerDept );
		return flxoaClientInformationService.queryForPage(map);
		
	}
	
	/*根据id删除客户信息*/
	@RequestMapping("/deleteclient")
	@ResponseBody
	public String deleteClient(HttpServletRequest request,HttpServletResponse response,FlxoaClientInformation flxoaclientInfo)throws UnsupportedEncodingException,ParseException{
		Map<String,Object> headMap=RRHeadSeting.setHeading(request,response);
		request=(HttpServletRequest) headMap.get("request");
		response=(HttpServletResponse) headMap.get("response");
		
		String clientId=request.getParameter("client_id");
		System.out.println("client_id:===="+clientId);
		String isDel="0";
		boolean delResult=false;
		if(!CommonUtils.isEmpty(clientId)){
			flxoaclientInfo.setId(Integer.parseInt(clientId));
			delResult=flxoaClientInformationService.delete(flxoaClientInformationService.queryById(flxoaclientInfo));
		}
		if(delResult){
			isDel="1";
		}
		return isDel;
	}
	
	/*根据id查看客户信息*/
	@RequestMapping("/queryclientById")
	@ResponseBody
	public String getClientById(HttpServletRequest request,HttpServletResponse response,FlxoaClientInformation flxoaclientInfo)throws UnsupportedEncodingException,ParseException{
		Map<String,Object> headMap=RRHeadSeting.setHeading(request,response);
		request=(HttpServletRequest) headMap.get("request");
		response=(HttpServletResponse) headMap.get("response");
		
		String clientId=request.getParameter("client_id");
		if(!CommonUtils.isEmpty(clientId)){
			flxoaclientInfo.setId(Integer.parseInt(clientId));
		}
		JSONObject json=new JSONObject();
		json=JSONObject.fromObject(flxoaClientInformationService.queryById(flxoaclientInfo));
		return json.toString();
	}
	/*根据跟单人id查找客户信息列表*/
	@RequestMapping("/getclientsbyfid")
	@ResponseBody
	public String getClientsByFid(HttpServletRequest request,HttpServletResponse response,FlxoaClientInformation flxoaclientInfo)throws UnsupportedEncodingException,ParseException{
		Map<String,Object> headMap=RRHeadSeting.setHeading(request, response);
		request=(HttpServletRequest) headMap.get("request");
		response=(HttpServletResponse) headMap.get("response");
		String start=request.getParameter("start");
		String length=request.getParameter("length");
		String draw=request.getParameter("draw");
		if(start==""||start==null){
			start="0";
		}
		if(length==""||length==null){
			length="10";
		}
		String fid=request.getParameter("fid");
		System.out.println("start:==="+start+";length:===="+length+";fid:===="+fid);
		Map<String,String> map=new HashMap<String,String>();
		map.put("start", start);
		map.put("length", length);
		map.put("draw", draw);
		map.put("fid", fid);
		return flxoaClientInformationService.queryForPageByFid(map);
	}
	/*添加客户信息*/
	@RequestMapping("/addclient")
	@ResponseBody
	public String addClient(HttpServletRequest request,HttpServletResponse response,FlxoaClientInformation flxoaclientInfo)throws UnsupportedEncodingException,ParseException{
		Map<String,Object> headMap=RRHeadSeting.setHeading(request,response);
		request=(HttpServletRequest) headMap.get("request");
		response=(HttpServletResponse) headMap.get("response");
		/*标记是否添加成功*/
		String isAdd="0";
		/*研究问题：请求只能接收字符串，没办法接收对象类型？*/
		//boolean isAdd=false;
		/*获取要添加的信息项*/
		String clientName=request.getParameter("client_name");//客户名称
		int clientBusiness=Integer.parseInt(request.getParameter("client_business"));//客户业务类型
		int clientTrade=Integer.parseInt(request.getParameter("client_trade"));//客户行业
		String clientAddress=request.getParameter("client_address");//客户地址
		String clientSalesman=request.getParameter("client_salesman");//客户业务员
		String clientURL=request.getParameter("client_url");//客户网址
		String clientPhone=request.getParameter("client_phone");//客户座机号
		String clientMail=request.getParameter("client_mail");//客户邮箱
		String clientCellphone=request.getParameter("client_cellphone");//客户手机号
		String clientPostcode=request.getParameter("client_postcode");//客户邮编
		String clientFax=request.getParameter("client_fax");//客户传真号
		String clientComment=request.getParameter("client_comment");//客户信息备注
		
		flxoaclientInfo.setClientName(clientName);
		flxoaclientInfo.setClientRank(0);
		flxoaclientInfo.setClientBusiness(clientBusiness);
		flxoaclientInfo.setClientTrade(clientTrade);
		flxoaclientInfo.setClientAddress(clientAddress);
		flxoaclientInfo.setClientSalesman(clientSalesman);
		flxoaclientInfo.setClientSiteurl(clientURL);
		flxoaclientInfo.setClientPhone(clientPhone);
		flxoaclientInfo.setClientMail(clientMail);
		flxoaclientInfo.setClientCellphone(clientCellphone);
		flxoaclientInfo.setClientPostcode(clientPostcode);
		flxoaclientInfo.setClientFax(clientFax);
		flxoaclientInfo.setComments(clientComment);
		/*添加共通字段数据*/
		flxoaclientInfo.setCreateDepartmentId(Integer.parseInt(String.valueOf(headMap.get("deptId"))));
		flxoaclientInfo.setCreateUserId(Integer.parseInt(String.valueOf(headMap.get("userId"))));
		flxoaclientInfo.setCreateTime(DateUtils.getSecondTimestamp(new Date()));
		flxoaclientInfo.setUpdateDepartmentId(Integer.parseInt(String.valueOf(headMap.get("deptId"))));
		flxoaclientInfo.setUpdateUserId(Integer.parseInt(String.valueOf(headMap.get("userId"))));
		flxoaclientInfo.setUpdateTime(DateUtils.getSecondTimestamp(new Date()));
		
		if(flxoaClientInformationService.add(flxoaclientInfo)){
			isAdd="1";
		}
		//isAdd=flxoaClientInformationService.add(flxoaclientInfo);
		System.out.println("响应头：====="+response.getContentType());
		System.out.println("返回字段isupdate：====="+isAdd);
		return isAdd;
	}
	/*修改客户跟单人*/
	@RequestMapping("/updateclientfollower")
	@ResponseBody
	public String updateClientFollower(HttpServletRequest request,HttpServletResponse response,FlxoaClientInformation flxoaclientInfo)throws UnsupportedEncodingException,ParseException{
		Map<String,Object> headMap=RRHeadSeting.setHeading(request, response);
		request=(HttpServletRequest) headMap.get("request");
		response=(HttpServletResponse) headMap.get("response");
		String isUpdate="";
		String id=request.getParameter("id");
		String fid=request.getParameter("fid");
		if(!CommonUtils.isEmpty(id)){
			flxoaclientInfo.setId(Integer.parseInt(id));
			flxoaclientInfo=flxoaClientInformationService.queryById(flxoaclientInfo);
		}
		if(!CommonUtils.isEmpty(fid)){
			flxoaclientInfo.setCreateUserId(Integer.parseInt(fid));
		}

		if(flxoaClientInformationService.update(flxoaclientInfo)){
			isUpdate="1";
		}
		return isUpdate;
	}
	/*修改客户信息*/
	@RequestMapping("/updateclient")
	@ResponseBody
	public String updateClient(HttpServletRequest request,HttpServletResponse response,FlxoaClientInformation flxoaclientInfo)throws UnsupportedEncodingException,ParseException{
		Map<String,Object> headMap=RRHeadSeting.setHeading(request, response);
		request=(HttpServletRequest) headMap.get("request");
		response=(HttpServletResponse) headMap.get("response");
		/*标记是否修改成功*/
		String isUpdate="0";
		/*获取要添加的信息项*/
		int id=Integer.parseInt(request.getParameter("client_id"));
		String clientName=request.getParameter("client_name");//客户名称
		int clientBusiness=Integer.parseInt(request.getParameter("client_business"));//客户业务类型
		int clientTrade=Integer.parseInt(request.getParameter("client_trade"));//客户行业
		String clientAddress=request.getParameter("client_address");//客户地址
		String clientSalesman=request.getParameter("client_salesman");//客户业务员
		String clientURL=request.getParameter("client_url");//客户网址
		String clientPhone=request.getParameter("client_phone");//客户座机号
		String clientMail=request.getParameter("client_mail");//客户邮箱
		String clientCellphone=request.getParameter("client_cellphone");//客户手机号
		String clientPostcode=request.getParameter("client_postcode");//客户邮编
		String clientFax=request.getParameter("client_fax");//客户传真号
		String clientComment=request.getParameter("client_comment");//客户信息备注
		
		flxoaclientInfo.setId(id);
		flxoaclientInfo=flxoaClientInformationService.queryById(flxoaclientInfo);
		System.out.println("78788787:==="+flxoaclientInfo.getId());
		
		flxoaclientInfo.setClientName(clientName);
		flxoaclientInfo.setClientBusiness(clientBusiness);
		flxoaclientInfo.setClientTrade(clientTrade);
		flxoaclientInfo.setClientAddress(clientAddress);
		flxoaclientInfo.setClientSalesman(clientSalesman);
		flxoaclientInfo.setClientSiteurl(clientURL);
		flxoaclientInfo.setClientPhone(clientPhone);
		flxoaclientInfo.setClientMail(clientMail);
		flxoaclientInfo.setClientCellphone(clientCellphone);
		flxoaclientInfo.setClientPostcode(clientPostcode);
		flxoaclientInfo.setClientFax(clientFax);
		flxoaclientInfo.setComments(clientComment);
		/*添加共通字段数据*/
		flxoaclientInfo.setUpdateDepartmentId(Integer.parseInt(String.valueOf(headMap.get("deptId"))));
		flxoaclientInfo.setUpdateUserId(Integer.parseInt(String.valueOf(headMap.get("userId"))));
		flxoaclientInfo.setUpdateTime(DateUtils.getSecondTimestamp(new Date()));
		
		if(flxoaClientInformationService.update(flxoaclientInfo)){
			isUpdate="1";
		}
		return isUpdate;
	}
	
	
}
