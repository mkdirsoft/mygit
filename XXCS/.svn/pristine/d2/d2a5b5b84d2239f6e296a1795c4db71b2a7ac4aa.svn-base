package com.flx.flxoa.common.util.weixin;
import net.sf.json.JSONObject;
/**
 * 类名称：WeiXinUtil.java
 * 类描述：
 * 创建时间：2018-4-9, 上午11:12:32
 * 
 * @version 1.0 
 * @since JDK版本 1.7
 * @author 张海英
 */
public class WeiXinUtil {
	public final static String access_token_url="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	public final static String oauth2_1_url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
	public final static String oauth2_2_url = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
	public final static String get_userInfo_url="https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";
	public final static String get_hangye_url = "https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=ACCESS_TOKEN";
	//appid和appsecret(换成真实的appid和appsecret) 
	public final static String appid="wx05948991416758bf";
	public final static String appSecret="61aa207025c96b87c6db2725450f6230";
	
	
	
	public static AccessToken getAccessToken(String appid, String appSecret) {
		//替换真实appid和appsecret
		String requestUrl = access_token_url.replace("APPID", appid).replace("APPSECRET", appSecret);
		AccessToken accesstoken=new AccessToken();
		//得到json对象
		JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);
		
		//将得到的json对象的属性值，存到accesstoken中
		accesstoken.setToken(jsonObject.getString("access_token"));
		accesstoken.setExpiresIn(jsonObject.getInt("expires_in"));
		return accesstoken;
	} 
	
	/**
	 * 网页授权认证	
	 * @param appId
	 * @param appSecret
	 * @param code
	 * @return
	 */
	public static WeixinOauth2Token getOauth2AccessToken(String appId,String appSecret,String code) {
		
		String  requestUrl=oauth2_1_url.replace("APPID", appId).replace("SECRET", appSecret).replace("CODE", code);
		//发送请求获取网页授权凭证
		JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, EnumMethod.GET.name(), null);
		WeixinOauth2Token   wxo=new WeixinOauth2Token();
		wxo.setAccessToken(jsonObject.getString("access_token"));
		wxo.setExpiresIn(jsonObject.getInt("expires_in"));
		wxo.setRefreshToken(jsonObject.getString("refresh_token"));
		wxo.setOpenId(jsonObject.getString("openid"));
		wxo.setScope(jsonObject.getString("scope"));
		wxo.setUnionID(jsonObject.getString("unionid"));
		
		return wxo;
		
	}
	/**
	 * 获取用户的基本信息
	 * @param accessToken
	 * @param openId
	 * @return
	 */
	public static SNSUserInfo getSNSUserInfo(String accessToken,String openId) {
		String requestUrl=oauth2_2_url.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openId);
		SNSUserInfo snsuserinfo=new SNSUserInfo();
		//通过网页授权获取用户信息
		JSONObject jsonObject=CommonUtil.httpsRequest(requestUrl, EnumMethod.GET.name(), null);
		
		snsuserinfo.setOpenId(jsonObject.getString("openid"));
		snsuserinfo.setNickname(jsonObject.getString("nickname"));
		snsuserinfo.setSex(jsonObject.getInt("sex"));
		snsuserinfo.setCountry(jsonObject.getString("country"));
		snsuserinfo.setProvince(jsonObject.getString("province"));
		snsuserinfo.setCity(jsonObject.getString("city"));
		snsuserinfo.setHeadImgUrl(jsonObject.getString("headimgurl"));
		//snsuserinfo.setPrivilegeList(JSONArray._fromArray(jsonObject.getString("privilege"),String.class));
		return snsuserinfo; 
	}
	
	/**
	 * 创建网页授权的url
	 * @param redirectUri
	 * @return
	 */
	public static String createUrl(String redirectUri) {
		
		String url =get_userInfo_url.replace("APPID", appid).replace("REDIRECT_URI", CommonUtil.urlEncodeUTF8(redirectUri)).replace("SCOPE", "snsapi_userinfo");
		System.out.println(url);
		return url;
	}	
	
	/**
	 * 长连接转化成短链接，提高扫码速度跟成功率
	 * @param args
	 */
	
	public static String  shortURL(String longURL, String wxAppId, String secret) {
        String requestUrl = "https://api.weixin.qq.com/cgi-bin/shorturl?access_token=ACCESS_TOKEN";
        try {
        	//将更新后的access_token,替换上去
			requestUrl = requestUrl.replace("ACCESS_TOKEN",getAccessToken(wxAppId, secret).getToken());
		} catch (Exception e) {
			e.printStackTrace();
		}
        String jsonMsg = "{\"action\":\"long2short\",\"long_url\":\"%s\"}";
        //格式化url
        String.format(jsonMsg, longURL);
        JSONObject jsonobject = CommonUtil.httpsRequest(requestUrl, "POST",String.format(jsonMsg, longURL));
        //转换成短连接成功
        return jsonobject.getString("short_url");
    }

	
	public static void main(String[] args) {
		AccessToken a =getAccessToken(appid, appSecret);
		//String s= shortURL(sss, appid, appSecret);
		//System.out.println(s);
		System.out.println(a.getToken());
		System.out.println(a.getExpiresIn());
	}
}
