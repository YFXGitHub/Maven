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
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class LoginRealm extends AuthorizingRealm {

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("授权。。。。。");
		String name = (String) principals.getPrimaryPrincipal();
		Set<String> roleNames = new HashSet<String>();
		//判断若是aaa 用户登录赋予admin角色   / bbb 则是普通用户不赋予角色
		if(name.equals("aaa")) {
			roleNames.add("admin");
		}
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roleNames);
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenToken) throws AuthenticationException {
		System.out.println("验证。。。。。。。");
		UsernamePasswordToken token = (UsernamePasswordToken)authenToken;
		//这里给出两个账号  aaa  / bbb  密码公用123
		if(token.getUsername().equals("aaa")) {
			return new SimpleAuthenticationInfo(token.getUsername(), token.getPassword(), getName());
		}else if(token.getUsername().equals("bbb")) {
			return new SimpleAuthenticationInfo(token.getUsername(), token.getPassword(), getName());
		}else {
			throw new AuthenticationException();
		}
	}

}
