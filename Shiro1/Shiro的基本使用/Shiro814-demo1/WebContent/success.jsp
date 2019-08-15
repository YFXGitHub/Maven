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
		/success.jsp
	
		<shiro:hasRole name="admin">
		<!-- 查看只有'admin'权限才显示  -->
			<a href="#">只有admin才可见！</a> 
		</shiro:hasRole>
		   <a href="root">添加</a><br/>
		   
		   
		   <a href="logout">退出</a>
</body>
</html>