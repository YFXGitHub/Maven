<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<shiro:hasRole name="admin" />
		<h1>success</h1>
		<table border="1" style="width: 400px;">
			<c:forEach items="${list}" var="list">
				<tr>
					<td>${list.id}</td>
					<td>${list.name}</td>
					<td>${list.sex}</td>
					<td>${list.age}</td>
					<td>${list.address}</td>
					<shiro:hasRole name="admin">
						<td><a href="udpate?id=${list.id}">修改</a></td>
					</shiro:hasRole>
				</tr>
			</c:forEach>
		</table>
		
		  <a href="logout">退出</a>
</body>
</html>