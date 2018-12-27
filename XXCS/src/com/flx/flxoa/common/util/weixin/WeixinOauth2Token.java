package com.flx.flxoa.common.util.weixin;
/**
 * 类名称：WeixinOauth2Token.java
 * 类描述：网页授权信息
 * 创建时间：2018-4-9, 上午11:11:38
 * 
 * @version 1.0 
 * @since JDK版本 1.7
 * @author 张海英
 */
public class WeixinOauth2Token {
	//网页授权接口调用凭证
	private  String accessToken;
	
	//凭证有效时长
	private int expiresIn;
	
	//用于刷新凭证
	private String refreshToken;
	
	//用户标识
	private String openId;
	
	//用户授权作用域（当scope=snsapi_base时，不弹出授权页面,直接跳转 只能获取到openId,当scope=snsapi=userinfo时弹出授权页面,获取用户信息）
	private String scope;
	
	//同一用户使用微信登录你的不同应用和公众号的 唯一id
	private String unionID;

	public String getUnionID() {
		return unionID;
	}

	public void setUnionID(String unionID) {
		this.unionID = unionID;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public int getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}
}
