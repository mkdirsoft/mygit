package com.flx.flxoa.common.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 类名称：Singleton.java
 * 类描述：单例类
 * 创建时间：2018-5-15, 上午10:48:07
 * 
 * @version 1.0 
 * @since JDK版本 1.7
 * @author 刘凯 
 */
public class Singleton {
    private volatile static Singleton instance;
    private Singleton(){
    }
    public static Singleton getInstance(){
        if(instance==null){
            synchronized (Singleton.class){
                if(instance==null){
                    instance=new Singleton();
                }
            }
        }
        return instance;
    }
    
    //保存单点登录 code 和token
    private Map<String,String> codeToken = new HashMap<String, String>();
    //保存单点登录 token 和 对应的用户信息
    private Map<String,String> accessTokenUser = new HashMap<String, String>();
	public Map<String, String> getCodeToken() {
		return codeToken;
	}
	public void setCodeToken(Map<String, String> codeToken) {
		this.codeToken = codeToken;
	}
	public Map<String, String> getAccessTokenUser() {
		return accessTokenUser;
	}
	public void setAccessTokenUser(Map<String, String> accessTokenUser) {
		this.accessTokenUser = accessTokenUser;
	}
    
}
