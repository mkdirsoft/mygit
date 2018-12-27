package com.flx.flxoa.common.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.springframework.ui.ModelMap;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

public class PhoneCode {
 
	private static String code ;
	
//	public static void main(String[] args) {
//		String phone = "18091570065"; //此处可输入你的手机号码进行测试
//		getPhonemsg(phone);
//	}
	
	/**
	 * 阿里云短信服务配置
	 * @param mobile
	 * @return
	 */
	public static String getPhonemsg(String mobile,HttpServletRequest request) {
		JSONObject json = null;
		Map map = new HashMap<>();
		String validated = "";
		/**
		 * 进行正则关系校验
		 */
		System.out.println(mobile);
		if (mobile == null || mobile == "") {
			map.put("code", 500);
			map.put("Msg","手机号为空");
			return validated;
		}
		/**
		 * 短信验证
		 */
		// 设置超时时间-可自行调整
		System.setProperty(StaticPeram.defaultConnectTimeout, StaticPeram.Timeout);
		System.setProperty(StaticPeram.defaultReadTimeout, StaticPeram.Timeout);
		// 初始化ascClient需要的几个参数
		final String product = StaticPeram.product;// 短信API产品名称（短信产品名固定，无需修改）
		final String domain = StaticPeram.domain;// 短信API产品域名（接口地址固定，无需修改）
		// 替换成你的AK
		final String accessKeyId = StaticPeram.accessKeyId;// 你的accessKeyId,参考本文档步骤2
		final String accessKeySecret = StaticPeram.accessKeySecret;// 你的accessKeySecret，参考本文档步骤2
		// 初始化ascClient,暂时不支持多region
		IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou",
				accessKeyId, accessKeySecret);
		try {
			DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product,
					domain);
		} catch (ClientException e1) {
			e1.printStackTrace();
		}
		
		//获取验证码
		code = vcode();
		//model.addAttribute("code", code);   
		IAcsClient acsClient = new DefaultAcsClient(profile);
		// 组装请求对象
		SendSmsRequest sendSmsRequest = new SendSmsRequest();
		// 使用post提交
		sendSmsRequest.setMethod(MethodType.POST);
		// 必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式
		sendSmsRequest.setPhoneNumbers(mobile);
		// 必填:短信签名-可在短信控制台中找到
		sendSmsRequest.setSignName(StaticPeram.SignName);
		// 必填:短信模板-可在短信控制台中找到
		sendSmsRequest.setTemplateCode(StaticPeram.TemplateCode);
		// 可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
		// 友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
		sendSmsRequest.setTemplateParam("{\"customer\":\""+code+"\"}");
		// 可选-上行短信扩展码(无特殊需求用户请忽略此字段)
		// request.setSmsUpExtendCode("90997");
		// 可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
		sendSmsRequest.setOutId("yourOutId");
		// 请求失败这里会抛ClientException异常
		SendSmsResponse sendSmsResponse;
		try {
			sendSmsResponse = acsClient.getAcsResponse(sendSmsRequest);
			if (sendSmsResponse.getCode() != null&& sendSmsResponse.getCode().equals("OK")) {
				// 请求成功
				map.put("code", 200);
				map.put("data", code);
				map.put("Msg","成功");
				//将验证码存到session中,同时存入创建时间
				//以json存放，这里使用的是阿里的fastjson
				HttpSession session = request.getSession();
				json = new JSONObject();
				json.put("code", code);
				json.put("createTime", System.currentTimeMillis());
				// 将认证码存入SESSION
				request.getSession().setAttribute("verifyCode", json);
			} else {
			    //如果验证码出错，会输出错误码告诉你具体原因
				System.out.println(sendSmsResponse.getCode());
				validated  = sendSmsResponse.getCode();
				System.out.println("获取验证码失败...");
			}
		} catch (ServerException e) {
			e.printStackTrace();
			map.put("code", 500);
			map.put("Msg","由于系统维护，暂时无法注册！！！");
		} catch (ClientException e) {
			e.printStackTrace();
			map.put("code", 500);
			map.put("Msg","由于系统维护，暂时无法注册！！！");
		}
		JSONArray jsonss = new JSONArray();
		jsonss.put(map);
		return jsonss.toString();
	}
	
	/**
	 * 生成6位随机数验证码
	 * @return
	 */
	public static String vcode(){
		String vcode = "";
        for (int i = 0; i < 6; i++) {
            vcode = vcode + (int)(Math.random() * 9);
        }
        return vcode;
	}	
}