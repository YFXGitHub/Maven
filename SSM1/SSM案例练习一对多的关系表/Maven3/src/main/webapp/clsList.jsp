<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cls LIst</title>
</head>
<body>
		<h1>ClsList</h1>
		<c:if test="${empty clsList}">
			暂时没有数据
		</c:if>
		<c:if test="${not empty clsList}">
			<table>
				<tr>
					<td>cid</td>
					<td>cname</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${clsList}" var="cls">
					<tr>
						<td>${cls.cid}</td>
						<td>${cls.cname}</td>
						<td><a href="updatePre?cid=${cls.cid}">修改</a> | <a href="delete?cid=${cls.cid}">删除</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
			<h4><a href="/index.jsp"> ---〉</a></h4>

</body>
</html>