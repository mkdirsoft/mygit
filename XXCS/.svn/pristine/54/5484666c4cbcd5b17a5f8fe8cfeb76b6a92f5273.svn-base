package com.flx.flxoa.info.system.security;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.flx.flxoa.common.util.MD5Encode;
import com.flx.flxoa.info.system.entity.FlxoaSystemUser;
import com.flx.flxoa.info.system.manager.FlxoaSystemUserService;

public class FlxoaAuthorizingRealm extends AuthorizingRealm {

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authToken) throws AuthenticationException {

		UsernamePasswordToken token = (UsernamePasswordToken) authToken;
		String tokenPassword = String.valueOf(token.getPassword());
		String result = "";
		//将获取的密码进行md5加密  前台已做md5加密
//		String mPassword = MD5Encode.MD5(tokenPassword);
//		token.setPassword(mPassword.toCharArray());
		//获取用户名
		FlxoaSystemUser flxoaSystemUser= flxoaSystemUserService.findByUserName(token.getUsername());
		if(flxoaSystemUser != null && !"".equals(flxoaSystemUser)){
			//登录密码和数据库密码比较
			String password = flxoaSystemUser.getPassword();
			if(password.equals(tokenPassword) ){
				return new SimpleAuthenticationInfo(token.getUsername(),
						token.getPassword(), getName());
			}else{
				result = "密码不正确";
			}
		}else{
			result = "该用户名不存在";
		}
		
		return null;
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
	
}
