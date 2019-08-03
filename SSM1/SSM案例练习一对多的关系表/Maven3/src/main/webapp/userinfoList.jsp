<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UserinfoList</title>
</head>
<body>
		<h1>UserinfoList</h1>
		<c:if test="${empty userinfoList}">
			<h2>暂时没有数据！</h2>
		</c:if>
		<c:if test="${not empty userinfoList}">
			<table border="1" style="width: 500px;">
				<tr>
					<td>uid</td>
					<td>usercard</td>
					<td>userpwd</td>
					<td>userphone</td>
					<td>useraddress</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${userinfoList}" var="userinfo">
					<tr>
						<td>${userinfo.uid}</td>
						<td>${userinfo.usercard}</td>
						<td>${userinfo.userpwd}</td>
						<td>${userinfo.userphone}</td>
						<td>${userinfo.useraddress}</td>
						<td><a href="updatePre?uid=${userinfo.uid}">修改</a> | <a href="delete?uid=${userinfo.uid}">删除</a></td>
					</tr>
				</c:forEach>
			</table>
			<h4><a href="/index.jsp"> ---〉</a></h4>
		</c:if>
	
</body>
</html>