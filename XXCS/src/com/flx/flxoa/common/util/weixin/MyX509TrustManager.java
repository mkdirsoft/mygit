package com.flx.flxoa.common.util.weixin;

import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.X509TrustManager;
/**
 * 类名称：MyX509TrustManager.java
 * 类描述：证书信任管理器（用于https请求） 
 * 创建时间：2018-4-9, 上午10:51:00
 * 
 * @version 1.0 
 * @since JDK版本 1.7
 * @author 张海英
 */
public class MyX509TrustManager implements X509TrustManager {
	 public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {}  
	  
	 public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {}  
	  
	 public X509Certificate[] getAcceptedIssuers() {  
	        return null;  
	 }  
}
