package com.flx.flxoa.info.system.security;

import java.io.PrintWriter;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.servlet.ShiroFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.flx.flxoa.common.exception.CaptchaErrorException;
import com.flx.flxoa.common.util.CaptchaValidateUtil;
import com.flx.flxoa.common.util.Singleton;
import com.flx.flxoa.info.system.comon.Permission;
import com.flx.flxoa.info.system.entity.FlxoaSystemSso;
import com.flx.flxoa.info.system.entity.FlxoaSystemUser;
import com.flx.flxoa.info.system.manager.FlxoaSystemDepartmentService;
import com.flx.flxoa.info.system.manager.FlxoaSystemSsoService;
import com.flx.flxoa.info.system.manager.FlxoaSystemUserService;

/**
 * formAuthenticationFilter为基于Form表单的身份验证过滤器；
 * 此处的FlxoaAuthenticationFilter为自行定义的Filter bean
 * 
 * @author Yu Haidong
 *
 */
public class FlxoaAuthenticationFilter extends FormAuthenticationFilter {

	/**
	 * 返回URL
	 */
	public static final String RETURN_URL = "returnUrl";
	
	@Override
	protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
		AuthenticationToken token = createToken(request, response);
		
		if (token == null) {
			String msg = "create AuthenticationToken error";
			throw new IllegalStateException(msg);
		}
		
		HttpServletRequest httpServletRequest = WebUtils.toHttp(request);
		HttpServletResponse httpServletResponse = WebUtils.toHttp(response);
		boolean adminLogin=false;
		
