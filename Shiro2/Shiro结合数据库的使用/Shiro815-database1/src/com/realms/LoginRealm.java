package com.realms;

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

import database.dao.DAO;

//自定义验证、授权
public class LoginRealm extends AuthorizingRealm{

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("授权。。。");
		String username = (String)principals.getPrimaryPrincipal();
		System.out.println("为"+username+"用户授权。。。。");
		//得到用户在数据库中的角色
		Set<String> roleNames = new DAO().listRoles(username);
		//得到用户在数据库中的权限
		Set<String> permissions = new DAO().listPermissions(username);
		System.out.println(roleNames+"---"+permissions);
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.setRoles(roleNames);
		info.setStringPermissions(permissions);
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenToken) throws AuthenticationException {
		System.out.println("验证。。。。");
		UsernamePasswordToken token = (UsernamePasswordToken)authenToken;
		//判断帐号  、 密码
		String password = new String(token.getPassword());
		
		//查询数据库中的帐号密码！
		String pwdDAO = new DAO().getPassword(token.getUsername());
		if(pwdDAO == null || !pwdDAO.equals(password)) {
			//用户名不存在 或 密码有误！
			throw new AuthenticationException();
		}
		
		return new SimpleAuthenticationInfo(token.getUsername(), password, getName());
	}

}
