package com.flx.flxoa.info.system.controller;

import static org.apache.shiro.web.filter.authc.FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.flx.flxoa.info.system.entity.FlxoaSystemUser;
import com.flx.flxoa.info.system.manager.FlxoaSystemUserService;

@Controller
public class LoginController {

    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

	protected FlxoaSystemUserService flxoaSystemUserService;

	public FlxoaSystemUserService getFlxoaSystemUserService() {
		return flxoaSystemUserService;
	}
	@Autowired
	public void setFlxoaSystemUserService(
			FlxoaSystemUserService flxoaSystemUserService) {
		this.flxoaSystemUserService = flxoaSystemUserService;
	}	
	/**
	 * 没有登陆的情况下，访问登陆界面时，url访问到这个action
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		String url = request.getRequestURL().toString();
		logger.debug("访问地址：{}",url);
		//如果是已经登录了 清除登录信息
//		Subject subject = SecurityUtils.getSubject();
//		if (subject.isAuthenticated()){
//	        //清空登录用户session
//	        request.getSession().removeAttribute("userId");
//	        request.getSession().removeAttribute("userName");
//	        request.getSession().removeAttribute("realName");
//	        request.getSession().removeAttribute("departmentId");
//	        request.getSession().removeAttribute("companyId");			
//			subject.logout();
//		}
		return "login";
	}
	
//	/**
//	 * 退出登录返回到登录页    已在FlxoaSystemLogoutFilter 实现退出登录
//	 * 
//	 * @param request
//	 * @param response
//	 * @param model
//	 * @return
//	 */
//	@RequestMapping(value = "/logout", method = RequestMethod.GET)
//	public String logout(HttpServletRequest request,
//			HttpServletResponse response, ModelMap model) {
//		
//		return "login";
//	}
	
	/**
	 * 如果登录不成功，shiro会请求转发到这个action，然后再跳到登录页面
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String submit(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws IOException {
		
		System.out.println("login.do-submit");
		
		Object error = request.getAttribute(DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
		if (error != null) {
			model.addAttribute("error", error);
			logger.debug("错误信息:{} "+error);
		}
		
		return "login";
	}
	
	/**
	 * 访问错误链接，跳转到error页面
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String error(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		return "error";
	}
	
	/**
	 * 手机登录
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/applogin")
	@ResponseBody
	public String appLogin(HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		String result="0";
		response.setContentType("text/html;charset=utf-8");
		//System.out.println("Origin:"+request.getHeader("Origin"));
		response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		response.setHeader("Access-Control-Allow-Methods", "POST");
		response.setHeader("Access-Control-Max-Age", "0");
		response.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,userId,token");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("XDomainRequestAllowed","1");		
		boolean flag = false;
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			flag = true;
			if(null != userName){
				FlxoaSystemUser u = new FlxoaSystemUser();
				u.setUserName(userName);
				FlxoaSystemUser flxoaSystemUser = flxoaSystemUserService.findUserDetialByUserName(u);
				if(null != flxoaSystemUser){
					HttpSession session = request.getSession();
					//手机端 session登录后永不超时
					session.setMaxInactiveInterval(-1);
					session.setAttribute("userId", String.valueOf(flxoaSystemUser.getId()));
					session.setAttribute("userName", flxoaSystemUser.getUserName());
					session.setAttribute("realName", flxoaSystemUser.getRealName());
					session.setAttribute("departmentName", String.valueOf(flxoaSystemUser.getDepartmentName()));
					session.setAttribute("departmentId", String.valueOf(flxoaSystemUser.getDepartmentId()));
					session.setAttribute("companyId", String.valueOf(flxoaSystemUser.getCompanyId()));
					session.setAttribute("cardId", String.valueOf(flxoaSystemUser.getCardId()));
					session.setAttribute("flxoaSystemUser",flxoaSystemUser);
				}
				result = "用户名或密码错误";
			}
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		if (flag) {
			result = "成功";
		}
		return result;
	}
}
