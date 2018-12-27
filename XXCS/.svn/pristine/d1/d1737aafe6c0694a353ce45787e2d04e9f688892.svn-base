package com.flx.flxoa.info.system.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flx.flxoa.common.util.DateUtils;
import com.flx.flxoa.info.system.entity.FlxoaSystemFuncation;
import com.flx.flxoa.info.system.entity.FlxoaSystemUser;
import com.flx.flxoa.info.system.entity.FunctionJsonBean;
import com.flx.flxoa.info.system.manager.FlxoaSystemFuncationService;
import com.flx.flxoa.info.system.manager.FlxoaSystemUserService;

/**
 * 类名称：FlxoaSystemFuncationController.java
 * 类描述：
 * 创建时间：2018-3-18, 下午2:21:29
 * 
 * @version 1.0 
 * @since JDK版本 1.7
 * @author 刘凯 
 */
/**
 * @author liukai
 *
 */
@Controller
public class FlxoaSystemFuncationController {

	protected FlxoaSystemFuncationService flxoaSystemFuncationService;
	protected  FlxoaSystemUserService flxoaSystemUserService;

	@Autowired
	public void setSystemFuncationService(FlxoaSystemFuncationService flxoaSystemFuncationService) {
		this.flxoaSystemFuncationService = flxoaSystemFuncationService;
	}
	@Autowired
	public void setSystemUserService(FlxoaSystemUserService flxoaSystemUserService) {
		this.flxoaSystemUserService = flxoaSystemUserService;
	}
	
	
	@RequestMapping(value = "/function/golist")
	public String goList(HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		
		return "nk/pages/system/function";
	}
	
