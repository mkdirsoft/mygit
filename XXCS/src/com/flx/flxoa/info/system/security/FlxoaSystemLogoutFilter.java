package com.flx.flxoa.info.system.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.shiro.session.SessionException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.springframework.stereotype.Service;

import com.flx.flxoa.common.util.Singleton;
import com.flx.flxoa.info.market.entity.HxUser;
import com.flx.flxoa.info.system.entity.FlxoaSystemUser;

/**
 * 类名称：SystemLogoutFilter.java
 * 类描述：
 * 创建时间：2018-4-3, 上午11:34:23
 * 
 * @version 1.0 
 * @since JDK版本 1.7
 * @author 刘凯 
 */
@Service
public class FlxoaSystemLogoutFilter extends LogoutFilter {
    
	@Override  
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {  
        //在这里执行退出系统前需要清空的数据  
        Subject subject=getSubject(request,response);  
        String redirectUrl=getRedirectUrl(request,response,subject);  
        ServletContext context= request.getServletContext();
        HttpServletRequest req = (HttpServletRequest) request;
		//退出时  移除该用户单点登录信息
//		if(null != req.getSession().getAttribute("userId")){
//			int userId = Integer.parseInt(String.valueOf(req.getSession().getAttribute("userId")));
//			//移除tokenUser
//			Map<String,String> mapAccessTokenUser = Singleton.getInstance().getAccessTokenUser();
//			List<String> tokenList = new ArrayList<String>();
//			for (Entry<String, String> entry : mapAccessTokenUser.entrySet()) {
//				JSONObject jsonBean = JSONObject.fromObject(entry.getValue());
//				HxUser user = (HxUser) JSONObject.toBean(jsonBean, HxUser.class);
//				if(user.getUserId() == userId){
//					tokenList.add(entry.getKey());
//					mapAccessTokenUser.remove(entry.getKey());
//				}
//			}
//			
//			//移除mapCode
//			Map<String,String> mapCode = Singleton.getInstance().getCodeToken();
//			for (Entry<String, String> entry : mapCode.entrySet()) {
//				for (int i = 0; i < tokenList.size(); i++) {
//					JSONObject jb = JSONObject.fromObject(entry.getValue());
//				    Map<String, String> map = (Map<String, String>)jb;
//					if(tokenList.get(i).equals(map.get("access_token"))){
//						mapAccessTokenUser.remove(entry.getKey());
//					}					
//				}
//
//			}			
//		}
		
        //清空登录用户session
		req.getSession().removeAttribute("userId");
		req.getSession().removeAttribute("userName");
		req.getSession().removeAttribute("user");

        try {  
            subject.logout();  
            context.removeAttribute("error");  
        }catch (SessionException e){  
            e.printStackTrace();  
        }  
        issueRedirect(request,response,redirectUrl);  
        return false;  
    }  
}  
