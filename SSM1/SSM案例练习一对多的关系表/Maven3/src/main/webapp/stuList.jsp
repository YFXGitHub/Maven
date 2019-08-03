<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>StuLIst</title>
</head>
<body>
	<h1>StuLIst</h1>
	<c:if test="${empty stuList}">
		<h1>暂时没有数据</h1>
	</c:if>
	<c:if test="${not empty stuList}">
		<table>
			<tr>
				<td>sid</td>
				<td>sname</td>
				<td>sex</td>
				<td>age</td>
				<td>cj</td>
				<td>cname</td>
				<td>操作</td>
			</tr>
		<c:forEach items="${stuList}" var="stu">
			<tr>
				<td>${stu.sid}</td>
				<td>${stu.sname}</td>
				<td>${stu.sex}</td>
				<td>${stu.age}</td>
				<td>${stu.cj}</td>
				<td>${stu.cls.cname}</td>
				<td><a href="updatePre?sid=${stu.sid}">修改</a> | <a href="delete?sid=${stu.sid}">删除</a></td>
			</tr>
		</c:forEach>	
		</table>
	</c:if>
	
		<h4><a href="/index.jsp"> ---〉</a></h4>
	
</body>
</html>