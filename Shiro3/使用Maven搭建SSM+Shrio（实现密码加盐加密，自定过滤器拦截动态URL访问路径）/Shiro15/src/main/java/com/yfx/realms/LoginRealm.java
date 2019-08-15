package com.yfx.realms;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

//验证 、授权 类
public class LoginRealm extends AuthorizingRealm {

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		 String name =(String) principals.getPrimaryPrincipal();
		System.out.println("为"+name+"用户进行授权。。。");
		
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authentToken) throws AuthenticationException {
		System.out.println("验证。。。");
		UsernamePasswordToken token = (UsernamePasswordToken)authentToken;
		String password = new String(token.getPassword());
		//解析加密有加盐的 密码
//		String passwordEncoded = new SimpleHash("md5",password,"ER9QMxFZGxW7tpnZ0iC7rA==",2).toString();
//		System.out.println("加盐加密后的密码："+passwordEncoded);
		
		 //解析加密有加盐的 密码
		String passwordEncoded = new SimpleHash("md5",password,"ER9QMxFZGxW7tpnZ0iC7rA==",2).toString();
		System.out.println("加盐加密后的密码："+passwordEncoded);
		
		//数据库中的密码		b8c89eab172c885ef9d501652ec81d22
		String pwdDatabase = "b8c89eab172c885ef9d501652ec81d22";
		if(token.getUsername().equals("admin") && passwordEncoded.equals(pwdDatabase)) {
			return new SimpleAuthenticationInfo(token.getUsername(), password, getName());	
		}else {
			 throw new AuthenticationException();
		}
	}
	
	/*
	 //解析加密有加盐的 密码
		String passwordEncoded = new SimpleHash("md5",password,"ER9QMxFZGxW7tpnZ0iC7rA==",2).toString();
		System.out.println("加盐加密后的密码："+passwordEncoded);
		
		//数据库中的密码		b8c89eab172c885ef9d501652ec81d22
		String pwdDatabase = "b8c89eab172c885ef9d501652ec81d22";
		if(token.getUsername().equals("admin") && passwordEncoded.equals(pwdDatabase)) {
			return new SimpleAuthenticationInfo(token.getUsername(), password, getName());	
		}else {
			 throw new AuthenticationException();
		}
		
		
		String salt = "ER9QMxFZGxW7tpnZ0iC7rA==";
		String pwdDatabase = "b8c89eab172c885ef9d501652ec81d22";
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(token, pwdDatabase, ByteSource.Util.bytes(salt), getName());
		return info;
	 * */

}
