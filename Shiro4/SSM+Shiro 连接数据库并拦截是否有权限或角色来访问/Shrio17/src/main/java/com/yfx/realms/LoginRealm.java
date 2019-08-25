package com.yfx.realms;

import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.yfx.service.UserService;

//自定义 具有验证、授权的类
public class LoginRealm extends AuthorizingRealm {
	
	@Autowired
	private UserService userService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// 授权
		String name = (String)principals.getPrimaryPrincipal();
		System.out.println("为："+name+"授权。。。。");
		//获取用户所拥有的角色和权限
		Set<String> findByUserRoles = userService.findByUserRoles(name);
		System.out.println(findByUserRoles);
		Set<String> findByUserPermissions = userService.findByUserPermissions(name);
		System.out.println(findByUserPermissions);
		
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(findByUserRoles);
		info.setStringPermissions(findByUserPermissions);
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authentoken) throws AuthenticationException {
		//验证
		System.out.println("验证。。。。");
		//获取用户的帐号、密码
		UsernamePasswordToken token = (UsernamePasswordToken)authentoken;
		String pwd = new String(token.getPassword());
		//获取数据库中的密码、加盐码
		String pwdDB = userService.getPassword(token.getUsername());
		//System.out.println("数据库中的密码："+pwdDB);
		//System.out.println("数据库中加盐码："+userService.getSalt(token.getUsername()));
		//将用户输入的密码，加盐并判断是否与数据库中的密码一致？
		String pwdEncoding = new SimpleHash("md5", pwd, userService.getSalt(token.getUsername()), 2).toString();
		if(pwdDB == null || !pwdDB.equals(pwdEncoding) ) {
			 throw new AuthenticationException();
		}
		//System.out.println("sdfa---"+pwd+token.getUsername());
		
		return new SimpleAuthenticationInfo(token.getUsername(), pwd, getName());
	}

}
