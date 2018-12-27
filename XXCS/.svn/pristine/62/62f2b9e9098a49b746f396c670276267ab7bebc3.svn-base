package com.flx.flxoa.info.system.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.flx.flxoa.common.util.DateUtils;
import com.flx.flxoa.common.util.MD5Encode;
import com.flx.flxoa.common.util.weixin.SNSUserInfo;
import com.flx.flxoa.common.util.weixin.WeiXinUtil;
import com.flx.flxoa.common.util.weixin.WeixinOauth2Token;
import com.flx.flxoa.info.system.entity.FlxoaSystemUser;
import com.flx.flxoa.info.system.manager.FlxoaSystemUserService;
/**
 * 类名称：WeixinLoginController.java
 * 类描述：微信扫码登录
 * 创建时间：2018-4-9, 下午3:09:56
 * 
 * @version 1.0 
 * @since JDK版本 1.7
 * @author 张海英
 */
@Controller
public class WeixinLoginController {
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
	 * 去微信扫码登录页
	 * @return
	 */
	@RequestMapping(value = "weixinshow",produces="text/html;charset=UTF-8")
	public String weixinShow(HttpServletRequest request,HttpServletResponse response, ModelMap model){
		System.out.println("微信扫码登录。。。");
		return "weixin";
	}
	
	/**
	 * 微信获取用户信息，扫码成功后自动执行
	 * @param request
	 * @param response
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "weixingetuserinfo",produces="text/html;charset=UTF-8")
	public String weixinGetUserInfo(HttpServletRequest request,HttpServletResponse response,ModelMap map){
		response.setCharacterEncoding("utf-8");
		String code = request.getParameter("code");
		// 通过code获取access_token
		WeixinOauth2Token oauth2Token = WeiXinUtil.getOauth2AccessToken(WeiXinUtil.appid, WeiXinUtil.appSecret, code);
		System.out.println(oauth2Token.toString());
		//获取网页授权接口调用凭证
		String accessToken = oauth2Token.getAccessToken();
		//获取用户标识
		String openId = oauth2Token.getOpenId();
		//通过网页授权获取用户信息
		SNSUserInfo snsUserInfo = WeiXinUtil.getSNSUserInfo(accessToken, openId);
		if(snsUserInfo != null){
			//微信用户id
			String id = oauth2Token.getUnionID();
			//微信用户Name
			String name = snsUserInfo.getNickname();
			//微信用户头像
			String logo = snsUserInfo.getHeadImgUrl();
			//查询数据库中是否有该用户(根据微信id查询)
			FlxoaSystemUser flxoaSystemUser = new FlxoaSystemUser();
			flxoaSystemUser.setWeixinId(id);
			flxoaSystemUser = flxoaSystemUserService.getUserByWeixinId(flxoaSystemUser);
			if(flxoaSystemUser != null){
				//获取用户名
				String username = flxoaSystemUser.getUserName();
				//获取用户密码
				String password = flxoaSystemUser.getPassword();
				request.getSession().setAttribute("weixinLoginUserName", username);
				request.getSession().setAttribute("weixinLoginPassword", password);				
				return "login";
			}else{
				//如果用户不存在，跳转到微信绑定页
				HttpSession session = request.getSession();
				session.setAttribute("weixinId", id);
				return "weixinbind";
			}
		}else{
			//跳转扫码错误页
			return "weixinerror";
		}
	}
	
	/**
	 * 微信绑定
	 * @param request
	 * @param response
	 * @param map
	 * @return
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@RequestMapping(value = "weixinbind",produces="text/html;charset=UTF-8")
	public String weixinBind(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws ServletException, IOException{
		//获取微信id
		String weixinId = (String) request.getSession().getAttribute("weixinId");
		//获取用户名
		String username = request.getParameter("username");
		//获取用户名密码
		String password = request.getParameter("password");
		//将获取到的用户密码加密
		String mPassword = MD5Encode.MD5(password);
		//查询数据库中是否有该用户
		FlxoaSystemUser flxoaSystemUser = flxoaSystemUserService.findByUserName(username);
		if(flxoaSystemUser != null && !"".equals(flxoaSystemUser)){
			//登录密码和数据库密码比较
			//获取数据库中的用户密码
			String pw = flxoaSystemUser.getPassword();
			//当登录用户名和密码与数据库中的用户名和密码相等时进行微信绑定
			if(pw.equals(mPassword)){
				flxoaSystemUser.setWeixinId(weixinId);
				request.getSession().setAttribute("userId", String.valueOf(flxoaSystemUser.getId()));
				request.getSession().setAttribute("departmentId", String.valueOf(flxoaSystemUser.getDepartmentId()));
				boolean b = flxoaSystemUserService.update(flxoaSystemUser);
				request.getSession().setAttribute("weixinLoginUserName", flxoaSystemUser.getUserName());
				request.getSession().setAttribute("weixinLoginPassword", flxoaSystemUser.getPassword());
				return "login";
			}
		}
		return null;
	}
	
	@RequestMapping(value = "getuserinfo")
    @ResponseBody
    public String getUserInfo(HttpServletRequest request,HttpServletResponse response){
        Map<String,Object> map = new HashMap<String,Object>();
        if(null != request.getSession().getAttribute("weixinLoginUserName")){
        	map.put("userName", String.valueOf(request.getSession().getAttribute("weixinLoginUserName")));
        	map.put("password", String.valueOf(request.getSession().getAttribute("weixinLoginPassword")));
        }
		// newjson對象
		JSONArray json = new JSONArray();        
        JSONArray jsonMap = json.put(map);
        return json.toString();
    }
}
