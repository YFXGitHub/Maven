<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h3>success.jsp</h3> Hello, <shiro:principal/>, how are you today?    | <a href="logout">Logout</a>
		
		<hr/><br/>
		<shiro:hasRole name="admin">
			<a href="">用户管理</a> |
		</shiro:hasRole>
		
		 <shiro:hasAnyRoles name="admin, productManager">  <!-- hasAnyRole标签 ：验证当前用户是否属于以下任意一个角色。   -->
		 	 <a href="product">商品管理</a> | <a href="orders">订单管理</a>
		 </shiro:hasAnyRoles>
		
</body>
</html>