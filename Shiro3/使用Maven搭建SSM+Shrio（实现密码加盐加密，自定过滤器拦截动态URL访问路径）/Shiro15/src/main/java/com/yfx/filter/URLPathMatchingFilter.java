package com.yfx.filter;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.apache.shiro.web.util.WebUtils;

//自定义动态 URL 用来代替@RequiresRoles/@RequiresPermissions 访问角色、权限的过滤器
// 实现此过滤器要先继承  org.apache.shiro.web.filter.PathMatchingFilter  在实现  onPreHandle 方法！
public class URLPathMatchingFilter extends PathMatchingFilter {

	@Override
	protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {
		
		//获取用户访问URL 路径
		String URL = getPathWithinApplication(request);
		System.out.println("当前用户的访问路径："+URL);

		Subject subject = SecurityUtils.getSubject();
		//subject 中使用session 的方法：   subject.getSession().setAttribute("ex", ex);
		//判断当前用户是否登录, 若没有则去登录
		if(!subject.isAuthenticated()) {
			WebUtils.issueRedirect(request, response, "/login.jsp");
			return false;
		}
		//模拟从数据库中获取的用户权限信息
		Set<String> permissions = new HashSet<String>();
		permissions.add("/add");			//添加权限
		permissions.add("/update");		//修改权限
		permissions.add("/delete");		//删除权限
		permissions.add("/findAll");		//查询权限       index.jsp 中有/findAll请求
		
		//遍历permissions 中的权限信息是否与 用户的请求路径是否一致，
		boolean isFlag = false;
		for (String string : permissions) {
			if(URL.equals(string)) {
				isFlag = true;
				break;
			}
		}
		//判断isFlag 
		if(isFlag) {
			return true;
		}else {
			WebUtils.issueRedirect(request, response, "error.jsp");
			return false;
		}
		
	}
}
