package com.flx.flxoa.info.market.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.lang.model.element.Element;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.record.PasswordRecord;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flx.flxoa.common.util.Aes;
import com.flx.flxoa.info.market.entity.HxUser;
import com.flx.flxoa.info.market.manager.HxUserService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
@Controller
public class XxcsLoginController {
	private static final String KEY = null;
	protected HxUserService hxUserService;
	@Autowired
	public void setHxUserService(
			HxUserService hxUserService) {
		this.hxUserService = hxUserService;
	}
	/**
	 * 手机登录
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/LoginTel")
	@ResponseBody
	public String LoginTel(HttpServletRequest request,HttpServletResponse response, HttpSession httpSession, ModelMap model ) throws UnsupportedEncodingException {
		Map map = new HashMap<>();
		Aes aes = new Aes();
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		response.setHeader("Access-Control-Allow-Methods", "POST");
		response.setHeader("Access-Control-Max-Age", "0");
		response.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,userId,token");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("XDomainRequestAllowed","1");		
		String user = "";
		String pass = "";
		//手机号-正则表达式：验证手机号
//		String phoneReg = "(^1[3|4|5|6|7|8|9]\\d{9}$)|(^09\\d{8}$)";
//		String passw = "/^[a-zA-Z\\d_]{8,}$/" ;
		//用户名
		String userName = request.getParameter("username");
		//密码
		String password = request.getParameter("password");
		System.out.println("userName"+userName);
		System.out.println("password"+password);
		String deco = null;
		deco = URLEncoder.encode(userName,"UTF-8");
		String searcName=java.net.URLDecoder.decode(deco,"UTF-8");
		String searcPass=java.net.URLDecoder.decode(password,"UTF-8");
		System.out.println("userName"+searcName);
		System.out.println("password"+searcPass);
		//解密
		user = aes.aesDecrypt(searcName);
		//解密
		pass = aes.aesDecrypt(searcPass);
		System.out.println("user"+user);
		System.out.println("pass"+pass);
//		 Subject subject = SecurityUtils.getSubject();
//		 UsernamePasswordToken token = new UsernamePasswordToken(userName,password);
//		 String tokenPassword = String.valueOf(token.getPassword());
		try {
			if(null != user && user != ""){
				//if(Pattern.matches(phoneReg, user)  && Pattern.matches(passw, pass)) {
					HxUser u = new HxUser();
					u.setTel(user);
					HxUser hxUser = hxUserService.findUserDetialByUserName(u);
					if(hxUser != null && !"".equals(hxUser)){
						//登录密码和数据库密码比较
						String passwords = hxUser.getPassWord();
						if(passwords.equals(pass) ){
							//手机端 session登录后永不超时
							httpSession.setMaxInactiveInterval(-1);
							httpSession.setAttribute("userId", String.valueOf(hxUser.getUserId()));
							httpSession.setAttribute("username", String.valueOf(hxUser.getTel()));
							httpSession.setAttribute("user",hxUser);
							
							map.put("code", 200);
							map.put("userId", String.valueOf(hxUser.getUserId()));
							map.put("Msg","成功");
						}else{
							map.put("code", 500);
							map.put("Msg","用户名或密码错误");
						}
					}else{
						map.put("code", 500);
						map.put("Msg","用户名或密码错误");
					}
//				}else {
//					map.put("code", 500);
//					map.put("Msg","手机号或密码不符合规则");
//			}
			}else {
				map.put("code", 500);
				map.put("Msg","用户名或密码错误");
			}
		} catch (UnknownAccountException e) {
			map.put("code", 500);
			map.put("Msg","用户名或密码错误");
		}
		JSONObject json = JSONObject.fromObject(map);
		return json.toString();
	}
}
