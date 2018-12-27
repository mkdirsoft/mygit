package com.flx.flxoa.info.system.interceptor;

import java.io.Serializable;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.EmptyInterceptor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.type.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.flx.flxoa.common.util.CommonUtils;
import com.flx.flxoa.common.util.DateUtils;

public class DataEntityInterceptor extends EmptyInterceptor {

	private static final long serialVersionUID = -8597658125309889388L;
	private static final Logger log = LoggerFactory
			.getLogger(DataEntityInterceptor.class);

	// private Logger logger = Logger.getLogger(LogEntityInterceptor.class);
	@Override
	public void onDelete(Object entity, Serializable id, Object[] state,
			String[] propertyNames, Type[] types) {
		// logger.info("删除数据");
		System.out.println("删除数据");

	}

	@Override
	public boolean onFlushDirty(Object entity, Serializable id,
			Object[] currentState, Object[] preState, String[] propertyNames,
			Type[] types) {
		// logger.info("修改数据");

		System.out.println("修改数据");
		
		assert (propertyNames.length == currentState.length);
		//从request 获取用户信息
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		String userId = (String)request.getSession().getAttribute("userId");
		String departmentId = (String)request.getSession().getAttribute("departmentId");
		int nowTime = DateUtils.getSecondTimestamp(new Date());
		for (int i = 0; i < propertyNames.length; i++) {
			if ("UpdateTime".equals(propertyNames[i])) {
//				if("".equals(CommonUtils.returnStr(currentState[i]))){				
					currentState[i] = nowTime;
//				}
			}else if("UpdateUserId".equals(propertyNames[i])){
//				if("".equals(CommonUtils.returnStr(currentState[i]))){				
					currentState[i] = Integer.parseInt(userId);
//				}				
			}else if("UpdateDepartmentId".equals(propertyNames[i])){
//				if("".equals(CommonUtils.returnStr(currentState[i]))){				
					currentState[i] = Integer.parseInt(departmentId);
//				}	
			}
		}

		return true;
	}

	@Override
	public boolean onSave(Object entity, Serializable id, Object[] State,
			String[] propertyNames, Type[] types) {
		// logger.info("保存数据");
		System.out.println("保存数据");
		
		assert (propertyNames.length == State.length);
		//从request 获取用户信息
		String userId = "";
		String departmentId = "";
		if(null !=RequestContextHolder.getRequestAttributes()){
			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
			userId = (String)request.getSession().getAttribute("userId");
			departmentId = (String)request.getSession().getAttribute("departmentId");				
		}
		int nowTime = DateUtils.getSecondTimestamp(new Date());
		for (int i = 0; i < propertyNames.length; i++) {
			if ("UpdateTime".equals(propertyNames[i])||"CreateTime".equals(propertyNames[i])) {
				if("".equals(CommonUtils.returnStr(State[i]))){
					State[i] = nowTime;
				}
			}else if("UpdateUserId".equals(propertyNames[i])||"CreateUserId".equals(propertyNames[i])){
				if("".equals(CommonUtils.returnStr(State[i]))){
					State[i] = Integer.parseInt(userId);
				}
			}else if("UpdateDepartmentId".equals(propertyNames[i])||"CreateDepartmentId".equals(propertyNames[i])){
				if("".equals(CommonUtils.returnStr(State[i]))){
					State[i] = Integer.parseInt(departmentId);
				}
			}else if("DeleteFlag".equals(propertyNames[i])){
				if("".equals(CommonUtils.returnStr(State[i]))){
					State[i] = "0";
				}			
			}
		}		
		// return false;
		return true;
	}
}
