package com.flx.flxoa.common.util;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flx.flxoa.info.market.entity.HxFavorite;
import com.flx.flxoa.info.market.entity.HxNews;

import net.sf.json.JSONObject;



/**
 * 包装 Request 对象，过滤参数值中的XML字符
 */
@SuppressWarnings("unchecked")
public class AntiSqlInjectionfilter implements Filter {
	
	private Logger logger = LoggerFactory.getLogger(AntiSqlInjectionfilter.class);
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	throws IOException, ServletException {
	HttpServletRequest req = (HttpServletRequest) request;
	HttpServletResponse resp = (HttpServletResponse) response;
	resp.setHeader("X-xss-protection","1;mode=block" );

	//获得所有请求的参数名
	Enumeration params = req.getParameterNames();
	String sql = "";
	while (params.hasMoreElements()) {
	//得到参数名 
	String param = params.nextElement().toString();
	//得到参数对应值
	String[] value = req.getParameterValues(param);
	for(int i = 0;i < value.length;i++){
	sql = sql + value[i];
	}
	}
	if(sqlValidate(sql)){
		System.out.println("AntiSqlInjectionfilter.java,亲，请不要传入非法字符！");
		throw new RuntimeException();  
		//有异常参数
	}else{
		chain.doFilter(request, response); //正常走
	}
		
	}
	@Override
	public void destroy() {


	}

	protected static boolean sqlValidate(String str){
		str = str.toLowerCase();//统一转为小写  
			//String badStr = "'|and|exec|insert|select|delete|update|count|*|/|chr|mid|master|truncate|char|declare|;|or|";//过滤掉的sql关键字，可以手动添加  
		String badStr = "'|and|exec|insert|select|delete|update|count|chr|mid|master|truncate|char|declare|or|";//过滤掉的sql关键字，可以手动添加  
			String[] badStrs = badStr.split("\\|");
			for (int i = 0; i < badStrs.length; i++) {
				if (str.indexOf(badStrs[i]) >= 0) {
				return true;
				}
			}
			return false;
		}
	
	
	/**
	 * 访问错误链接，跳转到error页面
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	public String error(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		return "error";
	}

}
