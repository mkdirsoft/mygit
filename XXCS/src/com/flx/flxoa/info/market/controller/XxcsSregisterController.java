package com.flx.flxoa.info.market.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flx.flxoa.common.util.MD5Encode;
import com.flx.flxoa.common.util.PhoneCode;
import com.flx.flxoa.info.market.entity.HxUser;
import com.flx.flxoa.info.market.manager.HxUserService;
import com.alibaba.fastjson.JSONObject;

@Controller
public class XxcsSregisterController {
	
	protected HxUserService hxUserService;
	@Autowired
	public void setHxUserService(
			HxUserService hxUserService) {
		this.hxUserService = hxUserService;
	}
	
	/**
	 * 获取验证码
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/registerCode", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String register(HttpServletRequest request){
		String tel = request.getParameter("username");
		
		return PhoneCode.getPhonemsg(tel, request);
	}
	
	
	/**
	 * @param request
	 * @param response
	 * @param model
	 * @return 航信注册
	 */
	@RequestMapping(value = "/Register", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String  Register(HttpServletRequest request,HttpServletResponse response, HxUser model){
		Map map = new HashMap<>();
		//获取验证码
		JSONObject json = (JSONObject)request.getSession().getAttribute("verifyCode");
		String password = request.getParameter("password");
		//手机验证码
		String codes = request.getParameter("code");
		String phone = request.getParameter("username");
		//用户密码加密
		String Md5pass = MD5Encode.MD5("password");
		//根据根据手机号查询是否已注册，已注册为true，反之false
		boolean username = hxUserService.isExist(request.getParameter("username"));
		//tel为false 时已有该用户
		if(username){
			if(!json.getString("code").equals(codes)){
				return (String) map.put("msg", "验证码错误");
			}
			if((System.currentTimeMillis() - json.getLong("createTime")) > 1000 * 60 * 5){
				
				return (String) map.put("msg", "验证码过期");
			}
			//用户姓名
			model.setUserType("3");
			model.setTel(phone);
			model.setPassWord(password);
			boolean b = hxUserService.add(model);
			if (b) {
				map.put("code", 200);
				map.put("Msg","成功");
			}
			
		}else{
			map.put("code", 500);
			map.put("Msg","该手机号已注册");
		}
		JSONArray jsonss = new JSONArray();
		jsonss.put(map);
		return jsonss.toString();
	}

	
	/**
	 * 忘记密码-获取验证码
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/forgetPassword", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String forgetPassword(HttpServletRequest request){
		Map map = new HashMap<>();
		//获取验证码
		JSONObject json = (JSONObject)request.getSession().getAttribute("verifyCode");
		//获取手机号
		String phone = request.getParameter("phone");
		//获取验证码
		String codes = request.getParameter("phone");
		//验证手机号是否存在
		boolean username = hxUserService.isExist(phone);
		if(username){
			map.put("code", 500);
			map.put("Msg","该手机号不存在");
		}else {
			return PhoneCode.getPhonemsg(phone, request);
		}
		JSONArray jsonss = new JSONArray();
		jsonss.put(map);
		return jsonss.toString();
	}
	
	/**
	 * 验证-获取验证码
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/verificationCode", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String verificationCode(HttpServletRequest request){
		Map map = new HashMap<>();
		//获取验证码
		JSONObject json = (JSONObject)request.getSession().getAttribute("verifyCode");
		//获取验证码-页面
		String codes = request.getParameter("Code");
		
		if(!json.getString("code").equals(codes)){
			return (String) map.put("msg", "验证码错误");
		}
		if((System.currentTimeMillis() - json.getLong("createTime")) > 1000 * 60 * 5){
			
			return (String) map.put("msg", "验证码过期");
		}
		map.put("code", 200);
		map.put("Msg","成功");
		JSONArray jsonss = new JSONArray();
		jsonss.put(map);
		return jsonss.toString();
	}
	
	/**
	 * 忘记密码-修改密码
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/passwordUp", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String passwordUp(HttpServletRequest request){
		Map map = new HashMap<>();
		HxUser hxUser = new HxUser();
		//获取手机号
		String phone = request.getParameter("phone");
		//获取密码
		String passWord = request.getParameter("passWord");
		//验证手机号是否存在
		boolean username = hxUserService.isExist(phone);
		if(username){
			map.put("code", 500);
			map.put("Msg","该手机号不存在");
		}else {
			hxUser.setTel(phone);
			//根据手机号码查询用户表
			HxUser hxUserList = hxUserService.queryById(hxUser);
			//修改数据-密码：先查后改
			hxUserList.setPassWord(passWord);
			boolean b = hxUserService.update(hxUserList);
			if(b) {
				map.put("code", 200);
				map.put("Msg","成功");
			}else {
				map.put("code", 500);
				map.put("Msg","系统错误");
			}
		}
		JSONArray jsonss = new JSONArray();
		jsonss.put(map);
		return jsonss.toString();
	}
}