		//判断是否需要有验证码进行验证
		if (captchaEnable) {
			if (!CaptchaValidateUtil.validateResponse(httpServletRequest, httpServletResponse)) {
				return onLoginFailure(token,adminLogin,new CaptchaErrorException(), request, response);
			}
		}
		//判断是否开启从白名单中读取允许登录后台的IP的功能
		try {
			Subject subject = getSubject(request, response);
			subject.login(token);
			return onLoginSuccess(token,adminLogin,subject, request, response);
		} catch (AuthenticationException e) {
			//e.printStackTrace();
			return onLoginFailure(token,adminLogin, e, request, response);
		}
	}
	
	/**
	 * 登录失败
	 */
	private boolean onLoginFailure(AuthenticationToken token,boolean adminLogin,AuthenticationException e, ServletRequest request,
			ServletResponse response) {
		
		return super.onLoginFailure(token, e, request, response);
	}
	
	/**
	 * 登录成功
	 */
	private boolean onLoginSuccess(AuthenticationToken token,boolean adminLogin,Subject subject,
			ServletRequest request, ServletResponse response)
			throws Exception {
		return super.onLoginSuccess(token, subject, request, response);
	}
	
	@Override
	protected boolean isLoginRequest(ServletRequest req, ServletResponse resp) {
		// 其中的loginUrl和adminUrl都是在shiro-context.xml中所配置的值
		return pathsMatch(getLoginUrl(), req)
				|| pathsMatch(getAdminLogin(), req);
	}

	public boolean onPreHandle(ServletRequest request,
			ServletResponse response, Object mappedValue) throws Exception {
		boolean isAllowed = isAccessAllowed(request, response, mappedValue);
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		//手机跨域保持session 一致
//		res.setHeader("Access-Control-Allow-Origin", "*");
//		res.setHeader("Access-Control-Allow-Methods", "POST");
//		res.setHeader("Access-Control-Allow-Headers", "x-requested-with");
//		res.setHeader("Access-Control-Allow-Credentials","true"); //是否支持cookie跨域
		
		res.setContentType("text/html;charset=utf-8");
		//System.out.println("Origin:"+req.getHeader("Origin"));
		res.setHeader("Access-Control-Allow-Origin", req.getHeader("Origin"));
		res.setHeader("Access-Control-Allow-Methods", "POST");
		res.setHeader("Access-Control-Max-Age", "0");
		res.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,userId,token");
		res.setHeader("Access-Control-Allow-Credentials", "true");
		res.setHeader("XDomainRequestAllowed","1");			
		//如果是登录请求 ，则需要重新登录
		if(pathsMatch(getAdminLogin(), req)){
			isAllowed = false;
		}
		 isAllowed =true;
		// 登录跳转，即如果已经登录成功了，则不用再次登录
		if (isAllowed) {
			if(isLoginRequest(req,res)){
				try {
					//noPermission 用户角色权限  0有权限   1无权限
					String noPermission = "";
					if(null != req.getSession().getAttribute("noPermission")){
						noPermission = String.valueOf(req.getSession().getAttribute("noPermission"));
					}
					//无权限访问后，   再进行登录 设置 有权限
					if(req.getRequestURI().equals("/flxoa/login.do")){
						req.getSession().setAttribute("noPermission", "0");
					}
					if("".equals(noPermission)||"0".equals(noPermission)){
						issueSuccessRedirect(request, response);
					}else{
						// 清除SavedRequest
						WebUtils.getAndClearSavedRequest(request);						
						//无权限跳转到 无权限页面
						res.sendRedirect(getLoginUrl());
						//跳转后 清空无权限状态,设置有权限
						//req.getSession().setAttribute("noPermission", "0");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return false;
			}
		}
		//判断此请求(ajax请求和跳转页面请求)是否有权限
        String path = req.getServletPath()+req.getPathInfo();
        int userId = 0;
        String userName = "";
        String realName = "";
        if(null != req.getSession().getAttribute("userId")){
        	userId = Integer.parseInt(String.valueOf(req.getSession().getAttribute("userId")));
        }
        if(null != req.getSession().getAttribute("userName")){
        	userName = String.valueOf(req.getSession().getAttribute("userName"));
        }
        if(null != req.getSession().getAttribute("realName")){
        	realName = String.valueOf(req.getSession().getAttribute("realName"));
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        String formatStr =formatter.format(new Date());  
		if(isAllowed)
		{
			if(null != req.getSession().getAttribute("userId")){
		        //超级管理员 不需要验证权限
		        if(1 != userId)
		        {
			        Map<String,List<Integer>> map = Permission.getRolePermission(userId, path);
			        if(map.size() <= 0)
			        {
			        	//无此url 请求权限
			        	isAllowed = false;
			        	//noPermission  0有权限   1无权限
			        	req.getSession().setAttribute("noPermission", "1");
			        	System.out.println("当前请求路径："+path+",无权限访问,当前请求用户id："+userId+"、用户名："+userName+"、用户姓名："+realName+",当前请求时间："+formatStr+"");
			        }else{
			        	System.out.println("当前请求路径："+path+",有权限访问,当前请求用户id："+userId+"、用户名："+userName+"、用户姓名："+realName+",当前请求时间："+formatStr+"");
			        }	        	
		        }else{
		        	System.out.println("当前请求路径："+path+",有权限访问,当前请求用户id："+userId+"、用户名："+userName+"、用户姓名："+realName+",当前请求时间："+formatStr+"");
		        }
			}else{
				//session 超时
				isAllowed = false;
				//noPermission  0有权限   1无权限
				req.getSession().setAttribute("noPermission", "1");
				System.out.println("当前请求路径："+path+",session超时,请重新登录,当前请求用户id："+userId+"、用户名："+userName+"、用户姓名："+realName+",当前请求时间："+formatStr+"");
			}
		}else{
			System.out.println("当前请求路径："+path+",未经授权访问,请登录或联系管理员,当前请求用户id："+userId+"、用户名："+userName+"、用户姓名："+realName+",当前请求时间："+formatStr+"");			
		}
		return isAllowed || onAccessDenied(request, response, mappedValue);
	}
	
    @Override  
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {  
        //判断是否是登录请求
    	if(isLoginRequest(request,response)){
    		//判断是否是post请求
        	if(isLoginSubmission(request, response)){
        		//登录信息token保存
        		return executeLogin(request, response);
        	}else{
        		return true;
        	}
        }else{
        	HttpServletRequest httpRequest = WebUtils.toHttp(request);       	
        	//是ajax请求  返回 输出错误代码401
        	if(!StringUtils.isBlank(httpRequest.getHeader("x-requested-with")) && httpRequest.getHeader("x-requested-with").equals("XMLHttpRequest")){
        		HttpServletResponse httpResponse = WebUtils.toHttp(response);
        		httpResponse.sendError(401);
        	}else{
        		//非ajax请求  返回 无权限页面
        		saveRequestAndRedirectToLogin(request, response);
        	}
        }
    	return false; 
    } 

	@Override
	protected void issueSuccessRedirect(ServletRequest request,
			ServletResponse response) throws Exception {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String successUrl = req.getParameter(RETURN_URL);
		if (StringUtils.isBlank(successUrl)) {
//			//无权限时候 返回 错误页面
//			if(req.getRequestURI().equals(getLoginUrl()))
//			{
//				successUrl = getLoginUrl();
//				// 清除SavedRequest
//				WebUtils.getAndClearSavedRequest(request);
//				WebUtils.issueRedirect(request, response, successUrl, null,
//						true);
//				//noPermission  0有权限   1无权限
//				req.getSession().setAttribute("noPermission", "0");	
//				return;			
//			}
//			else 
			if (req.getRequestURI().startsWith(
					req.getContextPath() + getAdminPrefix())) {
				// 后台直接返回首页
				successUrl = getAdminIndex();
				String userName = req.getParameter("username");
				if(null != userName){
					FlxoaSystemUser u = new FlxoaSystemUser();
					u.setUserName(userName);
					//保存登录成功用户信息
					FlxoaSystemUser flxoaSystemUser= flxoaSystemUserService.findUserDetialByUserName(u);
					if(null != flxoaSystemUser){
						req.getSession().setAttribute("userId", String.valueOf(flxoaSystemUser.getId()));
						req.getSession().setAttribute("userName", flxoaSystemUser.getUserName());
						req.getSession().setAttribute("realName", flxoaSystemUser.getRealName());
						req.getSession().setAttribute("departmentName", String.valueOf(flxoaSystemUser.getDepartmentName()));
						req.getSession().setAttribute("departmentId", String.valueOf(flxoaSystemUser.getDepartmentId()));
						req.getSession().setAttribute("companyId", String.valueOf(flxoaSystemUser.getCompanyId()));
						req.getSession().setAttribute("cardId", String.valueOf(flxoaSystemUser.getCardId()));
						req.getSession().setAttribute("flxoaSystemUser",flxoaSystemUser);
						//客户端id
						String client_id = String.valueOf(req.getSession().getAttribute("client_id"));
						//客户端密钥
//						String client_secret = String.valueOf(req.getSession().getAttribute("client_secret"));
						//返回url
						String redirect_uri = String.valueOf(req.getSession().getAttribute("redirect_uri"));
						redirect_uri = URLDecoder.decode(redirect_uri);
						//请求类型
						String response_type = String.valueOf(req.getSession().getAttribute("response_type"));
						//状态
						String state =  String.valueOf(req.getSession().getAttribute("state"));
						if(null != client_id
//								&&null != client_secret
								&&null != redirect_uri
								&&null != response_type
								&&null != state){
							if("code".equals(response_type)){
								//得到Service Bean
								WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();		
								FlxoaSystemSsoService flxoaSystemSsoService = (FlxoaSystemSsoService)webApplicationContext.getBean("FlxoaSystemSsoService");
								FlxoaSystemSso flxoaSystemSso = new FlxoaSystemSso();
								flxoaSystemSso.setClientId(client_id);
//								flxoaSystemSso.setClientSecret(client_secret);
								flxoaSystemSso.setRedirectUri(redirect_uri);
								FlxoaSystemSso queryFlxoaSystemSso = flxoaSystemSsoService.queryByPro(flxoaSystemSso);
								//验证通过
								if(null != queryFlxoaSystemSso){
									queryFlxoaSystemSso.setState(state);					
									//保存code
									String code = UUID.randomUUID().toString();
									//保存token
									String accessToken = UUID.randomUUID().toString();
									Map<String,String> mapCode = Singleton.getInstance().getCodeToken();
									Map<String,String> mapAccessToken = new HashMap<String, String>();
									mapAccessToken.put("access_token", accessToken);
									mapAccessToken.put("refresh_token", "");
									mapAccessToken.put("expires_in", "");
									mapAccessToken.put("token_type", "");
									JSONObject jsonBeanCode = JSONObject.fromObject(mapAccessToken);
									mapCode.put(code, jsonBeanCode.toString());
									//req.getSession().setAttribute("codeToken",mapCode);
									JSONObject jsonBeanToken = JSONObject.fromObject(flxoaSystemUser);
									//req.getSession().setAttribute(accessToken, jsonBean.toString());
									Map<String,String> mapAccessTokenUser = Singleton.getInstance().getAccessTokenUser();
									mapAccessTokenUser.put(accessToken, jsonBeanToken.toString());
									String returnUrl = queryFlxoaSystemSso.getRedirectUri()+"?code="+code+"" +
											"&state="+state;
//									System.out.println(returnUrl);
									// 清除SavedRequest
									WebUtils.getAndClearSavedRequest(request);
									WebUtils.issueRedirect(request, response, returnUrl, null,
											true);
									return;									
								}
							}
						}

					}					
				}
				//noPermission  0有权限   1无权限
				req.getSession().setAttribute("noPermission", "0");				
				// 清除SavedRequest
				WebUtils.getAndClearSavedRequest(request);
				WebUtils.issueRedirect(request, response, successUrl, null,
						true);
				return;
			} else {
				successUrl = getSuccessUrl();
			}
		}
		WebUtils.redirectToSavedRequest(req, res, successUrl);
	}
	
	protected FlxoaSystemUserService flxoaSystemUserService;

	public FlxoaSystemUserService getFlxoaSystemUserService() {
		return flxoaSystemUserService;
	}
	@Autowired
	public void setFlxoaSystemUserService(
			FlxoaSystemUserService flxoaSystemUserService) {
		this.flxoaSystemUserService = flxoaSystemUserService;
	}
	private String adminPrefix;
	private String adminIndex;
	private String adminLogin;
	private boolean captchaEnable;//是否开启验证码支持
	private boolean loginWhiteListEnable;//是否开启登录白名单支持
	
	public String getAdminPrefix() {
		return adminPrefix;
	}

	public void setAdminPrefix(String adminPrefix) {
		this.adminPrefix = adminPrefix;
	}

	public String getAdminIndex() {
		return adminIndex;
	}

	public void setAdminIndex(String adminIndex) {
		this.adminIndex = adminIndex;
	}

	public String getAdminLogin() {
		return adminLogin;
	}

	public void setAdminLogin(String adminLogin) {
		this.adminLogin = adminLogin;
	}
	
	public boolean isCaptchaEnable() {
		return captchaEnable;
	}

	public void setCaptchaEnable(boolean captchaEnable) {
		this.captchaEnable = captchaEnable;
	}
	
	public boolean isLoginWhiteListEnable() {
		return loginWhiteListEnable;
	}

	public void setLoginWhiteListEnable(boolean loginWhiteListEnable) {
		this.loginWhiteListEnable = loginWhiteListEnable;
	}
}