	@RequestMapping(value = "/function/getlist",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getList(HttpServletRequest request,HttpServletResponse response, ModelMap model) throws UnsupportedEncodingException {
		//需要选中的ids
		String checkIds = "";
		if(null != request.getParameter("checkIds")){
			checkIds = request.getParameter("checkIds");
		}
		List<FlxoaSystemFuncation> list = flxoaSystemFuncationService.query(null);
		if(!"".equals(checkIds)){
			for (int i = 0; i < list.size(); i++) {
				//根据传来的参数需要选中的ids
				if(!"".equals(checkIds)){
					if(-1 != checkIds.indexOf(",")){
						String [] temp = checkIds.split(",");
						for (int k = 0; k < temp.length; k++) {
							if(list.get(i).getId() == Integer.parseInt(temp[k])){
								list.get(i).setChecked(true);
							}
						}
					}else{
						if(list.get(i).getId() == Integer.parseInt(checkIds)){
							list.get(i).setChecked(true);
						}
					}						
				}				
				String url = list.get(i).getUrl();
				list.get(i).setUrlBack(url);
				list.get(i).setUrl("");
			}	

		}else{
			for (int i = 0; i < list.size(); i++) {
				String url = list.get(i).getUrl();
				list.get(i).setUrlBack(url);
				list.get(i).setUrl("");
			}			
		}

		JSONArray json = JSONArray.fromObject(list);
		return json.toString();
	}
	
	
	/**
	 * 首页菜单展示
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/function/getindexlist",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getIndexList(HttpServletRequest request,HttpServletResponse response, ModelMap model) throws UnsupportedEncodingException {
		FlxoaSystemFuncation flxoaSystemFuncation = new FlxoaSystemFuncation();
		flxoaSystemFuncation.setIsMenu("0");
		List<FlxoaSystemFuncation> list = new ArrayList<FlxoaSystemFuncation>();
		int userId = Integer.parseInt(String.valueOf(request.getSession().getAttribute("userId")));
		if(1 != userId){
			//普通用户 过滤首页菜单树
			FlxoaSystemUser flxoaSystemUser = new FlxoaSystemUser();
			flxoaSystemUser.setId(userId);
			//获取用户拥有的权限
			List<FlxoaSystemUser> listUser = flxoaSystemUserService.findUserPermisson(flxoaSystemUser);
			if(null != listUser){
				Map<String,FlxoaSystemFuncation> map = new LinkedHashMap<String,FlxoaSystemFuncation>();
				for (int i = 0; i < listUser.size(); i++) {
					if(!"null".equals(listUser.get(i).getFunctionId())&&"0".equals(listUser.get(i).getIsMenu()))
					{
						FlxoaSystemFuncation function = new FlxoaSystemFuncation();
						function.setId(Integer.parseInt((listUser.get(i).getFunctionId())));
						function.setName((listUser.get(i).getFunctionName()));
						function.setUrl((listUser.get(i).getUrl()));
						function.setParentId(Integer.parseInt((listUser.get(i).getFunctionParentId())));
						map.put(listUser.get(i).getFunctionName(), function);							
					}
				}
				//遍历map
				for (Entry<String, FlxoaSystemFuncation> entry : map.entrySet()) {
				    list.add(entry.getValue());
				}	
			}
		}else{
			list = flxoaSystemFuncationService.query(flxoaSystemFuncation);
		}
		//点击菜单id
		String activeId = request.getParameter("id");
		FunctionJsonBean baseJsonBean = new FunctionJsonBean();
		//根节点
		baseJsonBean.setId("1");
		baseJsonBean.setName("飞利信内部控制管理系统");
		//获取子级菜单
		FunctionJsonBean jsonBean = getChildFunction(baseJsonBean,list,activeId);
		baseJsonBean.setSubMenu(jsonBean.getSubMenu());
		JSONObject jsonObj = JSONObject.fromObject(jsonBean);
		return jsonObj.toString();
	}
	
	//递归取得子级功能
	private FunctionJsonBean getChildFunction(FunctionJsonBean parentFunctionJsonBean,List<FlxoaSystemFuncation> functionList,String activeId)
	{
		List<FunctionJsonBean> children = new ArrayList<FunctionJsonBean>();
		for (int i = 0; i < functionList.size(); i++) 
		{
			if(parentFunctionJsonBean.getId().equals(String.valueOf(functionList.get(i).getParentId())))
			{
				FunctionJsonBean jsonbean = new FunctionJsonBean();
				jsonbean.setId(String.valueOf(functionList.get(i).getId()));
				jsonbean.setName(functionList.get(i).getName());
				jsonbean.setUrl(functionList.get(i).getUrl());
				jsonbean.setPid(String.valueOf(functionList.get(i).getParentId()));
				//点击菜单的id
				if(jsonbean.getId().equals(activeId))
				{
					jsonbean.setIsActive("1");
				}
				else
				{
					jsonbean.setIsActive("0");
				}
				children.add(getChildFunction(jsonbean,functionList,activeId));
			}
		}
		parentFunctionJsonBean.setSubMenu(children);
		return parentFunctionJsonBean;
	}
	
	@RequestMapping(value = "/function/add",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String add(HttpServletRequest request,HttpServletResponse response, FlxoaSystemFuncation model) throws UnsupportedEncodingException {
		model.setDescription(" ");
		//查询最大的id+1作为排序id
		int maxId = flxoaSystemFuncationService.queryByMaxId();
		int functionSort = maxId+1;
		model.setFunctionSort(functionSort);
		boolean flag = flxoaSystemFuncationService.add(model);
		String result="0";
		if (flag) {
			result = "1";
		}
		return result;
	}
	
	@RequestMapping(value = "/function/update",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String update(HttpServletRequest request,HttpServletResponse response,FlxoaSystemFuncation model) throws UnsupportedEncodingException {
		FlxoaSystemFuncation flxoaSystemFuncation = flxoaSystemFuncationService.queryById(model);
		flxoaSystemFuncation.setName(model.getName());
		flxoaSystemFuncation.setParentId(model.getParentId());
		flxoaSystemFuncation.setUrl(model.getUrl());
		flxoaSystemFuncation.setButtonId(model.getButtonId());
		flxoaSystemFuncation.setIsMenu(model.getIsMenu());

		boolean flag = flxoaSystemFuncationService.update(flxoaSystemFuncation);
		//0失败 1成功
		String result="0";
		if (flag) {
			result = "1";
		}
		return result;
	}
	
	@RequestMapping(value = "/function/updatesort",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String updateSort(HttpServletRequest request,HttpServletResponse response,FlxoaSystemFuncation model) throws UnsupportedEncodingException {
		FlxoaSystemFuncation flxoaSystemFuncation = flxoaSystemFuncationService.queryById(model);
		flxoaSystemFuncation.setFunctionSort(model.getFunctionSort());
		flxoaSystemFuncation.setParentId(model.getParentId());

		boolean flag = flxoaSystemFuncationService.update(flxoaSystemFuncation);
		//0失败 1成功
		String result="0";
		if (flag) {
			result = "1";
		}
		return result;
	}
	
	@RequestMapping(value = "/function/delete",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String delete(HttpServletRequest request,HttpServletResponse response,FlxoaSystemFuncation model) throws UnsupportedEncodingException {
		FlxoaSystemFuncation flxoaSystemFuncation = flxoaSystemFuncationService.queryById(model);
		boolean flag = flxoaSystemFuncationService.delete(flxoaSystemFuncation);
		//0失败 1成功
		String result="0";
		if (flag) {
			result = "1";
		}
		return result;
	}
	
	//根据url列表页  可以显示哪些菜单按钮
	@RequestMapping(value = "/function/getbuttonid",produces="text/html;charset=UTF-8")
	@ResponseBody	
	public String getButtonId(HttpServletRequest request) {
		Date date = new Date();		
		System.out.println("ButtonId第一次===================="+DateUtils.format2(new Date()));
		//String listPath = "/flxoa/function/golist";
		String listPath = request.getParameter("listPath");
		int userId = Integer.parseInt(String.valueOf(request.getSession().getAttribute("userId")));
		FlxoaSystemUser flxoaSystemUser = new FlxoaSystemUser();
		flxoaSystemUser.setId(userId);
		System.out.println("ButtonId第二次===================="+DateUtils.format2(new Date()));
		//获取用户拥有的权限
		List<FlxoaSystemUser> listUser = flxoaSystemUserService.findUserPermisson(flxoaSystemUser);
		String buttonIds = "";
		Map<String,String> map = new HashMap<String,String>();
		System.out.println("ButtonId第三次===================="+DateUtils.format2(new Date()));
		if(1 != userId){
			if(null != listUser){
				String functionId = "";
				for (int i = 0; i < listUser.size(); i++) {
					//是菜单
					if(!"null".equals(listUser.get(i).getFunctionId())&&"0".equals(listUser.get(i).getIsMenu()))
					{
						if(listPath.equals(listUser.get(i).getUrl())){
							functionId = listUser.get(i).getFunctionId();
						}
					}
				}
				for (int i = 0; i < listUser.size(); i++) {
					//不是菜单,查看当前请求 有哪些按钮的权限
					if(!"null".equals(listUser.get(i).getFunctionId())&&
							"1".equals(listUser.get(i).getIsMenu())
							&&functionId.equals(listUser.get(i).getFunctionParentId())){
						
						if(!"".equals(listUser.get(i).getButtonId())){
							map.put(listUser.get(i).getButtonId(), listUser.get(i).getButtonId());
						}
					}
				}
				//遍历map
				for (Entry<String, String> entry : map.entrySet()) {
					if(!"".equals(entry.getValue())){
						buttonIds += entry.getValue()+ ",";
					}
				}
				if(!"".equals(buttonIds)){
					buttonIds = buttonIds.substring(0,buttonIds.length()-1);
				}
			}			
		}else{
			//超级管理员 可以查看 当前请求所有 按钮
			buttonIds = flxoaSystemFuncationService.queryButtonByPath(listPath);
		}
		System.out.println("ButtonId第四次===================="+DateUtils.format2(new Date()));

		return buttonIds;
	}
	
}
