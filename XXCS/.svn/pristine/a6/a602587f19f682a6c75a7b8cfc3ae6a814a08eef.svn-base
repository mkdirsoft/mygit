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
import com.flx.flxoa.info.clientsManagement.entity.FlxoaClientContact;
import com.flx.flxoa.info.clientsManagement.manager.FlxoaClientContactService;

@Controller
public class FlxoaClientContactController {

	protected FlxoaClientContactService flxoaClientContactService;
	@Autowired
	public void getFlxoaClientContactService(FlxoaClientContactService contactService){
		this.flxoaClientContactService=contactService;
	}
	
	@RequestMapping("/contactlist")
	public String contactList(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		return "nk/pages/clientsManage/clientContactManage";
	}
	/**
	 * 显示联系人信息列表
	 * */
	@RequestMapping("/querycontacts")
	@ResponseBody
	public String getContactList(HttpServletRequest request,HttpServletResponse response,FlxoaClientContact clientContact)throws UnsupportedEncodingException,ParseException{
		/*设置请求响应字符格式*/
		Map<String,Object> headMap=RRHeadSeting.setHeading(request, response);
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
		String clientId=request.getParameter("client_id");//客户id
		String clientName=request.getParameter("client_name");//客户名称
		String contactName=request.getParameter("contact_name");//联系人名称
		String contactPhone=request.getParameter("contact_phone");//联系人电话
		
		Map<String,String> map=new HashMap<String,String>();
		map.put("start", start);
		map.put("length", length);
		map.put("draw", draw);
		map.put("client_id",clientId);
		map.put("client_name", clientName);
		map.put("contact_name", contactName);
		map.put("contact_phone", contactPhone);
		return flxoaClientContactService.queryForPage(map);
	}
	/**
	 * 添加客户联系人信息
	 * */
	@RequestMapping("/addcontact")
	@ResponseBody
	public String addContact(HttpServletRequest request,HttpServletResponse response,FlxoaClientContact clientContact)throws UnsupportedEncodingException,ParseException{
		Map<String,Object> headMap=RRHeadSeting.setHeading(request,response);
		request=(HttpServletRequest) headMap.get("request");
		response=(HttpServletResponse) headMap.get("response");
		/*是否添加成功标记   0：添加成功  1：添加失败*/
		String isAdd="0";
		/*获取添加数据*/
		String clientId=request.getParameter("client_id");
		String contactName=request.getParameter("contact_name");
		String contactGender=request.getParameter("contact_gender");
		String contactDuty=request.getParameter("contact_duty");
		String contactPhone=request.getParameter("contact_phone");
		String contactMail=request.getParameter("contact_mail");
		if(!CommonUtils.isEmpty(clientId)){
			clientContact.setClientId(Integer.parseInt(clientId));
		}
		if(!CommonUtils.isEmpty(contactName)){
			clientContact.setContactName(contactName);
		}
		if(!CommonUtils.isEmpty(contactGender)){
			clientContact.setContactGender(Integer.parseInt(contactGender));
		}
		if(!CommonUtils.isEmpty(contactDuty)){
			clientContact.setContactDuty(contactDuty);
		}
		if(!CommonUtils.isEmpty(contactPhone)){
			clientContact.setContactPhone(contactPhone);
		}
		if(!CommonUtils.isEmpty(contactMail)){
			clientContact.setContactMail(contactMail);
		}
		clientContact.setCreateUserId(Integer.parseInt(String.valueOf(headMap.get("userId"))));
		clientContact.setCreateDepartmentId(Integer.parseInt(String.valueOf(headMap.get("deptId"))));
		clientContact.setCreateTime(DateUtils.getSecondTimestamp(new Date()));
		clientContact.setUpdateUserId(Integer.parseInt(String.valueOf(headMap.get("userId"))));
		clientContact.setUpdateDepartmentId(Integer.parseInt(String.valueOf(headMap.get("deptId"))));
		clientContact.setUpdateTime(DateUtils.getSecondTimestamp(new Date()));
		if(flxoaClientContactService.add(clientContact)){
			isAdd="1";
		}
		return isAdd;
	}
	/**
	 * 查看客户联系人信息
	 * */
	@RequestMapping("/querycontact")
	@ResponseBody
	public String getContactInfo(HttpServletRequest request,HttpServletResponse response,FlxoaClientContact clientContact)throws UnsupportedEncodingException,ParseException{
		/*设置请求响应字符格式*/
		Map<String,Object> headMap=RRHeadSeting.setHeading(request,response);
		request=(HttpServletRequest) headMap.get("request");
		response=(HttpServletResponse) headMap.get("response");
		/*获取查看的联系人信息id*/
		String id=request.getParameter("contact_id");
		if(!CommonUtils.isEmpty(id)){
			clientContact.setId(Integer.parseInt(id));
		}
		JSONObject json=new JSONObject();
		json=JSONObject.fromObject(flxoaClientContactService.queryById(clientContact));
		return json.toString();
	}
	/**
	 * 删除客户联系人信息
	 **/
	@RequestMapping("/deletecontact")
	@ResponseBody
	public String deleteContact(HttpServletRequest request,HttpServletResponse response,FlxoaClientContact clientContcat) throws UnsupportedEncodingException,ParseException{
		/*设置请求响应字符格式*/
		Map<String,Object> headMap=RRHeadSeting.setHeading(request,response);
		request=(HttpServletRequest) headMap.get("request");
		response=(HttpServletResponse) headMap.get("response");
		/*是否删除成功标记 0:删除失败   1：删除成功*/
		String isDel="0";
		boolean delResult=false;
		/*获取要删除的联系人信息id*/
		String id=request.getParameter("contact_id");
		if(!CommonUtils.isEmpty(id)){
			clientContcat.setId(Integer.parseInt(id));
			delResult=flxoaClientContactService.delete(flxoaClientContactService.queryById(clientContcat));
		}
		if(delResult){
			isDel="1";
		}
		return isDel;
	}
	/**
	 * 根据id修改客户联系人信息
	 * */
	@RequestMapping("/updatecontact")
	@ResponseBody
	public String updateContact(HttpServletRequest request,HttpServletResponse response,FlxoaClientContact clientContact) throws UnsupportedEncodingException,ParseException{
		/*设置请求响应字符格式*/
		Map<String,Object> headMap=RRHeadSeting.setHeading(request,response);
		request=(HttpServletRequest) headMap.get("request");
		response=(HttpServletResponse) headMap.get("response");
		/*标记是否修改成功 0:失败  1:成功*/
		String isUpdate="0";
		/*获取要修改的客户联系人信息id*/
		String id=request.getParameter("contact_id");
		/*获取修改信息*/
		String clientId=request.getParameter("client_id");
		String contactName=request.getParameter("contact_name");
		String contactGender=request.getParameter("contact_gender");
		String contactDuty=request.getParameter("contact_duty");
		String contactPhone=request.getParameter("contact_phone");
		String contactMail=request.getParameter("contact_mail");
		if(!CommonUtils.isEmpty(id)){
			clientContact.setId(Integer.parseInt(id));
		}
		clientContact=flxoaClientContactService.queryById(clientContact);
		if(!CommonUtils.isEmpty(clientId)){
			clientContact.setClientId(Integer.parseInt(clientId));
		}
		if(!CommonUtils.isEmpty(contactGender)){
			clientContact.setContactGender(Integer.parseInt(contactGender));
		}
		if(!CommonUtils.isEmpty(contactDuty)){
			clientContact.setContactDuty(contactDuty);
		}
		if(!CommonUtils.isEmpty(contactName)){
			clientContact.setContactName(contactName);
		}
		if(!CommonUtils.isEmpty(contactPhone)){
			clientContact.setContactPhone(contactPhone);
		}
		if(!CommonUtils.isEmpty(contactMail)){
			clientContact.setContactMail(contactMail);
		}
		clientContact.setUpdateUserId(Integer.parseInt(String.valueOf(headMap.get("userId"))));
		clientContact.setUpdateDepartmentId(Integer.parseInt(String.valueOf(headMap.get("deptId"))));
		clientContact.setUpdateTime(DateUtils.getSecondTimestamp(new Date()));
		if(flxoaClientContactService.update(clientContact)){
			isUpdate="1";
		}
		return isUpdate;
	}
}
