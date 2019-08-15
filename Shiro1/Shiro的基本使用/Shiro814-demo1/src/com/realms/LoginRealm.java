package com.realms;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class LoginRealm extends AuthorizingRealm {

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("授权。。。。。");
		String name = (String)principals.getPrimaryPrincipal();
		System.out.println("为："+name+"  授权。。。");
		Set<String> roleNames = new HashSet<String>();
		Set<String> permissions = new HashSet<String>();
		if(name.equals("aaa")) {
			roleNames.add("root");		//为当前用户赋予角色权限
			permissions.add("select"); 	//为当前用户赋予权限
		}
		if(name.equals("bbb")) {
			roleNames.add("admin");
			
		}
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roleNames);
		info.setStringPermissions(permissions);
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authentoken) throws AuthenticationException {
		System.out.println("验证。。。。");
		UsernamePasswordToken token = (UsernamePasswordToken)authentoken;
		//定义俩个用户 aaa/bbb
		if(token.getUsername().equals("aaa")) {
			return new SimpleAuthenticationInfo("aaa", "123", getName());
		}else if(token.getUsername().equals("bbb")){
			return new SimpleAuthenticationInfo("bbb", "123", getName());
		}else {
			throw new AuthenticationException();
		}
		
	}


}
/* 授权：
	 	Set<String> roleNames = new HashSet<String>();  
        Set<String> permissions = new HashSet<String>();  
        roleNames.add("administrator");//添加角色
        permissions.add("newPage.jhtml");  //添加权限
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roleNames);  
        info.setStringPermissions(permissions);  
        return info;  
--------------------- 

 
 * */
